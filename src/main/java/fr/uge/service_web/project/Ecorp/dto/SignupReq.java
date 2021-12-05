package fr.uge.service_web.project.Ecorp.dto;

public class SignupReq {
	private String firstname;
	private String lastname;
	private String address;
	private String mail;
	private String passwd;
	
	public SignupReq( String firstname, String lastname, String address, String mail, String passwd) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.mail = mail;
		this.passwd = passwd;
	}


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
	

}
