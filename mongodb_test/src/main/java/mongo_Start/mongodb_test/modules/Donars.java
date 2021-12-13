package mongo_Start.mongodb_test.modules;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Donars")
public class Donars {

	@Id
	private int id;

	private String donarName;

	private String donationType;

	private String designation;

	private String phoneNumber;

	private String email;

	private String locality;

	public Donars() {

		// TODO Auto-generated constructor stub
	}

	public Donars(int id, String donarName, String donationType, String designation, String phoneNumber, String email,
			String locality) {
		super();
		this.id = id;
		this.donarName = donarName;
		this.donationType = donationType;
		this.designation = designation;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.locality = locality;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDonarName() {
		return donarName;
	}

	public void setDonarName(String donarName) {
		this.donarName = donarName;
	}

	public String getDonationType() {
		return donationType;
	}

	public void setDonationType(String donationType) {
		this.donationType = donationType;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

}
