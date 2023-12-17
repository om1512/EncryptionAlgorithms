package com.omCode.utils;
import java.math.BigInteger;

public class multiplicativeInverse{
    public static int gcd(int a, int b){
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }


    public static int inverse(int a, int b){
        if(gcd(a, b) != 1){
            return -1;
        }
        int r0 = a, r1 = b, s0 = 1, s1 = 0, t0 = 0, t1 = 1;
        while(r1 > 0){
            int q = r0/r1;
            int r = r0 - q*r1;
            r0 = r1;
            r1 = r;


            int s = s0 - q*s1;
            int t = t0 - q*t1;
            s0 = s1;
            s1 = s;
            t0 = t1;
            t1 = t;
        }
        return (t0+a) % a;
    }


    public static void main(String[] args) {
        System.out.println(inverse(4,26));
    }


}
