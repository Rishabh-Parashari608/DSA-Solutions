import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int sr = 0, sc = 0;
        int litterCount = 0;

        int[][] litterId = new int[m][n];
        for (int[] row : litterId) Arrays.fill(row, -1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);

                if (c == 'S') {
                    sr = i;
                    sc = j;
                } else if (c == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }

        int fullMask = (1 << litterCount) - 1;
        if (fullMask == 0) return 0;

        int totalStates = m * n * (1 << litterCount) * (energy + 1);
        boolean[] visited = new boolean[totalStates];

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int startPos = sr * n + sc;
        int startState = encode(startPos, 0, energy, n, 1 << litterCount, energy);

        visited[startState] = true;
        queue.offer(startState);

        int moves = 0;
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int state = queue.poll();

                int e = state % (energy + 1);
                state /= (energy + 1);

                int mask = state % (1 << litterCount);
                int pos = state / (1 << litterCount);

                int r = pos / n;
                int c = pos % n;

                if (mask == fullMask) return moves;

                if (e == 0) continue;

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                    if (classroom[nr].charAt(nc) == 'X') continue;

                    int newEnergy = e - 1;
                    char cell = classroom[nr].charAt(nc);

                    if (cell == 'R') {
                        newEnergy = energy;
                    }

                    int newMask = mask;

                    if (cell == 'L') {
                        newMask |= 1 << litterId[nr][nc];
                    }

                    int newPos = nr * n + nc;

                    int newState = encode(
                        newPos,
                        newMask,
                        newEnergy,
                        n,
                        1 << litterCount,
                        energy
                    );

                    if (!visited[newState]) {
                        visited[newState] = true;
                        queue.offer(newState);
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    private int encode(int pos, int mask, int energy,
                       int n, int maskSize, int maxEnergy) {
        return (pos * maskSize + mask) * (maxEnergy + 1) + energy;
    }
}