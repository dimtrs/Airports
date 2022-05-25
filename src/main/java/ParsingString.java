import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParsingString {
    private final BufferedReader reader;
    private final String ScanString;
    private final int numberColumn;

    public ParsingString(BufferedReader reader, String scanString, int numberColumn) {
        this.reader = reader;
        this.ScanString = scanString;
        this.numberColumn = numberColumn;
    }

    public List<String> readstr() throws IOException {
        List<String> arrayList = new ArrayList<>();
        List<String> arrayListString = new ArrayList<>();
        String[] subStr=null;
        String listString=null;
        while (reader.ready()) {
            subStr = reader.readLine().split(",");
            if (subStr[numberColumn].contains(ScanString)) {
                Collections.addAll(arrayList, subStr);
                arrayList.set(0, arrayList.get(numberColumn));
                listString = String.join(", ", arrayList);
                Collections.addAll(arrayListString, listString);
            }
            arrayList.clear();
        }
        Collections.sort(arrayListString);
        return arrayListString;

    }
}
