package com.tripleOtech.freshAndFit.repository;

import com.tripleOtech.freshAndFit.entity.PackageStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackStatusRepository extends JpaRepository<PackageStatus,Long> {
}
