package stringAndArrays;

/*
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */
public class StrStr {

    public static void main(String[] args){
        System.out.println(String.format("Input: haystack = \"hello\", needle = \"ll\"\n expected = 2, actual = %s", strStr3("hello", "ll")));
        System.out.println(String.format("Input: haystack = \"aaaaa\", needle = \"a\"\n expected = -1, actual = %s", strStr3("aaaaa", "ab")));
        System.out.println(String.format("Input: haystack = \"I know what the answer is\", needle = \"answer\"\n expected = 16, actual = %s", strStr3("I know what the answer is", "answer")));
        System.out.println(String.format("Input: haystack = \"mississippi\", needle = \"pi\"\n expected = 9, actual = %s", strStr3("mississippi", "pi")));


    }

    public static int strStr(String haystack, String needle) {
        if(needle.isEmpty()){
            return 0;
        }
        for(int startIndex = 0; startIndex < haystack.length(); startIndex++){
            int needleCharLength = needle.length();
            char[] hayStackSubset = new char[needleCharLength];
            int subsetCount = 0;

            while (subsetCount < needleCharLength && subsetCount + startIndex < haystack.length()) {
                hayStackSubset[subsetCount] = haystack.charAt(subsetCount + startIndex);
                subsetCount++;
            }

            String hayStackSubsetStr = new String(hayStackSubset);
            if (hayStackSubsetStr.equals(needle)) {
                return startIndex;
            }

        }
        return -1;
    }


    public static int strStr2(String haystack, String needle) {
        if(needle.isEmpty() || haystack.equals(needle)){
            return 0;
        }

        int needleCharLength = needle.length();

        int max = haystack.length() - needle.length();

        for(int startIndex = 0; startIndex <= max; startIndex++){
            int subsetCount = 0;

            int needleSubsetIndex = subsetCount + startIndex;
            while (subsetCount < needleCharLength && needleSubsetIndex < haystack.length()) {
                needleSubsetIndex = subsetCount + startIndex;
                if(needle.charAt(subsetCount) != haystack.charAt(needleSubsetIndex)){
                    break;
                }
                subsetCount++;
            }


            if (subsetCount == needleCharLength) {
                return startIndex;
            }
        }
        return -1;
    }


    public static int strStr3(String haystack, String needle) {
        if(needle.isEmpty() || haystack.equals(needle)){
            return 0;
        }

        int needleCharLength = needle.length();

        int max = haystack.length() - needle.length();

        // I would consider this a bit of a cheat as it is using the optimised system copy char array
        for(int startIndex = 0; startIndex <= max; startIndex++){
            if(haystack.substring(startIndex, startIndex+needleCharLength).equals(needle)){
                return startIndex;
            }
        }
        return -1;
    }
}
