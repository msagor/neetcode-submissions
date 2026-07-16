//solution from chatgpt
public class MinStack {
    // Stores the current minimum value in the stack
    long min;

    // Stores encoded values instead of the actual values
    Stack<Long> stack;

    // Create an empty stack
    public MinStack() {
        stack = new Stack<>();
    }

    // Add a value to the stack
    public void push(int val) {
        // If this is the first value
        if (stack.isEmpty()) {
            // Store 0 because this value is the current minimum
            stack.push(0L);

            // Set the minimum value
            min = val;
        } else {
            // Store the difference between the new value and the current minimum
            stack.push(val - min);

            // If the new value is smaller than the current minimum,
            // update min to the new value
            if (val < min) min = val;
        }
    }

    // Remove the top value from the stack
    public void pop() {
        // Nothing to remove if the stack is empty
        if (stack.isEmpty()) return;

        // Remove the encoded value
        long pop = stack.pop();

        // A negative encoded value means that the popped value
        // was the minimum value at the time it was pushed.
        //
        // Example:
        // min = 3
        // val = 1
        // encoded value = 1 - 3 = -2
        //
        // To restore the previous minimum:
        // previous min = current min - encoded value
        // previous min = 1 - (-2) = 3
        if (pop < 0) min = min - pop;
    }

    // Return the value at the top of the stack
    public int top() {
        // Get the encoded value at the top
        long top = stack.peek();

        // If the encoded value is positive,
        // the actual value is top + min
        if (top > 0) {
            return (int) (top + min);
        } else {
            // If the encoded value is 0 or negative,
            // the top value is the current minimum
            return (int) min;
        }
    }

    // Return the current minimum value
    public int getMin() {
        return (int) min;
    }
}