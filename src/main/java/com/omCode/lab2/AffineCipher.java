package com.omCode.lab2;

import com.omCode.utils.multiplicativeInverse;

public class AffineCipher {
    public static String encrypt(String str, int key1, int key2) {
        if(multiplicativeInverse.inverse(26, key1) == -1) return "not";
        StringBuilder encrypted = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                encrypted.append(' ');
            } else {
                int temp = (((c - 'a') * key1 + key2) % 26);
                encrypted.append((char) ('a' + temp));
            }
        }
        return encrypted.toString();
    }


    public static String decryption(String str, int key1, int key2) {
        StringBuilder decrypt = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                decrypt.append(' ');
            } else {
                int inverse = multiplicativeInverse.inverse(26, key1);
                int temp = (((((c - 'a') - key2) * inverse) % 26) + 26) % 26;
                decrypt.append((char) ('a' + temp));
            }


        }
        return decrypt.toString();
    }


    public static void main(String[] args) {
        String en = encrypt("om dhingani", 7,11);
        String dc = decryption(en, 7, 11);
        if(en  != "not"){
            System.out.println("Encrypted text : " + en);
            System.out.println("Decrypted text : " + dc);
        }else{
            System.out.println("with this key it is not possible");
        }
    }
}


