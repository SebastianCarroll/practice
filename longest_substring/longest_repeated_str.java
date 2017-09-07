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
        // Split string to String[] where each are repeating
        String[] repeating = map_to_repeated(s);
        // Filter all but longest
        // return that one
        return repeating[0];
    }

    private static String[] map_to_repeated(String s) {
        // Here I'm going to need to know how many elements to make 
        // Return value. I could just use an arrayList or something similar
        // But seems wasteful.
        // Other wise i'll need to scan the list to count the transitions. 
        // Could just use same length as string. Won't be more than this

        String[] splits = new String[s.length()];
        String[] chars = s.split("");
        for(int i=0; i<s.length(); i++){
            splits[i] = chars[i];
        }

        return splits;
    }
}
