package com.prj.cas.pojo.request;

public class AdminRequest {
	private String firstName;
	private String middleName;
	private String lastName;
	private int roleId;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "UserRegistrationDto [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", roleId=" + roleId + "]";
	}
}
