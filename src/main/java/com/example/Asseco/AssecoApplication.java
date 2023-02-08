package com.example.Asseco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.example.Asseco.model.Invoice;
import com.example.Asseco.service.ConverterStructureService;

@SpringBootApplication
public class AssecoApplication {
    
    @Autowired
    ConverterStructureService converterStructureService;

    public static void main(String[] args) {
	SpringApplication.run(AssecoApplication.class, args);

    }

    @EventListener(ApplicationReadyEvent.class)
    private void convert() {
	Invoice invoice = new Invoice();
	converterStructureService.getStructure(invoice);

    }

}
