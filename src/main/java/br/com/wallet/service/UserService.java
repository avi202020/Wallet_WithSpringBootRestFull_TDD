package br.com.wallet.service;

import br.com.wallet.entity.User;
import java.util.Optional;


public interface UserService {
    
    User save(User u);
    
    Optional<User> findByEmail(String email);
    
}
