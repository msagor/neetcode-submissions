public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] countR = new int[26];
        int[] countM = new int[26];

        for (char c : ransomNote.toCharArray()) {
            countR[c - 'a']++;
        }

        for (char c : magazine.toCharArray()) {
            countM[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (countM[i] < countR[i]) return false;
        }

        return true;
    }
}