package edu.neu.coe.info6205.union_find;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class UF_client {
    public static int count(int n){
        UF_HWQUPC u_F= new UF_HWQUPC(n);
        Random rand=new Random();
//        boolean [] checker= new boolean[n];
//        Arrays.fill(checker,false);
        int result=0;
        while(u_F.components()!=1){
            int p = rand.nextInt(n);
            int q = rand.nextInt(n);
            result++;
            if(!u_F.connected(p,q)){
//                checker[p]=true;
//                checker[q]=true;
                u_F.union(p,q);
            }

//            if(allMarked(checker)){
//                break;
//            }
        }
        return result;
    }
    public static boolean allMarked(boolean[] a)
    {
        for(boolean check : a) if(!check) return false;
        return true;
    }

    public static void main(String[] args){
        Scanner inPut=new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int c = 0;
        c = inPut.nextInt();
        int total=0;
        for(int j=c;j<c*c;j+=j)
        {
            for(int i=0;i<100;i++){

                total +=count(j);
            }
            System.out.println(j+" objects "+total/100.0+" pairs "+0.5*j*Math.log(j)+" perdiction");
        }
    }
}
