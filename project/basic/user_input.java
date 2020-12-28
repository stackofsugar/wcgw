import java.util.Scanner;

class UserInput {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str_userinput = scanner.nextLine();
        System.out.println(scanner.nextLine());
        scanner.close();
        System.out.println("This is: " + str_userinput);
    }
}