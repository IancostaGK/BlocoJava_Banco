package Banco;

import Banco.Models.Conta;
import Banco.Models.Conta_PF;
import Banco.Models.Conta_PJ;
import Banco.Models.Transacao;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Objects;
import java.util.Scanner;

public class Arquivo {
    public static void ler_arquivo(ArrayList<Conta> lista){
        try {
            File file = new File("Arquivos_txt/contas.txt");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String linha = myReader.nextLine();
                String[] separador_de_string = linha.split(" ");
                if (Objects.equals(separador_de_string[0], "1")){
                    Criar_conta_pf(lista, separador_de_string);
                }else if(Objects.equals(separador_de_string[0], "2")){
                    Criar_conta_pj(lista, separador_de_string);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        }
    }

    private static void Criar_conta_pj(ArrayList<Conta> lista, String[] separador_de_string) {
        Conta_PJ conta = new Conta_PJ(separador_de_string[1],
                separador_de_string[2],
                separador_de_string[3],
                Double.parseDouble(separador_de_string[4]));
        lista.add(conta);
    }

    private static void Criar_conta_pf(ArrayList<Conta> lista, String[] separador_de_string) {
        Conta conta = new Conta_PF(separador_de_string[1],
                separador_de_string[2] + " " + separador_de_string[3],
                separador_de_string[4],
                Double.parseDouble(separador_de_string[5]),
                Double.parseDouble(separador_de_string[6]));
        lista.add(conta);
    }

    public static Formatter abrirGravacao() {
        Formatter saida = null;
        try {
            saida = new Formatter("Arquivos_txt/transacoes.txt");
        }
        catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        }
        return saida;
    }

    public static void Escrever_aqruivo(Formatter saida, ArrayList<Transacao> lista_transcao) {
        for (Transacao t : lista_transcao) {
            saida.format("%s\n", t.toString());
        }
        saida.close();
    }
}