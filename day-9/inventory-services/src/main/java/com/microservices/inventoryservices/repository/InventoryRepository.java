package com.microservices.inventoryservices.repository;

import com.microservices.inventoryservices.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface InventoryRepository  extends JpaRepository<Inventory, Long> {
  public   Optional<Inventory> findBySkuCode(String skuCode);
}
