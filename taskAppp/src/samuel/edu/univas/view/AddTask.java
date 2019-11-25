package samuel.edu.univas.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.mysql.fabric.xmlrpc.base.Array;

import samuel.edu.univas.dao.TaskDAO;
import samuel.edu.univas.vo.Task;
//this is the panel where the user add some task.
public class AddTask extends JPanel{
	
	private JTextField nameField;
	private JTextArea descField;
	private JTextField expected_date;
	private TaskDAO taskDAO;
	private String[] x ;
	
	public AddTask() throws SQLException{
		
		taskDAO = new TaskDAO();
		initialize();
	}
	
	private void initialize(){
		
		this.setLayout(new GridBagLayout());	
		GridBagConstraints gbc = new GridBagConstraints();
		this.setBackground(Color.LIGHT_GRAY);
		
		JLabel titleAdd = new JLabel();
		titleAdd.setText("ADD TASK -- ONLY 2019");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = 2;
		this.add(titleAdd,gbc);
		
		
		JLabel nameLabel = new JLabel();
		nameLabel.setText("Name: ");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(15,15,15,15);
		this.add(nameLabel,gbc);
		
		nameField = new JTextField();
		nameField.setPreferredSize(new Dimension(200,20));
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(nameField,gbc);
		
		JLabel descLabel = new JLabel();
		descLabel.setText("Description: ");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0;
		gbc.fill = GridBagConstraints.NONE;
		this.add(descLabel,gbc);
		
		descField = new JTextArea("",10,30);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(descField,gbc);
		
		JLabel dateLabel = new JLabel();
		dateLabel.setText("Expected date:(dd/mm/yyyy) ");
		gbc.gridx = 0 ;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.NONE;
		this.add(dateLabel,gbc);
		
		expected_date = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(expected_date,gbc);
		
		
		JButton btnSave = new JButton();
		btnSave.setText("Save");
		btnSave.setPreferredSize(new Dimension(100,20));
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridwidth = 2;
		btnSave.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				saveTask();
				
			}
			
		});
		this.add(btnSave,gbc);
	}
	
	public void saveTask(){
		Task task = new Task();
		
		String exp_date = (String) expected_date.getText();
		x = exp_date.split("/");
		task.setExpected_date(x[2]+"/"+x[1]+"/"+x[0]);
		System.out.println(x[0] + x[1] + x[2]);
		
		if(checkInput(x[2])){
			
			
			task.setName(nameField.getText());
			task.setDescription(descField.getText());
			
			
			taskDAO.save(task);
		
			clearInputs();
			
		}
		
	}
	
	
	public boolean checkInput(String x){
		
		if(nameField.getText() == null || nameField.getText().trim().isEmpty()){
			JOptionPane.showMessageDialog(this,"Please insert name","Input Empty",JOptionPane.WARNING_MESSAGE);
			nameField.requestFocus();
			return false;
		}
		if(descField.getText() == null || descField.getText().trim().isEmpty()){
			JOptionPane.showMessageDialog(this,"Please insert description","Input Empty",JOptionPane.WARNING_MESSAGE);
			descField.requestFocus();
			return false;
		}
		
		return true;
	}
	
	public void clearInputs(){
		nameField.requestFocus();
		nameField.setText(null);
		descField.setText(null);
		expected_date.setText(null);
		
		JOptionPane.showMessageDialog(this,"task successfully saved ",":)",JOptionPane.INFORMATION_MESSAGE);
	}
	
}
