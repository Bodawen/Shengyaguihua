package View.contents;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Province_comboBox extends JComboBox {

    public List<String> names;
    String path = "resource/city_names";

    public Province_comboBox(){
        File f = new File(path);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(f));
        String line = "";
        names = new ArrayList<>();
            while ((line = br.readLine()) != null)
            {
                names.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.addItem("全部");
        for (String name :
                names) {
            this.addItem(name);
        }
        
    }
}
