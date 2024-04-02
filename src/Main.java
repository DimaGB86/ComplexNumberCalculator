import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое комплексное число (в формате a+bj): ");
        String num1Str = scanner.nextLine();

        System.out.print("Введите операцию (+, *, /): ");
        String operation = scanner.nextLine().toLowerCase();

        System.out.print("Введите второе комплексное число (в формате a+bj): ");
        String num2Str = scanner.nextLine();
        
        scanner.close();

        try {
            ComplexNumber num1 = parseComplexNumber(num1Str);
            ComplexNumber num2 = parseComplexNumber(num2Str);

            ComplexCalculator calculator = new ComplexCalculator();
            ComplexNumber result = calculator.calculate(operation, num1, num2);

            System.out.println("Результат: " + result.getReal() + " + " + result.getImaginary() + "j");
            CustomLogger.log(operation + ": " + num1Str + " " + operation + " " + num2Str + " = " + result.getReal() + " + " + result.getImaginary() + "j");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Неверный формат ввода. Пожалуйста, введите комплексные числа в формате 'a+bj'");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }


    private static ComplexNumber parseComplexNumber(String input) {
        String[] parts = input.split("\\+");
        double real = Double.parseDouble(parts[0].trim());
        double imaginary = Double.parseDouble(parts[1].replaceAll("j", "").trim());
        return new ComplexNumber(real, imaginary);
    }
    
}
