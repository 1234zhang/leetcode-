import java.lang.Runnable;
import java.lang.Thread;

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
public class ThreadTest{
    public static void main(String[] args) {
        System.out.println("abcnd");
        MOnitorExample mOnitorExample = new MOnitorExample();
        Thread thread1 = new Thread(new Runnable(){
        
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                }catch(Exception e){
                    e.printStackTrace();
                }
                mOnitorExample.write();
            }
        });
        Thread thread2 = new Thread(new Runnable(){
        
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                }catch(Exception e){
                    e.printStackTrace();
                }
                mOnitorExample.read();
            }
        });
        thread1.start();
        thread2.start();
    }
}

