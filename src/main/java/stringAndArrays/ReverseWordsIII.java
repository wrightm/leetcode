package stringAndArrays;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class ReverseWordsIII {

    public static void main(String[] args){
        String example1 = "Let's take LeetCode contest";
        System.out.println(String.format("%s : %s", example1, reverseWords(example1)));
        String example2 = "Let's take LeetCode contest";
        System.out.println(String.format("%s : %s", example2, reverseWords2(example2)));
    }

    public static String reverseWords(String s) {
        int index = 0;
        int length = s.length();
        StringBuilder builder = new StringBuilder();
        while(index < length){
            if(s.charAt(index) == ' '){
                index++;
                builder.append(' ');
                continue;
            }

            int end = s.indexOf(' ', index);
            if(end == -1){
                for(int j = length-1; j >= index; j--){
                    builder.append(s.charAt(j));
                }
                break;
            }
            for(int j = end-1; j >= index; j--){
                builder.append(s.charAt(j));
            }
            builder.append(' ');
            index = end + 1;
        }
        return builder.toString();
    }

    public static String reverseWords2(String s) {
        StringBuilder builder = new StringBuilder(s.length());
        String[] words = s.split(" ");
        for(String word: words){
            builder.append(swap(word.toCharArray())).append(" ");
        }
        return builder.toString().trim();
    }

    public static String swap(char[] s) {
        int start = 0;
        int end = s.length-1;
        while(start <= end){
            char first = s[start];
            s[start] = s[end];
            s[end] = first;
            start++;
            end--;
        }
        return new String(s);
    }
}
