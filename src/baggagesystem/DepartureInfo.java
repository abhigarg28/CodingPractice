package baggagesystem;

/**
 * @author Abhishek Garg
 */
class DepartureInfo
{
    private String _flightNumber;
    private String _gateNumber;
    private String _destination;

    // since we are not using _departureTime for anything else
    // keeping it simple to String type
    private String _departureTime;

    DepartureInfo(String flightNumber, String gateNumber, String destination, String departureTime){
        _flightNumber = flightNumber;
        _gateNumber = gateNumber;
        _destination = destination;
        _departureTime = departureTime;
    }

    String getFlightNumber()
    {
        return _flightNumber;
    }

    String getGateNumber()
    {
        return _gateNumber;
    }

    public String getDestination()
    {
        return _destination;
    }
}
