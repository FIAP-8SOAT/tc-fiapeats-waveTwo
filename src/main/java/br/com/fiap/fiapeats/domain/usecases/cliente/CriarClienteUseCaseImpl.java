package br.com.fiap.fiapeats.domain.usecases.cliente;

import br.com.fiap.fiapeats.domain.dtos.CriarClienteDTO;
import br.com.fiap.fiapeats.domain.usecases.exceptions.ClienteExistenteException;
import br.com.fiap.fiapeats.domain.entities.Cliente;
import br.com.fiap.fiapeats.domain.interfaces.in.cliente.CriarClienteUseCase;
import br.com.fiap.fiapeats.domain.interfaces.out.cliente.ClienteRepositoryGateway;

public class CriarClienteUseCaseImpl implements CriarClienteUseCase {

    private final ClienteRepositoryGateway clienteRepositoryInterface;

    public CriarClienteUseCaseImpl(ClienteRepositoryGateway clienteRepositoryInterface) {
        this.clienteRepositoryInterface = clienteRepositoryInterface;
    }

    @Override
    public Cliente criar(CriarClienteDTO criarClienteDTO) {
        Cliente cliente = new Cliente(criarClienteDTO.getNome(), criarClienteDTO.getEmail(), criarClienteDTO.getDocumento());

        if (clienteRepositoryInterface.identificar(cliente.getDocumento()) != null) {
            throw new ClienteExistenteException("Cliente já possui cadastro");
        }
        return clienteRepositoryInterface.criar(cliente);
    }
}
