package com.example;

public class twoPont_125 {


    public static void main(String[] args) {
        System.out.println(new twoPont_125().isPalindrome("A man, a plan, a canal: Panama"));
    }



    public boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        int size = Math.abs('A' - 'a');

        int indexLeft = 0;
        int indexRight = s.length() -1;

        while (indexLeft <= indexRight) {
            if (indexLeft == indexRight) {
                return true;
            }
            if (!Character.isLetterOrDigit(s.charAt(indexLeft))) {
                indexLeft++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(indexRight))) {
                indexRight--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(indexLeft)) == Character.toLowerCase(s.charAt(indexRight))) {
                indexLeft++;
                indexRight--;
            } else {
                return false;
            }


        }
        return true;
    }

}
