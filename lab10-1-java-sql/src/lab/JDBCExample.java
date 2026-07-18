package lab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JDBCExample {

	public static void main(String[] args) {

		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				log.debug("Driver Loaded");
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
			
			Connection conn = null;
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/com?useSSL=false", "com", "com01" );
				log.debug("connected");
			
				try (PreparedStatement delete = conn.prepareStatement("delete from customer")) {
					delete.executeUpdate();
				}

				int[] id = { 1, 2, 3 };
				String[] name = { "KIM", "PARK", "LEE" };
				String[] addr = { "Seoul", "Incheon", "Daejeon" };
			
				String sql = "INSERT INTO customer (id, name, addr) VALUES ( ?, ?, ? )";
			
				PreparedStatement pstmt = conn.prepareStatement(sql);
			
				for(int i=0; i < id.length; i++) {
					pstmt.setInt(1, id[i]);
					pstmt.setString(2, name[i]);
					pstmt.setString(3, addr[i]);
					pstmt.executeUpdate();
				}
				

			PreparedStatement select = conn.prepareStatement("SELECT id, name, addr FROM customer");
			ResultSet rset = select.executeQuery();
			
			while(rset.next()) {
				log.debug("id: {}", rset.getInt(1));
				log.debug("name: {}", rset.getString(2));
				log.debug("addr: {}", rset.getString(3));
			}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				if(conn != null) try {conn.close();} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
	}
}
