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
            Hint: QSList.list is a static property, and you can use "update" function in RecommendItem.
         */
        RecommendList.clear();
        boolean updated = false;
        for (QSItem item: QSList.list) {
            if(item.getRank().compareTo(top_input) < 0 && item.getRank().compareTo(bottom_input) > 0){
                String uni_type = item.getType();
                String uni_region = item.getRegion();
                if(uni_type.equals(type) && uni_region.equals((region))){
                //update best rank if this uni is already a RecommendItem
                    for(RecommendItem recommendItem: RecommendList){
                        if(recommendItem.getName().equals(item.getName())&&!updated) {
                            recommendItem.update(item);
                            updated = true;
                        }
                    }
                //create new item if the uni first appear
                    if(!updated){
                        RecommendItem recommendItem = new RecommendItem(item);
                        RecommendList.add(recommendItem);
                    }
                    updated = false;
                }
            }
        }
        RecommendList.sort(Comparator.comparing(RecommendItem::getBestRank));
    }

    ObservableList<RecommendItem> getRecommendData() {
        // Show the most valuable university
        return RecommendList;
    }
}
