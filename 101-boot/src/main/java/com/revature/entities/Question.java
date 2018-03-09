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
@Table(name = "question")
public class Question {
	@Id
	@Column(name = "question_id")
	@SequenceGenerator(name = "question_id_seq", sequenceName = "question_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "question_id_seq", strategy = GenerationType.AUTO)
	private int questionId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "quiz_id")
	private Quiz quiz;
	
	@Column(name = "question")
	private String question;

	@Column(name = "correct_answer")
	private String correctAnswer;

	@Column(name = "wrong_answer_0")
	private String wrongAnswer1;

	@Column(name = "wrong_answer_1")
	private String wrongAnswer2;

	@Column(name = "wrong_answer_2")
	private String wrongAnswer3;

	public Question() {
		super();
	}

	public Question(int questionId, Quiz quiz, String question, String correctAnswer, String wrongAnswer1,
			String wrongAnswer2, String wrongAnswer3) {
		super();
		this.questionId = questionId;
		this.quiz = quiz;
		this.question = question;
		this.correctAnswer = correctAnswer;
		this.wrongAnswer1 = wrongAnswer1;
		this.wrongAnswer2 = wrongAnswer2;
		this.wrongAnswer3 = wrongAnswer3;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((correctAnswer == null) ? 0 : correctAnswer.hashCode());
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		result = prime * result + questionId;
		result = prime * result + ((quiz == null) ? 0 : quiz.hashCode());
		result = prime * result + ((wrongAnswer1 == null) ? 0 : wrongAnswer1.hashCode());
		result = prime * result + ((wrongAnswer2 == null) ? 0 : wrongAnswer2.hashCode());
		result = prime * result + ((wrongAnswer3 == null) ? 0 : wrongAnswer3.hashCode());
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
		Question other = (Question) obj;
		if (correctAnswer == null) {
			if (other.correctAnswer != null)
				return false;
		} else if (!correctAnswer.equals(other.correctAnswer))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (questionId != other.questionId)
			return false;
		if (quiz == null) {
			if (other.quiz != null)
				return false;
		} else if (!quiz.equals(other.quiz))
			return false;
		if (wrongAnswer1 == null) {
			if (other.wrongAnswer1 != null)
				return false;
		} else if (!wrongAnswer1.equals(other.wrongAnswer1))
			return false;
		if (wrongAnswer2 == null) {
			if (other.wrongAnswer2 != null)
				return false;
		} else if (!wrongAnswer2.equals(other.wrongAnswer2))
			return false;
		if (wrongAnswer3 == null) {
			if (other.wrongAnswer3 != null)
				return false;
		} else if (!wrongAnswer3.equals(other.wrongAnswer3))
			return false;
		return true;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public String getWrongAnswer1() {
		return wrongAnswer1;
	}

	public void setWrongAnswer1(String wrongAnswer1) {
		this.wrongAnswer1 = wrongAnswer1;
	}

	public String getWrongAnswer2() {
		return wrongAnswer2;
	}

	public void setWrongAnswer2(String wrongAnswer2) {
		this.wrongAnswer2 = wrongAnswer2;
	}

	public String getWrongAnswer3() {
		return wrongAnswer3;
	}

	public void setWrongAnswer3(String wrongAnswer3) {
		this.wrongAnswer3 = wrongAnswer3;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", quiz=" + quiz + "question=" + question + ", correctAnswer=" + correctAnswer
				+ ", wrongAnswer1=" + wrongAnswer1 + ", wrongAnswer2=" + wrongAnswer2 + ", wrongAnswer3=" + wrongAnswer3
				+ "]";
	}
}