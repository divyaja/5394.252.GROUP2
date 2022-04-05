package com.prj.cas.entity;

import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "emailId"))
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstName;
	private String middleName;
	private String lastName;
	private String emailId;
	@Column(unique = true)
	private String userName;
	private String password;
	private int roleId;
	private boolean isUserActive = true;
	private Timestamp createdAt;
	private String createdBy;
	private Timestamp lastUpdateAt;
	private String lastUpdatedBy;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "users_courses", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
	private Collection<Course> courses;

	public User() {

	}

	public User(String firstName, String middleName, String lastName, String emailId, String userName, String password,
			int roleId, boolean isUserActive, Timestamp createdAt, String createdBy, Timestamp lastUpdateAt,
			String lastUpdatedBy) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.userName = userName;
		this.password = password;
		this.roleId = roleId;
		this.isUserActive = isUserActive;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.lastUpdateAt = lastUpdateAt;
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int role) {
		this.roleId = role;
	}

	public boolean isActive() {
		return isUserActive;
	}

	public void setActive(boolean isUserActive) {
		this.isUserActive = isUserActive;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getLastUpdateAt() {
		return lastUpdateAt;
	}

	public void setLastUpdateAt(Timestamp lastUpdateAt) {
		this.lastUpdateAt = lastUpdateAt;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", userName=" + userName + ", password=" + password + ", roleId=" + roleId
				+ ", isActive=" + isUserActive + ", createdAt=" + createdAt + ", createdBy=" + createdBy
				+ ", lastUpdateAt=" + lastUpdateAt + ", lastUpdatedBy=" + lastUpdatedBy + "]";
	}

}
