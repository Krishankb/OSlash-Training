package org.example;

public class Mayan extends Language {

    Mayan(String languageName,int speakers) {
        super(languageName,speakers,"Central America","Verb-object-subject");
        if(languageName.contains("Chinese")) {
            this.wordOrder = "subject-verb-object";
        }
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println(this.name+" is spoken by " + this.numSpeakers +"people mainly in Central America \n\" +\n" +
                "                \"The language follows the word order: verb-object-subject. \n Fun fact : "+ this.name+" is an ergative language.");
    }

    public static void main(String[] args) {

    }

}


//public class SinoTibetan extends Language {
//
//}