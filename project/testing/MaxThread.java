// FInding out maximum number of thread until effectivity breaks
import java.math.BigInteger;

class MaxThread {
    public static void main(String[] args) throws Throwable {
        Chronox thread_make = new Chronox("thread_make");
        Chronox thread_all_run = new Chronox("thread_all_run");

        thread_make.start();
        Worker tr1 = new Worker("tr1");
        Worker tr2 = new Worker("tr2");
        Worker tr3 = new Worker("tr3");
        Worker tr4 = new Worker("tr4");
        thread_make.end();

        thread_all_run.start();
        tr1.start();
        tr2.start();
        tr3.start();
        tr4.start();

        tr1.join();
        tr2.join();
        tr3.join();
        tr4.join();
        thread_all_run.end();

        thread_make.printMillisecond();
        thread_all_run.printMillisecond();
    }
}

class Worker extends Thread {
    Worker(String name){
        this.setName(name);
    }

    public void run(){
        // System.out.println("Thread: " + this.getName() + " is starting");
        // isPrime(Big("100000"), Big("100"), Big("2"));
        isPrime(Big("15000000"), Big("15000000"), Big("2"));
        // System.out.println("Thread: " + this.getName() + " is killed");
    }

    static void isPrime(BigInteger number, BigInteger topBound, BigInteger bottomBound){
        for(var i = bottomBound; i.compareTo(topBound) < 0; i = i.add(BigInteger.ONE)){
            if((number.mod(i)).equals(BigInteger.ZERO)){
                System.out.println("HIT: " + i);
                // return;  // uncomment to break after 1st hit
            }
        }
        return;
    }

    static BigInteger Big(String value){
        return new BigInteger(value);
    }
}

class Chronox {
    private String process_name;
    private long time_start;
    private long time_end;
    static byte threadCount;

    Chronox(String name){
        this.process_name = name;
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