package ru.vlasovmb.minprofile.security.service;

public interface SecurityService {

    String findLoggedInUsername();

    String getCurrentUsername();

    void autoLogin(String username, String password);
}
