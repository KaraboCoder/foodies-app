package com.foodies.foodies.Services.contracts;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}