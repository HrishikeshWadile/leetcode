class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        // rec = [x1, y1, x2, y2]

        // rec1 is completely to the left of rec2
        if (rec1[2] <= rec2[0]) {
            return false;
        }

        // rec2 is completely to the left of rec1
        else if (rec2[2] <= rec1[0]) {
            return false;
        }

        // rec1 is completely below rec2
        else if (rec1[3] <= rec2[1]) {
            return false;
        }

        // rec2 is completely below rec1
        else if (rec2[3] <= rec1[1]) {
            return false;
        }

        // Otherwise, they overlap
        else {
            return true;
        }
    }
}