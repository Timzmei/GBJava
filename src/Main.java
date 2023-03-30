import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        System.out.println("1. Вычислить n-ое треугольного число (сумма чисел от 1 до n)\n" +
                "2. Вычислить n! (произведение чисел от 1 до n)\n" +
                "3. Вывести все простые числа от 1 до 1000 (числа, которые делятся только на 1 и на себя без остатка)\n" +
                "4. Реализовать простой калькулятор (введите первое число, введите второе число, введите требуемую операцию, ответ)\n" +
                "5. Выйти");
        System.out.println("\n\nВыберете задание:");
        Task5();

//        String task = in.next();

//        while (true) {
//            switch (task) {
//                case '1':
//                    Task1();
//                    break;
//                case '2':
//                    Task2();
//                    break;
//                case '3':
//                    Task3();
//                    break;
//                case '4':
//                    Task4(in);
//                    break;
//                case '5':
//                    return;
//            }
//        }

        in.close();

    }

    private static void Task5() {
        System.out.println("Введите уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69");


        Scanner in = new Scanner(System.in);
        String equations = in.next();
//        String equations = "q + w = e";
        String[] array = equations.split("\\s*[+=]\\s*");
//        System.out.println(new ArrayList<String>(List.of(array)));
        String el1 = array[0];
        String el2 = array[1];
        String result = array[2];

    }

    // Реализовать простой калькулятор (введите первое число, введите второе число, введите требуемую операцию, ответ)
    private static void Task4(Scanner in) {
        System.out.print("Введите первое число: ");
        double num1 = in.nextDouble();

        System.out.print("Введите второе число: ");
        double num2 = in.nextDouble();

        System.out.print("Введите требуемую операцию (+, -, *, /): ");
        char operator = in.next().charAt(0);


        System.out.println("Ответ: " + new Calculator(num1, num2, operator).calculate());
    }

    // Вычислить n-ое треугольного число (сумма чисел от 1 до n)
    private static void Task1() {
        Scanner in = new Scanner(System.in);

        Number number;
        number = getNumber(in);
        System.out.println("Треугольное число: " + number.getTriangularNumber());
        in.close();

    }

    // Вычислить n! (произведение чисел от 1 до n)
    private static void Task2() {
        Scanner in = new Scanner(System.in);

        Number number;
        number = getNumber(in);
        System.out.println("Факториал числа: " + number.getFactorial());
        in.close();

    }

// Вывести все простые числа от 1 до 1000 (числа, которые делятся только на 1 и на себя без остатка)
    private static void Task3() {
        System.out.println(getNaturalNumber(1000).toString());

    }

    private static Number getNumber(Scanner in) {
        System.out.println("Введите число: ");
        int inputNumber = in.nextInt();
        Number number = new Number(inputNumber);
        return number;
    }

    public static List<Integer> getNaturalNumber(int n) {
        List<Integer> naturalNumber = new LinkedList<>();

        if (n >= 2) {
            naturalNumber.add(2);
        }
        for (int i = 3; i <= n; i += 2) {
            if (isNatural(i)) {
                naturalNumber.add(i);
            }
        }
        return naturalNumber;
    }

    private static boolean isNatural(int number) {
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;

    }

}