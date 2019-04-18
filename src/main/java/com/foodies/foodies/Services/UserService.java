package com.foodies.foodies.Services;

import com.foodies.foodies.Models.User;
import com.foodies.foodies.Models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Service
public class UserService {
    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    Validator validator = validatorFactory.getValidator();

    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        if (!violations.isEmpty()){
            for (ConstraintViolation<User> violation : violations) {
                System.out.println(violation.getMessage());
            }
            return null;
        }else{
            return userRepository.save(user);
        }
    }
}
