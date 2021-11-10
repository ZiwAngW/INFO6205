package edu.neu.coe.info6205.sort;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        //if (args.length > 0) ParSort.cutoff = Integer.parseInt(args[0]);
        //System.out.println("Degree of parallelism: " + ForkJoinPool.getCommonPoolParallelism());
        Random random = new Random(0L);
        for(int size=19;size<=21;size++){
            int[] array =new int[1<<size];
            for (int thread = 2; thread <= 8; thread *= 2){
                ParSort ps=new ParSort();
                ps.thread=thread;
                ps.setPool();
                for(int iniCut=25;iniCut<=75;iniCut+=5){
                    ps.cutoff=10000*(iniCut+1);
                    double time;
                    long Start=System.currentTimeMillis();
                    for (int t = 0; t < 10; t++) {
                        for (int i = 0; i < array.length; i++) array[i] = random.nextInt(10000000);
                        ps.sort(array, 0, array.length);
                    }
                    long end = System.currentTimeMillis();
                    time = (double)(end - Start)/10;
                    System.out.println("array size "+array.length+" cutoff：" + ps.cutoff + " current threads: " + ps.thread + "  Time:" + time + "ms");

                }
            }
        }
    }
}
