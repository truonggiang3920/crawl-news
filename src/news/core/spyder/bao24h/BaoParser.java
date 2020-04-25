package news.core.spyder.bao24h;

import news.core.spyder.NewsModel;

import java.util.List;

public abstract class BaoParser <T>{
    public abstract T parserDetail(String url);
    public abstract List<String> parserListLink(String url);
}
