package br.com.cursoalura.microservice.loja.service;

import br.com.cursoalura.microservice.loja.model.dto.CompraDTO;
import br.com.cursoalura.microservice.loja.model.dto.InfoFornecedorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraService {

    @Autowired
    private RestTemplate restTemplate;

    public void realizarCompra(CompraDTO dto) {

        ResponseEntity<InfoFornecedorDTO> exchange =
                restTemplate.exchange("http://FORNECEDOR/info/" +
                        dto.getEndereco().getEstado(), HttpMethod.GET, null, InfoFornecedorDTO.class);

        System.out.println(exchange.getBody().getEndereco());
    }
}
