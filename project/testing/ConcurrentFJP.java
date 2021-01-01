// Finding out maximum number of thread until effectivity breaks
// ForkJoinPool enters the chat
import java.math.BigInteger;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.Scanner;

class ConcurrentFJP {
    public static void main(String[] args) throws Throwable {
        final byte NUM_CORE = (byte)Runtime.getRuntime().availableProcessors();
        final byte NUM_TEST_CORE;
        var scan = new Scanner(System.in);

        System.out.print("Enter your testing core (Effective = " + NUM_CORE + " ): ");
        NUM_TEST_CORE = scan.nextByte();
        System.out.println("Testing from 1 core to: " + NUM_TEST_CORE + " core(s)");
        for(byte NUM_THREADS = 1; NUM_THREADS <= NUM_TEST_CORE; NUM_THREADS++){
            var timer = new Chronox();
            var fjp_object = new ForkJoinPool(NUM_THREADS);

            timer.start();
            fjp_object.invoke(new getBigPrime(Big("15000000"), NUM_THREADS));
            timer.end();
            timer.printMillisecond();

            timer = null;
        }
        scan.close();
    }

    public static BigInteger Big(String value){
        return new BigInteger(value);
    }
}

class getBigPrime extends RecursiveAction {
    private static final long serialVersionUID = 1L;
    private BigInteger topBound;
    private BigInteger toeBound;
    private BigInteger thisNumber;
    private byte num_threads;

    getBigPrime(BigInteger top, BigInteger toe, BigInteger thisNum, byte num_threads){
        topBound = top;
        toeBound = toe;
        thisNumber = thisNum;
        this.num_threads = num_threads;
    }

    getBigPrime(BigInteger this_num, byte num_thread){
        this(this_num, Big("2"), this_num, num_thread);
    }

    protected void compute() {
        if(this.num_threads == 1){
            isPrime(thisNumber, topBound, toeBound);
            return;
        }
        else {
            var task = new getBigPrime[this.num_threads];
            for(byte i = 0; i < this.num_threads; i++){
                task[i] = new getBigPrime(thisNumber, (byte)1);
                if(i < (this.num_threads - 1)){
                    task[i].fork();
                }
            }
            task[this.num_threads - 1].compute();
            for(byte i = 0; i < (this.num_threads - 1); i++){
                task[i].join();
            }
            return;
        }
    }

    static BigInteger Big(String value){
        return new BigInteger(value);
    }

    static void isPrime(BigInteger number, BigInteger topBound, BigInteger toeBound){
        for(var i = toeBound; i.compareTo(topBound) < 0; i = i.add(BigInteger.ONE)){
            if((number.mod(i)).equals(BigInteger.ZERO)){
                // System.out.println("HIT: " + i);
                // return;  // uncomment to break after 1st hit
            }
        }
        return;
    }
}

class Chronox {
    private String process_name;
    private long time_start;
    private long time_end;
    static Byte num_obj = 0;

    Chronox(String name){
        this.process_name = name;
    }

    Chronox(){
        num_obj++;
        String process_name;
        process_name = "use-" + num_obj.toString() + "-core";
        this.process_name = process_name;
    }

    public void start(){
        time_start = System.nanoTime();
    }

    public void end(){
        time_end = System.nanoTime();
    }

    public void printMillisecond(){
        var result = ((time_end - time_start) / 1000000L);
        System.out.print("Process " + process_name + " is returned after ");
        System.out.println(result + " Millisecond(s)");
    }
}
