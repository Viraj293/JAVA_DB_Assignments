package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SwingDemo implements ActionListener {
	
	
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JButton b1,b2,b3,b4;
	
	
	
	public SwingDemo()
	{
		f = new JFrame("student registration form");
		f.setVisible(true);
		f.setResizable(false);
		f.setLayout(null);
		f.setSize(500,600);
		
		
		l1 = new  JLabel("id");
		l2 = new  JLabel("name");
		l3 = new  JLabel("surname");
		l4 = new  JLabel("email");
		l5 = new  JLabel("mobile");
		l6 = new  JLabel("city");
		l7 = new  JLabel("state");
		
		t1 = new JTextField(50);
		t2 = new JTextField(50);
		t3 = new JTextField(50);
		t4 = new JTextField(50);
		t5 = new JTextField(50);
		t6 = new JTextField(50);
		t7 = new JTextField(50);
				
		b1 = new JButton("INSERT");
		b2 = new JButton("SEARCH");
		b3 = new JButton("UPDATE");
		b4 = new JButton("DELET");
		
	    f.add(l1);
	    f.add(l2);
	    f.add(l3); 
	    f.add(l4);
	    f.add(l5);
	    f.add(l6);
	    f.add(l7);
	    
	    
	    f.add(t1);
	    f.add(t2);
	    f.add(t3);
	    f.add(t4);
	    f.add(t5);
	    f.add(t6);
	    f.add(t7);
	    
	    
	    f.add(b1);
	    f.add(b2); 
	    f.add(b3);
	    f.add(b4);
	    
	    
	    l1.setBounds(50, 50, 100, 50);
		l2.setBounds(50, 100, 100, 50);
		l3.setBounds(50, 150, 100, 50);
		l4.setBounds(50, 200, 100, 50);
		l5.setBounds(50, 250, 100, 50);
		l6.setBounds(50, 300, 100, 50);
		l7.setBounds(50, 350, 100, 50);
		
		
		t1.setBounds(150,60, 230, 30);
		t2.setBounds(150,110, 230, 30);
		t3.setBounds(150,160 , 230, 30);
		t4.setBounds(150,210, 230, 30);
		t5.setBounds(150, 260, 230, 30);
		t6.setBounds(150, 310, 230, 30);
		t7.setBounds(150, 360, 230, 30);
		
		
		
		b1.setBounds(70, 420, 100, 30);
		b2.setBounds(190, 420, 100, 30);
		b3.setBounds(70, 470, 100, 30);
		b4.setBounds(190, 470, 100, 30); 
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
		
	}
	
	
	public static void main(String[] args) {
		
		 new SwingDemo();
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1)
		{
			
			
			

			try {
				     // 1. IMPORT THE DRIVER
				Class.forName("com.mysql.jdbc.Driver");
			
			
			         //2. ESTSBLISH THE CONNECTION
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_database","root","");	
				
			         //3. WRITE THE QUERY
			String sql = "insert into student(name,surname,email,mobile,city,state) values (?,?,?,?,?,?)";
			
			         //4. PREPARE THE STATMENT
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,t2.getText());
			pst.setString(2,t3.getText());
			pst.setString(3 ,t4.getText());
			pst.setLong(4,Long.parseLong(t5.getText()));
			pst.setString(5 ,t6.getText());
			pst.setString(6 ,t7.getText());
			
			
			          //5. EXECUTE THE QUERY
	         pst.executeUpdate();
				
			           //6. CLOSE THE CONNECTION
	JOptionPane.showMessageDialog(f,"DATA INSERT");
	t2.setText("");	
	t3.setText("");	
	t4.setText("");	
	t5.setText("");	
	t6.setText("");	
	t7.setText("");	

			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
			
		}
		else if(ae.getSource()==b2)
		{
			
			try {
				
				
				// 1. IMPORT THE DRIVER
				Class.forName("com.mysql.jdbc.Driver");
			
			
			//2. ESTSBLISH THE CONNECTION
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_database","root","");
			
			//3. WRITE THE QUERY
				
				String sql = ("select * from student where id = ?");
			//4. PREPARE THE STATMENT
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setInt(1,Integer.parseInt(t1.getText()));
			//5. EXECUTE THE QUERY
				
				ResultSet rs = pst.executeQuery();
				if(rs.next())
				{
					t2.setText(rs.getString("name"));
					t3.setText(rs.getString("surname"));
					t4.setText(rs.getString("email"));
					t5.setText(rs.getString("mobile"));
					t6.setText(rs.getString("city"));
					t7.setText(rs.getString("state"));
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(f,"ID NOT FOUND");
				}
			//6. CLOSE THE CONNECTION
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		else if(ae.getSource()==b3)
		{
			
			try {
				// 1. IMPORT THE DRIVER
				Class.forName("com.mysql.jdbc.Driver");
		
			
			//2. ESTSBLISH THE CONNECTION
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_database","root","");
			//3. WRITE THE QUERY
			String sql= "update student set name = ?, surname = ?, email = ?, mobile=?, city = ? , state =  ? where id = ?";
			
			//4. PREPARE THE STATMENT
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,t2.getText());
			pst.setString(2,t3.getText());
			pst.setString(3,t4.getText());
			pst.setLong(4,Long.parseLong(t5.getText()));
			pst.setString(5,t6.getText());
			pst.setString(6,t7.getText());
			pst.setInt(7,Integer.parseInt(t1.getText()));
			
			
			//5. EXECUTE THE QUERY
			pst.executeUpdate();
			
			
			//6. CLOSE THE CONNECTION
			JOptionPane.showMessageDialog(f,"DATA UPDATED SUCCESFULL");
			
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			t7.setText("");
			
			
			
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
		
		
		else if(ae.getSource()==b4)
		{
			
			try {
				
				// 1. IMPORT THE DRIVER
				Class.forName("com.mysql.jdbc.Driver");
			
			
			//2. ESTSBLISH THE CONNECTION
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_database","root","");
			
			//3. WRITE THE QUERY
			String sql = "delete from student where id= ?";
			
			//4. PREPARE THE STATMENT
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1,Integer.parseInt(t1.getText()));
			
			//5. EXECUTE THE QUERY
			pst.executeUpdate();
			
			
			//6. CLOSE THE CONNECTION
			JOptionPane.showMessageDialog(f,"DATA DELET SUCCESFULL");
			
			
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			t7.setText("");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
			
			
}}
