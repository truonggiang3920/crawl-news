package news.core.spyder.bao24h;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bao24hModel {
    public void writeNewsToFile(Bao24hModel bao) throws IOException {

        String newsStr = bao.toString();
        FileWriter writer = null;
        PrintWriter buffer = null;
        try {
            writer = new FileWriter("", true);
            buffer = new PrintWriter(writer);
            buffer.println(newsStr);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            buffer.close();
            writer.close();
        }
    }

}
