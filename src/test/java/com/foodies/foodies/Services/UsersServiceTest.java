package com.foodies.foodies.Services;

import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.foodies.foodies.Models.Users;
import javax.validation.ConstraintViolation;
import com.foodies.foodies.Repositories.UsersRepository;
import com.foodies.foodies.Services.UsersService;
import javax.validation.Validator;
import com.foodies.foodies.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

@RunWith(MockitoJUnitRunner.class)
public class UsersServiceTest {

    @Autowired
    UsersRepository usersRepository;

    @Test
    public void whenCreateUserHasViolations_thenUsersRepositorySaveMethodNotCalled() {
//        validatorFactory= Validation.buildDefaultValidatorFactory();
//        ValidatorFactory validatorFactory= mock(ValidatorFactory.class);
//        //TO:DO Needs to return something
//        Mockito.when(Validation.buildDefaultValidatorFactory()).thenReturn();
//        validator = validatorFactory.getValidator();
//        UsersService usersService= mock(UsersService.class);
//        Users anyUser = mock(Users.class);
//        Set<ConstraintViolation<Users>> violations= mock(Set.class);
//        Mockito.when(validator.validate(anyUser)).thenReturn(violations);
//        when(usersService.createUser(anyUser)).thenCallRealMethod();
//        usersService.createUser(anyUser);
//        verify(usersRepository,never()).save("never called");
    }

    @Test
    public void whenCreateUserHasViolations_thenReturnNull() {
//        UsersService usersService= mock(UsersService.class);
//        Users anyUser = mock(Users.class);
//        Set<ConstraintViolation<Users>> violations= mock(Set.class);
//        Mockito.when(validator.validate(anyUser)).thenReturn(violations);
//        when(usersService.createUser(anyUser)).thenCallRealMethod();
//        assertNull(usersService.createUser(anyUser));
    }

    @Test
    public void whenCreateUserNoViolations_thenSaveeUser() {
//        UsersService usersService= mock(UsersService.class);
//        Users anyUser = mock(Users.class);
//        Set<ConstraintViolation<Users>> violations= mock(Set.class);
//        Mockito.when(validator.validate(anyUser)).thenReturn(violations);
//        when(usersService.createUser(anyUser)).thenCallRealMethod();
//        usersService.createUser(anyUser);
//        verify(usersRepository, save(anyUser)).someMethod("called at least once");
    }
}