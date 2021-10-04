import java.lang.String;
import java.util.*;

public class TextProcessor {
    String text;
    String regexWordDefinition = "[\\s\\.\\!\\,\\?\\:\\;]";

    public TextProcessor(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public String getTextUppercase() {
        return this.text.toUpperCase();
    }

    public int wordCount() {
        ArrayList<String> wordsArray = new ArrayList<String>();
        String[] words = this.text.split(this.regexWordDefinition);
        for (String word : words) {
            if (!word.isEmpty()) {
                wordsArray.add(word);
            }
        }

        return wordsArray.size();
    }

    public double averageWordLength() {
        ArrayList<Integer> totalLettersCount = new ArrayList<Integer>();

        String[] words = this.text.split(this.regexWordDefinition);
        for (String word : words) {
            totalLettersCount.add(word.length());
        }

        double sum = 0.0;

        for (int i=0; i<totalLettersCount.size(); i++) {
            sum += totalLettersCount.get(i);
        }

        return sum / totalLettersCount.size();
    }

    public double averageWordCountPerPeriod() {
        //sum words
        //divide by period number
        ArrayList<String> wordsArray = new ArrayList<String>();
        String[] words = this.text.split(this.regexWordDefinition);
        for (String word : words) {
            if (!word.isEmpty()) {
                wordsArray.add(word);
            }
        }


        ArrayList<String> periodArray = new ArrayList<String>();
        String[] periods = this.text.split("[\\.\\!\\?\\:\\;]");

        for (String period : periods) {
            periodArray.add(period);
        }

        return (double)wordsArray.size() / (double)periodArray.size();
    }

    public void searchAndReplace(String search, String replace) {
        this.text = this.text.replace(search, replace);
        //this.text = this.text.replaceAll("\\b"+search, replace);
    }
}

class Test {
    public static void main(String[] args) {
        TextProcessor text = new TextProcessor("Dette er, teksten min øæå. Dette er en annen test ey ahoy! Ahoy til deg også?");

        System.out.println("Antall ord: " + text.wordCount());
        System.out.println("Gjennomsnittlig ordlengde: " + text.averageWordLength());
        System.out.println("Gjennomsnittlig antall ord per periode: " + text.averageWordCountPerPeriod());

        text.searchAndReplace("er", "e");
        text.searchAndReplace("til", "te");
        System.out.println(text.getTextUppercase());
    }
}
