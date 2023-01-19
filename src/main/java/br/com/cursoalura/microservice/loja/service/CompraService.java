package br.com.cursoalura.microservice.loja.service;

import br.com.cursoalura.microservice.loja.client.FornecedorClient;
import br.com.cursoalura.microservice.loja.model.Compra;
import br.com.cursoalura.microservice.loja.model.dto.CompraDTO;
import br.com.cursoalura.microservice.loja.model.dto.InfoFornecedorDTO;
import br.com.cursoalura.microservice.loja.model.dto.InfoPedidoDTO;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CompraService {

    private static final Logger log = LoggerFactory.getLogger(CompraService.class);
    @Autowired
    private FornecedorClient fornecedorClient;

    public Compra realizarCompra(CompraDTO compraDTO) {

        final String estado = compraDTO.getEndereco().getEstado();
        log.info("Buscando informações do fornecedor de {}", estado);

        InfoFornecedorDTO infoFornecedorDTO = fornecedorClient.getInforPorEstado(compraDTO.getEndereco().getEstado());

        log.info("Realizando pedido");
        InfoPedidoDTO pedidoDTO = fornecedorClient.realizaPedido(compraDTO.getItens());

        Compra compraSalva = new Compra();
        compraSalva.setPedidoId(pedidoDTO.getId());
        compraSalva.setTempoDePreparo(pedidoDTO.getTempoDePreparo());
        compraSalva.setEnderecoDestino(infoFornecedorDTO.getEndereco().toString());

        return compraSalva;
    }
}
