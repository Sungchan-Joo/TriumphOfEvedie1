package team_project;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class IncorrectListForm extends JDialog
{
	private Time time;
	private JList list;
	
	
	public IncorrectListForm(Time time) {
		this.time = time;
		init();
		setDisplay();
		showDialog();
	}

	private void init()
	{
		//�ش� ȸ���� ������ ����Ʈ�� ����
		list = new JList(time.getIncorrect());
		list.setCellRenderer(new IncorrectListCellRenderer());
	}

	private void setDisplay()
	{
		JScrollPane scroll = new JScrollPane(list);
		add(scroll,BorderLayout.CENTER);
	}

	private void showDialog()
	{
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
