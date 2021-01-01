import java.util.Scanner;

class ThrowingExceptions {
    public static void main(String[] argv){
        int numa, numb;

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter 2 integers to be divided: ");
        numa = scan.nextInt();
        numb = scan.nextInt();

        try {
            System.out.println("The result is: " + divideInteger(numa, numb));
        } catch (ArithmeticException ex) {
            System.out.println("Exception caught: " + ex.getLocalizedMessage());
        }

        scan.close();
    }

    static int divideInteger(int a, int b) throws ArithmeticException {
        if(b == 0){
            throw new ArithmeticException("Division by zero");
        }
        else if(b > a){
            throw new ArithmeticException("Divisor larger than dividend");
        }
        else {
            return (a / b);
        }
    }
}
