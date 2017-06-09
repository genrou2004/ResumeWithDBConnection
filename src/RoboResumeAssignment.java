

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class RoboResumeAssignment {

	public static void main(String[] args) {
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
		
		Scanner scan = new Scanner(System.in);
		Employee emp = new Employee();
		
		ConnectionManager cm=new ConnectionManager();
        PreparedStatement pst=null;
        
        String answer;
        
        System.out.println("please choose 1 to 4 options");
        System.out.println("1. Insert");
        System.out.println("2. Display");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        
        int choice = scan.nextInt();
        switch(choice){
        case 1:
        }
        
      
            do{
		System.out.println("Enter your First Name: ");
		firstName = scan.nextLine();
		emp.setFirstName(firstName);
		System.out.println("Enter your Last Name: ");
        lastName = scan.nextLine();
		emp.setLastName(lastName);
		System.out.println("Enter your email: ");
		emailAddress = scan.nextLine();
		while (!EmailValidation.validate(emailAddress)) // calls the email validation method
		{
			System.out.println("please Enter a valid Email!");
			emailAddress = scan.nextLine();
		}
		emp.setEmailAddress(emailAddress);
		

		//Insert query for Resume
        try {
            String query = "insert into Resume(firstName,lastName,emailAddress) values(?,?,?)";
            pst = cm.getConnection().prepareStatement(query);
                //pst.setString(1, emp.getid()); 
               pst.setString(1, emp.getFirstName()); 
               pst.setString(2, emp.getLastName());
               pst.setString(3, emp.getEmailAddress());
               pst.executeUpdate(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        //Insert query for Education
        
            System.out.println("Enter School Name");
            schoolName = scan.nextLine();
            emp.setSchoolName(schoolName);
            System.out.println("Enter Educational achivements MAX 10: use STOP to EXIT");
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
        
        
       //Insert query for Experiance
            
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
        
            //Insert Skillset query
            
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
	}while(answer.equalsIgnoreCase("yes"));
    if(answer.equalsIgnoreCase("no")){
        System.out.println("Thank you for using our database!");
    }
        
        
		
		/*System.out.println("=============================================================");
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(emailAddress);
		System.out.println();
		System.out.println("EDUCATION:");

		for (String edu : resume.listOfEducationalAchi) {
			if (!edu.equalsIgnoreCase("stop")) {
				System.out.println(edu);
			}
		}
		System.out.println();
		System.out.println("EXPERIANCE:");

		for (String exp : resume.listOfWorkExperiance) {
			if (!exp.equalsIgnoreCase("stop")) {
				System.out.println(exp);
			}
		}
		System.out.println();
		System.out.println("SKILL SETS:");
		for (String skill : job.listOfSkillSet) {
			if (!skill.equalsIgnoreCase("stop")) {
				System.out.println(skill);
			}
		}*/
		
		scan.close();
	}

}
