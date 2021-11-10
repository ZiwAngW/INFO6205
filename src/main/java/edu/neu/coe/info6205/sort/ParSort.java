package edu.neu.coe.info6205.sort;
import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class ParSort {
    public static int cutoff;
    public static int thread;
    ForkJoinPool pool;
    public void setPool(){
        pool=new ForkJoinPool(thread);
    }
    public void sort(int[] array, int from, int to){
        int size = from - to + 1;
        if(size<cutoff) Arrays.sort(array,from,to);
        else{
            CompletableFuture<int[]> cf1= ParSort2(array,from,from+(to-from));
            CompletableFuture<int[]> cf2=ParSort2(array,from+(to-from)/2,to);
            CompletableFuture<int[]> cf=cf1.thenCombine(cf2,(xs1,xs2)->{
               int [] output=new int[xs1.length+xs2.length];
                int i = 0;
                int j = 0;
                for (int p = 0; p < output.length; p++) {
                    if (i >= xs1.length) {
                        output[p] = xs2[j++];
                    } else if (j >= xs2.length) {
                        output[p] = xs1[i++];
                    } else if (xs2[j] < xs1[i]) {
                       output[p] = xs2[j++];
                    } else {
                        output[p] = xs1[i++];
                    }
                }
               return output;
            });
            cf.whenComplete((result, throwable) -> System.arraycopy(result, 0, array, from, result.length));
            cf.join();
        }
    }
    public CompletableFuture<int[]> ParSort2(int[] array,int from,int to){

        return CompletableFuture.supplyAsync(()->{
            int[] result = new int[to - from];
            System.arraycopy(array, from, result, 0, result.length);
            sort(result, 0, to - from);
            return result;
        },pool);
    }
}
