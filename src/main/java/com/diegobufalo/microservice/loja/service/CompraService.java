package com.diegobufalo.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegobufalo.microservice.loja.client.FornecedorClient;
import com.diegobufalo.microservice.loja.dto.CompraDTO;
import com.diegobufalo.microservice.loja.dto.CompraSimplesDTO;
import com.diegobufalo.microservice.loja.dto.InfoFornecedorDTO;
import com.diegobufalo.microservice.loja.dto.InfoPedidoDTO;
import com.diegobufalo.microservice.loja.model.Compra;

import reactor.core.publisher.Flux;

@Service
public class CompraService {

	@Autowired
	private FornecedorClient fornecedorClient;

	public Compra realizaCompra(CompraDTO compra) {
		
		Flux<InfoFornecedorDTO> infoPorEstado = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
		
							fornecedorClient.realizaPedido(compra.getId());
		System.out.println(infoPorEstado);
		
		Compra compraSalva = new Compra();
		compraSalva.setPedidoId(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraSalva.setEnderecoDestino(compra.getEndereco().toString());
		
		return compraSalva;
		
	}

}
