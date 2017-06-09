

public class Employee {
    
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String schoolName;
    private String levelOfEducation;
    private String yearOfExperiance;
    private String areaOfExperty;
    private String skillSetName;
    private String levelOfSkillSet;
    
    public Employee(){
        
    }
    
    public Employee(String firstName, String lastName, String emailAddress, String schoolName, String levelOfEducation,
            String yearOfExperiance, String areaOfExperty, String skillSetName, String levelOfSkillSet) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.schoolName = schoolName;
        this.levelOfEducation = levelOfEducation;
        this.yearOfExperiance = yearOfExperiance;
        this.areaOfExperty = areaOfExperty;
        this.skillSetName = skillSetName;
        this.levelOfSkillSet = levelOfSkillSet;
    }
    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public String getSchoolName() {
        return schoolName;
    }
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
    public String getLevelOfEducation() {
        return levelOfEducation;
    }
    public void setLevelOfEducation(String levelOfEducation) {
        this.levelOfEducation = levelOfEducation;
    }
    public String getYearOfExperiance() {
        return yearOfExperiance;
    }
    public void setYearOfExperiance(String yearOfExperiance) {
        this.yearOfExperiance = yearOfExperiance;
    }
    public String getAreaOfExperty() {
        return areaOfExperty;
    }
    public void setAreaOfExperty(String areaOfExperty) {
        this.areaOfExperty = areaOfExperty;
    }
    public String getSkillSetName() {
        return skillSetName;
    }
    public void setSkillSetName(String skillSetName) {
        this.skillSetName = skillSetName;
    }
    public String getLevelOfSkillSet() {
        return levelOfSkillSet;
    }
    public void setLevelOfSkillSet(String levelOfSkillSet) {
        this.levelOfSkillSet = levelOfSkillSet;
    }
    

}
