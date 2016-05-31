package team_project;

import javax.swing.ImageIcon;

// 시험문제 : examinations
public class Quiz
{
	private int quizNum;	
	private ImageIcon img;
	private String question;
	private String[] rbChoice;
	private String userChoice;
	private String answer;
	public int getQuizNum()
	{
		return quizNum;
	}
	public void setQuizNum(int quizNum)
	{
		this.quizNum = quizNum;
	}
	public ImageIcon getImg()
	{
		return img;
	}
	public void setImg(ImageIcon img)
	{
		this.img = img;
	}
	public String getQuestion()
	{
		return question;
	}
	public void setQuestion(String question)
	{
		this.question = question;
	}
	public String[] getRbChoice()
	{
		return rbChoice;
	}
	public void setRbChoice(String[] rbChoice)
	{
		this.rbChoice = rbChoice;
	}
	public String getUserChoice()
	{
		return userChoice;
	}
	public void setUserChoice(String userChoice)
	{
		this.userChoice = userChoice;
	}
	public String getAnswer()
	{
		return answer;
	}
	public void setAnswer(String answer)
	{
		this.answer = answer;
	}
}
/*
 * 	userChoice = 라디오버튼 isSelected()의 getText
 */
