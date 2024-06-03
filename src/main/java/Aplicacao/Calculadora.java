package Aplicacao;

import java.util.logging.Logger;

public class Calculadora {
    public Operacoes calcular(Operacoes operacao) {
        switch (operacao.getOperador()) {
            case '+':
                operacao.setResultado(soma(operacao));
                break;
            case '-':
                operacao.setResultado(subtracao(operacao));
                break;
            case '*':
                operacao.setResultado(multiplicacao(operacao));
                break;
            case '/':
                if (operacao.getValorB() != 0) {
                    operacao.setResultado(divisao(operacao));
                } else {
                    throw new ArithmeticException("Divisão por zero");
                }
                break;
            default:
                operacao.setResultado(0);
                break;
        }
        return operacao;
    }

    public long soma(Operacoes operacao) {
        return operacao.getValorA() + operacao.getValorB();
    }

    public long subtracao(Operacoes operacao) {
        return operacao.getValorA() - operacao.getValorB();
    }

    public long multiplicacao(Operacoes operacao) {
        return operacao.getValorA() * operacao.getValorB();
    }

    public double divisao(Operacoes operacao) {
        return (double) operacao.getValorA() / operacao.getValorB();
    }
}
