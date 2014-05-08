package entites;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ARTICLES database table.
 * 
 */
@Entity
@Table(name="ARTICLES")
@NamedQuery(name="Article.findAll", query="SELECT a FROM Article a")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ARTICLE_ID")
	private String articleId;

	@Lob
	private String articlecontent;

	private String articleimage;

	private String articletitle;

	@Temporal(TemporalType.DATE)
	private Date createdate;

	@Lob
	private String description;

	@Temporal(TemporalType.DATE)
	private Date lastmodified;

	//bi-directional many-to-one association to Articlerate
	@OneToMany(mappedBy="article")
	private List<Articlerate> articlerates;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="TECHNICIAN_ID")
	private Employee employee;

	public Article() {
	}

	public String getArticleId() {
		return this.articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getArticlecontent() {
		return this.articlecontent;
	}

	public void setArticlecontent(String articlecontent) {
		this.articlecontent = articlecontent;
	}

	public String getArticleimage() {
		return this.articleimage;
	}

	public void setArticleimage(String articleimage) {
		this.articleimage = articleimage;
	}

	public String getArticletitle() {
		return this.articletitle;
	}

	public void setArticletitle(String articletitle) {
		this.articletitle = articletitle;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getLastmodified() {
		return this.lastmodified;
	}

	public void setLastmodified(Date lastmodified) {
		this.lastmodified = lastmodified;
	}

	public List<Articlerate> getArticlerates() {
		return this.articlerates;
	}

	public void setArticlerates(List<Articlerate> articlerates) {
		this.articlerates = articlerates;
	}

	public Articlerate addArticlerate(Articlerate articlerate) {
		getArticlerates().add(articlerate);
		articlerate.setArticle(this);

		return articlerate;
	}

	public Articlerate removeArticlerate(Articlerate articlerate) {
		getArticlerates().remove(articlerate);
		articlerate.setArticle(null);

		return articlerate;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}