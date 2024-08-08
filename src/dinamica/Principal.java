package dinamica;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import dinamica.Item1.Orcamento;

public class Principal {

	public static void main(String[] args) {
		new Principal();
	}

	public Principal() {
		System.out.println(maiorMediaSalarial(CargaDados.getListaFuncionarios()));
	}

	public static List<BigDecimal> maioresSalarios(List<Funcionario> funcionarios) {
		return funcionarios.stream().map(f -> f.getSalario()).sorted(Comparator.reverseOrder()).toList().subList(0, 10);
	}

	public Map<DepartamentoEnum, BigDecimal> getMediaPorCargo(List<Funcionario> lista) {
		Map<DepartamentoEnum, BigDecimal> mediaCargo = new HashMap<DepartamentoEnum, BigDecimal>();
		for (DepartamentoEnum d : DepartamentoEnum.values())
			mediaCargo.put(d, getMediaDoCargo(getFuncionarioCargo(d, lista)));
		return mediaCargo;
	}

	public static List<Funcionario> getFuncionarioCargo(DepartamentoEnum cargo, List<Funcionario> funcionarios) {
		return funcionarios.stream().filter(f -> f.getCargo().equals(cargo)).toList();
	}

	public BigDecimal getMediaDoCargo(List<Funcionario> lista) {
		return lista.stream().map(f -> f.getSalario()).reduce(BigDecimal.ZERO, BigDecimal::add)
				.divide(new BigDecimal(lista.stream().filter(Objects::nonNull).count()), RoundingMode.HALF_EVEN);
	}
	public static BigDecimal getTotalSalarios(List<Funcionario> funcionarios) {
		BigDecimal soma = BigDecimal.valueOf(0);
		for(Funcionario f : funcionarios) 
			soma = soma.add(f.getSalario());
		return soma;
	}
	
	public static BigDecimal getImpactoReajuste(List<Funcionario> funcionarios) {
		return getTotalSalarios(funcionarios).divide(BigDecimal.valueOf(10), 2, RoundingMode.HALF_EVEN);		
	}
	static Map<DepartamentoEnum, Double> getPercentualPorCargo(List<Funcionario> funcionarios) {
		Map<DepartamentoEnum, Double> m = new HashMap<>();
		for(DepartamentoEnum p: DepartamentoEnum.values()) 
			m.put(p, ( Double.parseDouble("" + getFuncionarioCargo(p, funcionarios).size()) / funcionarios.size()*100 ));
		return m;		
    }
	public class Orcamento {
		DepartamentoEnum departamento;
		BigDecimal orcamento;
		public Orcamento(DepartamentoEnum departamento, BigDecimal orcamento) {
			this.departamento = departamento;
			this.orcamento = orcamento;
		}
	}
	public static Orcamento getMaiorOrcamento(List<Funcionario> funcionarios) {
		List<Orcamento> maiorDepartamento = new ArrayList<>();
		Principal a = new Principal();
		for (DepartamentoEnum d : DepartamentoEnum.values()) {
			List<Funcionario> cargo = getFuncionarioCargo(d, funcionarios);
			maiorDepartamento.add(a.new Orcamento(d, getTotalSalarios(cargo)));
		}
		maiorDepartamento.sort((m1, m2) -> m2.orcamento.compareTo(m1.orcamento));
		return maiorDepartamento.getFirst();
	}
	public String maiorMediaSalarial(List<Funcionario> funcionarios) {
		return getMediaPorCargo(funcionarios).entrySet().stream().sorted((m1, m2) -> m2.getValue().compareTo(m1.getValue())).findFirst().toString();
	}
}
