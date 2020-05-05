package sql;

import news.core.spyder.NewsModel;
import news.core.spyder.bao24h.Bao24hParser;

import java.sql.*;

public class InsertDB {
    public static void main(String[] args) {
        Connection connection = null;
        Statement stmt = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/java_core" +
                            "?characterEncoding=UTF-8&autoReconnect=true&connectTimeout=30000&socketTimeout=30000&serverTimezone=UTC\n", "root", "truonggiang3920");

            stmt = connection.createStatement();
            stmt.execute("INSERT INTO crawl_news (newsName, newsAvatar, newsLink, newsContent, newsPostTime, resource) "
                    + "VALUES ()");
        }
        catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                stmt.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}