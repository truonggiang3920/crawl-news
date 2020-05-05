package news.core.spyder.bao24h;

import news.core.spyder.NewsModel;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.management.modelmbean.ModelMBean;
import java.util.ArrayList;
import java.util.List;

public class Bao24hParser  {
    private static NewsDB newsDB =new NewsDB();
    private static  Bao24hParser bao24hParser = new Bao24hParser();


    public static List <String> parserListLink(String url) {

        Document html = getHtmlContent(url);
        Elements elements = html.select("span.nwsTit.postname");

        List <String> linkArray = new ArrayList<>();

        for(int i=0; i < elements.size(); i ++){
            Element element = elements.get(i);
            String linkNews = element.selectFirst("a").attr("href");
            linkArray.add("https://www.24h.com.vn/" + linkNews);
        }
        return linkArray;
    }

    private static Document getHtmlContent(String url){
        Document pageHtml;
        try {
            Connection.Response response = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("http://www.google.com")
                    .followRedirects(true)
                    .timeout(30000)
                    .execute();
            pageHtml = response.parse(); 
            return pageHtml;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public NewsModel getContent(String url){
        NewsModel model = new NewsModel();
        Document html = getHtmlContent(url);
        String newsAvatar = null;
        try{
           newsAvatar  = html.selectFirst("img.news-image").attr("src");
        } catch (Exception e){
            System.out.println("Lỗi lấy avatar");
        }
        String newsName = html.selectFirst("h1#article_title").ownText();
        String newsContent = html.selectFirst("article.nwsHt.nwsUpgrade#article_body").text();
        String newsPostTime = html.selectFirst("div.updTm.updTmD.mrT5").ownText();
        String resource = html.selectFirst("span.dots#url_origin_cut").ownText();

        model.setNewsAvatar(newsAvatar);
        model.setNewsName(newsName);
        model.setNewsLink(url);
        model.setNewContent(newsContent);
        model.setNewsPostTime(newsPostTime);
        model.setResource(resource);
        return model;
    }
    public void getAllNews(){
        Bao24hParser bao24hParser = new Bao24hParser();
        String url = "https://www.24h.com.vn/bong-da-c48.html";
        List<String> listLink = bao24hParser.parserListLink(url);
        for(String link : listLink)
        {
            NewsModel model = bao24hParser.getContent(link);
            System.out.println(model.toString());
        }
    }
}
