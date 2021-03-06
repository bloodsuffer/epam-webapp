package ua.nure.zavizionov.SummaryTask4;

public interface Path {
	
	String ERROR_PAGE = "/WEB-INF/jsp/error_page.jsp";
	String LOGIN_PAGE = "login.jsp";
	String WELCOME_PAGE = "index.jsp";
	String REGISTER_PAGE = "/WEB-INF/jsp/all/register.jsp";;
	String LIST_TRAINS_PAGE = "/WEB-INF/jsp/all/list_trains.jsp";
	String LIST_ROUTES_PAGE = "/WEB-INF/jsp/all/list_routes.jsp";
	String LIST_WAGONS_PAGE = "/WEB-INF/jsp/all/list_train_wagons.jsp";
	String LIST_ROUTE_INFO_PAGE = "/WEB-INF/jsp/all/route_info.jsp";
	String TICKET_INFO = "/WEB-INF/jsp/all/ticket_info.jsp";
	
	
	
	String ADD_STATION_PAGE = "/WEB-INF/jsp/admin/add_station.jsp";
	String ADD_TRAIN_PAGE = "/WEB-INF/jsp/admin/add_train.jsp";
	String ADD_ROUTE_PAGE = "/WEB-INF/jsp/admin/add_route.jsp";
	
	String EDIT_ROUTE_PAGE = "/WEB-INF/jsp/admin/edit_route.jsp";
	String EDIT_TRAIN_PAGE = "/WEB-INF/jsp/admin/edit_train.jsp";
	
	String ADD_STATION_COMMAND = "controller?command=addStation";
	

	String LIST_TRAINS_COMMAND = "controller?command=listTrains";
	String LIST_ROUTES_COMMAND = "controller?command=listRoutes";
	String LIST_ROUTE_COMMAND = "controller?command=listRouteComposition";
	String LIST_TRAIN_WAGONS_COMMAND = "controller?command=listTrainInfo";
	String ADD_TRAIN_COMMAND = "controller?command=addTrain";
	
	
	
	
	
}
