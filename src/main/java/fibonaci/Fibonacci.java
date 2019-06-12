package fibonaci;

public class Fibonacci {

    public int countFibbonacci(int a) {
        if (a < 0) {
            throw new IllegalArgumentException("liczba nie może być ujemna");
        }

        if (a <= 1) {
            return a;
        }

        System.out.println(": " + a);

        return countFibbonacci(a - 1) + countFibbonacci(a - 2);
    }


    public int rekurencja(int a) {
        if (a == 1) {
            return a;
        }
        System.out.println(a);
        return rekurencja(a - 1);
    }

}
