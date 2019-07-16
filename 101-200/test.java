import java.util.Random;

import javax.management.relation.RelationService;

import java.util.List;
import java.util.ArrayList;

public class test{
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            list.add(random.nextInt(100));
        }
        for (Integer ints : list) {
            System.out.print(ints + " ");
        }
        System.out.println();
        sort(list, 0, list.size() - 1);
        for (Integer ints : list) {
            System.out.print(ints + " ");
        }
    }
    public static void sort(List<Integer> lists, int left,int right){
        if(left >= right){
            return;
        }
        int mid = (right + left)/2;
        sort(lists, left, mid);
        sort(lists, mid + 1, right);
        merge(lists, left, mid, right);
    }
    
    public static void merge(List<Integer> lists, int left, int mid, int right){
        List<Integer> res = new ArrayList<Integer>();
        int mergeMid = mid + 1;
        int resleft = left;
        while(left <= mid &&  mergeMid <= right){
            if(lists.get(left) < lists.get(mergeMid)){
                res.add(lists.get(left++));
            }else{
                res.add(lists.get(mergeMid++));
            }
        }
        while(left <= mid){
            res.add(lists.get(left++));
        }
        while(mergeMid <= right){
            res.add(lists.get(mergeMid++));
        }
        int resLen = 0;
        while(resleft <= right && resLen < res.size()){
            lists.set(resleft++,res.get(resLen ++));
        }
    }
}