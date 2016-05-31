package team_project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class QuizForm extends JDialog{
	public static final int QUIZLIST = 6;
	MainForm owner;
	
	JLabel lblIndex;
	JLabel lblImage;
	JLabel lblQuestion;
	JButton btnSubmit;
	JRadioButton[] choice;
	Time time;
	
	int countNum=1;
	
	String[] example;
	
	public QuizForm(MainForm owner){
		super(owner,"QuizForm", true);
		this.owner = owner;
		
		init();
		setDisplay();
		addListeners();
		showDialog();
	}
	private void init(){
		lblIndex = new JLabel(countNum+"/20", JLabel.CENTER);
		
		lblImage = new JLabel();
		lblQuestion = new JLabel();
		btnSubmit =  new JButton("제출하기");
		choice = new JRadioButton[4];
		
		// 보기 넣어줘야댐
		example = new String[4];
	}
	private void setDisplay(){
		JPanel pnlCenter = new JPanel(new GridLayout(0,1));
		pnlCenter.add(lblImage);
		
		JPanel pnlTop = new JPanel();
		pnlTop.add(lblQuestion);
		
		JPanel pnlBottom = new JPanel(new GridLayout(0,1));
		for(int i=0; i<choice.length; i++){
			choice[i] = new JRadioButton(example[i]);
			pnlBottom.add(choice[i]);
		}
		
		JPanel pnlCenterBottom = new JPanel();
		pnlCenterBottom.add(pnlTop);
		pnlCenterBottom.add(pnlBottom);
		
		JPanel pnlButton = new JPanel();
		pnlButton.add(btnSubmit);
		
		add(lblIndex, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlButton, BorderLayout.SOUTH);
	}
	private void showDialog() {
		setSize(500,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	private void addListeners(){
		btnSubmit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae)
			{
				setIndex();
				if(countNum >= QUIZLIST)
				{
					new ResultForm(QuizForm.this);
				}
			}
		});
	}
	
	public void addIncorrect(IncorrectNote icn) {
		time.addIncorrectNote(icn);
	}
	
	private void setIndex(){
		countNum++;
		lblIndex.setText(countNum+"/20");
		
	}
	public MainForm getOwner()
	{
		return owner;
	}
	public void setOwner(MainForm owner)
	{
		this.owner = owner;
	}
	public Time getTime()
	{
		return time;
	}
	public void setTime(Time time)
	{
		this.time = time;
	}

}
