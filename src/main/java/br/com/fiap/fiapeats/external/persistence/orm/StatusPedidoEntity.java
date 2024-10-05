package br.com.fiap.fiapeats.external.persistence.orm;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.*;

@Entity
@Table(name = "StatusPedido")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StatusPedidoEntity implements Serializable {

  @Id
  @Column(name = "ID_STATUS", nullable = false)
  private Long idStatus;

  @Column(name = "DESCRICAO", nullable = false)
  private String descricao;
}
