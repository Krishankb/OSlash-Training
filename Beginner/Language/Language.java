package org.example;

class Language {
    protected String name;
    protected int numSpeakers;
    protected String regionsSpoken;
    protected  String wordOrder;

    Language(String langname,int speakers,String regions, String wOrder) {
        this.name = langname;
        this.numSpeakers = speakers;
        this.regionsSpoken =regions;
        this.wordOrder = wOrder;

    }

    public void getInfo() {
        System.out.println(this.name+" is spoken by " + this.numSpeakers +"people mainly in " +this.regionsSpoken+ " .\n" +
                "The language follows the word order: "+ this.wordOrder+".");
    }

    public static void main(String[] args) {
        Language spain = new Language("Spanish",48451,"Spain","sub+verb+predicate");
        spain.getInfo();

        Mayan kiche = new Mayan("Ki'che", 2333300);
        kiche.getInfo();

        SinoTibetan mandarin = new SinoTibetan("Mandarin chinese",15451541);
        mandarin.getInfo();

        SinoTibetan burmese = new SinoTibetan("Burmese",54515415);
        burmese.getInfo();
    }

}
