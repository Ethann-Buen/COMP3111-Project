package comp3111.qsproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T3Analysis implements Comparator<RecommendItem> {
    public ObservableList<RecommendItem> RecommendList = FXCollections.observableArrayList();


    /**
     * @param item1 Recommended Item in RecommendList
     * @param item2 Recommended Item RecommendList
     * @return Comparison results of two RecommendItem based on rankings
     * @author sq0519
     */
    @Override
    public int compare(RecommendItem item1, RecommendItem item2) {
        int rank1 = Integer.parseInt(item1.getBestRank());
        int rank2 = Integer.parseInt(item2.getBestRank());
        return Integer.compare(rank1, rank2);
    }

    /**
     * Constructor for Task 3 Analyzer. It extracts university data from QSList.list for further processing.
     * @param top_input top boundary of ranking range
     * @param bottom_input bottom boundary of ranking range
     * @param type type of universities
     * @param region region of universities
     * @author sq0519
     */
    T3Analysis (String top_input, String bottom_input, String type, String region) {
        /*
            Your Code Here.
            Collect the QSItem which fit the score range, type and region into the RecommendItem.
            Sort the RecommendList by bestRank.
            Hint: QSList.list is a static property, and you can use "update" function in RecommendItem.
         */
        boolean updated = false;
        for (QSItem item: QSList.list) {

            String uni_type = item.type;
            String uni_region = item.region;
            if ((uni_type.equals(type) || type.equals("ALL") || uni_type.isBlank()) &&
                    (uni_region.equals(region) || region.equals("ALL"))) {
                    //update best rank if this uni is already a RecommendItem
                    for (RecommendItem recommendItem : RecommendList) {
                        if (recommendItem.getName().equals(item.getName()) && !updated) {
                            recommendItem.update(item);
                            updated = true;
                        }
                    }
                    //create new item if the uni first appear
                    if (!updated) {
                        RecommendItem recommendItem = new RecommendItem(item);
                        RecommendList.add(recommendItem);
                    }
                    updated = false;
            }
        }

        Iterator<RecommendItem> iterator = RecommendList.iterator();
        while (iterator.hasNext()) {
            RecommendItem item = iterator.next();
            int uni_rank = Integer.parseInt(item.getBestRank());
            if (!((top_input.isBlank() || uni_rank >= Integer.parseInt(top_input))
                    && (bottom_input.isBlank() || uni_rank <= Integer.parseInt(bottom_input)))) {
                iterator.remove();
            }
        }

        RecommendList.sort(this);
    }

    ObservableList<RecommendItem> getRecommendData() {
        // Show the most valuable university
        return RecommendList;
    }
}