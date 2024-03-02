package com.example.loginjwt.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
    private int employeeid;
    private String employeename;
    private String email;
    private String password;


    public EmployeeDto() {
    }


    public EmployeeDto(int employeeid, String employeename, String email, String password) {
        this.employeeid = employeeid;
        this.employeename = employeename;
        this.email = email;
        this.password = password;
    }

}