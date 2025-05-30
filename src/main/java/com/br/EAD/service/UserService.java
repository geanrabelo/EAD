package com.br.EAD.service;

import com.br.EAD.dto.request.AuthenticationDTO;
import com.br.EAD.dto.request.RegisterDTO;

public interface UserService {

    String login(AuthenticationDTO authenticationDTO);

    String register(RegisterDTO registerDTO);
}
