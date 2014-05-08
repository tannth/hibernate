package entites;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ACCOUNTROLES database table.
 * 
 */
@Entity
@Table(name="ACCOUNTROLES")
@NamedQuery(name="Accountrole.findAll", query="SELECT a FROM Accountrole a")
public class Accountrole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ACCOUNTROLE_ID")
	private String accountroleId;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="ACCOUNT_ID")
	private Account account;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="ROLE_ID")
	private Role role;

	public Accountrole() {
	}

	public String getAccountroleId() {
		return this.accountroleId;
	}

	public void setAccountroleId(String accountroleId) {
		this.accountroleId = accountroleId;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}