sping 学习总结：
www.manning.com/SpringinActionFourthEdition

https://www.eclipse.org/downloads/eclipse-packages/?osType=linux

https://www.cnblogs.com/tangshengwei/p/6341462.html
https://blog.csdn.net/java_2017_csdn/article/details/77450598/

https://www.cnblogs.com/xiongxx/p/6057558.html

官方：
https://spring.io/guides
http://projects.spring.io/spring-framework/#quick-start


curl https://start.spring.io/starter.tgz -d dependencies=web,actuator \
> -d language=java -d javaVersion=1.8 -d type=gradle-project -d baseDir=spring.io | tar -xzvf -

spting 实战源码运用：
```
gradle task
gradle eclipse
```

- ActiveMQ
https://www.cnblogs.com/jaycekon/p/6225058.html
./bin/activemq start
port: 8161

rabbitmq
http://www.rabbitmq.com/install-debian.html

wget -O- https://www.rabbitmq.com/rabbitmq-release-signing-key.asc | sudo apt-key add -
sudo apt-get update
sudo apt-get install rabbitmq-server