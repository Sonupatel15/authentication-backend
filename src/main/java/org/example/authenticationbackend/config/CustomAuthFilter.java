package org.example.authenticationbackend.config;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthFilter implements Filter {

    private static final ThreadLocal<String> authHeaderThreadLocal = new ThreadLocal<>();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String authHeader = httpRequest.getHeader("PinggyAuthHeader");

        if (authHeader == null || authHeader.isEmpty()) {
            httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing or empty PinggyAuthHeader");
            return;
        }

        authHeaderThreadLocal.set(authHeader);
        try {
            chain.doFilter(request, response);
        } finally {
            authHeaderThreadLocal.remove();
        }
    }

    public static String getAuthHeader() {
        return authHeaderThreadLocal.get();
    }
}
