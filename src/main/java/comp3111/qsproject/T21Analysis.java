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
            String uni = item.getProperty("name");
            String yr = item.getProperty("year");
            if (years.contains(yr)) {
                if (uni.equals(uni_1)) {
                    University1List.add(item);
                }
                if (uni.equals(uni_2)) {
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
        Double[] uni_1 = new Double[University1List.size()];
        Double[] uni_2 = new Double[University2List.size()];
        System.out.println("property: " + searchName);

        // University 1
        int invalidCount1 = 0; // Stores number of missing data
        for (int i = 0; i < University1List.size(); i++) {
            String property = University1List.get(i).getProperty(searchName);
            System.out.println(University1Name + " data: " + property);
            // Integral properties
            if (searchName.equals("internationalStudents") || searchName.equals("facultyCount")) {
                property = property.replace(",", "").replace(".", "");
            }
            // Float properties
            else if (searchName.equals("score")) {
                property = property.replace(",", "");
            }
            if (property == null || property.isEmpty()) { // Handle Empty Data
                uni_1[i] = 0.0;
                invalidCount1 += 1;
            }
            else {
                uni_1[i] = Double.parseDouble(property);
            }
        }

        // University 2
        int invalidCount2 = 0; // Stores number of missing data
        for (int i = 0; i < University2List.size(); i++) {
            String property = University2List.get(i).getProperty(searchName);
            System.out.println(University2Name + " data: " + property);
            // Integral properties
            if (searchName.equals("internationalStudents") || searchName.equals("facultyCount")) {
                property = property.replace(",", "").replace(".", "");
            }
            // Float properties
            else if (searchName.equals("score")) {
                property = property.replace(",", "");
            }
            if (property == null || property.isEmpty()) { // Handle Empty Data
                uni_2[i] = 0.0;
                invalidCount2 += 1;
            }
            else {
                uni_2[i] = Double.parseDouble(property);
            }
//            System.out.println("uni 2 data: " + uni_2[i]);
        }

        Double average1 = 0.0;
        Double average2 = 0.0;

        if (uni_1.length - invalidCount1 > 0) {
            for (double data : uni_1) {
                average1 += data;
            }
            average1 /= (uni_1.length - invalidCount1);
        }

        if (uni_2.length - invalidCount2 > 0) {
            for (double data : uni_2) {
                average2 += data;
            }
            average2 /= (uni_2.length - invalidCount2);
        }

        barData.getData().add(new XYChart.Data<>(average2, "University 2"));
        barData.getData().add(new XYChart.Data<>(average1, "University 1"));

        System.out.println("average 1: " + average1 + " average 2: " + average2);
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
        // University 1
        XYChart.Series<String, Double> uniScores1 = new XYChart.Series<>();
        System.out.println(University1Name);
        uniScores1.setName(University1Name);
        for (QSItem qsItem : University1List) {
            String year = qsItem.getProperty("year");
            System.out.println(year);
            String property = qsItem.getProperty(searchName);
            if (!(property == null || property.isEmpty())) {
                Double score = Double.parseDouble(property.replace(",", "."));
                uniScores1.getData().add(new XYChart.Data<>(year, score));
            }
        }
        lineData.add(uniScores1);
        // University 2
        XYChart.Series<String, Double> uniScores2 = new XYChart.Series<>();
        System.out.println(University2Name);
        uniScores2.setName(University2Name);
        for (QSItem qsItem : University2List) {
            String year = qsItem.getProperty("year");
            System.out.println(year);
            String property = qsItem.getProperty(searchName);
            if (!(property == null || property.isEmpty())) {
                Double score = Double.parseDouble(property.replace(",", "."));
                uniScores2.getData().add(new XYChart.Data<>(year, score));
            }
        }
        lineData.add(uniScores2);

        return lineData;
    }
}
