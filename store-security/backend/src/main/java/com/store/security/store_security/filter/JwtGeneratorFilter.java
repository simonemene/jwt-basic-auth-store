package com.store.security.store_security.filter;

import com.store.security.store_security.constants.JwtConstants;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Jwts;



import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.stream.Collectors;

public class JwtGeneratorFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(null!= authentication)
        {
          Environment environment = getEnvironment();
          if(null != environment)
          {
            String secret = environment.getProperty(JwtConstants.JWT_SECRET_KEY_NAME,
                    JwtConstants.JWT_SECRET_DEFAULT);
              SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
              String jwt = Jwts.builder().issuer("store-security")
                      .subject("JWT Token")
                      .claim("username",authentication.getName())
                      .claim("authorities",authentication.getAuthorities().stream()
                              .map(GrantedAuthority::getAuthority)
                              .collect(Collectors.joining(",")))
                      .issuedAt(new Date())
                      .expiration(new Date((new Date().getTime() + 60000)))
                      .signWith(secretKey)
                      .compact();
              response.setHeader(JwtConstants.JWT_HEADER,jwt);
          }
        }
        filterChain.doFilter(request,response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return !request.getServletPath().equals("/api/auth/user");
    }
}
