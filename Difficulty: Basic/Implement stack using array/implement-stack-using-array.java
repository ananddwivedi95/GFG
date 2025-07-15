class MyStack {
    private int[] arr;
    private int top;
    private int size;
    public MyStack() {
        arr = new int[1000];
        size=arr.length;
        top = -1;
    }

    public void push(int x) {
        // Your Code
        if(top>=size)
        {
            return;
        }
        top++;
        arr[top]=x;
    }

    public int pop() {
        // Your Code
        if(isEmpty())
        {
            return -1;
        }
        int popElement=arr[top];
        top--;
        return popElement;
    }
    public boolean isEmpty()
    {
        if(top<0)
        {
            return true;
        }
        return false;
    }
}