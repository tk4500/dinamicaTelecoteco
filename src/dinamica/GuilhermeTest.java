package dinamica;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GuilhermeTest {

	private List<Funcionario> funcionarios;

	@BeforeEach
	void setup() {
		funcionarios = new ArrayList<>();
		funcionarios.add(new Funcionario("João Silva", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("9000")));
		funcionarios.add(new Funcionario("Maria Oliveira", DepartamentoEnum.RH, new BigDecimal("8000")));
		funcionarios.add(new Funcionario("Pedro Souza", DepartamentoEnum.DESENVOLVIMENTO, new BigDecimal("7000")));
	}

	@DisplayName("Testa o percentual por cargo com funcionários.")
	@Test
	void deveCalcularPercentuaisCorretamente() {
		Map<DepartamentoEnum, Double> result = Guilherme.getPercentualPorCargo(funcionarios);

		double total = funcionarios.size();
		double percentual = 1 / total * 100;

		assertEquals(percentual, result.get(DepartamentoEnum.ADMINISTRACAO));
		assertEquals(percentual, result.get(DepartamentoEnum.DESENVOLVIMENTO));
		assertEquals(percentual, result.get(DepartamentoEnum.RH));

	}
}