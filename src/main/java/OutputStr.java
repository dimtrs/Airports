import java.util.Arrays;
import java.util.List;

public class OutputStr {
    private final List list;

    public OutputStr(List list) {
        this.list = list;
    }

    // Метод перебора значений list и последующий их вывод вместе с результатом количества строк
    public void outputStr() {
        int i = 0;
        for (Object object : list) {
            ContainerColumns containerColumns = (ContainerColumns) object;
            System.out.println(containerColumns);
            i++;
        }
        System.out.println("Найдено " + i + " Строк");
    }
}