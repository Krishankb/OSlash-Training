
public class DNA {
    public static void main(String[] args) {

        String dna1 = "ATGCGATACGCTTGA";
        String dna2 = "ATGCGATACGTGA";
        String dna3 = "ATTAATATGTACTGA";

        String[] dna = {dna1,dna2,dna3};

        int dnalength = dna.length;
        System.out.println(dnalength);



        for (int i = 0;i<dnalength;i++) {
            int indexStart = dna[i].indexOf("ATG");
            int indexEnd = dna[i].indexOf("TGA");
            if (indexStart != -1 && indexEnd != -1 && (indexEnd - indexStart)%3 == 0) {
                String protien = dna[i].substring(indexStart, indexEnd+3);
                System.out.println("Protien : " + protien);
                System.out.println("The DNA strand is Positive");

            }
            else {
                System.out.println("No Protien");
            }
        }



    }
}
