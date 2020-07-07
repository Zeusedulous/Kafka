Kafka
--------------------------------------------------------------------------------

1. **kafka study** : java原生操作

---


## kafka版本  2.0.1
    也可以在kafka/libs 下找到kafka_2.11-2.0.1-sources.jar，
    2.0.1代表kafka版本
## zookeeper版本 3.4.13
--------------------------------------------------------------------------------

### 安装

#### 一、下载安装包
Kafka官网下载安装包 http://kafka.apache.org/downloads.html
我们下载第二种（已经被编译过的）

**2.0.1**

- Released November 9, 2018
- Release Notes
- Source download: kafka-2.0.1-src.tgz (asc, sha512) ==未被编译的==
- Binary downloads:
    - Scala 2.11  - kafka_2.11-2.0.1.tgz (asc, sha512)  ==被编译过的==
    - Scala 2.12  - kafka_2.12-2.0.1.tgz (asc, sha512)  ==被编译过的==


We build for multiple versions of Scala. This only matters if you are using Scala and you want a version built for the same Scala version you use. Otherwise any version should work (2.12 is recommended).

#### 二、修改配置文件

**1， 修改server.properties**

advertised.listeners=PLAINTEXT://192.168.81.72:9092

zookeeper.connect=192.168.81.72:2181

**2、修改consumer.properties**

 bootstrap.servers=192.168.81.72:9092	

### Kakfa操作命令：

**1.启动kafka**


```
./bin/kafka-server-start.sh /config/server.properties
```

**2.后台启动**


```
nohup ./kafka-server-start.sh ../config/server.properties 1>/dev/null 2>&1 &
```


其中1>/dev/null 2>&1 是将命令产生的输入和错误都输入到空设备，也就是不输出的意思。
/dev/null代表空设备。

比如：

```
./kafka-server-start.sh ../config/server.properties 1>/data/kafka/logs/kafka.log 2>&1 &
```

**3.创建topic：zk**


```
./kafka-topics.sh --create --zookeeper 127.0.0.1:2181 --replication-factor 1 --partitions 1 --topic hello_topic
```

**4.查看所有的topic**

```
./kafka-topics.sh --list --zookeeper 127.0.0.1:2181
```

**5.发送消息：broker**

```
./kafka-console-producer.sh --broker-list 127.0.0.1:9092 --topic hello_topic
```


**6.消费消息：zk**

```
./kafka-console-consumer.sh  --bootstrap-server localhost:9092 --topic hello_topic --from-beginning
```


