package main.java;

import java.util.ArrayList;

public class WordSplitter {
    public static void main(String[] args) {
        System.out.println("The final amount of messages: "
                + messageCounter("This is the test message hello", 10));
    }

    private static int messageCounter(String str, int n) {
        int result = 0;
        for (String message : getPartsOfText(str, n)) {
            if (message.length() > n){
                result = -1;
                break;
            }
            else {
                result++;
            }
        }
        if (result != -1){
            for (String message : getPartsOfText(str, n)) {
                System.out.println(message);
            }
        }
        return result;
    }

    private static String[] getPartsOfText(String text, int n) {
        ArrayList<String> stringList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        int currLengthPart = 0;
        for (String word : text.split(" ")) {
            currLengthPart += word.length() + 1;
            if (currLengthPart <= n + 1)
                stringBuilder.append(' ').append(word);
            else {
                stringList.add(stringBuilder.substring(1));
                stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append(' ').append(word);
                currLengthPart = word.length() + 1;
            }
        }
        stringList.add(stringBuilder.substring(1));
        return stringList.toArray(new String[0]);
    }
}
