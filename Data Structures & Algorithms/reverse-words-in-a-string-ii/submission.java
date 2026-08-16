class Solution {
    public void reverseWords(char[] s) {

        // Step 1: Reverse the entire array
        reverse(s, 0, s.length - 1);

        // Step 2: Reverse each individual word
        int start = 0;

        for (int i = 0; i <= s.length; i++) {

            // We reached the end of a word
            if (i == s.length || s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
    }

    private void reverse(char[] s, int left, int right) {
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}


/*
Problem

Given a character array s, reverse the order of the words in the string in-place.

A word is defined as a sequence of non-space characters.

Words are separated by a single space.
There are no leading or trailing spaces.
You must modify the input array in-place with O(1) extra space.
Example 1

s = ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
output = ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
*/
