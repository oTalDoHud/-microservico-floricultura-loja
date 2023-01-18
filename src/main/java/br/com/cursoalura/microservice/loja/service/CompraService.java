package br.com.cursoalura.microservice.loja.service;

import br.com.cursoalura.microservice.loja.client.FornecedorClient;
import br.com.cursoalura.microservice.loja.model.Compra;
import br.com.cursoalura.microservice.loja.model.dto.CompraDTO;
import br.com.cursoalura.microservice.loja.model.dto.InfoFornecedorDTO;
import br.com.cursoalura.microservice.loja.model.dto.InfoPedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {


    @Autowired
    private FornecedorClient fornecedorClient;

    public Compra realizarCompra(CompraDTO compraDTO) {
        InfoFornecedorDTO infoFornecedorDTO = fornecedorClient.getInforPorEstado(compraDTO.getEndereco().getEstado());
        InfoPedidoDTO pedidoDTO = fornecedorClient.realizaPedido(compraDTO.getItens());

        System.out.println(infoFornecedorDTO.getEndereco());

        Compra compraSalva = new Compra();
        compraSalva.setPedidoId(pedidoDTO.getId());
        compraSalva.setTempoDePreparo(pedidoDTO.getTempoDePreparo());
        compraSalva.setEnderecoDestino(compraDTO.getEndereco().toString());

        return compraSalva;
    }
}
