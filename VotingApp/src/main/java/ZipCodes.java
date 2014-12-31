
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zip_codes")
public class ZipCodes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column private long id;

	@Column(name = "zip_code")
	private String zipCode;

	public long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
