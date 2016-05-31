package team_project;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class ResultForm extends JDialog 
{
	private JLabel lblScore;
	
	private QuizForm owner;

	private JList resultList;
	
	public ResultForm(QuizForm owner)
	{
		super(owner,"결과",true);
		this.owner = owner;
		init();
		setDisplay();
		addListener();
		showDialog();
	}
	
	private void init()
	{
		setScore();
		resultList = new JList(owner.getTime().getQuizs());
		resultList.setCellRenderer(new ResultListCellRenderer());
	}
	
	private void setDisplay()
	{
		add(setScore(),BorderLayout.NORTH);
		add(new JScrollPane(resultList),BorderLayout.CENTER);
	}
	
	private void addListener()
	{
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent we)
			{
				//오답노트의 내용을 저장한다.
				dispose();
			}
		});
		
		resultList.addMouseListener(new MouseAdapter() {
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
		Rectangle r = resultList.getCellBounds
		(
			resultList.getLastVisibleIndex(), resultList.getLastVisibleIndex()
		);
		
		try
		{
			int listY = r.y + r.height;
					
			int mouseY = me.getY();
					
			if(mouseY > listY) 
			{
				//리스트 바깥 쪽 클릭 버튼 false
				resultList.clearSelection();
			} 
			else 
			{
				if(me.getClickCount() == 2) {
					Quiz temp = (Quiz)resultList.getModel();
					new IncorrectNoteForm(this, temp);
				}
			}
		}
		catch(NullPointerException e)
		{
			JOptionPane.showMessageDialog(ResultForm.this, "선택할 리스트가 없습니다.","경고", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	private JLabel setScore()
	{
		lblScore = new JLabel();
		//퀴즈 내부의 메소드를 이용해서 맞은 갯수를 lbl에 적어준다.
		//임시점수
		lblScore.setText("50점");
		return lblScore;
	}
	
	private void showDialog()
	{
		setSize(500,800);
		setLocationRelativeTo(owner);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void addIncorrect(IncorrectNote icn)
	{
		 owner.addIncorrect(icn);
	}
	
}
