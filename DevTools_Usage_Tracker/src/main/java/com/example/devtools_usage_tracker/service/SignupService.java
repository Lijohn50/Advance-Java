package com.example.devtools_usage_tracker.service;

import com.example.devtools_usage_tracker.model.Admin;
import com.example.devtools_usage_tracker.repository.AdminRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final PasswordEncoder passwordEncoder;

    private final AdminRepository adminRepository;
    public void saveAdmin(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        adminRepository.save(admin);
    }
}
