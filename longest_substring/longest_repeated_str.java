import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string to test");
        String i = sc.next();
        System.out.printf("You entered: %s%n", i);
        System.out.println("Longest repeating character substring is: " + 
                longest_repeating(i));
    }

    private static String longest_repeating(String s) {
        String[] repeating = split_repeated_chars(s);
        return find_longest(repeating);
    }

    private static String[] split_repeated_chars(String s) {
        if(s.length() < 1) {
            System.out.println("Input must me a string. Current length: " + s.length());
            throw new IllegalArgumentException("Input cannot be empty");
        }

        // For simpliciy, splits is the same length as s. To cover the worst case of every char is different
        // Should really be a stack or similar
        String[] splits = new String[s.length()];
        int si = 0; // Tracks index into splits
        String[] chars = s.split("");
        String acc = chars[0];

        for(int i=1; i<s.length(); i++){
            String current = chars[i];

            if(acc.substring(0,1).equals(current)){
                acc += current;
            } else {
                splits[si] = acc;
                si++;
                acc = current;
            }
        }

        // Handle last char/string here
        // This will always be left off otherwise
        splits[si] = acc;
        return splits;
    }

    private static String find_longest(String[] repeats) {
        String longest = "";
        for(String cur : repeats) {
            // Must break due to our previous
            // decision to use String[]
            if(cur == null) break;
            if(cur.length() > longest.length()) {
                longest = cur;
            }
        }
        return longest;
    }
}
