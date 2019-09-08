package Logic.Algorithm;

import DB_handle.DB_select_handle;
import Mode.Score;
import Mode.Uni;

import java.util.List;
import java.util.Map;

public abstract class Algorithm {
    static final String scoreLi2019 = "scoreLi_2019";
    static final String scoreLi2018 = "scoreLi_2018";
    static final String scoreWen2019 = "scoreWen_2019";
    static final String scoreWen2018 = "scoreWen_2018";
    static final String Li1A1_2018 = "Li1A1_2018";
    static final String Li1A_2018 = "Li1A_2018";
    static final String Li1B_2018 = "Li1B_2018";
    static final String Li2A_2018 = "Li2A_2018";
    static final String Li2B_2018 = "Li2B_2018";
    static final String Li2C_2018 = "Li2C_2018";
    static final String Wen1A1_2018 = "Wen1A1_2018";
    static final String Wen1A_2018 = "Wen1A_2018";
    static final String Wen1B_2018 = "Wen1B_2018";
    static final String Wen2A_2018 = "Wen2A_2018";
    static final String Wen2B_2018 = "Wen2B_2018";
    static final String Wen2C_2018 = "Wen2C_2018";


    String uni_old_tablename;
    String score_old_tablename;
    Score score;
    Map<String, Object> info;
    DB_select_handle db_select_handle = new DB_select_handle();

    public Algorithm( Map<String, Object> info){
        this.info = info;
        score = score_result().get(0);
        get_table_name();
    }
    public abstract List<Uni> uni_result();

    void get_table_name(){
        score_old_tablename ="";
        uni_old_tablename ="";
        if (info.get("文理").equals("文史")){
            uni_old_tablename += "Wen";
            score_old_tablename = scoreWen2018;
        }else {
            uni_old_tablename += "Li";
            score_old_tablename = scoreLi2018;
        }
        switch (String.valueOf(info.get("批次"))){
            case "A1":
                uni_old_tablename += "1A1_2018";
                break;
            case "1A":
                uni_old_tablename += "1A_2018";
                break;
            case "1B":
                uni_old_tablename += "1B_2018";
                break;
            case "2A":
                uni_old_tablename += "2A_2018";
                break;
            case "2B":
                uni_old_tablename += "2B_2018";
                break;
            case "2C":
                uni_old_tablename += "2C_2018";
                break;
        }
    }
    public List<Score> score_result() {
        String tablename="";
        switch ((String)info.get("文理")){
            case "文史":
                tablename = scoreWen2019;
                break;
            case "理工":
                tablename = scoreLi2019;
                break;
        }
        return  db_select_handle.search_score((int)info.get("分数"),tablename);
    }

    public String getUni_old_tablename() {
        return uni_old_tablename;
    }

    public void setUni_old_tablename(String uni_old_tablename) {
        this.uni_old_tablename = uni_old_tablename;
    }

    public String getScore_old_tablename() {
        return score_old_tablename;
    }

    public void setScore_old_tablename(String score_old_tablename) {
        this.score_old_tablename = score_old_tablename;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
