package services.interfaces.remote;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import domain.Bus;
import domain.Line;
import domain.Passenger;
import domain.Station;
import domain.Stop;
import domain.User;

@Remote
public interface BusinessLogicServicesRemote {

	User identification(String email, String password);

	Boolean changePassword(User user, String oldPassword, String newPassword,
			String confirmationPassword);

	// // At this stage, we don't need this one
	// Boolean profileEmailAlreadyExistsWithoutFacebookId(Profile profile);
	//
	// // At this stage, we don't need this one
	// Passenger accountRegisterOrLoginWithFacebook(Profile profile);

	Boolean setLineStations(Line line, Map<Integer, Station> stations);

	List<Station> findStationsByLineId(Integer id);

	Boolean reportBusStop(Integer nbFreePlaces, Bus bus, Station station);

	List<Line> findLinesByStationId(Integer id);

	List<Bus> findBusesByLineId(Integer id);

	Boolean setLineBuses(Line line, List<Bus> buses);

	List<Bus> findAllAvailableBuses();

	Integer findStationOrderByLineId(Integer idStation, Integer idLine);

	Stop findLastStopByBusId(Integer idBus);

	List<Bus> findComingSoonBuses(String stationName);

	Bus findBusByNumber(String number);

	Station findStationByName(String name);

	Line findLineByName(String name);

	Boolean buyTicket(Passenger passenger, Station departureStation,
			Station arrivalStation, Bus bus, Double price);
	
	List<Bus> findComingSoonBusesGoingToStation(
			String departureStationName, String arrivalStationName);

}
