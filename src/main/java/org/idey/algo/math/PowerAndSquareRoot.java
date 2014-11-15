package org.idey.algo.math;

public class PowerAndSquareRoot {
    public static double power(double x, int y){
        double temp;
        if( y == 0)
            return 1;
        temp = power(x, y/2);
        if (y%2 == 0) {
            return temp * temp;
        }else{
            if(y > 0)
                return x*temp*temp;
            else
                return (temp*temp)/x;
        }
    }

    public static double nthRoot(int n, double x, double p){
        if(x < 0){
            System.err.println("Negative!");
            return -1;
        }
        if(x == 0) {
            return 0;
        }
        double x1 = x;
        double x2 = x / n;
        while (Math.abs(x1 - x2) > p){
            x1 = x2;
            x2 = ((n - 1.0) * x2 + x / power(x2, n - 1)) / n;
        }
        return x2;
    }

    public static void main(String[] args){
        System.out.println(nthRoot(2,3,0.000000001));
    }

}
