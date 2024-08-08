package dinamica;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VariacaoPorCargo {

	public static void main(String[] args) {
		List<Funcionario> funcionarios = CargaDados.getListaFuncionarios();
		BigDecimal menor = menorSalarioCargo(DepartamentoEnum.VENDAS, funcionarios);
		System.out.println(menor);
	}
	
	public static BigDecimal menorSalarioCargo(DepartamentoEnum cargo, List<Funcionario> funcionarios) {
		return getFuncionarioCargo(cargo, funcionarios).stream().map(f -> f.getSalario()).min(Comparator.naturalOrder()).orElse(BigDecimal.valueOf(0));
	}
	public static BigDecimal maiorSalarioCargo(DepartamentoEnum cargo, List<Funcionario> funcionarios) {
		return getFuncionarioCargo(cargo, funcionarios).stream().map(f -> f.getSalario()).max(Comparator.naturalOrder()).orElse(BigDecimal.valueOf(0));
	}
	public static BigDecimal mediaSalarioCargo(DepartamentoEnum cargo, List<Funcionario> funcionarios) {
		BigDecimal soma = getTotalSalarios(getFuncionarioCargo(cargo, funcionarios));
		
		return soma.divide(BigDecimal.valueOf(getFuncionarioCargo(cargo, funcionarios).size()), 2, RoundingMode.HALF_EVEN);
	}
	public static BigDecimal modaSalarioCargo(DepartamentoEnum cargo, List<Funcionario> funcionarios) {
		Map<BigDecimal,Integer> moda = new HashMap<>();
		for(Funcionario f :funcionarios)
			if (moda.containsKey(f.getSalario()))
				moda.put(null, null);
		
		return null;
	}
	
	public static BigDecimal getTotalSalarios(List<Funcionario> funcionarios) {
		BigDecimal soma = BigDecimal.valueOf(0);
		for(Funcionario f : funcionarios) {
			soma = soma.add(f.getSalario());
		}
		return soma;
		
	}
	
	public static List<Funcionario> getFuncionarioCargo(DepartamentoEnum cargo, List<Funcionario> funcionarios){
		return funcionarios.stream().filter(f->f.getCargo().equals(cargo)).toList();
		
	}
	
}
