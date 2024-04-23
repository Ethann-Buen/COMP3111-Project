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

    /**
     * Update the bestYear, bestRank, recentYear and recentRank for University
     * @author sq0519
     */
    void update(QSItem item) {
        assert (item.name.equals(name));
        /*
            Your Code Here.
            This function update the information from other QSItem.
            1. Update the best rank and the corresponding year.
            2. Update the most recent year and the corresponding rank.
         */
        if(item.rank.compareTo(bestRank) < 0){
            bestYear = item.year;
            bestRank = item.rank;
        }
        if(item.year.compareTo(recentYear) > 0 ){
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
