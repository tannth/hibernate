package entites;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ARTICLERATES database table.
 * 
 */
@Entity
@Table(name="ARTICLERATES")
@NamedQuery(name="Articlerate.findAll", query="SELECT a FROM Articlerate a")
public class Articlerate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ARTICLERATE_ID")
	private String articlerateId;

	private BigDecimal rate;

	//bi-directional many-to-one association to Article
	@ManyToOne
	@JoinColumn(name="ARTICLE_ID")
	private Article article;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_ID")
	private Employee employee;

	public Articlerate() {
	}

	public String getArticlerateId() {
		return this.articlerateId;
	}

	public void setArticlerateId(String articlerateId) {
		this.articlerateId = articlerateId;
	}

	public BigDecimal getRate() {
		return this.rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}