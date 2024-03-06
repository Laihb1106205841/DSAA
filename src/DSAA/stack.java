package DSAA;

// 定义一个泛型栈接口
interface GenericStack<T> {
    void push(T item);
    T pop();
    boolean isEmpty();
}

// Implementation to DSAA.GenericStack
class MyStack<T> implements GenericStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] stack;
    private int size;

    public MyStack() {
        this.stack = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    private void ensureCapacity() {
        if (size == stack.length) {
            Object[] stack2 = new Object[size+10];
            System.arraycopy(stack,0,stack2,0,size);
            stack = stack2;
//            stack = Arrays.copyOf(stack, size+10);
        }
    }

    @Override
    public void push(T element) {
        ensureCapacity();
        //so that the size will be legal when stack[size-1]
        stack[size++] = element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T element = (T) stack[--size];
        stack[size] = null; // Help with garbage collection
        return element;
    }

    public boolean isEmpty() {
        return size == 0;
    }


// 示例用法

    public static void main(String[] args) {
        // 创建一个整数栈
        GenericStack<Integer> intStack = new MyStack<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);

        // 弹出并打印栈顶元素
        while (!intStack.isEmpty()) {
            System.out.println(intStack.pop());
        }

        // 创建一个字符串栈
        GenericStack<String> stringStack = new MyStack<>();
        stringStack.push("A");
        stringStack.push("B");
        stringStack.push("C");

        // 弹出并打印栈顶元素
        while (!stringStack.isEmpty()) {
            System.out.println(stringStack.pop());
        }
    }

}