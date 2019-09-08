package DB_handle.run;

import DB_handle.DB_basic_handle;
import DB_handle.DB_build_handle;
import DB_handle.DB_select_handle;
import Mode.Uni;

import java.io.*;
import java.util.*;

public class load_DB {
    public static void main(String arg[]){
        load_DB ld= new load_DB();
        ld.createDB();
        ld.createunitables("D:\\workspace\\java_projects\\Shengyaguihua\\src\\resource\\csv\\uni_info");
        ld.load_uni_info("D:\\workspace\\java_projects\\Shengyaguihua\\src\\resource\\csv\\uni_info");
        ld.createscoretables("D:\\workspace\\java_projects\\Shengyaguihua\\src\\resource\\csv\\score");
        ld.load_score_info("D:\\workspace\\java_projects\\Shengyaguihua\\src\\resource\\csv\\score");
    }
    String name = "Career_Planning";
    public void createDB(){
        DB_basic_handle DBbasichandle = DB_basic_handle.getInstance();
        DBbasichandle.connDB();
        DBbasichandle.createDB(name);
        DBbasichandle.closeDB();
    }
    public void createscoretables(String path){
        File[] files = new File(path).listFiles();
        DB_basic_handle DBbasichandle = DB_basic_handle.getInstance();
        DBbasichandle.connDB();
        DBbasichandle.usedatabase(name);
        for (File f :
                files) {
            String name = f.getName();
            if (name.equals(".DS_Store")){
                continue;
            }
            name = name.substring(0,name.lastIndexOf("."));

            Map<String, String> map = new HashMap<>();
            map.put("score", "INT");
            map.put("number", "INT");
            map.put("count_number", "INT");
            DBbasichandle.createTable(name, map);
        }
        DBbasichandle.closeDB();
    }
    public void load_score_info(String path){
        File[] files = new File(path).listFiles();
        DB_basic_handle DBbasichandle = DB_basic_handle.getInstance();
        DBbasichandle.connDB();
        DBbasichandle.usedatabase(name);
        String[] elements = {"score&INT","number&INT","count_number&INT"};
        for (File f :
                files) {
            String name = f.getName();
            if (name.equals(".DS_Store")){
                continue;
            }
            name = name.substring(0,name.lastIndexOf("."));
            f.setReadable(true);//设置可读
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String line = "";
            ArrayList<String> allString = new ArrayList<>();
            try {
                while ((line = br.readLine()) != null) // 读取到的内容给line变量
                {
                    //remove null character
                    char s =line.trim().charAt(0);
                    if(s==65279){
                        if(line.length()>1){
                            line=line.substring(1);
                        }
                    }
                    allString.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            DBbasichandle.insert(name,elements,allString);
        }
        DBbasichandle.closeDB();
    }

    public void createunitables(String path){
        File[] files = new File(path).listFiles();
        DB_basic_handle DBbasichandle = DB_basic_handle.getInstance();
        DBbasichandle.connDB();
        DBbasichandle.usedatabase(name);
        for (File f :
                files) {
            String name = f.getName();
            if (name.equals(".DS_Store")){
                continue;
            }
            name = name.substring(0,name.lastIndexOf("."));

            Map<String, String> map = new HashMap<>();
            map.put("uniId", "VARCHAR");
            map.put("name", "VARCHAR");
            map.put("province", "VARCHAR");
            map.put("max_score", "INT");
            map.put("min_score", "INT");
            map.put("high_position", "INT");
            map.put("low_position", "INT");
            map.put("number", "INT");
            DBbasichandle.createTable(name, map);
        }
        DBbasichandle.closeDB();
    }
    public void load_uni_info(String path){
        File[] files = new File(path).listFiles();
        DB_basic_handle DBbasichandle = DB_basic_handle.getInstance();
        DBbasichandle.connDB();
        DBbasichandle.usedatabase(name);
        String[] elements = {"uniId&VARCHAR","name&VARCHAR","province&VARCHAR","max_score&INT","min_score&INT","high_position&INT","low_position&INT","number&INT"};
        for (File f :
                files) {
            String name = f.getName();
            if (name.equals(".DS_Store")){
                continue;
            }
            name = name.substring(0,name.lastIndexOf("."));
            f.setReadable(true);//设置可读
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(f));
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
        }
        DBbasichandle.closeDB();
    }

}
