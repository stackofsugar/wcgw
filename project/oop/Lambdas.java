class Lambdas {
    void makeNoise(){
        System.out.println("Wohoo");
    }

    public static void main(String[] argv){
        var obj1 = new Lambdas();
        var obj2 = new Lambdas(){
            void makeNoise(){
                System.out.println("Whooshh");
            }
        };

        obj1.makeNoise();
        obj2.makeNoise();
    }
}
