package MapaSistemasII;

import java.util.Scanner;

public class Registro {

    protected String nome;
    protected String cpf;

    public void registo() {

        int exit;

        Scanner informacao = new Scanner(System.in);

        try {

            System.out.println("Informe o nome da enfermeira(o) responsável pela vacinação: ");
            this.nome = informacao.nextLine();

            do {
                System.out.println("Informe o cpf da enfermeira(o) responsável pela vacinação: (Somnete números)");
                this.cpf = informacao.nextLine();

                if (getCPF().length() != 11) {
                    System.out.println("CPF Inválido");
                    exit = 0;
                } else {
                    exit = 1;
                }

            } while (exit == 0);

        } catch (Exception e) {
            System.out.println("\n" + "CPF inválido !! " + "\n\n" + "Finalizando execução");
            System.exit(0);
        }
    }

    public String getCPF() {
        return this.cpf;
    }

    public String getNome() {
        return this.nome;
    }
}