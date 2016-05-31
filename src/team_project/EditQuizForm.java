package team_project;

import javax.swing.JDialog;

public class EditQuizForm extends JDialog
{
	
	private QuizListForm owner;
	
	
	
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
