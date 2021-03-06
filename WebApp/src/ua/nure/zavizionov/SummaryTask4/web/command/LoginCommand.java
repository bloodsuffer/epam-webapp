package ua.nure.zavizionov.SummaryTask4.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.zavizionov.SummaryTask4.Path;
import ua.nure.zavizionov.SummaryTask4.db.Roles;
import ua.nure.zavizionov.SummaryTask4.db.entity.Role;
import ua.nure.zavizionov.SummaryTask4.db.entity.User;
import ua.nure.zavizionov.SummaryTask4.db.util.DBService;

public class LoginCommand extends Command {

	private static final long serialVersionUID = 6563596502700707329L;

	private static final Logger LOG = Logger.getLogger(LoginCommand.class);

	DBService service = DBService.getInstance();

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String forward = null;
		String errorMessage = null;
		LOG.debug("Command starts");

		HttpSession session = request.getSession();

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		LOG.trace("Get parameter login: " + login);

		if (login == null || password == null || login.isEmpty()
				|| password.isEmpty()) {
			errorMessage = "Login/password cannot be empty";
			request.setAttribute("errorMessage", errorMessage);
			LOG.error("Error occured: " + errorMessage);
			forward = Path.ERROR_PAGE;
			return forward;
		}
		User user = service.findUserByLogin(login);
		if (user == null || !password.equals(user.getPassword())) {
			errorMessage = "No user with such login/password";
			request.setAttribute("errorMessage", errorMessage);
			LOG.error("Error occured: " + errorMessage);
			forward = Path.ERROR_PAGE;
			return forward;
		} else {
			Role userRole = user.getRole();
			LOG.trace("User role is " + userRole.getName());
			if (userRole.getName().equals(Roles.ADMIN.getName())) {
				forward = Path.WELCOME_PAGE;
			}

			if (userRole.getName().equals(Roles.USER.getName())) {
				forward = Path.WELCOME_PAGE;
			}

			LOG.trace("Associating session with user " + user);
			session.setAttribute("user", user);
			LOG.trace("Associating session with userRole " + userRole.getName());
			session.setAttribute("userRole", userRole);

			LOG.info("User " + user + "logged as " + userRole);

		}
		LOG.debug("Command finished");

		return forward;

	}

}
