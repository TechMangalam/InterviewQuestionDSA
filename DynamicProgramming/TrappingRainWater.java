package DyanamicProgramming;

public class TrappingRainWater {

    public int trapDp(int[] height) {
        int max = 0;
        int[] dp = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            int i1 = i >= 2 ? dp[i - 2] : 0;
            if (height[i] > height[i - 1]) {
                dp[i] = i1 + 2;
            } else {
                dp[i] = i1;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater t = new TrappingRainWater();
        System.out.println(t.trapDp(height));
    }

}
