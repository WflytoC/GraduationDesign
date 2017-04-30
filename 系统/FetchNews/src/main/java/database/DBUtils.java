package database;

import model.News;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by wcshi on 2017/4/30.
 */
public class DBUtils {
    private static Connection conn = null;
    private static Connection getConnection() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/graduation?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&failOverReadOnly=false&serverTimezone=UTC";
        String username = "root";
        String password = "weichuang";
        if (conn == null) {
            try {
                Class.forName(driver);
                conn =  DriverManager.getConnection(url,username,password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }


    public static void insert(Elements elements) {
        Connection conn = getConnection();
        String sql = "insert into t_news (news_href,news_title) values(?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            for (Element element: elements) {
                if (isContains(element.attr("href")))
                    continue;
                pstmt.setString(1,element.attr("href"));
                pstmt.setString(2,element.text());
                pstmt.executeUpdate();
            }
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean isContains(String href) {
        Connection conn = getConnection();
        boolean exisits = false;
        String sql = "select * from t_news where news_href = ?";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,href);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                exisits = true;
            }
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exisits;
    }

    public static ArrayList<News> getNews(int startIndex) {
        Connection conn = getConnection();
        String sql = "select * from t_news limit ? , ?";
        PreparedStatement pstmt;
        ArrayList<News> result = new ArrayList<>();
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            pstmt.setInt(1,startIndex * 100 + 1);
            pstmt.setInt(2,startIndex * 100 + 100);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                News news = new News();
                news.setHref(rs.getString("news_href"));
                news.setTitle(rs.getString("news_title"));
                result.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int getNewsCount() {
        Connection conn = getConnection();
        String sql = "select * from t_news";
        int count = 0;
        PreparedStatement pstmt;
        try {
            pstmt =  conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                count += 1;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
