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
     * Constructor of RecommendItem (used in unit test)
     * @param inputName Name of university
     * @param inputBestYear Year of the university's best ranking
     * @param inputBestRank Best ranking of the university
     * @param inputRecentYear Year of the university's most recent ranking
     * @param inputRecentRank Recent rankings of the university
     */
    RecommendItem(String inputName, String inputBestYear, String inputBestRank, String inputRecentYear, String inputRecentRank){
        name = inputName;
        bestYear = inputBestYear;
        bestRank = inputBestRank;
        recentYear = inputRecentYear;
        recentRank = inputRecentRank;
    }


    /**
     * Update the bestYear, bestRank, recentYear and recentRank for University
     * @param item QSItem with information of university
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
        int currItemRank = Integer.parseInt(item.getProperty("rank"));
        int bestItemRank = Integer.parseInt(bestRank);
        int currItemYear = Integer.parseInt(item.getProperty("year"));
        int recentItemYear = Integer.parseInt(recentYear);

        if(currItemRank <= bestItemRank){
            bestYear = item.year;
            bestRank = item.rank;
        }
        if(currItemYear >= recentItemYear ){
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
