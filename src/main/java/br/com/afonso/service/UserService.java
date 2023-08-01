package br.com.afonso.service;

import br.com.afonso.model.User;
import br.com.afonso.repository.UserRepository;
import br.com.afonso.util.BusinessException;
import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    public void create(User user) {
        if (this.findByUsername(user.getUsername()) != null || this.findByDocument(user.getDocument()) != null) {
            throw new BusinessException("Usuário já cadastrado");
        }

        user.setPassword(BcryptUtil.bcryptHash(user.getPassword()));
        user.setRole(User.validateUsername(user.getUsername()));
        this.userRepository.persist(user);
    }

    public List<User> findAllUsers() {
        return this.userRepository.listAll();
    }

    private User findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    private User findByDocument(String document) {
        return this.userRepository.findByDocument(document);
    }

}
