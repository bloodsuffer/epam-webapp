package ua.nure.zavizionov.SummaryTask4.web.command;

import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

public class CommandContainer {
	
	private static final Logger LOG = Logger.getLogger(CommandContainer.class);
	
	private static Map<String, Command> commands = new TreeMap<String, Command>();

	
	static{
		commands.put("login", new LoginCommand());
		commands.put("logout", new LogoutCommand());
		//commands.put("viewSettings", new ViewSettingsCommand());
		commands.put("noCommand", new NoCommand());
		commands.put("listTrains", new ListTrainsCommand());
		commands.put("listRoutes", new ListRoutesCommand());
		commands.put("listTrainInfo", new ListTrainInfoCommand());
		commands.put("listRouteComposition", new ListRouteCompositionCommand());

		
		commands.put("addStation", new AddStationCommand());
		commands.put("addRoute", new AddRouteCommand());
		commands.put("addTrain", new AddTrainCommand());
		commands.put("addWagon", new AddWagonCommand());
		commands.put("addRouteComposition", new AddRouteCompositionCommand());
		commands.put("addUser", new AddUserCommand());
		commands.put("editRoute", new EditRouteCommand());
//		commands.put("editStation", new EditStationCommand());
		commands.put("editTrain", new EditTrainCommand());
		commands.put("deleteRoute", new DeleteRouteCommand());
		commands.put("deleteRouteComposition", new DeleteRouteCompositionCommand());
//		commands.put("deleteStation", new RemoveStationCommand());
		commands.put("deleteTrain", new DeleteTrainCommand());
		commands.put("deleteWagon", new DeleteWagonCommand());
//		
		commands.put("buyTicket", new BuyTicketCommand());
		
		commands.put("setLocale", new SetLocaleCommand());
		
		
		
		//TODO
		
	}
	
	public static Command get(String commandName) {
		if (commandName == null || !commands.containsKey(commandName)) {
			LOG.trace("Command " + commandName + " not found");
			return commands.get("noCommand"); 
		}
		
		return commands.get(commandName);
	}

}
