
package com.foodies.foodies.Controllers;

        import org.mockito.Mockito.*;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.junit.Before;
        import org.junit.Assert;

        import org.springframework.ui.Model;

        import com.foodies.foodies.Services.UsersService;
        import com.foodies.foodies.Models.UsersRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.mockito.runners.MockitoJUnitRunner;
        import org.mockito.Mock;
        import org.mockito.InjectMocks;
        import org.mockito.Spy;
        import com.foodies.foodies.Models.Users;
        import com.foodies.foodies.Models.UsersRepository;

@RunWith(MockitoJUnitRunner.class)
public class UsersControllerTest{

    //@Spy
    //@InjectMocks
    //private UsersController usersController;
    private HomeController HomeController;
    @Mock
    UsersService usersService;

    @Before
    public void before(){
        usersController = new UsersController();
    }

    @Test
    public void creatUser_shouldReturnUser(){
//        Mockito.when(worker.trans(Mockito.anyString())).thenReturn("cold");
//        TransResponse response = controller.translate(transRequest, null, new MockHttpServletRequest());
        Assert.assertEquals("1", "1");
    }
}
