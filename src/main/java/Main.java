import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class Main {
    // построчное считывание файла
    public static void main(String[] args) {
        try {
            InputStreamReader file = new InputStreamReader(new FileInputStream("D://airports.dat"), StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(file);
            ConnectConfig connectConfig = new ConnectConfig();
            int numberColumn = connectConfig.connectconfig();
            System.out.println("Введите строку:");
            Scanner scan = new Scanner(System.in);
             String ScanString = scan.nextLine();
           // String ScanString = "Wi";
            long start = System.currentTimeMillis();
            ParsingString readStr = new ParsingString(reader, ScanString, numberColumn);
            List<String> stroka = readStr.readstr();
            long timeWorkCode = System.currentTimeMillis() - start;
            OutputStr outputStr = new OutputStr(stroka);
            outputStr.outputStr();
            long usedBytes = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
            System.out.println("Скорость выполнения программы: " + timeWorkCode + " миллисекунд, и " +usedBytes/1048576 + " мегабайт памяти");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
