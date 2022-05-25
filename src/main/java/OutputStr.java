import java.util.Arrays;
import java.util.List;

public class OutputStr {
    private final List<String> stroka;

    public OutputStr(List<String> stroka) {
        this.stroka = stroka;
    }

    public void outputStr() {
        int i;
        for (i = 0; i < stroka.size(); i++) {
            System.out.println(stroka.get(i) + "\n");
        }
        System.out.println("Найдено " + i + " Строк");
    }
}
