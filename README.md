# MongodbCRUD

#### Implement the following features：

1.basic CRUD Api  
2.find commments by article id  
3.comment-like function  

#### database： articledb  
##### table ： comment  

fields	| meanings	|field type
| ---------- | :-----------:  | :-----------: |
_id	primary |ID	|ObjectId/String
articleid|	articleid	|String
content	|content	|String
userid|	userid	|String
nickname	|nickname of user|	String
createdatetime	|time	|Date
likenum|	count the likes|	Int32
replynum	|num of replies	|Int32
state	|delete or not	|String 0：invisible；1：visible；
parentid	|parent comment id	|String 0: the parent comment
