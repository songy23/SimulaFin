package simula.model;

import java.util.Date;

public class User {
	
	protected String User_Name;
	protected Date DoB;
	protected String Password;
	protected String Gender;
	protected String Address;
	protected String Email;
	protected String Profession;
	protected String Education_Level;
	
	public User(){};
	
	public User(String user_Name, Date dob, String password,
			String gender, String address, String email, 
			String professionalism, String education_level)
			{
				this.User_Name = user_Name;
				this.DoB = dob;
				this.Password = password;
				this.Gender = gender;
				this.Address = address;
				this.Email = email;
				this.Profession = professionalism;
				this.Education_Level = education_level;
			}

	public User(String user_Name)
			{
				this.User_Name = user_Name;
			}

	public String getUser_Name() {
		return User_Name;
	}



	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}


	public Date getDoB() {
		return DoB;
	}


	public void setDoB(Date doB) {
		DoB = doB;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public String getGender() {
		return Gender;
	}


	public void setGender(String gender) {
		Gender = gender;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}



	public String getProfession() {
		return Profession;
	}



	public void setProfession(String profession) {
		Profession = profession;
	}



	public String getEducation_Level() {
		return Education_Level;
	}


	public void setEducation_Level(String education_Level) {
		Education_Level = education_Level;
	}
}
