package samuel.edu.univas.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import samuel.edu.univas.dao.TaskDAO;
import samuel.edu.univas.vo.Task;
// this is the panel where the user edit/remove some task.
public class TaskList extends JPanel{
		
	TaskDAO taskDAO;
	public TaskList() throws SQLException{
		taskDAO = new TaskDAO();
		initialize();
	}
	
	private void initialize(){
		
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(1,1,1,1);
		
		
		int i = 0;
		
			for(Task tasks : taskDAO.getAll(0)){
			
			JPanel task = new JPanel();
			gbc.gridx = 0;
			gbc.gridy = i;
			gbc.ipadx = 394;
			gbc.ipady = 100;
			task.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.WHITE));
			task.setPreferredSize(new Dimension(100,100));
			task.setBackground(Color.pink);
			task.setLayout(new GridBagLayout());
			task.setSize(200, 200);
			this.add(task,gbc);
			
			
			JLabel title = new JLabel();
			if(tasks.getDone() == 1){
				title.setText(tasks.getName() + " --- DONE");
			}else{
				title.setText(tasks.getName() + " --- PENDING");

			}
			gbc.ipady = 1;
			gbc.ipadx = 1;
			gbc.anchor = GridBagConstraints.CENTER;
			gbc.gridx = 0;
			gbc.gridy = 0;
			task.add(title,gbc);
			
			JLabel text = new JLabel();
			text.setText(tasks.getDescription());
			gbc.ipady = 1;
			gbc.ipadx = 50;
			gbc.gridx = 0;
			gbc.gridy = 1;
			task.add(text,gbc);
			
			String[] datas = tasks.getExpected_date().split("-");
			String rightDate  = datas[2] + "/" + datas[1] + "/" + datas[0];
			
			JLabel date = new JLabel();
			date.setText(rightDate);
			gbc.gridx = 1;
			gbc.gridy = 1;
			task.add(date,gbc);
			
			JButton btnRemove = new JButton();
			btnRemove.setText("Remover");
			gbc.insets = new Insets(1,1,1,1);
			gbc.ipadx = 2;
			gbc.gridx = 0;
			gbc.gridy = 3;
			gbc.anchor = GridBagConstraints.CENTER;
			btnRemove.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("id = " + tasks.getId());
					taskDAO.removeTaskDone(tasks);
					removeAll();
					initialize();
					revalidate();
					updateUI();
				}
				
			});
			task.add(btnRemove,gbc);
			
			if(tasks.getDone() != 1){
				
				JButton btnEdit = new JButton();
				btnEdit.setText("Editar");
				gbc.gridx = 1;
				gbc.gridy = 3;
				gbc.anchor = GridBagConstraints.CENTER;
				btnEdit.addActionListener(new ActionListener(){
					
					@Override
					public void actionPerformed(ActionEvent e){
						
					String a = JOptionPane.showInputDialog(task, "new Name", tasks.getName());
					String b = JOptionPane.showInputDialog(task, "new Description", tasks.getDescription());
					
					String[] y = tasks.getExpected_date().split("-");
					String y2 = y[2] + "/" + y[1] + "/" + y[0]; 
					
					String c = JOptionPane.showInputDialog(task, "new date", y2);
					
					
					
					String[] x = c.split("/");
					c = x[2] + "-" + x[1] + "-" +x[0];
					
					taskDAO.editTask(tasks.getId(),a,b,c);
					removeAll();
					initialize();
					revalidate();
					repaint();
					}
				});
				task.add(btnEdit,gbc);
			}
			
			i += 1;
		
		}
	}
}
