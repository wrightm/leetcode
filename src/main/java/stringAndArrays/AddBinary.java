package stringAndArrays;

import java.util.Stack;

/*
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"

00000011
+
00000001
=
00000010
00000100

Output: "100"

--------------

Example 2:

Input: a = "1010", b = "1011"

0000 1010
+
0000 1011
=
0001 0101

Output: "10101"



 */
public class AddBinary {

    public static void main(String[] args) {
        System.out.println(String.format("a = \"100\", b = \"110010\", Output = %s == 110110", addBinary("100", "110010")));
        System.out.println(String.format("a = \"1111\", b = \"1111\", Output = %s == 11110", addBinary("1111", "1111")));
    }

    public static String addBinary(String a, String b) {
        int t = 0, indexA = a.length() - 1, indexB = b.length() - 1;
        char[] addition = new char[indexA > indexB ? a.length() + 1: b.length() + 1];
        int indexAddition = addition.length-1;

        do {
            int d1 = indexA >= 0 ? (a.charAt(indexA--) == '1' ? 1 : 0) : 0;
            int d2 = indexB >= 0 ? (b.charAt(indexB--) == '1' ? 1 : 0) : 0;
            t += d1 + d2;

            int m = t % 2;
            t = (t - m) / 2;
            addition[indexAddition--] = m == 1 ? '1' : '0';
        } while (t > 0 || indexA >= 0 || indexB >= 0);

        if(addition[0] != '1'){
            return new String(addition, 1, addition.length-1);
        } else {
            return new String(addition);
        }
    }
}
