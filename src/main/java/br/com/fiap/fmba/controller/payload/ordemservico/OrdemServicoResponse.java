package br.com.fiap.fmba.controller.payload.ordemservico;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrdemServicoResponse {

	 private Long codigo;
	 private String dataInicio;
	 private String dataFinal;
	 private String nomeCliente;
	 private String veiculo;
	 private String placa;
}
