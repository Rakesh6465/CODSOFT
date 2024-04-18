package gread;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GradeCalculatorServlet")
public class GradeCalculatorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int totalMarks = 0;
        int numSubjects = 0;
        double averagePercentage = 0.0;
        String grade;

        // Get marks obtained in each subject
        String[] marksStr = request.getParameterValues("marks");
        if (marksStr != null) {
            for (String mark : marksStr) {            	
                totalMarks += Integer.parseInt(mark);
                numSubjects++;
            }
            
            	for (String mark : marksStr) {
                	if(Integer.parseInt(mark) >= 30) {
                		continue;
                	}
            	else {
            		request.setAttribute("totalMarks", totalMarks);
                    request.setAttribute("averagePercentage", (double) totalMarks / numSubjects);
                    request.setAttribute("grade", "FAIL!");

                    // Forward to result page
                    request.getRequestDispatcher("result.jsp").forward(request, response);
            	}
            }
            // Calculate average percentage
            averagePercentage = (double) totalMarks / numSubjects;

            // Calculate grade
            if (averagePercentage >= 90) {
                grade = "A1";
            } else if (averagePercentage >= 80) {
                grade = "A2";
            } else if (averagePercentage >= 70) {
                grade = "B1";
            } else if (averagePercentage >= 60) {
                grade = "B2";
            } else if (averagePercentage >= 50) {
                grade = "C";
            } else if (averagePercentage >= 40) {
                grade = "D";
            } else if (averagePercentage >= 33) {
                grade = "E";
            } else {
                grade = "FAIL!";
            }
        } else {
            // Handle error if no marks provided
            grade = "NO MARK PROVIDED";
        }

        // Set attributes to be displayed in the result page
        request.setAttribute("totalMarks", totalMarks);
        request.setAttribute("averagePercentage", averagePercentage);
        request.setAttribute("grade", grade);

        // Forward to result page
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
