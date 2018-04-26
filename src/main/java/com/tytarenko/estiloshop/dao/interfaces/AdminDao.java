package com.tytarenko.estiloshop.dao.interfaces;

import com.tytarenko.estiloshop.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDao extends JpaRepository<Admin, Long> {

    Admin findAdminByEmail(String email);
    Admin findAdminByAdminId(long id);

}
