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
        CountryRegion1Name = country_region_1;
        CountryRegion2Name = country_region_2;
        for (QSItem item: QSList.list) {
            String country = item.getProperty("country");
            String region = item.getProperty("region");
            String yr = item.getProperty("year");
            if (years.contains(yr)) {
                if (country.equals(country_region_1) || region.equals(country_region_1)) {
                    CountryRegion1List.add(item);
                }
                if (country.equals(country_region_2) || region.equals(country_region_2)) {
                    CountryRegion2List.add(item);
                }
            }
        }
        CountryRegion1List.sort(Comparator.comparing(item -> item.getProperty("year")));
        CountryRegion2List.sort(Comparator.comparing(item -> item.getProperty("year")));
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
        Double[] country_region_1 = new Double[CountryRegion1List.size()];
        Double[] country_region_2 = new Double[CountryRegion2List.size()];
//        System.out.println("property: " + searchName);
        // Country/Region 1
        for (int i = 0; i < CountryRegion1List.size(); i++) {
            String property = CountryRegion1List.get(i).getProperty(searchName);
            // Integral properties
            if (searchName.equals("internationalStudents") || searchName.equals("facultyCount")) {
                property = property.replace(",", "").replace(".", "");
            }
            // Float properties
            else if (searchName.equals("score")) {
                property = property.replace(",", "");
            }
            country_region_1[i] = Double.parseDouble(property);
//            System.out.println("country 1 data: " + country_region_1[i]);
        }

        // University 2
        for (int i = 0; i < CountryRegion2List.size(); i++) {
            String property = CountryRegion2List.get(i).getProperty(searchName);
            // Integral properties
            if (searchName.equals("internationalStudents") || searchName.equals("facultyCount")) {
                property = property.replace(",", "").replace(".", "");
            }
            // Float properties
            else if (searchName.equals("score")) {
                property = property.replace(",", "");
            }
            country_region_2[i] = Double.parseDouble(property);
//            System.out.println("country 2 data: " + country_region_2[i]);
        }

        Double average1 = 0.0;
        Double average2 = 0.0;

        for (double data : country_region_1) {
            average1 += data;
        }
        average1 /= country_region_1.length;

        for (double data : country_region_2) {
            average2 += data;
        }
        average2 /= country_region_2.length;

        barData.getData().add(new XYChart.Data<>(average1, CountryRegion1Name));
        barData.getData().add(new XYChart.Data<>(average2, CountryRegion2Name));
//        System.out.println("average 1: " + average1 + " average 2: " + average2);

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
        XYChart.Series<String, Double> countryRegionScores1 = new XYChart.Series<>();
        countryRegionScores1.setName(CountryRegion1Name);
        Double sum = 0.0;

        QSItem initialItem = CountryRegion1List.getFirst();
        String initialYear = initialItem.getProperty("year");
        Double score = Double.parseDouble(initialItem.getProperty(searchName).replace(",", "."));
        sum += score;
        for (int i = 0; i < CountryRegion1List.size()-1; i++) {
            QSItem qsItem = CountryRegion1List.get(i+1);
            String year = qsItem.getProperty("year");
            score = Double.parseDouble(qsItem.getProperty(searchName).replace(",", "."));
            if (year.equals(initialYear)) {
                sum += score;
            }
            else {
                countryRegionScores1.getData().add(new XYChart.Data<>(initialYear, sum)); // Store the sums of data from previous years
                sum = score; // Update the score to be the current score
                initialYear = year; // Update the initial year
            }
//            System.out.println("country 1: " + "year: " + year);
        }
        countryRegionScores1.getData().add(new XYChart.Data<>(initialYear, sum)); // Handle the last year (there will be no more years after)
        lineData.add(countryRegionScores1);

        // University 2
        XYChart.Series<String, Double> countryRegionScores2 = new XYChart.Series<>();
        countryRegionScores2.setName(CountryRegion2Name);
        sum = 0.0;

        initialItem = CountryRegion2List.getFirst();
        initialYear = initialItem.getProperty("year");
        score = Double.parseDouble(initialItem.getProperty(searchName).replace(",", "."));
        sum += score;
//        Double[] sums2 = new Double[6]; // Array to store the sums for each year
        for (int i = 0; i < CountryRegion2List.size()-1; i++) {
            QSItem qsItem = CountryRegion2List.get(i+1);
            String year = qsItem.getProperty("year");
            score = Double.parseDouble(qsItem.getProperty(searchName).replace(",", "."));
            if (year.equals(initialYear)) {
                sum += score;
            }
            else {
                countryRegionScores2.getData().add(new XYChart.Data<>(initialYear, sum)); // Store the sums of data from previous years
                sum = score; // Update the score to be the current score
                initialYear = year; // Update the initial year
            }
//            System.out.println("country 2: " + "year: " + year);
        }
        countryRegionScores2.getData().add(new XYChart.Data<>(initialYear, sum)); // Handle the last year (there will be no more years after)
        lineData.add(countryRegionScores2);

        return lineData;
    }
}
