package Exercicios;

import java.util.Scanner;
import java.util.Random;

public class Exercicio2Completo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean continuar = true;

        while (continuar) {
            String[] opcoes = {"Pedra", "Papel", "Tesoura", "Lagarto", "Spock"};

            System.out.println("=== Pedra, Papel, Tesoura, Lagarto e Spock ===");
            System.out.println("Escolha uma opção:");
            for (int i = 0; i < opcoes.length; i++) {
                System.out.println(i + " - " + opcoes[i]);
            }

            System.out.print("Sua escolha: ");
            int escolhaUsuario = scanner.nextInt();

            if (escolhaUsuario < 0 || escolhaUsuario >= opcoes.length) {
                System.out.println("Escolha inválida!");
                continue; // volta para o início do loop sem encerrar o programa
            }

            int escolhaComputador = random.nextInt(5);

            System.out.println("Você escolheu: " + opcoes[escolhaUsuario]);
            System.out.println("Computador escolheu: " + opcoes[escolhaComputador]);

            if (escolhaUsuario == escolhaComputador) {
                System.out.println("Empate!");
            } else if (venceu(escolhaUsuario, escolhaComputador)) {
                System.out.println("Você venceu!");
            } else {
                System.out.println("Você perdeu!");
            }

            System.out.print("Você deseja continuar? (s/n): ");
            continuar = scanner.next().equalsIgnoreCase("s");
        }

        scanner.close(); // fechado fora do loop
    }

    // Método que define as regras do jogo
    public static boolean venceu(int jogador, int computador) {
        return (jogador == 0 && (computador == 2 || computador == 3)) || // Pedra vence Tesoura e Lagarto
                (jogador == 1 && (computador == 0 || computador == 4)) || // Papel vence Pedra e Spock
                (jogador == 2 && (computador == 1 || computador == 3)) || // Tesoura vence Papel e Lagarto
                (jogador == 3 && (computador == 1 || computador == 4)) || // Lagarto vence Papel e Spock
                (jogador == 4 && (computador == 0 || computador == 2));   // Spock vence Pedra e Tesoura
    }
}
