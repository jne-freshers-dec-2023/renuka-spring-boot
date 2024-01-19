package com.microservices.inventoryservices.service;

import com.microservices.inventoryservices.entity.Inventory;
import com.microservices.inventoryservices.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@RequiredArgsConstructor
@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode){
       return  inventoryRepository.findBySkuCode(skuCode).isPresent();
    }
}
