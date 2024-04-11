package comp3111.qsproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

import java.util.*;

public class T22Analysis {
    public ObservableList<QSItem> CountryRegion1List = FXCollections.observableArrayList();
    public ObservableList<QSItem> CountryRegion2List = FXCollections.observableArrayList();
    private String CountryRegion1Name;
    private String CountryRegion2Name;

    T22Analysis(String country_region_1, String country_region_2, List<String> years) {
        /*
            Your Code Here.
            Collect the QSItem with corresponding years and country/region into two country/region lists.
            Sort country/region lists by the years.
            Hint: QSList.list is a static property.
         */
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
              Average score of country/region2, "Country/Region 2"
              Average score of country/region1, "Country/Region 1"
            ]

            There are some "dirty data" in csv.
            For example, the string "3,143" or "3.143" can not transfer to Integer or Double directly.
            Careful process these data.
         */
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
