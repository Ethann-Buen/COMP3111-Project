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

    /**
     * Constructor for Task 2.2 Analyzer. It extracts country/region data from QSList.list for further processing.
     * @param country_region_1 The first country/region choice
     * @param country_region_2 The second country/region choice
     * @param years The list of years to consider
     * @author Ethann-Buen
     */
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
                if (country_region_1.equals("All")) {
                    CountryRegion1List.add(item);
                }
                if (country_region_2.equals("All")) {
                    CountryRegion2List.add(item);
                }
            }
        }
        CountryRegion1List.sort(Comparator.comparing(item -> item.getProperty("year")));
        CountryRegion2List.sort(Comparator.comparing(item -> item.getProperty("year")));
    }

    /**
     * Calculates the averages of the country/region data based on the given property, and returns the data
     * in the form of a bar chart. It cleans the dirty data before further processing.
     * @param searchName The property to be compared.
     * @author Ethann-Buen
     */
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
        // Country/Region 1
        int invalidCount1 = 0;
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
            if (property.isEmpty()) {
                country_region_1[i] = 0.0;
                invalidCount1 += 1;
            }
            else {
                country_region_1[i] = Double.parseDouble(property);
            }
        }

        // University 2
        int invalidCount2 = 0;
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
            if (property.isEmpty()) {
                country_region_2[i] = 0.0;
                invalidCount2 += 1;
            }
            else {
                country_region_2[i] = Double.parseDouble(property);
            }
        }

        Double average1 = 0.0;
        Double average2 = 0.0;

        if (country_region_1.length - invalidCount1 > 0) {
            for (double data : country_region_1) {
                average1 += data;
            }
            average1 /= (country_region_1.length - invalidCount1);
        }

        if (country_region_2.length - invalidCount2 > 0) {
            for (double data : country_region_2) {
                average2 += data;
            }
            average2 /= (country_region_2.length - invalidCount2);
        }

        barData.getData().add(new XYChart.Data<>(average2, "Country/Region 2"));
        barData.getData().add(new XYChart.Data<>(average1, "Country/Region 1"));

        return barData;
    }

    /**
     * Calculates the averages of country/region scores per year, and plots the computed output in the form
     * of a line chart. It cleans the dirty data before further processing.
     * @param searchName The property to be compared (score by default)
     * @author Ethann-Buen
     */
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
        int count = 0; // Stores the counts of data per year
        boolean isValid = true;

        QSItem initialItem = CountryRegion1List.getFirst();
        String initialYear = initialItem.getProperty("year");
        String initialProperty =initialItem.getProperty(searchName);
        Double score = 0.0;
        if (!(initialProperty == null || initialProperty.isEmpty())) {
            score = Double.parseDouble(initialProperty.replace(",", "."));
            count = 1;
        }

        sum += score;
        for (int i = 0; i < CountryRegion1List.size()-1; i++) {
            QSItem qsItem = CountryRegion1List.get(i+1);
            String year = qsItem.getProperty("year");
            String property = qsItem.getProperty(searchName);
            if (!(property == null || property.isEmpty())) {
                score = Double.parseDouble(property.replace(",", "."));
                isValid = true;
            }
            else {
                score = 0.0;
                isValid = false;
            }

            if (year.equals(initialYear)) {
                sum += score;
                if (isValid) {
                    count += 1; // Only update count if there is data.
                }
            }
            else {
                sum /= count;
                countryRegionScores1.getData().add(new XYChart.Data<>(initialYear, sum)); // Store the sums of data from previous years
                sum = score; // Update the score to be the current score
                initialYear = year; // Update the initial year
                if (isValid) {
                    count = 1;
                }
                else {
                    count = 0;
                }
            }
        }
        sum /= count;
        countryRegionScores1.getData().add(new XYChart.Data<>(initialYear, sum)); // Handle the last year (there will be no more years after)
        lineData.add(countryRegionScores1);

        // University 2
        XYChart.Series<String, Double> countryRegionScores2 = new XYChart.Series<>();
        countryRegionScores2.setName(CountryRegion2Name);
        sum = 0.0;

        initialItem = CountryRegion2List.getFirst();
        initialYear = initialItem.getProperty("year");
        initialProperty = initialItem.getProperty(searchName);
        score = 0.0;
        isValid = true;
        if (!(initialProperty == null || initialProperty.isEmpty())) {
            score = Double.parseDouble(initialProperty.replace(",", "."));
            count = 1;
        }
        else {
            count = 0;
        }
        sum += score;
        for (int i = 0; i < CountryRegion2List.size()-1; i++) {
            QSItem qsItem = CountryRegion2List.get(i+1);
            String year = qsItem.getProperty("year");
            String property = qsItem.getProperty(searchName);
            if (!(property == null || property.isEmpty())) {
                score = Double.parseDouble(property.replace(",", "."));
                isValid = true;
            }
            else {
                score = 0.0;
                isValid = false;
            }
            if (year.equals(initialYear)) {
                sum += score;
                if (isValid) {
                    count += 1;
                }
            }
            else {
                sum /= count;
                countryRegionScores2.getData().add(new XYChart.Data<>(initialYear, sum)); // Store the sums of data from previous years
                sum = score; // Update the score to be the current score
                initialYear = year; // Update the initial year
                if (isValid) {
                    count = 1;
                }
                else {
                    count = 0;
                }
            }
        }
        sum /= count;
        countryRegionScores2.getData().add(new XYChart.Data<>(initialYear, sum)); // Handle the last year (there will be no more years after)
        lineData.add(countryRegionScores2);

        return lineData;
    }
}
