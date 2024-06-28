package ru.practice.thirdpractice.firsttask;

public class Division<T extends Number> {
    private final T num1;
    private final T num2;

    public Division(T num1, T num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double divide() throws ArithmeticException {
        if (num2.doubleValue() == 0) {
            throw new ArithmeticException("Деление на ноль не допускается");
        }
        return num1.doubleValue() / num2.doubleValue();
    }
}