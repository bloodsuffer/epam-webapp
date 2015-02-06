package ua.nure.zavizionov.SummaryTask4.web.command;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.derby.client.am.SqlException;
import org.apache.log4j.Logger;

import ua.nure.zavizionov.SummaryTask4.Path;
import ua.nure.zavizionov.SummaryTask4.db.util.DBService;

public class DeleteWagonCommand extends Command {
	
	private static final Logger LOG = Logger.getLogger(DeleteWagonCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String forward = null;
		String errorMessage = null;
		DBService service = DBService.getInstance();
		LOG.debug("Command starts");
		String wagonIdString = request.getParameter("wagonId");
		String trainIdString = request.getParameter("trainId");
		int wagonId = 0;
		int trainId = 0;
		LOG.debug("Parsing info");
		try {
			wagonId = Integer.parseInt(wagonIdString);
			trainId = Integer.parseInt(trainIdString);
		} catch (NumberFormatException e) {
			LOG.error("Error during parsing", e);
			errorMessage = "Wrong input data format.";
			request.setAttribute("errorMessage", errorMessage);
			forward = Path.ERROR_PAGE;
			return forward;
		}

		try {
			service.deleteWagon(wagonId);
		}catch(SqlException e){
			LOG.error("Error occured", e);
			errorMessage = "Error occured while deleting.";
			request.setAttribute("errorMessage", errorMessage);
			return Path.ERROR_PAGE;
		}

		
		LOG.debug("Command finished");
		response.sendRedirect(Path.LIST_TRAIN_WAGONS_COMMAND + "&trainId=" + trainId);
		return forward;
	}

}
