import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FilePartReader {

    private String filePath;
    private Integer fromLine;
    private Integer toLine;


    public FilePartReader() {
        this.filePath = null;
        this.fromLine = null;
        this.toLine = null;
    }

    public String getFilePath() {
        return filePath;
    }

    public Integer getFromLine() {
        return fromLine;
    }

    public Integer getToLine() {
        return toLine;
    }

    public void setUp(String filePath, Integer fromLine, Integer toLine) {
        if(toLine < fromLine || fromLine < 1) throw new IllegalMonitorStateException("Lajos");
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }


    public String read(String filePath){
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
            contentBuilder.setLength(contentBuilder.length()-1);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }


    //Take care because if fromLine is 1, it means the very first row in the file.
    // Also, if fromLine is 1 and toLine is 1 also, we will read only the very first line.
    public String readLines(Integer fromLine, Integer toLine){
        String file = read(filePath);
        List<String> text = Arrays.asList(file.split("\n"));
        StringBuilder readLinesString = new StringBuilder();
        for(int i=fromLine-1; i<toLine-1; i++){
            readLinesString.append(text.get(i)).append("\n");
        }
        return readLinesString.toString();
    }
}
