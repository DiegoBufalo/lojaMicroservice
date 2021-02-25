package com.diegobufalo.microservice.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegobufalo.microservice.loja.dto.CompraDTO;
import com.diegobufalo.microservice.loja.model.Compra;
import com.diegobufalo.microservice.loja.service.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraController {
	
	@Autowired
	private CompraService compraService;
	
	@PostMapping
	public Compra realizarCompra(@RequestBody CompraDTO compra) {
		compraService.realizaCompra(compra);
		return compraService.realizaCompra(compra);		
	}
}
