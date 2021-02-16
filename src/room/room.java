package room;

public class room {
    int RoomID;
    int MemberNum;
    double DepartureLon;
    double DepartureLat;
    double DestinationLon;
    double DestinationLat;
    String Departure;
    String Destination;
    String Time;
//    String Member;
    public room(){}
    public room(int RoomID,int MemberNum,double DepartureLon,double DepartureLat,double DestinationLon,double DestinationLat,String Departure,String Destination,String Time){
        this.RoomID=RoomID;
        this.MemberNum=MemberNum;
        this.DepartureLon=DepartureLon;
        this.DepartureLat=DepartureLat;
        this.DestinationLon=DestinationLon;
        this.DestinationLat=DestinationLat;
        this.Departure=Departure;
        this.Destination=Destination;
        this.Time=Time;
//        this.Member=Member;
    }

    public int getRoomID(){return this.RoomID;}
    public void setRoomID(int RoomID){this.RoomID=RoomID;}

    public int getMemberNum(){return this.MemberNum;}
    public void setMemberNum(int MemberNum){this.MemberNum=MemberNum;}

    public double getDepartureLon (){return this.DepartureLon;}
    public void  setDepartureLon (double DepartureLon){this.DepartureLon =DepartureLon;}

    public double getDepartureLat (){return this.DepartureLat;}
    public void  setDepartureLat (double DepartureLat){this.DepartureLat =DepartureLat;}

    public double getDestinationLon (){return this.DestinationLon ;}
    public void  setDestinationLon (double DestinationLon){this.DestinationLon =DestinationLon;}

    public double getDestinationLat (){return this.DestinationLat ;}
    public void  setDestinationLat (double DestinationLat){this.DestinationLat =DestinationLat;}

    public String getDeparture(){return this.Departure;}
    public void setDeparture(String Departure){this.Departure=Departure;}

    public String getDestination(){return this.Destination;}
    public void setDestination(String Destination){this.Destination=Destination;}

    public String getTime(){return this.Time;}
    public void setTime(String Time){this.Time=Time;}
//
//    public String getMember(){return this.Member;}
//    public void setMember(String Member){this.Member=Member;}

}
