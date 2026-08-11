class Solution {

    private int[][] dp23;

    private int factorCount(int digit, int prime) {
        int count = 0;

        while (digit % prime == 0) {
            count++;
            digit /= prime;
        }

        return count;
    }

    private void buildDP() {

        int MAX2 = 50;
        int MAX3 = 35;
        int INF = 1000000;

        dp23 = new int[MAX2 + 1][MAX3 + 1];

        for (int i = 0; i <= MAX2; i++) {
            for (int j = 0; j <= MAX3; j++) {
                dp23[i][j] = INF;
            }
        }

        dp23[0][0] = 0;

            int[][] factors = {
            {1, 0},
            {0, 1},
            {2, 0},
            {1, 1},
            {3, 0},
            {0, 2}
        };

        for (int a = 0; a <= MAX2; a++) {
            for (int b = 0; b <= MAX3; b++) {

                if (dp23[a][b] == INF) {
                    continue;
                }

                for (int[] f : factors) {

                    int na = Math.min(MAX2, a + f[0]);
                    int nb = Math.min(MAX3, b + f[1]);

                    dp23[na][nb] = Math.min(
                        dp23[na][nb],
                        dp23[a][b] + 1
                    );
                }
            }
        }
    }

    private int minDigits(long a, long b, long c, long d) {

        if (a > 50 || b > 35) {
            return Integer.MAX_VALUE;
        }

        int result = dp23[(int) a][(int) b];

        if (result >= 1000000) {
            return Integer.MAX_VALUE;
        }

        long total = result + c + d;

        if (total > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int) total;
    }

    private String buildSuffix(
            int length,
            long a,
            long b,
            long c,
            long d) {

        if (minDigits(a, b, c, d) > length) {
            return null;
        }

        StringBuilder result = new StringBuilder();

        for (int pos = 0; pos < length; pos++) {

            int remaining = length - pos - 1;

            for (int digit = 1; digit <= 9; digit++) {

                long na = Math.max(
                    0,
                    a - factorCount(digit, 2)
                );

                long nb = Math.max(
                    0,
                    b - factorCount(digit, 3)
                );

                long nc = Math.max(
                    0,
                    c - factorCount(digit, 5)
                );

                long nd = Math.max(
                    0,
                    d - factorCount(digit, 7)
                );

                if (minDigits(na, nb, nc, nd) <= remaining) {

                    result.append(digit);

                    a = na;
                    b = nb;
                    c = nc;
                    d = nd;

                    break;
                }
            }
        }

        return result.toString();
    }

    private boolean isValid(
            String num,
            long a,
            long b,
            long c,
            long d) {

        long ca = 0;
        long cb = 0;
        long cc = 0;
        long cd = 0;

        for (int i = 0; i < num.length(); i++) {

            int digit = num.charAt(i) - '0';

            if (digit == 0) {
                return false;
            }

            ca += factorCount(digit, 2);
            cb += factorCount(digit, 3);
            cc += factorCount(digit, 5);
            cd += factorCount(digit, 7);
        }

        return ca >= a &&
               cb >= b &&
               cc >= c &&
               cd >= d;
    }

    public String smallestNumber(String num, long t) {
        long need2 = 0;
        long need3 = 0;
        long need5 = 0;
        long need7 = 0;

        while (t % 2 == 0) {
            need2++;
            t /= 2;
        }

        while (t % 3 == 0) {
            need3++;
            t /= 3;
        }

        while (t % 5 == 0) {
            need5++;
            t /= 5;
        }

        while (t % 7 == 0) {
            need7++;
            t /= 7;
        }

      
        if (t != 1) {
            return "-1";
        }

        buildDP();
        if (isValid(num, need2, need3, need5, need7)) {
            return num;
        }

        int n = num.length();

         long[][] prefix = new long[4][n + 1];

        int firstZero = n;

        for (int i = 0; i < n; i++) {

            for (int p = 0; p < 4; p++) {
                prefix[p][i + 1] = prefix[p][i];
            }

            int digit = num.charAt(i) - '0';

            if (digit == 0) {
                firstZero = Math.min(firstZero, i);
                continue;
            }

            prefix[0][i + 1] += factorCount(digit, 2);
            prefix[1][i + 1] += factorCount(digit, 3);
            prefix[2][i + 1] += factorCount(digit, 5);
            prefix[3][i + 1] += factorCount(digit, 7);
        }

        for (int i = n - 1; i >= 0; i--) {

           
            if (i > firstZero) {
                continue;
            }

            int original = num.charAt(i) - '0';

           
            for (int digit = original + 1; digit <= 9; digit++) {

                long have2 = prefix[0][i];
                long have3 = prefix[1][i];
                long have5 = prefix[2][i];
                long have7 = prefix[3][i];

                have2 += factorCount(digit, 2);
                have3 += factorCount(digit, 3);
                have5 += factorCount(digit, 5);
                have7 += factorCount(digit, 7);

                long remaining2 =
                    Math.max(0, need2 - have2);

                long remaining3 =
                    Math.max(0, need3 - have3);

                long remaining5 =
                    Math.max(0, need5 - have5);

                long remaining7 =
                    Math.max(0, need7 - have7);

                int remainingLength = n - i - 1;

                if (minDigits(
                        remaining2,
                        remaining3,
                        remaining5,
                        remaining7
                    ) <= remainingLength) {

                    String suffix = buildSuffix(
                        remainingLength,
                        remaining2,
                        remaining3,
                        remaining5,
                        remaining7
                    );

                    if (suffix != null) {

                        StringBuilder answer =
                            new StringBuilder();

                        answer.append(num, 0, i);
                        answer.append(digit);
                        answer.append(suffix);

                        return answer.toString();
                    }
                }
            }
        }

          int requiredLength = minDigits(
            need2,
            need3,
            need5,
            need7
        );

        if (requiredLength == Integer.MAX_VALUE) {
            return "-1";
        }

     
        int answerLength =
            Math.max(n + 1, requiredLength);

        return buildSuffix(
            answerLength,
            need2,
            need3,
            need5,
            need7
        );
    }
}