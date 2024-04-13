package comp3111.qsproject;

import com.csvreader.CsvReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Collections;

/**
 * This file is a container of collected QS data
 */

public class QSList {
    public static ObservableList<QSItem> list = FXCollections.observableArrayList();
    public static ObservableList<String> university = FXCollections.observableArrayList();
    public static ObservableList<String> type = FXCollections.observableArrayList();
    public static ObservableList<String> region = FXCollections.observableArrayList();
    public static ObservableList<String> country = FXCollections.observableArrayList();

    public static void initialize() {
        /*
            Your Code Here.
            1. Load the csv into list.
            2. Collect the set of university, type, region and country.
         */
        File data = new File("qs.csv");
        String file = "\\" + data.getAbsolutePath();

        CsvReader csvReader = null;
        try {
            csvReader = new CsvReader(file);
            try {
                csvReader.readHeaders();
                int fieldCount = csvReader.getColumnCount();
                while (csvReader.readRecord()) {
                    String[] row = new String[fieldCount];
                    for (int i = 0; i < fieldCount; i++) {
                        row[i] = csvReader.get(i);
                    }
                    QSItem qsData = new QSItem(row);
                    list.add(qsData);

                    String qsUniversity = csvReader.get("university");
                    university.add(qsUniversity);
                    String qsType = csvReader.get("type");
                    type.add(qsType);
                    String qsRegion = csvReader.get("region");
                    region.add(qsRegion);
                    String qsCountry = csvReader.get("country");
                    country.add(qsCountry);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                csvReader.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
