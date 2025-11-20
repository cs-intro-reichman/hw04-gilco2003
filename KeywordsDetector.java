import javax.print.DocFlavor.STRING;

public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
            "Our product will transform the market",
            "Programming is both painful and engaging",
            "This has nothing to do with machine learning",
            "We need to leverage our core competencies",
            "Let's talk about data and algorithms",
            "Chatbots are great but must be used carefully",
            "This blockchain-based solution will disrupt the industry",
            "The team showed great Synergy in the last project",
            "Use simple words without hype and fluff",
            "Our new technology presents a significant paradigm shift",
            "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations 
        String[] keywords = {"synergy", "disrupt", "leverage", "Paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    }
    //counts how many spaces there are in a sentence
    public static int countSpaces(String str){
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        return count;
    }
    //recieves a sentence and returns an array of all the words in said sentence.
    public static String[] spiltSentnce(String str) {
        int j = 0;
        String[] spilt = new String[countSpaces(str) + 1];
        spilt[j] = "";
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != ' ') {
                spilt[j] = spilt[j] + str.charAt(i);
            }
             else {
                j++;
                spilt[j] = "";
             }

        }
        return spilt;
    }
    //checks if a word is in a sentence
    public static boolean isInASentence(String[] sentence, String word) {
        for(int i = 0; i < sentence.length; i++){
            if(sentence[i].toLowerCase().equals(word.toLowerCase()))
                return true;
        }
        return false;
    }

    // Iterates through all the sentences.
    // If a sentence contains one or more of the kewords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {
        String[] temp;
        for(int i = 0; i < sentences.length; i++) { 
            temp = spiltSentnce(sentences[i]);
            for(int j = 0; j < keywords.length; j++ )
            if (isInASentence(temp, keywords[j])) {
                System.out.println(sentences[i]);
            }
            
    }
}}
