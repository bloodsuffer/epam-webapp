package ua.nure.zavizionov.SummaryTask4.db.dao.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import ua.nure.zavizionov.SummaryTask4.db.dao.DaoFactory;
import ua.nure.zavizionov.SummaryTask4.db.dao.RouteDao;
import ua.nure.zavizionov.SummaryTask4.db.dao.UserDao;
import ua.nure.zavizionov.SummaryTask4.db.entity.Role;
import ua.nure.zavizionov.SummaryTask4.db.entity.Route;
import ua.nure.zavizionov.SummaryTask4.db.entity.RouteComposition;
import ua.nure.zavizionov.SummaryTask4.db.entity.Station;
import ua.nure.zavizionov.SummaryTask4.db.entity.User;
import junit.framework.TestCase;

public class RouteDaoTests extends TestCase {
	
	 Connection con = null;
	 private  RouteDao dao = null;
	 DaoFactory factory = DaoFactory.getInstance();
	 Route testRoute = null;
	 Station testStation1 = null;
	 Station testStation2 = null;
	
	{
		System.out.println("do");
		con = Init.getConnection();
		dao = factory.getRouteDao(con);
		testRoute = new Route();
		testStation1 = new Station();
		testStation2 = new Station();
		testStation1.setId(1);
		testStation2.setId(2);
		testRoute.setDepartureStation(testStation1);
		testRoute.setArrivalStation(testStation2);
		testRoute.setDepartureTime(new Date(1500000));
		testRoute.setArrivalTime(new Date(1000000));
		testRoute.setRouteComposition(new ArrayList<RouteComposition>());
	}

	@Test
	public void testGetSelectQuery() {
		String query = dao.getSelectQuery();
		assertNotNull(query);
		assertFalse(query.isEmpty());
	}

	@Test
	public void testGetUpdateQuery() {
		String query = dao.getUpdateQuery();
		assertNotNull(query);
		assertFalse(query.isEmpty());
	}

	@Test
	public void testGetDeleteQuery() {
		String query = dao.getDeleteQuery();
		assertNotNull(query);
		assertFalse(query.isEmpty());
	}

	@Test
	public void testGetCreateQuery() {
		String query = dao.getCreateQuery();
		assertNotNull(query);
		assertFalse(query.isEmpty());
	}

	@Test
	public void testRouteDao() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	public void testParseResultSetResultSet() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrepareStatementForInsertPreparedStatementRoute() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrepareStatementForUpdatePreparedStatementRoute() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddRoute() throws SQLException {
		Route route = dao.persist(testRoute);
		testRoute.setId(route.getId());
		testRoute.getArrivalStation().setName(route.getArrivalStation().getName());
		testRoute.getDepartureStation().setName(route.getDepartureStation().getName());
		try{
			assertEquals(route, testRoute);
		}finally{
			testRoute.setId(null);
			dao.delete(route);
		}
	}
	
	@Test
	public void testEditRoute() throws SQLException {
		Route route = dao.persist(testRoute);
		testRoute.setId(route.getId());
		testRoute.getArrivalStation().setName(route.getArrivalStation().getName());
		testRoute.getDepartureStation().setName(route.getDepartureStation().getName());
		try{
			assertEquals(route, testRoute);
			assertFalse(testRoute.getArrivalStation().equals(testStation1));
			testRoute.setArrivalStation(testStation1);
			dao.update(testRoute);
			assertEquals(dao.getByPK(testRoute.getId()).getArrivalStation(), testStation1);;
		}finally{
			testRoute.setId(null);
			dao.delete(route);
		}
	}
}
