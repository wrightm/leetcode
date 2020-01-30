package queueandstack;

import java.util.*;

/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 */
public class PerfectSquaresOptimised {
    public static int numSquares(int n) {
        int sqrt = (int) Math.sqrt(n);
        if(sqrt * sqrt == n){
            return 1;
        }
        Queue<Integer> sums = new LinkedList<>();
        List<Integer> squares = new ArrayList<>();
        int numberOfSquaresForLayer = 0;
        for(int i = 1; i <= n; i++){
            int square = i * i;
            if(square > n){
                break;
            }
            squares.add(square);
            sums.offer(square);
            numberOfSquaresForLayer++;
        }

        Set<Integer> visited = new HashSet<>(squares);

        if(visited.contains(n)){
            return 1;
        }

        int perfectLeastSquares = 1;
        int currentLayerLoopCount = 0;
        int nextLayerCount = 0;
        while(!sums.isEmpty()){
            Integer sum = sums.poll();
            currentLayerLoopCount++;
            for (Integer square : squares) {
                Integer newSum = sum + square;
                if (newSum < n && !visited.contains(newSum)) {
                    visited.add(newSum);
                    sums.offer(newSum);
                    nextLayerCount++;
                } else if(newSum == n){
                    return ++perfectLeastSquares;
                } else if(newSum > n){
                    break;
                }
            }
            if(currentLayerLoopCount == numberOfSquaresForLayer){
                perfectLeastSquares++;
                numberOfSquaresForLayer = nextLayerCount;
                nextLayerCount = 0;
                currentLayerLoopCount = 0;
            }
        }
        return perfectLeastSquares;
    }

    public static void main(String[] args){
        int n1 = 12;
        System.out.println(String.format("The least number of squares for %s  is %s", n1, numSquares(n1)));

        int n2 = 13;
        System.out.println(String.format("The least number of squares for %s  is %s", n2, numSquares(n2)));

        int n3 = 1221;
        System.out.println(String.format("The least number of squares for %s  is %s", n3, numSquares(n3)));
    }
}
