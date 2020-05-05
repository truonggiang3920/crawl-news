package news.core.spyder;

public class NewsModel {
    private String newsName;
    private String newsAvatar;
    private String newsLink;
    private String newContent;
    private  String newsPostTime;
    private String resource;
    public NewsModel(){};
    public NewsModel (String newsName, String newsAvatar, String newsLink,
                      String newContent, String newsPostTime, String resource)
    {
        this.newsName = newsName;
        this.newsAvatar = newsAvatar;
        this.newsLink = newsLink;
        this.newContent = newContent;
        this.newsPostTime = newsPostTime;
        this.resource = resource;
    }


    public String getNewsName() {
        return newsName;
    }

    public void setNewsName(String newsName) {
        this.newsName = newsName;
    }

    public String getNewsAvatar() {
        return newsAvatar;
    }

    public void setNewsAvatar(String newsAvatar) {
        this.newsAvatar = newsAvatar;
    }

    public String getNewsLink() {
        return newsLink;
    }

    public void setNewsLink(String newsLink) {
        this.newsLink = newsLink;
    }

    public String getNewContent() {
        return newContent;
    }

    public void setNewContent(String newContent) {
        this.newContent = newContent;
    }

    public String getNewsPostTime() {
        return newsPostTime;
    }

    public void setNewsPostTime(String newsPostTime) {
        this.newsPostTime = newsPostTime;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        return "NewsModel{" +
                "\n newsName='" + newsName + '\'' +
                " \n newsAvatar='" + newsAvatar + '\'' +
                " \n newsLink='" + newsLink + '\'' +
                " \n newContent='" + newContent + '\'' +
                " \n newsPostTime='" + newsPostTime + '\'' +
                " \n resource='" + resource + '\'' +
                '}';
    }
}
