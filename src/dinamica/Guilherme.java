package dinamica;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Guilherme {
	public static void main(String[] args) {
		System.out.println(getPercentualPorCargo(CargaDados.getListaFuncionarios()).toString());
			
	}

	public static List<Funcionario> getFuncionarioCargo(DepartamentoEnum cargo, List<Funcionario> funcionarios){
		return funcionarios.stream().filter(f->f.getCargo().equals(cargo)).toList();
	}
		
		static Map<DepartamentoEnum, Double> getPercentualPorCargo(List<Funcionario> funcionarios) {
			Map<DepartamentoEnum, Double> m = new HashMap<>();
			for(DepartamentoEnum p: DepartamentoEnum.values()) {
				m.put(p, ( Double.parseDouble("" + getFuncionarioCargo(p, funcionarios).size()) / funcionarios.size()*100 ));
			}
			
			return m;		
		
	    }

}

		
		
	/*
        List<Funcionario> funcionarios = getListaFuncionarios();

      
        Map<DepartamentoEnum, Integer> contadorDepartamentos = new HashMap<>();
        for (Funcionario funcionario : funcionarios) {
            DepartamentoEnum departamento = funcionario.getCargo();
            contadorDepartamentos.put(departamento, contadorDepartamentos.getOrDefault(departamento, 0) + 1);
        }

    
        int totalFuncionarios = funcionarios.size();

       
        Map<DepartamentoEnum, Double> percentuais = new HashMap<>();
        for (DepartamentoEnum departamento : contadorDepartamentos.keySet()) {
            int quantidade = contadorDepartamentos.get(departamento);
            double percentual = (quantidade * 100.0) / totalFuncionarios;
            percentuais.put(departamento, percentual);
        }

 
        for (DepartamentoEnum departamento : percentuais.keySet()) {
            double percentual = percentuais.get(departamento);
            System.out.println("Departamento: " + departamento + "  Percentual: " + percentual + "%");
        }
    }

    public static List<Funcionario> getListaFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        return funcionarios;	*/
		
		
		
		
		
		
		