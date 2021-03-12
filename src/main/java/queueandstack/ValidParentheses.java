package queueandstack;

import java.util.*;

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
 */
public class ValidParentheses {
    // (
    // )
    // "{([])}"
    // "{(" -- "{" queue
    // "([" -- "{(" queue
    // "[]" -- "[]" does not go in stack
    // ")}" -- "{()" queue
    // "}" -- "{()}"  queue

    // "{()}"
    // "{(" -- "{" queue
    // "()" -- "" no queue
    // "}" -- "{}" queue


    // ()[]{}
    // () -- no queue
    // [] -- no queue
    // {} -- no queue

    // ([)]
    // ([]((]
    public static boolean isValid(String s) {
        if (s.length() == 0){
            return true;
        }

        if(s.length() % 2 != 0){
            return false;
        }

        char lastChar = s.charAt(s.length() - 1);
        if(lastChar == '[' || lastChar == '{' || lastChar == '('){
            return false;
        }

        char firstChar = s.charAt(0);
        if(firstChar == ']' || firstChar == '}' || firstChar == ')'){
            return false;
        }

        Map<String, String> openClosedBracketMapping = new HashMap<>();
        openClosedBracketMapping.put("[", "]");
        openClosedBracketMapping.put("{", "}");
        openClosedBracketMapping.put("(", ")");

        List<String> brackets = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            brackets.add( Character.toString(s.charAt(i)));
        }

        Set<String> closedBrackets = new HashSet<>();
        closedBrackets.add("]");
        closedBrackets.add("}");
        closedBrackets.add(")");

        int i = 0;
        while(!brackets.isEmpty()) {
            if(i >= brackets.size()-1){
                i = 0;
            }
            String firstBracket = brackets.get(i);
            String secondBracket =  brackets.get(i+1);
            String expectedSecondBracket = openClosedBracketMapping.get(firstBracket);

            if(secondBracket.equals(expectedSecondBracket)) {
                brackets.remove(i);
                brackets.remove(i);
                continue;
            }

            // Testing for {]
            if(expectedSecondBracket != null && closedBrackets.contains(secondBracket)){
                return false;
            }

            i++;
        }

        return true;

    }

    public static void main(String[] args) {
        /*
        Example 1:

        Input: "()"
        Output: true
         */
        System.out.println(String.format("Ex 1. %s", isValid("()")));

        /*
        Example 2:

        Input: "()[]{}"
        Output: true
         */
        System.out.println(String.format("Ex 2. %s", isValid("()[]{}")));
        /*
        Example 3:

        Input: "(]"
        Output: false
         */
        System.out.println(String.format("Ex 3. %s", isValid("(]")));

        /*
        Example 4:

        Input: "([)]"
        Output: false
         */
        System.out.println(String.format("Ex 4. %s", isValid("([)]")));

        /*
        Example 5:

        Input: "{[]}"
        Output: true
         */
        System.out.println(String.format("Ex 5. %s", isValid("{[]}")));

        /*
        Example 6:

        Input: "{ [ ( { [ {} ] } ) ] }"
        Output: true
         */
        System.out.println(String.format("Ex 6. %s", isValid("{[({[{}]})]}")));

        /*
        Example 7:

        Input: "{ [ ( { [ {} {} ] } ) ] }"
        Output: true
         */
        System.out.println(String.format("Ex 7. %s", isValid("{[({[{}{}]})]}")));
        /*
        Example 8:

        Input: "()({}[])[]{}"
        Output: true
         */
        System.out.println(String.format("Ex 8. %s", isValid("()({}[])[]{}")));
    }
}
