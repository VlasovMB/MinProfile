package ru.vlasovmb.minprofile.security.service;

public interface SecurityService {
    boolean isAnonymousUser();

    String getCurrentUsername();

    void autoLogin(String username, String password);
}
