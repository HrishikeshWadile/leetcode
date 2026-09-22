class Solution {
    public String pushDominoes(String dominoes) {
        char[] d = dominoes.toCharArray();
        int n = d.length;

        boolean r = false;
        int s = 0;

        for (int i = 0; i < n; i++) {

            if (d[i] == 'R') {

                if (r) {
                    // R ... R
                    // Everything between the two R's becomes R
                    for (int j = s + 1; j < i; j++) {
                        d[j] = 'R';
                    }
                }

                r = true;
                s = i;
            }

            else if (d[i] == 'L') {

                if (r) {
                    // R ... L
                    int left = s;
                    int right = i;

                    // Move inward from both sides
                    while (left < right) {
                        d[left++] = 'R';
                        d[right--] = 'L';
                    }

                    // If left == right, the middle remains '.'
                    r = false;
                    s = i;
                }

                else {
                    // ... L
                    // Everything since s becomes L
                    for (int j = s; j < i; j++) {
                        if (d[j] == '.') {
                            d[j] = 'L';
                        }
                    }

                    s = i;
                }
            }
        }

        // Remaining R ... . at the end
        if (r) {
            for (int j = s + 1; j < n; j++) {
                d[j] = 'R';
            }
        }

        return new String(d);
    }
}