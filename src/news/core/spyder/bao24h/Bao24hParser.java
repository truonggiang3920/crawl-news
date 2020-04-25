package news.core.spyder.bao24h;

import news.core.spyder.NewsModel;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class Bao24hParser extends Bao24hModel {


    public Bao24hModel parserDetail(String url) {
        Document html = getHtmlContent(url);

        Bao24hModel result = new Bao24hModel();

        String avatar = html.selectFirst("center").selectFirst("img").attr("src");
        String name = html.selectFirst("article_title").ownText();
        String  = "";
        String director = "";
        String country = "";
        String publicYear = "";
        String publicDate = "";
        String voteCount = "";


        Element pros = html.selectFirst("dl.movie-dl");

        Elements child = pros.children();
        for(int i=0; i<child.size(); i ++){
            if(child.get(i).ownText().equals("Điểm IMDb:")){
                imdb = child.get(i+1).ownText();
            }
            if(child.get(i).ownText().equals("Số người đánh giá:")){
                voteCount = child.get(i+1).text();
            }
            if(child.get(i).ownText().equals("Đạo diễn:")){
                director = child.get(i+1).text();
            }
            if(child.get(i).ownText().equals("Quốc gia:")){
                country = child.get(i+1).text();
            }
            if(child.get(i).ownText().equals("Năm:")){
                publicYear = child.get(i+1).text();
            }
            if(child.get(i).ownText().equals("Ngày ra rạp:")){
                publicDate = child.get(i+1).text();
            }
        }

        result.se(name);
        result.setAvatar(avatar);
        result.setImdScore(imdb);
        result.setVoteCount(voteCount);
        result.setDirectors(director);
        result.setCountry(country);
        result.setPublicDate(publicDate);
        result.setPublicYear(publicYear);
        return result;
    }

    public List<String> parserListLink(String url) {

        Document html = getHtmlContent(url);
        Elements elements = html.select("bxDoiSbIt");

        List<String> linkArray = new ArrayList<>();

        for(int i=0; i < elements.size(); i ++){
            Element element = elements.get(i);
            String linkNews = element.selectFirst("a").attr("href");
            linkArray.add("https://www.24h.com.vn/" + linkNews);
        }
        return linkArray;
    }

    private Document getHtmlContent(String url){
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
}
