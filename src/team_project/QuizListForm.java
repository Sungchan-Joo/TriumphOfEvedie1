package team_project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class QuizListForm extends JDialog 
{
	private MainForm owner;
	
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDel;
	
	private JList list;
	private DefaultListModel listModel;
	
	public QuizListForm(MainForm owner)
	{
		super(owner,"관리",true);
		this.owner = owner;
		init();
		setDisplay();
		addListener();
		showDialog();
	}
	
	private void init()
	{
		btnAdd = new JButton("추가");
		btnEdit = new JButton("수정");
		btnDel = new JButton("삭제");
		
		listModel = new DefaultListModel();
		for(Quiz temp : owner.getQuizList())
		{
			listModel.addElement(temp);
		}
		list = new JList(listModel);
	}
	
	private void addListener()
	{
		ActionListener listener = new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent ae)
			{
				Object src = ae.getSource();
				
				if(src == btnAdd)
				{
					new EditQuizForm();
				}
				else if(src == btnEdit)
				{
					new EditQuizForm();
				}
				else
				{
					
				}
			}
		};
		btnAdd.addActionListener(listener);
		btnEdit.addActionListener(listener);
		btnDel.addActionListener(listener);
	}
	
	private void setDisplay()
	{
		add(new JScrollPane(list),BorderLayout.CENTER);
		JPanel pnlSouth = new JPanel(new GridLayout(1,3));
		pnlSouth.add(btnAdd);
		pnlSouth.add(btnEdit);
		pnlSouth.add(btnDel);
		add(pnlSouth,BorderLayout.SOUTH);
	}

	private void showDialog()
	{
		setSize(500,500);
		setLocationRelativeTo(owner);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

}
