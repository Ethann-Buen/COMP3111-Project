package comp3111.qsproject;

import com.csvreader.CsvReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
        File data = new File("C:\\Users\\aowu\\IdeaProjects\\COMP3111-Project\\QSProject_skeleton\\qs.csv");
        String file = "\\" + data.getAbsolutePath();

        CsvReader csvReader = null;
        try {
            csvReader = new CsvReader(file);
            try {
                csvReader.readHeaders();
                int fieldCount = csvReader.getHeaderCount();
                while (csvReader.readRecord()) {
                    String[] row = new String[fieldCount];
                    for (int i = 0; i < fieldCount; i++) {
                        row[i] = csvReader.get(i);
                    }
                    QSItem qsData = new QSItem(row);
                    list.add(qsData);

                    String qsUniversity = csvReader.get("university");
                    if (!university.contains(qsUniversity)) {
                        university.add(qsUniversity);
                    }

                    String qsType = csvReader.get("type");
                    if (!type.contains(qsType)) {
                        type.add(qsType);
                    }

                    String qsRegion = csvReader.get("region");
                    if (!region.contains(qsRegion)) {
                        region.add(qsRegion);
                    }

                    String qsCountry = csvReader.get("country");
                    if (!country.contains(qsCountry)) {
                        country.add(qsCountry);
                    }
                }
                FXCollections.sort(university);
                FXCollections.sort(type);
                FXCollections.sort(region);
                FXCollections.sort(country);
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
