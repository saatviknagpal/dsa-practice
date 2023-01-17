class Solution {

    public int minFlipsMonoIncr(String S) {
        // Check if input string is null or empty
        if (S == null || S.length() <= 0) return 0;

        // Convert input string to array of characters
        char[] sChars = S.toCharArray();

        // Initialize zeroCountAfterOnes and onesCount variables
        int zeroCountAfterOnes = 0;
        int onesCount = 0;

        // Iterate through the array of characters
        for (int i = 0; i < sChars.length; i++) {
            // Check if current character is 0
            if (sChars[i] == '0') {
                // If onesCount is 0, there is no need to flip any ones
                if (onesCount == 0) continue; else zeroCountAfterOnes++;
            } else {
                // If current character is 1, increment the onesCount variable
                onesCount++;
            }
            // If zeroCountAfterOnes is greater than onesCount, set zeroCountAfterOnes to onesCount
            if (zeroCountAfterOnes > onesCount) {
                zeroCountAfterOnes = onesCount;
            }
        }
        // Return the minimum number of flips needed
        return zeroCountAfterOnes;
    }
}
