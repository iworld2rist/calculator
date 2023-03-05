import java.util.*;

class Main {
    public static String calc(String input) {
        // Парсим строку ввода
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid input");
        }
        String aStr = parts[0];
        String op = parts[1];
        String bStr = parts[2];

        // Определяем тип чисел (арабские или римские)
        boolean isRoman = false;
        if (aStr.matches("[IVX]+") && bStr.matches("[IVX]+")) {
            isRoman = true;
        } else if (!aStr.matches("[0-9]+") || !bStr.matches("[0-9]+")) {
            throw new IllegalArgumentException("Invalid number format");
        }

        // Парсим числа
        int a = Integer.parseInt(aStr);
        int b = Integer.parseInt(bStr);

        // Выполняем арифметическую операцию
        int result;
        switch (op) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }

        // Формируем результат
        String resultStr;
        if (isRoman) {
            if (result <= 0) {
                throw new IllegalArgumentException("Roman result cannot be negative or zero");
            }
            resultStr = toRoman(result);
        } else {
            resultStr = Integer.toString(result);
        }
        return resultStr;
    }
