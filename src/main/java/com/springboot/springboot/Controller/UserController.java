package com.springboot.springboot.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springboot.configuration.AppUserDetailService;
import com.springboot.springboot.configuration.security.JwtTokenUtil;
import com.springboot.springboot.domain.AppUser;
import com.springboot.springboot.domain.Role;
import com.springboot.springboot.model.CreateUserRequest;
import com.springboot.springboot.model.LoginUserRequest;
import com.springboot.springboot.repository.IRoleRepository;
import com.springboot.springboot.repository.IUserRepository;

@RestController
@RequestMapping("${url.base.path}/user")
public class UserController {
    
    @Autowired
    IUserRepository _UserRepository;

    @Autowired
    IRoleRepository _RoleRepository;

    @Autowired
    AppUserDetailService appUserDetailService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseEntity<?> post(@RequestBody @Valid CreateUserRequest request)
    {

        Role role = _RoleRepository.getReferenceById(request.RoleId.toString());

        if (role == null)
        {
            ResponseEntity.notFound().build();
        }

        Collection<Role> lRoles = new ArrayList<>();
        lRoles.add(role);

        AppUser userRequest = new AppUser(request.FirstName, request.LastName, request.UserName, passwordEncoder.encode(request.Password) , lRoles, "Admin");
        _UserRepository.save(userRequest);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> post(@RequestBody @Valid LoginUserRequest request)
    {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(request.UserName, request.Password);
        Authentication authentication = authenticationManager.authenticate(token);

        org.springframework.security.core.userdetails.User userDetails = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        AppUser user = appUserDetailService.getByUsername(userDetails.getUsername());

        String accessToken = jwtTokenUtil.generateAccessToken(user);
        String refreshToken = jwtTokenUtil.generateRefreshToken(user);

        Map<String, String> tokens = new HashMap<>();

        tokens.put("access_token", accessToken);
        tokens.put("refresh_token", refreshToken);

        return ResponseEntity.ok().body(tokens);
    }

    @RequestMapping(value = "/refresh", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> refresh(HttpServletRequest request) {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String refreshToken = authorizationHeader.substring("Bearer ".length());
            if (jwtTokenUtil.validate(refreshToken)) {
                org.springframework.security.core.userdetails.User userDetails = (org.springframework.security.core.userdetails.User) appUserDetailService.loadUserByUsername(jwtTokenUtil.getUserName(refreshToken));
                AppUser user = (AppUser) appUserDetailService.loadUserByUsername(userDetails.getUsername());

                String accessToken = jwtTokenUtil.generateAccessToken(user);

                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", accessToken);

                return ResponseEntity.ok().body(tokens);
            }
        }

        return ResponseEntity.badRequest().body(null);
    }


    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<AppUser> findAll()
    {
        List<AppUser> appUsers = _UserRepository.findAll();
        return appUsers;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public @ResponseBody AppUser requestMethodName(@PathVariable String id) 
    {
        AppUser appUser = _UserRepository.getReferenceById(id);
        return appUser;
    }
    
}
