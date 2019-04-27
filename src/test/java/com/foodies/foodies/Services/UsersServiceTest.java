package com.foodies.foodies.Services;

import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.foodies.foodies.Models.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.mockito.runners.MockitoJUnitRunner;

import com.foodies.foodies.Models.Users;
import com.foodies.foodies.Models.UsersRepository;
import java.util.Set;

@RunWith(MockitoJUnitRunner.class)
public class UsersServiceTest {

    @Autowired
    UsersRepository usersRepository;

    @Test
    public void whenCreateUserHasViolations_thenUsersRepositorySaveMethodNotCalled() {
        UsersService usersService= mock(UsersService.class);
        Users anyuser = mock(Users.class);
        Set<ConstraintViolation<Users>> violations= mock(Set.class);
        Mockito.when(validator.validate(anyuser)).thenReturn(violations);
        when(usersService.createUser(anyUser)).thenCallRealMethod();
        usersService.createUser(anyUser);
        verify(usersRepository,never()).save("never called");
    }

    @Test
    public void whenCreateUserHasViolations_thenReturnNull() {
        UsersService usersService= mock(UsersService.class);
        Users anyuser = mock(Users.class);
        Set<ConstraintViolation<Users>> violations= mock(Set.class);
        Mockito.when(validator.validate(anyuser)).thenReturn(violations);
        when(usersService.createUser(anyUser)).thenCallRealMethod();
        assertNull(usersService.createUser(anyUser));
    }

    @Test
    public void whenCreateUserNoViolations_thenSaveeUser() {
        UsersService usersService= mock(UsersService.class);
        Users anyuser = mock(Users.class);
        Set<ConstraintViolation<Users>> violations= mock(Set.class);
        Mockito.when(validator.validate(anyuser)).thenReturn(violations);
        when(usersService.createUser(anyUser)).thenCallRealMethod();
        usersService.createUser(anyUser);
        verify(usersRepository, save(anyuser)).someMethod("called at least once");
    }
}