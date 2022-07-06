package com.sallee.bangbangla.pojo.DTO;


public class CommitDTO {
	Integer itemId;
	Integer commitId;
	Integer beCommitId;
	Integer credit;
	String text;

	public CommitDTO() {}

	public CommitDTO(Integer itemId, Integer commitId, Integer beCommitId, Integer credit, String text) {
		this.itemId = itemId;
		this.commitId = commitId;
		this.beCommitId = beCommitId;
		this.credit = credit;
		this.text = text;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getCommitId() {
		return commitId;
	}

	public void setCommitId(Integer commitId) {
		this.commitId = commitId;
	}

	public Integer getBeCommitId() {
		return beCommitId;
	}

	public void setBeCommitId(Integer beCommitId) {
		this.beCommitId = beCommitId;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
