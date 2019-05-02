package com.foodies.foodies.Controllers;

import static org.mockito.Mockito.*;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.mockito.Spy;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Assert;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(MockitoJUnitRunner.class)
public class UsersControllerTest{
//    @InjectMocks
//    private UsersController usersController=new UsersController();
//    @Mock
//    private Model model;
//
//    @Mock
//    private UsersService usersService;
//
//    @Test
//    public void creatUser_shouldReturnUser(){
//        Users user= mock(Users.class);
//        when(usersService.createUser(user)).thenReturn(user);
//        Users newUser = usersService.createUser(user);
//        String returnValue = usersController.createUser(user,model);
//        verify(model, times(1)).addAttribute("user", newUser );
//        Assert.assertEquals("user", returnValue);
//    }
}
