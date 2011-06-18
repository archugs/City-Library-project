import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PublisherInfo implements ActionListener {

	Label heading, lpubid, lpub_name, lphone, laddress, lcity, lstate, lzip, error;
	TextField pub_idField, pub_nameField, phoneField, addressField, cityField, stateField, zipField;
	Button insert, exit;
	
	Connection con;
	PreparedStatement stat;
	Statement stmt;
	ResultSet rs;
	Font f;
	Panel p1;
	Frame f1;
	
	public PublisherInfo()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:ArchanaDB", "System", "Anna1Nagar1");
			stmt = con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println("Error: " +e);
		}
	}
	
	public void compshow()
	{
		f1 = new Frame("PUBLISHERS");
		p1 = new Panel();
		heading = new Label("PUBLISHERS INFORMATION");
		lpubid = new Label("Publishers ID: ");
		lpub_name = new Label("Publishers name: ");
		lphone = new Label("Phone Number: ");
		laddress = new Label("Address: ");
		lcity = new Label("City: ");
		lstate = new Label("State: ");
		lzip = new Label("zip: ");
		
		pub_idField = new TextField(6);
		pub_nameField = new TextField(50);
		phoneField = new TextField(15);
		addressField = new TextField(50);
		cityField = new TextField(50);
		stateField = new TextField(50);
		zipField = new TextField(20);
		
		insert = new Button("Insert");
		exit = new Button("Exit");
		
		p1.setLayout(null);
		heading.setBounds(250, 35, 200, 40);
		p1.add(heading);
		
		lpubid.setBounds(75,90, 200, 30);
		pub_idField.setBounds(400,90, 100, 25);
		p1.add(lpubid);
		p1.add(pub_idField);
		
		lpub_name.setBounds(75, 120, 200, 30);
		pub_nameField.setBounds(400, 120, 200, 25);
		p1.add(lpub_name);
		p1.add(pub_nameField);
		
		lphone.setBounds(75, 150, 200, 30);
		phoneField.setBounds(400, 150, 150, 25);
		p1.add(lphone);
		p1.add(phoneField);
		
		laddress.setBounds(75, 180, 200, 30);
		addressField.setBounds(400, 180, 250, 25);
		p1.add(laddress);
		p1.add(addressField);
		
		lcity.setBounds(75, 210, 200, 30);
		cityField.setBounds(400, 210, 200, 25);
		p1.add(lcity);
		p1.add(cityField);
		
		lstate.setBounds(75, 240, 200, 30);
		stateField.setBounds(400, 240, 200, 25);
		p1.add(lstate);
		p1.add(stateField);
		
		lzip.setBounds(75, 270, 200, 30);
		zipField.setBounds(400, 270, 200, 25);
		p1.add(lzip);
		p1.add(zipField);
		
		insert.setBounds(175, 350, 100, 30);
		exit.setBounds(325, 350, 100, 30);
		p1.add(insert);
		p1.add(exit);
		
		f1.add(p1);
		f1.setSize(680, 500);
		f1.setVisible(true);
		
		insert.addActionListener(this);
		exit.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getActionCommand() == "Exit")
			System.exit(0);
		if(ae.getActionCommand() == "Insert")
		{
			try
			{
				stat = con.prepareStatement("INSERT INTO Publishers VALUES(?, ?, ?, ? ,?, ?, ?)");
				String pid = pub_idField.getText();
				String pname = pub_nameField.getText();
				String pphone = phoneField.getText();
				String padd = addressField.getText();
				String pcity = cityField.getText();
				String pstate = stateField.getText();
				String pzip = zipField.getText();
				
				stat.setString(1, pid);
				stat.setString(2,pname);
				stat.setString(3, pphone);
				stat.setString(4, padd);
				stat.setString(5, pcity);
				stat.setString(6, pstate);
				stat.setString(7, pzip);
				
				stat.executeUpdate();
				pub_idField.setText("");
				pub_nameField.setText("");
				phoneField.setText("");
				addressField.setText("");
				cityField.setText("");
				stateField.setText("");
				zipField.setText("");
				
				}			
			catch(Exception e)
			{
				System.out.println("Error1 " +e);
				error.setText("Row cannot be initialized");
				
			}
		}
		
	}

	public static void main(String[] args)
	{
		PublisherInfo p = new PublisherInfo();
		p.compshow();
	}
}
