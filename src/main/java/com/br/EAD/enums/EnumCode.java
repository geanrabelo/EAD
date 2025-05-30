package com.br.EAD.enums;

public enum EnumCode {
    USR000("Email already registered in system");

    private String message;

    EnumCode(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
