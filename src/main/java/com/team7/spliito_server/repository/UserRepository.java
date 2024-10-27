package com.team7.spliito_server.repository;

import com.team7.spliito_server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
}