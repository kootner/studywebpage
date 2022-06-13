package com.sparta.studywebpage.repository;

import com.sparta.studywebpage.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByUsername(String username);

    boolean existsByPassword(String password);

    boolean existsByNickname(String nickname);

    Optional<User> findByUsername(String username);
}
