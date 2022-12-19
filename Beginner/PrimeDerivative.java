import java.util.ArrayList;
public class PrimeDirective {

     public boolean isPrime(int number) {
        if (number == 2) {
            System.out.println("It is the smallest prime number");
            return true;
        }
        else if(number < 2) {
            System.out.println("It is not a prime");
            return false;
        }
        for (int i=2;i< number;i++) {
            if (number%i == 0) {
                return false;
            }
        }
        return true;
     }

    public static void main(String[] args) {
        PrimeDirective pd = new PrimeDirective();
        System.out.println(pd.isPrime(7));
        System.out.println(pd.isPrime(28));
        System.out.println(pd.isPrime(2));

    }


}
