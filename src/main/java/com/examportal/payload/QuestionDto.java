package com.examportal.payload;

public class QuestionDto {

	private int questionId;
	
	private String question;

	private String correctAnswer;
	
	private String optionA;
	
	private String optionB;
	
	private String optionC;

	private String optionD;

	private ExamDto exam;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
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

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public ExamDto getExam() {
		return exam;
	}

	public void setExam(ExamDto exam) {
		this.exam = exam;
	}

	@Override
	public String toString() {
		return "QuestionDto [questionId=" + questionId + ", question=" + question + ", correctAnswer=" + correctAnswer
				+ ", optionA=" + optionA + ", optionB=" + optionB + ", optionC=" + optionC + ", optionD=" + optionD
				+ ", exam=" + exam + "]";
	}

	public QuestionDto(int questionId, String question, String correctAnswer, String optionA, String optionB,
			String optionC, String optionD, ExamDto exam) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.correctAnswer = correctAnswer;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.exam = exam;
	}

	public QuestionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}

