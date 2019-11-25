package samuel.edu.univas.dao;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import samuel.edu.univas.vo.Task;

public class TaskDAO {
	
	private Connection connection;
	
	public TaskDAO() throws SQLException{
		
			connection = (Connection) ConnectionUtil.getConnection();
	}
	
	
	public void save(Task task){
		
			String query = "insert into task(nome,descricao,expected_date)"
					+ "values(?,?,?)";
			
		
			try{
				PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(query);
				int index = 1;
				
				stmt.setString(index++, task.getName());
				stmt.setString(index++, task.getDescription());
				stmt.setString(index++, task.getExpected_date());
				stmt.execute();
				
				
				String query2 = "select id from task where nome= '" + task.getName() +"' and descricao= '" + task.getDescription() + "'" ;
				
				Statement stmt2 = connection.createStatement();
				ResultSet result = stmt2.executeQuery(query2);
				
				while(result.next()){
					int y = result.getInt("id");
					insertIsDone(y);
				}
				
				
			}catch(SQLException e){
				e.printStackTrace();
			}
			
	}  
	
	public void insertIsDone(int y){
			
		String query = "insert into isdone(idTask,done)" + "values(?,?)";
		
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(query);
			int index = 1;

			stmt.setLong(index++, y);
			stmt.setLong(index++, 0);
			
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Task> getAll(int x){
		
		ArrayList<Task> taskList = new ArrayList<Task>();
		
		if(x == 0){
			String query = "select t.*, i.* from task as t, isdone as i where i.idTask = t.id";
			
			try {
				Statement stmt = connection.createStatement();
				ResultSet result = stmt.executeQuery(query);
				
				while(result.next()){
					
					Task task = new Task();
					task.setId(result.getInt("id"));
					task.setName(result.getString("nome"));
					task.setDescription(result.getString("descricao"));
					task.setExpected_date(result.getString("expected_date"));
					task.setDone(result.getInt("done"));
					taskList.add(task);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(x == 1){
			String query = "select t.*, i.* from task as t, isdone as i where t.expected_date >= '2019/01/01' and t.expected_date <= '2019/01/31'"
					+ "and i.done = 0 and i.idTask = t.id";
			
			try {
				Statement stmt = connection.createStatement();
				ResultSet result = stmt.executeQuery(query);
				
				while(result.next()){
					
					Task task = new Task();
					task.setId(result.getInt("id"));
					task.setName(result.getString("nome"));
					task.setDescription(result.getString("descricao"));
					task.setExpected_date(result.getString("expected_date"));
					taskList.add(task);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(x == 2){
			String query = "select t.*, i.* from task as t, isdone as i where t.expected_date >= '2019/02/01' and t.expected_date <= '2019/02/28'"
					+ "and i.done = 0 and i.idTask = t.id";
			try {
				Statement stmt = connection.createStatement();
				ResultSet result = stmt.executeQuery(query);
				
				while(result.next()){
					
					Task task = new Task();
					task.setId(result.getInt("id"));
					task.setName(result.getString("nome"));
					task.setDescription(result.getString("descricao"));
					task.setExpected_date(result.getString("expected_date"));
					taskList.add(task);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if(x == 3){
			String query = "select t.*, i.* from task as t, isdone as i where t.expected_date >= '2019/03/01' and t.expected_date <= '2019/03/30'"
					+ "and i.done = 0 and i.idTask = t.id";
						
						try {
							Statement stmt = connection.createStatement();
							ResultSet result = stmt.executeQuery(query);
							
							while(result.next()){
								
								Task task = new Task();
								task.setId(result.getInt("id"));
								task.setName(result.getString("nome"));
								task.setDescription(result.getString("descricao"));
								task.setExpected_date(result.getString("expected_date"));
								taskList.add(task);
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
		else if(x == 4){
			String query = "select t.*, i.* from task as t, isdone as i where t.expected_date >= '2019/04/01' and t.expected_date <= '2019/04/31'"
					+ "and i.done = 0 and i.idTask = t.id";
						
						try {
							Statement stmt = connection.createStatement();
							ResultSet result = stmt.executeQuery(query);
							
							while(result.next()){
								
								Task task = new Task();
								task.setId(result.getInt("id"));
								task.setName(result.getString("nome"));
								task.setDescription(result.getString("descricao"));
								task.setExpected_date(result.getString("expected_date"));
								taskList.add(task);
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
		else if(x == 5){
			String query = "select t.*, i.* from task as t, isdone as i where t.expected_date >= '2019/05/01' and t.expected_date <= '2019/05/30'"
					+ "and i.done = 0 and i.idTask = t.id";
						
						try {
							Statement stmt = connection.createStatement();
							ResultSet result = stmt.executeQuery(query);
							
							while(result.next()){
								
								Task task = new Task();
								task.setId(result.getInt("id"));
								task.setName(result.getString("nome"));
								task.setDescription(result.getString("descricao"));
								task.setExpected_date(result.getString("expected_date"));
								taskList.add(task);
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
		else if(x == 6){
			String query = "select t.*, i.* from task as t, isdone as i where t.expected_date >= '2019/06/01' and t.expected_date <= '2019/06/30'"
					+ "and i.done = 0 and i.idTask = t.id";						
						try {
							Statement stmt = connection.createStatement();
							ResultSet result = stmt.executeQuery(query);
							
							while(result.next()){
								
								Task task = new Task();
								task.setId(result.getInt("id"));
								task.setName(result.getString("nome"));
								task.setDescription(result.getString("descricao"));
								task.setExpected_date(result.getString("expected_date"));
								taskList.add(task);
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
		else if(x == 7){
			String query = "select t.*, i.* from task as t, isdone as i where t.expected_date >= '2019/07/01' and t.expected_date <= '2019/07/31'"
					+ "and i.done = 0 and i.idTask = t.id";
						
						try {
							Statement stmt = connection.createStatement();
							ResultSet result = stmt.executeQuery(query);
							
							while(result.next()){
								
								Task task = new Task();
								task.setId(result.getInt("id"));
								task.setName(result.getString("nome"));
								task.setDescription(result.getString("descricao"));
								task.setExpected_date(result.getString("expected_date"));
								taskList.add(task);
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
		else if(x == 8){
			String query = "select t.*, i.* from task as t, isdone as i where t.expected_date >= '2019/08/01' and t.expected_date <= '2019/08/30'"
					+ "and i.done = 0 and i.idTask = t.id";						
						try {
							Statement stmt = connection.createStatement();
							ResultSet result = stmt.executeQuery(query);
							
							while(result.next()){
								
								Task task = new Task();
								task.setId(result.getInt("id"));
								task.setName(result.getString("nome"));
								task.setDescription(result.getString("descricao"));
								task.setExpected_date(result.getString("expected_date"));
								taskList.add(task);
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
		else if(x == 9){
			String query = "select t.*, i.* from task as t, isdone as i where t.expected_date >= '2019/09/01' and t.expected_date <= '2019/09/30'"
					+ "and i.done = 0 and i.idTask = t.id";						
						try {
							Statement stmt = connection.createStatement();
							ResultSet result = stmt.executeQuery(query);
							
							while(result.next()){
								
								Task task = new Task();
								task.setId(result.getInt("id"));
								task.setName(result.getString("nome"));
								task.setDescription(result.getString("descricao"));
								task.setExpected_date(result.getString("expected_date"));
								taskList.add(task);
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
		else if(x == 10){
			String query = "select t.*, i.* from task as t, isdone as i where t.expected_date >= '2019/10/01' and t.expected_date <= '2019/10/31'"
					+ "and i.done = 0 and i.idTask = t.id";						
						try {
							Statement stmt = connection.createStatement();
							ResultSet result = stmt.executeQuery(query);
							
							while(result.next()){
								
								Task task = new Task();
								task.setId(result.getInt("id"));
								task.setName(result.getString("nome"));
								task.setDescription(result.getString("descricao"));
								task.setExpected_date(result.getString("expected_date"));
								taskList.add(task);
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
		else if(x == 11){
			String query = "select t.*, i.* from task as t, isdone as i where t.expected_date >= '2019/11/01' and t.expected_date <= '2019/11/30'"
					+ "and i.done = 0 and i.idTask = t.id";						
						try {
							Statement stmt = connection.createStatement();
							ResultSet result = stmt.executeQuery(query);
							
							while(result.next()){
								
								Task task = new Task();
								task.setId(result.getInt("id"));
								task.setName(result.getString("nome"));
								task.setDescription(result.getString("descricao"));
								task.setExpected_date(result.getString("expected_date"));
								taskList.add(task);
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
		else if(x == 12){
			String query = "select t.*, i.* from task as t, isdone as i where t.expected_date >= '2019/12/01' and t.expected_date <= '2019/12/31'"
					+ "and i.done = 0 and i.idTask = t.id";						
						try {
							Statement stmt = connection.createStatement();
							ResultSet result = stmt.executeQuery(query);
							
							while(result.next()){
								
								Task task = new Task();
								task.setId(result.getInt("id"));
								task.setName(result.getString("nome"));
								task.setDescription(result.getString("descricao"));
								task.setExpected_date(result.getString("expected_date"));
								taskList.add(task);
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
		return taskList;
			
	}
	
	
	public void removeTaskDone(Task task){
		
		String query = "delete from isdone where idTask = ?" ;
				
		
		
		try {
			
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(query);
			
			stmt.setLong(1,task.getId());
			stmt.execute();
			
			removeTask(task.getId());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void removeTask(int x){
		
		String query2 = "delete from task where id = ?"; 
		
		
		
		try {
			PreparedStatement stmt2 = (PreparedStatement) connection.prepareStatement(query2);
			
			stmt2.setLong(1,x);
			stmt2.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public void taskDone(int x){
			
			String query = "update isdone set done = 1 where idTask = ?";
			
			try{
				PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(query);
				stmt.setInt(1, x);
				stmt.execute();
				
				
				
			}catch(SQLException e){
				e.printStackTrace();
			}
		
	}
	
	public int countPendingTasks(){
			
		String query = "select count(*) from isdone where done = 0";
		int x = 0;
		try{
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(query);
			System.out.println(result.getFetchSize());
			while(result.next()){
					x = result.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return x;
		
	}
	
	public int countTasksDone(){
		
		String query = "select count(*) from isdone where done = 1";
		int x = 0;
		
		try{
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(query);
			
			while(result.next()){
				x = result.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return x;
	}
	
	public void editTask(int id ,String nome, String descricao, String data){
		
		String query = "update task set nome = ? , descricao = ?, expected_date = ? where id = ? ";
		
			try{
				PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(query);
				int index = 1;
				
				stmt.setString(index++, nome);
				stmt.setString(index++,descricao);
				stmt.setString(index++, data);
				stmt.setInt(index++, id);
				
				stmt.execute();
				
				
			}catch(SQLException e){
				e.printStackTrace();
			}
		     
		
		
	}
}
