package com.springboot.springboot.configuration.security;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import com.springboot.springboot.configuration.AppUserDetailService;
import com.springboot.springboot.configuration.AppUserDetails;

import java.util.ArrayList;
import java.util.Arrays;




@Component
public class JwtAuthenticationFilter  extends OncePerRequestFilter{

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    AppUserDetailService appUserDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (!StringUtils.hasLength(header) || !header.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }
        

        final String token = header.split(" ")[1].trim();
        if(!jwtTokenUtil.validate(token)){
            filterChain.doFilter(request, response);
            return;
        }

        AppUserDetails appUserDetails = (AppUserDetails) appUserDetailService.loadUserByUsername(jwtTokenUtil.getUserName(token));

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(appUserDetails, null, Optional.ofNullable(appUserDetails).map(AppUserDetails::getAuthorities).orElse(Arrays.asList()));

        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        filterChain.doFilter(request, response);
    }
    
}
