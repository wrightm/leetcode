package stringAndArrays;

import java.util.Arrays;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix {

    public static void main(String[] args){
        String[] firstSetOfStrings = {"flower", "flow", "flight"};
        System.out.println(String.format("input = [\"flower\",\"flow\",\"flight\"], expected out = fl, actual out = %s", longestCommonPrefix2(firstSetOfStrings)));

        String[] secondSetOfStrings = {"dog", "racecar", "car"};
        System.out.println(String.format("input = [\"dog\",\"racecar\",\"car\"], expected out = \"\", actual out = %s", longestCommonPrefix2(secondSetOfStrings)));

        String[] thirdSetOfStrings = {"flower pride", "flower power", "flower pickle"};
        System.out.println(String.format("input = [\"flower pride\",\"flower power\",\"flower pickle\"], expected out = flower p, actual out = %s", longestCommonPrefix2(thirdSetOfStrings)));

        String[] fourSetOfStrings = {"flower pride", "flower power", "flow"};
        System.out.println(String.format("input = [\"flower pride\",\"flower power\",\"flow\"], expected out = flow, actual out = %s", longestCommonPrefix2(fourSetOfStrings)));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        int nStrs = strs.length;
        String firstString = strs[0];
        int nFistChars = firstString.length();
        StringBuilder commonPrefix = new StringBuilder();
        for(int charIndex = 0; charIndex < nFistChars; charIndex++){
            char firstStringChar = firstString.charAt(charIndex);
            for(int strIndex = 1; strIndex < nStrs; strIndex++){
                if(charIndex >= strs[strIndex].length()){
                    return commonPrefix.toString();
                }
                char otherStringChar = strs[strIndex].charAt(charIndex);
                if(firstStringChar != otherStringChar){
                    return commonPrefix.toString();
                }
            }
            commonPrefix.append(firstStringChar);
        }
        return commonPrefix.toString();
    }

    public static String longestCommonPrefix2(String[] strs) {
        if(strs == null || strs.length <= 0){
            return "";
        }
        String res = strs[0];

        for(int i=0;i<strs.length;i++){
            while (!strs[i].startsWith(res) && res.length() > 0){
                res = res.substring(0, res.length()-1);
            }
        }
        return res;
    }
}
