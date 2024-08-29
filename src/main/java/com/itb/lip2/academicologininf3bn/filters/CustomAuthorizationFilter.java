package com.itb.lip2.academicologininf3bn.filters;


import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

public class CustomAuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if(request.getServletPath().equals("/academico/api/v1/login")) {
            filterChain.doFilter(request, response);
        }else if (request.getServletPath().equals("/academico/api/v1/logout")) {
            String authorizationHeader = request.getHeader(AUTHORIZATION);
            if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                String stringTokens =  authorizationHeader.substring("Bearer ".length());
            }
        }else {
            String authorizationHeader = request.getHeader(AUTHORIZATION);
            if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
                try{

                    filterChain.doFilter(request, response);
                }catch (Exception exception) {
                    System.out.println("Error " + exception.getMessage());
                }
            }else {
                filterChain.doFilter(request, response);
            }
        }
    }
}
