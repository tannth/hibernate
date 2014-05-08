package entites;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PARAMATERS database table.
 * 
 */
@Entity
@Table(name="PARAMATERS")
@NamedQuery(name="Paramater.findAll", query="SELECT p FROM Paramater p")
public class Paramater implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String parameterid;

	@Column(name="\"KEY\"")
	private String key;

	@Lob
	@Column(name="\"VALUE\"")
	private String value;

	public Paramater() {
	}

	public String getParameterid() {
		return this.parameterid;
	}

	public void setParameterid(String parameterid) {
		this.parameterid = parameterid;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}