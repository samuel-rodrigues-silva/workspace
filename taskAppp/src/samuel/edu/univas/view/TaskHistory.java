package samuel.edu.univas.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import samuel.edu.univas.dao.TaskDAO;
//History , this is the panel where every task done or todo is shown to the user.
public class TaskHistory extends JPanel{

		private	TaskDAO taskDAO;
		
		public TaskHistory() throws SQLException{
			taskDAO = new TaskDAO();
			initialize();
		}
		
		public void initialize(){
			
			GridBagConstraints gbc = new GridBagConstraints();
			this.setLayout(new GridBagLayout());
			
			
			JPanel firstPane = new JPanel();
			gbc.insets = new Insets(30,30,30,30);
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.ipadx = 150;
			gbc.ipady = 150;
			gbc.anchor = GridBagConstraints.CENTER;
			firstPane.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.BLACK));
			firstPane.setBackground(Color.LIGHT_GRAY);
			this.add(firstPane,gbc);
			
			JLabel pendingTask = new JLabel();
			pendingTask.setText("Pending Tasks = " + taskDAO.countPendingTasks());
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.anchor = GridBagConstraints.CENTER;
			firstPane.add(pendingTask,gbc);
			
			JPanel secondPane = new JPanel();
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.ipadx = 150;
			gbc.ipady = 150;
			secondPane.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.BLACK));
			secondPane.setBackground(Color.LIGHT_GRAY);
			this.add(secondPane,gbc);
			
			JLabel taskDone = new JLabel();
			taskDone.setText("Tasks Done = " + taskDAO.countTasksDone());
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.anchor = GridBagConstraints.CENTER;
			secondPane.add(taskDone,gbc);
		}
}
