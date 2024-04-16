package comp3111.qsproject;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    /* T1 Controller */
    public TableView<QSItem> t1DataTable;

    @FXML
    public ChoiceBox<String> t1YearChoiceBox;

    @FXML
    public BarChart<String, Double> t1BarChart;

    @FXML
    public TableColumn<QSItem, String> t1Rank;

    @FXML
    public TableColumn<QSItem, String> t1University;

    @FXML
    public TableColumn<QSItem, String> t1Score;

    @FXML
    public TableColumn<QSItem, String> t1Country;

    @FXML
    public TableColumn<QSItem, String> t1City;

    @FXML
    public TableColumn<QSItem, String> t1Type;

    @FXML
    public PieChart t1PieChart;

    @FXML
    public ChoiceBox<String> t1PieChartChoiceBox;

    @FXML
    public Label t1PieChartLabel;

    @FXML
    public ChoiceBox<String> t1BarChartChoiceBox;

    @FXML
    public Label t1BarChartLabel;

    @FXML
    public CategoryAxis t1BarChartTypeXaxis;

    /* T2 Controller */
    @FXML
    public ChoiceBox<String> t2University1ChoiceBox;
    @FXML
    public ChoiceBox<String> t2University2ChoiceBox;
    @FXML
    public ChoiceBox<String> t2CountryRegion1ChoiceBox;
    @FXML
    public ChoiceBox<String> t2CountryRegion2ChoiceBox;

    @FXML
    public CheckBox t22017CheckBox;
    @FXML
    public CheckBox t22018CheckBox;
    @FXML
    public CheckBox t22019CheckBox;
    @FXML
    public CheckBox t22020CheckBox;
    @FXML
    public CheckBox t22021CheckBox;
    @FXML
    public CheckBox t22022CheckBox;
    @FXML
    public CheckBox t22017CheckBox2;
    @FXML
    public CheckBox t22018CheckBox2;
    @FXML
    public CheckBox t22019CheckBox2;
    @FXML
    public CheckBox t22020CheckBox2;
    @FXML
    public CheckBox t22021CheckBox2;
    @FXML
    public CheckBox t22022CheckBox2;

    @FXML
    public BarChart<Double, String> t21RankBarChart;
    @FXML
    public BarChart<Double, String> t21ScoreBarChart;
    @FXML
    public BarChart<Double, String> t21FacultyBarChart;
    @FXML
    public BarChart<Double, String> t21InternationalBarChart;
    @FXML
    public BarChart<Double, String> t21SFRBarChart;
    @FXML
    public LineChart<String, Double> t21LineChart;

    @FXML
    public BarChart<Double, String> t22RankBarChart;
    @FXML
    public BarChart<Double, String> t22ScoreBarChart;
    @FXML
    public BarChart<Double, String> t22FacultyBarChart;
    @FXML
    public BarChart<Double, String> t22InternationalBarChart;
    @FXML
    public BarChart<Double, String> t22SFRBarChart;
    @FXML
    public LineChart<String, Double> t22LineChart;

    /* T3 Controller */

    @FXML
    public TextField t3TopRankTextField;
    @FXML
    public TextField t3BottomRankTextField;
    @FXML
    public ChoiceBox<String> t3TypeChoiceBox;
    @FXML
    public ChoiceBox<String> t3RegionChoiceBox;
    @FXML
    public TableView<RecommendItem> t3TableView;

    @FXML
    public TableColumn<RecommendItem, String> t3University;

    @FXML
    public TableColumn<RecommendItem, String> t3BestYear;

    @FXML
    public TableColumn<RecommendItem, String> t3BestRank;

    @FXML
    public TableColumn<RecommendItem, String> t3RecentYear;

    @FXML
    public TableColumn<RecommendItem, String> t3RecentRank;

    ObservableList<String> yearList = FXCollections.observableArrayList("2017", "2018", "2019", "2020", "2021", "2022");
    ObservableList<String> stringPropertyList = FXCollections.observableArrayList("country", "region", "size", "type", "researchOutput");

    @FXML
    private void initialize() {
        // Whole Program Information
        QSList.initialize();
        // T1
        t1YearChoiceBox.setItems(yearList);
        t1YearChoiceBox.setValue("2017");
        t1PieChartChoiceBox.setItems(stringPropertyList);
        t1PieChartChoiceBox.setValue("size");
        t1PieChartLabel.setText("");
        t1BarChartChoiceBox.setItems(stringPropertyList);
        t1BarChartChoiceBox.setValue("type");
        t1BarChartLabel.setText("");
        // T2
        /*
            Your Code Here.
            1. Initialize the Choice boxes of university.
            2. Initialize the Choice boxes of country/region.
            3. For choice boxes of country/region,
                you need to add a blank or "All" option representing selection of all the country/region.
         */
        t2University1ChoiceBox.getItems().addAll(QSList.university);
        t2University2ChoiceBox.getItems().addAll(QSList.university);

        t2CountryRegion1ChoiceBox.getItems().add("--");
        t2CountryRegion1ChoiceBox.getItems().add("All");
        t2CountryRegion1ChoiceBox.getItems().addAll(QSList.country);
        t2CountryRegion1ChoiceBox.getItems().addAll(QSList.region);

        t2CountryRegion2ChoiceBox.getItems().add("--");
        t2CountryRegion2ChoiceBox.getItems().add("All");
        t2CountryRegion2ChoiceBox.getItems().addAll(QSList.country);
        t2CountryRegion2ChoiceBox.getItems().addAll(QSList.region);
        // T3
        /*
            Your Code Here.
            1. Initialize the Choice boxes of type.
            2. Initialize the Choice boxes of region.
            3. For choice boxes of region,
                you need to add a blank or "All" option representing selection of all the region.
         */
    }

    @FXML
    private void T1_onClickClear() {
        /*
            Your Code Here.
            Reset the Page Task1. (including the choice box, labels and charts)
         */
    }

    @FXML
    private void T1_onClickSearch() {
        /*
            Your Code Here.
            When click search on Task1:
                1. Fetch the year from the choice box.
                2. Clear previous data.
                3. Make an Analyser.
                4. Update the Table view, which shows Information about universities.
                5. Update the Pie Chart, which shows the sum score of selected property (t1PieChartChoiceBox).
                6. Update the Bar Chart, which shows the average score of selected property (t1BarChartChoiceBox).
            Please notice that we need listeners for monitoring the changes of choice box in pie chart and bar chart.
         */
    }

    @FXML
    private void T21_onClickClear() {
        /*
            Your Code Here.
            Reset the Page Task 2.1. (including the choice boxes, check boxes and charts)
         */
        t2University1ChoiceBox.getSelectionModel().clearSelection();
        t2University2ChoiceBox.getSelectionModel().clearSelection();

        t22017CheckBox.setSelected(false);
        t22018CheckBox.setSelected(false);
        t22019CheckBox.setSelected(false);
        t22020CheckBox.setSelected(false);
        t22021CheckBox.setSelected(false);
        t22022CheckBox.setSelected(false);

        t21RankBarChart.getData().clear();
        t21ScoreBarChart.getData().clear();
        t21FacultyBarChart.getData().clear();
        t21InternationalBarChart.getData().clear();
        t21SFRBarChart.getData().clear();

        t21LineChart.getData().clear();
    }

    @FXML
    private void T21_onClickCompare() {
        /*
            Your Code Here.
            When click search on Task2.1:
                1. Fetch the two universities from the choice box.
                2. Fetch the selected years.
                3. Clear previous data.
                4. Make an Analyser.
                5. Update the Bar Charts, which shows the average of selected property.
                6. Update the line Chart, which shows two lines of score of each year.
         */
        t21RankBarChart.getData().clear();
        t21ScoreBarChart.getData().clear();
        t21FacultyBarChart.getData().clear();
        t21InternationalBarChart.getData().clear();
        t21SFRBarChart.getData().clear();

        t21LineChart.getData().clear();

        String uni_1 = t2University1ChoiceBox.getValue();
        String uni_2 = t2University2ChoiceBox.getValue();
        List<String> years = new ArrayList<>();
        CheckBox[] checkBoxes = {
                t22017CheckBox,
                t22018CheckBox,
                t22019CheckBox,
                t22020CheckBox,
                t22021CheckBox,
                t22022CheckBox};

        for (int i = 0; i < checkBoxes.length; i++) {
            CheckBox curBox = checkBoxes[i];
            String curYear = yearList.get(i);
            if (curBox.isSelected()) {
                years.add(curYear);
            }
        }

        String[] properties = {"rank", "score", "facultyCount", "internationalStudents", "studentFacultyRatio"};
        BarChart<Double, String>[] charts = new BarChart[]{
                t21RankBarChart,
                t21ScoreBarChart,
                t21FacultyBarChart,
                t21InternationalBarChart,
                t21SFRBarChart};

        T21Analysis analyzer = new T21Analysis(uni_1, uni_2, years);

        for (int i = 0; i < properties.length; i++) {
            charts[i].getData().add(analyzer.getBarChartData(properties[i]));
        }

        List<XYChart.Series<String, Double>> lineData = analyzer.getLineChartData("score");
        for (XYChart.Series<String, Double> line : lineData) {
            t21LineChart.getData().add(line);
        }
    }

    @FXML
    private void T22_onClickClear() {
        /*
            Your Code Here.
            Reset the Page Task 2.2. (including the choice boxes, check boxes and charts)
         */
        t2CountryRegion1ChoiceBox.getSelectionModel().clearSelection();
        t2CountryRegion2ChoiceBox.getSelectionModel().clearSelection();

        t22017CheckBox2.setSelected(false);
        t22018CheckBox2.setSelected(false);
        t22019CheckBox2.setSelected(false);
        t22020CheckBox2.setSelected(false);
        t22021CheckBox2.setSelected(false);
        t22022CheckBox2.setSelected(false);

        t22RankBarChart.getData().clear();
        t22ScoreBarChart.getData().clear();
        t22FacultyBarChart.getData().clear();
        t22InternationalBarChart.getData().clear();
        t22SFRBarChart.getData().clear();

        t22LineChart.getData().clear();
    }

    @FXML
    private void T22_onClickCompare() {
        /*
            Your Code Here.
            When click search on Task2.2:
                1. Fetch the two country/region from the choice box.
                2. Fetch the selected years.
                3. Clear previous data.
                4. Make an Analyser.
                5. Update the Bar Charts, which shows the average of selected property.
                6. Update the line Chart, which shows two lines of score of each year.
         */
        t22RankBarChart.getData().clear();
        t22ScoreBarChart.getData().clear();
        t22FacultyBarChart.getData().clear();
        t22InternationalBarChart.getData().clear();
        t22SFRBarChart.getData().clear();

        t22LineChart.getData().clear();

        String country_region_1 = t2CountryRegion1ChoiceBox.getValue();
        String country_region_2 = t2CountryRegion2ChoiceBox.getValue();

        List<String> years = new ArrayList<>();

        CheckBox[] checkBoxes = {
                t22017CheckBox2,
                t22018CheckBox2,
                t22019CheckBox2,
                t22020CheckBox2,
                t22021CheckBox2,
                t22022CheckBox2};

        for (int i = 0; i < checkBoxes.length; i++) {
            CheckBox curBox = checkBoxes[i];
            String curYear = yearList.get(i);
            if (curBox.isSelected()) {
                years.add(curYear);
            }
        }

        String[] properties = {"rank", "score", "facultyCount", "internationalStudents", "studentFacultyRatio"};
        BarChart<Double, String>[] charts = new BarChart[]{
                t22RankBarChart,
                t22ScoreBarChart,
                t22FacultyBarChart,
                t22InternationalBarChart,
                t22SFRBarChart};

        T22Analysis analyzer = new T22Analysis(country_region_1, country_region_2, years);

        for (int i = 0; i < properties.length; i++) {
            charts[i].getData().add(analyzer.getBarChartData(properties[i]));
        }

        List<XYChart.Series<String, Double>> lineData = analyzer.getLineChartData("score");
        for (XYChart.Series<String, Double> line : lineData) {
            t22LineChart.getData().add(line);
        }
    }

    @FXML
    private void T3_onClickClear() {
        /*
            Your Code Here.
            Reset the Page Task 2.2. (including the text fields, choice boxes and the table view)
         */
    }

    @FXML
    private void T3_onClickRecommend() {
        /*
            Your Code Here.
            When click search on Task3:
                1. Fetch the top and bottom boundary requirement of score.
                2. Fetch the type and region requirements.
                3. Clear previous data.
                4. Make an Analyser.
                5. Update the Table View.
         */
    }

}