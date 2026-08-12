package com.example.devtools_usage_tracker.repository;

import com.example.devtools_usage_tracker.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    public Admin getAdminByUsername(String username);
}
