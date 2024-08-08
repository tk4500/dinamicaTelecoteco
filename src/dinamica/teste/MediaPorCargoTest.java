package dinamica.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import dinamica.DepartamentoEnum;
import dinamica.Funcionario;
import dinamica.MediaPorCargo;

class MediaPorCargoTest {

	@Test
	void deveRetornarMediaPorCargo() {
		
		List<Funcionario> funcionarios = new ArrayList<>();
		
		funcionarios.add(new Funcionario("João Silva", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("9000")));
        funcionarios.add(new Funcionario("Maria Oliveira", DepartamentoEnum.RH, new BigDecimal("8000")));
        funcionarios.add(new Funcionario("Pedro Souza", DepartamentoEnum.DESENVOLVIMENTO, new BigDecimal("7000")));
        funcionarios.add(new Funcionario("Marcos Silva", DepartamentoEnum.DESENVOLVIMENTO, new BigDecimal("7600")));
        funcionarios.add(new Funcionario("Letícia Santos", DepartamentoEnum.SUPORTE, new BigDecimal("6300")));
        funcionarios.add(new Funcionario("Vinícius Lima", DepartamentoEnum.QUALIDADE, new BigDecimal("5800")));
        funcionarios.add(new Funcionario("Amanda Oliveira", DepartamentoEnum.VENDAS, new BigDecimal("7800")));
        funcionarios.add(new Funcionario("Felipe Almeida", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("9800")));
        funcionarios.add(new Funcionario("Larissa Costa", DepartamentoEnum.RH, new BigDecimal("8700")));
        funcionarios.add(new Funcionario("Gustavo Ferreira", DepartamentoEnum.DESENVOLVIMENTO, new BigDecimal("7700")));
        funcionarios.add(new Funcionario("Isabela Sousa", DepartamentoEnum.SUPORTE, new BigDecimal("6400")));
        funcionarios.add(new Funcionario("Renato Mendes", DepartamentoEnum.QUALIDADE, new BigDecimal("5900")));
        
        MediaPorCargo mediaCargo =  new MediaPorCargo();
        
        Map<DepartamentoEnum, BigDecimal> retorno = mediaCargo.getMediaPorCargo(funcionarios);
        
        assertThat();
		
	}

	
}
