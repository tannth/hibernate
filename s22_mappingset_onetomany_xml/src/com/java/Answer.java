package com.java;

public class Answer {
	private int aid;
	private String answer;
	private String postBy;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getPostBy() {
		return postBy;
	}

	public void setPostBy(String postBy) {
		this.postBy = postBy;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getAnswer() + " by: " + getPostBy();
	}
}
