public class Droid{
    String name;
    int battery;
    int batterylevel;

    public Droid(String droidName) {
      name = droidName;
      batterylevel = 100;
    }

    public void performTask(String task){
      //this.task = task;
      System.out.println(name + " is performing task:" + task);
      batterylevel -=10;
    }

    public String toString() {
      return "Hello I m the droid " + name;
    }


    public void energyReport(){
      System.out.println("Battery level : " + batterylevel);
    }

    public void energyTransfer() {
      batterylevel = batterylevel;
    }

  public static void main(String[] args){
    Droid codey = new Droid("Codey");
    System.out.println(codey.name);
    codey.performTask("dancing");
    //new instance
    Droid d = new Droid("Nany");
    System.out.println(d.name);
    d.performTask("playing");
    d.energyReport();

  }
}
