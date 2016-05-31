package team_project;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class IncorrectListCellRenderer extends ResultListCellRenderer
{
	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus)
	{
		IncorrectNote icn = (IncorrectNote)value;
		String odap = icn.getNote();
		JTextArea odapNote = new JTextArea(odap);
		odapNote.setLineWrap(true);
		odapNote.setWrapStyleWord(true);
		JPanel fatherPanel = new JPanel(new BorderLayout());
		JPanel motherPanel = (JPanel)super.getListCellRendererComponent(list,icn.getQuiz(),index,isSelected,cellHasFocus);
		
		fatherPanel.add(motherPanel,BorderLayout.CENTER);
		fatherPanel.add(odapNote,BorderLayout.SOUTH);
		return fatherPanel;
	}
	
}
