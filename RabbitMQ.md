# Rabbit 使用总结
### 安装Rabbit Server
```
wget -O- https://www.rabbitmq.com/rabbitmq-release-signing-key.asc | sudo apt-key add -
sudo apt-get update
sudo apt-get install rabbitmq-server
```

### 开启rabbitmqWeb管理插件
执行`rabbitmq-plugins enable rabbitmq_management`命令，开启Web管理插件，这样我们就可以通过浏览器来进行管理，
打开浏览器并访问：http://localhost:15672/，并使用默认用户guest登录，密码也为guest


- 参考文档：https://www.cnblogs.com/luxiaoxun/p/3918054.html
