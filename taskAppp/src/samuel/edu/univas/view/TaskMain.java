package samuel.edu.univas.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TaskMain extends JFrame{
	
	private JPanel contentPane;
	private JPanel rightPane;
	private AddTask addTask;
	private TaskList listTask;
	private PendingTask pendingTask;
	private TaskHistory taskHistory;
		
	public TaskMain (){
		setSize(800,540);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(800,540));
		setTitle("TaskApp");
		setResizable(false);
		initialize();
	}
	
	private void initialize(){
		
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		
		createLeftPanel();
		
		rightPane = new JPanel();
		rightPane.setLayout(new FlowLayout());
		contentPane.add(rightPane, BorderLayout.CENTER);
		
		try {
			taskHistory = new TaskHistory();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		rightPane.removeAll();
		rightPane.add(taskHistory);
	}
	
	private void createLeftPanel(){

		JPanel leftPanel = new JPanel();
		leftPanel.setPreferredSize(new Dimension(200,540));
		leftPanel.setBackground(Color.gray);
		leftPanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		
		JButton btnDash = new JButton();
		btnDash.setPreferredSize(new Dimension(200,125));
		btnDash.setBackground(Color.WHITE);
		ImageIcon imgPending = new ImageIcon(getClass().getResource("/taskPending.png"));
		btnDash.setIcon(imgPending);
		btnDash.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					pendingTask = new PendingTask();
				}catch(SQLException s){
					s.printStackTrace();
				}
				rightPane.removeAll();
				rightPane.add(pendingTask);
				TaskMain.this.repaint();
				rightPane.revalidate();
				
				
				JScrollPane scroll = new JScrollPane(pendingTask);
				scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				scroll.setPreferredSize(new Dimension(598,510));
				rightPane.add(scroll);
				
				
			}
			
		});
		leftPanel.add(btnDash);
		
		JButton btnAdd = new JButton();
		btnAdd.setPreferredSize(new Dimension(200,128));
		btnAdd.setBackground(Color.WHITE);
		ImageIcon imgAdd = new ImageIcon(getClass().getResource("/taskAdding.png"));
		btnAdd.setIcon(imgAdd);
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					addTask = new AddTask();
				}catch(SQLException s){
					s.printStackTrace();
				}
				rightPane.removeAll();	
				rightPane.add(addTask);
				rightPane.revalidate();
				TaskMain.this.repaint();
			}
		});
		leftPanel.add(btnAdd);
		
		JButton btnList = new JButton();
		btnList.setPreferredSize(new Dimension(200,128));
		btnList.setBackground(Color.WHITE);
		ImageIcon imgHist = new ImageIcon(getClass().getResource("/taskHistory.png"));
		btnList.setIcon(imgHist);
		btnList.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					listTask = new TaskList();
				}catch(SQLException s){
					s.printStackTrace();
				}
				rightPane.removeAll();
				rightPane.add(listTask);
				rightPane.revalidate();
				TaskMain.this.repaint();
				
				JScrollPane scroll = new JScrollPane(listTask);
				scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				scroll.setPreferredSize(new Dimension(598,510));
			
				rightPane.add(scroll);
			}
			
		});
		leftPanel.add(btnList);
		
		
		JButton btnDone = new JButton();
		btnDone.setPreferredSize(new Dimension(200,128));
		btnDone.setBackground(Color.WHITE);
		ImageIcon imgDone = new ImageIcon(getClass().getResource("/taskDone.png"));
		btnDone.setIcon(imgDone);
		btnDone.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					taskHistory = new TaskHistory();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				rightPane.removeAll();
				rightPane.add(taskHistory);
				rightPane.revalidate();
				TaskMain.this.repaint();
			}
			
		});
		leftPanel.add(btnDone);
		

		contentPane.add(leftPanel, BorderLayout.WEST);
	}

}
