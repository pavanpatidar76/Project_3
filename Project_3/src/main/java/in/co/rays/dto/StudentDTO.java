package in.co.rays.dto;

import java.util.Date;


/**
 * Student DTO classes
 * @author PAWAN PATIDAR
 *
 */
public class StudentDTO extends BaseDTO {

     /**
     * First Name of Student
     */
    private String firstName;
    /**
     * Last Name of Student
     */
    private String lastName;
   

	/**
     * Date of Birth of Student
     */
    private Date dob;
    /**
     * Mobileno of Student
     */
    private String mobileNo;
    /**
     * Email of Student
     */
    private String email;
    /**
     * CourseId of Student
     */
    private long courseId;
    /**
     * Course name of Student
     */
    private String courseName;
    
    /**
     * CollegeId of Student
     */
    private long collegeId;
    /**
     * College name of Student
     */
    private String collegeName;



    /**
     * accessor
     */
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
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public String getMobileNo() {
        return mobileNo;
    }
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Long getCollegeId() {
        return collegeId;
    }
    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }
    
    public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

   
    public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	
	public String getKey() {
        return id + "";
    }

   
    public String getValue() {
        return firstName + " " + lastName;
    }

}