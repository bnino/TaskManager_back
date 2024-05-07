package com.TaskManager.services;

import com.TaskManager.controller.models.AuthRequest;
import com.TaskManager.controller.models.AuthResponse;
import com.TaskManager.controller.models.RegisterRequest;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(AuthRequest request);
}
