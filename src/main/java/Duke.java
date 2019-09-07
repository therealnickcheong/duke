import java.time.LocalDateTime;

import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the Duke program
 * Takes in an input from the user and executes the command
 * result is shown as the output on the console
 *
 * @author Nicholas Cheong
 * @version Phase 1
 * @since 2019-09-07
 */

public class Duke {
    private DataReadWrite SaveFile;
    private TaskList DukeTaskList;
    private Ui ui;

    /**
     * This Constructor "Duke" instantiates the necessary data structures on startup
     * @throws IOException exception thrown when Duke cannot read saved Data in Duke.txt
     */

    public Duke() throws  IOException{
        ui = new Ui();
        SaveFile = new DataReadWrite();
        SaveFile.readFile();
        DukeTaskList = new TaskList(SaveFile.updateDukeTaskList());

    }

    /**
     * This method "run" is used to continuously scan for user input
     * user input is passed into "Parser" to process the input to execute the corresponding action
     */

    public void run(){
        ui.printWelcome();
        boolean exitFlag = false;
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        while(!exitFlag){
            if(myObj.hasNextLine()){
                String userCmd = myObj.nextLine(); // Read user input
                Parser parseCmd = new Parser(SaveFile, DukeTaskList);
                parseCmd.parse(userCmd);
                exitFlag = parseCmd.getExitStatus();
            }else{
                break;
            }
        }
    }

    /**
     *This is the main method to run the Duke program
     * @param args unused
     * @throws IOException exception thrown when Duke cannot read saved Data in Duke.txt
     * @throws DukeException exception thrown specific to Duke
     * @throws DateTimeParseException exception thrown when input date/time is not recognised
     */

    public static void main(String[] args) throws IOException, DukeException, DateTimeParseException{
        new Duke().run();

    }
}
