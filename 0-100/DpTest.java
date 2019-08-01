public class DpTest{
    public static Integer cutRod(int n, int[] price){
        int[] memory = new int[10];
        return getMaxPrice(n, price, memory);
    }
    public static Integer getMaxPrice(int n, int[] price, int[] memory){
        if(memory[n] > 0){
            return memory[n];
        }
        if(n == 0){
            return 0;
        }
        int p = 0;
        for (int i = 0; i < n; i++) {
            p = Math.max(p, price[i] + getMaxPrice(n - i, price, memory));
        }
        memory[n] = p;
        return p;
    }
    public static void main(String[] args) {
        System.out.println("hello world");
    }
}