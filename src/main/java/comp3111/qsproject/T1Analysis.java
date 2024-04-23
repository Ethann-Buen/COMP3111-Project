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
        for (QSItem qsItem : QSList.list) {
            String qsItemYear = qsItem.getProperty("year");
            if (qsItemYear.equals(year)) {
                tableList.add(qsItem);
            }
        }
    }

    /**
     * Gets the Table List.
     * @author phmakaa
     */
    ObservableList<QSItem> getTableList() {
        return tableList;
    }

    /**
     * Gets the Key List.
     * @author phmakaa
     */
    ObservableList<String> getKeyList(String searchName) {
        switch (searchName) {
            case "country" -> {
                return QSList.country;
            }
            case "region" -> {
                return QSList.region;
            }
            case "size" -> {
                return FXCollections.observableArrayList("S", "M", "L", "XL");
            }
            case "type" -> {
                return FXCollections.observableArrayList("Public", "Private");
            }
            case "researchOutput" -> {
                return FXCollections.observableArrayList("Medium", "High", "Very high");
            }
            default -> {
                return FXCollections.observableArrayList();
            }
        }
    }

    /**
     * Gets the Pie Chart Data, showing the sum of the score.
     * @author phmakaa
     */
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
        double[] sumList = new double[keyList.size()];

        for (QSItem qsItem : tableList) {
            String score = qsItem.getScore();
            if (score.equals(""))
                continue;
            String property = qsItem.getProperty(searchName);

            for (int j = 0; j < keyList.size(); j++) {
                if (keyList.get(j).equals(property)) {
                    sumList[j] += Double.parseDouble(score);
                }
            }
        }

        for (int j = 0; j < keyList.size(); j++) {
            PieChart.Data datum = new PieChart.Data(keyList.get(j), sumList[j]);
            pieChartData.add(datum);
        }
        return pieChartData;
    }

    /**
     * Gets the Bar Chart Data, showing the average of the score.
     * @author phmakaa
     */
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
        double[] sumList = new double[keyList.size()];
        int[] countList = new int[keyList.size()];

        for (QSItem qsItem : tableList) {
            String score = qsItem.getScore();
            if (score.equals(""))
                continue;
            String property = qsItem.getProperty(searchName);

            for (int j = 0; j < keyList.size(); j++) {
                if (keyList.get(j).equals(property)) {
                    sumList[j] += Double.parseDouble(score);
                    countList[j] += 1;
                }
            }
        }

        for (int j = 0; j < keyList.size(); j++) {
            double average = 0.0;
            if (countList[j] != 0) {
                average = sumList[j]/countList[j];
            }
            XYChart.Data<String, Double> datum = new XYChart.Data<>(keyList.get(j), average);
            barData.getData().add(datum);
        }
        return barData;
    }

}
