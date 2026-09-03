class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixOrder = new int[nums.length];
        prefixOrder[0] = 1;
        int[] sufixOrder = new int [nums.length];
        sufixOrder[nums.length-1] = 1;
        for(int i = 1; i <nums.length;i++)  {
            prefixOrder[i] = prefixOrder[i-1]*nums[i-1];
        }
        for(int i = nums.length-2; i >=0;i--)  {
            sufixOrder[i] = sufixOrder[i+1]*nums[i+1];
        }
        for(int i = 0; i < nums.length; i++)    {
            prefixOrder[i] = prefixOrder[i]*sufixOrder[i];
        }
        return prefixOrder;
    }
}  
