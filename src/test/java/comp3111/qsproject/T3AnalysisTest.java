package comp3111.qsproject;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;
import java.util.stream.Stream;


import static org.junit.jupiter.api.Assertions.*;


class T3AnalysisTest {


    /**
     * Top: 1, Bottom: 1, Type = ALL, Region = ALL
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


        //debug
//        for (RecommendItem item : ActualList.getRecommendData()) {
//            System.out.println(item.getName());
//            System.out.println(item.getBestRank());
//            System.out.println(item.getBestYear());
//            System.out.println(item.getRecentRank());
//            System.out.println(item.getRecentYear());
//        }


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
     */
    @Test
    void Test3_getRecommendData() {
        if (QSList.list.isEmpty()) {
            QSList.initialize();
        }


        //Expect output list
        ObservableList<RecommendItem> ExpectList = FXCollections.observableArrayList();
        Stream.of(
                        new RecommendItem("University of Science and Technology of China", "2017", "104", "2017", "104"),
                        new RecommendItem("The Hong Kong Polytechnic University", "2019", "106", "2019", "106"),
                        new RecommendItem("King Abdulaziz University (KAU)", "2022", "109", "2022", "109"),
                        new RecommendItem("Zhejiang University", "2017", "110", "2017", "110"),
                        new RecommendItem("Nagoya University", "2021", "110", "2021", "110")
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
}
