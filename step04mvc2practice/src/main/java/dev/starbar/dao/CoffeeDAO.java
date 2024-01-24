package dev.starbar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dev.starbar.model.Coffee;
import dev.starbar.util.DBUtil;

public class CoffeeDAO {
	public void add(Coffee coffee) {
		final String insertQuery = "INSERT INTO coffee (name, size, price) VALUES ( \"" + coffee.getName() + "\", \""
				+ coffee.getSize() + "\"," + coffee.getPrice() + ")";

		try (Connection con = DBUtil.getConnection(); Statement statement = con.createStatement();) {
			boolean res = statement.execute(insertQuery);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Coffee> findAll() {
		final String selectQuery = "SELECT * FROM coffee";
		List<Coffee> coffees = new ArrayList<>();

		try (Connection con = DBUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(selectQuery);
				ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				final int id = rs.getInt("id");
				final String name = rs.getString("name");
				final String size = rs.getString("size");
				final int price = rs.getInt("price");

				coffees.add(new Coffee(id, name, size, price));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return coffees;
	}

	public void updateCoffee(int id, String name, String size, int price) {
		final String updateQuery = "UPDATE COFFEE SET NAME=\"" + name + "\", " + "SIZE=\"" + size + "\", PRICE=" + price
				+ " WHERE ID=" + id;
		
		try (Connection con = DBUtil.getConnection(); Statement statement = con.createStatement();) {
			boolean res = statement.execute(updateQuery);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		final String deleteQuery = "DELETE FROM COFFEE WHERE ID="+id;
		try (Connection con = DBUtil.getConnection(); Statement statement = con.createStatement();) {
			boolean res = statement.execute(deleteQuery);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
