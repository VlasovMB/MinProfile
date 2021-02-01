package ru.vlasovmb.minprofile.security.service;

public interface SecurityService {

    Boolean isAnonymousUser();

    String getCurrentUsername();

    void autoLogin(String username, String password);
}
