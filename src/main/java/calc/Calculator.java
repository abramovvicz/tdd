package calc;

public class Calculator {

    // int number; // czestp zwieksza sie zasieg dostpe do pakietowe
    //zeby testowac
    //musza byc w takim samym pakiecie

    public int add(int a, int b) {
        int k = Integer.MIN_VALUE;
        int j = Integer.MAX_VALUE;
        System.out.println("min value" + k);
        System.out.println("max value" + j);
        System.out.println(k + (-j));
        if (a == 0 && b == 0) {
            return 0;
        }
        if ((a == j || b == j) && a == -b) {
            return 0;
        }
        System.out.println("math abs a " + Math.abs(a));
        System.out.println("math abs b " + Math.abs(b));
        int d = Math.abs(a) + Math.abs(b);
        if (d <= 0) {
            throw new ArithmeticException("Za duże liczby");
        }
        return a + b;
//        return Math.addExact(a, b);
    }

    public double div(double a, double b) {
        if (b == 0.0) {
            throw new IllegalArgumentException("Nie dziel przez zero");
        }
        return a / b;
    }

}
