import java.math.BigInteger;
import java.util.Scanner;
import java.util.concurrent.RecursiveTask;

class MultithreadedPrimeChecker {
    public static void main(String[] argv){
        boolean is_done = false;

        while(!is_done){
            // Intro
            System.out.println("Welcome to Multithreaded Prime Checker \n(C) 2020 Christopher Digno");
            System.out.print("Please enter the value you want to check: ");
            // Input section
            BigInteger input_val;
            var scan = new Scanner(System.in);
            while(true){
                var str_input = scan.nextLine();
                var strinput_scan = new Scanner(str_input);
                if((str_input.contains(" "))){
                    System.out.print("Sorry, number can't contain spaces. \nPlease try again: ");
                }
                else {
                    if(strinput_scan.hasNextBigInteger()){
                        input_val = Big(str_input);
                        break;
                    }
                    else {
                        System.out.print("Sorry, " + str_input + " was not a valid number. \nPlease try again: ");
                    }
                }
                strinput_scan.close();
            }
            scan.close();
            System.out.println("Your input is " + input_val);
            // Computation section
            final byte THREAD_COUNT = (byte)Runtime.getRuntime().availableProcessors();

        }
    }

    static BigInteger Big(String value){
        return new BigInteger(value);
    }
}

class Worker extends RecursiveTask<Boolean> {
    private static final long serialVersionUID = -7470106627408756453L;
    private final BigInteger VALUE_THRESHOLD = Big("15000000");
    private final BigInteger VALUE_MAX_GOOD = Big("120000000");

    private byte NUM_THREADS;
    private BigInteger input;
    private BigInteger top_bound;
    private BigInteger toe_bound;

    Worker(BigInteger input, byte NUM_THREADS){
        this.NUM_THREADS = NUM_THREADS;
        this.input = input;
    }

    protected Boolean compute() {
        if(NUM_THREADS == 1){

        }
        else {

        }

        return null;
    }
    
    static BigInteger Big(String value){
        return new BigInteger(value);
    }

    static Boolean isPrime(BigInteger number, BigInteger topBound, BigInteger toeBound){
        for(var i = toeBound; i.compareTo(topBound) < 0; i = i.add(BigInteger.ONE)){
            if((number.mod(i)).equals(BigInteger.ZERO)){
                return false;
            }
        }
        return true;
    }
}
