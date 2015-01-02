
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "candidates")
public class Candidates {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column private long id;

	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "surname")
	private String surname;

	public long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	@ManyToOne 
	@JoinColumn(name="zip_codes_id")
	private ZipCodes zipCode;
	public ZipCodes getZipCode(){
		return zipCode;
	}
	
}

