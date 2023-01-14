package Ivan;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsingMethods {
    
    public static void printFileData(String resultFilePath){
        try {
            FileReader fileReader = new FileReader(resultFilePath);
            Scanner sc = new Scanner(fileReader);
            while (sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void findWords(File file, String resultFilePath, String letter) throws FileNotFoundException {
        FileReader fr = new FileReader(file);
        Scanner sc = new Scanner(fr);
        ArrayList<String> fileContent = new ArrayList<>();
        int wordsCount = 0;
        while (sc.hasNext()){
            fileContent.add(sc.next().toLowerCase(Locale.ROOT));
        }
        String customRegex = "\\b"+letter.toLowerCase(Locale.ROOT)+"([A-Za-z�-��-���������������])+(\\.)*(\\d*|\\s)(\\b)";
        Pattern pattern = Pattern.compile(customRegex);
        Matcher matcher = pattern.matcher(fileContent.toString());
        while (matcher.find()){
            wordsCount++;
        }
        if(wordsCount!=0){
            try {
                FileWriter fileWriter = new FileWriter(resultFilePath,true);
                fileWriter.write("File: " + file.getName() + " count of words which begin with the letter "+letter+": " + wordsCount + "\n");
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
