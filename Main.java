package Ivan;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    private static final String DIRECTORY_PATH = "";
    private static final String RESULT_FILE_PATH = "";
    public static void main(String[] args) {
        File resultFile = new File(RESULT_FILE_PATH);
        if(resultFile.exists()){
            try {
                new FileWriter(RESULT_FILE_PATH).write("");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter directory -> ");
        String directoryPath = sc.nextLine();
        System.out.print("Enter letter -> ");
        String letter = sc.nextLine();
        ExecutorService executorService = Executors.newCachedThreadPool();
        CustomParsing fileParser = new CustomParsing(directoryPath, executorService, RESULT_FILE_PATH, letter);
        Future<Void> result = (Future<Void>) executorService.submit(fileParser);
        try {
            result.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        ParsingMethods.printFileData(RESULT_FILE_PATH);
    }
}
