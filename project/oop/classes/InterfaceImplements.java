package classes;

public class InterfaceImplements implements InterfaceClass {
    public boolean hungry = true; 

    public void eat(){
        hungry = false;
    }
    public boolean isHungry(){
        return hungry;
    }
    public void hunt(){
        hungry = true;
    }
}
