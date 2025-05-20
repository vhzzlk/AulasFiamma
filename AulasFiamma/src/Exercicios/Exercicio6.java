package Exercicios;

import java.util.Arrays;

public class Exercicio6 {
    public static void main(String[] args) {
        // Exemplo da entrada fornecida
        String[] codigosMisteriosos = {"4H", "7A", "2C"};

        // Chamando o método que decodifica os códigos
        String resultado = decodificarCodigos(codigosMisteriosos);

        // Exibindo os resultados
        System.out.println("==== A ILHA DOS CÓDIGOS PERDIDOS ====");
        System.out.println("Códigos misteriosos: " + Arrays.toString(codigosMisteriosos));
        System.out.println("Código decifrado: " + resultado);

        // Testando com outros exemplos
        testarOutrosExemplos();
    }

    /**
     * Decodifica um array de códigos misteriosos.
     * Cada código consiste em um número seguido por uma letra.
     * O número indica quantas vezes a letra deve ser repetida.
     *
     * @param codigos Array de strings com os códigos no formato "NL" onde N é um número e L é uma letra
     * @return String com o código decodificado
     */
    public static String decodificarCodigos(String[] codigos) {
        StringBuilder resultado = new StringBuilder();

        for (String codigo : codigos) {
            // Verifica se o código tem o formato esperado
            if (codigo.length() >= 2) {
                try {
                    // Extrai o número e a letra do código
                    // Assumimos que o último caractere é a letra e o resto é o número
                    String numeroStr = codigo.substring(0, codigo.length() - 1);
                    char letra = codigo.charAt(codigo.length() - 1);
                    int repeticoes = Integer.parseInt(numeroStr);

                    // Adiciona a letra ao resultado o número de vezes especificado
                    for (int i = 0; i < repeticoes; i++) {
                        resultado.append(letra);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Erro ao processar o código: " + codigo);
                    System.out.println("O código deve começar com um número válido.");
                }
            } else {
                System.out.println("Código ignorado (formato inválido): " + codigo);
            }
        }

        return resultado.toString();
    }

    /**
     * Método para testar o decodificador com exemplos adicionais
     */
    public static void testarOutrosExemplos() {
        // Testes adicionais para verificar o funcionamento da função
        String[][] testeCasos = {
                {"10X", "1Y", "5Z"},            // Teste com números maiores
                {"1A", "2B", "3C", "4D", "5E"}, // Teste com mais elementos
                {"0A", "3B"},                   // Teste com zero repetições
                {"42*"}                         // Teste com caractere especial
        };

        System.out.println("\n==== TESTES ADICIONAIS ====");

        for (int i = 0; i < testeCasos.length; i++) {
            String[] caso = testeCasos[i];
            String resultado = decodificarCodigos(caso);

            System.out.println("Teste " + (i + 1) + ":");
            System.out.println("  Entrada: " + Arrays.toString(caso));
            System.out.println("  Saída: " + resultado);
        }
    }
}