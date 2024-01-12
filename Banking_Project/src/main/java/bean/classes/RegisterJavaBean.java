package bean.classes;

public class RegisterJavaBean {
	private String gender;
	private String first_name;
	private String last_name;
	private String dob_month;
	private String dob_day;
	private String dob_year;
	private String gardian_name;
	private String g_phno;
	private String email;
	private String address;
	private String city;
	private String state;
	private String country;
	private String account_no;
	private String pin;
	
	
	
	public RegisterJavaBean(String gender, String first_name, String last_name, String dob_month, String dob_day,
			String dob_year, String gardian_name, String g_phno, String email, String address, String city,
			String state, String country, String account_no, String pin) {
		super();
		this.gender = gender;
		this.first_name = first_name;
		this.last_name = last_name;
		this.dob_month = dob_month;
		this.dob_day = dob_day;
		this.dob_year = dob_year;
		this.gardian_name = gardian_name;
		this.g_phno = g_phno;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.account_no = account_no;
		this.pin = pin;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getDob_month() {
		return dob_month;
	}
	public void setDob_month(String dob_month) {
		this.dob_month = dob_month;
	}
	public String getDob_day() {
		return dob_day;
	}
	public void setDob_day(String dob_day) {
		this.dob_day = dob_day;
	}
	public String getDob_year() {
		return dob_year;
	}
	public void setDob_year(String dob_year) {
		this.dob_year = dob_year;
	}
	public String getGardian_name() {
		return gardian_name;
	}
	public void setGardian_name(String gardian_name) {
		this.gardian_name = gardian_name;
	}
	public String getG_phno() {
		return g_phno;
	}
	public void setG_phno(String g_phno) {
		this.g_phno = g_phno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAccount_no() {
		return account_no;
	}
	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	

}

