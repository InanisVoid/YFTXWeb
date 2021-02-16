package user;
public class user {
    int UserID;
    String UserNickname;
    public user(){}
    public user(int UserID, String UserNickname){
        this.UserID=UserID;
        this.UserNickname=UserNickname;
    }
    public int getUserID(){return this.UserID;}
    public void setUserID(int UserID){this.UserID=UserID;}
    public String getUserNickname(){return this.UserNickname;}
    public void setUserNickname(String UserNickname){this.UserNickname=UserNickname;}
}
