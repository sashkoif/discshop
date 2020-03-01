package com.test.discshop.repository;

import java.util.Optional;

import com.test.discshop.domain.Disk;

import org.springframework.data.repository.CrudRepository;

public interface DiskRepository  extends CrudRepository<Disk, Long> {
    Optional<Disk> findById(Long id);
}