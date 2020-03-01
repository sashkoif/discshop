package com.test.discshop.repository;

import java.util.List;
import java.util.Optional;

import com.test.discshop.domain.Disk;
import com.test.discshop.domain.TakenItem;
import com.test.discshop.domain.User;

import org.springframework.data.repository.CrudRepository;

public interface TakenItemRepository extends CrudRepository<TakenItem, Long> {
    Optional<TakenItem> findById(Long id);

    Optional<List<TakenItem>> findByUser(User user);

    Iterable<TakenItem> findAll();

	TakenItem findTakenItemByUserAndDisk(User user, Disk disk);
}