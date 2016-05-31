package team_project;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextArea;

public class IncorrectNoteForm extends JDialog
{
	private ResultForm owner;
	private JTextArea taNote;
	private JButton btnSave;
	private Quiz quiz;

	public IncorrectNoteForm(ResultForm owner, Quiz quiz)
	{
		super(owner, "�����Ʈ �ۼ�", true);
		this.owner = owner;
		this.quiz = quiz;
		init();
		setDisplay();
		addListeners();
		showDialog();
	}

	private void init()
	{
		taNote = new JTextArea(10, 30);
		taNote.setLineWrap(true);
		taNote.setWrapStyleWord(true);
		btnSave = new JButton("����");
	}

	private void setDisplay()
	{
		add(taNote, BorderLayout.CENTER);
		add(btnSave, BorderLayout.SOUTH);
	}
	
	private void saveIncorrectNote() 
	{	
		
		String note = taNote.getText();
		owner.addIncorrect(new IncorrectNote(quiz, note));
		// time��ü ������ �����Ʈ�� ����
	}
	private void addListeners() {
		btnSave.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				saveIncorrectNote();
				dispose();
			}
		});
	}
	private void showDialog()
	{
		pack();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(owner);
		setVisible(true);
	}
}