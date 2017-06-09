
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ResumeAssignment {
	Scanner scan = new Scanner(System.in);
	public void add(){
		// Variable declaration
		String firstName;
		String lastName;
		String emailAddress;
		String levelOfEducation;
		String work_exp;
		String schoolName;
		String yearOfExperiance;
		String lavelOfSkillSet;
		String skillSetName;
		String answer;
		
		
		Employee emp = new Employee();
		ConnectionManager cm = new ConnectionManager();
		PreparedStatement pst = null;

		do {
			System.out.println("Enter your First Name: ");
			firstName = scan.nextLine();
			emp.setFirstName(firstName);
			System.out.println("Enter your Last Name: ");
			lastName = scan.nextLine();
			emp.setLastName(lastName);
			System.out.println("Enter your email: ");
			emailAddress = scan.nextLine();
			while (!EmailValidation.validate(emailAddress)) // calls the email
															// validation method
			{
				System.out.println("please Enter a valid Email!");
				emailAddress = scan.nextLine();
			}
			emp.setEmailAddress(emailAddress);

			// Insert query for Resume
			try {
				String query = "insert into Resume(firstName,lastName,emailAddress) values(?,?,?)";
				pst = cm.getConnection().prepareStatement(query);
				pst.setString(1, emp.getFirstName());
				pst.setString(2, emp.getLastName());
				pst.setString(3, emp.getEmailAddress());
				pst.executeUpdate();
				 /*int i = pst.executeUpdate(query);
				 
		            if(i != 0)
		            {
		                System.out.println("Row is created");
		            }
		            else
		            {
		                System.out.println("Row is not created");
		            }*/
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

			// Insert query for Education

			System.out.println("Enter School Name");
			schoolName = scan.nextLine();
			emp.setSchoolName(schoolName);
			System.out.println("Enter Educational achivements ");
			levelOfEducation = scan.nextLine();
			emp.setLevelOfEducation(levelOfEducation);
			
			try {
				String query = "insert into Education(schoolName,LavelOfEducation) values(?,?)";
				pst = cm.getConnection().prepareStatement(query);
				pst.setString(1, emp.getSchoolName());
				pst.setString(2, emp.getLevelOfEducation());
				pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			// Insert query for Experiance

			System.out.println("Enter number of years of Experiance");
			yearOfExperiance = scan.nextLine();
			emp.setYearOfExperiance(yearOfExperiance);
			System.out.println("Enter your experiance title");
			work_exp = scan.nextLine();
			emp.setAreaOfExperty(work_exp);
			
			try {
				String query = "insert into Experiance(yearOfExperiance,LavelOfExperty) values(?,?)";
				pst = cm.getConnection().prepareStatement(query);

				pst.setString(1, emp.getYearOfExperiance());
				pst.setString(2, emp.getAreaOfExperty());
				pst.executeUpdate();
			} catch (SQLException ec) {
				ec.printStackTrace();
			}

			// Insert Skillset query

			System.out.println("Enter SkillSet Name");
			skillSetName = scan.nextLine();
			emp.setSkillSetName(skillSetName);
			System.out.println("Enter your Skill level");
			lavelOfSkillSet = scan.nextLine();
			emp.setLevelOfSkillSet(lavelOfSkillSet);
			
			try {
				String query = "insert into SkillSet(skillSetName,LavelOfSkillSet) values(?,?)";
				pst = cm.getConnection().prepareStatement(query);
				pst.setString(1, emp.getSkillSetName());
				pst.setString(2, emp.getLevelOfSkillSet());
				pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("Congrats! The Information stord successfully to the DataBase");
			System.out.println();
			System.out.println("Would you like to insert more data to the database (yes/no)");
			answer = scan.nextLine();
		} while (answer.equalsIgnoreCase("yes"));
		if (answer.equalsIgnoreCase("no")) {
			System.out.println("Thank you for using our database!");
		}
		
	}// end og add	
		
		public void display(){
		
		Connection con;
		Statement stmt;
		ResultSet rs;
		String query = "select * from Resume";
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/Employee?"+ "user=root&password=password");
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()){
				System.out.print(rs.getString("ResumeID") + "\t");
				System.out.print(rs.getString("FirstName") + "\t");
				System.out.print(rs.getString("LastName") + "\t" );
				System.out.print(rs.getString("EmailAddress"));
				System.out.println();
			}
			}catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		
		String query1 = "select * from Education";
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/Employee?"+ "user=root&password=password");
			stmt = con.createStatement();
			rs = stmt.executeQuery(query1);
			while(rs.next()){
				System.out.print(rs.getString("EducationID") + "\t");
				System.out.print(rs.getString("schoolName") + "\t");
				System.out.print(rs.getString("LavelOfEducation"));
				System.out.println();
			}
			}catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		
		String query2 = "select * from Experiance";
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/Employee?"+ "user=root&password=password");
			stmt = con.createStatement();
			rs = stmt.executeQuery(query2);
			while(rs.next()){
				System.out.print(rs.getString("ExperianceID") + "\t");
				System.out.print(rs.getString("yearOfExperiance") + "\t");
				System.out.print(rs.getString("LavelOfExperty"));
				System.out.println();
			}
			}catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
		}

		String query3 = "select * from SkillSet";
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/Employee?"+ "user=root&password=password");
			stmt = con.createStatement();
			rs = stmt.executeQuery(query3);
			while(rs.next()){
				System.out.print(rs.getString("SkillSetID") + "\t");
				System.out.print(rs.getString("SkillSetName") + "\t");
				System.out.print(rs.getString("LavelOfSkillSet"));
				System.out.println();
			}
			}catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		
		}	
		public void update(){
			
		}
		
		public void delete(){
			
		}
}
