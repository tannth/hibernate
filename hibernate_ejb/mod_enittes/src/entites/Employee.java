package entites;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the EMPLOYEES database table.
 * 
 */
@Entity
@Table(name="EMPLOYEES")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EMPLOYEE_ID")
	private String employeeId;

	private String address;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	private String email;

	@Column(name="FIRT_NAME")
	private String firtName;

	private String gender;

	@Column(name="LAST_NAME")
	private String lastName;

	private BigDecimal phone;

	//bi-directional many-to-one association to Articlerate
	@OneToMany(mappedBy="employee")
	private List<Articlerate> articlerates;

	//bi-directional many-to-one association to Article
	@OneToMany(mappedBy="employee")
	private List<Article> articles;

	//bi-directional many-to-one association to Complaintreply
	@OneToMany(mappedBy="employee")
	private List<Complaintreply> complaintreplies;

	//bi-directional many-to-one association to Complaint
	@OneToMany(mappedBy="employee")
	private List<Complaint> complaints;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="ACCOUNT_ID")
	private Account account;

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="DEPARTMENT_ID")
	private Department department;

	//bi-directional many-to-one association to Job
	@ManyToOne
	@JoinColumn(name="JOB_ID")
	private Job job;

	public Employee() {
	}

	public String getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirtName() {
		return this.firtName;
	}

	public void setFirtName(String firtName) {
		this.firtName = firtName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public BigDecimal getPhone() {
		return this.phone;
	}

	public void setPhone(BigDecimal phone) {
		this.phone = phone;
	}

	public List<Articlerate> getArticlerates() {
		return this.articlerates;
	}

	public void setArticlerates(List<Articlerate> articlerates) {
		this.articlerates = articlerates;
	}

	public Articlerate addArticlerate(Articlerate articlerate) {
		getArticlerates().add(articlerate);
		articlerate.setEmployee(this);

		return articlerate;
	}

	public Articlerate removeArticlerate(Articlerate articlerate) {
		getArticlerates().remove(articlerate);
		articlerate.setEmployee(null);

		return articlerate;
	}

	public List<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Article addArticle(Article article) {
		getArticles().add(article);
		article.setEmployee(this);

		return article;
	}

	public Article removeArticle(Article article) {
		getArticles().remove(article);
		article.setEmployee(null);

		return article;
	}

	public List<Complaintreply> getComplaintreplies() {
		return this.complaintreplies;
	}

	public void setComplaintreplies(List<Complaintreply> complaintreplies) {
		this.complaintreplies = complaintreplies;
	}

	public Complaintreply addComplaintreply(Complaintreply complaintreply) {
		getComplaintreplies().add(complaintreply);
		complaintreply.setEmployee(this);

		return complaintreply;
	}

	public Complaintreply removeComplaintreply(Complaintreply complaintreply) {
		getComplaintreplies().remove(complaintreply);
		complaintreply.setEmployee(null);

		return complaintreply;
	}

	public List<Complaint> getComplaints() {
		return this.complaints;
	}

	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}

	public Complaint addComplaint(Complaint complaint) {
		getComplaints().add(complaint);
		complaint.setEmployee(this);

		return complaint;
	}

	public Complaint removeComplaint(Complaint complaint) {
		getComplaints().remove(complaint);
		complaint.setEmployee(null);

		return complaint;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

}