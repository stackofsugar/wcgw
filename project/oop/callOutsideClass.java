import classes.Dog;

class CallClass {
    public static void main(String[] argv){
        System.out.println("I'm calling a class outside its dir: ");
        Dog sweety = new Dog();
        sweety.bark(4);
    }
}
