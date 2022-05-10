import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
* This program creates an array containing a student's information and
* displays it in a separate file.
*
* @author Layla Michel
* @version 1.0
* @since 2022-05-05
*/

public class Students {
    /**
    * First name property.
    */
    private String _firstName;

    /**
    * Middle name initial property.
    */
    private String _middleInit;

    /**
    * Last name property.
    */
    private String _lastName;

    /**
    * Student grade property.
    */
    private String _grade;

    /**
    * Student iep or not property.
    */
    private String _iep;

    /**
    * Array of strings property.
    */
    private final List<String> strList = new ArrayList<String>();

    /**
    * Constructor.
    *
    * @param firstName as String
    * @param middleInit as String
    * @param lastName as String
    * @param grade as String
    * @param iep as String
    */
    public Students(String firstName, String middleInit,
        String lastName, String grade, String iep) {
        _firstName = firstName;
        _middleInit = middleInit;
        _lastName = lastName;
        _grade = grade;
        _iep = iep;
    }

    /**
    * Prints out each student's information in output.txt in a proper format.
    *
    * @throws IOException if no file is passed in.
    */
    public void print() throws IOException {
        // Adding student's information to an array
        strList.add("First name: " + _firstName);
        strList.add("Middle initial: " + _middleInit);
        strList.add("Last name: " + _lastName);
        strList.add("Grade: " + _grade);
        strList.add("Student has an IEP? " + _iep);

        try {
            // Build a string containing the elements
            // of the array
            final StringBuilder builder = new StringBuilder();
            for (int counter = 0; counter < strList.size(); counter++) {
                builder.append(strList.get(counter));
                builder.append("\n");
            }

            // Create new file called "output.txt"
            final FileWriter fileWriter = new FileWriter("/home/runner/"
                + "Unit3-05-Java/output.txt", true);

            // Add the information to the output.txt file
            final BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.append(builder.toString());
            writer.append("\n");
            writer.close();
            System.out.println("Student added to 'output.txt'");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
