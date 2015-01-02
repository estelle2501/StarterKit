
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
@Table(name = "voters")
public class Voters {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column private long id;

	@Column(name = "pesel")
	private String pesel;

	public long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	
	@ManyToOne
	@JoinColumn(name="zip_codes_id")
	private ZipCodes zipCode;
	public ZipCodes getZipCode(){
		return zipCode;
	}
	
}

