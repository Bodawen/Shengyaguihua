package Logic;

import DB_handle.DB_select_handle;
import Logic.Algorithm.Algorithm;
import Logic.Algorithm.Frist;
import Logic.Algorithm.Score_info;
import Mode.Score;
import Mode.Uni;
import View.JFrame_root;
import View.JPanel_info;
import View.JPanel_content;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class main_logic {
    JFrame_root root;
    JPanel_info info;
    JPanel_content content;
    Algorithm algorithm;
    Map<String,Object> info_packet;
    private static class SingletonHolder{
        private static main_logic instance = new main_logic();
    }

    public static main_logic getInstance(){
        return main_logic.SingletonHolder.instance;
    }

    public void search_uni(String algu){

        switch (algu){
            case "第一算法":
                algorithm = new Frist(info_packet);
                break;
        }
        List<Uni> list;
        list= algorithm.uni_result();
        System.out.println(list);
        content.show_data(list);
    }
    public List<Score> show_score(){
        algorithm = new Score_info(info_packet);
        return algorithm.score_result();
    }

    public Map<String, Object> getInfo_packet() {
        return info_packet;
    }

    public void setInfo_packet(Map<String, Object> info_packet) {
        this.info_packet = info_packet;
    }

    public JFrame_root getRoot() {
        return root;
    }

    public void setRoot(JFrame_root root) {
        this.root = root;
    }

    public JPanel_info getInfo() {
        return info;
    }

    public void setInfo(JPanel_info info) {
        this.info = info;
    }

    public JPanel_content getContent() {
        return content;
    }

    public void setContent(JPanel_content content) {
        this.content = content;
    }
}
