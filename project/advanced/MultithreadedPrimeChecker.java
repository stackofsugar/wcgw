import java.math.BigInteger;
import java.util.Scanner;

class MultithreadedPrimeChecker {
    public static void main(String[] argv){
        final BigInteger THREAD_THRESHOLD = Big("15000000");
        final byte THREAD_LIMIT = 8;
        final BigInteger THREAD_MAX_GOOD = Big("120000000");
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
                // Thread count decider
            final byte THREAD_COUNT;
            if(input_val.compareTo(THREAD_MAX_GOOD) <= 0){

            }
            else {
                THREAD_COUNT = 8;
            }
        }
    }

    static BigInteger Big(String value){
        return new BigInteger(value);
    }

    static boolean numberValidate(String input){
        boolean is_healthy = true;
        for(int i = 0; i < input.length(); i++){

        }

        if(is_healthy){
            return true;
        }
        else {
            return false;
        }
    }

}
