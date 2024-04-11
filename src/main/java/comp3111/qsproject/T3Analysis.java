package comp3111.qsproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T3Analysis {
    public ObservableList<RecommendItem> RecommendList = FXCollections.observableArrayList();

    T3Analysis (String top_input, String bottom_input, String type, String region) {
        /*
            Your Code Here.
            Collect the QSItem which fit the score range, type and region into the RecommendItem.
            Sort the RecommendList by bestRank.
            Hint: QSList.list is a static property and you can use "update" function in RecommendItem.
         */
    }

    ObservableList<RecommendItem> getRecommendData() {
        // Show the most valuable university
        return RecommendList;
    }
}
