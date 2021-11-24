## 管理员管理                ip+"/admin"

#### 1、管理员登录           "/login"            post

- 传入数据：

  ```json
  "data":{
  
  	"admin_number":"value",
  
  	"admin_pass":"value"
  
  }
  ```

  

- 传回数据：

  ```json
  {
  
  	"state":  true/false/404,
  
  	"msg" : "结果",
  
  	"token":  "token登录信息"
  
  }
  ```
  
  

#### 2、管理员添加        "/addAdmin"            post

- 传入数据：

  ```json
  "data":{
  
  	"admin_name":"value",
  
  	"admin_number":"value",
  
  	"admin_pass":"value"
  
  }
  ```

  

- 传回数据：

  ```json
  {
  
  	"state":  true / false/404,
  
  	"msg" : "结果"
  
  }
  ```
  
  

#### 3、获取管理员列表       "/getAdmins"            post

- 传入数据：

  无

- 传回数据：

  ```json
  {
  
  	"state":  true / false/404,
  
  	"admins" : "结果集（管理员表数据集）"
  
  }
  ```
  
  

#### 4、删除管理员        “/delete_Admin”     post

- 传入数据：

  ```json
  "data":{
  
  	"admin_id":"value",
  
  }
  ```

  

- 传回数据：

  ```json
  {
  
  	"state":  true / false / 404,
  
  	"msg" : "结果"
  
  }
  ```
  
  

#### 5、token验证         “/token”    post

- 传入数据：

  ```json
  "data":{
  
  	"token":"value",
  
  }
  ```

  

- 传回数据：

  ```json
  {
  
  	"state":  true / false/404,
  
  	"msg" : "结果",
  
  	"token":  "token登录信息"
  
  }
  ```
  
  



#### 6、数据库设计

|    字段名    |  类型   |    注释    |
| :----------: | :-----: | :--------: |
|   admin_id   |   int   |  管理员id  |
|  admin_name  | varchar | 管理员姓名 |
| admin_number | varchar | 管理员账号 |
|  admin_pass  | varchar | 管理员密码 |
|     role     | varchar | 管理员权限 |



## 用户管理        ip+"/user"

#### 1、获取用户列表         "/getUsers"    POST

- 传入数据：

  无

- 传回数据：

  ```json
  {
  
  	"state":  true / false / 404,
  
  	"users" : "结果集（用户表数据集）"
  
  }
  ```
  
  

#### 2、删除用户              "/deleteUser"    POST

- 传入数据：

  ```json
  "data":{
  
  	"userId" : "value"
  
  }
  ```

  

- 传回数据：

  ```json
  {
  
  	"state":  true / false / 404,
  
  	"msg" : "结果"
  
  }
  ```
  
  

#### 3、升级用户权限         "/up_User"    POST

- 传入数据：

  ```json
  "data":{
  
  	"userId" : "value"
  
  }
  ```

  

- 传回数据：

  ```json
  {
  
  	"state":  true / false / 404,
  
  	"msg": "结果"
  
  }
  ```
  
  

#### 4、降低用户权限       "/down_User"    POST

- 传入数据：

  ```json
  "data":{
  
  	"userId" : "value"
  
  }
  ```

  

- 传回数据：

  ```json
  {
  
  	"state":  true / false / 404,
  
  	"msg": "结果"
  
  }
  ```

  

#### 5、数据库设计

|   字段名   |   类型    |     注释     |
| :--------: | :-------: | :----------: |
|   userId   |    int    |    用户id    |
|  userName  |  varchar  |   用户姓名   |
|  userPass  |  varchar  |   用户账号   |
| userEmail  |  varchar  |   用户邮箱   |
|   roleId   | timestamp |   用户权限   |
| registTime | timestamp | 用户注册时间 |
| userPhoto  |  varchar  | 上次登录时间 |

## Spider管理    ip + “/spider”

#### 1、获取spider列表         "/getAll"    POST

- 传入数据：

  无

- 传回数据：

  ```json
  {
      "success":true / false, 
  	"code":200 / 500, 
  	"msg":数据获取成功！/..., 
  	"data":[]
  }
  ```

  

#### 2、获取单个spider记录              "/get"    POST

- 传入数据：

  ```json
  "data":{
  
  	"spiderId" : "value"
  
  }
  ```

- 返回数据：

  ```json
  {
      "success":true / false, 
  	"code":200 / 500, 
  	"msg":数据查询成功！/..., 
  	"data":{
      	"spider":{},
  		"img_path":[]
  	}
  }
  ```

  

#### 3、更新一条spider记录          “/updata”   POST

- 传入数据：

  ```json
  data:{
      "spiderId": "value",
  	"spiderName":"value",
  	"spiderPhoto":"value",
  	"spiderSample":"value",
  	"spiderDetails":"value"
  }
  ```

- 返回数据

  ```json
  {
      "success":true / false, 
  	"code":200 / 500, 
  	"msg":数据修改成功！/..., 
  	"data":[]
  }
  ```

#### 4、删除一条spider记录          “/delete”   POST

- 传入数据：

  ```json
  "data":{
      "spiderId": "value",
  }
  ```

- 返回数据

  ```json
  {
      "success":true / false, 
  	"code":200 / 500, 
  	"msg":数据删除成功！/..., 
  	"data":[]
  }
  ```

#### 5、插入一条spider记录      “/insert”   POST

- 传入数据

  ```json
  "data":{
      "spiderName":"value",
  	"spiderDetails":"value",
  }
  ```
  
- 返回数据

  ```json
  {
      "success":true / false, 
  	"code":200 / 500, 
  	"msg":"数据添加成功！/...", 
  	"data":{
      	"spiderId":"",
      	"spiderName":"value",
  		"spiderDetails":"value",
      	"spiderPhoto":"图片存储文件夹",
      	"spiderDetails":""
  	}
  }
  ```

#### 6、插入图片      “/image”   POST

- 传入数据

  ```json
  "data":{
      "spiderPhoto":"存储文件夹",
  	"file":"图片文件",
  }
  ```

- 返回数据

  ```json
  {
      "success":true / false, 
  	"code":200 / 500, 
  	"msg":"数据添加成功！/...", 
  	"data":[]
  }
  ```

  

#### 7、数据库设计

|     字段名     |    类型    |   注释   |
| :------------: | :--------: | :------: |
|    spiderId    | intvarchar |  种类id  |
| spiderNamename |  varchar   | 蜘蛛名称 |
|  spiderPhoto   |  varchar   | 蜘蛛图片 |
|  spiderSample  |    int     | 样本数量 |
| spiderDetails  |  varchar   | 详情介绍 |





