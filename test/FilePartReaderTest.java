import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {
    FilePartReader filePartReader = new FilePartReader();


    @Test
    void testIsReadEquals() {
        filePartReader.setUp("/home/bertalan/Desktop/codecool/Java_OOP/5.SI/filepartreader-testing-with-junit-BertalanBalazs/src/main/java/file",2 ,100);
        String readResult = filePartReader.read(filePartReader.getFilePath());
        assertEquals("The following are the graphical non-control characters defined by anna\n" +
                "ISO 8859-1 (1987).  Descriptions in words aren't all that helpful,\n" +
                "but they're the best we can do in text.  A graphics file illustrating\n" +
                "the character set should be available from the same archive as this\n" +
                "file.", readResult);
    }

    @Test
    void testIsReadLinesEquals() {
        filePartReader.setUp("/home/bertalan/Desktop/codecool/Java_OOP/5.SI/filepartreader-testing-with-junit-BertalanBalazs/src/main/java/file",1 ,3);
        String readResult = filePartReader.readLines(filePartReader.getFromLine(), filePartReader.getToLine());
        assertEquals("The following are the graphical non-control characters defined by anna\n" +
        "ISO 8859-1 (1987).  Descriptions in words aren't all that helpful,\n" , readResult);
    }

    @Test
    void testIsWordsOrderedAlphabetically() {
        filePartReader.setUp("/home/bertalan/Desktop/codecool/Java_OOP/5.SI/filepartreader-testing-with-junit-BertalanBalazs/src/main/java/file",1 ,2);
        FileWordAnarlyzer fileWordAnarlyzer = new FileWordAnarlyzer(filePartReader);
        String[] k = new String[]{"anna","are", "by", "characters", "defined", "following", "graphical", "non-control" ,"The" ,"the"};
        assertArrayEquals(k, fileWordAnarlyzer.getWordsOrderedAlphabetically().toArray());
    }

    @Test
    void testIsWordsContainingSubstring() {
        filePartReader.setUp("/home/bertalan/Desktop/codecool/Java_OOP/5.SI/filepartreader-testing-with-junit-BertalanBalazs/src/main/java/file",1 ,2);
        FileWordAnarlyzer fileWordAnarlyzer = new FileWordAnarlyzer(filePartReader);
        String[] k = new String[]{"are"};
        assertArrayEquals(k, fileWordAnarlyzer.getWordsContainingSubstring("re").toArray());
    }

    @Test
    void testPalindromesStrings() {
        filePartReader.setUp("/home/bertalan/Desktop/codecool/Java_OOP/5.SI/filepartreader-testing-with-junit-BertalanBalazs/src/main/java/file",1 ,3);
        FileWordAnarlyzer fileWordAnarlyzer = new FileWordAnarlyzer(filePartReader);
        String[] k = new String[]{"anna"};
        assertArrayEquals(k, fileWordAnarlyzer.getStringsWhichPalindromes().toArray());
    }
}