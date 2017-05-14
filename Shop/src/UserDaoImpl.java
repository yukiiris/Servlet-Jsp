import java.sql.Connection;
import java.sql.PreparedStatement;

import com.shop.user.User;

public class UserDaoImpl {

	private Connection conn = null;
	private PreparedStatement pstm = null;
	
	public UserDaoImpl(Connection conn)
	{
		this.conn = conn;
	}
	
	public boolean doCreate(User user) throws Exception
	{
		boolean isCreate = false;
		try
		{
			String sql = "INSERT INTO user(id,name,password) VALUES(?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, user.getID());
			pstm.setString(2, user.getName());
			pstm.setString(3, user.getPassword());
			
			if (pstm.executeUpdate() > 0)
			{
				isCreate = true;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return isCreate;
	}
}
