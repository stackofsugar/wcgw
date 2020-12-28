package classes;

class Main {
    public static void main(String[] argv){
        Dog buddy = new Dog();
        AbstractClass abstr = new AbstractInherit();
        InterfaceClass itvc = new InterfaceImplements();

        buddy.bark(4);
        System.out.println("Overloaded functs: " + buddy.ovMethod(5) + 
            " and " + buddy.ovMethod(5.64));
        buddy = null;
        
        for(byte i = 0; i < 10; i++){
            abstr.increment();
        }
        System.out.println(abstr.getCount()); 
        abstr = null;

        itvc.eat();
        System.out.println(itvc.isHungry());
        itvc.hunt();
        System.out.println(itvc.isHungry());
        itvc = null;

        System.gc();
    }
}
