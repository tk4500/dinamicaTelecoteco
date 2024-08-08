package dinamica;

import java.math.BigDecimal;
import java.util.List;

public class VariacaoPorCargo {

	public static void main(String[] args) {
		List<Funcionario> funcionarios = CargaDados.getListaFuncionarios();
	}
	
	public void name() {
		
	}
	
	public BigDecimal menorSalarioCargo(DepartamentoEnum cargo, List<Funcionario> funcionarios) {
		
	}
	
	public List<Funcionario> getFuncionarioCargo(DepartamentoEnum cargo, List<Funcionario> funcionarios){
		return funcionarios.stream().filter(f->f.getCargo().equals(cargo)).toList();
		
	}
}
