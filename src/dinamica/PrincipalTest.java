package dinamica;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrincipalTest {

    private List<Funcionario> funcionarios;

    @BeforeEach
    public void setup() {
        funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("João Silva", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("9000")));
        funcionarios.add(new Funcionario("Maria Oliveira", DepartamentoEnum.RH, new BigDecimal("8000")));
        funcionarios.add(new Funcionario("Pedro Souza", DepartamentoEnum.DESENVOLVIMENTO, new BigDecimal("7000")));
        funcionarios.add(new Funcionario("Ana Santos", DepartamentoEnum.SUPORTE, new BigDecimal("6000")));
        funcionarios.add(new Funcionario("José Lima", DepartamentoEnum.QUALIDADE, new BigDecimal("5500")));
        funcionarios.add(new Funcionario("Paula Rocha", DepartamentoEnum.VENDAS, new BigDecimal("7500")));
        funcionarios.add(new Funcionario("Carlos Alves", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("9200")));
        funcionarios.add(new Funcionario("Carlos Alves", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("9200")));
        funcionarios.add(new Funcionario("Fernanda Ribeiro", DepartamentoEnum.RH, new BigDecimal("8100")));
        funcionarios.add(new Funcionario("Lucas Fernandes", DepartamentoEnum.DESENVOLVIMENTO, new BigDecimal("7200")));
        funcionarios.add(new Funcionario("Juliana Costa", DepartamentoEnum.SUPORTE, new BigDecimal("6100")));
        funcionarios.add(new Funcionario("Ricardo Pereira", DepartamentoEnum.QUALIDADE, new BigDecimal("5600")));
        funcionarios.add(new Funcionario("Camila Lima", DepartamentoEnum.VENDAS, new BigDecimal("7600")));
        funcionarios.add(new Funcionario("Bruno Gomes", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("9400")));
        funcionarios.add(new Funcionario("Patricia Ferreira", DepartamentoEnum.RH, new BigDecimal("8300")));
        funcionarios.add(new Funcionario("Marcelo Rodrigues", DepartamentoEnum.DESENVOLVIMENTO, new BigDecimal("7400")));
        funcionarios.add(new Funcionario("Renata Martins", DepartamentoEnum.SUPORTE, new BigDecimal("6200")));
        funcionarios.add(new Funcionario("Thiago Almeida", DepartamentoEnum.QUALIDADE, new BigDecimal("5700")));
    }

    @Test
    @DisplayName("Testa o tamanho da lista de maiores salários")
    public void testMaioresSalariosSize() {
        List<BigDecimal> maioresSalarios = Principal.maioresSalarios(funcionarios);
        assertEquals(10, maioresSalarios.size());
    }

    @Test
    @DisplayName("Testa o valor do maior salário")
    public void testMaioresSalariosValor() {
        List<BigDecimal> maioresSalarios = Principal.maioresSalarios(funcionarios);
        assertEquals(new BigDecimal("9400"), maioresSalarios.get(0));
    }

    @Test
    @DisplayName("Testa a média de salários por cargo para ADMINISTRACAO")
    public void testGetMediaPorCargoAdministracao() {
        Map<DepartamentoEnum, BigDecimal> mediaPorCargo = Principal.getMediaPorCargo(funcionarios);
        assertEquals(new BigDecimal("9200"), mediaPorCargo.get(DepartamentoEnum.ADMINISTRACAO));
    }

    @Test
    @DisplayName("Testa a média de salários por cargo para RH")
    public void testGetMediaPorCargoRh() {
        Map<DepartamentoEnum, BigDecimal> mediaPorCargo = Principal.getMediaPorCargo(funcionarios);
        assertEquals(new BigDecimal("8133"), mediaPorCargo.get(DepartamentoEnum.RH));
    }

    @Test
    @DisplayName("Testa a média de salários por cargo para DESENVOLVIMENTO")
    public void testGetMediaPorCargoDesenvolvimento() {
        Map<DepartamentoEnum, BigDecimal> mediaPorCargo = Principal.getMediaPorCargo(funcionarios);
        assertEquals(new BigDecimal("7200"), mediaPorCargo.get(DepartamentoEnum.DESENVOLVIMENTO));
    }

    @Test
    @DisplayName("Testa a média de salários por cargo para SUPORTE")
    public void testGetMediaPorCargoSuporte() {
        Map<DepartamentoEnum, BigDecimal> mediaPorCargo = Principal.getMediaPorCargo(funcionarios);
        assertEquals(new BigDecimal("6100"), mediaPorCargo.get(DepartamentoEnum.SUPORTE));
    }

    @Test
    @DisplayName("Testa a média de salários por cargo para VENDAS")
    public void testGetMediaPorCargoQualidade() {
        Map<DepartamentoEnum, BigDecimal> mediaPorCargo = Principal.getMediaPorCargo(funcionarios);
        assertEquals(new BigDecimal("7550"), mediaPorCargo.get(DepartamentoEnum.VENDAS));
    }

    @Test
    @DisplayName("Testa a média de salários por cargo para QUALIDADE")
    public void testGetMediaPorCargoVendas() {
        Map<DepartamentoEnum, BigDecimal> mediaPorCargo = Principal.getMediaPorCargo(funcionarios);
        assertEquals(new BigDecimal("5600"), mediaPorCargo.get(DepartamentoEnum.QUALIDADE));
    }

    @Test
    @DisplayName("Testa o impacto do reajuste")
    public void testGetImpactoReajuste() {
        BigDecimal impactoReajuste = Principal.getImpactoReajuste(funcionarios);
        assertEquals(new BigDecimal("13300.00"), impactoReajuste);
    }

    @Test
    @DisplayName("Testa o percentual de salários por cargo para ADMINISTRACAO")
    public void testGetPercentualAdministracao() {
        Map<DepartamentoEnum, Double> percentualPorCargo = Principal.getPercentualPorCargo(funcionarios);
        assertEquals(22.22, percentualPorCargo.get(DepartamentoEnum.ADMINISTRACAO), 0.01);
    }

    @Test
    @DisplayName("Testa o percentual de salários por cargo para RH")
    public void testGetPercentualRh() {
        Map<DepartamentoEnum, Double> percentualPorCargo = Principal.getPercentualPorCargo(funcionarios);
        assertEquals(16.66, percentualPorCargo.get(DepartamentoEnum.RH), 0.01);
    }

    @Test
    @DisplayName("Testa o percentual de salários por cargo para DESENVOLVIMENTO")
    public void testGetPercentualDesenvolvimento() {
        Map<DepartamentoEnum, Double> percentualPorCargo = Principal.getPercentualPorCargo(funcionarios);
        assertEquals(16.66, percentualPorCargo.get(DepartamentoEnum.DESENVOLVIMENTO), 0.01);
    }

    @Test
    @DisplayName("Testa o percentual de salários por cargo para SUPORTE")
    public void testGetPercentualSuporte() {
        Map<DepartamentoEnum, Double> percentualPorCargo = Principal.getPercentualPorCargo(funcionarios);
        assertEquals(16.66, percentualPorCargo.get(DepartamentoEnum.SUPORTE), 0.01);
    }

    @Test
    @DisplayName("Testa o percentual de salários por cargo para QUALIDADE")
    public void testGetPercentualQualidade() {
        Map<DepartamentoEnum, Double> percentualPorCargo = Principal.getPercentualPorCargo(funcionarios);
        assertEquals(16.66, percentualPorCargo.get(DepartamentoEnum.QUALIDADE), 0.01);
    }

    @Test
    @DisplayName("Testa o percentual de salários por cargo para VENDAS")
    public void testGetPercentualVendas() {
        Map<DepartamentoEnum, Double> percentualPorCargo = Principal.getPercentualPorCargo(funcionarios);
        assertEquals(11.11, percentualPorCargo.get(DepartamentoEnum.VENDAS), 0.01);
    }

    @Test
    @DisplayName("Testa o menor salário por cargo para ADMINISTRACAO")
    public void testMenorSalarioCargo() {
        BigDecimal menorSalario = Principal.menorSalarioCargo(DepartamentoEnum.ADMINISTRACAO, funcionarios);
        assertEquals(new BigDecimal("9000"), menorSalario);
    }

    @Test
    @DisplayName("Testa o maior salário por cargo para ADMINISTRACAO")
    public void testMaiorSalarioCargo() {
        BigDecimal maiorSalario = Principal.maiorSalarioCargo(DepartamentoEnum.ADMINISTRACAO, funcionarios);
        assertEquals(new BigDecimal("9400"), maiorSalario);
    }

    @Test
    @DisplayName("Testa a média salarial por cargo para ADMINISTRACAO")
    public void testMediaSalarioCargo() {
        BigDecimal mediaSalario = Principal.mediaSalarioCargo(DepartamentoEnum.ADMINISTRACAO, funcionarios);
        assertEquals(new BigDecimal("9200.00"), mediaSalario);
    }

    @Test
    @DisplayName("Testa a moda salarial por cargo para ADMINISTRACAO")
    public void testModaSalarioCargo() {
        BigDecimal modaSalario = Principal.modaSalarioCargo(DepartamentoEnum.ADMINISTRACAO, funcionarios);
        assertEquals(new BigDecimal("9200"), modaSalario);
    }

    @Test
    @DisplayName("Testa a mediana salarial por cargo para ADMINISTRACAO com número par de funcionários")
    public void testMedianaSalarioCargoPar() {
        BigDecimal medianaSalario = Principal.medianaSalarioCargo(DepartamentoEnum.ADMINISTRACAO, funcionarios);
        assertEquals(new BigDecimal("9200.00"), medianaSalario);
    }

    @Test
    @DisplayName("Testa a mediana salarial por cargo para ADMINISTRACAO com número ímpar de funcionários")
    public void testMedianaSalarioCargoImpar() {
        funcionarios.add(new Funcionario("Gabriela Cardoso", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("8500")));
        BigDecimal medianaSalario = Principal.medianaSalarioCargo(DepartamentoEnum.ADMINISTRACAO, funcionarios);
        assertEquals(new BigDecimal("9200"), medianaSalario);
    }

    @Test
    @DisplayName("Testa o tamanho da lista de funcionários para ADMINISTRACAO")
    public void testGetFuncionarioCargoAdministracaoSize() {
        List<Funcionario> administracao = Principal.getFuncionarioCargo(DepartamentoEnum.ADMINISTRACAO, funcionarios);
        assertEquals(4, administracao.size());
    }
    
    @Test
    @DisplayName("Testa o nome do primeiro funcionário para ADMINISTRACAO")
    public void testGetFuncionarioCargoAdministracaoNome() {
        List<Funcionario> administracao = Principal.getFuncionarioCargo(DepartamentoEnum.ADMINISTRACAO, funcionarios);
        assertEquals("João Silva", administracao.get(0).getNome());
    }
    
    @Test
    @DisplayName("Testa o tamanho da lista de funcionários para RH")
    public void testGetFuncionarioCargoRhSize() {
        List<Funcionario> rh = Principal.getFuncionarioCargo(DepartamentoEnum.RH, funcionarios);
        assertEquals(3, rh.size());
    }
    
    @Test
    @DisplayName("Testa o nome do primeiro funcionário para RH")
    public void testGetFuncionarioCargoRhNome() {
        List<Funcionario> rh = Principal.getFuncionarioCargo(DepartamentoEnum.RH, funcionarios);
        assertEquals("Maria Oliveira", rh.get(0).getNome());
    }

    @Test
    @DisplayName("Testa o departamento com o maior orçamento")
    public void testGetMaiorOrcamento() {
        Entry<DepartamentoEnum, BigDecimal> maiorOrcamento = Principal.getMaiorOrcamento(funcionarios);
        assertEquals(DepartamentoEnum.ADMINISTRACAO, maiorOrcamento.getKey());
        assertEquals(new BigDecimal("36800"), maiorOrcamento.getValue());
    }

    @Test
    @DisplayName("Testa o departamento com a maior média salarial")
    public void testMaiorMediaSalarial() {
        Entry<DepartamentoEnum, BigDecimal> maiorMediaSalarial = Principal.maiorMediaSalarial(funcionarios);
        assertEquals(DepartamentoEnum.ADMINISTRACAO, maiorMediaSalarial.getKey());
        assertEquals(new BigDecimal("9200"), maiorMediaSalarial.getValue());
    }

    @Test
    @DisplayName("Testa a montagem da resposta")
    public void testMontaResposta() {
        Principal.montaResposta(funcionarios);
    }
    
    @Test
    @DisplayName("Testa a carga de dados")
    public void testCargaDados() {
        CargaDados.getListaFuncionarios();
    }
    @Test
    @DisplayName("Testa NullPointerException para maioresSalarios com lista nula")
    public void testMaioresSalariosNull() {
        assertThrows(NullPointerException.class, () -> Principal.maioresSalarios(null));
    }

    @Test
    @DisplayName("Testa NullPointerException para getMediaPorCargo com lista nula")
    public void testGetMediaPorCargoNull() {
        assertThrows(NullPointerException.class, () -> Principal.getMediaPorCargo(null));
    }

    @Test
    @DisplayName("Testa NullPointerException para getImpactoReajuste com lista nula")
    public void testGetImpactoReajusteNull() {
        assertThrows(NullPointerException.class, () -> Principal.getImpactoReajuste(null));
    }

    @Test
    @DisplayName("Testa NullPointerException para getPercentualPorCargo com lista nula")
    public void testGetPercentualPorCargoNull() {
        assertThrows(NullPointerException.class, () -> Principal.getPercentualPorCargo(null));
    }

     @Test
    @DisplayName("Testa NullPointerException para getMaiorOrcamento com lista nula")
    public void testGetMaiorOrcamentoNull() {
        assertThrows(NullPointerException.class, () -> Principal.getMaiorOrcamento(null));
    }

    @Test
    @DisplayName("Testa NullPointerException para maiorMediaSalarial com lista nula")
    public void testMaiorMediaSalarialNull() {
        assertThrows(NullPointerException.class, () -> Principal.maiorMediaSalarial(null));
    }

    @Test
    @DisplayName("Testa NullPointerException para montaResposta com lista nula")
    public void testMontaRespostaNull() {
        assertThrows(NullPointerException.class, () -> Principal.montaResposta(null));
    }
}
