package comp3111.qsproject;

import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class T21AnalysisTest {

    @Test
    void Test1_getBarChartData() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }

        String uni_1 = "Massachusetts Institute of Technology (MIT)";
        String uni_2 = "ETH Zurich - Swiss Federal Institute of Technology";
        List<String> years = List.of("2017", "2019", "2020", "2021");

        // Expected
        XYChart.Series<Double, String> expected = new XYChart.Series<>();
        expected.getData().add(new XYChart.Data<>(95.1, "University 2"));
        expected.getData().add(new XYChart.Data<>(100.0, "University 1"));
        // Actual
        T21Analysis analyzer = new T21Analysis(uni_1, uni_2, years);
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

        String uni_1 = "CentraleSupélec";
        String uni_2 = "Boston University";
        List<String> years = List.of("2020", "2018", "2022");

        // Expected
        XYChart.Series<Double, String> expected = new XYChart.Series<>();
        expected.getData().add(new XYChart.Data<>(10.0, "University 2"));
        expected.getData().add(new XYChart.Data<>(0.0, "University 1"));
        // Actual
        T21Analysis analyzer = new T21Analysis(uni_1, uni_2, years);
        XYChart.Series<Double, String> actual = analyzer.getBarChartData("studentFacultyRatio");

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

        String uni_1 = "Bauman Moscow State Technical University";
        String uni_2 = "Bandung Institute of Technology (ITB)";
        List<String> years = List.of("2020", "2018", "2022", "2017", "2019", "2021");

        // Expected
        XYChart.Series<Double, String> expected = new XYChart.Series<>();
        expected.getData().add(new XYChart.Data<>(327.4, "University 2"));
        expected.getData().add(new XYChart.Data<>(290.5, "University 1"));
        // Actual
        T21Analysis analyzer = new T21Analysis(uni_1, uni_2, years);
        XYChart.Series<Double, String> actual = analyzer.getBarChartData("rank");

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

        String uni_1 = "Technische Universität Berlin (TU Berlin)";
        String uni_2 = "Pakistan Institute of Engineering and Applied Sciences (PIEAS)";
        List<String> years = List.of("2020", "2019", "2021");

        // Expected
        XYChart.Series<Double, String> expected = new XYChart.Series<>();
        expected.getData().add(new XYChart.Data<>(0.0, "University 2"));
        expected.getData().add(new XYChart.Data<>(6464.0, "University 1"));
        // Actual
        T21Analysis analyzer = new T21Analysis(uni_1, uni_2, years);
        XYChart.Series<Double, String> actual = analyzer.getBarChartData("internationalStudents");

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

        String uni_1 = "University of Canterbury";
        String uni_2 = "Khalifa University";
        List<String> years = List.of("2020", "2019", "2021");

        // Expected
        XYChart.Series<Double, String> expected = new XYChart.Series<>();
        expected.getData().add(new XYChart.Data<>(498.0, "University 2"));
        expected.getData().add(new XYChart.Data<>(0.0, "University 1"));
        // Actual
        T21Analysis analyzer = new T21Analysis(uni_1, uni_2, years);
        XYChart.Series<Double, String> actual = analyzer.getBarChartData("facultyCount");

        for (int i = 0; i < expected.getData().size(); i++) {
            XYChart.Data<Double, String> expectedData = expected.getData().get(i);
            XYChart.Data<Double, String> actualData = actual.getData().get(i);
            assertEquals(expectedData.getXValue(), actualData.getXValue(), 0.1);
            assertEquals(expectedData.getYValue(), actualData.getYValue());
        }
    }
    @Test
    void Test6_getBarChartData() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }

        String uni_1 = "Alma Mater Studiorum - University of Bologna";
        String uni_2 = "Al-Farabi Kazakh National University";
        List<String> years = List.of("2017", "2021", "2022");

        // Expected
        XYChart.Series<Double, String> expected = new XYChart.Series<>();
        expected.getData().add(new XYChart.Data<>(45.399999999999984, "University 2"));
        expected.getData().add(new XYChart.Data<>(47.300000000000004, "University 1"));
        // Actual
        T21Analysis analyzer = new T21Analysis(uni_1, uni_2, years);
        XYChart.Series<Double, String> actual = analyzer.getBarChartData("score");

        for (int i = 0; i < expected.getData().size(); i++) {
            XYChart.Data<Double, String> expectedData = expected.getData().get(i);
            XYChart.Data<Double, String> actualData = actual.getData().get(i);
            assertEquals(expectedData.getXValue(), actualData.getXValue(), 0.1);
            assertEquals(expectedData.getYValue(), actualData.getYValue());
        }
    }
    @Test
    void Test7_getBarChartData() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }

        String uni_1 = "Nanyang Technological University, Singapore (NTU)";
        String uni_2 = "National Sun Yat-sen University";
        List<String> years = List.of("2017", "2018", "2019");

        // Expected
        XYChart.Series<Double, String> expected = new XYChart.Series<>();
        expected.getData().add(new XYChart.Data<>(391.5, "University 2"));
        expected.getData().add(new XYChart.Data<>(12.0, "University 1"));
        // Actual
        T21Analysis analyzer = new T21Analysis(uni_1, uni_2, years);
        XYChart.Series<Double, String> actual = analyzer.getBarChartData("rank");

        for (int i = 0; i < expected.getData().size(); i++) {
            XYChart.Data<Double, String> expectedData = expected.getData().get(i);
            XYChart.Data<Double, String> actualData = actual.getData().get(i);
            assertEquals(expectedData.getXValue(), actualData.getXValue(), 0.1);
            assertEquals(expectedData.getYValue(), actualData.getYValue());
        }
    }
    @Test
    void Test8_getBarChartData() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }

        String uni_1 = "Université Paris Descartes";
        String uni_2 = "Aalborg University";
        List<String> years = List.of("2017", "2019", "2022");

        // Expected
        XYChart.Series<Double, String> expected = new XYChart.Series<>();
        expected.getData().add(new XYChart.Data<>(31.96666666666667, "University 2"));
        expected.getData().add(new XYChart.Data<>(0.0, "University 1"));
        // Actual
        T21Analysis analyzer = new T21Analysis(uni_1, uni_2, years);
        XYChart.Series<Double, String> actual = analyzer.getBarChartData("score");

        for (int i = 0; i < expected.getData().size(); i++) {
            XYChart.Data<Double, String> expectedData = expected.getData().get(i);
            XYChart.Data<Double, String> actualData = actual.getData().get(i);
            assertEquals(expectedData.getXValue(), actualData.getXValue(), 0.1);
            assertEquals(expectedData.getYValue(), actualData.getYValue());
        }
    }
    @Test
    void Test9_getBarChartData() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }

        String uni_1 = "Université Paris Descartes";
        String uni_2 = "Aalborg University";
        List<String> years = List.of("2017", "2019", "2022");

        // Expected
        XYChart.Series<Double, String> expected = new XYChart.Series<>();
        expected.getData().add(new XYChart.Data<>(2474.0, "University 2"));
        expected.getData().add(new XYChart.Data<>(11387.0, "University 1"));
        // Actual
        T21Analysis analyzer = new T21Analysis(uni_1, uni_2, years);
        XYChart.Series<Double, String> actual = analyzer.getBarChartData("internationalStudents");

        for (int i = 0; i < expected.getData().size(); i++) {
            XYChart.Data<Double, String> expectedData = expected.getData().get(i);
            XYChart.Data<Double, String> actualData = actual.getData().get(i);
            assertEquals(expectedData.getXValue(), actualData.getXValue(), 0.1);
            assertEquals(expectedData.getYValue(), actualData.getYValue());
        }
    }
    @Test
    void Test10_getBarChartData() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }

        String uni_1 = "CentraleSupélec";
        String uni_2 = "Boston University";
        List<String> years = List.of("2020", "2018", "2022");

        // Expected
        XYChart.Series<Double, String> expected = new XYChart.Series<>();
        expected.getData().add(new XYChart.Data<>(2642.0, "University 2"));
        expected.getData().add(new XYChart.Data<>(552.0, "University 1"));
        // Actual
        T21Analysis analyzer = new T21Analysis(uni_1, uni_2, years);
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

        String uni_1 = "CentraleSupélec";
        String uni_2 = "University of South Australia";
        List<String> years = List.of("2017", "2018", "2019", "2020", "2021", "2022");
        List<Double> scores1 = List.of(52.3, 52.3, 52.3, 52.3, 52.3, -1.0);
        List<Double> scores2 = List.of(37.4, 39.1, 36.7, 35.9, 34.5, 32.8);

        // Expected
        List<XYChart.Series<String, Double>> expected = new ArrayList<>();

        XYChart.Series<String, Double> uni_1_data = new XYChart.Series<>();
        for (int i = 0; i < years.size(); i++) {
            if (scores1.get(i) >= 0) {
                uni_1_data.getData().add(new XYChart.Data<>(years.get(i), scores1.get(i)));
            }
        }
        expected.add(uni_1_data);

        XYChart.Series<String, Double> uni_2_data = new XYChart.Series<>();
        for (int i = 0; i < years.size(); i++) {
            if (scores2.get(i) >= 0) {
                uni_2_data.getData().add(new XYChart.Data<>(years.get(i), scores2.get(i)));
            }
        }
        expected.add(uni_2_data);
        // Actual
        T21Analysis analyzer = new T21Analysis(uni_1, uni_2, years);
        List<XYChart.Series<String, Double>> actual = analyzer.getLineChartData("score");

        for (int i = 0; i < expected.size(); i++) {
            XYChart.Series<String, Double> expectedData = expected.get(i);
            XYChart.Series<String, Double> actualData = actual.get(i);
            for (int j = 0; j < expectedData.getData().size(); j++) {;
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

        String uni_1 = "Belarusian State University";
        String uni_2 = "Beihang University (former BUAA)";
        List<String> years = List.of("2017", "2019", "2021", "2022");
        List<Double> scores1 = List.of(33.0, 30.8, 33.0, 34.9);
        List<Double> scores2 = List.of(-1.0, -1.0, -1.0, 29.1);

        // Expected
        List<XYChart.Series<String, Double>> expected = new ArrayList<>();

        XYChart.Series<String, Double> uni_1_data = new XYChart.Series<>();
        for (int i = 0; i < years.size(); i++) {
            if (scores1.get(i) >= 0) {
                uni_1_data.getData().add(new XYChart.Data<>(years.get(i), scores1.get(i)));
            }
        }
        expected.add(uni_1_data);

        XYChart.Series<String, Double> uni_2_data = new XYChart.Series<>();
        for (int i = 0; i < years.size(); i++) {
            if (scores2.get(i) >= 0) {
                uni_2_data.getData().add(new XYChart.Data<>(years.get(i), scores2.get(i)));
            }
        }
        expected.add(uni_2_data);
        // Actual
        T21Analysis analyzer = new T21Analysis(uni_1, uni_2, years);
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

        String uni_1 = "Scuola Normale Superiore";
        String uni_2 = "Sant'Anna - Scuola Universitaria Superiore Pisa";
        List<String> years = List.of("2017", "2018", "2019", "2020");
        List<Double> scores1 = List.of(-1.0, -1.0, -1.0, -1.0);
        List<Double> scores2 = List.of(-1.0, -1.0, -1.0, -1.0);

        // Expected
        List<XYChart.Series<String, Double>> expected = new ArrayList<>();

        XYChart.Series<String, Double> uni_1_data = new XYChart.Series<>();
        for (int i = 0; i < years.size(); i++) {
            if (scores1.get(i) >= 0) {
                uni_1_data.getData().add(new XYChart.Data<>(years.get(i), scores1.get(i)));
            }
        }
        expected.add(uni_1_data);

        XYChart.Series<String, Double> uni_2_data = new XYChart.Series<>();
        for (int i = 0; i < years.size(); i++) {
            if (scores2.get(i) >= 0) {
                uni_2_data.getData().add(new XYChart.Data<>(years.get(i), scores2.get(i)));
            }
        }
        expected.add(uni_2_data);
        // Actual
        T21Analysis analyzer = new T21Analysis(uni_1, uni_2, years);
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

        String uni_1 = "TELECOM Paris";
        String uni_2 = "Stanford University";
        List<String> years = List.of("2017", "2019", "2020", "2021", "2022");
        List<Double> scores1 = List.of(-1.0, -1.0, -1.0, -1.0, -1.0);
        List<Double> scores2 = List.of(98.7, 98.6, 98.4, 98.4, 98.7);

        // Expected
        List<XYChart.Series<String, Double>> expected = new ArrayList<>();

        XYChart.Series<String, Double> uni_1_data = new XYChart.Series<>();
        for (int i = 0; i < years.size(); i++) {
            if (scores1.get(i) >= 0) {
                uni_1_data.getData().add(new XYChart.Data<>(years.get(i), scores1.get(i)));
            }
        }
        expected.add(uni_1_data);

        XYChart.Series<String, Double> uni_2_data = new XYChart.Series<>();
        for (int i = 0; i < years.size(); i++) {
            if (scores2.get(i) >= 0) {
                uni_2_data.getData().add(new XYChart.Data<>(years.get(i), scores2.get(i)));
            }
        }
        expected.add(uni_2_data);
        // Actual
        T21Analysis analyzer = new T21Analysis(uni_1, uni_2, years);
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