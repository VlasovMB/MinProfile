package ru.vlasovmb.minprofile.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.tinylog.Logger;


@Service
public class SecurityServiceImpl implements SecurityService{
    private final AuthenticationManager authenticationManager;
    private final UserDetailServiceImpl userDetailServiceImpl;

    @Autowired
    public SecurityServiceImpl(AuthenticationManager authenticationManager, UserDetailServiceImpl userDetailServiceImpl) {
        this.authenticationManager = authenticationManager;
        this.userDetailServiceImpl = userDetailServiceImpl;
    }


    @Override
    public Boolean isAnonymousUser() {
       return SecurityContextHolder.getContext().getAuthentication().getName().equalsIgnoreCase("anonymousUser");

    }

    @Override
    public String getCurrentUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @Override
    public void autoLogin(String username, String password) {
        UserDetails userDetails = userDetailServiceImpl.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails,
                        password,
                        userDetails.getAuthorities());
        authenticationManager.authenticate(authenticationToken);
        if (authenticationToken.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            Logger.info("Auto logged in: " + username);
        }

    }
}
