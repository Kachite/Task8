import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writer {
    private String path;

    public Writer(String path) {
        this.path = path;
    }

    public void WriteOutput(ArrayList<ArrayList<String>> output) {
        try {
            FileWriter fileWriter = new FileWriter(path, false); // TODO: set append to true before submitting
            for (var line : output) {
                fileWriter.write(line + "\n");
            }

            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
