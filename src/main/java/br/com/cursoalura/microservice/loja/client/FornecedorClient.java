package br.com.cursoalura.microservice.loja.client;

import br.com.cursoalura.microservice.loja.model.dto.InfoFornecedorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("fornecedor")
public interface FornecedorClient {

    @RequestMapping(value = "/info/{estado}")
    InfoFornecedorDTO getInforPorEstado(@PathVariable String estado);
}
