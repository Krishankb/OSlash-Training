public class Magic {
  public static void main(String[] args) {
    //myNumber is the original number
    int myNumber = 67;
    int magicNumber = myNumber*myNumber;
    magicNumber = magicNumber + myNumber;
    magicNumber = magicNumber / myNumber;
    magicNumber = magicNumber + 17;
    magicNumber = magicNumber - myNumber;
    magicNumber = magicNumber /6;
    System.out.println(magicNumber);

  }
}
