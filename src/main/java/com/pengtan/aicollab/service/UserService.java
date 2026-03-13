package com.pengtan.aicollab.service;

import com.pengtan.aicollab.dto.AuthResponse;
import com.pengtan.aicollab.dto.LoginRequest;
import com.pengtan.aicollab.dto.RegisterRequest;
import com.pengtan.aicollab.entity.User;
import com.pengtan.aicollab.repository.UserRepository;
import com.pengtan.aicollab.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthResponse register(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("用户名已存在");
        }
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());

        userRepository.save(user);
        String token = jwtUtil.generateToken(user.getUsername());
        return new AuthResponse(token, user.getUsername());
    }

    public AuthResponse login(LoginRequest request) {
        Optional<User> userOpt = userRepository.findByUsername(request.getUsername());
        if (userOpt.isEmpty() || !encoder.matches(request.getPassword(), userOpt.get().getPassword())) {
            throw new RuntimeException("用户名或密码错误");
        }
        String token = jwtUtil.generateToken(userOpt.get().getUsername());
        return new AuthResponse(token, userOpt.get().getUsername());
    }
}