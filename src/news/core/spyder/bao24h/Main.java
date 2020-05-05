package news.core.spyder.bao24h;

import news.core.spyder.NewsModel;
import news.core.spyder.bao24h.Bao24hParser;
public class Main {
    public static void main(String[] args) {
        Bao24hParser bao24hParser = new Bao24hParser();
        bao24hParser.getAllNews();
    }
}
