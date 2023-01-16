package br.com.cursoalura.microservice.loja.service;

import br.com.cursoalura.microservice.loja.client.FornecedorClient;
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
    private FornecedorClient fornecedorClient;

    public void realizarCompra(CompraDTO dto) {
        InfoFornecedorDTO infoFornecedorDTO = fornecedorClient.getInforPorEstado(dto.getEndereco().getEstado());

        System.out.println(infoFornecedorDTO.getEndereco());
    }
}
