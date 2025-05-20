package Exercicios;

import java.util.Scanner;
import java.util.Random;

public class Exercicio8Completo {
    // Constante para a margem de erro máxima (1%)
    private static final double MARGEM_ERRO_MAX = 0.01;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("==== CALCULADORA DE CÁLCULOS MATEMATICAMENTE ERRADOS ====");
        System.out.println("Esta calculadora tem um erro proposital de até 1% no resultado!");
        System.out.println("Operações disponíveis: +, -, *, /");
        System.out.println("Digite 'sair' para encerrar o programa.");

        while (true) {
            try {
                // Obtém o primeiro número
                System.out.print("\nDigite o primeiro número: ");
                String entrada = scanner.nextLine().trim();

                if (entrada.equalsIgnoreCase("sair")) {
                    break;
                }

                double numero1 = Double.parseDouble(entrada);

                // Obtém a operação
                System.out.print("Digite a operação (+, -, *, /): ");
                String operacao = scanner.nextLine().trim();

                // Obtém o segundo número
                System.out.print("Digite o segundo número: ");
                double numero2 = Double.parseDouble(scanner.nextLine().trim());

                // Calcula o resultado correto
                double resultadoCorreto = calcularResultadoCorreto(numero1, numero2, operacao);

                // Aplica o erro proposital aleatório
                double resultadoComErro = aplicarErroProposital(resultadoCorreto, random);

                // Calcula o percentual de erro real aplicado
                double percentualErroAplicado = calcularPercentualErro(resultadoCorreto, resultadoComErro);

                // Exibe os resultados
                System.out.println("\n=== RESULTADO ===");
                System.out.printf("Cálculo: %.2f %s %.2f\n", numero1, operacao, numero2);
                System.out.printf("Resultado correto: %.4f\n", resultadoCorreto);
                System.out.printf("Resultado com erro: %.4f\n", resultadoComErro);
                System.out.printf("Erro aplicado: %.4f%% (máximo permitido: 1%%)\n", percentualErroAplicado * 100);

            } catch (NumberFormatException e) {
                System.out.println("Erro: Por favor, insira um número válido.");
            } catch (ArithmeticException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        }

        System.out.println("Calculadora encerrada. Obrigado por usar!");
        scanner.close();
    }

    /**
     * Calcula o resultado matematicamente correto da operação
     *
     * @param n1 Primeiro número
     * @param n2 Segundo número
     * @param op Operação matemática (+, -, *, /)
     * @return Resultado da operação
     * @throws ArithmeticException Se houver uma operação inválida (como divisão por zero)
     */
    private static double calcularResultadoCorreto(double n1, double n2, String op) throws ArithmeticException {
        switch (op) {
            case "+":
                return n1 + n2;
            case "-":
                return n1 - n2;
            case "*":
                return n1 * n2;
            case "/":
                if (n2 == 0) {
                    throw new ArithmeticException("Divisão por zero não é permitida!");
                }
                return n1 / n2;
            default:
                throw new ArithmeticException("Operação inválida! Use +, -, * ou /");
        }
    }

    /**
     * Aplica um erro aleatório de até 1% no resultado
     *
     * @param resultadoCorreto O resultado correto do cálculo
     * @param random Gerador de números aleatórios
     * @return Resultado com erro aplicado
     */
    private static double aplicarErroProposital(double resultadoCorreto, Random random) {
        // Gera um fator de erro aleatório entre -1% e +1%
        double fatorErro = (random.nextDouble() * 2 * MARGEM_ERRO_MAX) - MARGEM_ERRO_MAX;

        // Calcula o valor do erro
        double valorErro = resultadoCorreto * fatorErro;

        // Retorna o resultado com o erro aplicado
        return resultadoCorreto + valorErro;
    }

    /**
     * Calcula o percentual de erro aplicado ao resultado
     *
     * @param resultadoCorreto O resultado matematicamente correto
     * @param resultadoComErro O resultado com erro aplicado
     * @return Percentual de erro (em decimal)
     */
    private static double calcularPercentualErro(double resultadoCorreto, double resultadoComErro) {
        if (resultadoCorreto == 0) {
            // Evita divisão por zero
            return 0;
        }

        return Math.abs((resultadoComErro - resultadoCorreto) / resultadoCorreto);
    }

    /**
     * Método para testar a calculadora com valores fixos
     * (utilizado para verificação do funcionamento)
     */
    private static void testeCalculadora() {
        double[][] testeCasos = {
                {10, 5, 1}, // 10 + 5 (código de operação 1 para soma)
                {20, 7, 2}, // 20 - 7 (código de operação 2 para subtração)
                {8, 4, 3},  // 8 * 4 (código de operação 3 para multiplicação)
                {15, 3, 4}  // 15 / 3 (código de operação 4 para divisão)
        };

        String[] operacoes = {"+", "-", "*", "/"};
        Random random = new Random(42); // Seed fixa para testes reproduzíveis

        System.out.println("\n==== TESTES DA CALCULADORA ====");

        for (double[] caso : testeCasos) {
            double n1 = caso[0];
            double n2 = caso[1];
            int opIndice = (int)caso[2] - 1;
            String op = operacoes[opIndice];

            double resultadoCorreto = calcularResultadoCorreto(n1, n2, op);
            double resultadoComErro = aplicarErroProposital(resultadoCorreto, random);
            double percentualErro = calcularPercentualErro(resultadoCorreto, resultadoComErro);

            System.out.printf("Cálculo: %.2f %s %.2f\n", n1, op, n2);
            System.out.printf("Correto: %.4f | Com erro: %.4f | Erro: %.4f%%\n\n",
                    resultadoCorreto, resultadoComErro, percentualErro * 100);
        }
    }
}