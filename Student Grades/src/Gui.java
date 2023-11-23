import javax.swing.*;
import BreezySwing.*;
import java.text.DecimalFormat;
public class Gui extends GBFrame {
	
	DecimalFormat dc = new DecimalFormat("0");
	int nameCounter = 0;
	int testCounter = 0;
	int quizCounter = 0;
	String name = "";
	
	double [] testArray = new double [5];
	double [] quizArray = new double [8];
	double hwAverage = -1;
	
	StudentInfo [] array = new StudentInfo [15];
	StudentInfo grades;
	
	
	JLabel nameCounterLabel = addLabel ("Name " + (nameCounter+1) + "/15:", 1, 1, 1, 1); //displays number of inputs
	JTextField nameInput = addTextField ("", 1, 2, 1, 1);
	JButton enterPerson = addButton("Enter", 1, 3, 1, 1);
	
	JLabel testCounterLabel = addLabel ("Test " + (nameCounter+1) + "/5:", 2, 1, 1, 1); //displays number of inputs
	JTextField testInput = addTextField ("", 2, 2, 1, 1);
	JButton enterTest = addButton("Enter", 2, 3, 1, 1);
	
	JLabel quizCounterLabel = addLabel ("Quiz " + (nameCounter+1) + "/8:", 3, 1, 1, 1); //displays number of inputs
	JTextField quizInput = addTextField ("", 3, 2, 1, 1);
	JButton enterQuiz = addButton("Enter", 3, 3, 1, 1);
	
	JLabel hwInputLabel = addLabel ("HW: ", 4, 1, 1, 1); //displays number of inputs
	JTextField hwInput = addTextField ("", 4, 2, 1, 1);
	JButton enterHW = addButton("Enter", 4, 3, 1, 1);
	
	JButton next = addButton("Enter Person", 5, 3, 1, 1);
	
	JButton outputFinal = addButton("Output by Final Average", 5, 1, 1, 1);
	JButton outputAlphabet = addButton("Output by Alphabetical Order", 5, 2, 1, 1);
	
	
	public void buttonClicked(JButton buttonObj) {
		
		if (buttonObj == enterPerson) {
			if (nameInput.getText().isBlank()) {
				messageBox("Please input a name");
			}
			else {
				hwAverage = -1;
				for (int i = 0; i < testArray.length; i++) {
					testArray[i] = -1;
				}
				for (int j = 0; j < quizArray.length; j++) {
					quizArray[j] = -1;
				}
				name = nameInput.getText();
				nameCounterLabel.setText("Inputting array For: " + name);
				nameInput.setText("");
				nameInput.setVisible(false);
				enterPerson.setVisible(false);
			}
		}
		
		if (buttonObj == enterTest) {
			try {
				if (!name.isBlank()) {
					testArray[testCounter] = Double.parseDouble(testInput.getText());
					testInput.setText("");
					testCounter++;
					if (testCounter < 5) {
						testCounterLabel.setText("Test " + (testCounter+1) + "/5:");
						testInput.grabFocus();
					}
					else {
						testCounterLabel.setText("No more tests can be inputted");
						testInput.setText("");
						testInput.setVisible(false);
						enterTest.setVisible(false);
					}
				}
				else {
					messageBox("Please enter a name first");
				}
			}
			catch (Exception e) {
				messageBox("Invalid input");
			}
		}
		
		
		if (buttonObj == enterQuiz) {
			try {
				if (!name.isBlank()) {
					quizArray[quizCounter] = Double.parseDouble(quizInput.getText());
					quizInput.setText("");
					quizCounter++;
					if (quizCounter < 8) {
						quizCounterLabel.setText("Quiz " + (quizCounter+1) + "/8:");
						quizInput.grabFocus();
					}
					else {
						quizCounterLabel.setText("No more quizzes can be inputted");
						quizInput.setText("");
						quizInput.setVisible(false);
						enterQuiz.setVisible(false);
					}
				}
				else {
					messageBox("Please enter a name first");
				}
			}
			catch (Exception e) {
				messageBox("Invalid input");
			}
		}
		
		
		if (buttonObj == enterHW) {
			try {
				if (!name.isBlank()) {
					hwAverage = Double.parseDouble(hwInput.getText());
					hwInputLabel.setText("Homework average has been inputted");
					hwInput.setText("");
					hwInput.setVisible(false);
					enterHW.setVisible(false);
				}
				else {
					messageBox("Please enter a name first");
				}
			}
			catch (Exception e) {
				messageBox("Invalid input");
			}
		}
		
		
		if (buttonObj == next) {
			if (name == "" ||  testArray[0] == -1 || quizArray[0] == -1 || hwAverage == -1) {
				messageBox("Please make sure all of the required fields are filled", 400, 150);
			}
			else if (!name.isBlank()) {
				grades = new StudentInfo(name, testArray, quizArray, hwAverage, testCounter, quizCounter);
				array[nameCounter] = grades;
				nameCounter++;
				testCounter = 0;
				quizCounter = 0;
				nameInput.setVisible(true);
				enterPerson.setVisible(true);
				testInput.setVisible(true);
				enterTest.setVisible(true);
				quizInput.setVisible(true);
				enterQuiz.setVisible(true);
				hwInput.setVisible(true);
				enterHW.setVisible(true);
				nameCounterLabel.setText("Name " + (nameCounter+1) + "/15:");
				testCounterLabel.setText("Test " + (testCounter+1) + "/5:");
				quizCounterLabel.setText("Quiz " + (quizCounter+1) + "/8:");
				hwInputLabel.setText("HW: ");
			}
			else {
				messageBox("Please enter a name first");
			}
			if (nameCounter == 15){
				nameCounterLabel.setText("No more students can be inputted");
				nameInput.setVisible(false);
				enterPerson.setVisible(false);
				testInput.setVisible(false);
				enterTest.setVisible(false);
				quizInput.setVisible(false);
				enterQuiz.setVisible(false);
				hwInput.setVisible(false);
				enterHW.setVisible(false);
				testCounterLabel.setVisible(false);
				quizCounterLabel.setVisible(false);
				hwInputLabel.setVisible(false);
				next.setVisible(false);
			}
		}
		
		
		if (buttonObj == outputFinal) {
			try {
				AllStudents [] students = new AllStudents [15];
				String messageBoxOutput = "";
				for (int i = 0; i < nameCounter; i++) {
					students[i] = new AllStudents(array[i].getName(), array[i].getFinalAverage());
				}
				students = students[0].sortByFinal(students, nameCounter);
				for (int i = 0; i < nameCounter; i++) {
					messageBoxOutput += "Name: " + students[i].getName() + "   Final Average: " + dc.format(students[i].getFinalAverage()) + '\n';
				}
				messageBox(messageBoxOutput, 250, 300);
			}
			catch (Exception e) {
				messageBox("Please input student information");
			}
		}
		
		
		if (buttonObj == outputAlphabet) {
			try {
				AllStudents [] students = new AllStudents [15];
				String messageBoxOutput = "";
				for (int i = 0; i < nameCounter; i++) {
					students[i] = new AllStudents(array[i].getName(), array[i].getFinalAverage());
				}
				students = students[0].sortByAlphabet(students, nameCounter);
				for (int i = 0; i < nameCounter; i++) {
					messageBoxOutput += "Name: " + students[i].getName() + "   Final Average: " + dc.format(students[i].getFinalAverage()) + '\n';
				}
				messageBox(messageBoxOutput, 250, 300);
			}
			catch (Exception e) {
				messageBox("Please input student information");
			}
		}
		
	}
	
	
	//outputs GUI
	public static void main(String[] args) {
		JFrame frm = new Gui();
		frm.setTitle("Student Grades");
		frm.setSize(600, 400);
		frm.setVisible(true);
	}
}