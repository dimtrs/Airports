import org.yaml.snakeyaml.Yaml;

import java.io.*;

public class ConnectConfig {
    //Метод подключения конфига с параметрами конкретной колонки
    public int connectconfig() {
        InputStream inputStream = null;

        try {
            inputStream = new FileInputStream("D:\\air.yml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Yaml yaml = new Yaml();
        return yaml.load(inputStream);
    }
}
