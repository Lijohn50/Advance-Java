package com.example.devtools_usage_tracker.service;

import com.example.devtools_usage_tracker.model.Admin;
import com.example.devtools_usage_tracker.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final AdminRepository adminRepository;

    public boolean checkAdmin(String username, String password) {

        Admin admin = adminRepository.getAdminByUsername(username);
        return admin != null && admin.getPassword().equals(password) && admin.getUsername().equals(username);
    }
}
