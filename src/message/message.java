package message;

public class message {
    int MessageID;
    int RoomID;
    int UserID;
    String UserNickname;
    String Content;
    String Time;
    public message(){};
    public message(int MessageID,int RoomID,int UserID,String UserNickname,String Content,String Time) {
        this.MessageID = MessageID;
        this.RoomID = RoomID;
        this.UserID = UserID;
        this.UserNickname = UserNickname;
        this.Content = Content;
        this.Time = Time;
    }
    public int getMessageID () {return this.MessageID ;}
    public void setMessageID (int MessageID) {this.MessageID = MessageID;}

    public int getRoomID () {return this.RoomID ;}
    public void setRoomID (int RoomID) {this.RoomID = RoomID;}

    public int getUserID () {return this.UserID ;}
    public void setUserID (int UserID) {this.UserID = UserID;}

    public String getUserNickname () {return this.UserNickname ;}
    public void setUserNickname (String UserNickname) {this.UserNickname = UserNickname;}

    public String getContent () {return this.Content ;}
    public void setContent (String Content ) {this.Content = Content;}

    public String getTime () {return this.Time ;}
    public void setTime (String Time) {this.Time = Time;}



}
