package entites;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the COMPLAINTCATEGORIES database table.
 * 
 */
@Entity
@Table(name="COMPLAINTCATEGORIES")
@NamedQuery(name="Complaintcategory.findAll", query="SELECT c FROM Complaintcategory c")
public class Complaintcategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CATEGORY_ID")
	private String categoryId;

	private String categoryname;

	//bi-directional many-to-one association to Complaint
	@OneToMany(mappedBy="complaintcategory")
	private List<Complaint> complaints;

	public Complaintcategory() {
	}

	public String getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryname() {
		return this.categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public List<Complaint> getComplaints() {
		return this.complaints;
	}

	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}

	public Complaint addComplaint(Complaint complaint) {
		getComplaints().add(complaint);
		complaint.setComplaintcategory(this);

		return complaint;
	}

	public Complaint removeComplaint(Complaint complaint) {
		getComplaints().remove(complaint);
		complaint.setComplaintcategory(null);

		return complaint;
	}

}