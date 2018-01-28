package baggagesystem;

/**
 * @author Abhishek Garg
 */
class BagInfo
{
    private String _id;
    private String _source;
    private String _destination;

    BagInfo( String bagId, String source, String destination )
    {
        _id = bagId;
        _source = source;
        _destination = destination.equals("ARRIVAL") ? "BaggageClaim" : destination;
    }

    String getId()
    {
        return _id;
    }

    String getSource()
    {
        return _source;
    }

    String getDestination()
    {
        return _destination;
    }
}
