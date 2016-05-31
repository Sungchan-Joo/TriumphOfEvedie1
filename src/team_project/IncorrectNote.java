package team_project;

public class IncorrectNote
{
	private Quiz quiz;
	private String note;
	
	public IncorrectNote(Quiz quiz, String note) {
		this.quiz = quiz;
		this.note = note;
	}

	public Quiz getQuiz()
	{
		return quiz;
	}

	public void setQuiz(Quiz quiz)
	{
		this.quiz = quiz;
	}

	public String getNote()
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}
	
	
}
