package dinamica;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class VariacaoPorCargo {

	public static void main(String[] args) {
		List<Funcionario> funcionarios = CargaDados.getListaFuncionarios();
		BigDecimal menor = menorSalarioCargo(DepartamentoEnum.VENDAS, funcionarios);
		System.out.println(menor);
	}
	
	public static BigDecimal menorSalarioCargo(DepartamentoEnum cargo, List<Funcionario> funcionarios) {
		return getFuncionarioCargo(cargo, funcionarios).stream().map(f -> f.getSalario()).min(Comparator.naturalOrder()).orElse(BigDecimal.valueOf(0));
	}
	
	public static List<Funcionario> getFuncionarioCargo(DepartamentoEnum cargo, List<Funcionario> funcionarios){
		return funcionarios.stream().filter(f->f.getCargo().equals(cargo)).toList();
		
	}
}
