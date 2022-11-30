package MapaSistemasII;

import java.util.ArrayList;
import java.util.Scanner;

public class MapaSistemasII extends Menu {

    public int escolha;

    public MapaSistemasII(int escolha) {
        super(escolha);
    }

    public static void main(String[] args) {

        Registro perfil = new Registro();
        Scanner informacao = new Scanner(System.in);
        ArrayList<Pessoa> pessoa = new ArrayList<Pessoa>();
        int escolha;

        // perfil.registo();

        do {

            System.out.println(
                    "| 1 - Vacinar Cidadão | 2 - Listar Cidadões Vacinados |" + "\n" + "| 3 -      Sair       |");
            escolha = informacao.nextInt();

            Menu menu = new Menu(escolha);

            menu.sistema();

        } while (escolha != 3);

        informacao.close();
    }
}
