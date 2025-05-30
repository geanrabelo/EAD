package com.br.EAD.controller;

import com.br.EAD.dto.request.user.AuthenticationDTO;
import com.br.EAD.dto.request.user.RegisterDTO;
import com.br.EAD.dto.response.MessageDTO;
import com.br.EAD.dto.response.TokenDTO;
import com.br.EAD.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/ead/auth")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(path = "/login")
    @Transactional
    public ResponseEntity<TokenDTO> login(@RequestBody @Validated AuthenticationDTO authenticationDTO){
        return ResponseEntity.ok(new TokenDTO(userService.login(authenticationDTO)));
    }

    @PostMapping(path = "/register")
    @Transactional
    public ResponseEntity<MessageDTO> register(@RequestBody @Validated RegisterDTO registerDTO){
        return ResponseEntity.ok(new MessageDTO(userService.register(registerDTO)));
    }
}
