package com.br.EAD.service.impl;

import com.br.EAD.dto.request.AuthenticationDTO;
import com.br.EAD.dto.request.RegisterDTO;
import com.br.EAD.entity.User;
import com.br.EAD.enums.EnumCode;
import com.br.EAD.exceptions.ex.UserEmailAlreadyExists;
import com.br.EAD.exceptions.ex.UserNotFound;
import com.br.EAD.repository.UserRepository;
import com.br.EAD.security.service.TokenService;
import com.br.EAD.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private TokenService tokenService;
    private AuthenticationManager authenticationManager;

    public UserServiceImpl(UserRepository userRepository, TokenService tokenService,
                           AuthenticationManager authenticationManager){
        this.userRepository = userRepository;
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public String login(AuthenticationDTO authenticationDTO) {
        if(userRepository.findByEmail(authenticationDTO.email()).isEmpty()){
            throw new UserNotFound(EnumCode.USR001.getMessage());
        }
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDTO.email(), authenticationDTO.password()) ;
        var auth = authenticationManager.authenticate(usernamePassword);

        return tokenService.generateToken((User) usernamePassword.getPrincipal());
    }

    @Override
    public String register(RegisterDTO registerDTO) {
        if(userRepository.findByEmail(registerDTO.email()).isPresent()) throw new UserEmailAlreadyExists(EnumCode.USR000.getMessage());
        String passwordCrypt = new BCryptPasswordEncoder().encode(registerDTO.password());

        User user = User.builder()
                .name(registerDTO.name())
                .email(registerDTO.email())
                .password(passwordCrypt)
                .profile(registerDTO.profile())
                .createdAt(LocalDateTime.now()).build();

        userRepository.save(user);
        return "User registered successfully";
    }
}
