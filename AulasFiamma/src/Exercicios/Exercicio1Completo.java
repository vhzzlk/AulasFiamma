package Exercicios;

    import java.util.Scanner;
import java.text.DecimalFormat;

public class Exercicio1Completo {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            DecimalFormat df = new DecimalFormat("0.00");

            // Valores das moedas
            double[] valoresMoedas = {0.01, 0.05, 0.10, 0.25, 0.50, 1.00};
            int[] quantidades = new int[valoresMoedas.length];
            double total = 0;

            System.out.println("=== Simulador de Cofrinho Inteligente ===");
            System.out.println("Informe quantas moedas você inseriu no cofre:");

            // Coleta as quantidades
            for (int i = 0; i < valoresMoedas.length; i++) {
                System.out.print("Moedas de R$ " + df.format(valoresMoedas[i]) + ": ");
                quantidades[i] = scanner.nextInt();
                total += quantidades[i] * valoresMoedas[i];
            }

            // Mostra o total
            System.out.println("\nTotal depositado: R$ " + df.format(total));

            // Diferença até R$ 100
            double meta = 100.00;
            if (total >= meta) {
                System.out.println("Parabéns! Você já atingiu ou superou a meta de R$ 100!");
            } else {
                double falta = meta - total;
                System.out.println("Faltam R$ " + df.format(falta) + " para atingir R$ 100.");
            }

            // Estimativa de tempo
            if (total > 0 && total < meta) {
                int semanas = (int) Math.ceil(meta / total);
                System.out.println("Se repetir este depósito toda semana, levará aproximadamente " + semanas + " semana(s) para atingir R$ 100.");
            } else if (total == 0) {
                System.out.println("Depósito zero. Comece a economizar para ver projeções semanais.");
            }

            scanner.close();
        }
    }

