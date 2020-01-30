package queueandstack;

import java.util.*;

/*
You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4 wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.

Example 1:
Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
Output: 6
Explanation:
A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".

"0000" "0100" "0200" "0200" "0209" "0208" "0207" "0206" "0205" "0204" "0203" "0202"



Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102".
Example 2:
Input: deadends = ["8888"], target = "0009"
Output: 1
Explanation:
We can turn the last wheel in reverse to move from "0000" -> "0009".
Example 3:
Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
Output: -1
Explanation:
We can't reach the target without getting stuck.
Example 4:
Input: deadends = ["0000"], target = "8888"
Output: -1
Note:
The length of deadends will be in the range [1, 500].
target will not be in the list deadends.
Every string in deadends and the string target will be a string of 4 digits from the 10,000 possibilities '0000' to '9999'.
 */
public class OpenTheLock {

    public static int openLock(String[] deadends, String target) {
        Queue<String> combinations = new LinkedList<>();
        combinations.offer("0000");

        Set<String> visited = new HashSet<>(Arrays.asList(deadends));

        if(visited.contains("0000")) return -1;
        visited.add("0000");

        int shortestPathToTarget = 0;
        while (!combinations.isEmpty()){
            if(visited.contains(target)) return shortestPathToTarget;
            List<String> nextLevelCombinations = new LinkedList<>();
            while(!combinations.isEmpty()){
                String combination = combinations.poll();

                for (int i = 0; i < 4; i++) {
                    char[] current = combination.toCharArray();
                    int n = current[i] - '0';
                    int next = 10 + n;
                    int more = (next+1)%10, less = (next-1)%10;
                    current[i] = (char)(more + '0');
                    nextLevelCombinations.add(new String(current));
                    current[i] = (char)(less + '0');
                    nextLevelCombinations.add(new String(current));
                }
            }

            for(String newCombination: nextLevelCombinations){
                if(!visited.contains(newCombination)){
                    combinations.offer(newCombination);
                    visited.add(newCombination);
                }
            }
            shortestPathToTarget++;
        }
        return visited.contains(target) ? shortestPathToTarget : -1;
    }

    public static int openLock2(String[] deadends, String target) {
        Queue<String> combinations = new LinkedList<>();
        combinations.offer("0000");

        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();

        if(visited.contains("0000")) return -1;
        visited.add("0000");

        int shortestPathToTarget = 0;
        while (!combinations.isEmpty()){
            if(visited.contains(target)) return shortestPathToTarget;
            List<String> nextLevelCombinations = new LinkedList<>();
            while(!combinations.isEmpty()){
                String combination = combinations.poll();
                if(dead.contains(combination)){
                    continue;
                }
                for (int i = 0; i < 4; i++) {
                    char[] current = combination.toCharArray();
                    int n = current[i] - '0';
                    int next = 10 + n;
                    int more = (next+1)%10, less = (next-1)%10;
                    current[i] = (char)(more + '0');
                    nextLevelCombinations.add(new String(current));
                    current[i] = (char)(less + '0');
                    nextLevelCombinations.add(new String(current));
                }
            }

            for(String newCombination: nextLevelCombinations){
                if(!visited.contains(newCombination)){
                    combinations.offer(newCombination);
                    visited.add(newCombination);
                }
            }
            shortestPathToTarget++;
        }
        return visited.contains(target) ? shortestPathToTarget : -1;
    }

    public static void main(String[] args) {
        String[] deadends1 = {"0201","0101","0102","1212","2002"};
        String target1 = "0202";

        System.out.println(String.format("target1: Shortest path to unlocking %s", openLock2(deadends1, target1)));

        String[] deadends2 = {"4515","4184","9093","6799","6594","8484","8048","2886","5609","9801","7845","2631","3962","5601","5049","3916","7222","5699","3980","0814","2386","8880","4524","5329","6242","9184","5357","1288","5446","9771","5492","0361","8679","2808","1184","0228","6448","9083","5730","3379","9890","5713","2642","0772","0141","8765","4448","7356","5382","8138","0272","0802","7944","6245","1345","6805","6945","3377","6741","0945","0925","1471","1118","3708","8332","6887","9130","0851","5177","6032","1906","0767","5974","3592","4967","2620","7959","3805","4836","8641","9805","6141","1023","5291","6808","8466","6259","4084","8880","0043","7394","6369","0313","3293","5254","3827","1728","5495","5927","3680","5454","1305","3366","8174","2717","1069","3785","9181","6171","1462","8859","4333","5795","8883","9881","1287","6416","5760","4390","6260","9788","6191","1510","2553","0222","7214","5214","2943","9615","4492","5632","7093","5869","4177","3542","2433","3518","0105","5266","8033","3094","5221","2240","5874","3742","8687","5202","7932","4512","4106","0234","3863","8154","3076","7452","9081","1189","9847","6463","5475","2125","8509","8193","7885","0611","5479","4371","4168","8870","1871","0248","9145","7032","4093","1429","5415","5261","4482","7241","7373","6043","3156","1828","0741","4792","7642","8921","3979","8445","2710","5027","0658","6168","2434","4568","6790","5356","5643","8948","2831","2411","0043","4042","2651","6041","8557","8253","2634","0559","9254","9501","3215","0234","3108","3363","8688","1513","7747","3846","3542","6671","9677","4598","7304","8313","1036","5811","3279","7115","3157","7761","3256","3379","4807","2475","8576","3612","6157","1266","8635","9429","9897","8048","2654","3145","5204","8731","9154","6673","7213","0608","1045","6692","0452","3947","6488","0525","5531","0312","7363","5876","2713","0484","2299","3052","4392","0464","2755","7416","5527","1276","2077","3723","0142","0653","9606","0916","6882","6575","2024","6250","1711","3381","7703","1626","6859","1526","0514","6271","3438","2880","9874","5837","6547","4960","0712","9390","6207","1437","1131","2253","9308","0665","6334","6648","4997","1583","4590","1032","4791","8445","2328","8440","1369","2595","8853","0797","1989","3119","5246","5964","7501","2464","7716","2772","8257","6181","7195","5138","2185","8121","1753","5144","1776","3221","3883","5573","7268","7162","5602","3035","5843","1417","1823","9366","6477","0108","5719","8666","8901","7289","2498","2219","4520","2951","7929","5504","0797","7586","5306","2656","7479","6606","4227","7727","4449","2299","0142","5099","3898","7005","4275","3692","1905","5540","8365","8971","9541","7449","6146","2844","1026","7639","2614","0796","5920","4633","9839","9761","5748","5524","1332","5586","3026","9057","1498","8197","0692","7714","6334","7656","1649","2989","4393","6227","5183","6328","9864","5972","2203","7032","3643","2429","0981","4729","0501","9624","1464","2619","7712","6739","9171","0899","9731","1058","7006","1859","4002","5325","1039","0466","2060","4203","8816","8867","1797","9832","6489","4771","9789","0271","7684","6345","0825","9022","4285","8081","9435","0946","4466","6551","4722","3580","5484","5191","4582","0220","1580","0045","8701","3895","1795","0614","3118","4836","2101","2072","7090","9275","8715","1303","4864","1116","6102","2818","9196","1222","3481","1709","6145","2349","3395","5314","3404","4626","3770","7762","8413","7310","9659","0892","9920","7195","7049","7443","5505","3400","2275","0669","6024"};
        String target2 = "4894";

        System.out.println(String.format("target2: Shortest path to unlocking %s", openLock2(deadends2, target2)));
    }
}
