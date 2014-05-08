package entites;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the COMPLAINTS database table.
 * 
 */
@Entity
@Table(name="COMPLAINTS")
@NamedQuery(name="Complaint.findAll", query="SELECT c FROM Complaint c")
public class Complaint implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COMPLAINT_ID")
	private String complaintId;

	@Column(name="COMPLAINT_TITLE")
	private String complaintTitle;

	@Temporal(TemporalType.DATE)
	private Date createdate;

	@Lob
	private String empcontent;

	private BigDecimal priority;

	private BigDecimal status;

	//bi-directional many-to-one association to Complaintreply
	@OneToMany(mappedBy="complaint")
	private List<Complaintreply> complaintreplies;

	//bi-directional many-to-one association to Complaintcategory
	@ManyToOne
	@JoinColumn(name="CATEGORY_ID")
	private Complaintcategory complaintcategory;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_ID")
	private Employee employee;

	public Complaint() {
	}

	public String getComplaintId() {
		return this.complaintId;
	}

	public void setComplaintId(String complaintId) {
		this.complaintId = complaintId;
	}

	public String getComplaintTitle() {
		return this.complaintTitle;
	}

	public void setComplaintTitle(String complaintTitle) {
		this.complaintTitle = complaintTitle;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getEmpcontent() {
		return this.empcontent;
	}

	public void setEmpcontent(String empcontent) {
		this.empcontent = empcontent;
	}

	public BigDecimal getPriority() {
		return this.priority;
	}

	public void setPriority(BigDecimal priority) {
		this.priority = priority;
	}

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	public List<Complaintreply> getComplaintreplies() {
		return this.complaintreplies;
	}

	public void setComplaintreplies(List<Complaintreply> complaintreplies) {
		this.complaintreplies = complaintreplies;
	}

	public Complaintreply addComplaintreply(Complaintreply complaintreply) {
		getComplaintreplies().add(complaintreply);
		complaintreply.setComplaint(this);

		return complaintreply;
	}

	public Complaintreply removeComplaintreply(Complaintreply complaintreply) {
		getComplaintreplies().remove(complaintreply);
		complaintreply.setComplaint(null);

		return complaintreply;
	}

	public Complaintcategory getComplaintcategory() {
		return this.complaintcategory;
	}

	public void setComplaintcategory(Complaintcategory complaintcategory) {
		this.complaintcategory = complaintcategory;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}