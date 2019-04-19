import java.util.Arrays;
import java.util.List;


public class FileWordAnarlyzer {

    public FilePartReader filePartReader;

    public FileWordAnarlyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List getWordsOrderedAlphabetically() {
        String splittedLines = filePartReader.readLines(1, 2);
        List<String> readLines = Arrays.asList(splittedLines.split("\\s+"));
        readLines.sort(String::compareToIgnoreCase);
        return readLines;
    }

    public List getWordsContainingSubstring(String subString) {
        String splittedLines = filePartReader.readLines(1, 2);
        List<String> readLines = new java.util.ArrayList<>(Arrays.asList(splittedLines.split("\\s+")));
        readLines.removeIf(a -> !a.toLowerCase().contains(subString.toLowerCase()));
        return readLines;
    }

    public List getStringsWhichPalindromes() {
        String splittedLines = filePartReader.readLines(1, 2);
        List<String> readLines = new java.util.ArrayList<>(Arrays.asList(splittedLines.split("\\s+")));
        readLines.removeIf(a -> {
            StringBuilder word1 = new StringBuilder();
            word1.append(a);
            return !a.contentEquals(word1.reverse());
        });
        return readLines;
    }
}
