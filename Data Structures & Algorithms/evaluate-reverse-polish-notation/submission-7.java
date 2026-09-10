class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("/") || tokens[i].equals("*"))	{
		if(stack.size() > 1)	{
			int result = 0;
			int operand2 = stack.pop();
			int operand1  = stack.pop();
			if(tokens[i].equals("+"))	{
				result = operand1 + operand2;
			} else if(tokens[i].equals("-"))	{
				result = operand1 - operand2;
			} else if(tokens[i].equals("*"))	{
				result = operand1 * operand2;
			} else if(tokens[i].equals("/"))	{
				result = operand2 == 0 ? 0 : operand1 / operand2;
			}
			stack.push(result);
		}
	    } else	{
		int num = Integer.parseInt(tokens[i]);
		stack.push(num);
	    }
        }
	return stack.pop();
    }
}