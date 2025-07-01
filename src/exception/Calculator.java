package exception;

public class Calculator {
    public double calculateDouble (int n) {
        if(n == 0) throw new MyArithmeticException("Zero not allowed");
        if( n < 0) throw new MyArithmeticException("Negative not allowed");

        return (double) n;
    }
}
