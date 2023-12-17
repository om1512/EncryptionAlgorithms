package com.omCode.lab1;

import java.util.Scanner;

public class ShiftCipher {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string to encrypt : ");
        String input = sc.next();
        String encrypted = encrypt(input,5);
        System.out.println("encrypted string : " + encrypted);
        for(int i=1;i<26;i++){
            String decrypted = decrypt(encrypted,i);
            if(input.equals(decrypted)){
                System.out.println("decrypted string : " + decrypted);
                System.out.println(i + " is key");
                break;
            }
            System.out.println(i + " is not key");
        }
        for(int i=0;i<26;i++){
            System.out.print((char)('a'+i));
            System.out.println(" "+i);
        }

    }
    // for encryption
    static String encrypt(String input,int key){
        StringBuilder str = new StringBuilder();
        for(int i=0;i<input.length();i++){
            int c = ((input.charAt(i) - 'a') + key) % 26;
            str.append((char)(c + 'a'));
        }
        return str.toString();
    }
    // for decryption
    static String decrypt(String input,int key){
        StringBuilder str = new StringBuilder();
        for(int i=0;i<input.length();i++){
            int c = ((input.charAt(i) - 'a') - key) % 26;
            while(c<0){
                c+=26;
            }
            str.append((char)(c + 'a'));
        }
        return str.toString();
    }

}
