package samuel.edu.univas.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import samuel.edu.univas.dao.TaskDAO;
import samuel.edu.univas.vo.Task;
//this is the panel where displays every pending task. 
public class PendingTask extends JPanel{
		
	TaskDAO taskDAO;
	
	public PendingTask() throws SQLException{
		taskDAO = new TaskDAO();
		initialize();
	}
	
	private void initialize(){
		GridBagConstraints gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		gbc.insets = new Insets(1,1,1,1);
		
		JLabel pendingTasks = new JLabel();
		pendingTasks.setText("PENDING TASKS");
		this.add(pendingTasks);
		
		JComboBox<String> comboBox = new JComboBox();
		comboBox.addItem("---");
		comboBox.addItem("All");
		comboBox.addItem("January");
		comboBox.addItem("February");
		comboBox.addItem("March");
		comboBox.addItem("April");
		comboBox.addItem("May");
		comboBox.addItem("June");
		comboBox.addItem("July");
		comboBox.addItem("August");
		comboBox.addItem("September");
		comboBox.addItem("October");
		comboBox.addItem("November");
		comboBox.addItem("December");
		comboBox.setPreferredSize(new Dimension(200,30));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.EAST;
		this.add(comboBox,gbc);
		
		comboBox.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				 String month = (String) comboBox.getSelectedItem();
				 int x = 0 ;
				 switch(month){
				 case "All" : 
					 	x = 0;
				 		callGetAll(x);
				 		
				 break;
				 case "January" : 
					 	x = 1;
					 	callGetAll(x);
				 break;
				 case "February" : 
					 	x = 2;
					 	callGetAll(x);
				 break;
				 case "March" : 
					 	x = 3;
					 	callGetAll(x);
				 break;
				 case "April" : 
					    x = 4;
					    callGetAll(x);
				 break;
				 case "May" :
					    x = 5;
					    callGetAll(x);
				 break;
				 case "June" :
					    x = 6;
					    callGetAll(x);
				 break;
				 case "July" :
					    x = 7;
					    callGetAll(x);
				 break;
				 case "August" :
					    x = 8;
					    callGetAll(x);
				 break;
				 case "September" :
					    x = 9;
					    callGetAll(x);
				 break;
				 case "October" :
					    x = 10;
					    callGetAll(x);
				 break;
				 case "November" :
					    x = 11;
					    callGetAll(x);
				 break;
				 case "December" :
					    x = 12;
					    callGetAll(x);
					    revalidate();
				 break;		 
				 }
				 System.out.println(comboBox.getSelectedItem() + " = " + x);
			};
		});
		
	}
	
	public void callGetAll(int x){
		GridBagConstraints gbc = new GridBagConstraints();
		int i = 0;
		removeAll();
		initialize();
		revalidate();
		for(Task task : taskDAO.getAll(x)){
			if(task.getDone() == 0){
				JPanel taskPane = new JPanel();
				gbc.gridx = 0;
				gbc.gridy = i+1;
				gbc.ipadx = 394;
				gbc.ipady = 50;
				taskPane.setPreferredSize(new Dimension(100,50));
			//	taskPane.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.WHITE));
				taskPane.setBackground(Color.pink);
				this.add(taskPane,gbc);
				
				JLabel name = new JLabel();
				name.setText(task.getName());
				gbc.gridx = 0;
				gbc.gridy = 0;
				gbc.anchor = GridBagConstraints.CENTER;
				taskPane.add(name,gbc);
				
				JLabel description = new JLabel();
				description.setText(task.getDescription());
				gbc.gridx = 0;
				gbc.gridy = 1;
				taskPane.add(description,gbc);
				
				String[] datas = task.getExpected_date().split("-");
				String rightDate  = datas[2] + "/" + datas[1] + "/" + datas[0];
				
				JLabel date = new JLabel();
				date.setText(rightDate);
				gbc.gridx = 0;
				gbc.gridy = 2;
				taskPane.add(date,gbc);
				
				JCheckBox taskDone = new JCheckBox();
				gbc.gridx = 1;
				gbc.gridy = 2;
				taskDone.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
							
						if(taskDone.isSelected()){
							int x = task.getId();
							taskDAO.taskDone(x);
							revalidate();
							repaint();
							updateUI();
						};
					}
					
				});
				taskPane.add(taskDone,gbc);
				i += 1;
				
				updateUI();
				repaint();
			}
			 
			
	   }
	}	
}
