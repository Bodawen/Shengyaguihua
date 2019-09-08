package test;

import DB_handle.DB_basic_handle;
import DB_handle.DB_build_handle;
import DB_handle.DB_select_handle;
import Mode.Uni;

import java.util.*;

public class test_DB {
    public static void main(String arg[]){
        DB_basic_handle DBbasichandle = DB_basic_handle.getInstance();
        DB_select_handle db_select_handle = new DB_select_handle();
        DB_build_handle db_build_handle = new DB_build_handle(DBbasichandle);
        db_build_handle.createDB();
        db_build_handle.create_uni_table("Wen1A_2018");
        db_build_handle.insert_data("Wen1A_2018","wenyiA_2018.csv");
//        List<Uni> list =db_select_handle.select_allinfo_from_uni("name","清华");
        List<Uni> list =db_select_handle.select_all_from_uni("Wen1A_2018");
//        List<Uni> list =db_select_handle.select_allinfo_byscore_from_uni("<","600");
        for (Uni uni:list
             ) {
            System.out.println(uni.getId()+" "+uni.getName()+" "+uni.getNumber()+" "+uni.getMin_score());
        }
//        DBbasichandle.connDB();

//        mainoperation(DBbasichandle);
//        DBbasichandle.usedatabase("shengjia");
//        query_test(DBbasichandle);

//        DBbasichandle.closeDB();
    }

    public static void query_test(DB_basic_handle DBbasichandle){
        System.out.println("queries: ");
        List<Map> list = DBbasichandle.query("select * from uni where min > 556;");
        System.out.println(list);
        for (Map map: list
             ) {
            Iterator entries = map.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry entry = (Map.Entry) entries.next();
                System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            }
        }
    }
}

