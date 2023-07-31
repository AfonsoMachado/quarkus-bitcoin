package br.com.afonso.service;

import br.com.afonso.model.User;
import br.com.afonso.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    public void create(User user) {
        userRepository.persist(user);
    }

}
