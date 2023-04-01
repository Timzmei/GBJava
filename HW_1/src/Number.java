public class Number {

    private int number;

    public Number(int number) {
        this.number = number;
    }

    public int getTriangularNumber() {
        int result = 0;
        for (int i = 1; i <= number; i++) {
            result += i;
        }
        return result;
    }

    public Object getFactorial() {
        if (number == 0) {
            return 1;
        } else if (number < 0) {
            return "Введите неотрицательное число";
        }
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result = result * i;
        }
        return result;
    }
}
