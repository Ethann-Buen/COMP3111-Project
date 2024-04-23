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

        t1YearChoiceBox.setValue("2017");
        t1PieChartChoiceBox.setValue("size");
        t1BarChartChoiceBox.setValue("type");

        t1PieChartLabel.setText("");
        t1BarChartLabel.setText("");

        t1PieChart.getData().clear();
        t1BarChart.getData().clear();
    }

    private void T1_updatePieChart(T1Analysis analyzer) {
        String pieSearchName = t1PieChartChoiceBox.getValue();
        t1PieChartLabel.setText(pieSearchName.concat(" & score"));
        t1PieChart.getData().clear();
        ObservableList<PieChart.Data> pieChartData = analyzer.getPieChartData(pieSearchName);
        pieChartData.forEach(datum ->
                datum.nameProperty().bind(Bindings.concat(datum.getName(), " ",
                        datum.pieValueProperty().getValue().intValue()))
        );
        for (PieChart.Data datum : pieChartData) {
            t1PieChart.getData().add(datum);
        }
    }

    private void T1_updateBarChart(T1Analysis analyzer) {
        String barSearchName = t1BarChartChoiceBox.getValue();
        t1BarChartLabel.setText(barSearchName.concat(" & score"));
        t1BarChart.getData().clear();
        t1BarChart.getData().add(analyzer.getBarChartData(barSearchName));
        if (barSearchName.equals("country")) {
            t1BarChart.setCategoryGap(0);
            t1BarChart.setBarGap(2);
            t1BarChartTypeXaxis.tickLabelFontProperty().set(Font.font(6));
        }
        else {
            t1BarChart.setCategoryGap(5);
            t1BarChart.setBarGap(5);
            t1BarChartTypeXaxis.tickLabelFontProperty().set(Font.font(12));
        }
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

        String year = t1YearChoiceBox.getValue();
        T1Analysis analyzer = new T1Analysis(year);

        t1DataTable.setItems(analyzer.tableList);
        t1Rank.setCellValueFactory(new PropertyValueFactory<QSItem, String>("rank"));
        t1University.setCellValueFactory(new PropertyValueFactory<QSItem, String>("name"));
        t1Score.setCellValueFactory(new PropertyValueFactory<QSItem, String>("score"));
        t1Country.setCellValueFactory(new PropertyValueFactory<QSItem, String>("country"));
        t1City.setCellValueFactory(new PropertyValueFactory<QSItem, String>("city"));
        t1Type.setCellValueFactory(new PropertyValueFactory<QSItem, String>("type"));

        T1_updatePieChart(analyzer);
        t1PieChartChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            T1_updatePieChart(analyzer);
        });

        T1_updateBarChart(analyzer);
        t1BarChartChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            T1_updateBarChart(analyzer);
        });
    }

    @FXML
    private void T21_onClickClear() {
        /*
            Your Code Here.
            Reset the Page Task 2.1. (including the choice boxes, check boxes and charts)
         */
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
    }

    @FXML
    private void T22_onClickClear() {
        /*
            Your Code Here.
            Reset the Page Task 2.2. (including the choice boxes, check boxes and charts)
         */
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