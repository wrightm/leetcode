package stringAndArrays;

import java.util.Stack;

/**
 * Given an input string, reverse the string word by word.
 *
 *
 *
 * Example 1:
 *
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 *
 * Note:
 *
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 *
 * Follow up:
 *
 * For C programmers, try to solve it in-place in O(1) extra space.
 */
public class ReverseWords {

    public static void main(String[] args){
        String example1 = "    a   good   example   ";
        System.out.println(String.format("%s : %s", example1, reverseWords1(example1)));
        String example2 = "    a        ";
        System.out.println(String.format("%s : %s", example2, reverseWords1(example2)));
        String example3 = "a";
        System.out.println(String.format("%s : %s", example3, reverseWords1(example3)));
        String example4 = "addssdsds";
        System.out.println(String.format("%s : %s", example4, reverseWords1(example4)));
        String example5 = "the sky is blue";
        System.out.println(String.format("%s : %s", example5, reverseWords1(example5)));
    }

    public static String reverseWords(String s) {
        int startIndex = -1;
        int endIndex = -1;
        boolean start = true;
        StringBuilder builder = new StringBuilder();
        for(int i = s.length() -1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            if(currentChar != ' ' && startIndex == -1 && (i > 0 && s.charAt(i - 1) == ' ' || i == 0)) {
                startIndex = i;
                endIndex = i;
            } else if (currentChar != ' ' && startIndex == -1) {
                startIndex = i;
            } else if (currentChar != ' ' && i > 0 && s.charAt(i - 1) == ' ') {
                endIndex = i;
            } else if(i == 0){
                endIndex = i;
            }
            if(startIndex != -1 && endIndex != -1){
                if(start){
                    builder.append(s.substring(endIndex, startIndex + 1));
                    start = false;
                } else {
                    builder.append(' ');
                    builder.append(s.substring(endIndex, startIndex + 1));
                }
                startIndex = -1;
                endIndex = -1;
            }
        }
        return builder.toString();
    }

    // a hello how

    public static String reverseWords1(String s) {
        StringBuilder builder = new StringBuilder();
        int i = s.length()-1;
        while (i >= 0) {
            char current = s.charAt(i);
            if(current == ' '){
                i--;
                continue;
            }

            int endIndex = i;
            int startIndex = s.lastIndexOf(' ', endIndex) + 1;

            builder.append(s.substring(startIndex, endIndex+1));
            builder.append(' ');
            i = startIndex - 1;
        }
        return builder.toString().trim();
    }
}
