package dinamica;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrincipalTest {
	Principal principal;
	List<Funcionario> funcionarios;
	
	@BeforeEach
	void setup(){
		principal = new Principal();
		funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("João Silva", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("9000")));
        funcionarios.add(new Funcionario("Maria Oliveira", DepartamentoEnum.RH, new BigDecimal("8000")));
        funcionarios.add(new Funcionario("Pedro Souza", DepartamentoEnum.DESENVOLVIMENTO, new BigDecimal("7000")));
        funcionarios.add(new Funcionario("Ana Santos", DepartamentoEnum.SUPORTE, new BigDecimal("6000")));
        funcionarios.add(new Funcionario("José Lima", DepartamentoEnum.QUALIDADE, new BigDecimal("5500")));
        funcionarios.add(new Funcionario("Paula Rocha", DepartamentoEnum.VENDAS, new BigDecimal("7500")));
        funcionarios.add(new Funcionario("Carlos Alves", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("9200")));
        funcionarios.add(new Funcionario("Fernanda Ribeiro", DepartamentoEnum.RH, new BigDecimal("8100")));
        funcionarios.add(new Funcionario("Lucas Fernandes", DepartamentoEnum.DESENVOLVIMENTO, new BigDecimal("7200")));
        funcionarios.add(new Funcionario("Juliana Costa", DepartamentoEnum.SUPORTE, new BigDecimal("6100")));
        funcionarios.add(new Funcionario("Ricardo Pereira", DepartamentoEnum.QUALIDADE, new BigDecimal("5600")));
        funcionarios.add(new Funcionario("Camila Lima", DepartamentoEnum.VENDAS, new BigDecimal("7600")));
        funcionarios.add(new Funcionario("Bruno Gomes", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("9400")));
        funcionarios.add(new Funcionario("Patricia Ferreira", DepartamentoEnum.RH, new BigDecimal("8300")));
        funcionarios.add(new Funcionario("Marcelo Rodrigues", DepartamentoEnum.DESENVOLVIMENTO, new BigDecimal("7400")));
        funcionarios.add(new Funcionario("Renata Martins", DepartamentoEnum.SUPORTE, new BigDecimal("6200")));
        funcionarios.add(new Funcionario("Thiago Almeida", DepartamentoEnum.QUALIDADE, new BigDecimal("5700")));
        funcionarios.add(new Funcionario("Beatriz Araujo", DepartamentoEnum.VENDAS, new BigDecimal("7700")));
        funcionarios.add(new Funcionario("André Melo", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("9600")));
        funcionarios.add(new Funcionario("Gabriela Cardoso", DepartamentoEnum.RH, new BigDecimal("8500")));
        funcionarios.add(new Funcionario("Marcos Silva", DepartamentoEnum.DESENVOLVIMENTO, new BigDecimal("7600")));
        funcionarios.add(new Funcionario("Letícia Santos", DepartamentoEnum.SUPORTE, new BigDecimal("6300")));
        funcionarios.add(new Funcionario("Vinícius Lima", DepartamentoEnum.QUALIDADE, new BigDecimal("5800")));
        funcionarios.add(new Funcionario("Amanda Oliveira", DepartamentoEnum.VENDAS, new BigDecimal("7800")));
        funcionarios.add(new Funcionario("Felipe Almeida", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("9800")));
        funcionarios.add(new Funcionario("Larissa Costa", DepartamentoEnum.RH, new BigDecimal("8700")));
        funcionarios.add(new Funcionario("Gustavo Ferreira", DepartamentoEnum.DESENVOLVIMENTO, new BigDecimal("7700")));
        funcionarios.add(new Funcionario("Isabela Sousa", DepartamentoEnum.SUPORTE, new BigDecimal("6400")));
	}
	@Test
	void test() {
		System.out.println(principal.montaResposta(funcionarios));
	}
	
	@DisplayName("Deve retornar o total de salario.")
	@Test
	void DeveRetornarOTotalDeSalarios() {
		funcionarios.add(new Funcionario("João Silva", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("9000")));
        funcionarios.add(new Funcionario("Maria Oliveira", DepartamentoEnum.RH, new BigDecimal("8000")));
        funcionarios.add(new Funcionario("Pedro Souza", DepartamentoEnum.DESENVOLVIMENTO, new BigDecimal("7000")));
        
        BigDecimal retorno = Principal.getTotalSalarios(funcionarios);
        
	}
	
	@DisplayName("getTotalSalarios Deve Lancar NullPointerException Ao Adicionar Funcionario Nulo")
	@Test
	public void deveLancarNullPointerExceptionAoAdicionarFuncionarioNuloEmTotalSalarios() {
	    
	    try {
	    	Principal.getTotalSalarios(funcionarios);
	    }catch(NullPointerException e) {
	    	
	    }
	}
	
	@Test
	void DeveRetornarOImpactoDosReajustes() {
		funcionarios.add(new Funcionario("João Silva", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("9000")));
        funcionarios.add(new Funcionario("Maria Oliveira", DepartamentoEnum.RH, new BigDecimal("8000")));
        funcionarios.add(new Funcionario("Pedro Souza", DepartamentoEnum.DESENVOLVIMENTO, new BigDecimal("7000")));
        
        BigDecimal retorno = Principal.getImpactoReajuste(funcionarios);
        
	}
	
	@DisplayName("getImpactoReajuste Deve Lancar NullPointerException Ao Adicionar Funcionario Nulo")
	@Test
	public void deveLancarNullPointerExceptionAoAdicionarFuncionarioNuloEmImpactoDosReajustes() {
	    
	    try {
	    	Principal.getImpactoReajuste(funcionarios);
	    }catch(NullPointerException e) {
	    	
	    }
	}

}
