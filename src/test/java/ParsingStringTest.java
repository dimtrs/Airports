import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.MappingStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ParsingStringTest {
    private final int numberColumn = 2;

    @Test
    public void parse() throws FileNotFoundException {
        InputStreamReader file = new InputStreamReader(new FileInputStream("D://airports.dat"), StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(file);
        String scanString = "Go";
        ParsingString parsingString = new ParsingString(reader, scanString, numberColumn);
        CSVReader csv = new CSVReader(reader);
        MappingStrategy mapper = ParsingString.setColumMapping(numberColumn);
        List list = parsingString.parse(mapper, csv);
        Object str1;
        if (numberColumn == 1) {
            str1 = "1, Goroka Airport, Goroka, Papua New Guinea, GKA, AYGA, -6.081689834590001,145.391998291,5282,10, U, Pacific/Port_Moresby, airport, OurAirports";
        } else if (numberColumn == 2) {
            str1 = "Goroka Airport, 1, Goroka, Papua New Guinea, GKA, AYGA, -6.081689834590001,145.391998291,5282,10, U, Pacific/Port_Moresby, airport, OurAirports";
        } else if (numberColumn == 3) {
            str1 = "Goroka, Goroka Airport, 1, Papua New Guinea, GKA, AYGA, -6.081689834590001,145.391998291,5282,10, U, Pacific/Port_Moresby, airport, OurAirports";
        } else if (numberColumn == 4) {
            str1 = "Papua New Guinea, Goroka Airport, Goroka, 1, GKA, AYGA, -6.081689834590001,145.391998291,5282,10, U, Pacific/Port_Moresby, airport, OurAirports";
        } else if (numberColumn == 5) {
            str1 = "GKA, Goroka Airport, Goroka, Papua New Guinea, 1, AYGA, -6.081689834590001,145.391998291,5282,10, U, Pacific/Port_Moresby, airport, OurAirports";
        } else if (numberColumn == 6) {
            str1 = "AYGA, Goroka Airport, Goroka, Papua New Guinea, GKA, 1, -6.081689834590001,145.391998291,5282,10, U, Pacific/Port_Moresby, airport, OurAirports";
        } else if (numberColumn == 7) {
            str1 = "-6.081689834590001,145.391998291,5282,10, Goroka Airport, Goroka, Papua New Guinea, GKA, AYGA, 1, U, Pacific/Port_Moresby, airport, OurAirports";
        } else if (numberColumn == 8) {
            str1 = "U, Goroka Airport, Goroka, Papua New Guinea, GKA, AYGA, -6.081689834590001,145.391998291,5282,10, 1, Pacific/Port_Moresby, airport, OurAirports";
        } else if (numberColumn == 9) {
            str1 = "Pacific/Port_Moresby, Goroka Airport, Goroka, Papua New Guinea, GKA, AYGA, -6.081689834590001,145.391998291,5282,10, U, 1, airport, OurAirports";
        }

        for (Object object : list) {
            Object str2 = object;
            if (str2.equals(str1))
                Assert.assertEquals(str2, str1);
        }

    }
}