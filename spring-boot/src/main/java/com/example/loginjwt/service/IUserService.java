package com.example.loginjwt.service;

import com.example.loginjwt.entity.Role;
import com.example.loginjwt.entity.User;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String userName, String roleName);
}
