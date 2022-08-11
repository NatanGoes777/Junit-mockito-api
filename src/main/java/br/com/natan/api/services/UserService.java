package br.com.natan.api.services;

import br.com.natan.api.domain.User;

public interface UserService {

    User findById(Integer id);

}
