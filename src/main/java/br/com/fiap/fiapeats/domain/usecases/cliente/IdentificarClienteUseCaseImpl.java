package br.com.fiap.fiapeats.domain.usecases.cliente;

import br.com.fiap.fiapeats.domain.entities.Cliente;
import br.com.fiap.fiapeats.domain.usecases.exceptions.NotFoundException;
import br.com.fiap.fiapeats.domain.interfaces.in.cliente.IdentificarClienteUseCase;
import br.com.fiap.fiapeats.domain.interfaces.out.cliente.ClienteRepositoryGateway;

public class IdentificarClienteUseCaseImpl implements IdentificarClienteUseCase {

  private final ClienteRepositoryGateway clienteRepositoryInterface;

  public IdentificarClienteUseCaseImpl(ClienteRepositoryGateway clienteRepositoryInterface) {
    this.clienteRepositoryInterface = clienteRepositoryInterface;
  }

  @Override
  public Cliente identificar(String documento) {
    Cliente cliente = clienteRepositoryInterface.identificar(documento);
    if (cliente == null) {
      throw new NotFoundException("A identificação do cliente falhou pois ele não existe!");
    }
    return cliente;
  }
}
