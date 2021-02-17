package orders;

public class orders {
    int OrderID;
    int UserID;
    String Time;
    double DepartureLon;
    double DepartureLat;
    double DestinationLon;
    double DestinationLat;
    String Departure;
    String Destination;
    int RoomID;
    public orders(){}
    public orders(int OrderID, int UserID, String Time, double DepartureLon, double DepartureLat, double DestinationLon, double DestinationLat, String Departure, String Destination, int RoomID)
    {
        this.OrderID=OrderID;
        this.UserID=UserID;
        this.Time=Time;
        this.DepartureLon=DepartureLon;
        this.DepartureLat=DepartureLat;
        this.DestinationLon=DestinationLon;
        this.DestinationLat=DestinationLat;
        this.Departure=Departure;
        this.Destination=Destination;
        this.RoomID=RoomID;
    }

    public int getOrderID(){return this.OrderID;}
    public void setOrderID(int OrderID){this.OrderID=OrderID;}

    public int getUserID(){return this.UserID;}
    public void setUserID(int UserID){this.UserID=UserID;}

    public int getRoomID(){return this.RoomID;}
    public void setRoomID(int RoomID){this.RoomID=RoomID;}

    public double getDepartureLon (){return this.DepartureLon;}
    public void  setDepartureLon (double DepartureLon){this.DepartureLon =DepartureLon;}

    public double getDepartureLat (){return this.DepartureLat;}
    public void  setDepartureLat (double DepartureLat){this.DepartureLat =DepartureLat;}

    public double getDestinationLon (){return this.DestinationLon ;}
    public void  setDestinationLon (double DestinationLon){this.DestinationLon =DestinationLon;}

    public double getDestinationLat (){return this.DestinationLat ;}
    public void  setDestinationLat (double DestinationLat){this.DestinationLat =DestinationLat;}

    public String getTime (){return this.Time ;}
    public void  setTime (String Time ){this.Time =Time;}

    public String getDeparture (){return this.Departure ;}
    public void  setDeparture (String Departure){this.Departure =Departure;}

    public String getDestination (){return this.Destination ;}
    public void  setDestination (String Destination){this.Destination =Destination;}


}
