import java.util.Arrays;

class Solution {
    static  int index;
    public int[] findEvenNumbers(int[] digits) {
        index = 0;
        int[] freq = new int[10];
        for (int i = 0;i < digits.length;i++) {
            freq[digits[i]]++;
        }
        int[] result = new int[450];
        generate(freq,3,0,result);
        return Arrays.copyOf(result, index);
    }
    static void generate(int[] freq,int k,int num, int[] result){
        if (k <= 0 ){
            result[index++] =  num;
            return;
        }
        for (int i = 0;i < 10;i++) {
            if (freq[i] == 0) continue;
            if (k == 3 && i == 0) continue;
            if (k == 1  && i %2 !=0) continue;
            freq[i]--;
            generate(freq, k - 1, num* 10+ i, result);
            freq[i]++;
        }
    }
}