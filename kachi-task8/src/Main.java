import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        ArrayList<String> csv;
//        var files = parseCmdArgs(args);
//        var inputFile = files[0];
//        var outputFile = files[1];
        Reader reader = new Reader("./input.txt");
        Writer writer = new Writer("output.txt");
        DateProcessor dateProcessor = new DateProcessor();

        var csv = reader.GetInput();

        var input = csv.get(0).split(",");
        var month = Integer.parseInt(input[0]);
        var year = Integer.parseInt(input[1]);


        ArrayList<ArrayList<String>> calender = dateProcessor.GetCalendar(month, year);
        writer.WriteOutput(calender);
    }

    public static String[] parseCmdArgs(String[] args) {
        return args;
    }
}