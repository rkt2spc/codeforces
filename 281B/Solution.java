import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    private double diff(long a, long b, long x, long y) {
        double numerator = a * y - b * x;
        double denominator = b * y;
        return numerator / denominator;
    }

    public void solve(InputReader in, PrintWriter out) {
        long x = in.nextLong();
        long y = in.nextLong();
        long n = in.nextLong();

        double minDiff = Double.POSITIVE_INFINITY;
        long aa = 0, bb = 0;

        for (long b = 1; b <= n; ++b) {
            long a1 = x * b / y;
            long a2 = a1 + 1;

            double a1Diff = Math.abs(diff(a1, b, x, y));
            if (a1Diff < minDiff) {
                aa = a1;
                bb = b;
                minDiff = a1Diff;
            }

            double a2Diff = Math.abs(diff(a2, b, x, y));
            if (a2Diff < minDiff) {
                aa = a2;
                bb = b;
                minDiff = a2Diff;
            }
        }

        out.println(String.format("%d/%d", aa, bb));
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        Solution sln = new Solution();
        sln.solve(in, out);

        out.close();
    }

    private static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        public InputReader(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        public boolean hasMoreTokens() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                String s = nextLine();
                if (s == null)
                    return false;
                tokenizer = new StringTokenizer(s);
            }
            return true;
        }

        public String nextToken() {
            return hasMoreTokens() ? tokenizer.nextToken() : null;
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() {
            return Long.parseLong(nextToken());
        }

        public double nextDouble() {
            return Double.parseDouble(nextToken());
        }

        public String nextLine() {
            try {
                tokenizer = null;
                return reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
