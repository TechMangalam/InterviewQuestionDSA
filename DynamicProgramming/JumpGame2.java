package DyanamicProgramming;

import java.util.Arrays;

public class JumpGame2 {

    public int jumpDp(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;i+j<dp.length &&j<=nums[i];j++)
            {

                dp[i+j]=Math.min(dp[i+j],dp[i]+1);
            }
        }

        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        JumpGame2 j = new JumpGame2();
        System.out.println(j.jumpDp(nums));
    }

}
