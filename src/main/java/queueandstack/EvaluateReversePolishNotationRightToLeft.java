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
public class EvaluateReversePolishNotationRightToLeft {

    private static Set<String> operators = new HashSet<>();
    static {
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
    }

    public static int evalRPN(String[] tokens) {
        List<String> stack = new ArrayList<>();

        int nTokens = tokens.length;

        for(int i = nTokens-1; i >= 0; i--){
            stack.add(tokens[i]);
            operate(stack);
        }


        return Integer.parseInt(stack.get(0));
    }

    private static void operate(List<String> stack){
        if(stack.size() < 3){
            return;
        }
        String first = stack.remove(stack.size() -1);
        String second = stack.remove(stack.size() -1);

        if(operators.contains(first) || operators.contains(second)){
            stack.add(second);
            stack.add(first);
            return;
        }

        String operator = stack.remove(stack.size() -1);
        stack.add(second);
        stack.add(first);


        switch (operator){
            case "+":
                add(stack);
                break;
            case "-":
                minus(stack);
                break;
            case "/":
                divide(stack);
                break;
            case "*":
                multiple(stack);
                break;
        }
        operate(stack);
    }

    private static void add(List<String> stack){
        Integer secondNumber = Integer.parseInt(stack.remove(stack.size()-1 ));
        Integer firstNumber = Integer.parseInt(stack.remove(stack.size()-1 ));

        stack.add(String.valueOf(firstNumber + secondNumber));
    }

    private static void minus(List<String> stack){
        Integer secondNumber =  Integer.parseInt(stack.remove(stack.size()-1 ));
        Integer firstNumber =  Integer.parseInt(stack.remove(stack.size()-1 ));

        stack.add(String.valueOf(secondNumber - firstNumber));
    }

    private static void multiple(List<String> stack){
        Integer secondNumber =  Integer.parseInt(stack.remove(stack.size()-1 ));
        Integer firstNumber =  Integer.parseInt(stack.remove(stack.size()-1 ));

        stack.add(String.valueOf(firstNumber * secondNumber));
    }

    private static void divide(List<String> stack){
        Integer secondNumber = Integer.parseInt(stack.remove(stack.size()-1 ));
        Integer firstNumber = Integer.parseInt(stack.remove(stack.size()-1 ));

        stack.add(String.valueOf(secondNumber / firstNumber));
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
