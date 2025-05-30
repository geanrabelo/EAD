package com.br.EAD.service;

import com.br.EAD.dto.request.user.AuthenticationDTO;
import com.br.EAD.dto.request.user.RegisterDTO;

public interface UserService {

    String login(AuthenticationDTO authenticationDTO);

    String register(RegisterDTO registerDTO);
}
