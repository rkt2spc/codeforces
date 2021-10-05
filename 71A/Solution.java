import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    public String solve(String s) {
        if (s.length() <= 10)
            return s;

        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        sb.append(s.length() - 2);
        sb.append(s.charAt(s.length() - 1));

        return sb.toString();
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        Solution sln = new Solution();

        int n = in.nextInt();
        for (int i = 0; i < n; ++i)
            out.println(sln.solve(in.nextToken()));

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
