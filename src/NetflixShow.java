public class NetflixShow {
    private String showName;
    private long viewCount;

    public String getShowName() {
        return showName;
    }// get show

    public NetflixShow(String showName, int viewCount) {
        this.showName = showName;
        this.viewCount = viewCount;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }// sey show

    public long getViewCount() {
        return viewCount;
    }// get count

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }// ser count

    public String toString() {
        String result = "";
        result += String.format("%50s%-20d", showName,viewCount);
        return result;
    }
    public String forFile(){
        String result = "";
        result += String.format(showName +";"+ viewCount + "\n");
        return result;
    }

    public void cleanShowName(){
        while (showName.contains("?")){
            showName = showName.replace("?","");
        }
        while (showName.contains("/")){
            showName = showName.replace("/","");
        }
        while(showName.contains("  ")){
            showName = showName.replace(" ","");
        }

    }


}
