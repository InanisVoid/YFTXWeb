package Database;

public class userInfo {
    int id;
    int userID;
    String nickname;
    public userInfo(){}
    public userInfo(int id, int userID, String nickname){
        this.id=id;
        this.userID=userID;
        this.nickname=nickname;
    }
    public int getID(){return this.id;}
    public void setID(int id){this.id=id;}
    public int getUserID(){return this.userID;}
    public void setUserID(int userID){this.userID=userID;}
    public String getNickname(){return this.nickname;}
    public void setNickname(String nickname) {this.nickname=nickname;}
}
