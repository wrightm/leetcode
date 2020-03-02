package queueandstack;

import java.util.Arrays;

/*
Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature.
If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */
public class DailyTemperaturesOptimised {
    public static int[] dailyTemperatures(int[] T) {
        int length =  T.length;
        int[] result = new int[length];
        int[] stack = new int[length];
        int head=-1;

        for(int i=0; i< length;i++){
            int cur = T[i];
            while( head>=0 && T[stack[head]]<cur){
                int last = stack[head--];
                result[last] = i-last;
            }

            stack[++head]=i;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

        System.out.println(String.format("We need to wait %s", Arrays.toString(dailyTemperatures(temperatures))));

    }
}
