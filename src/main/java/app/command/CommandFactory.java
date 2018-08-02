package app.command;

import app.command.executor.*;
import org.apache.log4j.Logger;

/**
 * Factory pattern realization class.
 * Singleton
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class CommandFactory {

	private static final Logger LOGGER = Logger.getLogger(LoginCommand.class);

	private static volatile CommandFactory instance;
    private CommandFactory() {
    }

    /**
     * Returns the only one CommandFactory object.
     * @return CommandFactory singleton.
     */
    public static CommandFactory getInstance(){
        if(instance == null){
            synchronized(CommandFactory.class) {
                if (instance == null) instance = new CommandFactory();
            }
        } return instance;
    }

    /**
     * Creates the needed command according to name.
     * @param hiddenCommand String name of the command.
     * @return Command
     */
	public Command getCommand(String hiddenCommand) {
		if (hiddenCommand != null) {
			LOGGER.debug("not null command");
			switch (hiddenCommand) {
			case "login": {
				LOGGER.debug("login command started");
				return new LoginCommand();
			}
			case "reg": {
				LOGGER.debug("registration command started");
				return new RegistrationCommand();
			}
			case "lang": {
			    LOGGER.debug("change language command started");
			    return new L7nCommand();
			}
			case "adminRequests": {
				LOGGER.debug("admin requests command started");
				return new AdminRequestCommand();
			}
			case "adminRooms": {
				LOGGER.debug("admin rooms command started");
				return new AdminRoomCommand();
			}
			case "adminOrders": {
			    LOGGER.debug("admin orders command started");
			    return new AdminOrderCommand();
			}
			case "adminUsers": {
                LOGGER.debug("admin users command started");
                return new AdminUserCommand();
			}
            case "userRooms": {
                LOGGER.debug("user rooms command started");
                return new UserRoomCommand();
            }
            case "userRequests": {
                LOGGER.debug("user reqequests command started");
                return new UserRequestCommand();
            }
			case "newRequest": {
                 LOGGER.debug("new user request command started");
                 return new UserNewRequestCommand();
            }
            case "createNewRequest": {
                LOGGER.debug("new uReuest command started");
                return new CreateNewRequestCommand();
            }
            case "logout": {
                LOGGER.debug("new logout command started");
                return new LogoutCommand();
            }
            case "processRequests": {
                LOGGER.debug("process request command started");
                return new AdminProcessRequestCommand();
            }
            case "processUser": {
                LOGGER.debug("process user command started");
                return new AdminProcessUserCommand();
            }
			}
		}
		return new LoginCommand();
	}
}