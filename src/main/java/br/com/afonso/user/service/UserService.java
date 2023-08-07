package br.com.afonso.user.service;

import br.com.afonso.user.dto.CreateUserDto;
import br.com.afonso.user.dto.UserDto;
import br.com.afonso.user.mappers.UserMapper;
import br.com.afonso.user.model.User;
import br.com.afonso.user.repository.UserRepository;
import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.ForbiddenException;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    @Inject
    UserMapper userMapper;

    public void create(CreateUserDto dto) {
        if (this.findByUsername(dto.getUsername()).isPresent() || this.findByDocument(dto.getDocument()).isPresent()) {
            throw new ForbiddenException("Usuário já cadastrado");
        }

        User user = this.userMapper.toEntity(dto);

        user.setPassword(BcryptUtil.bcryptHash(user.getPassword()));
        user.setRole(User.validateUsername(user.getUsername()));
        this.userRepository.persist(user);
    }

    public List<UserDto> findAllUsers() {
        final List<User> users = this.userRepository.listAll();
        return this.userMapper.entityListToDtoList(users);
    }

    public void delete(@NotNull Long id) {
        User user = this.userRepository.findById(id);
        this.userRepository.delete(user);
    }

    public User findById(@NotNull Long id) {
        return this.userRepository.findById(id);
    }

    private Optional<User> findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    private Optional<User> findByDocument(String document) {
        return this.userRepository.findByDocument(document);
    }

}
