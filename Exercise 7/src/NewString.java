import java.lang.String;

class NewString {
    String sentence;

    public NewString(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return this.sentence;
    }

    public String abbreviate() {
        String[] words = this.sentence.split(" ");
        String firstLetters = "";
        for (String word : words) {
            firstLetters = firstLetters + word.substring(0, 1);
        }

        return firstLetters;
    }

    public String removeLetter(String letterToRemove) {
        return this.sentence.replace(letterToRemove, "");
    }
}

class Test {
    public static void main(String[] args) {
        NewString Sentence = new NewString("dette er en string");
        System.out.println(Sentence.removeLetter("e"));

        NewString Sentence2 = new NewString("dette er en annen string");
        System.out.println(Sentence.abbreviate());
    }
}