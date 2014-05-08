package entites;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the COMPLAINTREPLIES database table.
 * 
 */
@Entity
@Table(name="COMPLAINTREPLIES")
@NamedQuery(name="Complaintreply.findAll", query="SELECT c FROM Complaintreply c")
public class Complaintreply implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COMPLAINTREPLY_ID")
	private String complaintreplyId;

	@Lob
	private String replycontent;

	@Temporal(TemporalType.DATE)
	private Date replydate;

	//bi-directional many-to-one association to Complaint
	@ManyToOne
	@JoinColumn(name="COMPLAINT_ID")
	private Complaint complaint;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="TECHNICIAN_ID")
	private Employee employee;

	public Complaintreply() {
	}

	public String getComplaintreplyId() {
		return this.complaintreplyId;
	}

	public void setComplaintreplyId(String complaintreplyId) {
		this.complaintreplyId = complaintreplyId;
	}

	public String getReplycontent() {
		return this.replycontent;
	}

	public void setReplycontent(String replycontent) {
		this.replycontent = replycontent;
	}

	public Date getReplydate() {
		return this.replydate;
	}

	public void setReplydate(Date replydate) {
		this.replydate = replydate;
	}

	public Complaint getComplaint() {
		return this.complaint;
	}

	public void setComplaint(Complaint complaint) {
		this.complaint = complaint;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}