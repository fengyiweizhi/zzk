package leetcode;

/**
 * @author 风亦未止
 * @date 2021/11/17 21:30
 */
public class MinStack {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(-1);
        stack.push(3);
        int min = stack.getMin();
        int top = stack.top();
        System.out.println("最小值："+min+"顶端值："+top);

    }

}
class Stack {
    private int[] a;
    private int last;

    public Stack() {
        last=-1;
        a=new int[1];
    }

    public void push(int val) {
        if (last==-1){
            a[0]=val;
            last=a.length-1;
            return;
        }
        int[] newData=new int[a.length+1];
        newData[newData.length-1]=val;
        System.arraycopy(a,0,newData,0,a.length);
        a=newData;
        last=a.length-1;
    }

    public void pop() {
        int[] newData=new int[a.length-1];
        System.arraycopy(a,0,newData,0,a.length-1);
        a=newData;
        last=a[a.length-1];
    }

    public int top() {
        return a[a.length-1];
    }

    public int getMin() {
        int min=a[a.length-1];
        for(int x:a){
            min = Math.min(min,x);
        }
        return min;
    }
}