package news.core.spyder;

public class NewsModel {
    private String newsName;
    private String newsAvatar;
    private String newsLink;
    private String newsSource;
    private String newContent;
    private  String newsPostTime;
    private String newsOtherSources;
    public NewsModel(){};
    public NewsModel (String newsName, String newsAvatar, String newsLink, String newsSource,
                      String newContent, String newsPostTime, String newsOtherSources)
    {
        this.newsName = newsName;
        this.newsAvatar = newsAvatar;
        this.newsLink = newsLink;
        this.newsSource = newsSource;
        this.newContent = newContent;
        this.newsPostTime = newsPostTime;
        this.newsOtherSources = newsOtherSources;
    }

    public void setName(String name) { this.newsName = newsName; }
    public String getName() { return newsName; }

    public void setAvatar(String avatar) { this.newsAvatar = newsAvatar; }
    public String getAvatar() { return newsAvatar; }

    public void setLink(String link) { this.newsLink = newsLink; }
    public String getLink() { return newsLink; }

    public void setSource(String source) { this.newsSource = source; }
    public String getSource() { return newsSource; }

    public void setContent(String content) { this.newContent = content; }
    public String getContent() { return newContent; }

    public void setNewsPostTime(String newsPostTime) { this.newsPostTime = newsPostTime; }
    public String getNewsPostTime() { return newsPostTime; }

    public void setOtherSources(String otherSources) { this.newsOtherSources = otherSources; }
    public String getOtherSources() { return newsOtherSources; }

    @Override
    public String toString() {
        return "NewsModel{" +
                "newsName='" + newsName + '\'' +
                ", newsAvatar='" + newsAvatar + '\'' +
                ", newsLink='" + newsLink + '\'' +
                ", newsSource='" + newsSource + '\'' +
                ", newContent='" + newContent + '\'' +
                ", newsPostTime='" + newsPostTime + '\'' +
                ", newsOtherSources='" + newsOtherSources + '\'' +
                '}';
    }
}
