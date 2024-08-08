package dinamica;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JulioTest {
	
	private List<Funcionario> funcionarios;
	private static Julio julio;
	
	@BeforeAll
	static void init() {
		julio = new Julio();
	}
	
	@BeforeEach
	void setup() {
		funcionarios = new ArrayList<>();
	}
	@DisplayName("Deve retornar o total de salario.")
	@Test
	void DeveRetornarOTotalDeSalarios() {
		funcionarios.add(new Funcionario("João Silva", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("9000")));
        funcionarios.add(new Funcionario("Maria Oliveira", DepartamentoEnum.RH, new BigDecimal("8000")));
        funcionarios.add(new Funcionario("Pedro Souza", DepartamentoEnum.DESENVOLVIMENTO, new BigDecimal("7000")));
        
        BigDecimal retorno = Julio.getTotalSalarios(funcionarios);
        
	}
	
	@Test
	void DeveRetornarOImpactoDosReajustes() {
		funcionarios.add(new Funcionario("João Silva", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("9000")));
        funcionarios.add(new Funcionario("Maria Oliveira", DepartamentoEnum.RH, new BigDecimal("8000")));
        funcionarios.add(new Funcionario("Pedro Souza", DepartamentoEnum.DESENVOLVIMENTO, new BigDecimal("7000")));
        
        BigDecimal retorno = Julio.getImpactoReajuste(funcionarios);
        
	}
	


}
