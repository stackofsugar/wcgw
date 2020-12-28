class Method {
    static void saySomething(){
        System.out.println("Something");
    }

    static void sayThis(String say_string){
        System.out.println(say_string);
    }
    
    static String gimmeThis(String give_string){
        return give_string;
    }

    public static void main(String[] argv){
        saySomething();
        sayThis("Hello");
        sayThis(gimmeThis("Hello there"));
    }
}
