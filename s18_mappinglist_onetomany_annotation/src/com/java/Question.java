package com.java;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;
import org.hibernate.lucene.Indexed;
import org.hibernate.lucene.Keyword;

@Entity
@Table(name = "q502")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "qid")
	private int qid;
	@Column(name = "qname")
	private String qname;
	@OneToMany(fetch = FetchType.LAZY, targetEntity = Answer.class, cascade = CascadeType.ALL)
	@IndexColumn(name="type")
	@JoinColumn(name = "qid", referencedColumnName = "qid")
	private List<Answer> answers;

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String getQname() {
		return qname;
	}

	public void setQname(String qname) {
		this.qname = qname;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

}
