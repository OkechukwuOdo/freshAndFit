package com.tripleOtech.freshAndFit.repository;

import com.tripleOtech.freshAndFit.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Long> {
}
