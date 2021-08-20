package com.app.search.service.impl;

import java.util.List;
import java.util.regex.*;
import com.app.dao.PlayerServiceDAO;
import com.app.dao.impl.PlayerServiceDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Player;
import com.app.search.service.PlayerSearchService;
//import com.app.dao.impl.PlayerSearchDAOImpl;

public class PlayerSearchServiceImpl implements PlayerSearchService{

	private PlayerServiceDAO playerServiceDAO=new PlayerServiceDAOImpl();
	@Override
	public Player getPlayerById(int id) throws BusinessException {
		Player player=null;
		if(id<100 || id>1000) {
			throw new BusinessException("Invalid user id"+id);
		}
		else {
			player=playerServiceDAO.getPlayerById(id);
		}
		// TODO Auto-generated method stub
		return player;
	}

	@Override
	public List<Player> getPlayerByName(String name) throws BusinessException {
		List<Player> playerList=null;
		if(name.matches("[a-zA-Z]{2,10}")) {
		playerList=playerServiceDAO.getPlayerByName(name);
		}
		else {
			throw new BusinessException("Invalid name of player"+name);
		}
		return playerList;
	}

	@Override
	public List<Player> getPlayerByGender(String gender) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> getPlayerByTeamName(String teamName) throws BusinessException {
		// TODO Auto-generated method stub
		List<Player> playerList=null;
		if(teamName.matches("[a-zA-Z]{2,10}")) {
		playerList=playerServiceDAO.getPlayerByTeamName(teamName);
		}
		else {
			throw new BusinessException("Invalid name of player"+teamName);
		}
		return playerList;

	}

	@Override
	public List<Player> getPlayerBySportsName(String sportsName) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> getPlayerByCity(String city) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getPlayerByContact(Long contactl) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int addPlayer(Player player) throws BusinessException {
		
	}

	
}
