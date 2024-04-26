package comp3111.qsproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class T1AnalysisTest {

    @Test
    void test1_getTableList() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }

        String year = "2017";
        T1Analysis analyzer = new T1Analysis(year);

        ObservableList<QSItem> expected = FXCollections.observableArrayList();
        for (QSItem qsItem : QSList.list) {
            String qsItemYear = qsItem.getProperty("year");
            if (qsItemYear.equals(year)) {
                expected.add(qsItem);
            }
        }

        ObservableList<QSItem> actual = analyzer.getTableList();

        assertEquals(expected,actual);
    }

    @Test
    void test2_getTableList() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }

        String year = "2019";
        T1Analysis analyzer = new T1Analysis(year);

        ObservableList<QSItem> expected = FXCollections.observableArrayList();
        for (QSItem qsItem : QSList.list) {
            String qsItemYear = qsItem.getProperty("year");
            if (qsItemYear.equals(year)) {
                expected.add(qsItem);
            }
        }

        ObservableList<QSItem> actual = analyzer.getTableList();

        assertEquals(expected,actual);
    }

    @Test
    void test3_getTableList() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }

        String year = "2022";
        T1Analysis analyzer = new T1Analysis(year);

        ObservableList<QSItem> expected = FXCollections.observableArrayList();
        for (QSItem qsItem : QSList.list) {
            String qsItemYear = qsItem.getProperty("year");
            if (qsItemYear.equals(year)) {
                expected.add(qsItem);
            }
        }

        ObservableList<QSItem> actual = analyzer.getTableList();

        assertEquals(expected,actual);
    }

    @Test
    void test1_getKeyList() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }

        String searchName = "country";
        String year = "2017";
        T1Analysis analyzer = new T1Analysis(year);

        ObservableList<String> expected = QSList.country;

        ObservableList<String> actual = analyzer.getKeyList(searchName);

        assertEquals(expected,actual);
    }

    @Test
    void test2_getKeyList() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }

        String searchName = "region";
        String year = "2018";
        T1Analysis analyzer = new T1Analysis(year);

        ObservableList<String> expected = QSList.region;

        ObservableList<String> actual = analyzer.getKeyList(searchName);

        assertEquals(expected,actual);
    }

    @Test
    void test3_getKeyList() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }

        String searchName = "size";
        String year = "2020";
        T1Analysis analyzer = new T1Analysis(year);

        ObservableList<String> expected = FXCollections.observableArrayList("S", "M", "L", "XL");

        ObservableList<String> actual = analyzer.getKeyList(searchName);

        assertEquals(expected,actual);
    }

    @Test
    void test4_getKeyList() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }

        String searchName = "type";
        String year = "2021";
        T1Analysis analyzer = new T1Analysis(year);

        ObservableList<String> expected = FXCollections.observableArrayList("Public", "Private");

        ObservableList<String> actual = analyzer.getKeyList(searchName);

        assertEquals(expected,actual);
    }

    @Test
    void test5_getKeyList() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }

        String searchName = "researchOutput";
        String year = "2022";
        T1Analysis analyzer = new T1Analysis(year);

        ObservableList<String> expected = FXCollections.observableArrayList("Medium", "High", "Very high");

        ObservableList<String> actual = analyzer.getKeyList(searchName);

        assertEquals(expected,actual);
    }

    @Test
    void test6_getKeyList() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }

        String searchName = "";
        String year = "";
        T1Analysis analyzer = new T1Analysis(year);

        ObservableList<String> expected = FXCollections.observableArrayList();

        ObservableList<String> actual = analyzer.getKeyList(searchName);

        assertEquals(expected,actual);
    }

    @Test
    void test1_getPieChartData() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }
        String searchName = "region";
        String year = "2017";
        T1Analysis analyzer = new T1Analysis(year);

        ObservableList<PieChart.Data> expected = FXCollections.observableArrayList();
        expected.add(new PieChart.Data("Africa", 143.3));
        expected.add(new PieChart.Data("Asia", 4238.3));
        expected.add(new PieChart.Data("Europe", 8863.7));
        expected.add(new PieChart.Data("Latin America", 596.7));
        expected.add(new PieChart.Data("North America", 5348.3));
        expected.add(new PieChart.Data("Oceania", 1389.6));

        ObservableList<PieChart.Data> actual = analyzer.getPieChartData(searchName);

        for (int i = 0; i < expected.size(); i++) {
            PieChart.Data expectedData = expected.get(i);
            PieChart.Data actualData = actual.get(i);
            assertEquals(expectedData.getName(), actualData.getName());
            assertEquals(expectedData.getPieValue(), actualData.getPieValue(),0.1);
        }
    }

    @Test
    void test2_getPieChartData() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }
        String searchName = "size";
        String year = "2019";
        T1Analysis analyzer = new T1Analysis(year);

        ObservableList<PieChart.Data> expected = FXCollections.observableArrayList();
        expected.add(new PieChart.Data("S", 887.5));
        expected.add(new PieChart.Data("M", 2972.0));
        expected.add(new PieChart.Data("L", 9651.0));
        expected.add(new PieChart.Data("XL", 5979.5));

        ObservableList<PieChart.Data> actual = analyzer.getPieChartData(searchName);

        for (int i = 0; i < expected.size(); i++) {
            PieChart.Data expectedData = expected.get(i);
            PieChart.Data actualData = actual.get(i);
            assertEquals(expectedData.getName(), actualData.getName());
            assertEquals(expectedData.getPieValue(), actualData.getPieValue(),0.1);
        }
    }


    @Test
    void test3_getPieChartData() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }
        String searchName = "type";
        String year = "2022";
        T1Analysis analyzer = new T1Analysis(year);

        ObservableList<PieChart.Data> expected = FXCollections.observableArrayList();
        expected.add(new PieChart.Data("Public", 16656.8));
        expected.add(new PieChart.Data("Private", 3149.6));

        ObservableList<PieChart.Data> actual = analyzer.getPieChartData(searchName);

        for (int i = 0; i < expected.size(); i++) {
            PieChart.Data expectedData = expected.get(i);
            PieChart.Data actualData = actual.get(i);
            assertEquals(expectedData.getName(), actualData.getName());
            assertEquals(expectedData.getPieValue(), actualData.getPieValue(),0.1);
        }
    }

    @Test
    void test1_getBarChartData() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }
        String searchName = "region";
        String year = "2017";
        T1Analysis analyzer = new T1Analysis(year);

        XYChart.Series<String, Double> expected = new XYChart.Series<>();
        expected.getData().add(new XYChart.Data<>("Africa", 35.8));
        expected.getData().add(new XYChart.Data<>("Asia", 51.1));
        expected.getData().add(new XYChart.Data<>("Europe", 49.8));
        expected.getData().add(new XYChart.Data<>("Latin America", 45.9));
        expected.getData().add(new XYChart.Data<>("North America", 57.5));
        expected.getData().add(new XYChart.Data<>("Oceania", 49.6));

        XYChart.Series<String, Double> actual = analyzer.getBarChartData(searchName);

        for (int i = 0; i < expected.getData().size(); i++) {
            XYChart.Data<String, Double> expectedData = expected.getData().get(i);
            XYChart.Data<String, Double> actualData = actual.getData().get(i);
            assertEquals(expectedData.getXValue(), actualData.getXValue());
            assertEquals(expectedData.getYValue(), actualData.getYValue(),0.1);
        }
    }

    @Test
    void test2_getBarChartData() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }
        String searchName = "size";
        String year = "2019";
        T1Analysis analyzer = new T1Analysis(year);

        XYChart.Series<String, Double> expected = new XYChart.Series<>();
        expected.getData().add(new XYChart.Data<>("S", 44.4));
        expected.getData().add(new XYChart.Data<>("M", 44.4));
        expected.getData().add(new XYChart.Data<>("L", 49.2));
        expected.getData().add(new XYChart.Data<>("XL", 51.5));

        XYChart.Series<String, Double> actual = analyzer.getBarChartData(searchName);

        for (int i = 0; i < expected.getData().size(); i++) {
            XYChart.Data<String, Double> expectedData = expected.getData().get(i);
            XYChart.Data<String, Double> actualData = actual.getData().get(i);
            assertEquals(expectedData.getXValue(), actualData.getXValue());
            assertEquals(expectedData.getYValue(), actualData.getYValue(),0.1);
        }
    }

    @Test
    void test3_getBarChartData() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }
        String searchName = "type";
        String year = "2022";
        T1Analysis analyzer = new T1Analysis(year);

        XYChart.Series<String, Double> expected = new XYChart.Series<>();
        expected.getData().add(new XYChart.Data<>("Public", 48.4));
        expected.getData().add(new XYChart.Data<>("Private", 56.2));

        XYChart.Series<String, Double> actual = analyzer.getBarChartData(searchName);

        for (int i = 0; i < expected.getData().size(); i++) {
            XYChart.Data<String, Double> expectedData = expected.getData().get(i);
            XYChart.Data<String, Double> actualData = actual.getData().get(i);
            assertEquals(expectedData.getXValue(), actualData.getXValue());
            assertEquals(expectedData.getYValue(), actualData.getYValue(),0.1);
        }
    }
}