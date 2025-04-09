package com.example.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Code_20 {

    public static void main(String[] args) {

        System.out.println(new Code_20().isValid("){"));

    }

    public boolean isValid(String s) {

        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};


        for (int i = 0; i < s.length(); i++) {
            if (pairs.containsKey(s.charAt(i)) ) {
                if (stack.size() == 0 || stack.peek() != pairs.get(s.charAt(i))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.size() == 0;
    }

}
