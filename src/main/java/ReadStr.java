import java.io.BufferedReader;
import java.io.IOException;

public class ReadStr {
    public String readstr(BufferedReader reader) throws IOException {
        while (reader.ready()) {
            String tmp = reader.readLine();
            return tmp;
        }
        return null;
    }
}


// ArrayList<String> list = new ArrayList<>();
// while (reader.ready()) {
// String tmp = reader.readLine();
// if (tmp.contains(scan.nextLine())) {
//list.add(tmp);