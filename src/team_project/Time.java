package team_project;

import java.util.Vector;

// ÀÀ½ÃÈ½¼ö : number of examinations 
public class Time
{
	private int times;
	private Quiz[] quizs;
	private Vector<IncorrectNote> incorrect;

	public int getTimes()
	{
		return times;
	}
	public void setTimes(int times)
	{
		this.times = times;
	}
	public Quiz[] getQuizs()
	{
		return quizs;
	}
	public void setQuizs(Quiz[] quizs)
	{
		this.quizs = quizs;
	}
	public Vector<IncorrectNote> getIncorrect()
	{
		return incorrect;
	}
	public void setIncorrect(Vector<IncorrectNote> incorrect)
	{
		this.incorrect = incorrect;
	}
	
	public void addIncorrectNote(IncorrectNote icn)
	{
		incorrect.add(icn);
	}
	
}
