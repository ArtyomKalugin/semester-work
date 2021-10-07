package com.kalugin.net.service;

import com.kalugin.net.dto.UserDTO;
import com.kalugin.net.model.User;

import java.util.List;

public interface UserService {
    List<UserDTO> getAll();
    UserDTO get(int id);
    void save(User user);
}
