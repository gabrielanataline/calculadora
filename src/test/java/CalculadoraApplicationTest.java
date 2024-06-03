import Aplicacao.Calculadora;
import Aplicacao.Operacoes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculadoraApplicationTest {

    Calculadora calculadora = new Calculadora();

    @Test
    public void testSoma() {
        Operacoes operacao = new Operacoes(3, 2, '+');
        calculadora.calcular(operacao);
        assertEquals(5, operacao.getResultado(), 0.001);
    }

    @Test
    public void testSubtracao() {
        Operacoes operacao = new Operacoes(5, 3, '-');
        calculadora.calcular(operacao);
        assertEquals(2, operacao.getResultado(), 0.001);
    }

    @Test
    public void testMultiplicacao() {
        Operacoes operacao = new Operacoes(4, 3, '*');
        calculadora.calcular(operacao);
        assertEquals(12, operacao.getResultado(), 0.001);
    }

    @Test
    public void testDivisao() {
        Operacoes operacao = new Operacoes(9, 3, '/');
        calculadora.calcular(operacao);
        assertEquals(3, operacao.getResultado(), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisaoPorZero() {
        Operacoes operacao = new Operacoes(1, 0, '/');
        calculadora.calcular(operacao);
    }

}