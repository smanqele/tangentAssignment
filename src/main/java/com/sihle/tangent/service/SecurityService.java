package com.sihle.tangent.service;


public interface SecurityService {
    String findLoggedInToken();

    void login(String username, String password);
}
