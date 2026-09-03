class Solution {
    public int trap(int[] height) {
        int[] rightMax = new int[height.length];
        int maxHeight = 0;
        for(int i = 0; i< height.length; i++)   {
            if(height[i] > maxHeight)   {
                maxHeight = height[i];
            }
            rightMax[i] = maxHeight;
        }
        int[] leftMax = new int[height.length];
        maxHeight = 0;
        for(int i = height.length - 1; i>0; i--)   {
            if(height[i] > maxHeight)   {
                maxHeight = height[i];
            }
            leftMax[i] = maxHeight;
        }
        int totalWater = 0;
        for(int i = 1; i < height.length - 1; i++)  {
            int currentWater = Math.min(rightMax[i], leftMax[i]) - height[i];
            if(currentWater > 0)    {
                totalWater+=currentWater;
            }
        }
        return totalWater;
    }
}
