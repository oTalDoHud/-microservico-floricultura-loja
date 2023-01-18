package br.com.cursoalura.microservice.loja.client;

import br.com.cursoalura.microservice.loja.model.dto.InfoPedidoDTO;
import br.com.cursoalura.microservice.loja.model.dto.InfoFornecedorDTO;
import br.com.cursoalura.microservice.loja.model.dto.ItemDaCompraDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("fornecedor")
public interface FornecedorClient {

    @RequestMapping(value = "/info/{estado}")
    InfoFornecedorDTO getInforPorEstado(@PathVariable String estado);

    @RequestMapping(value = "/pedidos", method = RequestMethod.POST)
    InfoPedidoDTO realizaPedido(List<ItemDaCompraDTO> itens);
}
