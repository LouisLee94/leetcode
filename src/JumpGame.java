public class JumpGame {
    public boolean canJump(int[] nums) {
        int reachPos = 0;
        int i;
        for (i = 0; i < nums.length; i++) {
            if (reachPos == i && nums[i] == 0) break;
            reachPos = Math.max(reachPos, i + nums[i]);
        }
        return i >= nums.length - 1;
    }
}
