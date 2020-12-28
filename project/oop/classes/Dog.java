package classes;

public class Dog {
    public void bark(int times){
        if(times < 0){
            System.out.println("What?");
        }
        else {
            for(int i = 0; i < times; i++){
                System.out.println("Woof!");
            }
        }
    }

    public int ovMethod(int num){
        return num;
    }

    public double ovMethod(double num){
        return num;
    }
}