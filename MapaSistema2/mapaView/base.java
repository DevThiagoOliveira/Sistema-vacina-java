package MapaSistema2.mapaView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import MapaSistema2.mapaModel.Infermeira;
import MapaSistema2.mapaModel.Pessoa;

public class base {
    public static void main(String[] args) {

        // objetos
        Infermeira infermeira = new Infermeira();
        Pessoa pessoa = new Pessoa();

        // variaveis
        int exit = 0, escolha;
        ArrayList<String> dataVacinacao = new ArrayList<String>();
        ArrayList<String> arrayPessoa = new ArrayList<String>();

        Scanner informacao = new Scanner(System.in);

        System.out.println("Informe o nome da enfermeira(o) responsável pela vacinação: ");
        infermeira.setNome(informacao.nextLine());

        do {
            System.out.println("Informe o cpf da enfermeira(o) responsável pela vacinação: (Somnete números)");
            infermeira.setCpf(informacao.nextBigInteger());

            exit = cpfValidador(exit, infermeira.getCpf());

        } while (exit != 0);

        System.out.println("\nBem Vindo(a) " + infermeira.getNome() + "\n" + "CPF: " + infermeira.getCpf() + "\n");

        do {

            System.out.println(
                    "| 1 - Vacinar Cidadão | 2 - Listar Cidadões Vacinados |" + "\n" + "| 3 -      Sair       |");
            escolha = informacao.nextInt();

            if (escolha == 1) {

                do {
                    System.out.println("Informe o CPF do cidadão: ");
                    pessoa.setCpf(informacao.nextBigInteger());

                    exit = cpfValidador(exit, pessoa.getCpf());

                } while (exit != 0);

                informacao = new Scanner(System.in);

                System.out.println("Informe o nome do cidadão: ");
                pessoa.setNome(informacao.nextLine());

                for (int contador = 0; contador < 4; contador++) {
                    System.out.println(
                            "Informe a data da " + (contador + 1) + "ª dose do cidadão: (Exemplo:. Dia/Mes/Ano)");
                    dataVacinacao.add(informacao.nextLine());

                    if ((dataVacinacao.get(contador).length() != 10)) {
                        System.out.println("Data Invalida");
                        break;
                    }

                    SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

                    try {
                        Date dataInformada = formatador.parse(dataVacinacao.get(contador));

                        Calendar calendar = new GregorianCalendar();

                        calendar.setTime(dataInformada);

                        if (dataVacinacao.size() >= 2) {

                            Date proximaData = formatador.parse(dataVacinacao.get(contador - 1));
                            Calendar calendar2 = new GregorianCalendar();

                            calendar2.setTime(proximaData);

                            Calendar startCalendar = new GregorianCalendar();

                            startCalendar.setTime(dataInformada);

                            Calendar endCalendar = new GregorianCalendar();

                            endCalendar.setTime(proximaData);

                            int ano = (endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR)) * (-1);
                            int mes = (ano * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH))
                                    * (-1);

                            if (ano <= 0) {
                                if (mes < 4) {
                                    System.out.println(
                                            "Data de vacinação não condiz com 4 meses de diferença entre elas, você não tem dirento a uma nova dose");
                                    break;
                                }
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

                if (dataVacinacao.size() == 4) {

                    arrayPessoa.add(
                            "\n" + "Nome: " + pessoa.getNome() + "\n" +
                                    "CPF: " + pessoa.getCpf() + "\n" +
                                    "1ª Data: " + dataVacinacao.get(0) + "\n" +
                                    "2ª Data: " + dataVacinacao.get(1) + "\n" +
                                    "3ª Data: " + dataVacinacao.get(2) + "\n" +
                                    "4ª Data: " + dataVacinacao.get(3) + "\n" +
                                    "\n");

                    dataVacinacao.clear();
                }
            }

            if (escolha == 2) {
                if (arrayPessoa.size() <= 0) {
                    System.out.println("Não a registros de cidadões vacinados");
                }

                for (String vacinados : arrayPessoa) {
                    System.out.println(vacinados);
                }
            }

        } while (escolha != 3);

        informacao.close();
    }

    public static int cpfValidador(int _exit, String _objetoCpf) {
        if (_objetoCpf.length() != 11) {
            System.out.println("CPF Inválido");
            _exit = 1;
        } else {
            _exit = 0;
        }

        return _exit;
    }
}
