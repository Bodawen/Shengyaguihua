package DB_handle;

import Mode.Score;
import Mode.Uni;

import java.util.*;

public class DB_select_handle{
    DB_basic_handle DBbasichandle;
    String db_name = "Career_Planning";

    public DB_select_handle(){
        this.DBbasichandle = DB_basic_handle.getInstance();
    }

    public List<Uni> select_allinfo_from_uni(String tablename,String label,String value){
        List<Uni> listuni = new LinkedList<>();
        DBbasichandle.connDB();
        DBbasichandle.usedatabase(db_name);

        List<Map> result = DBbasichandle.query("Select * from "+tablename+" where "+label+" = '"+value+"'");
//        System.out.println(result);
        setModeUni(listuni, result);
        DBbasichandle.closeDB();
        return listuni;
    }

    public List<Uni> select_allinfo_byscore_from_uni(String score,Object number,String tablename, Object province){
        List<Uni> listuni = new LinkedList<>();
        DBbasichandle.connDB();
        DBbasichandle.usedatabase(db_name);
        System.out.println(score);
        if (province.equals("全部")){
            province = "";
        }else {
            province = " and province = '"+province+"'";
        }
        List<Map> result2 = DBbasichandle.query("Select * from "+tablename+" where "+score+" > min_score" +
                province+" order by min_score desc limit "+number);
        List<Map> result  = DBbasichandle.query("Select * from "+tablename+" where "+score+" <= min_score" +
                province+" order by min_score asc limit "+number);
        System.out.println("Select * from "+tablename+" where "+score+" <= min_score" +
              province+" order by min_score asc limit "+number);
        Collections.reverse(result);
        result.addAll(result2);
        setModeUni(listuni, result);
        DBbasichandle.closeDB();
        return listuni;
    }

    public List<Uni> select_all_from_uni(String tablename){
        List<Uni> listuni = new LinkedList<>();
        DBbasichandle.connDB();
        DBbasichandle.usedatabase(db_name);
        List<Map> result = DBbasichandle.query("Select * from "+ tablename);
//        System.out.println(result);
        setModeUni(listuni, result);
        DBbasichandle.closeDB();
        return listuni;
    }

    public List<Score> search_score(int score,String tablename){
        List<Score> scores = new ArrayList<>();
        DBbasichandle.connDB();
        DBbasichandle.usedatabase(db_name);
        List<Map> result = DBbasichandle.query("Select * from "+ tablename+" where score = "+score);
        setModeScore(scores,result);
        DBbasichandle.closeDB();
        return scores;
    }

    public List<Score> search_oldscore_by_newscore(int count_number,String tablename){
        List<Score> scores = new ArrayList<>();
        DBbasichandle.connDB();
        DBbasichandle.usedatabase(db_name);
//        Select * , ABS(4832-count_number) as nt from scoreLi_2018 order by nt asc limit 1;
        List<Map> result = DBbasichandle.query("Select *, ABS("+count_number+"-count_number) as sd from "+ tablename+" order by " +
                "sd asc limit 1");
        setModeScore(scores,result);
        DBbasichandle.closeDB();
        return scores;
    }

    private void setModeUni(List<Uni> listuni, List<Map> result) {
        for (Map map : result
        ) {
            Iterator entries = map.entrySet().iterator();
            Uni uni = new Uni();
            while (entries.hasNext()) {
                Map.Entry entry = (Map.Entry) entries.next();
                switch ((String) entry.getKey()) {
                    case "number":
                        uni.setNumber((int) entry.getValue());
                        break;
                    case "min_score":
                        uni.setMin_score((int) entry.getValue());
                        break;
                    case "name":
                        uni.setName((String) entry.getValue());
                        break;
                    case "id":
                        uni.setId((long) entry.getValue());
                        break;
                    case "low_position":
                        uni.setLow_position((int) entry.getValue());
                        break;
                    case "province":
                        uni.setProvince((String) entry.getValue());
                        break;
                    case "uniid":
                        uni.setUniId((String)entry.getValue());
                        break;
                    case "high_position":
                        uni.setHigh_position((int) entry.getValue());
                        break;
                    case "max_score":
                        uni.setMax_score((int) entry.getValue());
                        break;
                }
            }
            listuni.add(uni);
        }
    }
    private void setModeScore(List<Score> listsocre, List<Map> result) {
        for (Map map : result
        ) {
            Iterator entries = map.entrySet().iterator();
            Score score = new Score();
            while (entries.hasNext()) {
                Map.Entry entry = (Map.Entry) entries.next();
                switch ((String) entry.getKey()) {
                    case "score":
                        score.setScore((int) entry.getValue());
                        break;
                    case "nubmer":
                        score.setNubmer((int) entry.getValue());
                        break;
                    case "count_number":
                        score.setCount_number((int) entry.getValue());
                        break;
                }
            }
            listsocre.add(score);
        }
    }
}
