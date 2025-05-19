package Exercicios;

public class Exercicio3Completo {

    public static boolean senhaValida(String senha) {
        if (senha == null || senha.isEmpty()) return false;

        boolean temMaiuscula = false;
        boolean temPrimo = false;
        boolean temEspecial = false;

        String especiais = "!@#$%^&*()_+-=<>?/{}[]|\\";
        String vogais = "aeiouAEIOU";

        for (int i = 0; i < senha.length(); i++) {
            char c = senha.charAt(i);

            // Verifica letra maiúscula
            if (Character.isUpperCase(c)) {
                temMaiuscula = true;
            }

            // Verifica número primo
            if (Character.isDigit(c)) {
                int num = c - '0';
                if (num == 2 || num == 3 || num == 5 || num == 7) {
                    temPrimo = true;
                }
            }

            // Verifica caractere especial
            if (especiais.indexOf(c) != -1) {
                temEspecial = true;
            }

            // Verifica vogais duplicadas seguidas
            if (i > 0 && vogais.indexOf(c) != -1 && senha.charAt(i - 1) == c) {
                return false; // Vogais duplicadas seguidas
            }
        }

        return temMaiuscula && temPrimo && temEspecial;
    }

    public static void main(String[] args) {
        String[] senhas = {"B7!tP", "A33aaa!", "c5*Oq", "Z2#b"};

        for (String senha : senhas) {
            System.out.println("Senha: " + senha + " → " + (senhaValida(senha) ? "VÁLIDA" : "INVÁLIDA"));
        }
    }
}

