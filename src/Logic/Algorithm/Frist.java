package Logic.Algorithm;

import Mode.Score;
import Mode.Uni;

import java.util.List;
import java.util.Map;

public class Frist extends Algorithm {
    public Frist(Map<String, Object> info) {
        super(info);
    }

    @Override
    public List<Uni> uni_result() {
        String t = "";
        Score old_score = db_select_handle.search_oldscore_by_newscore(score.getCount_number(),score_old_tablename).get(0);
        List<Uni> list = db_select_handle.select_allinfo_byscore_from_uni(old_score.getScore()+"",info.get("查询学校数"),
                uni_old_tablename,info.get("地区"));
        return list;
    }

}
