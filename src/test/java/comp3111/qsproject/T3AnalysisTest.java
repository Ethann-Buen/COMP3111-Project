package comp3111.qsproject;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;
import java.util.stream.Stream;


import static org.junit.jupiter.api.Assertions.*;


class T3AnalysisTest {


    /**
     * Top: 1, Bottom: 1, Type = ALL, Region = ALL
     * Case: Boundary inputs
     */
    @Test
    void Test1_getRecommendData() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }


        //Expect output list
        ObservableList<RecommendItem> ExpectList = FXCollections.observableArrayList();
        ExpectList.add(new RecommendItem("Massachusetts Institute of Technology (MIT)",
                "2022", "1",
                "2022","1"));


        //Actual output list
        T3Analysis ActualList = new T3Analysis("1","1","ALL","ALL");

        //Compare
        assertEquals(ExpectList.size(), ActualList.getRecommendData().size());


        for (int i = 0; i < ExpectList.size(); i++) {
            RecommendItem item1 = ExpectList.get(i);
            RecommendItem item2 = ActualList.getRecommendData().get(i);


            assertEquals(item1.getName(), item2.getName());
            assertEquals(item1.getBestRank(), item2.getBestRank());
            assertEquals(item1.getBestYear(), item2.getBestYear());
            assertEquals(item1.getRecentRank(), item2.getRecentRank());
            assertEquals(item1.getRecentYear(), item2.getRecentYear());
        }
    }


    /**
     * Top: 1, Bottom: 10, Type = Private, Region = ALL
     * Case: Typical inputs
     */
    @Test
    void Test2_getRecommendData() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }


        //Expect output list
        ObservableList<RecommendItem> ExpectList = FXCollections.observableArrayList();
        Stream.of(
                new RecommendItem("Massachusetts Institute of Technology (MIT)", "2022", "1", "2022", "1"),
                new RecommendItem("Stanford University", "2021", "2", "2022", "3"),
                new RecommendItem("Harvard University", "2021", "3", "2022", "5"),
                new RecommendItem("California Institute of Technology (Caltech)", "2021", "4", "2022", "6"),
                new RecommendItem("University of Chicago", "2021", "9", "2022", "10")
                )
                .forEach(ExpectList::add);
        //Actual output list
        T3Analysis ActualList = new T3Analysis("1","10","Private","ALL");


        //Compare
        assertEquals(ExpectList.size(), ActualList.getRecommendData().size());


        for (int i = 0; i < ExpectList.size(); i++) {
            RecommendItem item1 = ExpectList.get(i);
            RecommendItem item2 = ActualList.getRecommendData().get(i);

            assertEquals(item1.getName(), item2.getName());
            assertEquals(item1.getBestRank(), item2.getBestRank());
            assertEquals(item1.getBestYear(), item2.getBestYear());
            assertEquals(item1.getRecentRank(), item2.getRecentRank());
            assertEquals(item1.getRecentYear(), item2.getRecentYear());
        }
    }


    /**
     * Top: 100, Bottom: 110, Type = Public, Region = Asia
     * Case: Universities that are ranked within the input range for some years,
     * but whose overall best rank is higher than the input range, will not be displayed.
     */
    @Test
    void Test3_getRecommendData() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }


        //Expect output list
        ObservableList<RecommendItem> ExpectList = FXCollections.observableArrayList();
        Stream.of(
                        new RecommendItem("King Abdulaziz University (KAU)", "2022", "109", "2022", "109"),
                        new RecommendItem("Nagoya University", "2021", "110", "2022", "118")
                )
                .forEach(ExpectList::add);


        //Actual output list
        T3Analysis ActualList = new T3Analysis("100","110","Public","Asia");


        //Compare
        assertEquals(ExpectList.size(), ActualList.getRecommendData().size());


        for (int i = 0; i < ExpectList.size(); i++) {
            RecommendItem item1 = ExpectList.get(i);
            RecommendItem item2 = ActualList.getRecommendData().get(i);


            assertEquals(item1.getName(), item2.getName());
            assertEquals(item1.getBestRank(), item2.getBestRank());
            assertEquals(item1.getBestYear(), item2.getBestYear());
            assertEquals(item1.getRecentRank(), item2.getRecentRank());
            assertEquals(item1.getRecentYear(), item2.getRecentYear());
        }
    }

    /**
     * Top: 1, Bottom: 40, Type = ALL, Region = Oceania
     * Case: Typical inputs
     */
    @Test
    void Test4_getRecommendData() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }

        //Expect output list
        ObservableList<RecommendItem> ExpectList = FXCollections.observableArrayList();
        Stream.of(
                new RecommendItem("The Australian National University", "2018", "20", "2022", "27"),
                new RecommendItem("The University of Melbourne", "2022", "37", "2022", "37"),
                new RecommendItem("The University of Sydney","2022","38","2022","38")
                )
                .forEach(ExpectList::add);

        //Actual output list
        T3Analysis ActualList = new T3Analysis("1","40","ALL","Oceania");


        //Compare
        assertEquals(ExpectList.size(), ActualList.getRecommendData().size());

        for (int i = 0; i < ExpectList.size(); i++) {
            RecommendItem item1 = ExpectList.get(i);
            RecommendItem item2 = ActualList.getRecommendData().get(i);

            assertEquals(item1.getName(), item2.getName());
            assertEquals(item1.getBestRank(), item2.getBestRank());
            assertEquals(item1.getBestYear(), item2.getBestYear());
            assertEquals(item1.getRecentRank(), item2.getRecentRank());
            assertEquals(item1.getRecentYear(), item2.getRecentYear());
        }
    }

    /**
     * Top: 45, Bottom: 70, Type = Private, Region = North America
     * Case: Typical inputs
     */
    @Test
    void Test5_getRecommendData() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }

        //Expect output list
        ObservableList<RecommendItem> ExpectList = FXCollections.observableArrayList();

        Stream.of(
                new RecommendItem("Carnegie Mellon University", "2019", "46", "2022", "53"),
                new RecommendItem("Brown University", "2017", "49", "2022", "60")
                )
                .forEach(ExpectList::add);

        //Actual output list
        T3Analysis ActualList = new T3Analysis("45","70","Private","North America");


        //Compare
        assertEquals(ExpectList.size(), ActualList.getRecommendData().size());

        for (int i = 0; i < ExpectList.size(); i++) {
            RecommendItem item1 = ExpectList.get(i);
            RecommendItem item2 = ActualList.getRecommendData().get(i);

            assertEquals(item1.getName(), item2.getName());
            assertEquals(item1.getBestRank(), item2.getBestRank());
            assertEquals(item1.getBestYear(), item2.getBestYear());
            assertEquals(item1.getRecentRank(), item2.getRecentRank());
            assertEquals(item1.getRecentYear(), item2.getRecentYear());
        }
    }

    /**
     * Top: 400, Bottom: 400, Type = ALL, Region = ALL
     * Case: Boundary inputs
     */
    @Test
    void Test6_getRecommendData() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }

        //Expect output list
        ObservableList<RecommendItem> ExpectList = FXCollections.observableArrayList();
        Stream.of(
                new RecommendItem("Leibniz University Hannover", "2017", "400", "2017", "400")
                )
                .forEach(ExpectList::add);

        //Actual output list
        T3Analysis ActualList = new T3Analysis("400","400","ALL","ALL");


        //Compare
        assertEquals(ExpectList.size(), ActualList.getRecommendData().size());

        for (int i = 0; i < ExpectList.size(); i++) {
            RecommendItem item1 = ExpectList.get(i);
            RecommendItem item2 = ActualList.getRecommendData().get(i);

            assertEquals(item1.getName(), item2.getName());
            assertEquals(item1.getBestRank(), item2.getBestRank());
            assertEquals(item1.getBestYear(), item2.getBestYear());
            assertEquals(item1.getRecentRank(), item2.getRecentRank());
            assertEquals(item1.getRecentYear(), item2.getRecentYear());
        }
    }

    /**
     * Top: 401, Bottom: 500, Type = Private, Region = ALL
     * Case: Boundary inputs, empty list
     */
    @Test
    void Test7_getRecommendData() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }

        //Expect output list
        ObservableList<RecommendItem> ExpectList = FXCollections.observableArrayList();

        //Actual output list
        T3Analysis ActualList = new T3Analysis("401","500","Private","ALL");


        //Compare
        assertEquals(ExpectList.size(), ActualList.getRecommendData().size());

        for (int i = 0; i < ExpectList.size(); i++) {
            RecommendItem item1 = ExpectList.get(i);
            RecommendItem item2 = ActualList.getRecommendData().get(i);

            assertEquals(item1.getName(), item2.getName());
            assertEquals(item1.getBestRank(), item2.getBestRank());
            assertEquals(item1.getBestYear(), item2.getBestYear());
            assertEquals(item1.getRecentRank(), item2.getRecentRank());
            assertEquals(item1.getRecentYear(), item2.getRecentYear());
        }
    }

    /**
     * Top: -1, Bottom: -20, Type = ALL, Region = Asia
     * Case: Boundary inputs , empty list
     */
    @Test
    void Test8_getRecommendData() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }

        //Expect output list
        ObservableList<RecommendItem> ExpectList = FXCollections.observableArrayList();

        //Actual output list
        T3Analysis ActualList = new T3Analysis("-1","-20","ALL","Asia");

        //Compare
        assertEquals(ExpectList.size(), ActualList.getRecommendData().size());

        for (int i = 0; i < ExpectList.size(); i++) {
            RecommendItem item1 = ExpectList.get(i);
            RecommendItem item2 = ActualList.getRecommendData().get(i);

            assertEquals(item1.getName(), item2.getName());
            assertEquals(item1.getBestRank(), item2.getBestRank());
            assertEquals(item1.getBestYear(), item2.getBestYear());
            assertEquals(item1.getRecentRank(), item2.getRecentRank());
            assertEquals(item1.getRecentYear(), item2.getRecentYear());
        }
    }

    /**
     * Top: 1, Bottom: 400, Type = ALL, Region = Africa
     * Case: Typical inputs
     */
    @Test
    void Test9_getRecommendData() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }

        //Expect output list
        ObservableList<RecommendItem> ExpectList = FXCollections.observableArrayList();

        Stream.of(
                new RecommendItem("University of Cape Town", "2018", "191", "2022", "226"),
                new RecommendItem("University of Witwatersrand", "2017", "359", "2019", "381"),
                new RecommendItem("Stellenbosch University", "2018", "361", "2018", "361"),
                new RecommendItem("The American University in Cairo", "2017", "365", "2020", "395")
                )
                .forEach(ExpectList::add);

        //Actual output list
        T3Analysis ActualList = new T3Analysis("1","400","ALL","Africa");

        //Compare
        assertEquals(ExpectList.size(), ActualList.getRecommendData().size());

        for (int i = 0; i < ExpectList.size(); i++) {
            RecommendItem item1 = ExpectList.get(i);
            RecommendItem item2 = ActualList.getRecommendData().get(i);

            assertEquals(item1.getName(), item2.getName());
            assertEquals(item1.getBestRank(), item2.getBestRank());
            assertEquals(item1.getBestYear(), item2.getBestYear());
            assertEquals(item1.getRecentRank(), item2.getRecentRank());
            assertEquals(item1.getRecentYear(), item2.getRecentYear());
        }
    }

    /**
     * Top: 1, Bottom: 100, Type = ALL, Region = Latin America
     * Case: Typical inputs
     */
    @Test
    void Test10_getRecommendData() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }

        //Expect output list
        ObservableList<RecommendItem> ExpectList = FXCollections.observableArrayList();

        Stream.of(
                        new RecommendItem("Universidad de Buenos Aires (UBA)", "2021", "66", "2022", "69"),
                        new RecommendItem("Universidad Nacional Autónoma de México  (UNAM)", "2021", "100", "2022", "105")
                )
                .forEach(ExpectList::add);

        //Actual output list
        T3Analysis ActualList = new T3Analysis("1","100","ALL","Latin America");

        //Compare
        assertEquals(ExpectList.size(), ActualList.getRecommendData().size());

        for (int i = 0; i < ExpectList.size(); i++) {
            RecommendItem item1 = ExpectList.get(i);
            RecommendItem item2 = ActualList.getRecommendData().get(i);

            assertEquals(item1.getName(), item2.getName());
            assertEquals(item1.getBestRank(), item2.getBestRank());
            assertEquals(item1.getBestYear(), item2.getBestYear());
            assertEquals(item1.getRecentRank(), item2.getRecentRank());
            assertEquals(item1.getRecentYear(), item2.getRecentYear());
        }
    }
}
