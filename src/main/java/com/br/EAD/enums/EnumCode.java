package com.br.EAD.enums;

public enum EnumCode {
    USR000("Email already registered in system"),
    USR001("User not found"),
    CRS000("Course already registered in system"),
    CRS001("Course not found"),
    CLR000("Classroom already registered in system"),
    CLR001("Classroom not found");

    private String message;

    EnumCode(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
