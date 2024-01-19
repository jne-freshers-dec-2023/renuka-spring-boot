package com.microservices.inventoryservices;

import com.microservices.inventoryservices.entity.Inventory;
import com.microservices.inventoryservices.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServicesApplication.class, args);
	}
	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
	return  args -> {
		Inventory inventory1= new Inventory();
		inventory1.setSkuCode("iphone_13");
		inventory1.setQuantity(100);

		Inventory inventory2=new Inventory();
		inventory2.setSkuCode("samsung");
		inventory2.setQuantity(0);

		Inventory inventory3= new Inventory();
		inventory3.setSkuCode("Redmi");
		inventory3.setQuantity(2);

		inventoryRepository.save(inventory1);
		inventoryRepository.save(inventory2);
		inventoryRepository.save(inventory3);
	};
	}

}
