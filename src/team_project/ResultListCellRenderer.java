package team_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ListCellRenderer;
import javax.swing.border.LineBorder;

public class ResultListCellRenderer implements ListCellRenderer
{

	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus)
	{
		Quiz quiz = (Quiz)value;
		
		JPanel motherPanel = new JPanel(new BorderLayout());
		JPanel pnlNorth = new JPanel();
		if(quiz.getImg() != null)
		{
			JLabel lblImg = new JLabel(quiz.getImg(),JLabel.CENTER);
			pnlNorth.add(lblImg);
		}
		JPanel pnlCenter = new JPanel();
		JLabel lblQ = new JLabel(quiz.getQuestion(),JLabel.CENTER);
		pnlCenter.add(lblQ);
		JPanel pnlSouth = new JPanel(new GridLayout(0,1));
		JRadioButton[] rbList = new JRadioButton[4];
		for(int idx = 0; idx < rbList.length; idx++)
		{
			rbList[idx] = new JRadioButton(quiz.getRbChoice()[idx]);
			if(rbList[idx].getText().equals(quiz.getUserChoice()))
			{
				rbList[idx].doClick();
			}
			if(rbList[idx].getText().equals(quiz.getAnswer()))
			{
				rbList[idx].setFont(new Font(Font.DIALOG,Font.BOLD,10));
				rbList[idx].setForeground(Color.RED);
			}
			pnlSouth.add(rbList[idx]);
		}
		
		motherPanel.add(pnlNorth,BorderLayout.NORTH);
		motherPanel.add(pnlCenter,BorderLayout.CENTER);
		motherPanel.add(pnlSouth,BorderLayout.SOUTH);
		
		if(isSelected)
		{
			motherPanel.setBorder(new LineBorder(Color.GRAY,2));
		}
		
		return motherPanel;
	}
	
}
