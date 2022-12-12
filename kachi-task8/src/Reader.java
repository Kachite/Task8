import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    private String path;

    public Reader(String path) {
        this.path = path;
    }

    public ArrayList<String> GetInput() {
        ArrayList<String> input = new ArrayList<>();
        try {
            File file = new File(path);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                input.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return input;
    }
}
