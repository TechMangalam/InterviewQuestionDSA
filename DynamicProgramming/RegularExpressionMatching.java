package DyanamicProgramming;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            if (p.charAt(i) == '*') dp[0][i + 1] = dp[0][i - 1];
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) dp[i + 1][j + 1] = dp[i][j];
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    else dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        RegularExpressionMatching rm = new RegularExpressionMatching();
        System.out.println(rm.isMatch("aa", "a"));
        System.out.println(rm.isMatch("aa", "a*"));
        System.out.println(rm.isMatch("ab", ".*"));
        System.out.println(rm.isMatch("aab", "c*a*b"));
        System.out.println(rm.isMatch("mississippi", "mis*is*p*."));
    }

}
