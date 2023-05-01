import java.text.MessageFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int number;
    static char operation;
    static String result;

    public static void main(String[] args) {
        System.out.println("Введите выражение [\"a\" + \"b\", \"a\" - \"b\", \"a\" * x, \"a\" / x] где a и b - строки а x - число  от 1 до 10 включительно  + Enter ");
//      Считываем введенную строку userInput
        String userInput = scanner.nextLine();
//      Создаём пустой символьный массив длиной 26 символов: uchar
        char[] uchar = new char[26];
//      Заполняем символьный массив символами строки которую ввел пользователь и по ходу ловим знак операции
        for (int i = 0; i < userInput.length(); i++) {
            uchar[i] = userInput.charAt(i);
            if (uchar[i] == '+') {
                operation = '+';
            }
            if (uchar[i] == '-') {
                operation = '-';
            }
            if (uchar[i] == '*') {
                operation = '*';
            }
            if (uchar[i] == '/') {
                operation = '/';
            }

        }
        String[] blocks = userInput.split("[+-/*\"]");
        if (blocks.length == 5) {
            //  String n0 = blocks[0];
            String n1 = blocks[1];
        /*  String n2 = blocks[2];
            String n3 = blocks[3]; */
            String n4 = blocks[4];

            result = calculated(n1, n4, operation);
            System.out.println(result);
        } else {
            String n1 = blocks[1];
            String n3 = blocks[3];

            number = Integer.parseInt(n3);
            result = calculated(n1, number, operation);
            System.out.println(result);

        }
    }

    public static String calculated(String num1, String num2, char op) {

        switch (op) {
            case '+' -> result = num1 + num2;
            case '-' -> {
                int resultA = num1.length ( ) - num2.length ( );
                result = num1.substring (0, resultA);
            }
            case '*' -> System.out.println ("Неверный знак операции * (введите + или -)");
            case '/' -> System.out.println ("Неверный знак операции / (введите + или -)");
            default -> throw new IllegalArgumentException ("Не верный знак операции");
        }
        return result;
    }

    public static String calculated(String num1, int num, char op) {

        switch (op) {
            case '+' -> System.out.println ("Неверный знак операции + (введите * или /)");
            case '-' -> System.out.println ("Неверный знак операции - (введите * или /)");
            case '*' -> {
// При умножении строки добавляется null !
                for (int u = 0; u < num; u++) result = MessageFormat.format ("{0}{1}", result, num1);
            }
            case '/' -> {
                try {
                    int resultB = num1.length ( ) / num;
                    result = num1.substring (0, resultB);
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println ("Exception : " + e);
                    System.out.println ("Only integer non-zero parameters allowed");
                } finally {
                    if (num1.length ( ) < num) {
                        System.out.println ("Делимое меньше делителя");
                    }
                }
            }
            default -> throw new IllegalArgumentException ("Не верный знак операции");
        }
        return result;
    }
}