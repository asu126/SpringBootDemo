### Spring Cloud

##### Consul

- 安装
```
$ https://releases.hashicorp.com/consul/1.0.7/consul_1.0.7_linux_amd64.zip
$ unzip consul_1.0.7_linux_amd64.zip
$ sudo mv consul /usr/local/bin/consul

# 针对Consul 低版本
$ wget https://releases.hashicorp.com/consul/0.7.2/consul_0.7.2_web_ui.zip
$ unzip consul_0.7.2_web_ui.zip
$ mkdir -p /usr/share/consul
$ mv dist /usr/share/consul/ui
```

- 运行
```
consul agent -dev
```

- Eureka
https://blog.csdn.net/sunhuiliang85/article/details/76222517
