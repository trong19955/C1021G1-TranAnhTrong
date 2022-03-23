package com.example.demo.configuration;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//Lớp CustomSuccessHandler được sử dụng để điều hướng trang web sau khi được đăng nhập thành công
@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String targetUrl = determineTargetUrl(authentication);

        if (response.isCommitted()) {
            System.out.println("Can't direct!");
            return;
        }

        redirectStrategy.sendRedirect(request,response,targetUrl);
    }

    protected String determineTargetUrl(Authentication authentication) {
        String url = "";

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        List<String> roles = new ArrayList<>();

        for (GrantedAuthority grantedAuthority: authorities) {
            roles.add(grantedAuthority.getAuthority());
        }

        if (isDba(roles))
            url = "/dba";
        else if (isAdmin(roles))
            url = "/admin";
        else if (isUser(roles))
            url = "/home";
        else
            url = "/accessDenied";

        return url;
    }

    private boolean isUser(List<String> roles) {
        return roles.contains("ROLE_USER");
    }

    private boolean isAdmin(List<String> roles) {
        return roles.contains("ROLE_ADMIN");
    }

    private boolean isDba(List<String> roles) {
        return roles.contains("ROLE_DBA");
    }

    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
}
