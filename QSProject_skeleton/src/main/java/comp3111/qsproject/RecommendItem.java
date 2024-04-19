package comp3111.qsproject;

public class RecommendItem {
    String name;

    String bestYear;

    String bestRank;

    String recentYear;

    String recentRank;

    RecommendItem(QSItem item) {
        name = item.name;
        bestYear = item.year;
        bestRank = item.rank;
        recentYear = item.year;
        recentRank = item.rank;
    }

    //For JUnit Test Case
//    RecommendItem(String testName, String best_year, String best_rank, String recent_year, String recent_rank) {
//        name = testName;
//        bestYear = best_year;
//        bestRank = best_rank;
//        recentYear = recent_year;
//        recentRank = recent_rank;
//    }

    void update(QSItem item) {
        assert (item.name.equals(name));
        /*
            Your Code Here.
            This function update the information from other QSItem.
            1. Update the best rank and the corresponding year.
            2. Update the most recent year and the corresponding rank.
         */
        //if curr rank < recorded rank then update
        if(item.getRank().compareTo(bestRank) < 0){
            bestYear = item.year;
            bestRank = item.rank;
        }
        //if curr year > recorded year then update
        if(item.getYear().compareTo(recentYear) > 0 ){
            recentYear = item.year;
            recentRank = item.rank;
        }
    }

    public String getName() { return name; }

    public String getBestYear() { return bestYear; }

    public String getBestRank() { return bestRank; }

    public String getRecentYear() { return recentYear; }

    public String getRecentRank() { return recentRank; }
}
