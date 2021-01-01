import java.math.BigInteger;
import java.util.Scanner;

////////////////////////////////////////////////////////////////////////////////////////////////////////
class AkuNitip {
    public static void main(String[] argv){
        // Nitip bentar
        var scan = new Scanner(System.in);
        float buffer,
             avgbuffer;
        while(true){
            System.out.println("Enter 4 float numbers");
            avgbuffer = 0;
            for(byte i = 0; i < 4; i++){
                buffer = scan.nextFloat();
                avgbuffer += buffer;
            }
            if(avgbuffer == 0){
                break;
            }
            else {
                System.out.printf("The average is: %.2f\n", (float)avgbuffer / 4.0f);
            }
        }
        scan.close();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    static void isPrime(BigInteger number, BigInteger topBound, BigInteger bottomBound){
        for(var i = bottomBound; i.compareTo(topBound) < 0; i = i.add(BigInteger.ONE)){
            if((number.mod(i)).equals(BigInteger.ZERO)){
                // System.out.println("HIT: " + i);
                // return;  // uncomment to break after 1st hit
            }
        }
        return;
    }
    static BigInteger Big(String value){
        return new BigInteger(value);
    }
    static void unit_test(String test_name, String thisNumber, String thisTopBound, String thisBottomBound){
        var unit_test_object = new Chrono(test_name);
    
        unit_test_object.start();
        isPrime(Big(thisNumber), Big(thisTopBound), Big(thisBottomBound));
        unit_test_object.end();
        unit_test_object.printMillisecond();

        unit_test_object = null;
        return;
    }
}

class Chrono {
    private String process_name;
    private long time_start;
    private long time_end;

    Chrono(String name){
        this.process_name = name;
    }
    public void start(){
        System.out.print("Process " + process_name + " is returned after ");
        time_start = System.nanoTime();
    }
    public void end(){
        time_end = System.nanoTime();
    }
    public void printMillisecond(){
        var result = ((time_end - time_start) / 1000000L);
        System.out.println(result + " Millisecond(s)");
    }
}

// Old tests:

// unit_test("p_Bottom15m", "15000000", "15000000", "2");
// unit_test("p_15mTop30m", "30000000", "30000000", "15000000");
// unit_test("p_Full30m", "30000000", "30000000", "2");
// unit_test("p_15mTop150m", "150000000", "150000000", "135000000");
// unit_test("p_15mTop900m", "900000000", "900000000", "885000000");
// unit_test("p_15mTop2b", "2000000000", "2000000000", "1985000000");

// var divisor = Big("15000000");
// var dividend = Big("1524147891");
// System.out.println("Result: " + dividend.divide(divisor));

// var thread_count = dividend.divide(Big("8"));
// System.out.println("Will accommodate " + thread_count + " iterations per thread.");