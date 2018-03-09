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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "flashcard")
public class Flashcard {

	@Id
	@Column(name = "flashcard_id")
	@SequenceGenerator(name = "flashcard_id_seq", sequenceName = "flashcard_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "flashcard_id_seq", strategy = GenerationType.AUTO)
	private int flashcardId;

	private String question;
	private String answer;

	@Column(name = "AUTHOR_ID")
	private int authorId;

//	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name = "FC_SET_ID")
//	private Set<FlashcardSet> fcSet;
	
	@Column(name = "FC_SET_ID")
	private int fcSetId;

//	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name = "USER_ID")
//	private Set<User> author;

	public Flashcard() {
		super();
	}

	public Flashcard(int flashcardId, String question, String answer, int authorId, int fcSetId) {
		super();
		this.flashcardId = flashcardId;
		this.question = question;
		this.answer = answer;
		this.authorId = authorId;
		this.fcSetId = fcSetId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + authorId;
		result = prime * result + fcSetId;
		result = prime * result + flashcardId;
		result = prime * result + ((question == null) ? 0 : question.hashCode());
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
		Flashcard other = (Flashcard) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (authorId != other.authorId)
			return false;
		if (fcSetId != other.fcSetId)
			return false;
		if (flashcardId != other.flashcardId)
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		return true;
	}

	public int getFlashcardId() {
		return flashcardId;
	}

	public void setFlashcardId(int flashcardId) {
		this.flashcardId = flashcardId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getFcSetId() {
		return fcSetId;
	}

	public void setFcSetId(int fcSetId) {
		this.fcSetId = fcSetId;
	}

	@Override
	public String toString() {
		return "Flashcard [flashcardId=" + flashcardId + ", question=" + question + ", answer="
				+ answer + ", authorId=" + authorId + ", fcSetId=" + fcSetId + "]";
	}
}
