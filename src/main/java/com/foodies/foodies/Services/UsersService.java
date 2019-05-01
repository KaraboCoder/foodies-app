package com.foodies.foodies.Services;

import com.foodies.foodies.Models.Users;
import com.foodies.foodies.Models.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Service
public class UsersService {
    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    Validator validator = validatorFactory.getValidator();

    @Autowired
    UsersRepository usersRepository;

    public Users createUser(Users user) {
        Set<ConstraintViolation<Users>> violations = validator.validate(user);
        if (!violations.isEmpty()){
            for (ConstraintViolation<Users> violation : violations) {
                System.out.println(violation.getMessage());
            }
            return null;
        }else{
            return usersRepository.save(user);
        }
    }
}
