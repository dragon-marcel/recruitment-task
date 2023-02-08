package com.example.Asseco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Asseco.model.Invoice;
import com.example.Asseco.service.StructureUtils;

@SpringBootApplication
public class AssecoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssecoApplication.class, args);
		Invoice invoice = new Invoice();
		StructureUtils.getStructure(invoice);
		
	}

}
