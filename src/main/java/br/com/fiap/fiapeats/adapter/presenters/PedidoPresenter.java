package br.com.fiap.fiapeats.adapter.presenters;

import br.com.fiap.fiapeats.usecases.dtos.CriarPedidoResponse;
import br.com.fiap.fiapeats.usecases.dtos.ListarPedidosResponse;
import br.com.fiap.fiapeats.domain.entities.Pedido;
import br.com.fiap.fiapeats.usecases.dtos.ProdutoResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PedidoPresenter {

    public static CriarPedidoResponse toCriarPedidoResponse(Pedido pedido) {
        return new CriarPedidoResponse(
                pedido.getId().toString(),
                pedido.getCliCpf(),
                pedido.getIdStatus(),
                pedido.getTempoEspera(),
                pedido.getDataHoraCriacao()
        );
    }

    public static List<ListarPedidosResponse> toListarPedidosResponse(List<Pedido> pedidos) {
        List<ListarPedidosResponse> response = new ArrayList<>();

        for (Pedido pedido : pedidos) {
            response.add(new ListarPedidosResponse(pedido.getId().toString(),
                    pedido.getCliCpf(),
                    obterDescricaoDoStatusPorCodigo(pedido.getIdStatus()),
                    pedido.getValor(),
                    pedido.getTempoEspera(),
                    pedido.getDataHoraCriacao(),
                    obterDescricaoDoStatusDePagamentoPorCodigo(pedido.getIdPagamento()),
                    pedido.getProdutos().stream().map(ProdutoResponse::new).toList()));
        }

        return response;
    }

    public static ListarPedidosResponse toListarPedidoResponse(Pedido pedido) {
            return new ListarPedidosResponse(
                    pedido.getId().toString(),
                    pedido.getCliCpf(),
                    obterDescricaoDoStatusPorCodigo(pedido.getIdStatus()),
                    pedido.getValor(),
                    pedido.getTempoEspera(),
                    pedido.getDataHoraCriacao(),
                    obterDescricaoDoStatusDePagamentoPorCodigo(pedido.getIdPagamento()),
                    pedido.getProdutos().stream().map(ProdutoResponse::new).collect(Collectors.toList())
            );
    }

    private static String obterDescricaoDoStatusDePagamentoPorCodigo(Long codigoStatus) {
        String status;

        if (codigoStatus == null) {
            return "Código de status inválido";
        }

        switch (codigoStatus.intValue()) {
            case 1:
                status = "PENDENTE";
                break;
            case 2:
                status = "APROVADO";
                break;
            case 3:
                status = "REJEITADO";
                break;
            case 4:
                status = "EM ANÁLISE";
                break;
            case 5:
                status = "ESTORNADO";
                break;
            case 6:
                status = "CANCELADO";
                break;
            default:
                status = "STATUS DESCONHECIDO";
                break;
        }

        return status;
    }

    private static String obterDescricaoDoStatusPorCodigo(Long codigoStatus) {
        String status;

        if (codigoStatus == null) {
            return "Código de status inválido";
        }

        switch (codigoStatus.intValue()) {
            case 1:
                status = "PENDENTE";
                break;
            case 2:
                status = "RECEBIDO";
                break;
            case 3:
                status = "EM PREPARAÇÃO";
                break;
            case 4:
                status = "PRONTO";
                break;
            case 5:
                status = "FINALIZADO";
                break;
            case 6:
                status = "CANCELADO";
                break;
            default:
                status = "STATUS DESCONHECIDO";
                break;
        }

        return status;
    }



}
