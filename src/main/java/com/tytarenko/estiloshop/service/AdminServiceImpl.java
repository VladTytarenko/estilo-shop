package com.tytarenko.estiloshop.service;

import com.tytarenko.estiloshop.dao.interfaces.AdminDao;
import com.tytarenko.estiloshop.entity.Admin;
import com.tytarenko.estiloshop.service.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public void addAdmin(Admin admin) {
        adminDao.saveAndFlush(admin);
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminDao.saveAndFlush(admin);
    }

    @Override
    public Admin getAdminByLogin(String login) {
        return adminDao.findAdminByEmail(login);
    }

    @Override
    public Admin getAdminById(long id) {
        return adminDao.findAdminByAdminId(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return adminDao.findAdminByEmail(email);
    }
}
