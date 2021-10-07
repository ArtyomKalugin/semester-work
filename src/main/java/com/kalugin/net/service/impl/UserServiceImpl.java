package com.kalugin.net.service.impl;

import com.kalugin.net.helper.PasswordHelper;
import com.kalugin.net.model.User;
import com.kalugin.net.dao.Dao;
import com.kalugin.net.dao.impl.UserDaoImpl;
import com.kalugin.net.dto.UserDTO;
import com.kalugin.net.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private final Dao<User> dao = new UserDaoImpl();

    @Override
    public UserDTO get(int id) {
        return null;
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> users = dao.getAll();
        return users.stream()
                .map(u -> new UserDTO(u.getFirstName(), u.getLastName(), u.getLogin()))
                .collect(Collectors.toList());
    }

    @Override
    public void save(User user) {
        dao.save(new User(
                user.getFirstName(),
                user.getLastName(),
                user.getLogin(),
                PasswordHelper.encrypt(user.getPassword())
        ));
    }
}
