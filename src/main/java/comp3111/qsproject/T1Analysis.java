package comp3111.qsproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

import java.util.*;

public class T1Analysis {
    public ObservableList<QSItem> tableList = FXCollections.observableArrayList();
    T1Analysis (String year) {
        /*
            Your Code Here.
            Collect the QSItem with corresponding years into tableList.
            Use static properties in QSList here.
            Hint: QSList.list is a static property.
         */
        for (QSItem item: QSList.list) {
            String itemYear = item.getProperty("year");
            if (itemYear.equals(year)) {
                tableList.add(item);
            }
        }
    }

    ObservableList<QSItem> getTableList() {
        return tableList;
    }

    ObservableList<String> getKeyList(String searchName) {
        ObservableList<String> keyList = FXCollections.observableArrayList();
        switch (searchName) {
            case "country" -> {
                keyList =  QSList.country;
                // keyList = FXCollections.observableArrayList(QSList.country.subList(40,50));
            }
            case "region" -> {
                keyList = QSList.region;
            }
            case "size" -> {
                keyList = FXCollections.observableArrayList("S", "M", "L", "XL");
            }
            case "type" -> {
                keyList = FXCollections.observableArrayList("Public", "Private");
            }
            case "researchOutput" -> {
                keyList = FXCollections.observableArrayList("Medium", "High", "Very high");
            }
        }
        return keyList;
    }

    ObservableList<PieChart.Data> getPieChartData(String searchName) {
        ObservableList<PieChart.Data> pieChartData= FXCollections.observableArrayList();
        /*
            Your Code Here.
            Return the Pie Chart Data.
            Pie Chart shows the SUM of the score.
            For example, when the user chooses "size", which means the searchName will be "size"
            And Return an ObservableList with PieChart.Data
            [
                key: "L", value: the Sum score of the Large size universities,
                key: "M", value: the Sum score of the Middle size universities,
                key: "S", value: the Sum score of the Small size universities,
            ]
         */

        ObservableList<String> keyList = getKeyList(searchName);
        double[] valueList = new double[keyList.size()];
        for (int j = 0; j < keyList.size(); j++) {
            valueList[j] = 0.0;
        }

        for (QSItem qsItem : tableList) {
            String property = qsItem.getProperty(searchName);
            for (int j = 0; j < keyList.size(); j++) {
                String key = keyList.get(j);
                if (property.equals(key) && !qsItem.getScore().equals("")) {
                    valueList[j] += Double.parseDouble(qsItem.getScore());
                }
            }
        }

        for (int i = 0; i < keyList.size(); i++) {
            PieChart.Data datum = new PieChart.Data(keyList.get(i), valueList[i]);
            pieChartData.add(datum);
        }

        return pieChartData;
    }

    XYChart.Series<String, Double> getBarChartData(String searchName) {
        XYChart.Series<String, Double> barData= new XYChart.Series<>();
        /*
            Your Code Here.
            Return the Bar Chart Data.
            Bar Chart shows the Avg. of the score.
            For example, when the user chooses "size", which means the searchName will be "size"
            And Return an XYChart.Series with XYChart.Data
            [
                key: "L", value: the Average score of the Large size universities,
                key: "M", value: the Average score of the Middle size universities,
                key: "S", value: the Average score of the Small size universities,
            ]
         */
        ObservableList<String> keyList = getKeyList(searchName);
        double[] valueList = new double[keyList.size()];
        int[] countList = new int[keyList.size()];
        for (int j = 0; j < keyList.size(); j++) {
            valueList[j] = 0.0;
            countList[j] = 0;
        }

        for (QSItem qsItem : tableList) {
            String property = qsItem.getProperty(searchName);
            for (int j = 0; j < keyList.size(); j++) {
                String key = keyList.get(j);
                if (property.equals(key) && !qsItem.getScore().equals("")) {
                    valueList[j] += Double.parseDouble(qsItem.getScore());
                    countList[j] += 1;
                }
            }
        }

        for(int j = 0; j < valueList.length; j++) {
            if (countList[j] != 0) {
                valueList[j] = valueList[j]/countList[j];
            }
        }

        for (int i = 0; i < keyList.size(); i++) {
            XYChart.Data<String, Double> datum = new XYChart.Data<>(keyList.get(i), valueList[i]);
            barData.getData().add(datum);
        }

        return barData;
    }


}
