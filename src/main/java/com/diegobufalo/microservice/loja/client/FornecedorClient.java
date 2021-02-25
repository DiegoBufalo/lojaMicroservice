package com.diegobufalo.microservice.loja.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegobufalo.microservice.loja.dto.InfoFornecedorDTO;
import com.diegobufalo.microservice.loja.dto.InfoPedidoDTO;
import com.diegobufalo.microservice.loja.dto.ItemDaCompraDTO;
import com.diegobufalo.microservice.loja.dto.ItemDoPedidoDTO;
import com.diegobufalo.microservice.loja.dto.PedidoSimplesDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@FeignClient("fornecedor")
public interface FornecedorClient {

	@RequestMapping("/info/{estado}")
	Flux<InfoFornecedorDTO> getInfoPorEstado(@PathVariable String estado);

	@RequestMapping(method = RequestMethod.POST, value = "/pedido")
	InfoPedidoDTO realizaPedido(List<ItemDaCompraDTO> itens); 
	
	@RequestMapping(method = RequestMethod.POST, value = "/simples")
	Mono<PedidoSimplesDTO> realizaPedido(@RequestBody ItemDoPedidoDTO pedido);
}
