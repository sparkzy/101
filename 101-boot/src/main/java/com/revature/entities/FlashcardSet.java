package com.revature.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@Column(name = "title")
	private String title;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "subject_id")
	private Subject subject;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "author_id")
	private User author;

	private int likes = 0;

	public FlashcardSet() {
		super();
	}

	public FlashcardSet(int fcSetId, String title, Subject subject, User author, int likes) {
		super();
		this.fcSetId = fcSetId;
		this.title = title;
		this.subject = subject;
		this.author = author;
		this.likes = likes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + fcSetId;
		result = prime * result + likes;
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
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
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (fcSetId != other.fcSetId)
			return false;
		if (likes != other.likes)
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
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

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	@Override
	public String toString() {
		return "FlashcardSet [fcSetId=" + fcSetId + ", title=" + title + ", subject=" + subject + ", author="
				+ author + ", likes=" + likes + "]";
	}
}