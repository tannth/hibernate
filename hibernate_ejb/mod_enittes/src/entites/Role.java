package entites;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "ROLES" database table.
 * 
 */
@Entity
@Table(name="\"ROLES\"")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ROLE_ID")
	private String roleId;

	private String rolename;

	//bi-directional many-to-one association to Accountrole
	@OneToMany(mappedBy="role")
	private List<Accountrole> accountroles;

	public Role() {
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public List<Accountrole> getAccountroles() {
		return this.accountroles;
	}

	public void setAccountroles(List<Accountrole> accountroles) {
		this.accountroles = accountroles;
	}

	public Accountrole addAccountrole(Accountrole accountrole) {
		getAccountroles().add(accountrole);
		accountrole.setRole(this);

		return accountrole;
	}

	public Accountrole removeAccountrole(Accountrole accountrole) {
		getAccountroles().remove(accountrole);
		accountrole.setRole(null);

		return accountrole;
	}

}