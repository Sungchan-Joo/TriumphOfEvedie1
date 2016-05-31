package team_project;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.LineBorder;

public class IncorrectFormListCellRenderer implements ListCellRenderer
{

	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus)
	{
		
		Time temp = (Time)value;
		JLabel lblTimeNum = new JLabel(String.valueOf(temp.getTimes())+" È¸Â÷");
		if(isSelected)
		{
			lblTimeNum.setBorder(new LineBorder(Color.GRAY,2));
		}
		
		return lblTimeNum;
	}
	
}
