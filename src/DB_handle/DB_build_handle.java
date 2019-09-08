package DB_handle;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DB_build_handle {
    DB_basic_handle DBbasichandle;
    String dB_name = "Career_Planning";

    public DB_build_handle(DB_basic_handle DBbasichandle) {
        this.DBbasichandle = DBbasichandle;
    }

    public void createDB(){
        DBbasichandle.connDB();
        DBbasichandle.createDB("Career_Planning");
        DBbasichandle.closeDB();
    }
    public void create_uni_table(String name) {
        DBbasichandle.connDB();
        DBbasichandle.usedatabase(dB_name);
        Map<String, String> map = new HashMap<>();
        map.put("name", "VARCHAR");
        map.put("number", "INT");
        map.put("min_score", "INT");
        map.put("score_difference", "INT");
        map.put("province", "VARCHAR");
        map.put("type", "VARCHAR");
        DBbasichandle.createTable(name, map);


        DBbasichandle.closeDB();
    }

    public void insert_data(String name,String filepath){
        DBbasichandle.connDB();
        DBbasichandle.usedatabase(dB_name);
        String[] elements = {"name&VARCHAR","number&INT","min_score&INT","score_difference&INT"};
        //todo insert province and type data."province_VARCHAR","type_VARCHAR"...
        File csv = new File(filepath); // CSV文件路径
        csv.setReadable(true);//设置可读
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(csv));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = "";
        ArrayList<String> allString = new ArrayList<>();
        try {
            while ((line = br.readLine()) != null) // 读取到的内容给line变量
            {
                allString.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        DBbasichandle.insert(name,elements,allString);
//        DBbasichandle.createTable("Wen1A_2018", map);
//        DBbasichandle.createTable("Wen1A_2017", map);
//        DBbasichandle.createTable("Wen1A_2016", map);
//        DBbasichandle.createTable("WenA1_2018", map);
//        DBbasichandle.createTable("WenA1_2017", map);
//        DBbasichandle.createTable("WenA1_2016", map);
//        DBbasichandle.createTable("Wen1B_2018", map);
//        DBbasichandle.createTable("Wen1B_2017", map);
//        DBbasichandle.createTable("Wen1B_2016", map);
//        DBbasichandle.createTable("Wen2A_2018", map);
//        DBbasichandle.createTable("Wen2A_2017", map);
//        DBbasichandle.createTable("Wen2A_2016", map);
//        DBbasichandle.createTable("Wen2B_2018", map);
//        DBbasichandle.createTable("Wen2B_2017", map);
//        DBbasichandle.createTable("Wen2B_2016", map);
//        DBbasichandle.createTable("Wen2C_2018", map);
//        DBbasichandle.createTable("Wen2C_2017", map);
//        DBbasichandle.createTable("Wen2C_2016", map);
//
//        DBbasichandle.createTable("Li1A_2018", map);
//        DBbasichandle.createTable("Li1A_2017", map);
//        DBbasichandle.createTable("Li1A_2016", map);
//        DBbasichandle.createTable("LiA1_2018", map);
//        DBbasichandle.createTable("LiA1_2017", map);
//        DBbasichandle.createTable("LiA1_2016", map);
//        DBbasichandle.createTable("Li1B_2018", map);
//        DBbasichandle.createTable("Li1B_2017", map);
//        DBbasichandle.createTable("Li1B_2016", map);
//        DBbasichandle.createTable("Li2A_2018", map);
//        DBbasichandle.createTable("Li2A_2017", map);
//        DBbasichandle.createTable("Li2A_2016", map);
//        DBbasichandle.createTable("Li2B_2018", map);
//        DBbasichandle.createTable("Li2B_2017", map);
//        DBbasichandle.createTable("Li2B_2016", map);
//        DBbasichandle.createTable("Li2C_2018", map);
//        DBbasichandle.createTable("Li2C_2017", map);
//        DBbasichandle.createTable("Li2C_2016", map);
        DBbasichandle.closeDB();
    }
}
