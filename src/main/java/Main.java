import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class Main {
    // построчное считывание файла
    public static void main(String[] args) {
        try {
            //Создаем объект класса InputStreamReader для считывания строк файла airports
            InputStreamReader file = new InputStreamReader(new FileInputStream("D://airports.dat"), StandardCharsets.UTF_8);
            // В переменную reader типа BufferedReader записываем считанную строку из файла airports
            BufferedReader reader = new BufferedReader(file);
            // Создаем экземпляр класса для последующего вызова его метода connectConfig() и записываем номер колонки в переменную numberColumn
            ConnectConfig connectConfig = new ConnectConfig();
            int numberColumn = connectConfig.connectconfig();
            // Считываем введенные данные с клавиатуры
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите строку:");
            String scanString = scan.nextLine();
            //В переменной start начинаем отсчет в миллисекундах с момента начала алгоритма парсинга
            long start = System.currentTimeMillis();
            // Создаем объект класса ParsingString, в параметры передаем значение строки из файла airports,считанную с клавиатуры строку, и номер колонки
            ParsingString parsingString = new ParsingString(reader, scanString, numberColumn);
            // В переменную list записываем переданное значение из метода parsingString()
            List list = parsingString.parsingString();
            // В переменной timeWorkCode заканчиваем отсчет после завершения алгоритма парсинга
            long timeWorkCode = System.currentTimeMillis() - start;
            //Вызов метода outputStr() с выводом результатов
            OutputStr outputStr = new OutputStr(list);
            outputStr.outputStr();
            // В переменную usedBytes записываем сколько байт потребляет программа. Для корректного вывода делим значение на 1048576, чтобы получить мегабайты
            long usedBytes = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            System.out.println("Скорость выполнения программы: " + timeWorkCode + " миллисекунд, и " + usedBytes / 1048576 + " мегабайт памяти");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}