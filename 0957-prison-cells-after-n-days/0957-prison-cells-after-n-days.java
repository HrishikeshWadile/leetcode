class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        Set<String> seen = new HashSet<>();

        while (n > 0) {
            String state = Arrays.toString(cells);

            if (seen.contains(state)) {
                // Cycle detected
                break;
            }

            seen.add(state);
            n--;

            int[] next = new int[8];

            for (int i = 1; i < 7; i++) {
                if (cells[i - 1] == cells[i + 1]) {
                    next[i] = 1;
                }
            }

            cells = next;
        }

        // Skip complete cycles
        if (n > 0) {
            int cycleLength = 0;
            String state = Arrays.toString(cells);

            while (true) {
                int[] next = new int[8];

                for (int i = 1; i < 7; i++) {
                    if (cells[i - 1] == cells[i + 1]) {
                        next[i] = 1;
                    }
                }

                cells = next;
                cycleLength++;

                if (Arrays.toString(cells).equals(state)) {
                    break;
                }
            }

            n %= cycleLength;

            while (n-- > 0) {
                int[] next = new int[8];

                for (int i = 1; i < 7; i++) {
                    if (cells[i - 1] == cells[i + 1]) {
                        next[i] = 1;
                    }
                }

                cells = next;
            }
        }

        return cells;
    }
}