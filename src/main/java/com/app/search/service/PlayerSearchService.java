package com.app.search.service;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Player;

public interface PlayerSearchService {

	public Player getPlayerById(int id) throws BusinessException;
	public List<Player> getPlayerByName(String name) throws BusinessException;
	public List<Player> getPlayerByGender(String gender) throws BusinessException;
	public List<Player> getPlayerByTeamName(String teamName) throws BusinessException;
	public List<Player> getPlayerBySportsName(String sportsName) throws BusinessException;
	public List<Player> getPlayerByCity(String city) throws BusinessException;
	public Player getPlayerByContact(Long contactl) throws BusinessException;
}
