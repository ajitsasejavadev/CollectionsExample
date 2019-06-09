
class Stack{

    private int [] stack;
    private int top;
    private int size;

    public Stack(){   // initialize stack
        this.size=10;
        this.top= -1;
        this.stack = new int[size];
    }

    public void setStackSize(int size){
        this.size=size;
        this.stack=new int[size];
    }

    public boolean isEmplty() {return (top== -1);} // check empty or not

    public boolean isFull() {  return (top == stack.length-1); }  // check Full or not

    public int stackSize()
    {
        return top+1;
    }

    public void push(int item){
        if(!isFull())
        {
            top++;
            stack[top]=item;
            System.out.println(item+" inserted at position "+top);
        }
        else{
            System.out.println("Can't insert Stack is full");
        }
    }

    public int pop(){
        if(!isEmplty()){
            return stack[top--];
        } else return -1;
    }

    public String display(){
       if(isEmplty()) return "stack is empty";
       else {
           String arr ="";
           for(int i=0;i<=top;i++)
           {
               arr+=stack[i]+" ";
           }
           return "stack is = "+ arr;
       }
    }
}

public class StackClassic {
    public static void main(String[] args) {
        Stack stack = new Stack() ;
        stack.setStackSize(5);  // if we will not give size then 10 size stack will initialize

        stack.pop();

        stack.push(10);
        stack.push(20);
        stack.push(0);
        stack.push(60);
        stack.push(50);

        System.out.println(stack.isEmplty());
        System.out.println(stack.isFull());
        System.out.println(stack.stackSize());
        System.out.println(stack.display());
        stack.pop();
        System.out.println(stack.display());
    }

}
