package dinamica;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Julio {
	

	public static void main(String[] args) {
		
		 List<Funcionario> funcionarios = CargaDados.getListaFuncionarios() ;
	}
	
	public static BigDecimal getTotalSalarios(List<Funcionario> funcionarios) {
		BigDecimal soma = BigDecimal.valueOf(0);
		for(Funcionario f : funcionarios) {
			soma = soma.add(f.getSalario());
		}
		return soma;
		
	}
	
	public static BigDecimal getImpactoReajuste(List<Funcionario> funcionarios) {
		return getTotalSalarios(funcionarios).divide(BigDecimal.valueOf(10), 2, RoundingMode.HALF_EVEN);
		
	}

		
	
}
