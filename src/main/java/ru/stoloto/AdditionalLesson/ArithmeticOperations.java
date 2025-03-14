package ru.stoloto.AdditionalLesson;

public class ArithmeticOperations {
    public static void main(String[] args) {
        // 0) Арифметические операции над двумя примитивами типа int
        int a = 10;
        int b = 3;

        int sum = a + b;        // Сложение
        int difference = a - b; // Вычитание
        int product = a * b;   // Умножение
        int quotient = a / b;  // Деление (целочисленное)

        System.out.println("Сумма: " + sum);
        System.out.println("Разность: " + difference);
        System.out.println("Произведение: " + product);
        System.out.println("Частное: " + quotient);

        // 1) Арифметические операции над int и double в одном выражении
        double c = 2.5;
        double result1 = a + c; // int + double
        double result2 = a * c; // int * double

        System.out.println("Результат сложения int и double: " + result1);
        System.out.println("Результат умножения int и double: " + result2);

        // 2) Логические операции
        boolean isGreater = a > b;   // a больше b?
        boolean isLessOrEqual = a <= c; // a меньше или равно c?
        boolean isEqual = (a == b);  // a равно b?
        boolean isNotEqual = (a!=b);  // a не равно b?

        System.out.println("a > b: " + isGreater);
        System.out.println("a <= c: " + isLessOrEqual);
        System.out.println("a == b: " + isEqual);
        System.out.println("a != b: " + isNotEqual);

        // 3) Диапазоны типов данных для вещественных чисел
        // float: 32 бита, double: 64 бита
        System.out.println("Максимальное значение float: " + Float.MAX_VALUE);
        System.out.println("Минимальное значение float: " + Float.MIN_VALUE);
        System.out.println("Максимальное значение double: " + Double.MAX_VALUE);
        System.out.println("Минимальное значение double: " + Double.MIN_VALUE);

        // 4) Получить переполнение при арифметической операции
        int maxInt = Integer.MAX_VALUE;
        int overflow = maxInt + 1; // Переполнение int

        System.out.println("Переполнение int: " + overflow);
    }
}
