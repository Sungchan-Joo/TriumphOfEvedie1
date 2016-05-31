package team_project;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class IncorrectForm extends JDialog
{
	private MainForm owner;
	private JList timeList;
	
	public IncorrectForm(MainForm owner) {
		super(owner, "응시목록", true);
		init();
		setDisplay();
		addListener();
		showDialog();
	}


	private void init()
	{
		
		timeList = new JList(owner.getTimeList());
		timeList.setCellRenderer(new IncorrectFormListCellRenderer());
	}
	private void setDisplay()
	{
		add(new JScrollPane(timeList), BorderLayout.CENTER);
	}
	private void showDialog()
	{
		setSize(500, 400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void addListener()
	{
/*		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent we)
			{
				//오답노트의 내용을 저장한다.
				dispose();
			}
		});*/
		
		timeList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent me) {
				mousePositionCheck(me);
			}
			@Override
			public void mousePressed(MouseEvent me) {
				mousePositionCheck(me);
			}
		});
	}
	
	private void mousePositionCheck(MouseEvent me) 
	{
		Rectangle r = timeList.getCellBounds
		(
				timeList.getLastVisibleIndex(), timeList.getLastVisibleIndex()
		);
		
		try
		{
			int listY = r.y + r.height;
					
			int mouseY = me.getY();
					
			if(mouseY > listY) 
			{
				//리스트 바깥 쪽 클릭 버튼 false
				timeList.clearSelection();
			} 
			else 
			{
				
				if(me.getClickCount() == 2) {
					int idx = timeList.getLeadSelectionIndex();
					Vector<Time> temp = (Vector<Time>)timeList.getModel();
					new IncorrectListForm(temp.elementAt(idx));
				}
			}
		}
		catch(NullPointerException e)
		{
			JOptionPane.showMessageDialog(IncorrectForm.this, "선택할 리스트가 없습니다.","경고", JOptionPane.WARNING_MESSAGE);
		}
	}

}
