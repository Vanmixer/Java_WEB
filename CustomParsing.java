package Ivan;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class CustomParsing implements Callable<Void> {

    private final String directoryPath;
    private final ExecutorService executorService;
    private final String resultFilePath;
    private final String letter;

    public CustomParsing(String directoryPath, ExecutorService executorService, String resultFilePath, String letter) {
        this.directoryPath = directoryPath;
        this.executorService = executorService;
        this.resultFilePath = resultFilePath;
        this.letter = letter;
    }

    @Override
    public Void call() throws Exception {
        File file = new File(directoryPath);
        if(!file.exists()) {
            System.out.println("File is not found");
            return null;
        }
        File[] files = file.listFiles();
        ArrayList<Future<Void>> result = new ArrayList<>();
        for (File value : files) {
            if (value.isDirectory()) {
                CustomParsing customParsing = new CustomParsing(value.getAbsolutePath(),executorService, resultFilePath, letter);
                Future<Void> future =  executorService.submit(customParsing);
                result.add(future);
            } else {
                ParsingMethods.findWords(value, resultFilePath, letter);
            }
            for (Future<Void> rez : result)
                rez.get();
        }
        return null;
    }
}
