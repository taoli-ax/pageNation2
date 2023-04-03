### 专业版Idea maven运行tomcat （一）
1. pom.xml 替换为war项目`<packing>war</packing>`
2. lifeCycle中的package生成war包
3. 生成war包放到 tomcat安装目录下的webapps,运行bin下的脚本start.bat,自动解压
4. 访问项目 `localhost:8080/MyProject-1.0-SNAPSHOT_war`，成功访问后关闭服务器
5. 回到idea,发现多了一个MyProject-1.0-SNAPSHOT.war，右击运行
6. 成功部署！


### 专业版Idea maven运行tomcat （二）
1. 设置deployment为external resource
2. 选择webapp目录
3. 成功部署！

### 专业版idea maven运行tomcat (三) 推荐！！！
1. pom.xml 替换为war项目`<packing>war</packing>`
2. lifeCycle中的package生成war包
3. 设置tomcat服务器 deployment为external
4. 直接选择编译目录target下的MyProject-1.0-SNAPSHOT.war文件
5. 部署成功！



#### idea tomcat的console 乱码
在服务器**VM options**中加入`-Dfile.encoding=UTF-8`