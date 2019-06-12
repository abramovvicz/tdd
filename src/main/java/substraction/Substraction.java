package substraction;

public class Substraction {


    public double substract(double a, double b) {
        if(a<0&&b<0){
            return a-b;
        }
        return a - Math.abs(b);
    }

}
