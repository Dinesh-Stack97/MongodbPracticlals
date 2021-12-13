package mongo_Start.mongodb_test.modules;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Temples")
public class Temple {

	@Id
	private int id;

	private String templeName;

	private String priestName;

	private long phoneNumber;

	private String email;

	private int no_of_Halls;

	private List<Donations> donations;

	public Temple() {

		// TODO Auto-generated constructor stub
	}

	public Temple(int id, String templeName, String priestName, long phoneNumber, String email, int no_of_Halls,
			List<Donations> donations) {
		super();
		this.id = id;
		this.templeName = templeName;
		this.priestName = priestName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.no_of_Halls = no_of_Halls;
		this.donations = donations;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTempleName() {
		return templeName;
	}

	public void setTempleName(String templeName) {
		this.templeName = templeName;
	}

	public String getPriestName() {
		return priestName;
	}

	public void setPriestName(String priestName) {
		this.priestName = priestName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNo_of_Halls() {
		return no_of_Halls;
	}

	public void setNo_of_Halls(int no_of_Halls) {
		this.no_of_Halls = no_of_Halls;
	}

	public List<Donations> getDonations() {
		return donations;
	}

	public void setDonations(List<Donations> donations) {
		this.donations = donations;
	}

}
