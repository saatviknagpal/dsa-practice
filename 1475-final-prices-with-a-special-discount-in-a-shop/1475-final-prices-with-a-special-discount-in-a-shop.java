class Solution {

    public int[] finalPrices(int[] prices) {
        /*
        Initialize an empty stack called "stack".
        
        Iterate through the list of prices with a for loop starting at index 0 and ending at the last index of the prices list.
        
        Inside the for loop, check if the stack is not empty and if the price of the item at the top of the stack is greater than or equal to         the price of the current item. If this is true, subtract the price of the current item from the price of the item at the top of the           stack and update the price of the item at the top of the stack in the prices list.
        
        Pop the top element of the stack.
        
        Push the current index to the stack.
        
        After the for loop, return the prices list. */

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) prices[stack.pop()] -= prices[i];
            stack.push(i);
        }
        return prices;
    }
}
