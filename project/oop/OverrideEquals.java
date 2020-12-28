// Overriding .equals() built-in class method
// Will also overrode .hashCode() promptly
import java.util.HashSet;

class OverrideEquals {
    public static void main(String[] argv){
        var acc1 = new BankAccounts("Joko", 1142547);
        var acc2 = new BankAccounts("Joko", 1142547);
        var acc3 = new BankAccounts("Kris", 7744124);
        
        var accountCompare = new HashSet<BankAccounts>();
        accountCompare.add(acc1);
        System.out.println("Compare using HashSet");
        System.out.println("acc1 vs acc2 : " + accountCompare.contains(acc2));
        System.out.println("acc1 vs acc3 : " + accountCompare.contains(acc3));

        System.out.println("Compare using .equals");
        System.out.println("acc1 vs acc2: " + acc1.equals(acc2));
        System.out.println("acc1 vs acc3: " + acc1.equals(acc3));

    }
}

class BankAccounts {
    private final String acc_name;
    private final int acc_num;

    BankAccounts(String acc_name, int acc_num){
        this.acc_name = acc_name;
        this.acc_num = acc_num;
    }

    public boolean equals(Object comp){
        if(comp == this){
            return true;
        }
        else if(!(comp instanceof BankAccounts)){
            return false;
        }
        else {
            BankAccounts compcasted = (BankAccounts)comp;
            return ((compcasted.acc_num == this.acc_num) && 
                (compcasted.acc_name.equals(this.acc_name)));
        }
    }
    public int hashCode(){
        int resbuf = 23;
        resbuf = (37 * resbuf) - acc_num;
        return (37 * resbuf + (acc_name != null ? acc_name.hashCode() : 0));
    }
}