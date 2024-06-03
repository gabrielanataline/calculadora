package Aplicacao;

public class Operacoes {
    private long valorA;
    private char operador;
    private long valorB;
    private double resultado;

    public Operacoes(long valorA, long valorB, char operador) {
        this.valorA = valorA;
        this.valorB = valorB;
        this.operador = operador;
    }

    public long getValorA() {
        return valorA;
    }

    public void setValorA(long valorA) {
        this.valorA = valorA;
    }

    public char getOperador() {
        return operador;
    }

    public void setOperador(char operador) {
        this.operador = operador;
    }

    public long getValorB() {
        return valorB;
    }

    public void setValorB(long valorB) {
        this.valorB = valorB;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
}