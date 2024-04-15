package comp3111.qsproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

import java.util.*;

public class T21Analysis {
    public ObservableList<QSItem> University1List = FXCollections.observableArrayList();
    public ObservableList<QSItem> University2List = FXCollections.observableArrayList();
    private String University1Name;
    private String University2Name;

    T21Analysis(String uni_1, String uni_2, List<String> years) {
        /*
            Your Code Here.
            Collect the QSItem with corresponding years and university into two university lists.
            Sort university lists by the years.
            Hint: QSList.list is a static property.
         */
        University1Name = uni_1;
        University2Name = uni_2;
        for (QSItem item: QSList.list) {
            String uni = item.getProperty("university");
            String yr = item.getProperty("year");
            if (years.contains(yr)) {
                if (uni == uni_1) {
                    University1List.add(item);
                }
                if (uni == uni_2) {
                    University2List.add(item);
                }
            }
        }
        University1List.sort(Comparator.comparing(item -> item.getProperty("year")));
        University2List.sort(Comparator.comparing(item -> item.getProperty("year")));
    }

    XYChart.Series<Double, String> getBarChartData(String searchName) {
        XYChart.Series<Double, String> barData= new XYChart.Series<>();
        /*
            Your Code Here.
            Return the Bar Chart Data.
            Bar Chart shows the Avg. of the selected property.
            For example, when the user chooses "score", which means the searchName will be "score"
            And Return an XYChart.Series with XYChart.Data
            [
              Average score of university2, "University 2"
              Average score of university1, "University 1"
            ]

            There are some "dirty data" in csv.
            For example, the string "3,143" or "3.143" can not transfer to Integer or Double directly.
            Careful process these data.
         */
        double[] uni_1 = new double[University1List.size()];
        double[] uni_2 = new double[University2List.size()];

        for (QSItem item : University1List) {
            String property = item.getProperty(searchName);
            // Integral properties
            if (searchName == "international_students" || searchName == "faculty_count") {
                property = property.replace(",", "").replace(".", "");
            }
            // Float properties
            else if (searchName == "score") {
                property = property.replace(",", "");
            }
        }

        double average1 = 0;
        double average2 = 0;
        for (double data : uni_1) {
            average1 += data;
        }
        average1 /= uni_1.length;

        for (double data : uni_2) {
            average2 += data;
        }
        average2 /= uni_2.length;

        barData.getData().add(new XYChart.Data<>(average1, "University 1"));
        barData.getData().add(new XYChart.Data<>(average2, "University 2"));

        



        return barData;
    }

    List<XYChart.Series<String, Double>> getLineChartData(String searchName) {
        List<XYChart.Series<String, Double>> lineData = new ArrayList<>();
        /*
            Your Code Here.
            Fill the lineData1 and lineData2.
            Line Chart shows two lines. Each line shows the number of searchName each year.
            In our cases, the searchName will be "score"
            And Return an XYChart.Series with XYChart.Data
            [
              Series[Data<year,score>],
            ]

            There are some "dirty data" in csv.
            For example, the string "3,143" or "3.143" can not transfer to Integer or Double directly.
            Careful process these data.
         */
        return lineData;
    }
}
