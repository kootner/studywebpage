package com.sparta.studywebpage.repository;

import com.sparta.studywebpage.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByEmail(String email);

    boolean existsByNickname(String nickname);
}
