package dinamica;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class MediaPorCargo {

	public static void main(String[] args) {
		
		
		MediaPorCargo media = new MediaPorCargo();
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
        
        System.out.println(media.getFuncionarioCargo(DepartamentoEnum.RH, funcionarios));
        System.out.println(media.getMediaDoCargo(funcionarios));
        System.out.println(media.getMediaPorCargo(funcionarios));
		
	}
	
	
	public List<Funcionario> getFuncionarioCargo(DepartamentoEnum cargo, List<Funcionario> funcionarios){
		return funcionarios.stream().filter(f->f.getCargo().equals(cargo)).toList();
		
	}
	
	public BigDecimal getMediaDoCargo(List<Funcionario> lista) {
		
		BigDecimal sum = lista.stream().map(f -> f.getSalario()).reduce(BigDecimal.ZERO, BigDecimal::add);
		
		long count = lista.stream().filter(Objects::nonNull).count();
		
		return sum.divide(new BigDecimal(count), RoundingMode.HALF_EVEN);
	}
	
	public Map<DepartamentoEnum, BigDecimal> getMediaPorCargo(List<Funcionario> lista){
			
		Map<DepartamentoEnum, BigDecimal> mediaCargo = new HashMap<DepartamentoEnum, BigDecimal>();

		for(DepartamentoEnum d: DepartamentoEnum.values()) {
			mediaCargo.put(d, getMediaDoCargo(getFuncionarioCargo(d, lista)));
		}
				
		return mediaCargo;
		
	}
	
}