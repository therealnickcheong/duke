import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;


public class Duke {
    private DataReadWrite SaveFile;
    private TaskList DukeTaskList;
    private Ui ui;

    public Duke() throws  IOException{
        ui = new Ui();
        SaveFile = new DataReadWrite();
        SaveFile.readFile();
        DukeTaskList = new TaskList(SaveFile.updateDukeTaskList());

    }

    public void run(){
        ui.printWelcome();
        boolean exitFlag = false;
        while(!exitFlag){
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            String userCmd = myObj.nextLine();  // Read user input
            Parser parseCmd = new Parser(SaveFile, DukeTaskList);
            parseCmd.parse(userCmd);
            exitFlag = parseCmd.getExitStatus();
        }
    }

    public static void main(String[] args) throws IOException, DukeException, DateTimeParseException{
        new Duke().run();

    }
}
