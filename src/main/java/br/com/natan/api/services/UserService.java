package br.com.natan.api.services;

import br.com.natan.api.domain.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    List<User> findAll();

}
