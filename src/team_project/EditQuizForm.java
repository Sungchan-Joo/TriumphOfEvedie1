package team_project;

import javax.swing.JDialog;

public class EditQuizForm extends JDialog
{
	
	private QuizListForm owner;
	
	public EditQuizForm() {
		// 새로운 문제 추가용
		// 파라미터 없는 생성자 
	}
	
	public EditQuizForm(QuizListForm owner)
	{
		this.owner = owner;
		init();
		setDisplay();
		showDialog();
	}

	private void init()
	{
		
	}

	private void setDisplay()
	{
		
	}

	private void showDialog()
	{
		setSize(500,600);
		setLocationRelativeTo(owner);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

}
