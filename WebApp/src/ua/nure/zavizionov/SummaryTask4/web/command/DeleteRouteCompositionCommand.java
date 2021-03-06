package ua.nure.zavizionov.SummaryTask4.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.derby.client.am.SqlException;
import org.apache.log4j.Logger;

import ua.nure.zavizionov.SummaryTask4.Path;
import ua.nure.zavizionov.SummaryTask4.db.util.DBService;

public class DeleteRouteCompositionCommand extends Command {

	private static final Logger LOG = Logger
			.getLogger(DeleteRouteCompositionCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String forward = null;
		String errorMessage = null;
		DBService service = DBService.getInstance();
		LOG.debug("Command starts");
		String routeCompositionIdString = request
				.getParameter("routeCompositionId");
		String routeIdString = request.getParameter("routeId");
		int routeCompositionId = 0;
		int routeId = 0;
		LOG.debug("Parsing info");
		try {
			routeCompositionId = Integer.parseInt(routeCompositionIdString);
			routeId = Integer.parseInt(routeIdString);
		} catch (NumberFormatException e) {
			LOG.error("Error during parsing", e);
			errorMessage = "Wrong input data format.";
			request.setAttribute("errorMessage", errorMessage);
			forward = Path.ERROR_PAGE;
			return forward;
		}

		try {
			service.deleteRouteComposition(routeCompositionId);
		} catch (SqlException e) {
			LOG.error("Error occured", e);
			errorMessage = "Error occured while deleting.";
			request.setAttribute("errorMessage", errorMessage);
			return Path.ERROR_PAGE;
		}

		LOG.debug("Command finished");
		response.sendRedirect(Path.LIST_ROUTE_COMMAND + "&routeId=" + routeId);
		return forward;
	}
}
