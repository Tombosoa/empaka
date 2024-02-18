package com.javaadr.renderapi.Repository;

import com.javaadr.renderapi.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>{
    public User findByEmailAndPassword(String email, String password);
    public User findByEmail(String email);
    public User findUserById(UUID id);
}
