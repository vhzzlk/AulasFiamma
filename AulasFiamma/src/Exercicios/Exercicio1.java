package Exercicios;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double moedas = 0;
        double quantasMoedas;
        double qualMoedas;

        double tirarMoedas;
        boolean continuar = true;
        while (continuar) {
        System.out.println("----Bem vindo ao Cofrinho----");
        System.out.println("1-) Colocar moedas no Cofre");
        System.out.println("2-) Tirar moedas do Cofre");
        System.out.println("3-) Ver quantos moedas tem o Cofre");
        System.out.println("4-) Quantas moedas falta pra 100");
            System.out.println("5-)");
        int opcao = sc.nextInt();


        switch (opcao) {
            case 1:
                System.out.println("Quantas moedas você deseja colocar?");
                quantasMoedas = sc.nextDouble();
                System.out.println("Moeda de quantos centavos?(0,01 | 0,05 | 0,10 | 0,25 | 0,50 | 1,00 )");
                qualMoedas = sc.nextDouble();
                quantasMoedas *= qualMoedas ;
                moedas += quantasMoedas;
                break;
            case 2:
                System.out.println("Quantas moedas você deseja tirar?");
                 tirarMoedas = sc.nextDouble();
                System.out.println("Moeda de quantos centavos?(0,01 | 0,05 | 0,10 | 0,25 | 0,50 | 1,00 )");
                qualMoedas = sc.nextDouble();
                tirarMoedas *= qualMoedas ;
                if (tirarMoedas < moedas) {
                    System.out.printf("Você conseguiu tirar a quantidade  de %.2f  do Cofre\n", tirarMoedas);
                    moedas -= tirarMoedas = moedas;
                } else {
                    System.err.println("Erro: Você não tem essa quantidade de moedas");
                    continuar = false;
                }
                break;
                case 3:
                    System.out.printf("%.2f\n" ,moedas);
                    break;
                    case 4:
                        moedas = 100 - moedas;

                        System.out.printf("Faltam R$ %.2f\n" , moedas );
                        break;
            default:
                System.err.println("Opção invalida!!! Tente novamente!");
        }
            System.out.println("Você deseja continuar?(s/n)");
        continuar = sc.next().equalsIgnoreCase("s");
        }


    }
}
