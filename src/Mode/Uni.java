package Mode;

import java.util.ArrayList;
import java.util.List;

public class Uni {

    long id;
    int number;
    int low_position;
    int max_score;
    int min_score;
    String name;
    String uniId;
    int high_position;
    String province;
    List<String> label = new ArrayList<>();

    public Uni() {
        label.add("id");
        label.add("院校代码");
        label.add("院校名称");
        label.add("地区");
        label.add("最高分");
        label.add("最低分");
        label.add("高位次");
        label.add("低位次");
        label.add("计划数");

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getMin_score() {
        return min_score;
    }

    public void setMin_score(int min_score) {
        this.min_score = min_score;
    }

    public String getName() {
        return name;
    }

    public int getLow_position() {
        return low_position;
    }

    public void setLow_position(int low_position) {
        this.low_position = low_position;
    }

    public int getMax_score() {
        return max_score;
    }

    public void setMax_score(int max_score) {
        this.max_score = max_score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniId() {
        return uniId;
    }

    public void setUniId(String uniId) {
        this.uniId = uniId;
    }

    public int getHigh_position() {
        return high_position;
    }

    public void setHigh_position(int high_position) {
        this.high_position = high_position;
    }

    public List<String> getLabel() {
        return label;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
