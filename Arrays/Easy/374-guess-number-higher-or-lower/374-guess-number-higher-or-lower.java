/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 0;
        int high = n;
        while(low <= high){
            int pick = low + (high - low)/2;
            if(guess(pick) == -1){
                high = pick -1;
            }
            if(guess(pick) == 1){
                low = pick + 1;
            }
            if(guess(pick) == 0){
                return pick;
            }
        }
        return -1;
    }
}