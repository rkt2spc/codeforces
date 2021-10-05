import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    public void solve(InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();

        int prevScore = 0;
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            int score = in.nextInt();

            if (score <= 0 || (k <= 0 && score != prevScore))
                break;

            prevScore = score;
            ++ans;
            --k;
        }

        out.println(ans);
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
