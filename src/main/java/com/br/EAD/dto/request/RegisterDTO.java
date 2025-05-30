package com.br.EAD.dto.request;

import com.br.EAD.enums.Profile;

public record RegisterDTO(String name,
                          String email,
                          String password,
                          Profile profile){
}
