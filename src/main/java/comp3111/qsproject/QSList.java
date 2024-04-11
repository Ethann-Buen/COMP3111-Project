package comp3111.qsproject;

import com.csvreader.CsvReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
    }
}
