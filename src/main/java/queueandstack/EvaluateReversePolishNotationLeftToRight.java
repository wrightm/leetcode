package queueandstack;

import java.util.*;

/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation:
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 */
public class EvaluateReversePolishNotationLeftToRight {
    public static int evalRPN(String[] tokens) {
        List<Integer> stack = new ArrayList<>();
        for(String token: tokens){
            switch (token){
                case "+":
                    add(stack);
                    break;
                case "-":
                    minus(stack);
                    break;
                case "*":
                    multiple(stack);
                    break;
                case "/":
                    divide(stack);
                    break;
                default:
                    stack.add(Integer.parseInt(token));
            }
        }
        return stack.get(0);
    }

    private static void add(List<Integer> stack){
        Integer secondNumber = stack.remove(stack.size()-1 );
        Integer firstNumber = stack.remove(stack.size()-1 );

        stack.add(firstNumber + secondNumber);
    }

    private static void minus(List<Integer> stack){
        Integer secondNumber = stack.remove(stack.size()-1 );
        Integer firstNumber = stack.remove(stack.size()-1 );

        stack.add(firstNumber - secondNumber);
    }

    private static void multiple(List<Integer> stack){
        Integer secondNumber = stack.remove(stack.size()-1 );
        Integer firstNumber = stack.remove(stack.size()-1 );

        stack.add(firstNumber * secondNumber);
    }

    private static void divide(List<Integer> stack){
        Integer secondNumber = stack.remove(stack.size()-1 );
        Integer firstNumber = stack.remove(stack.size()-1 );

        stack.add(firstNumber / secondNumber);
    }

    public static void main(String[] args) {
        String[] input1 = {"2", "1", "+", "3", "*"};
        System.out.println(String.format("%s = %s", Arrays.asList(input1), evalRPN(input1)));

        String[] input2 = {"4", "13", "5", "/", "+"};
        System.out.println(String.format("%s = %s", Arrays.asList(input2), evalRPN(input2)));

        String[] input3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(String.format("%s = %s", Arrays.asList(input3), evalRPN(input3)));
    }
}
