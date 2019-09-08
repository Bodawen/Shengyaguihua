package DB_handle;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DB_basic_handle {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost:3306/";
    static final String DB = "";
    static final String Character ="?useSSL=false&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "";


    static Connection conn = null;
    static Statement statement = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;


    private static class SingletonHolder{
        private static DB_basic_handle instance = new DB_basic_handle();
    }

    public static DB_basic_handle getInstance(){
        return SingletonHolder.instance;
    }


    public static void connDB() {
        try {
            Class.forName(JDBC_DRIVER).newInstance();
            conn = DriverManager.getConnection(URL+DB+Character, USER, PASS);
            if (!conn.isClosed()) {
                System.out.println("Succeeded connecting to MySQL!");
            }
            statement = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeDB() {
        if(rs != null ){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
                System.out.println("Database connection terminated!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void createDB(String name){
        try {
            statement.execute("CREATE DATABASE IF NOT EXISTS "+ name +" DEFAULT CHARSET utf8 COLLATE utf8_general_ci;");
            usedatabase(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void usedatabase(String name){
        try {
            statement.execute("use " + name );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(String name, Map<String, String> map) {
        try {
            String q = "CREATE TABLE IF NOT EXISTS " + name +" ( ";
            q += "id INT UNSIGNED AUTO_INCREMENT,";
            for (Map.Entry<String, String> entry : map.entrySet()) {
                switch (entry.getValue()){
                    case "INT":
                        q+= ""+entry.getKey()+" INT,";
                        break;
                    case "VARCHAR":
                        q+= ""+entry.getKey()+" VARCHAR(100),";
                        break;
                }
            }
            q += "PRIMARY KEY (id)";
            q += ")ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4";
//            System.out.println(q);
            statement.executeUpdate(q);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(String name,String[] elements, ArrayList<String> list) {
        try {
            String[] datastructure = new String[elements.length];
            String field = " ( ";
            String q = "INSERT INTO " + name;
            for (int i = 0; i < elements.length; i++) {
                String[] element = elements[i].split("&");
                field +="`"+ element[0]+"`";
                datastructure[i] = element[1];
                if (i==elements.length-1){
                    break;
                }
                field+=", ";
            }
            field +=") ";
            q += field;
            q +=" VALUES (";
            for (int i = 0; i < list.size(); i++) {
                String values = "";
                String[] words = list.get(i).split(",");
                for (int j = 0; j < words.length; j++) {
                    values += "'" + words[j] + "'";
//                    if (datastructure[j].equals("VARCHAR")){
//                        values += "'" + words[j] + "'";
//                    }else if (datastructure[j].equals(("INT"))){
//                        values +=  words[j];
//                    }
                    if (!(j==words.length-1)){
                        values+=", ";
                    }
                }
                System.out.println(q+values+")");
                statement.executeUpdate(q+values+")");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List query(String sql){
        List<Map> list= new ArrayList<Map>();
        int count;
        try {
            System.out.println(sql);
            rs = statement.executeQuery(sql);
            ResultSetMetaData rsmd;
            rsmd = rs.getMetaData();
            count = rsmd.getColumnCount();
            while(rs.next()){
                Map map = new HashMap();
                for(int i=1;i<=count;i++){
                    //获取指定列的表目录名称
                    String label=rsmd.getColumnLabel(i);
                    //以 Java 编程语言中 Object 的形式获取此 ResultSet 对象的当前行中指定列的值
                    Object object= rs.getObject(i);
                    map.put(label.toLowerCase(), object);
                }
                list.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void update(String sql){
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void delete(String sql){
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
