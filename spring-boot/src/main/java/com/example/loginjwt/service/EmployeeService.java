package com.example.loginjwt.service;

import com.example.loginjwt.dto.EmployeeDto;
import com.example.loginjwt.dto.LoginDTO;
import com.example.loginjwt.dto.LoginMesage;

public interface EmployeeService {
    String addEmployee(EmployeeDto employeeDTO);
    LoginMesage loginEmployee(LoginDTO loginDTO);
}