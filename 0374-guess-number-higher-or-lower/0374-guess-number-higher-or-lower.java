/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1, h = n, r, m;
        while (true) {
            m = l + (h - l) / 2;
            r = guess(m);
            if (r == 0) return m;
            else if (r == -1) h = m - 1;
            else l = m + 1;
        }
    }
}