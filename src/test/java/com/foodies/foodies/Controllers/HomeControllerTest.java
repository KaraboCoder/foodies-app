//package com.foodies.foodies.Controllers;
//
////Mockito
//import static org.mockito.Mockito.*;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.mockito.Mock;
//import org.mockito.InjectMocks;
//import org.mockito.Spy;
//
////JUnit
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.Before;
//import org.junit.Assert;
//
////Other
//import com.foodies.foodies.Controllers.HomeController;
//import org.springframework.ui.Model;
//import com.foodies.foodies.Services.UsersService;
//import com.foodies.foodies.Repositories.UsersRepository;
//import com.foodies.foodies.Models.Users;
//import org.springframework.beans.factory.annotation.Autowired;
//
//@RunWith(MockitoJUnitRunner.class)
//public class HomeControllerTest {
//
//    @InjectMocks
//    private HomeController homeController = new HomeController();
//
//    @Mock
//    private Model model;
//
//    @Test
//    public void homePageView_shouldReturnIndex(){
//        String returnValue = homeController.HomePageView(model);
//        verify(model, times(1)).addAttribute("message", "Thymeleaf is f**n awsome!");
//        verify(model, times(1)).addAttribute("umessage", "<b>Thymeleaf is here!</b>");
//        Assert.assertEquals("index", returnValue);
//    }
//}
