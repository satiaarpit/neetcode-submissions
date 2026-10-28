class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] leftRange = new int[heights.length];
        int[] rightRange = new int[heights.length];
        for(int i = 0; i < heights.length; i++) {
            while(!stack.isEmpty() && heights[i]<= heights[stack.peek()])    {
                stack.pop();
            }
            leftRange[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        stack=new Stack<Integer>();
        for(int i = heights.length-1; i >=0; i--) {
            while(!stack.isEmpty() && heights[i]<= heights[stack.peek()])    {
                stack.pop();
            }
            rightRange[i]=stack.isEmpty()?heights.length:stack.peek();
            stack.push(i);
        }
        int max = 0;
        for(int i = 0; i < heights.length; i++) {
            int current = heights[i]*(rightRange[i] - leftRange[i] - 1);
            if(current > max)   {
                max=current;
            }
        }
        return max;
    }
}
