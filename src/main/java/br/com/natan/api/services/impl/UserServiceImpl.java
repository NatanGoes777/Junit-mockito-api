package br.com.natan.api.services.impl;

import br.com.natan.api.domain.User;
import br.com.natan.api.domain.dto.UserDTO;
import br.com.natan.api.repositories.UserRepository;
import br.com.natan.api.services.UserService;
import br.com.natan.api.services.exceptions.DataIntegrityViolationException;
import br.com.natan.api.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserRepository repository;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não Encontrado!"));
    }

    public List<User> findAll(){
        return repository.findAll();
    }

    @Override
    public User create(UserDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, User.class));
    }

    @Override
    public User update(UserDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, User.class));
    }

    private void findByEmail(UserDTO obj){
        Optional<User> user = repository.findByEmail(obj.getEmail());
        if(user.isPresent() && !user.get().getId().equals(obj.getId()))
            throw new DataIntegrityViolationException("Email já cadastrado no sistema!");
    }

}
