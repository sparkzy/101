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
@Table(name = "flashcard")
public class Flashcard {

	@Id
	@Column(name = "flashcard_id")
	@SequenceGenerator(name = "flashcard_id_seq", sequenceName = "flashcard_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "flashcard_id_seq", strategy = GenerationType.AUTO)
	private int flashcardId;

	private String question;
	private String answer;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "author_id")
	private User author;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "FC_SET_ID")
	private FlashcardSet fcSet;

	public Flashcard() {
		super();
	}

	public Flashcard(int flashcardId, String question, String answer, User author, FlashcardSet fcSet) {
		super();
		this.flashcardId = flashcardId;
		this.question = question;
		this.answer = answer;
		this.author = author;
		this.fcSet = fcSet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((fcSet == null) ? 0 : fcSet.hashCode());
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
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (fcSet == null) {
			if (other.fcSet != null)
				return false;
		} else if (!fcSet.equals(other.fcSet))
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

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public FlashcardSet getFcSet() {
		return fcSet;
	}

	public void setFcSet(FlashcardSet fcSet) {
		this.fcSet = fcSet;
	}

	@Override
	public String toString() {
		return "Flashcard [flashcardId=" + flashcardId + ", question=" + question + ", answer=" + answer + ", author="
				+ author + ", fcSet=" + fcSet + "]";
	}
}