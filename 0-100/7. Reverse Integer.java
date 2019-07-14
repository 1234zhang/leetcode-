class Solution{
    public int reverse(int x){
        int result = 0;
        while(x != 0){
            int tail = x%10;
            int newResult = result * 10 + tail;
            if((newResult-tail)/10 != result){
                return 0;
            }
            result = newResult;
            x = x/10;
        }
        return result;
    }
}
/**
 * NOte:
 * 在Java中发生int整型溢出的时候，Java 不会对溢出报错，而是将高位
 * 截取，只留下2^32-1位。
 */