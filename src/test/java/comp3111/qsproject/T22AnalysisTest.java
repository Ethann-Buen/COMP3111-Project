package comp3111.qsproject;

import javafx.scene.chart.XYChart;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class T22AnalysisTest {

    @Test
    void Test1_getBarChartData() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }

        String country_region_1 = "Argentina";
        String country_region_2 = "Belarus";
        List<String> years = List.of("2017", "2018", "2019", "2020", "2021", "2022");

        // Expected
        XYChart.Series<Double, String> expected = new XYChart.Series<>();
        expected.getData().add(new XYChart.Data<>(32.966666674, "Country/Region 2"));
        expected.getData().add(new XYChart.Data<>(42.01428571, "Country/Region 1"));
        // Actual
        T22Analysis analyzer = new T22Analysis(country_region_1, country_region_2, years);
        XYChart.Series<Double, String> actual = analyzer.getBarChartData("score");

        for (int i = 0; i < expected.getData().size(); i++) {
            XYChart.Data<Double, String> expectedData = expected.getData().get(i);
            XYChart.Data<Double, String> actualData = actual.getData().get(i);
            assertEquals(expectedData.getXValue(), actualData.getXValue(), 0.1);
            assertEquals(expectedData.getYValue(), actualData.getYValue());
        }
    }
    @Test
    void Test2_getBarChartData() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }

        String country_region_1 = "Australia";
        String country_region_2 = "Latin America";
        List<String> years = List.of("2017", "2018", "2019", "2020", "2021", "2022");

        // Expected
        XYChart.Series<Double, String> expected = new XYChart.Series<>();
        expected.getData().add(new XYChart.Data<>(222.4868421, "Country/Region 2"));
        expected.getData().add(new XYChart.Data<>(189.4645669, "Country/Region 1"));
        // Actual
        T22Analysis analyzer = new T22Analysis(country_region_1, country_region_2, years);
        XYChart.Series<Double, String> actual = analyzer.getBarChartData("rank");

        for (int i = 0; i < expected.getData().size(); i++) {
            XYChart.Data<Double, String> expectedData = expected.getData().get(i);
            XYChart.Data<Double, String> actualData = actual.getData().get(i);
            assertEquals(expectedData.getXValue(), actualData.getXValue(), 0.1);
            assertEquals(expectedData.getYValue(), actualData.getYValue());
        }
    }
    @Test
    void Test3_getBarChartData() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }

        String country_region_1 = "All";
        String country_region_2 = "Hong Kong SAR";
        List<String> years = List.of("2017", "2018", "2019", "2020", "2021", "2022");

        // Expected
        XYChart.Series<Double, String> expected = new XYChart.Series<>();
        expected.getData().add(new XYChart.Data<>(5535.833333, "Country/Region 2"));
        expected.getData().add(new XYChart.Data<>(4847.50, "Country/Region 1"));
        // Actual
        T22Analysis analyzer = new T22Analysis(country_region_1, country_region_2, years);
        XYChart.Series<Double, String> actual = analyzer.getBarChartData("internationalStudents");

        for (int i = 0; i < expected.getData().size(); i++) {
            XYChart.Data<Double, String> expectedData = expected.getData().get(i);
            XYChart.Data<Double, String> actualData = actual.getData().get(i);
            assertEquals(expectedData.getXValue(), actualData.getXValue(), 0.1);
            assertEquals(expectedData.getYValue(), actualData.getYValue());
        }
    }
    @Test
    void Test4_getBarChartData() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }

        String country_region_1 = "Europe";
        String country_region_2 = "France";
        List<String> years = List.of("2017", "2019", "2021");

        // Expected
        XYChart.Series<Double, String> expected = new XYChart.Series<>();
        expected.getData().add(new XYChart.Data<>(10.75, "Country/Region 2"));
        expected.getData().add(new XYChart.Data<>(10.70132325, "Country/Region 1"));
        // Actual
        T22Analysis analyzer = new T22Analysis(country_region_1, country_region_2, years);
        XYChart.Series<Double, String> actual = analyzer.getBarChartData("studentFacultyRatio");

        for (int i = 0; i < expected.getData().size(); i++) {
            XYChart.Data<Double, String> expectedData = expected.getData().get(i);
            XYChart.Data<Double, String> actualData = actual.getData().get(i);
            assertEquals(expectedData.getXValue(), actualData.getXValue(), 0.1);
            assertEquals(expectedData.getYValue(), actualData.getYValue());
        }
    }
    @Test
    void Test5_getBarChartData() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }

        String country_region_1 = "Estonia";
        String country_region_2 = "Ireland";
        List<String> years = List.of("2017", "2018", "2019");

        // Expected
        XYChart.Series<Double, String> expected = new XYChart.Series<>();
        expected.getData().add(new XYChart.Data<>(1609.5, "Country/Region 2"));
        expected.getData().add(new XYChart.Data<>(1605.0, "Country/Region 1"));
        // Actual
        T22Analysis analyzer = new T22Analysis(country_region_1, country_region_2, years);
        XYChart.Series<Double, String> actual = analyzer.getBarChartData("facultyCount");

        for (int i = 0; i < expected.getData().size(); i++) {
            XYChart.Data<Double, String> expectedData = expected.getData().get(i);
            XYChart.Data<Double, String> actualData = actual.getData().get(i);
            assertEquals(expectedData.getXValue(), actualData.getXValue(), 0.1);
            assertEquals(expectedData.getYValue(), actualData.getYValue());
        }
    }
    @Test
    void Test1_getLineChartData() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }

        String country_region_1 = "Hong Kong SAR";
        String country_region_2 = "South Korea";
        List<String> years = List.of("2020", "2021", "2022");
        List<Double> scores1 = List.of(68.78333333, 69.66666667, 71.33333333);
        List<Double> scores2 = List.of(55.77 , 54.36363636, 55.70909091);

        // Expected
        List<XYChart.Series<String, Double>> expected = new ArrayList<>();

        XYChart.Series<String, Double> country_1_data = new XYChart.Series<>();
        for (int i = 0; i < years.size(); i++) {
            if (scores1.get(i) >= 0) {
                country_1_data.getData().add(new XYChart.Data<>(years.get(i), scores1.get(i)));
            }
        }
        expected.add(country_1_data);

        XYChart.Series<String, Double> country_2_data = new XYChart.Series<>();
        for (int i = 0; i < years.size(); i++) {
            if (scores2.get(i) >= 0) {
                country_2_data.getData().add(new XYChart.Data<>(years.get(i), scores2.get(i)));
            }
        }
        expected.add(country_2_data);
        // Actual
        T22Analysis analyzer = new T22Analysis(country_region_1, country_region_2, years);
        List<XYChart.Series<String, Double>> actual = analyzer.getLineChartData("score");

        for (int i = 0; i < expected.size(); i++) {
            XYChart.Series<String, Double> expectedData = expected.get(i);
            XYChart.Series<String, Double> actualData = actual.get(i);
            for (int j = 0; j < expectedData.getData().size(); j++) {
                XYChart.Data<String, Double> expectedPoint = expectedData.getData().get(j);
                XYChart.Data<String, Double> actualPoint = actualData.getData().get(j);
                assertEquals(expectedPoint.getXValue(), actualPoint.getXValue());
                assertEquals(expectedPoint.getYValue(), actualPoint.getYValue(), 0.1);
            }
        }
    }
    @Test
    void Test2_getLineChartData() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }

        String country_region_1 = "France";
        String country_region_2 = "Europe";
        List<String> years = List.of("2017", "2018", "2019");
        List<Double> scores1 = List.of(45.80, 45.35, 45.80);
        List<Double> scores2 = List.of(49.79606742, 50.01468927, 46.82171429);

        // Expected
        List<XYChart.Series<String, Double>> expected = new ArrayList<>();

        XYChart.Series<String, Double> country_1_data = new XYChart.Series<>();
        for (int i = 0; i < years.size(); i++) {
            if (scores1.get(i) >= 0) {
                country_1_data.getData().add(new XYChart.Data<>(years.get(i), scores1.get(i)));
            }
        }
        expected.add(country_1_data);

        XYChart.Series<String, Double> country_2_data = new XYChart.Series<>();
        for (int i = 0; i < years.size(); i++) {
            if (scores2.get(i) >= 0) {
                country_2_data.getData().add(new XYChart.Data<>(years.get(i), scores2.get(i)));
            }
        }
        expected.add(country_2_data);
        // Actual
        T22Analysis analyzer = new T22Analysis(country_region_1, country_region_2, years);
        List<XYChart.Series<String, Double>> actual = analyzer.getLineChartData("score");

        for (int i = 0; i < expected.size(); i++) {
            XYChart.Series<String, Double> expectedData = expected.get(i);
            XYChart.Series<String, Double> actualData = actual.get(i);
            for (int j = 0; j < expectedData.getData().size(); j++) {
                XYChart.Data<String, Double> expectedPoint = expectedData.getData().get(j);
                XYChart.Data<String, Double> actualPoint = actualData.getData().get(j);
                assertEquals(expectedPoint.getXValue(), actualPoint.getXValue());
                assertEquals(expectedPoint.getYValue(), actualPoint.getYValue(), 0.1);
            }
        }
    }
    @Test
    void Test3_getLineChartData() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }

        String country_region_1 = "All";
        String country_region_2 = "Asia";
        List<String> years = List.of("2017", "2020");
        List<Double> scores1 = List.of(51.57869674, 48.95227273);
        List<Double> scores2 = List.of(51.06385542, 48.63033708);

        // Expected
        List<XYChart.Series<String, Double>> expected = new ArrayList<>();

        XYChart.Series<String, Double> country_1_data = new XYChart.Series<>();
        for (int i = 0; i < years.size(); i++) {
            if (scores1.get(i) >= 0) {
                country_1_data.getData().add(new XYChart.Data<>(years.get(i), scores1.get(i)));
            }
        }
        expected.add(country_1_data);

        XYChart.Series<String, Double> country_2_data = new XYChart.Series<>();
        for (int i = 0; i < years.size(); i++) {
            if (scores2.get(i) >= 0) {
                country_2_data.getData().add(new XYChart.Data<>(years.get(i), scores2.get(i)));
            }
        }
        expected.add(country_2_data);
        // Actual
        T22Analysis analyzer = new T22Analysis(country_region_1, country_region_2, years);
        List<XYChart.Series<String, Double>> actual = analyzer.getLineChartData("score");

        for (int i = 0; i < expected.size(); i++) {
            XYChart.Series<String, Double> expectedData = expected.get(i);
            XYChart.Series<String, Double> actualData = actual.get(i);
            for (int j = 0; j < expectedData.getData().size(); j++) {
                XYChart.Data<String, Double> expectedPoint = expectedData.getData().get(j);
                XYChart.Data<String, Double> actualPoint = actualData.getData().get(j);
                assertEquals(expectedPoint.getXValue(), actualPoint.getXValue());
                assertEquals(expectedPoint.getYValue(), actualPoint.getYValue(), 0.1);
            }
        }
    }
    @Test
    void Test4_getLineChartData() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }

        String country_region_1 = "Singapore";
        String country_region_2 = "China";
        List<String> years = List.of("2017", "2018", "2019", "2020");
        List<Double> scores1 = List.of(91.45, 91.35, 91.65, 91.8);
        List<Double> scores2 = List.of(52.92, 54.72857143, 53.1, 53.95);

        // Expected
        List<XYChart.Series<String, Double>> expected = new ArrayList<>();

        XYChart.Series<String, Double> country_1_data = new XYChart.Series<>();
        for (int i = 0; i < years.size(); i++) {
            if (scores1.get(i) >= 0) {
                country_1_data.getData().add(new XYChart.Data<>(years.get(i), scores1.get(i)));
            }
        }
        expected.add(country_1_data);

        XYChart.Series<String, Double> country_2_data = new XYChart.Series<>();
        for (int i = 0; i < years.size(); i++) {
            if (scores2.get(i) >= 0) {
                country_2_data.getData().add(new XYChart.Data<>(years.get(i), scores2.get(i)));
            }
        }
        expected.add(country_2_data);
        // Actual
        T22Analysis analyzer = new T22Analysis(country_region_1, country_region_2, years);
        List<XYChart.Series<String, Double>> actual = analyzer.getLineChartData("score");

        for (int i = 0; i < expected.size(); i++) {
            XYChart.Series<String, Double> expectedData = expected.get(i);
            XYChart.Series<String, Double> actualData = actual.get(i);
            for (int j = 0; j < expectedData.getData().size(); j++) {
                XYChart.Data<String, Double> expectedPoint = expectedData.getData().get(j);
                XYChart.Data<String, Double> actualPoint = actualData.getData().get(j);
                assertEquals(expectedPoint.getXValue(), actualPoint.getXValue());
                assertEquals(expectedPoint.getYValue(), actualPoint.getYValue(), 0.1);
            }
        }
    }
}