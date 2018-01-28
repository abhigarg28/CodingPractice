package baggagesystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Abhishek Garg
 */
public class BaggageSystemMain
{
    enum Sections{
        CONVEYOR_SYSTEM, DEPARTURES, BAGS
    }

    static Graph<String> _graph = new Graph<String>();
    static ArrayList<DepartureInfo> _departureList = new ArrayList<DepartureInfo>();
    static ArrayList<BagInfo> _bags = new ArrayList<BagInfo>();

    public static void main(String[] args)
    {
        if(args[0] == null){
            System.out.println("Please mention the input file name as first argument");
        }

        Sections section = null;

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(args[0]));

            String line;
            while ((line = reader.readLine()) != null) {

                // might want to remove dependency on section name
                // cause only given information is section 1 this section 2 that
                if(line.contains("# Section: Conveyor System")){
                    section = Sections.CONVEYOR_SYSTEM;
                    continue;
                }else if(line.contains("# Section: Departures")){
                    section = Sections.DEPARTURES;
                    continue;
                }else if(line.contains("# Section: Bags")){
                    section = Sections.BAGS;
                    continue;
                }

                if(section != null){
                    switch( section ){
                        case CONVEYOR_SYSTEM:
                            processConveyorInfo(line);
                            break;
                        case DEPARTURES:
                            processDepartureInfo(line);
                            break;
                        case BAGS:
                            processBagsInfo(line);
                            break;
                        default:

                    }
                }
            }
            if(reader != null){
                reader.close();
            }

            generateOutput();

        } catch( FileNotFoundException e ) {
            e.printStackTrace();
            System.out.println("Not able to find mentioned file: " + args[1]);
        } catch( IOException e ) {
            e.printStackTrace();
            System.out.println("Not able to read mentioned input file: " + args[1]);
        }
    }

    private static void processConveyorInfo( String lineInfo )
    {
        String[] info = lineInfo.split(" ");
        _graph.addEdge(info[0], info[1], Integer.parseInt(info[2]));
    }

    private static void processDepartureInfo( String lineInfo )
    {
        String[] info = lineInfo.split(" ");
        _departureList.add(new DepartureInfo(info[0], info[1], info[2], info[3]));
    }

    private static void processBagsInfo( String lineInfo )
    {
        String[] info = lineInfo.split(" ");
        _bags.add(new BagInfo(info[0], info[1], info[2]));
    }

    private static void generateOutput()
    {
        for(BagInfo bagInfo : _bags){
            String destination = getDestinationVertex(bagInfo.getDestination());
            HashMap<String, Double> map = GraphAlgorithm.dijkstraShortestPath(_graph, bagInfo.getSource());
            System.out.print(bagInfo.getId() + " ");
            System.out.print(bagInfo.getSource() + " ");
            System.out.print(destination + " ");
            System.out.print(map.get(destination));
            System.out.println();
        }
    }

    private static String getDestinationVertex(String flightNumber){
        if(flightNumber.equals("BaggageClaim")){
            return flightNumber;
        }
        for(DepartureInfo departureInfo : _departureList){
            if(departureInfo.getFlightNumber().equals(flightNumber)){
                return departureInfo.getGateNumber();
            }
        }
        return null;
    }

}
