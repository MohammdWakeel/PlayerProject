package com.app;

import java.util.*;
import java.util.Scanner;
import java.lang.Exception;
import org.apache.log4j.Logger;
import com.app.model.*;
//import com.app.dao.PlayerDao;
//import com.app.dao.TeamDAO;
//import com.app.dao.impl.PlayerDaoImpl;
//import com.app.dao.impl.TeamDAOImpl;
import com.app.exception.BusinessException;
import com.app.search.service.PlayerSearchService;
import com.app.search.service.impl.PlayerSearchServiceImpl;
import com.app.dao.impl.*;
import com.app.dao.*;


public class Main {

	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		log.info("Welcome to Indai's top Player App!");
		log.info("============================================");

		int ch = 0;
		do {
			log.info("\nWhat are you wish to do today's!");
			log.info("1)Create a player");
			log.info("2)Update a palyer");
			log.info("3)Delete a palyer");
			log.info("4)List of all palyer's");
			log.info("5)Search a palyer with various filters");
			log.info("6)Exit");
			log.info("Enter Your Choice(1-6)");

			try {
				ch = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println(e);

			}

			switch (ch) {
			case 1:
				log.info("");
				PlayerServiceDAO playerServiceDAO=new PlayerServiceDAOImpl();
				Player player=new Player(122, "Rahul", 38, "M", "Punjab", "Cricket", 9343465478l);
				try {
				if(playerServiceDAO.addPlayer(player) ==1) {
					System.out.println("Data of the player added ssuccesfully!");
					System.out.println(player);
				}
				}
				catch(BusinessException e) {
					System.out.println(e.getMessage());
				}
			}


				break;
			case 2:
				log.info("Under Construction");

				break;
			case 3:
				log.info("Under Construction");

				break;
			case 4:
				log.info("Under Construction");

				break;
			case 5:
				int option=0;
				PlayerSearchService palyerSearchService=new PlayerSearchServiceImpl();
				do {
				log.info("Welcome in your seach Player menu!");
				log.info("1) By player id");
				log.info("2) By player name");
				log.info("3) By player age");
				log.info("4) By player gender");
				log.info("5) By player city");
				log.info("6) By player teamName");
				log.info("7) By player sportsName");
				log.info("8) By player contact");
				log.info("9) Go to the main menu");
				log.info("Enter Your Choice(1-6)");

				try {
					option = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
					System.out.println(e);

				}
				
				switch(option) {
				
				case 1:
					log.info("Enter player id to get player details!");
					try {
					int id=Integer.parseInt(scanner.nextLine());
					Player player=palyerSearchService.getPlayerById(id);
					if(player!=null) {
						log.info("Player with "+id+" found given below with details...!");
						log.info(player);
					}
					}
					catch(NumberFormatException e){
						log.warn("Player id should be integer,please try again...!");
					}
					catch (BusinessException e) {
						log.warn(e.getMessage());
					}
					break;
				case 2:
					log.info("Enter player Name to get player details!");
					try {
					String name=scanner.nextLine();
					List<Player> playerList=new ArrayList<>();
					playerList=palyerSearchService.getPlayerByName(name);
					if(playerList!=null && playerList.size()>0) {
						log.info("Player with "+name+" found given below with details...!");
						log.info(playerList);
					}
					}
					catch(NumberFormatException e){
						log.warn("Player id should be integer,please try again...!");
					}
					catch (BusinessException e) {
						log.warn(e.getMessage());
					}
					break;
				case 3:
					log.info("Thank You for using our App!");
					break;
				case 4:
					log.info("Thank You for using our App!");
					break;
				case 5:
					log.info("Thank You for using our App!");
					break;
				case 6:
					log.info("Enter player Team Name to get player details!");
					String teamName=scanner.nextLine();
					try {
					List<Player> playerList=palyerSearchService.getPlayerByTeamName(teamName);
					if(playerList!=null && playerList.size()>0) {
						log.info("Total Players are "+playerList.size()+" who playing for the team "+teamName.toUpperCase()+" printing the players!");
						for(Player player:playerList) {
							log.info(player);
						}
					}
					}
					catch(BusinessException e) {
						log.warn(e.getMessage());
					}
					break;
				case 7:
					log.info("Thank You for using our App!");
					break;
				case 8:
					log.info("Thank You for using our App!");
					break;
				case 9:
					log.info("Thank You for using our App!");
					break;	
					
				}
				}while(option!=9);

				break;
			case 6:
				log.info("Thank You for using our App!");

				break;

			default:
				log.warn("Invalid choice, choice should be only number between 1 to 6!");
			}

		} while (ch != 0);
	}

}
