import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PasswordChecker passChecker = new PasswordChecker();

        try {
            System.out.print("Введите мин. длину пароля: ");
            passChecker.setMinLength(Integer.parseInt(sc.nextLine()));
            System.out.print("Введите макс. допустимое количество повторений символа подряд: ");
            passChecker.setMaxRepeats(Integer.parseInt(sc.nextLine()));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка! Ведено некорректное значение! " + e.getMessage());
            return;
        }

        while (true) {
            System.out.print("Введите пароль или end: ");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("end")) break;
            try {
                if (passChecker.verify(input) == true) {
                    System.out.println("Подходит!");
                } else System.out.println("Не подходит!");
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
