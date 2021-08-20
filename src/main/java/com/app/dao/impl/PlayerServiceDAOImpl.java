package com.app.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import org.apache.log4j.Logger;

import com.app.dao.PlayerServiceDAO;
import com.app.dao.dbutil.MysqlConnection;
import com.app.exception.BusinessException;
import com.app.model.Player;
import com.app.model.Team;

public class PlayerServiceDAOImpl implements PlayerServiceDAO{

	private static Logger log=Logger.getLogger(PlayerServiceDAOImpl.class);
	public Player getPlayerById(int id) throws BusinessException {
		Player player=null;
		try(Connection connection = MysqlConnection.getConnection()){
			String sql="Select p.id,name,age,gender,city,sportName,contact,teamName,team_id from player p join team t on p.team_id=t.id where p.id=?";
			PreparedStatement preparedstatement=connection.prepareStatement(sql);
			preparedstatement.setInt(1, id);
			ResultSet resultSet=preparedstatement.executeQuery();
			if(resultSet.next()) {
				player=new Player();
				player.setId(id);
				player.setName(resultSet.getString("name"));
				player.setAge(resultSet.getInt("age"));
				player.setGender(resultSet.getString("gender"));
				player.setCity(resultSet.getString("city"));
				player.setSportsName(resultSet.getString("sportName"));
				player.setContactl(resultSet.getLong("contact"));
				Team team=new Team();
				team.setId(resultSet.getInt("id"));
				team.setName(resultSet.getString("name"));
				player.setTeam(team);
			}
			else {
				throw new BusinessException("Player id "+id+" does not exist");
			}
			
		}
		catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured, Contact to Your Admin!");
		}
		// TODO Auto-generated method stub
		return player;
	}

	public List<Player> getPlayerByName(String name) throws BusinessException {
		List<Player> playerList=new ArrayList<>();
		Player player=null;
		try(Connection connection = MysqlConnection.getConnection()){
			String sql="Select p.id,name,age,gender,city,sportName,contact,team_id from player p join team t on p.team_id=t.id where p.name=?";
			PreparedStatement preparedstatement=connection.prepareStatement(sql);
			preparedstatement.setString(1, name);
			ResultSet resultSet=preparedstatement.executeQuery();
			while(resultSet.next()) {
				player=new Player();
				player.setId(resultSet.getInt("id"));
				player.setName(resultSet.getString("name"));
				player.setAge(resultSet.getInt("age"));
				player.setGender(resultSet.getString("gender"));
				player.setCity(resultSet.getString("city"));
				player.setSportsName(resultSet.getString("sportName"));
				player.setContactl(resultSet.getLong("contact"));
				Team team=new Team();
				team.setId(resultSet.getInt("id"));
				team.setName(resultSet.getString("name"));
				player.setTeam(team);
				playerList.add(player);
			}
			if(playerList.size()==0){
				throw new BusinessException("Player name "+name+" does not exist");
			}
			
		}
		catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured, Contact to Your Admin!");
		}
		return playerList;
	}

	public List<Player> getPlayerByGender(String gender) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Player> getPlayerByTeamName(String teamName) throws BusinessException {
		List<Player> playerList=new ArrayList<>();
		Player player=null;
		try(Connection connection = MysqlConnection.getConnection()){
			String sql="Select p.id,name,age,gender,city,sportName,contact,teamName,team_id from player p join team t on p.team_id=t.id where t.teamName=?";
			PreparedStatement preparedstatement=connection.prepareStatement(sql);
			preparedstatement.setString(1, teamName);
			ResultSet resultSet=preparedstatement.executeQuery();
			while(resultSet.next()) {
				player=new Player();
				player.setId(resultSet.getInt("id"));
				player.setName(resultSet.getString("name"));
				player.setAge(resultSet.getInt("age"));
				player.setGender(resultSet.getString("gender"));
				player.setCity(resultSet.getString("city"));
				player.setSportsName(resultSet.getString("sportName"));
				player.setContactl(resultSet.getLong("contact"));
				Team team=new Team();
				team.setId(resultSet.getInt("team_id"));
				team.setName(resultSet.getString("teamName"));
				player.setTeam(team);
				playerList.add(player);
			}
			if(playerList.size()==0){
				throw new BusinessException("No players for the team "+teamName);
			}
			
		}
		catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured, Contact to Your Admin!");
		}		
		return playerList;
	}

	public List<Player> getPlayerBySportsName(String sportName) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Player> getPlayerByCity(String city) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	public Player getPlayerByContact(Long contactl) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int addPlayer(Player player) throws BusinessException{
		int ch=0;
		try (Connection connection = MysqlConnection.getConnection()) {
			
			String sql= "insert into player(id,name,age,gender,city,sportsName,contactl) values(?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1,player.getId());
			preparedStatement.setInt(3,player.getAge());
			preparedStatement.setString(2, player.getName());
			preparedStatement.setString(4, player.getGender());
			preparedStatement.setString(6, player.getSportsName());
			preparedStatement.setLong(7, player.getContactl());
			preparedStatement.setString(5, player.getCity());
			
			ch=preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error ocurred, please contact admin!");
		}
		return ch;
	}


	
	
}
