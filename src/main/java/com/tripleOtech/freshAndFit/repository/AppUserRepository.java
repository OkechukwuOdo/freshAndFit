package com.tripleOtech.freshAndFit.repository;

import com.tripleOtech.freshAndFit.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    Optional<AppUser> findByEmail(String username);
    Optional<AppUser> findAppUserById(Long username);
}
