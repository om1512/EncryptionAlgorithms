package com.omCode.lab2;


import com.omCode.utils.multiplicativeInverse;

public class MultiplicativeCipher {


    public static String encrypt(String str,int key){
        if(multiplicativeInverse.inverse(26, key) == -1) return "not";
        StringBuilder encrypted = new StringBuilder();
        for(char c : str.toCharArray()){
            int temp = ((c -'a') * key % 26);
            encrypted.append((char)('a' + temp));
        }
        return encrypted.toString();
    }


    public static String decryption(String str,int key){
        StringBuilder decrypt = new StringBuilder();
        for(char c : str.toCharArray()){
            int inverse = multiplicativeInverse.inverse(26, key);
            int temp = (((c - 'a') * inverse) % 26);
            decrypt.append((char)('a' + temp));
        }
        return decrypt.toString();
    }


    public static void main(String[] args) {
        String en = encrypt("welcome", 5);
        String dc = decryption(en, 5);
        if(en  != "not"){
            System.out.println("Encrypted text : " + en);
            System.out.println("Decrypted text : " + dc);
        }else{
            System.out.println("with this key it is not possible");
        }

    }
}
