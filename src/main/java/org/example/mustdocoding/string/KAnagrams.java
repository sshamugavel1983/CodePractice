package org.example.mustdocoding.string;

public class KAnagrams {
    static final int MAX_CHAR = 26;

    static boolean areKAnagrams(String str1, String str2,
                                int k) {
        int n = str1.length();
        if (str2.length() != n)
            return false;
        int[] hash_str1 = new int[MAX_CHAR];
        for (int i = 0; i < n; i++)
            hash_str1[str1.charAt(i) - 'a']++;

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (hash_str1[str2.charAt(i) - 'a'] > 0)
                hash_str1[str2.charAt(i) - 'a']--;
            else
                count++;

            if (count > k)
                return false;
        }
        return true;
    }

    public static void main(String args[]) {
        String str1 = "fodr";
        String str2 = "gork";
        int k = 2;
        if (areKAnagrams(str1, str2, k) == true)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
