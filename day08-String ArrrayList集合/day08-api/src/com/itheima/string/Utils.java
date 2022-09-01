package com.itheima.string;

public class Utils {
    public static void main(String[] args) {
        String str = "";
        for (int i = 97; i < 97 + 26; i++) {
            str += (char)i;
        }
        for (int i = 65; i < 65 + 26; i++) {
            str += (char)i;
        }
        for (int i = 48; i < 48 + 10; i++) {
            str += (char)i;
        }
        System.out.println(str);
    }
}
