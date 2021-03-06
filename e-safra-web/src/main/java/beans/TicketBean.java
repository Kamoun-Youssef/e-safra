package beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import services.interfaces.local.BusinessLogicServicesLocal;
import services.interfaces.local.StationServicesLocal;
import services.interfaces.local.TicketServicesLocal;
import domain.Bus;
import domain.Station;
import domain.Ticket;

@ManagedBean
@ViewScoped
public class TicketBean {
	private Date date1;
	private List<Station> stations = new ArrayList<>();

	@EJB
	private BusinessLogicServicesLocal businessLogicServicesLocal;

	@EJB
	private TicketServicesLocal ticketServicesLocal;

	@EJB
	private StationServicesLocal stationServicesLocal;

	Ticket ticket = new Ticket();
	Station stationDeparture = new Station();
	Station stationArrival = new Station();

	public String doSearchBus() {
		System.out.println("Hello");
		List<Bus> buses = businessLogicServicesLocal
				.findComingSoonBusesGoingToStation(stationDeparture.getName(),
						stationArrival.getName());
		System.out.println("size : " + buses.size());
		return "";

	}

	public Station getStationDeparture() {
		return stationDeparture;
	}

	public void setStationDeparture(Station stationDeparture) {
		this.stationDeparture = stationDeparture;
	}

	public Station getStationArrival() {
		return stationArrival;
	}

	public void setStationArrival(Station stationArrival) {
		this.stationArrival = stationArrival;
	}

	public List<Station> getStations() {
		stations = stationServicesLocal.findAllStations();
		return stations;
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}

	public Station doFindStationByName(String name) {
		return businessLogicServicesLocal.findStationByName(name);
	}

	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public String doSome() {
		return "";
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

}
