class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int maxVol = 0;
        while(i<j)  {
            int currentVol = Math.min(heights[i], heights[j])* Math.abs(i-j);
            if (currentVol > maxVol)    {
                maxVol = currentVol;
            }
        if(heights[i]>heights[j]){
            j--;
        } else  {
            i++;
        }
        }
        return maxVol;
    }
}
