package br.com.fiap.fiapeats.usecases.dtos;

public class CriarClienteDTO {

  private String nome;

  private String email;

  private String documento;

  public CriarClienteDTO(String nome, String email, String documento) {
    this.nome = nome;
    this.email = email;
    this.documento = documento;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDocumento() {
    return documento;
  }

  public void setDocumento(String documento) {
    this.documento = documento;
  }
}
