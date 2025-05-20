package Exercicios;

import java.util.*;

public class Exercicio4Completo {

    // Agora as variáveis são globais e estáticas
    static double pesoForca = 0.4;
    static double pesoInteligencia = 0.3;
    static double pesoVelocidade = 0.3;

    static class Hero {
        String nome;
        int forca, inteligencia, velocidade;

        Hero(String nome, int forca, int inteligencia, int velocidade) {
            this.nome = nome;
            this.forca = forca;
            this.inteligencia = inteligencia;
            this.velocidade = velocidade;
        }

        double calcularPoder() {
            return (forca * pesoForca) + (inteligencia * pesoInteligencia) + (velocidade * pesoVelocidade);
        }

        public String toString() {
            return nome + " [Força: " + forca + ", Inteligência: " + inteligencia + ", Velocidade: " + velocidade + "]";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Hero> herois = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Ranking de Super-Heróis ---");
            System.out.println("1. Adicionar herói");
            System.out.println("2. Listar heróis");
            System.out.println("3. Comparar dois heróis");
            System.out.println("4. Configurar fórmula de poder");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            int opcao = sc.nextInt();
            sc.nextLine(); // Limpa buffer

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Força (0-100): ");
                    int forca = sc.nextInt();
                    System.out.print("Inteligência (0-100): ");
                    int inteligencia = sc.nextInt();
                    System.out.print("Velocidade (0-100): ");
                    int velocidade = sc.nextInt();
                    sc.nextLine();
                    herois.add(new Hero(nome, forca, inteligencia, velocidade));
                    System.out.println("Herói adicionado!");
                }

                case 2 -> {
                    if (herois.isEmpty()) {
                        System.out.println("Nenhum herói cadastrado.");
                        break;
                    }
                    herois.stream()
                            .sorted(Comparator.comparingDouble(h -> -h.calcularPoder()))
                            .forEach(h -> System.out.printf("%s - Poder Total: %.2f%n", h, h.calcularPoder()));
                }

                case 3 -> {
                    System.out.print("Nome do primeiro herói: ");
                    String nome1 = sc.nextLine();
                    System.out.print("Nome do segundo herói: ");
                    String nome2 = sc.nextLine();

                    Hero h1 = encontrarHeroi(herois, nome1);
                    Hero h2 = encontrarHeroi(herois, nome2);

                    if (h1 == null || h2 == null) {
                        System.out.println("Um dos heróis não foi encontrado.");
                        break;
                    }

                    double p1 = h1.calcularPoder();
                    double p2 = h2.calcularPoder();

                    System.out.printf("%s: %.2f%n", h1.nome, p1);
                    System.out.printf("%s: %.2f%n", h2.nome, p2);

                    if (p1 > p2)
                        System.out.println(h1.nome + " é mais poderoso.");
                    else if (p2 > p1)
                        System.out.println(h2.nome + " é mais poderoso.");
                    else
                        System.out.println("Os dois heróis têm o mesmo poder.");
                }

                case 4 -> {
                    System.out.print("Novo peso Força: ");
                    pesoForca = sc.nextDouble();
                    System.out.print("Novo peso Inteligência: ");
                    pesoInteligencia = sc.nextDouble();
                    System.out.print("Novo peso Velocidade: ");
                    pesoVelocidade = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Fórmula atualizada!");
                }

                case 0 -> {
                    System.out.println("Saindo...");
                    return;
                }

                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static Hero encontrarHeroi(List<Hero> lista, String nome) {
        for (Hero h : lista) {
            if (h.nome.equalsIgnoreCase(nome)) {
                return h;
            }
        }
        return null;
    }
}
