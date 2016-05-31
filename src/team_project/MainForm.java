package team_project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainForm extends JFrame implements ActionListener{
	
	private JButton testBtn;
	private JButton wrongAnswerBtn;
	private JButton manageBtn;
	
	private Vector<Quiz> quizList;
	private Vector<Time> timeList;
	
	public MainForm()
	{
		init();
		setDisplay();
		addListener();
		showFrame();
	}
	
	private void init()
	{
		testBtn = new JButton("응시하기");
		wrongAnswerBtn = new JButton("오답노트");
		manageBtn = new JButton("관리하기");
	}
	
	private void setDisplay()
	{
		JPanel cpnlNorth = new JPanel(new BorderLayout());
		cpnlNorth.add(testBtn,BorderLayout.CENTER);
		JPanel cpnlSouth = new JPanel(new GridLayout(1,2));
		cpnlSouth.add(wrongAnswerBtn);
		cpnlSouth.add(manageBtn);
		JPanel pnlCenter = new JPanel(new GridLayout(2,1));
		pnlCenter.add(cpnlNorth);
		pnlCenter.add(cpnlSouth);
		
		add(pnlCenter,BorderLayout.CENTER);
	}
	
	private void addListener()
	{
		testBtn.addActionListener(this);
		wrongAnswerBtn.addActionListener(this);
		manageBtn.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		Object src = ae.getSource();
		if(src == testBtn)
		{
			new QuizForm(this);
		}
		else if(src == wrongAnswerBtn)
		{
			//Dialog오답노트?
		}
		else
		{
			new QuizListForm(this);
		}
	}
	private void showFrame()
	{
		setTitle("장학자바");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	// getters, setters
	public Vector<Quiz> getQuizList()
	{
		return quizList;
	}
	
	public void setQuizList(Vector<Quiz> quizList)
	{
		this.quizList = quizList;
	}
	
	public Vector<Time> getTimeList()
	{
		return timeList;
	}
	
	public void setTimeList(Vector<Time> timeList)
	{
		this.timeList = timeList;
	}
	
	public static void main(String[] args) {
		new MainForm();
	}

}
