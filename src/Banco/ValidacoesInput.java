package Banco;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidacoesInput {

    static int perguntar_int_menu() {
        try {
            Scanner s = new Scanner(System.in);
            return s.nextInt();
        } catch (InputMismatchException e) {
            return 0;
        }
    }

    static int perguntar_codigo(String pergunta) {
        try {
            System.out.print("------------\n" + " 1 - Para PF\n 2 - Para PJ\n------------\n");
            System.out.print(pergunta);
            Scanner s = new Scanner(System.in);
            return s.nextInt();
        } catch (InputMismatchException e) {
            return 0;
        }
    }

    static double perguntar_double(String pergunta) {
        try {
            Scanner s = new Scanner(System.in);
            System.out.print(pergunta);
            return s.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
    }

    static String perguntar_String(String pergunta) {
        Scanner s = new Scanner(System.in);
        System.out.print(pergunta);
        return s.next();
    }

    static double perguntar_valor() {
        try {
            Scanner s = new Scanner(System.in);
            System.out.print("Digite o valor:");
            return s.nextDouble();
        } catch (InputMismatchException e) {
            return 0;
        }
    }

    static String perguntar_cc() {
        Scanner s = new Scanner(System.in);
        System.out.print("Digite o numero da conta:");
        return s.next();
    }
}
