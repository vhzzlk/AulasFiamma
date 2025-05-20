package Exercicios;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercicio5Completo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Definição dos candidatos a mascote
        String[] candidatos = {"Leão", "Águia", "Tigre", "Lobo", "Golfinho"};

        // Mapa para armazenar os votos de cada candidato
        Map<String, Integer> votos = new HashMap<>();

        // Inicializa o contador de votos para cada candidato
        for (String candidato : candidatos) {
            votos.put(candidato, 0);
        }

        int totalVotos = 0;

        // Apresentação do sistema
        System.out.println("==== SISTEMA DE VOTAÇÃO PARA O MASCOTE DA TURMA ====");
        System.out.println("Candidatos disponíveis:");
        for (int i = 0; i < candidatos.length; i++) {
            System.out.println((i + 1) + " - " + candidatos[i]);
        }
        System.out.println("\nDigite o número ou o nome do candidato para votar.");
        System.out.println("Digite 'fim' para encerrar a votação e mostrar os resultados.");

        // Loop de votação
        while (true) {
            System.out.print("\nSeu voto: ");
            String voto = scanner.nextLine().trim();

            // Verifica se o usuário deseja encerrar a votação
            if (voto.equalsIgnoreCase("fim")) {
                break;
            }

            // Tenta converter o voto em número se for um dígito
            String candidatoEscolhido = null;
            try {
                int numeroVoto = Integer.parseInt(voto);
                if (numeroVoto >= 1 && numeroVoto <= candidatos.length) {
                    candidatoEscolhido = candidatos[numeroVoto - 1];
                }
            } catch (NumberFormatException e) {
                // Se não for um número, verifica se é o nome de um candidato
                for (String candidato : candidatos) {
                    if (candidato.equalsIgnoreCase(voto)) {
                        candidatoEscolhido = candidato;
                        break;
                    }
                }
            }

            // Registra o voto se for válido
            if (candidatoEscolhido != null) {
                votos.put(candidatoEscolhido, votos.get(candidatoEscolhido) + 1);
                totalVotos++;
                System.out.println("Voto registrado para " + candidatoEscolhido + "!");
            } else {
                System.out.println("Voto inválido! Por favor, digite o número ou o nome de um candidato válido.");
            }
        }

        // Apresenta os resultados
        System.out.println("\n==== RESULTADO DA VOTAÇÃO ====");
        System.out.println("Total de votos: " + totalVotos);

        if (totalVotos > 0) {
            // Encontra o vencedor
            String vencedor = null;
            int maiorQuantidadeVotos = 0;

            System.out.println("\nDistribuição dos votos:");
            for (String candidato : candidatos) {
                int votosRecebidos = votos.get(candidato);
                double percentual = (double) votosRecebidos / totalVotos * 100;
                System.out.printf("%s: %d votos (%.2f%%)\n", candidato, votosRecebidos, percentual);

                if (votosRecebidos > maiorQuantidadeVotos) {
                    maiorQuantidadeVotos = votosRecebidos;
                    vencedor = candidato;
                }
            }

            // Verifica se houve empate
            boolean empate = false;
            for (String candidato : candidatos) {
                if (!candidato.equals(vencedor) && votos.get(candidato) == maiorQuantidadeVotos) {
                    empate = true;
                    break;
                }
            }

            System.out.println("\n---- RESULTADO FINAL ----");
            if (empate) {
                System.out.println("Houve EMPATE na votação!");
                System.out.println("Candidatos empatados com " + maiorQuantidadeVotos + " votos:");
                for (String candidato : candidatos) {
                    if (votos.get(candidato) == maiorQuantidadeVotos) {
                        System.out.println("- " + candidato);
                    }
                }
            } else {
                System.out.println("O vencedor é: " + vencedor + " com " + maiorQuantidadeVotos + " votos!");
                double percentualVencedor = (double) maiorQuantidadeVotos / totalVotos * 100;
                System.out.printf("Percentual de votos do vencedor: %.2f%%\n", percentualVencedor);
            }
        } else {
            System.out.println("Nenhum voto foi registrado.");
        }

        scanner.close();
    }
}