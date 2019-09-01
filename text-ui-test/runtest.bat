@ECHO OFF

REM create bin directory if it doesn't exist
if not exist ..\bin mkdir ..\bin

REM delete output from previous run
REM ACTUAL.TXT

REM compile the code into the bin folder
javac  -cp ..\src -Xlint:none -d ..\bin ..\src\main\java\Duke.java ..\src\main\java\DataReadWrite.java ..\src\main\java\Deadline.java ..\src\main\java\DukeException.java ..\src\main\java\Event.java ..\src\main\java\Parser.java ..\src\main\java\Task.java ..\src\main\java\TaskList.java ..\src\main\java\ToDo.java ..\src\main\java\Ui.java

IF ERRORLEVEL 1 (
    echo ********** BUILD FAILURE **********
    exit /b 1
)
REM no error here, errorlevel == 0

REM run the program, feed commands from input.txt file and redirect the output to the ACTUAL.TXT
java -classpath ..\bin Duke < input.txt > ACTUAL.TXT

REM compare the output to the expected output
FC ACTUAL.TXT EXPECTED.TXT
REM FC ACTUAL.TXT input.txt
REM FC input.txt EXPECTED.TXT

