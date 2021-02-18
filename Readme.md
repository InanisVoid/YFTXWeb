#  Yi Fang Tong Xing (Accelerator) 企划

## Flow: 业务流程

1. 登录

2. 预约/即时 拼车

3. 选择地点以及其他

4. 匹配相近时间前往相近地点的房间

5. 有房间：拉取房间列表 /无房间、已满：创建

6. 加入房间：群聊功能



## Entity: 实体/实例(Instance)

### User

​	userID, 历史记录，发言，设置，...

### Room

​	RoomID，时间，目的地，成员，发言，设置，...

### Order

​	OrderID, 时间，目的地，出发地, RoomID

### 车/接单的？



## Data Base Tables:

1. users: userID, nickname, login, settings, ...

2. rooms: roomID, Departure time, Departure place, destination, Member, destroyed?, ...

3. userLog: userID, text, ... 

4. user_room: userID, roomID

5. user_room_message: userID, roomID, messages, ...

6. room_message: roomID, messages, ...

   

## Framework:  OLD

| Pages     | App                                        | Web                                     |
| --------- | ------------------------------------------ | --------------------------------------- |
| Login     | Login                                      | Login                                   |
| Menu      | Choose 即时/预约，用户设置，已有房间，...  |                                         |
| 即时/预约 | Choose 时间，地点，出发点; Send 信息       | Find Room/Create Room; Return room list |
| 选取房间  | 显示房间列表；选取房间； send 选取房间信息 | Return 房间信息                         |
| 群聊      | 循环请求房间信息（Room Member, Messages）  | 循环发送房间信息                        |
| 用户设置  | 设置                                       | 改user                                  |



## Interface:

| Pages    | InterfaceName                                |
| -------- | :------------------------------------------- |
| Login    | url:'http://1.15.123.232/YFTXWeb/login'      |
| Book     | url:'http://1.15.123.232/YFTXWeb/book'；     |
| Order    | url:'http://1.15.123.232/YFTXWeb/order'；    |
| Choose   | url:'http://1.15.123.232/YFTXWeb/choose'；   |
| Chatroom | url:'http://1.15.123.232/YFTXWeb/chatroom'； |
| Message  | url:'http://1.15.123.232/YFTXWeb/message'    |

## Login-Send:

UserID: Int

UserNickname：String

## Book-Send：

​	UserID: 	

​	Time:  String

​	DepartureLon: Double

​	DepartureLat: Double

​	DestinationLon: Double

​	DestinationLat: Double

## Order-Send:

UserID: Int

## Order-Get:

#####  	订单: 

​		OrderID(Int); Departure(String); Destination(String); Time ; RoomID(Int):

​	~~Orders:~~ [order1,order2,...]

## Choose-Send:

​	 OrderID: ,

​	 RoomID: ;

## Choose-Get:

​	历史记录，房间信息

##### 		History: [{}，{}，{}]

​		{} Time: ; UserID: ; UserNickname: ; Content: String; 

##### 		Room：~~{}~~

​		~~{} Member:~~ [UserID1, UserID2,...]; 

## Chatroom-Send:

​		 RoomID: ;

## Chatroom-Get:

##### 		History: [{}，{}，{}] //近50条

​		{} Time: ; UserID: ; UserNickname: ; Content: ; 



## Message-Send:

​	RoomID:; Time: ; Content: UserID: UserNickname:



## Requirements:

### 前端

#### 微信开发者工具 (1.03)

​	百度地图SDK AK: wKUfa4Zk2QZfY767GfmXWMGjpzm8DoKQ

​	不校验合法域名

### 后端

#### Java (jdk 15.0.2）/ JSP

​	Servlet框架

#### MySql (5.7) 

​	user:root password:123456

#### Apache-Tomcat (10.0.2)	



Java IDE: IDEA

MySql: navicat



## Sources：

Test Server Domain：http://yftx.tech/

Test Server IP：1.15.123.232

Interface Test:  http://yftx.tech/YFTXWeb/



## Reference:

#### 小程序开发指南：https://developers.weixin.qq.com/miniprogram/dev/framework/quickstart/

