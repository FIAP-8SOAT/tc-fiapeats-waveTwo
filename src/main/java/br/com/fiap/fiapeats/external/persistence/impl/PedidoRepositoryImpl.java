package br.com.fiap.fiapeats.external.persistence.impl;

import br.com.fiap.fiapeats.adapter.gateway.persistence.interfaces.PedidoRepository;
import br.com.fiap.fiapeats.external.persistence.mapper.PedidoEntityMapper;
import br.com.fiap.fiapeats.external.persistence.orm.PedidoEntity;
import br.com.fiap.fiapeats.external.persistence.repository.PedidoRepositoryJPA;
import br.com.fiap.fiapeats.domain.entities.Pedido;
import br.com.fiap.fiapeats.domain.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class PedidoRepositoryImpl implements PedidoRepository {

    @Autowired
    private PedidoEntityMapper pedidoMapper;

    @Autowired
    private PedidoRepositoryJPA pedidoRepositoryJPA;

    @Override
    public Pedido salvarPedido(Pedido pedido) {
        log.info(
                "correlationId={"
                        + ThreadContext.get(Constants.CORRELATION_ID)
                        + "} "
                        + "[PedidoRepositoryImpl-salvarPedido] ");

        PedidoEntity result = pedidoRepositoryJPA.save(pedidoMapper.toPedidoEntity(pedido));
        return pedidoMapper.toPedidoFromEntity(result);
    }

    @Override
    public List<Pedido> listarPedidos() {
        log.info(
                "correlationId={"
                        + ThreadContext.get(Constants.CORRELATION_ID)
                        + "} "
                        + "[PedidoRepositoryImpl-listarPedidos] ");

        List<PedidoEntity> result = pedidoRepositoryJPA.findAll();
        return pedidoMapper.toListaPedidos(result);
    }

    @Override
    public List<Pedido> listarPedidosPorPagamento(Long idPagamento) {
        log.info(
                "correlationId={"
                        + ThreadContext.get(Constants.CORRELATION_ID)
                        + "} "
                        + "[PedidoRepositoryImpl-listarPedidosPorPagamento] ");

        List<PedidoEntity> result = pedidoRepositoryJPA.findByIdPagamento(idPagamento);
        return pedidoMapper.toListaPedidos(result);
    }

    @Override
    public Pedido listarPedidoPorId(String idPedido) {
        log.info(
                "correlationId={"
                        + ThreadContext.get(Constants.CORRELATION_ID)
                        + "} "
                        + "[PedidoRepositoryImpl-listarPedidosPorPagamento] ");

        Optional<PedidoEntity> result = pedidoRepositoryJPA.findById(UUID.fromString(idPedido));
        if(result.isPresent())
            return pedidoMapper.toPedidoFromEntity(result.get());
        else
            return null; //TODO: Verificar como ajustar
    }

}