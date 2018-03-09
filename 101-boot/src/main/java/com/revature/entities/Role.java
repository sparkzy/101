package com.revature.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	@Id
	@Column(name = "role_id")
	@SequenceGenerator(name = "role_id_seq", sequenceName = "role_id_seq")
	@GeneratedValue(generator = "role_id_seq", strategy = GenerationType.AUTO)
	private int roleId;

	private String role;

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userRole")
//	@JsonIgnore
//	private Set<User> users;

	public Role() {
		super();
	}

	public Role(int roleId, String role/*, Set<User> users*/) {
		this.roleId = roleId;
		this.role = role;
//		this.users = users;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

//	public Set<User> getUsers() {
//		return users;
//	}
//
//	public void setUsers(Set<User> users) {
//		this.users = users;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + roleId;
//		result = prime * result + ((users == null) ? 0 : users.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (roleId != other.roleId)
			return false;
//		if (users == null) {
//			if (other.users != null)
//				return false;
//		} else if (!users.equals(other.users))
//			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", role=" + role + /*", users=" + users +*/ "]";
	}
}