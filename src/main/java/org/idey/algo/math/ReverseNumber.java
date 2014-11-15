package org.idey.algo.math;

public class ReverseNumber {
    public static int reverse(int x){
        long reverse=0;
        long value = x;
        boolean isNegative=false;
        if(value<0){
            isNegative = true;
            value = Math.abs(value);
        }
        while(value>0){
            reverse = reverse*10+value%10;
            if(reverse> Integer.MAX_VALUE){
                throw new IllegalArgumentException("Numeric Overflow");
            }
            value = value /10;
        }

        if(isNegative){
            reverse = 0-reverse;
        }

        return (int)(reverse);
    }

    public static void main(String[] args){
        System.out.println(reverse(-123));
    }
}
