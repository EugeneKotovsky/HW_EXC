import java.util.Scanner;

public class PasswordChecker {

    private int minLength;
    private int maxRepeats;

    public void setMinLength(int minLength) {
        if (minLength <= 0) {
            throw new IllegalArgumentException("Минимальная длина пароля должна быть положительной");
        } else this.minLength = minLength;
    }

    public void setMaxRepeats(int maxRepeats) {
        if (maxRepeats <= 0) {
            throw new IllegalArgumentException("Максимальное количество повторений символов в пароле должно быть положительным");
        } else this.maxRepeats = maxRepeats;
    }

    public boolean verify(String password) {
        if (minLength == 0 || maxRepeats == 0) {
            throw new IllegalStateException("Настройки не были заданы");
        } else if (password.length() < minLength) {
            return false;
        } else {
            int currentRepeats = 1;
            for (int i = 0; i < password.length() - 1; i++) {
                if (password.charAt(i) == password.charAt(i + 1)) {
                    currentRepeats++;
                    if (currentRepeats > maxRepeats) {
                        return false;
                    }
                } else currentRepeats = 1;
            }
        }
        return true;
    }
}
