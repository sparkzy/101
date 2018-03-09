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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "fc_set")
public class FlashcardSet {

	@Id
	@Column(name = "fc_set_id")
	@SequenceGenerator(name = "fc_set_id_seq", sequenceName = "fc_set_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "fc_set_id_seq", strategy = GenerationType.AUTO)
	private int fcSetId;

	private String title;

	@Column(name = "subject_id")
	private int subjectId;
//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinColumn(name = "subject_id")
//	private Set<Subject> subject;

	@Column(name = "author_id")
	private int authorId;
//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinColumn(name = "user_id")
//	private Set<User> author;

	private int likes;

	public FlashcardSet() {
		super();
	}

	public FlashcardSet(int fcSetId, String title, int subjectId, int authorId, int likes) {
		super();
		this.fcSetId = fcSetId;
		this.title = title;
		this.subjectId = subjectId;
		this.authorId = authorId;
		this.likes = likes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + authorId;
		result = prime * result + fcSetId;
		result = prime * result + likes;
		result = prime * result + subjectId;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		FlashcardSet other = (FlashcardSet) obj;
		if (authorId != other.authorId)
			return false;
		if (fcSetId != other.fcSetId)
			return false;
		if (likes != other.likes)
			return false;
		if (subjectId != other.subjectId)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public int getFcSetId() {
		return fcSetId;
	}

	public void setFcSetId(int fcSetId) {
		this.fcSetId = fcSetId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	@Override
	public String toString() {
		return "FlashcardSet [fcSetId=" + fcSetId + ", title=" + title + ", subjectId=" + subjectId + ", authorId="
				+ authorId + ", likes=" + likes + "]";
	}
}