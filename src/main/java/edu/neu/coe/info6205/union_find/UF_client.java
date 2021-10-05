package edu.neu.coe.info6205.union_find;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class UF_client {
    public static int count(int n){
        UF_HWQUPC u_F= new UF_HWQUPC(n);
        Random rand=new Random();
        boolean [] checker= new boolean[n];
        Arrays.fill(checker,false);
        int result=0;
        while(true){
            int p = rand.nextInt(n);
            int q = rand.nextInt(n);
            if(!u_F.connected(p,q)){
                checker[p]=true;
                checker[q]=true;
                u_F.union(p,q);
                result++;
            }
            if(allMarked(checker)){
                break;
            }
        }
        return result;
    }
    public static boolean allMarked(boolean[] a)
    {
        for(boolean check : a) if(!check) return false;
        return true;
    }

    public static void main(String[] args){
//        Scanner inPut=new Scanner(System.in);
//        System.out.print("Enter an integer: ");
//        int c = -1;
//        c = inPut.nextInt();
        int total=0;
        for(int i=0;i<100;i++){
            total = total+count(50);
        }
        System.out.println("Average pairs over 1000 tries: "+total/100.0);
    }
}
