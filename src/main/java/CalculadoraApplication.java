import Aplicacao.Calculadora;
import Aplicacao.Operacoes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CalculadoraApplication {
    private static final Logger logger = LoggerFactory.getLogger(CalculadoraApplication.class);


    public static void main(String[] args) {
        Queue<Operacoes> filaOperacoes = new LinkedList<>();
        filaOperacoes.add(new Operacoes(14, 8, '-'));
        filaOperacoes.add(new Operacoes(5, 6, '*'));
        filaOperacoes.add(new Operacoes(2147483647, 2, '+'));
        filaOperacoes.add(new Operacoes(18, 3, '/')); // Implementando o cálculo de divisão

        Calculadora calculadora = new Calculadora();
        Stack<Double> resultadoCalculos = new Stack<>(); // Criando a pilha para armazenar os resultados

        DecimalFormat decimalFormat = new DecimalFormat("#.##"); // Formato para duas casas decimais

        logger.info("Iniciando processamento das operações.");

        while (!filaOperacoes.isEmpty()) {
            Operacoes operacao = filaOperacoes.poll();
            logger.info("Processando operação: {} {} {}", operacao.getValorA(), operacao.getOperador(), operacao.getValorB());
            calculadora.calcular(operacao);
            // Ajustando a formatação para imprimir o resultado sem zeros à direita
            String resultadoFormatado = decimalFormat.format(operacao.getResultado());
            System.out.printf("%d %c %d = %s%n", operacao.getValorA(), operacao.getOperador(), operacao.getValorB(), resultadoFormatado);

            logger.info("Resultado da operação: {}", resultadoFormatado);

            // Imprimindo a lista de operações a serem processadas após cada cálculo
            System.out.println("Lista de operações a serem processadas:");
            filaOperacoes.forEach(op -> System.out.printf("%d %c %d%n", op.getValorA(), op.getOperador(), op.getValorB()));
            System.out.println();

            resultadoCalculos.push(Double.parseDouble(resultadoFormatado)); // Armazenando o resultado na pilha
        }

        logger.info("Processamento das operações concluído.");


        // Imprimindo a pilha ao final
        System.out.println("Resultado de cada cálculo:");
        while (!resultadoCalculos.isEmpty()) {
            double resultado = resultadoCalculos.pop();
            System.out.println(decimalFormat.format(resultado)); // Formatação para remover zeros desnecessários
        }
    }

}



