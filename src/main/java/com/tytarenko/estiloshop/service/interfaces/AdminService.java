package com.tytarenko.estiloshop.service.interfaces;

import com.tytarenko.estiloshop.entity.Admin;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface AdminService extends UserDetailsService {

    void addAdmin(Admin admin);
    void updateAdmin(Admin admin);
    Admin getAdminByLogin(String login);

}
