package entites;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the ACCOUNTS database table.
 * 
 */
@Entity
@Table(name = "ACCOUNTS")
@NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ACCOUNT_ID")
	private String accountId;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DATE")
	private Date createDate;

	private String username;

	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_ACCESS")
	private Date lastAccess;

	private String password;

	// bi-directional many-to-one association to Accountrole
	@OneToMany(mappedBy = "account")
	private List<Accountrole> accountroles;

	// bi-directional many-to-one association to Employee
	@OneToMany(mappedBy = "account")
	private List<Employee> employees;

	public Account() {
	}

	public String getAccountId() {
		return this.accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getLastAccess() {
		return this.lastAccess;
	}

	public void setLastAccess(Date lastAccess) {
		this.lastAccess = lastAccess;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Accountrole> getAccountroles() {
		return this.accountroles;
	}

	public void setAccountroles(List<Accountrole> accountroles) {
		this.accountroles = accountroles;
	}

	public Accountrole addAccountrole(Accountrole accountrole) {
		getAccountroles().add(accountrole);
		accountrole.setAccount(this);

		return accountrole;
	}

	public Accountrole removeAccountrole(Accountrole accountrole) {
		getAccountroles().remove(accountrole);
		accountrole.setAccount(null);

		return accountrole;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setAccount(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setAccount(null);

		return employee;
	}

}