package com.omCode.lab1;
import java.util.*;
public class MonoalphabeticRandom {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string to encrypt : ");
        String str = sc.next();
        List<Map<Character,Character>> list = generateMap();
        String encrypted = encrypt(str,list);
        System.out.println("Encrypted String : " + encrypted);
        System.out.println("Decrypted String : " + decrypt(encrypted, list));
    }
    static String encrypt(String str,List<Map<Character,Character>> list){
        Map<Character,Character> map = list.get(0);
        StringBuilder encrypted = new StringBuilder();
        for(char c:str.toCharArray()){
            encrypted.append(map.get(c));
        }
        return encrypted.toString();
    }
    static String decrypt(String str,List<Map<Character,Character>> list){
        Map<Character,Character> map = list.get(1);
        StringBuilder decrypt = new StringBuilder();
        for(char c:str.toCharArray()){
            decrypt.append(map.get(c));
        }
        return decrypt.toString();
    }
    // random -> 0 to 25
    static int randomGen(int min,int max){
        Random r = new Random();
        return r.nextInt((max-min) + 1) + min;
    }
    static List<Map<Character,Character>> generateMap(){
        List<Map<Character,Character>> ans = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        Map<Character,Character> map = new HashMap<>();
        Map<Character,Character> map1 = new HashMap<>();
        char ch = 'a';
        for(int i=0;i<26 && ch <= 'z';i++){
            int random = randomGen(0,25);
            while(!set.add((char)(random + 'A'))){
                random = randomGen(0,25);
            }
            map.put(ch,(char)(random + 'A'));
            map1.put((char)(random + 'A'),ch);
            ch++;
        }
        ans.add(map);
        ans.add(map1);
        System.out.println(ans);
        return ans;
    }

}
