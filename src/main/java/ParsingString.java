import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import au.com.bytecode.opencsv.bean.MappingStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParsingString extends CsvToBean {
    private final BufferedReader reader;
    private final String scanString;
    private final int numberColumn;

    public ParsingString(BufferedReader reader, String scanString, int numberColumn) {
        this.reader = reader;
        this.scanString = scanString;
        this.numberColumn = numberColumn;
    }


    public List parsingString() throws IOException {

        // CsvToBean csv = new CsvToBean();
        CSVReader csvReader = new CSVReader(reader);
        //Set column mapping strategy
        List list = parse(setColumMapping(numberColumn), csvReader);
        return list;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    //Метод для сопоставления колонок контейнера и колонок для вывода результата с выбором колонки, предварительно введенной в файл yml
    public static ColumnPositionMappingStrategy setColumMapping(int numberColumn) {
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(ContainerColumns.class);
        if (numberColumn == 1) {
            String[] columns = new String[]{"ID", "FULL_NAME_AIRPORT", "NAME_AIRPORT", "COUNTRY", "THREE_LETTERS", "FOUR_LETTERS", "COORDINATES1", "COORDINATES2", "COORDINATES3", "COORDINATES4", "POLE", "OCEAN", "AIRPORT", "OUR_AIRPORTS"};
            strategy.setColumnMapping(columns);
        } else if (numberColumn == 2) {
            String[] columns = new String[]{"FULL_NAME_AIRPORT", "ID", "NAME_AIRPORT", "COUNTRY", "THREE_LETTERS", "FOUR_LETTERS", "COORDINATES1", "COORDINATES2", "COORDINATES3", "COORDINATES4", "POLE", "OCEAN", "AIRPORT", "OUR_AIRPORTS"};
            strategy.setColumnMapping(columns);
        } else if (numberColumn == 3) {
            String[] columns = new String[]{"NAME_AIRPORT", "ID", "FULL_NAME_AIRPORT", "COUNTRY", "THREE_LETTERS", "FOUR_LETTERS", "COORDINATES1", "COORDINATES2", "COORDINATES3", "COORDINATES4", "POLE", "OCEAN", "AIRPORT", "OUR_AIRPORTS"};
            strategy.setColumnMapping(columns);
        } else if (numberColumn == 4) {
            String[] columns = new String[]{"COUNTRY", "ID", "NAME_AIRPORT", "FULL_NAME_AIRPORT", "THREE_LETTERS", "FOUR_LETTERS", "COORDINATES1", "COORDINATES2", "COORDINATES3", "COORDINATES4", "POLE", "OCEAN", "AIRPORT", "OUR_AIRPORTS"};
            strategy.setColumnMapping(columns);
        } else if (numberColumn == 5) {
            String[] columns = new String[]{"THREE_LETTERS", "ID", "NAME_AIRPORT", "COUNTRY", "FULL_NAME_AIRPORT", "FOUR_LETTERS", "COORDINATES1", "COORDINATES2", "COORDINATES3", "COORDINATES4", "POLE", "OCEAN", "AIRPORT", "OUR_AIRPORTS"};
            strategy.setColumnMapping(columns);
        } else if (numberColumn == 6) {
            String[] columns = new String[]{"FOUR_LETTERS", "ID", "NAME_AIRPORT", "COUNTRY", "THREE_LETTERS", "FULL_NAME_AIRPORT", "COORDINATES1", "COORDINATES2", "COORDINATES3", "COORDINATES4", "POLE", "OCEAN", "AIRPORT", "OUR_AIRPORTS"};
            strategy.setColumnMapping(columns);
        } else if (numberColumn == 7) {
            String[] columns = new String[]{"COORDINATES1", "ID", "NAME_AIRPORT", "COUNTRY", "THREE_LETTERS", "FOUR_LETTERS", "FULL_NAME_AIRPORT", "COORDINATES2", "COORDINATES3", "COORDINATES4", "POLE", "OCEAN", "AIRPORT", "OUR_AIRPORTS"};
            strategy.setColumnMapping(columns);
        } else if (numberColumn == 8) {
            String[] columns = new String[]{"POLE", "ID", "NAME_AIRPORT", "COUNTRY", "THREE_LETTERS", "FOUR_LETTERS", "COORDINATES1", "COORDINATES2", "COORDINATES3", "COORDINATES4", "FULL_NAME_AIRPORT", "OCEAN", "AIRPORT", "OUR_AIRPORTS"};
            strategy.setColumnMapping(columns);
        } else if (numberColumn == 9) {
            String[] columns = new String[]{"OCEAN", "ID", "NAME_AIRPORT", "COUNTRY", "THREE_LETTERS", "FOUR_LETTERS", "COORDINATES1", "COORDINATES2", "COORDINATES3", "COORDINATES4", "POLE", "FULL_NAME_AIRPORT", "AIRPORT", "OUR_AIRPORTS"};
            strategy.setColumnMapping(columns);
        }
        return strategy;
    }

    @Override
    // Переопределенный метод парсинга csv файла и последующей записи значений в list, отсортированных по нужной колонке
    public List parse(MappingStrategy mapper, CSVReader csv) {
        try {
            mapper.captureHeader(csv);
            ArrayList list = new ArrayList();
            String[] line;
            int index;
            while (null != (line = csv.readNext())) {
                index = line[numberColumn - 1].indexOf(scanString);
                if (index != -1) {
                    Object obj = this.processLine(mapper, line);
                    list.add(obj);
                }
            }
            return list;
        } catch (Exception var6) {
            throw new RuntimeException("Error parsing CSV!", var6);
        }
    }
}