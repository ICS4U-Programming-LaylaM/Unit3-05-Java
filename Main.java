import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* This program creates reads from a file containing information about
* different students, checks for the validity of the information and
* creates an object containing that information.
*
* @author Layla Michel
* @version 1.0
* @since 2022-05-05
*/

final class Main {
    /**
    * Array of students.
    */
    private static String[] studentsArray;

    /**
    * Counter.
    */
    private static int counter;

    /**
    * Grade as integer.
    */
    private static int gradeInt;

    /**
    * Default constructor.
    */
    private Main() { }

    /**
    * Creating main function.
    *
    * @param args nothing passed in
    * @throws IOException if no file is passed in
    */
    public static void main(String[] args)
            throws IOException {

        // Create list to get the strings
        final List<String> listOfStudents =
            new ArrayList<String>();

        BufferedReader bf = null;
        try {
            // Check if there are some arguments
            if (null != args[0]
                // Length > 4 because a.txt will be shortest filename
                && args[0].length() > 4
                // Check if arguments have the correct file extension
                && args[0].endsWith(".txt")) {
                bf = new BufferedReader(new FileReader(args[0]));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        String line = bf.readLine();

        // Add file elements to list
        while (line != null) {
            listOfStudents.add(line);
            line = bf.readLine();
        }

        // Create array of students of the size of the list
        studentsArray = listOfStudents.toArray(new String[0]);

        final String nullStr = "null";

        for (counter = 0; counter < studentsArray.length; counter++) {
            // Create a sublist containing each string separated by a
            // space of each element of the studentsArray
            final List<String> list = new ArrayList<String>(Arrays.asList(
                studentsArray[counter].split(" ")));

            for (int counter2 = 0; counter2 < list.size(); counter2++) {
                if (counter2 == 3) {
                    try {
                        // Check if the grade is an integer
                        gradeInt = Integer.parseInt(list.toArray(
                            new String[0])[counter2]);

                        // Check if the grade is a valid number
                        if (gradeInt < 9 || gradeInt > 12) {
                            // Set the grade value to null if the input is
                            // invalid
                            list.set(counter2, nullStr);
                        }
                    } catch (NumberFormatException e) {
                        // Set the grade value to null if the input is invalid
                        list.set(counter2, nullStr);
                    }
                } else if (counter2 == 4) {
                    // Check if the IEP is a boolean
                    if (!"true".equals(list.toArray(new String[0])
                        [counter2].toLowerCase())
                        && !"false".equals(list.toArray(new String[0])
                        [counter2].toLowerCase())) {
                        // Set the IEP value to null if the input is invalid
                        list.set(counter2, nullStr);
                    }
                }
            }

            // Create aStudent object containing the information of each string
            final Students aStudent = new Students(
                list.toArray(new String[0])[0],
                list.toArray(new String[0])[1],
                list.toArray(new String[0])[2],
                list.toArray(new String[0])[3],
                list.toArray(new String[0])[4]);

            // Call print method to display the information in a separate file
            aStudent.print();
        }
    }
}
