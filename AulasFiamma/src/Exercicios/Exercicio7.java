package Exercicios;

import java.util.Arrays;
import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        // Lista ordenada de feitiços
        String[] feiticos = {
                "Aceleratio",
                "Defensio",
                "Expelliarmus",
                "Lumos",
                "Wingardium Leviosa"
        };

        System.out.println("==== BUSCA BINÁRIA NO MUNDO DOS FEITIÇOS ====");
        System.out.println("Lista de feitiços disponíveis:");
        imprimirFeiticos(feiticos);

        // Demonstração com o exemplo fornecido
        String feiticoProcurado = "Expelliarmus";
        int posicao = buscaBinaria(feiticos, feiticoProcurado);

        System.out.println("\nExemplo de busca automática:");
        System.out.println("Procurando pelo feitiço: " + feiticoProcurado);
        mostrarResultado(feiticoProcurado, posicao);

        // Permitir ao usuário buscar feitiços
        buscarFeiticosInterativamente(feiticos);
    }

    /**
     * Implementação do algoritmo de busca binária para encontrar um feitiço na lista ordenada
     *
     * @param feiticos Array ordenado de feitiços
     * @param alvo Feitiço a ser procurado
     * @return Índice do feitiço encontrado ou -1 se não encontrado
     */
    public static int buscaBinaria(String[] feiticos, String alvo) {
        int inicio = 0;
        int fim = feiticos.length - 1;

        while (inicio <= fim) {
            // Calcula o ponto médio da região de busca atual
            int meio = inicio + (fim - inicio) / 2;

            // Compara o feitiço do meio com o alvo
            int comparacao = alvo.compareTo(feiticos[meio]);

            // Exibe o passo atual da busca (para fins didáticos)
            System.out.println("  Comparando com: " + feiticos[meio] + " na posição " + meio);

            // Verifica se encontramos o feitiço
            if (comparacao == 0) {
                return meio; // Feitiço encontrado
            }

            // Decide qual metade da lista explorar
            if (comparacao > 0) {
                // O feitiço procurado vem depois na ordem alfabética
                inicio = meio + 1;
                System.out.println("  O feitiço procurado está à direita");
            } else {
                // O feitiço procurado vem antes na ordem alfabética
                fim = meio - 1;
                System.out.println("  O feitiço procurado está à esquerda");
            }
        }

        // Feitiço não encontrado
        return -1;
    }

    /**
     * Exibe o resultado da busca
     *
     * @param feitico Nome do feitiço procurado
     * @param posicao Posição onde foi encontrado (ou -1)
     */
    public static void mostrarResultado(String feitico, int posicao) {
        if (posicao != -1) {
            System.out.println("Feitiço encontrado na posição " + posicao);
        } else {
            System.out.println("O feitiço \"" + feitico + "\" não foi encontrado no grimório.");
        }
    }

    /**
     * Imprime a lista de feitiços com suas posições
     *
     * @param feiticos Array de feitiços
     */
    public static void imprimirFeiticos(String[] feiticos) {
        for (int i = 0; i < feiticos.length; i++) {
            System.out.println("  [" + i + "] " + feiticos[i]);
        }
    }

    /**
     * Permite ao usuário buscar feitiços interativamente
     *
     * @param feiticos Array ordenado de feitiços
     */
    public static void buscarFeiticosInterativamente(String[] feiticos) {
        Scanner scanner = new Scanner(System.in);
        String feitico;

        System.out.println("\n---- MODO INTERATIVO ----");
        System.out.println("Digite o nome do feitiço que deseja encontrar (ou 'sair' para encerrar):");

        while (true) {
            System.out.print("\nFeitiço: ");
            feitico = scanner.nextLine().trim();

            if (feitico.equalsIgnoreCase("sair")) {
                break;
            }

            if (feitico.isEmpty()) {
                System.out.println("Por favor, digite um nome de feitiço válido.");
                continue;
            }

            // Busca o feitiço
            int posicao = buscaBinaria(feiticos, feitico);
            mostrarResultado(feitico, posicao);
        }

        System.out.println("Grimório fechado. Até a próxima, bruxo(a)!");
        scanner.close();
    }
}