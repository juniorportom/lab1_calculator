package com.hades.labs.calculator.dataprovider.jpa.repositories;

import com.hades.labs.calculator.dataprovider.jpa.entities.InventoryDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryDao, Integer> {
}
