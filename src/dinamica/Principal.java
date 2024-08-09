package dinamica;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class Principal {

	public static void main(String[] args) {
		System.out.println(montaResposta(CargaDados.getListaFuncionarios()));
	}

	public static String montaResposta(List<Funcionario> funcionarios) {
		StringBuilder msg = new StringBuilder();
		msg.append("● Quais os 10 maiores salários da empresa? ");
		msg.append(String.join(", ",
				maioresSalarios(funcionarios).stream().map(l -> "R$" + l.toString().replace(".", ",")).toList()));
		msg.append("\n\n● Qual a média de salário por cargo? ");
		getMediaPorCargo(funcionarios).forEach(
				(m1, m2) -> msg.append(String.format("\nCargo: %s: R$ %s", m1, m2.toString().replace(".", ","))));
		msg.append("\n\n● Qual seria o impacto, em reais, de oferecer um reajuste de 10% a todos os funcionários?");
		msg.append(String.format(" R$ %s", getImpactoReajuste(funcionarios).toString().replace(".", ",")));
		msg.append("\n\n● Qual o percentual de cada cargo em relação ao total de funcionários?");
		getPercentualPorCargo(funcionarios)
				.forEach((m1, m2) -> msg.append(String.format("\nCargo: %s: %.2f%%", m1.toString(), m2)));
		msg.append("\n\n● Qual o menor salário, o maior salário, a média, a moda e a mediana de salário por cargo?");
		for (DepartamentoEnum e : DepartamentoEnum.values())
			msg.append(String.format(
					"\n%s: \nMenor Salario: R$%s\nMaior Salario R$%s\nMedia Salarial:  R$%s\nModa:  R$%s\nMediana:  R$%s",
					e.name(), menorSalarioCargo(e, funcionarios), maiorSalarioCargo(e, funcionarios),
					mediaSalarioCargo(e, funcionarios), modaSalarioCargo(e, funcionarios),
					medianaSalarioCargo(e, funcionarios)));
		msg.append("\n\n● Qual departamento possui o maior orçamento?");
		msg.append(String.format(" %s: R$%s", getMaiorOrcamento(funcionarios).getKey(),
				getMaiorOrcamento(funcionarios).getValue().toString().replace(".", ",")));
		msg.append("\n\n● Qual departamento possui a maior média salarial?");
		msg.append(String.format(" %s: R$%s", maiorMediaSalarial(funcionarios).getKey().name(),
				maiorMediaSalarial(funcionarios).getValue().toString().replace(".", ",")));
		return msg.toString();
	}

	public static List<BigDecimal> maioresSalarios(List<Funcionario> funcionarios) {
		return funcionarios.stream().map(f -> f.getSalario()).sorted(Comparator.reverseOrder()).toList().subList(0, 10);
	}

	public static Map<DepartamentoEnum, BigDecimal> getMediaPorCargo(List<Funcionario> lista) {
		Map<DepartamentoEnum, BigDecimal> mediaCargo = new HashMap<DepartamentoEnum, BigDecimal>();
		for (DepartamentoEnum d : DepartamentoEnum.values())
			mediaCargo.put(d, getMediaDoCargo(getFuncionarioCargo(d, lista)));
		return mediaCargo;
	}

	public static List<Funcionario> getFuncionarioCargo(DepartamentoEnum cargo, List<Funcionario> funcionarios) {
		return funcionarios.stream().filter(f -> f.getCargo().equals(cargo)).toList();
	}

	public static BigDecimal getMediaDoCargo(List<Funcionario> lista) {
		return lista.stream().map(f -> f.getSalario()).reduce(BigDecimal.ZERO, BigDecimal::add)
				.divide(new BigDecimal(lista.stream().filter(Objects::nonNull).count()), RoundingMode.HALF_EVEN);
	}

	public static BigDecimal getTotalSalarios(List<Funcionario> funcionarios) {
		BigDecimal soma = BigDecimal.valueOf(0);
		for (Funcionario f : funcionarios)
			soma = soma.add(f.getSalario());
		return soma;
	}

	public static BigDecimal getImpactoReajuste(List<Funcionario> funcionarios) {
		return getTotalSalarios(funcionarios).divide(BigDecimal.valueOf(10), 2, RoundingMode.HALF_EVEN);
	}

	static Map<DepartamentoEnum, Double> getPercentualPorCargo(List<Funcionario> funcionarios) {
		Map<DepartamentoEnum, Double> m = new HashMap<>();
		for (DepartamentoEnum p : DepartamentoEnum.values())
			m.put(p, (Double.parseDouble("" + getFuncionarioCargo(p, funcionarios).size()) / funcionarios.size()
					* 100));
		return m;
	}

	public static Entry<DepartamentoEnum, BigDecimal> getMaiorOrcamento(List<Funcionario> funcionarios) {
		Map<DepartamentoEnum, BigDecimal> maiorDepartamento = new HashMap<DepartamentoEnum, BigDecimal>();

		for (DepartamentoEnum d : DepartamentoEnum.values()) {
			List<Funcionario> cargo = getFuncionarioCargo(d, funcionarios);
			maiorDepartamento.put(d, getTotalSalarios(cargo));
		}
		return maiorDepartamento.entrySet().stream().sorted((m1, m2) -> m2.getValue().compareTo(m1.getValue()))
				.findFirst().orElseThrow(() -> new RuntimeException("No value present"));

	}

	public static Entry<DepartamentoEnum, BigDecimal> maiorMediaSalarial(List<Funcionario> funcionarios) {
		return getMediaPorCargo(funcionarios).entrySet().stream()
				.sorted((m1, m2) -> m2.getValue().compareTo(m1.getValue())).findFirst()
				.orElseThrow(() -> new RuntimeException("No value present"));
	}

	public static BigDecimal menorSalarioCargo(DepartamentoEnum cargo, List<Funcionario> funcionarios) {
		return getFuncionarioCargo(cargo, funcionarios).stream().map(f -> f.getSalario()).min(Comparator.naturalOrder())
				.orElseThrow(() -> new RuntimeException("No value present"));
	}

	public static BigDecimal maiorSalarioCargo(DepartamentoEnum cargo, List<Funcionario> funcionarios) {
		return getFuncionarioCargo(cargo, funcionarios).stream().map(f -> f.getSalario()).max(Comparator.naturalOrder())
				.orElseThrow(() -> new RuntimeException("No value present"));
	}

	public static BigDecimal mediaSalarioCargo(DepartamentoEnum cargo, List<Funcionario> funcionarios) {
		BigDecimal soma = getTotalSalarios(getFuncionarioCargo(cargo, funcionarios));

		return soma.divide(BigDecimal.valueOf(getFuncionarioCargo(cargo, funcionarios).size()), 2,
				RoundingMode.HALF_EVEN);
	}

	public static BigDecimal modaSalarioCargo(DepartamentoEnum cargo, List<Funcionario> funcionarios) {
		Map<BigDecimal, Integer> moda = new HashMap<>();
		for (Funcionario f : funcionarios)
			if (moda.containsKey(f.getSalario()))
				moda.put(f.getSalario(), (moda.get(f.getSalario()) + 1));
			else
				moda.put(f.getSalario(), 1);
		return moda.entrySet().stream().sorted((m1, m2) -> m2.getValue().compareTo(m1.getValue())).map(m -> m.getKey())
				.findFirst().orElseThrow(() -> new RuntimeException("No value present"));
	}

	public static BigDecimal medianaSalarioCargo(DepartamentoEnum cargo, List<Funcionario> funcionarios) {
		return medianaLista(
				getFuncionarioCargo(cargo, funcionarios).stream().map(m -> m.getSalario()).sorted().toList());
	}

	public static BigDecimal medianaLista(List<BigDecimal> salarios) {
		List<BigDecimal> temp = new ArrayList<>();
		temp.addAll(salarios);
		while (temp.size() > 2) {
			temp.removeFirst();
			temp.removeLast();
		}
		if (temp.size() == 2) {
			return temp.getFirst().add(temp.getLast()).divide(BigDecimal.valueOf(2), 2, RoundingMode.HALF_EVEN);
		} else {
			return temp.getFirst();
		}
	}

}
