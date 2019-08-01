public class Main{
    public static void main(String[] args) {
        System.out.println("hello world");
        MOnitorExample mOnitorExample = new MOnitorExample();
        Thread thread1 = new Thread(new Runnable(){
        
            @Override
            public void run() {
                mOnitorExample.write();
            }
        });
        Thread thread2 = new Thread(new Runnable(){
        
            @Override
            public void run() {
                mOnitorExample.write();
            }
        });
        thread1.start();
        thread2.start();
    }
}
class MOnitorExample{
    int a = 0;
    public synchronized void write(){
        a++;
    }

    public synchronized void read(){
        int i = a;
        System.out.println(i);
    }
}
