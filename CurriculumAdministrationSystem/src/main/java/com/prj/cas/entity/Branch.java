package com.prj.cas.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String branchName;
	private boolean isBranchActive;

	public Branch(String branchName, boolean isBranchActive) {
		super();
		this.branchName = branchName;
		this.isBranchActive = isBranchActive;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public boolean isBranchActive() {
		return isBranchActive;
	}

	public void setBranchActive(boolean isBranchActive) {
		this.isBranchActive = isBranchActive;
	}

	@Override
	public String toString() {
		return "Branch [id=" + id + ", branchName=" + branchName + ", isBranchActive=" + isBranchActive + "]";
	}

}
