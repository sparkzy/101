package com.revature.entities;

import java.util.Set;

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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {
	@Id
	@Column(name = "subject_id")
	@SequenceGenerator(name = "subject_id_seq", sequenceName = "subject_id_seq")
	@GeneratedValue(generator = "subject_id_seq", strategy = GenerationType.AUTO)
	private int subjectId;


	@Column(name = "subject_name")
	private  String subjectName;

//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "subject")
//	private Set<Post> posts;

	public Subject() {
		super();
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Subject(int subjectId, String subjectName) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + subjectId;
		result = prime * result + ((subjectName == null) ? 0 : subjectName.hashCode());
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
		Subject other = (Subject) obj;
		if (subjectId != other.subjectId)
			return false;
		if (subjectName == null) {
			if (other.subjectName != null)
				return false;
		} else if (!subjectName.equals(other.subjectName))
			return false;
		return true;
	}
	

//	public Subject(int subjectId, String subjectName, Set<Post> posts) {
//		this.subjectId = subjectId;
//		this.subjectName = subjectName;
//		this.posts = posts;
//	}
//
//	public int getSubjectId() {
//		return subjectId;
//	}
//
//	public void setSubjectId(int subjectId) {
//		this.subjectId = subjectId;
//	}
//
//	public String getSubjectName() {
//		return subjectName;
//	}
//
//	public void setSubjectName(String subjectName) {
//		this.subjectName = subjectName;
//	}
//
//	public Set<Post> getPosts() {
//		return posts;
//	}
//
//	public void setPosts(Set<Post> posts) {
//		this.posts = posts;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((posts == null) ? 0 : posts.hashCode());
//		result = prime * result + subjectId;
//		result = prime * result + ((subjectName == null) ? 0 : subjectName.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Subject other = (Subject) obj;
//		if (posts == null) {
//			if (other.posts != null)
//				return false;
//		} else if (!posts.equals(other.posts))
//			return false;
//		if (subjectId != other.subjectId)
//			return false;
//		if (subjectName == null) {
//			if (other.subjectName != null)
//				return false;
//		} else if (!subjectName.equals(other.subjectName))
//			return false;
//		return true;
//	}
//
//	@Override
//	public String toString() {
//		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + ", posts=" + posts + "]";
//	}

	
}
