package Banco;

import Banco.Models.Conta;
import Banco.Models.Conta_PF;
import Banco.Models.Conta_PJ;
import java.util.ArrayList;

public class CriaContas {
    public static void criar_conta(ArrayList<Conta> lista) {
        double saldo;
        String numero_conta = ValidacoesInput.perguntar_String("Digite o numero da conta:");
        if(conta_nao_existe(lista, numero_conta)){
            int codigo = ValidacoesInput.perguntar_codigo("Digite o codigo da conta:");
            switch (codigo) {
                case 1:
                    saldo = ValidacoesInput.perguntar_double("Digite o saldo: ");
                    CriarContaTipoPF(lista, numero_conta, saldo);
                    break;
                case 2:
                    saldo = ValidacoesInput.perguntar_double("Digite o saldo: ");
                    CriarContaTipoPJ(lista, numero_conta, saldo);
                    break;
                default:
                    System.out.println("Codigo invalido!");
            }
        } else
            System.out.println("Conta ja existente!");
    }

    private static void CriarContaTipoPJ(ArrayList<Conta> lista, String numero_conta, double saldo) {
        String nome_empresa = ValidacoesInput.perguntar_String("Digite o nome da empresa:");
        String cnpj = ValidacoesInput.perguntar_String("Digite o cnpj:");
        if (dados_sao_validos_PJ(saldo, numero_conta, cnpj)) {
            Conta_PJ conta = new Conta_PJ(numero_conta, nome_empresa, cnpj, saldo);
            System.out.println("Conta criada com sucesso!");
            lista.add(conta);
        } else
            System.out.println("Dados invalidos!");
    }

    private static void CriarContaTipoPF(ArrayList<Conta> lista, String numero_conta, double saldo) {
        double cheque_especial = ValidacoesInput.perguntar_double("Digite o cheque especial: ");
        String nome = ValidacoesInput.perguntar_String("Digite o seu nome: ");
        nome = nome + " " + ValidacoesInput.perguntar_String("Digite o seu sobrenome: ");
        String cpf = ValidacoesInput.perguntar_String("Digite o seu CPF: ");
        if (dados_sao_validos_PF(saldo, cheque_especial, numero_conta, cpf)) {
            Conta_PF conta = new Conta_PF(numero_conta, nome, cpf, saldo, cheque_especial);
            System.out.println("Conta criada com sucesso!");
            lista.add(conta);
        } else
            System.out.println("Dados invalidos!");
    }

    private static boolean conta_nao_existe(ArrayList<Conta> lista, String conta) {
        boolean b = true;
        for (Conta item : lista) {
            if (item.getCc().equals(conta)) {
                b = false;
                break;
            }
        }
        return b;
    }

    static boolean valores_eh_valido_PF(double saldo, double cheque_especial) {
        return ((saldo >= 0) && (cheque_especial >= 0));
    }

    static boolean valores_eh_valido_PJ(double saldo) {
        return (saldo >= 0);
    }

    static boolean numeros_eh_validos(String palavra) {
        return palavra.matches("[0-9]+");
    }

    static boolean dados_sao_validos_PF(double saldo, double cheque_especial, String numero_conta, String cpf) {
        return (((valores_eh_valido_PF(saldo, cheque_especial))
                && (numeros_eh_validos(cpf)) && (numeros_eh_validos(numero_conta))));
    }

    static boolean dados_sao_validos_PJ(double saldo, String numero_conta, String cpf) {
        return ((valores_eh_valido_PJ(saldo)) && (numeros_eh_validos(cpf)) && (numeros_eh_validos(numero_conta)));
    }
}