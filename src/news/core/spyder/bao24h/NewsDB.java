package news.core.spyder.bao24h;

import news.core.spyder.NewsModel;

import java.sql.*;

public class NewsDB {
    public static void writeToDB(NewsModel model) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found !!");
            return;
        }
        Connection connection = null;
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/java_core" +
                            "?characterEncoding=UTF-8&autoReconnect=true&connectTimeout=30000&socketTimeout=30000&serverTimezone=UTC\n", "root", "truonggiang3920");
            Statement selectStmt = connection.createStatement();
            ResultSet rs = selectStmt.executeQuery("select *from `java_core`.`crawl_news` where `newsLink`='" + model.getNewsLink() + "'");
            String tmp = null;
            while (rs.next()) {
                tmp = rs.getString(11);
            }
            if (tmp == null) {
                String sql = "insert into `java_core`.`crawl_news` (`newsName`,`newsAvatar`,`newsContent`,`newsPostTime`,`resource`) " +
                        "values ('" + model.getNewsName() + "','" + model.getNewsAvatar() + "','" + model.getNewContent() + "'" +
                        ",'" + model.getNewsPostTime() + ",'" + model.getResource();
                selectStmt.execute(sql);
                System.out.println("inserting");
            } else {
                selectStmt.execute("update `java_core`.`crawl_news` set `newsName`='" + model.getNewsName() + "','" + model.getNewsAvatar() + "','" + model.getNewContent() + "'" +
                        ",'" + model.getNewsPostTime() + ",'" + model.getResource());
                System.out.println("updating");
            }

        } catch (SQLException e) {
            System.out.println(e);
            return;
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}