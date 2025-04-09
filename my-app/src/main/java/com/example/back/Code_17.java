package com.example.back;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Code_17 {

    public static void main(String[] args) {
        List<String> strings = new Code_17().letterCombinations("23");

        for (String string : strings) {
            System.out.println(string);
        }
    }


    //   leleleto leleto

    public List<String> letterCombinations(String digits) {

        List<String> a = new ArrayList<>();

        if (digits.length() == 0) {
            return a;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        asassa(a, 0, digits, new StringBuffer(), phoneMap);

        return a;


    }

    public void asassa(List<String> list, int curr, String digits, StringBuffer buffer, Map<Character, String> map) {


        if (curr == digits.length()) {
            list.add(buffer.toString());
            return;
        }
        char c = digits.charAt(curr);
        String s = map.get(c);

        for (int i = 0; i < s.length(); i++) {
            buffer.append(s.charAt(i));
            asassa(list, curr + 1, digits, buffer, map);
            buffer.deleteCharAt(curr);
        }
    }

}
