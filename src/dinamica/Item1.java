package dinamica;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Item1 {

	public static void main(String[] args) {

		System.out.println(maioresSalariosString(CargaDados.getListaFuncionarios()));

	}

	public static List<Funcionario> getFuncionarioCargo(DepartamentoEnum cargo, List<Funcionario> funcionarios) {
		return funcionarios.stream().filter(f -> f.getCargo().equals(cargo)).toList();

	}

	public static BigDecimal getTotalSalarios(List<Funcionario> funcionarios) {
		BigDecimal soma = BigDecimal.valueOf(0);
		for (Funcionario f : funcionarios) {
			soma = soma.add(f.getSalario());
		}
		return soma;

	}

	public static Map.Entry<DepartamentoEnum, BigDecimal> maiorOrcamento(List<Funcionario> funcionarios) {
		Map<DepartamentoEnum, BigDecimal> orcamentos = new HashMap<>();

		for (DepartamentoEnum d : DepartamentoEnum.values()) {
			List<Funcionario> cargo = getFuncionarioCargo(d, funcionarios);
			BigDecimal totalSalario = getTotalSalarios(cargo);
			orcamentos.put(d, totalSalario);
		}
		return orcamentos.entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null);
	}

	public static Orcamento getMaiorOrcamento(List<Funcionario> funcionarios) {
		List<Orcamento> maiorDepartamento = new ArrayList<>();
		Item1 a = new Item1();
		for (DepartamentoEnum d : DepartamentoEnum.values()) {
			List<Funcionario> cargo = getFuncionarioCargo(d, funcionarios);
			maiorDepartamento.add(a.new Orcamento(d, getTotalSalarios(cargo)));
		}
		maiorDepartamento.sort((m1, m2) -> m2.orcamento.compareTo(m1.orcamento));
		return maiorDepartamento.getFirst();
	}

	public static BigDecimal menorSalario(List<Funcionario> funcionarios) {

		BigDecimal maiorSalario = funcionarios.stream().map(f -> f.getSalario()).sorted(Comparator.naturalOrder())
				.findFirst().orElse(null);

		return maiorSalario;

	}

	public static BigDecimal maiorSalario(List<Funcionario> funcionarios) {

		BigDecimal maiorSalario = funcionarios.stream().map(f -> f.getSalario()).sorted(Comparator.reverseOrder())
				.findFirst().orElse(null);

		return maiorSalario;

	}

	public static String maioresSalariosString(List<Funcionario> funcionarios) {

		String salarios = funcionarios.stream().map(f -> f.getSalario()).sorted(Comparator.reverseOrder()).limit(10)
				.map(BigDecimal::toString).collect(Collectors.joining("\n"));

		return salarios;

	}

	public static List<BigDecimal> maioresSalarios(List<Funcionario> funcionarios) {

		List<BigDecimal> lista = funcionarios.stream().map(f -> f.getSalario()).sorted(Comparator.reverseOrder())
				.limit(10).toList();

		return lista;

	}

	public class Orcamento {
		DepartamentoEnum departamento;
		BigDecimal orcamento;

		public Orcamento(DepartamentoEnum departamento, BigDecimal orcamento) {
			this.departamento = departamento;
			this.orcamento = orcamento;

		}

	}

}
