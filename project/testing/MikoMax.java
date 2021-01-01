import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MikoMax {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int optimalThreads = Runtime.getRuntime().availableProcessors();
        int threadsFrom;
        int threadsTo;

        System.out.printf("Enter number of threads (optimal = %d): ", optimalThreads);
        threadsFrom = input.nextInt();
        input.nextLine();

        if (threadsFrom != 0) {
            threadsTo = threadsFrom;
        } else {
            threadsFrom = 1;
            threadsTo = optimalThreads;
            System.out.println("Benchmarking up to optimal threads");
        }

        System.out.printf("Enter lower bound: ");
        long lb = input.nextLong();
        input.nextLine();

        System.out.printf("Enter upper bound: ");
        long ub = input.nextLong();
        input.nextLine();

        for (int i = threadsFrom; i <= threadsTo; i++) {
            System.out.printf("Using %d threads\n", i);
        
            Sum sum = new Sum(lb, ub, i);
            ForkJoinPool pool = new ForkJoinPool(i);

            System.out.println("Computing sum...");
            long start = System.nanoTime();
            long result = pool.invoke(sum);
            long stop = System.nanoTime();
            System.out.printf("Done with result: %d\n", result);
            System.out.printf("Took %dms to perform the computation\n", (stop - start) / 1000000L);
        }
        input.close();
    }
}   

class Sum extends RecursiveTask<Long> {

    private static final long serialVersionUID = 1L;
    private long low;
    private long high;
    private int threads;

    Sum(long low, long high, int threads) {
        this.low = low;
        this.high = high;
        this.threads = threads;
    }

    protected Long compute() {
        if (this.threads == 1) {
            long result = 0L;
            for (long i = this.low; i <= this.high; i++) {
                result = (result + (i % 1000000000L)) % 1000000000L;
            }
            return result;
        }
        Sum[] tasks = new Sum[this.threads];
        long delta = (high - low + 1) / this.threads;
        long remainder = (high - low + 1) % this.threads;
        long current = this.low;
        for (int i = 0; i < this.threads; i++) {
            long stride = delta;
            if (remainder > 0) {
                stride++;
                remainder--;
            }
            tasks[i] = new Sum(current, current + stride - 1, 1);
            if (i < this.threads - 1) {
                tasks[i].fork();
            }
            current = current + stride;
        }

        long result = tasks[this.threads - 1].compute();
        for (int i = 0; i < this.threads - 1; i++) {
            result = (result + tasks[i].join()) % 1000000000L;
        }
        return result;
    }

}