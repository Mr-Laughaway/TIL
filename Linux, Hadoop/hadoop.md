Hadoop

```빅데이터``` ```6V```

```오픈소스```, ```분산```, ```병렬```, ```파일 시스템```, ```프레임워크```, ```클러스터``` 

```HDFS```, ```MapReduce```, ```Yarn```, ```Core```, ```API```s 

- 클러스터
  - Master - Slave 구조
  - NameNode(HDFS의 namespace, meta정보)
  - DataNode(64M, 128M 데이터 블럭이 분산되어 저장)
  - 3개 Data블럭은 복제되어 저장 - 장애 허용, 대응력 높음



```bash
/usr/local/hadoop-2.7.7/start-all.sh
/usr/local/hadoop-2.7.7/stop-all.sh
```



----

#### 희수씨 필기 티빔

##### 설치 절차

### Oracle

- Oracle.com 에서 Java SE Development Kit 8u221 를 다운받는다. 리눅스 x64버전으로
- hadoop-2.7.7 다운 받고
- eclipse-jee-photon-R-linux-gtk-x86_64 도 다운 받는다.

```
[hadoop@master ~]$ su -
Password: 
Last login: Wed Jul 31 13:04:07 EDT 2019 on pts/0
[root@master ~]# cd /usr/local
[root@master local]# pwd
/usr/local
[root@master local]# tar -xvf /home/hadoop/Downloads/jdk-8u221-linux-x64.tar.gz 
[root@master local]# chown -R hadoop:hadoop /usr/local/jdk1.8.0_221/
[root@master local]# ls -al


[root@master local]# tar -xvf /home/hadoop/Downloads/eclipse-jee-photon-R-linux-gtk-x86_64.tar.gz 
[root@master local]# ls -al
[root@master local]# chown -R hadoop:hadoop /usr/local/eclipse/
[root@master local]# ls –al

[root@master local]# tar -xvf /home/hadoop/Downloads/hadoop-2.7.7.tar.gz 
[root@master local]# chown -R hadoop:hadoop /usr/local/hadoop-2.7.7/
[root@master local]# ls –al
```

를 입력 하여 압축을 푼다.

hostname이 master여야 한다. 밑의 코드를 이용하여 바꿔주자.

```
#Hostname 변경

CentOS를 처음 시작하면 다음과 같이 Hostname이 localhost로 설정됩니다.
관리해야될 서버가 한대라면 모르지만 여러대를 관리한다면 서버별로 hostname을 지정해 주는것이 좋다.
[root@master local]# hostname
을 실행하면 현재 hostname을 확인할 수 있습니다. 

hostname변경 방법은 일회성 변경과 영구적 변경 방법이 있습니다.
hostname 호스트네임 을 실행하고 hostname을 실행하면 변경된 hostname을 확인할 수 있습니다.
하지만 서버를 재시작 하는 경우 hostname이 기존 localhost로 변경될 것입니다
영구적으로  hostname을 변경하기 위해서는 
[root@master ~]# hostnamectl set-hostname  slave1
실행하면 서버가 재시장 되어도 변경된  hostname을 유지합니다.

서버를 재시작 하지 않아도 아래의 명령을 실행하고 실행중인 터미널을 닫고 다시 열면 hostname이 변경된것을 확인할 수 있습니다.
/bin/hostname -F /etc/hostname
```

# .bashrc 환경설정

[root@master local]# su hadoop [hadoop@master local]$ cd ~ [hadoop@master ~]$ vi .bash_profile



제대로 되었는지 확인한번 해보자~

1. 그후 모든 것을 끈 후 저장된 장소로 가서 가상파일을 복사한다. 전체를! 하나를 master, 하나는 slave로 저장
2. vmware 로 master를 실행하자. 실행시 위치와 이름이 바뀌었기 때문에 copied로 하자. 후에 tad 에 오른쪽 버튼을 눌러 셋팅에서 이름을 master로 이름변경하고 hostname이 master임을 확인하자
3. vmware로 slace를 실행하고, 똑같이 copied하고, 똑같이 tab에 오른쪽 버튼을 눌러 이름을 slave1로 셋팅하고 hostname을 slave1로 바꾸자.

master ipaddress 192.168.255.130

- NameNode + DataNode2

slave1 ipaddress 192.168.255.129

- Secondary+DataNode1

마스터키로 하자 `su -`

```
[root@slave1 ~]# vi /etc/hosts
192.168.255.130  master
192.168.255.129  secondary
192.168.255.129  slave1
192.168.255.130  slave2
//master 와 slave둘다 바꿔준다.
```

## ssh 설정

ssh설정시 하둡 계정이 아니 마스터 계정으로 해주어야 하기 때문에 exit를 눌러 로그아웃 후 해준다.



slave 노드에 베포할 공개키를 인증키로 복사한다!



slave에서 인증키 설정한다

```
Hadoop  home 디렉토리아래 ssh 디렉토리 생성 후 접근 권한 변경
[hadoop@slave1 ~]$ mkdir .ssh
[hadoop@slave1 ~]$ chmod 755 ~/.ssh

master 서버에서 공개 키 분배
[hadoop@master ~]$ scp ~/.ssh/authorized_keys hadoop@192.168.50.129:./.ssh/

slave 노드에 인증 키 복제 되었는지 확인
[hadoop@slave1 ~]$ ls .ssh/

master 노드에서 테스트
[hadoop@master ~]$ ssh hadoop@master date
[hadoop@master ~]$ ssh hadoop@secondary date
[hadoop@master ~]$ ssh hadoop@slave1 date
[hadoop@master ~]$ ssh hadoop@slave2 date
```

만약 실수록 인증키를 만들었다면 rm id_rsa

rm id_rsa.pub 혹은 rm -rf ./* 해주자

### 하둡 실행하는 쉘 스크립트 파일에서 필요한 환경변수 설정

```
[hadoop@master ~]$ cd /usr/local/hadoop-2.7.7/
[hadoop@master hadoop-2.7.7]$ cd etc/hadoop/
[hadoop@master hadoop]$ vi hadoop-env.sh

#자바 설치된 경로 확인 후 설정하세요
export JAVA_HOME=/usr/local/jdk1.8.0_221/
```

### slave를 설정한다

```
[hadoop@master ~]$ cd /usr/local/hadoop-2.7.7/
[hadoop@master hadoop-2.7.7]$ cd etc/hadoop/
[hadoop@master hadoop]$ vi slaves

#slave 노드 host명 등록
slave1
slave2 
//localhost는 삭제하고 저장~ 저장은 
```

### core-site.xml

vi core-site.xml 에 가서

```
[hadoop@master hadoop]$ vi core-site.xml
<?xml version="1.0"?>
<?xml-stylesheet type="text/xsl" href="configuration.xsl"?>
<!-- Put site-specific property overrides in this file. -->
<configuration>
<property>
<name>fs.default.name</name>
<value>hdfs://master:9000</value>
</property>
<property>
<name>hadoop.tmp.dir</name>
<value>/usr/local/hadoop-2.7.7/tmp</value>
</property>
</configuration>
```

로 저장

### hdfs-site.xml

vi hdfs-site.xml

```
<?xml version="1.0"?>
<?xml-stylesheet type="text/xsl" href="configuration.xsl"?>
<!-- Put site-specific property overrides in this file. -->
<configuration>
<property>
<name>dfs.replication</name>
<value>1</value>
</property>
<property>
<name>dfs.permissions.enabled</name>
<value>false</value>
</property>
<property>
<name>dfs.secondary.http.address</name>
<value>secondary:50090</value>
</property>
</configuration>
```

### mapred-site.xml

저 파일이 없기때문에 복사해와서

[hadoop@master hadoop]$ cp mapred-site.xml.template mapred-site.xml

```
<?xml version="1.0"?>
<?xml-stylesheet type="text/xsl" href="configuration.xsl"?>
<configuration>
<property>
<name>mapreduce.framework.name</name>
<value>yarn</value>
</property>
</configuration>
```

### yarn-site.xml

```
<?xml version="1.0"?>
<configuration>
<property>
<name>yarn.nodemanager.aux-services</name>
<value>mapreduce_shuffle</value>
</property>
<property>
<name>yarn.nodemanager.aux-services.mapreduce_shuffle.class</name>
<value>org.apache.hadoop.mapred.ShuffleHandler</value>
</property>
</configuration>
```

### 다른 노드 설정 파일 동기화

```bash
#마스터 노드에서
[hadoop@master ~]$ mkdir -p /usr/local/hadoop-2.7.7/tmp
[hadoop@master ~]$ mkdir -p /usr/local/hadoop-2.7.7/tmp/dfs
[hadoop@master ~]$ mkdir -p /usr/local/hadoop-2.7.7/tmp/dfs/name
[hadoop@master ~]$ mkdir -p /usr/local/hadoop-2.7.7/tmp/dfs/data
[hadoop@master ~]$ mkdir -p /usr/local/hadoop-2.7.7/tmp/mapred
[hadoop@master ~]$ mkdir -p /usr/local/hadoop-2.7.7/tmp/mapred/system
[hadoop@master ~]$ mkdir -p /usr/local/hadoop-2.7.7/tmp/mapred/local
[hadoop@master ~]$ chmod 755 /usr/local/hadoop-2.7.7/tmp/dfs

[hadoop@master ~]$ cd /usr/local/hadoop-2.7.7

[hadoop@master ~]$ rsync -av . hadoop@slave1:/usr/local/hadoop-2.7.7

[hadoop@master ~]$ cd /usr/local/hadoop-2.7.7/etc/hadoop

[hadoop@master ~]$ rsync -av . hadoop@slave1:/usr/local/hadoop-2.7.7/etc/hadoop
```

### 방화벽 설정

root 에서 ( su -)

yum install iptables-services-y 설치를 미리 하고

아래를 dport 22 아래에 추가해 주어야 한다!

아래 있는 192.168.234.0/24 에서 0전 까지는 나의 ip를 작성해주도록 하자! 255였으므로

192.168.255.0/24다

```
[root@master local]# vi /etc/sysconfig/iptables
-A INPUT -m state --state NEW -m tcp -p tcp --dport 8080 -j ACCEPT
-A INPUT -m state --state NEW -m tcp -p tcp --dport 8088 -j ACCEPT
-A INPUT -m state --state NEW -m tcp -p tcp --dport 50070 -j ACCEPT
-A INPUT -m state --state NEW -m tcp -p tcp --dport 5432 -j ACCEPT
-A INPUT -m state --state NEW -m tcp -p tcp --dport 3306 -j ACCEPT
-A INPUT -m state --state NEW -m tcp -p tcp --dport 8032 -j ACCEPT
-A INPUT -m state --state NEW -m tcp -p tcp --dport 12000 -j ACCEPT
-A INPUT -s 192.168.234.0/24 -d 192.168.234.0/24 -j ACCEPT
-A OUTPUT -s 192.168.234.0/24 -d 192.168.234.0/24 -j ACCEPT
-A INPUT -j REJECT --reject-with icmp-host-prohibited
-A FORWARD -j REJECT --reject-with icmp-host-prohibited
COMMIT
```

[root@master local]# service iptables restart 작성해서 다시 시작해주자

slave1에도 같은 설정을 해주고 양쪽다 systemctl status iptables 로 active상태를 확인하자

### Namenode포맷을 해야한다!

```
#마스터 노드에서
[hadoop@master ~]$ hadoop  namenode  -format 
```

su hadoop 하면 하둡으로 가지며

만약 위에께 안된다면

[hadoop@master ~] $ source ~/.bash_profile 해주면 위에것이 된다

### hadoop 시작

전체 한번에 시작시키는 명령어는

master의 namenode와 datanode2, slave의 secondary와 datanode1를 동시 시작!하기 위해서

```
#마스터 노드에서
[hadoop@master ~]$ cd /usr/local/hadoop-2.7.7/sbin
[hadoop@master ~]$ ls
하면 다양한 명령어가 뜬다!
[hadoop@master sbin]$  ./start-all.sh
히스토리의 경우 따로 해주어야 실행이 된다
[hadoop@master sbin]$  ./mr-jobhistory-daemon.sh start historyserver
[hadoop@master sbin]$ jps
```

해서 확인해보자~



이리 나온 상태에서 (위에는 historyserver가 빠졌다 있어야 한다)

브라우저에서

http://master:50070/dfshealth.html 를 입력해보자

livenode 를 클릭해서 라이브노드가 2개임을 확인하자

### 종료하는 방법

```bash
[hadoop@master sbin]$ ./stop-all.sh
```



---



#### 티빔 2차

### 만약 확인시 라이브노드가 1개라면 다시 설정 해 볼 내용!

1. systemctl enable iptables 를 입력하여 activedt상태인지 확인!(slave도!)

Live Node가 2개가 아닐 시

먼저 master 와 slave둘다

```bash
[hadoop@master sbin]$ ./stop-all.sh
//먼저다 스탑!
[hadoop@slave .ssh]$ cd /usr/local/
[hadoop@slave hadoop-2.7.7]$ ls
[hadoop@slave hadoop-2.7.7]$ cd tmp
[hadoop@slave tmp]$ rm -rf *
[hadoop@slave tmp]$ cd ..
[hadoop@slave hadoop-2.7.7]$ ls
//tmp 아래의 정보만 삭제! master와 slave둘다!
//그후 마스터노드에서
[hadoop@master hadoop-2.7.7]$ hadoop namenode -format
[hadoop@master sbin]$ ./start-all.sh
 //시작한 후 slave 에서 tmp 파일 아래 자료가 생기는 것을 확인 후! 브라우저에서 live node가 2개임을 확인한다!
Live Node가 2개가 아닌경우 다시 설정해볼 내용
[hadoop@master hadoop-2.7.7]$ ls
#tmp 삭제
[hadoop@master hadoop-2.7.7]$ rm -rfR tmp
[hadoop@master hadoop-2.7.7]$ ls

#Slave1 노드에서도 삭제
[hadoop@slave1 hadoop-2.7.7]$ ls
bin  include  libexec      logs        README.txt  share
etc  lib      LICENSE.txt  NOTICE.txt  sbin        tmp
[hadoop@slave1 hadoop-2.7.7]$ rm -rfR tmp
[hadoop@slave1 hadoop-2.7.7]$ ls

#master 노드에서 tmp 디렉토리 다시 생성
[hadoop@master hadoop-2.7.7]$ mkdir -p /usr/local/hadoop-2.7.7/tmp/dfs/name
[hadoop@master hadoop-2.7.7]$ mkdir -p /usr/local/hadoop-2.7.7/tmp/dfs/data
[hadoop@master hadoop-2.7.7]$ ls -R /usr/local/hadoop-2.7.7/tmp

[hadoop@master hadoop-2.7.7]$ mkdir -p /usr/local/hadoop-2.7.7/tmp/mapred/system
[hadoop@master hadoop-2.7.7]$ mkdir -p /usr/local/hadoop-2.7.7/tmp/mapred/local
[hadoop@master hadoop-2.7.7]$ ls -R /usr/local/hadoop-2.7.7/tmp

[hadoop@master hadoop-2.7.7]$rsync -av . hadoop@slave1:/usr/local/hadoop-2.7.7

[hadoop@master hadoop-2.7.7]$ cd etc/hadoop
[hadoop@master hadoop-2.7.7]$ rsync -av . hadoop@slave2:/usr/local/hadoop-2.7.7
[hadoop@master hadoop-2.7.7]$ rsync -av . hadoop@secondary:/usr/local/hadoop-2.7.7

[hadoop@master hadoop-2.7.7]$ rm -rf ./logs/yarn*
[hadoop@master hadoop-2.7.7]$ rm -rf ./logs/hadoop*

[hadoop@master ~]$ hadoop namenode -format

그 후 다시 생성하자
```

### 조심하자

#### 하둡 세이프모드 해제(비정상종료시 강제 세이프모드)

$ hadoop dfsadmin -safemode leave

## hadooop

### 하둡 분산 파일 시스템(HDFS)관리

**hadoop** **fs -옵션 …**

1. 파일 목록 보기 : ls, lsr
2. 파일 용량 확인 : du, dus
3. 파일 내용 보기 : cat, text
4. 디렉토리 생성 : mkdir
5. 파일 복사 : put, get, getmerge, cp, copyFromLocal, copyToLocal
6. 파일 이동 : mv, moveFromLocal
7. 카운트 값 조회 : count
8. 파일삭제, 디렉토리 삭제 : rm, rmr
9. 파일의 마지막 내용 확인 : tail
10. 권한 변경 : chmod, chown, chgrp
11. 0바이트파일 생성 : touchz
12. 통계 정보 조회 : stat
13. 복제 데이터 개수 변경 : setrep
14. 휴지통 비우기 : expunge
15. 파일 형식 확인 : test

```bash
[hadoop@master ~]$ hadoop fs mkdir /lab // 먼저 하둡에 파일 생성
[hadoop@master ~]$ vi test.txt
//내용 아무것이나 넣고 저장~(파일 생성한 것!)

[hadoop@master ~]$ hadoop fs -put ./test.txt /lab/
//하둡에 그 파일을 저장~

[hadoop@master ~]$ hadoop fs -ls /lab/
//저장된 파일 확인!

[hadoop@master ~]$ rm test.txt
[hadoop@master ~]$ ls
//로컬에서 삭제!

[hadoop@master ~]$ hadoop fs -get /lab/test.txt
[hadoop@master ~]$ ls
//하둡에서 파일 가져와서 다시 확인!


[hadoop@master ~]$ hadoop fs -rm /lab/test.txt
//하둡에서 그 파일을 삭제!
[hadoop@master ~]$ vi sample.txt 
//내용입력
[hadoop@master ~]$ vi sample2.txt
//내용입력

[hadoop@master ~]$ hadoop fs -put sampl* /lab/
//두개를 하둡에 올린다!
[hadoop@master ~]$ hadoop fs -ls /lab/
//잘 올라가있는지 확인!

[hadoop@master ~]$ hadoop fs -mkdir /data
[hadoop@master ~]$ hadoop fs -ls /
Found 2 items
drwxr-xr-x   - hadoop supergroup          0 2019-08-16 10:24 /data
drwxr-xr-x   - hadoop supergroup          0 2019-08-16 10:23 /lab

//data 디텍토리 생긴것을 확인!

[hadoop@master ~]$ hadoop fs -mv /lab/sample* /data/
//파일을 data디렉토리로 옮긴다!

[hadoop@master ~]$ hadoop fs -ls /lab
[hadoop@master ~]$ hadoop fs -ls /data
Found 2 items
-rw-r--r--   1 hadoop supergroup         27 2019-08-16 10:23 /data/sample.txt
-rw-r--r--   1 hadoop supergroup         22 2019-08-16 10:23 /data/sample2.txt
//옮겨진것을 확인하자

[hadoop@master ~]$ hadoop fs -getmerge /data/sample* ./sample3.txt
[hadoop@master ~]$ ls
Desktop    Downloads  Pictures  sample2.txt  sample.txt  test.txt
Documents  Music      Public    sample3.txt  Templates   Videos
[hadoop@master ~]$ cat sample3.txt
haha~ today is friday!!!!!
Tomorrow is saturday!

//두 파일이 합쳐져서 만들어진것을 확인할 수 있다!
```



### 안전모드

하둡 실행 후 ^z 나 ^s와 같이 비정상 종료를 할 경우 hadoop은 safe모드로 진입한다. 이때는 파일 복사 삭제 등이 안된다.

### 도구

### dfsadmin

hadoop dfsadmin -help 하면 다양한 관리 동작 명령어를 알 수 있다.

1. fsck : 파일 시스템 상태 체크
2. balancer : HDFS 재균형
3. deamonlog : 로그 레벨 동적 변경
4. dfsadmin : HDFS 상태 확인. HDFS 퇴거, DataNode 참가 등

### 로깅

log4j는

### 클러스터에서 노드를 추가하기

1. nclude 파일에 새 노드의 네트워크 주소를 추가한다.
   - dfs.hosts와 mapreduce.jobtracker.hosts.filename속성을 통해 하나의 공유 파일을 참조한다.
2. 네임노드에 허가된 데이터 노드 집합을 반영한다.

- `$ hadoop dfsadmin -refreshNodes`

1. 새로 허가된 태스크트래커 집합을 잡트래커에 반영한다.

- `$ hadoop mradmin -refreshNodes`

1. 새 노드가 하둡 제어 스크립트에 의해 장차 클러스터에서 사용될 수 있게 slaves 파일을 갱신한다.
2. 새로운 데이터 노드와 대스크 트래커를 시작한다.
3. 새로운 데이터 노드와 태스크 트래커가 웹 UI에 나타나는지를 확인한다.

## MapReduce Programming

1. MapReduce 프레임워크는 페타바이트 이상의 대용량 데이터를 신뢰할 수 없는 컴퓨터로 구성된 클러스터 환경에서 병렬 처리를 지원하기 위해서 개발되었습니다.
2. MapReduce프레임워크는 함수형 프로그래밍에서 일반적으로 사용되는 Map()과 Reduce() 함수 기반으로주로 구성
   - Map()은 (key, value) 쌍을 처리하여 또 다른 (key ,value) 쌍을 생성하는 함수입니다.
   - Reduce()는 맵(map)으로부터 생성된 (key, list(value)) 들을 병합(merge)하여 최종적으로 list(value) 들을 생성하는 함수입니다
   - 데이터 처리를 위한 프로그래밍 모델
   - 분산컴퓨팅에 적합한 함수형 프로그래밍
   - 배치형 데이터 처리 시스템
   - 자동화된 병렬처리 및 분산처리
   - Fault-tolerance(내고장성, 결함허용)
   - 프로그래머를 위한 추상클래스

### 용어

1. 작업(Job)

- 데이터 집합을 이용하여 Mapper와 Reducer를 실행하는 "전체 프로그램“입니다.
- 20개의 파일로부터 "Word Count"를 실행하는 것은 1개의 작업(Job)입니다.

1. 태스크(Task)

- 1개의 데이터 조각을 처리하는 1개의 Mapper 또는 Reducer의 실행입니다.
- 20개의 파일은 20개의 Map 태스크에 의해 처리됩니다.

1. 태스크 시도(Task Attempt)

- 머신 위에서 1개의 태스크를 실행하는 특정 시도입니다.
- 최소한 20개의 Map 태스크 시도들이 수행됩니다. 서버 장애 시에는 더 많은 시도들이 수행됩니다.

1. Map

- 어떤 데이터의 집합을 받아들여 데이터를 생성하는 프로세스입니다.
- 주로 입력 파일을 한 줄씩 읽어서 filtering등의 처리를 수해

1. Reduce

- Map에 의해서 만들어진 데이터를 모아서 최종적으로 원하는 결과로 만들어 내는 프로세스입니다
- 데이터 집약 처리

1. 어떤 처리든 데이터는 키(key)와 밸류(value)의 쌍으로 이루어지고, 해당 쌍의 집합을 처리한다.
2. 입력 데이터도 출력 데이터도 key-value의 집합으로 구성된다.
3. Shuffle

- Map 처리 후 데이터를 정렬해서, 같은 키를 가진 데이터를 같은 장소에 모은다.
- 슬레이브 서버 간에 네트워크를 통한 전송이 발생한다

### 이클립스 설치

```java
su - 
//root 계정
cd /usr/local

tar -xvf /home/hadoop/Downloads/eclipse-jee-photon-R-linux-gtk-x86_64.tar.gz
ls -al (로 설치 확인)
chown -R hadoop:hadoop /usr/local/eclipse/
ls -al(로 그룹명 변화 확인)
postgresql(추가해야하는 자르파일이다)
$HADOOP-HOME/share/hadoop/common/lib/common-cli-1.2.jar
$HADOOP-HOME/share/hadoop/common/hadoop-common-2.7.7.jar
$HADOOP-HOME/share/hadoop/mapreduce/hadoop-mapreduce-client-core-2.7.7.jar
$HADOOP-HOME/share/hadoop/mapreduce/lib/log4j ~.jar






package lab.hadoop.fileio;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class SingleFileWriteRead {
  public static void main(String[] args) {
	// 입력 파라미터 확인
	if (args.length != 2) {
		System.err.println("Usage: SingleFileWriteRead <filename> <contents>");
			System.exit(2);
		}

	try {
		// 파일 시스템 제어 객체 생성
		Configuration conf = new Configuration();
		FileSystem hdfs = FileSystem.get(conf);

		// 경로 체크
		Path path = new Path(args[0]);
		if (hdfs.exists(path)) {
			hdfs.delete(path, true);
		}

		// 파일 저장
		FSDataOutputStream outStream = hdfs.create(path);
		outStream.writeUTF(args[1]);
		outStream.close();

		// 파일 출력
		FSDataInputStream inputStream = hdfs.open(path);
		String inputString = inputStream.readUTF();
		inputStream.close();

		System.out.println("## inputString:" +inputString);
                . System.out.println(path.getFileSystem(conf).getHomeDirectory()); //hdfs 홈 경로
 System.out.println(path.toUri()); //패스의 파일명
 System.out.println(path.getFileSystem(conf).getUri().getPath());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
```

export 해서 jar파일을 이름을 fileio.jar 로 해서 home 에 저장하자

```bash
Hello hadoop HDFS[hadoop@master ~]$ hadoop jar ./fileio.jar test.txt "Hello hadoop HDFS"

[hadoop@master ~]$ hadoop fs -ls -R /

[hadoop@master ~]$ hadoop fs -cat test.txt 
//확인해보자!!! 잘 나오는가!?
```

#### WordCount 프로그래밍 순서

```java
package lab.hadoop.wordcount;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper  extends Mapper<LongWritable, Text, Text, IntWritable>{
	private final static IntWritable one=new IntWritable(1);
	private Text word=new Text();
	

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		
		StringTokenizer itr=new StringTokenizer(value.toString());
		while(itr.hasMoreTokens()) {
			word.set(itr.nextToken());
			context.write(word, one);
		}
	}

}
package lab.hadoop.wordcount;

import java.io.IOException;


import org.apache.hadoop.io.IntWritable;

import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer  extends Reducer<Text, IntWritable, Text, IntWritable>{
	private final static IntWritable result=new IntWritable();
	
	

	
	protected void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		
		
		int sum=0;
		for(IntWritable val: values) {
			sum+= val.get();
		}
		result.set(sum);
		context.write(key,result);
	}	

}
package lab.hadoop.wordcount;



import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class WordCount {

	public static void main(String[] args) throws Exception {
		Configuration conf= new Configuration();
		if(args.length !=2) {
			System.err.println("Usage: WordCount <input> <output>");
			System.exit(2);
		}
		Job job=new Job(conf, "WordCount");
		
		job.setJarByClass(WordCount.class);
		job.setMapperClass(WordCountMapper.class);
		job.setReducerClass(WordCountReducer.class);
		
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputValueClass(TextOutputFormat.class);
	
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		//file system control object making
		FileSystem hdfs =FileSystem.get(conf);
		
		//route check
		Path path= new Path(args[1]);
		if(hdfs.exists(path)) {
			hdfs.delete(path,true);
		}
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.waitForCompletion(true);
	}

}
```



이 과정을 실험해 보았따!

```bash
[hadoop@master ~]$ hadoop jar ./WordCount.jar /data/input.txt /output/

[hadoop@master ~]$ hadoop fs -ls -R /output
[hadoop@master ~]$ hadoop fs -cat /output/part-r-00000
로 확인해보자!!!!!
```



---



#### 티빔 3

## 항공기 정보 정리해보기

1. http://stat-computing.org/dataexpo/2009/the-data.html 에서 2007년과 2008년의 .csv파일 다운

2. 압축 풀기

   - [hadoop@master Downloads]$ bunzip2 ./2007.csv.bz2
   - [hadoop@master Downloads]$ bunzip2 ./2008.csv.bz2

3. 하둡에 파일을 만들기

   - [hadoop@master ~]$ hadoop fs -mkdir /data/airline
   - [hadoop@master ~]$ hadoop fs -put ./Downloads/2008.csv /data/airline/
   - [hadoop@master ~]$ hadoop fs -ls /data/airline (하둡에 넣은 파일 확인해보자)
   - [hadoop@master ~]$ hadoop fs -mkdir /output/airline
   - [hadoop@master ~]$ hadoop fs -ls /output

4. 이클립스에서 작업

   ```java
   package lab.hadoop.airline;
   
   import java.io.IOException;
   
   import org.apache.hadoop.io.IntWritable;
   import org.apache.hadoop.io.LongWritable;
   import org.apache.hadoop.io.Text;
   import org.apache.hadoop.mapreduce.Mapper;
   
   
   
   public class DepartureDelayCountMapper extends 
   	Mapper<LongWritable, Text, Text, IntWritable> {
   		
   	//map 출력값(value)
   		private final static IntWritable outputValue = new IntWritable(1);
   	//map 출력키(key)
   		private Text outputKey = new Text();
   	
   public void map(LongWritable key, Text value, Context context) throws IOException,InterruptedException {
   	if( key.get()>0) {
   		//콤마 구분자 분리
   		String[] colums = value.toString().split(",");
   		if(colums != null && colums.length >0) {
   			try{
   				//출력키 설정
   				outputKey.set(colums[0]+ "," +colums[1]);
   				if(!colums[15].equals("NA")) {
   					int depDelayTime =Integer.parseInt(colums[15]);
   					if(depDelayTime >0) {
                           //출력데이터 설정
   						context.write(outputKey,outputValue);
   					}
   						
   					}
   				}catch(Exception e) {
   					e.printStackTrace();
   				}
   		}
   	}
   }
   }
   ```

   ```java
   package lab.hadoop.airline;
   
   import java.io.IOException;
   
   import org.apache.hadoop.io.IntWritable;
   import org.apache.hadoop.io.Text;
   import org.apache.hadoop.mapreduce.Reducer;
   
   public class DelayCountReducer extends Reducer<Text,IntWritable, Text, IntWritable> {
   	private IntWritable result =new IntWritable();
   	//
   	public void reduce(Text key, Iterable<IntWritable>values, Context context)throws IOException, InterruptedException{
   		int sum=0;
   		for(IntWritable value: values)
   			sum+= value.get();
   		result.set(sum);
   		context.write(key, result);
   	}
   
   }
   ```

   

5. 출력할 드라이브 설정

   ```java
   package lab.hadoop.airline;
   
   
   
   import org.apache.hadoop.conf.Configuration;
   import org.apache.hadoop.fs.FileSystem;
   import org.apache.hadoop.fs.Path;
   import org.apache.hadoop.io.IntWritable;
   import org.apache.hadoop.io.Text;
   import org.apache.hadoop.mapreduce.Job;
   import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
   import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
   import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
   import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
   
   public class DepartureDelayCount {
   
   	public static void main(String[] args) throws Exception {
   		Configuration conf= new Configuration();
   		
   		if(args.length !=2) {
   			System.err.println("Usage: DepartureDelayCount <input> <output>");
   			System.exit(2);//셀 커맨드 잘못 사용시 종료!
   		}
   		FileSystem hdfs=FileSystem.get(conf);
   		//route check 
   				//경로 체크
   				Path path= new Path(args[1]);
   				if(hdfs.exists(path)) {
   					hdfs.delete(path,true);
   				}
   				
   		//job 이름 설정
   		Job job=new Job(conf, "DepartureDelayCount");
   		//입출력 데이터 경로 설정
   		FileInputFormat.addInputPath(job, new Path(args[0]));
   		FileOutputFormat.setOutputPath(job, new Path(args[1]));
   		//job 클래스 설정
   		job.setJarByClass(DepartureDelayCount.class);
           //mapper클래스 설정
   		job.setMapperClass(DepartureDelayCountMapper.class);
           //Reducer 클래스 설정
   		job.setReducerClass(DelayCountReducer.class);
   		
           //입출력 데이터 포맷 설정
   		job.setInputFormatClass(TextInputFormat.class);
   		job.setOutputValueClass(TextOutputFormat.class);
   	    //출력키 및 출력값 유형 설정
   		job.setOutputKeyClass(Text.class);
   		job.setOutputValueClass(IntWritable.class);
   		
   		job.waitForCompletion(true);
   	}
   
   }
   ```

6. 아카이브를 만들자

   - 먼저 이클립스에서 자르파일로 export하고 export 저장위치는 home아래 (main class설정! 자동으로 뜬다)
   - [hadoop@master ~]$ hadoop jar ./departure.jar /data/airline /output/airline
   - [hadoop@master ~]$ hadoop fs -ls /output/airline(파일 완료 확인)
   - [hadoop@master ~]$ hadoop fs -cat /output/airline/part-r-00000(이것으로 누적 합계를 확인!)

### 연습2

```java
package lab.hadoop.delaycount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class DelayCountMapper extends Mapper<LongWritable,Text , Text, IntWritable>{
    //<입력키 유형, 입력값 유형, 출력키 유형, 출력값 유형>을 의미


	private String workType;
	private Text outputKey =new Text();
	private final static IntWritable outputValue= new IntWritable(1);


	@Override
	protected void setup(Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {//setup은 Mapper class에서 작업시작히 한번 호출 되는 메서드

		workType=context.getConfiguration().get("workType");
	}
	
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{//입력 분할에서 각 키 / 값 쌍마다 한 번씩 호출된다.
		if (key.get()>0) {
			String[] colums=value.toString().split(",");
			if(colums !=null && colums.length>0) {
				try {
					if(workType.equals("departure")) {//실행시 옵션을 줄때 그것이 departure인가?
						if(!colums[15].equals("NA")){
							int depDelayTime=Integer.parseInt(colums[15]);
							if(depDelayTime>0) {
								outputKey.set(colums[0]+","+colums[1]);
                                //colums[0]=year colums[1]=month
                                //출력 데이터 생성
								context.write(outputKey, outputValue);
							}
						}
                        //도착 지연 데이터 출력
					}else if(workType.equals("arrival")) {//실행시 옵션을 줄때 그것이 arrival 인가?
						if(!colums[14].equals("NA")) {
							int arrDelayTime=Integer.parseInt(colums[14]);
							if(arrDelayTime>0) {
                                //출력키 설정
								outputKey.set(colums[0]+","+colums[1]);
                                //출력 데이터 생성
								context.write(outputKey, outputValue);
							}
						}
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
package lab.hadoop.delaycount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class DelayCountReducer extends Reducer<Text,IntWritable, Text, IntWritable> {
	private IntWritable result =new IntWritable();
	
	public void reduce(Text key, Iterable<IntWritable>values, Context context)throws IOException, InterruptedException{
		int sum=0;
		for(IntWritable value: values)
			sum+= value.get();
		result.set(sum);
		context.write(key, result);
	}

}
package lab.hadoop.delaycount;



import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class DelayCount extends Configured implements Tool{
	
	public int run(String[] args) throws Exception{
	
		String[] otherArgs=new GenericOptionsParser(getConf(),args).getRemainingArgs();
		//입추력 데이터 경로 확
		if(args.length !=2) {
			System.err.println("Usage: DelayCount <in> <out>");
			System.exit(2);
		}
		//job이름 설정 
		Job job=new Job(getConf(), "DelayCount");
		
		FileSystem hdfs=FileSystem.get(getConf());
		//route check 
				//경로 체크
				Path path= new Path(args[1]);
				if(hdfs.exists(path)) {
					hdfs.delete(path,true);
				}
		//입출력 데이터 경로 설
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		//job클래스 설
		job.setJarByClass(DelayCount.class);
		job.setMapperClass(DelayCountMapper.class);
		job.setReducerClass(DelayCountReducer.class);
		
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputValueClass(TextOutputFormat.class);
	
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		job.waitForCompletion(true);
        //실행시키는 코드!
		return 0;
	}
	public static void main(String[] args)throws Exception{
		//Tool 인터페이스 실행
		int res=ToolRunner.run(new Configuration(),new DelayCount(),args);
		System.out.println("##RESULT:"+res);
	}
}
```

- 실행해 보자
- [hadoop@master ~]$ hadoop fs -mkdir /output/delaycount
- [hadoop@master ~]$ hadoop jar ./delaycount.jar -D workType=arrival /data/airline /output/delaycount
  - 여기서 -D workType 은 처음 Mapper class 시 주었던 것 arrival 로
- [hadoop@master ~]$ hadoop fs -mkdir /output/delaycount2
- [hadoop@master ~]$ hadoop jar ./delaycount.jar -D workType=departure /data/airline /output/delaycount2
  - 이번에는 -D workType =departure로 해보자.

## 정렬

1. 맵리듀스의 핵심 기능
2. 하나의 리듀스 테스크만 실행되게 하면 쉽게 해결 가능 하지만, 여러 데이터 노드가 구성된 상황에서 하나의 리듀스 테스크만 실행하는 것은 분산 환경의 장점을 살리지 못하는 것!
3. 대량의 데이터를 정렬시 부하도 상당함
4. 하둡이 제공하는 정렬 방식
   - 보조 정렬,

### 보조 정렬

1. 키의 값들을 그룹핑하고, 그룹핑된 레코드에 순서를 부여
2. 구현 순서
   - 기존 키의 값들을 조합한 복합키(Composite Key)정의
   - 키의 값 중에서 그룹핑 키로 사용할 키 결정
   - 복합키의 레코드를 정렬하기 위한 비교기(comparator)정의
   - 그룹핑 키를 파티셔닝할 파티셔녀(partitioner)정의
   - 그룹 핑 키를 정렬하기 위한 비교기(Comparator)정의

```java
package lab.hadoop.sort;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableUtils;

public class DateKey implements WritableComparable<DateKey> {
	//년, 월을 키로 사용할 것(년은 문자여도 월의 경우 숫자로 해야 정렬된다..?)
	///직렬하기 위한
	private String year;
	private Integer month;
	public DateKey() {
		
	}
	public DateKey(String year, Integer month) {
		super();
		this.year = year;
		this.month = month;
	}
	@Override
	public void readFields(DataInput in) throws IOException {
		year=WritableUtils.readString(in);
		month=in.readInt();
		
	}
	@Override
	public void write(DataOutput out) throws IOException {
		WritableUtils.writeString(out, year);
		out.writeInt(month);
		
	}
	@Override
	public int compareTo(DateKey key) {
		int result = year.compareTo(key.year);
		if(0==result) {
			result=month.compareTo(key.month);
			
		}
		return result;
		
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
/*	@Override
	public String toString() {
		return (new StringBuilder()).append(year).append(",").append(month).toString();
		
	}*/
	@Override
	public String toString() {
		return "DateKey [year=" + year + ", month=" + month + "]";
	}
	
	
	
	
}
package lab.hadoop.sort;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class DateKeyComparator extends WritableComparator{
	protected DateKeyComparator() {
		super(DateKey.class,true);
	}
	@SuppressWarnings("rawtypes")
	@Override
	public int compare(WritableComparable w1, WritableComparable w2) {
		//복합키 클래스 캐스팅
		
		DateKey k1=(DateKey) w1;
		DateKey k2=(DateKey) w2;
		
		//연도 비교
		int cmp=k1.getYear().compareTo(k2.getYear());
		if(cmp !=0) {
			return cmp;
			
		}
		///월 비교
		return k1.getMonth() == k2.getMonth() ? 0:(k1.getMonth()<k2.getMonth() ? -1:1);
	}
	
}
```



그룹핑 키의 파티셔널~

```java
package lab.hadoop.sort;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class GroupKeyPartitioner extends Partitioner<DateKey, IntWritable>{

	@Override
	public int getPartition(DateKey key, IntWritable val, int numPartitions) {
		
		int hash=key.getYear().hashCode();
		int partition=hash % numPartitions;
		return partition;
	}
}
```



그룹핑 키의 비교기(comparator)

```java
package lab.hadoop.sort;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class GroupKeyComparator extends WritableComparator{
protected GroupKeyComparator() {
	super(DateKey.class,true);
}
@SuppressWarnings("rawtypes")
@Override
public int compare(WritableComparable w1, WritableComparable w2) {
	
DateKey k1=(DateKey)w1;
DateKey k2 =(DateKey)w2;
//연도값 비교
return k1.getYear().compareTo(k2.getYear());
}
}
```



enum(상수)

```java
package lab.hadoop.sort;

public enum DelayCounters {
not_available_arrival,
scheduled_arrival,
early_arrival,
not_available_departure,
scheduled_departure,
early_departure;
}
```



reducer

```java
package lab.hadoop.sort;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;

public class DelayCountReducerWithDateKey extends Reducer<DateKey,IntWritable,DateKey,IntWritable>{
	//병렬로 여러개의 아웃풋 을 생성하는 것!
	private MultipleOutputs<DateKey,IntWritable>mos;
	//reduce출력키
	private DateKey outputKey=new DateKey();
	//reduce 출력
	private IntWritable result=new IntWritable();
	
	@Override
	protected void setup(Context context)
			throws IOException, InterruptedException {
	mos=new MultipleOutputs<DateKey,IntWritable>(context);
	}
	public void reduce(DateKey key,Iterable<IntWritable> values,Context context)throws IOException,InterruptedException{
		//콤마 구분자 분리
		String[] colums =key.getYear().split(",");
		
		int sum =0;
		Integer bMonth=key.getMonth();
		
		if(colums[0].equals("D")) {
			for(IntWritable value:values) {
				if (bMonth !=key.getMonth()) {
					result.set(sum);
					outputKey.setYear(key.getYear().substring(2));
					outputKey.setMonth(bMonth);
					mos.write("departure", outputKey, result);
					sum=0;
				}
				sum+=value.get();
				bMonth=key.getMonth();
			}
			if(key.getMonth()==bMonth) {
				outputKey.setYear(key.getYear().substring(2));
				outputKey.setMonth(key.getMonth());
				result.set(sum);
				mos.write("departure", outputKey, result);
			}
		}else {
			for(IntWritable value:values) {
				if(bMonth !=key.getMonth()) {
					result.set(sum);
					outputKey.setYear(key.getYear().substring(2));
					outputKey.setMonth(bMonth);
					mos.write("arrival", outputKey, result);
					sum=0;
				}
				sum+=value.get();
				bMonth=key.getMonth();
			}
			if(key.getMonth()==bMonth) {
				outputKey.setYear(key.getYear().substring(2));
				outputKey.setMonth(key.getMonth());
				result.set(sum);
				mos.write("arrival", outputKey, result);
			}
				}
			}
	@Override
	protected void cleanup(Context context)
			throws IOException, InterruptedException {
		mos.close();
	}
	
		
	}
```



mapper

```java
package lab.hadoop.sort;


import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class DelayCountMapperWithDateKey extends Mapper<LongWritable,Text,DateKey,IntWritable> {

	//map출력값
	private final static IntWritable outputValue=new IntWritable(1);
	//
	private DateKey outputKey =new DateKey();
	
	public void map(LongWritable key,Text value,Context context)throws IOException,InterruptedException{
		if (key.get()>0) {
			//콤마 구분자 분리
			String[] colums=value.toString().split(",");
			if(colums !=null&&colums.length>0) {
				try {
					//출발지연 제이터 출력
					if(!colums[15].equals("NA")) {
						int depDelayTime=Integer.parseInt(colums[15]);
						if(depDelayTime>0) {
							//출력키 설정 
							outputKey.setYear(("D,"+colums[0]));
							outputKey.setMonth(new Integer(colums[1]));
							//출력데이터 생성
							context.write(outputKey, outputValue);
						}else if(depDelayTime==0) {
							context.getCounter(DelayCounters.scheduled_departure).increment(1);
						}else if(depDelayTime<0) {
							context.getCounter(DelayCounters.early_departure).increment(1);
						}
					}else {
						context.getCounter(DelayCounters.not_available_departure).increment(1);
					}
					//도착 지연 데이터 출력
					if(!colums[14].equals("NA")) {
						int arrDelayTime=Integer.parseInt(colums[14]);
						if(arrDelayTime>0) {
							//출력키 설정 
							outputKey.setYear(("A,"+colums[0]));
							outputKey.setMonth(new Integer(colums[1]));
							//출력데이터 생성
							context.write(outputKey, outputValue);
						}else if(arrDelayTime==0) {
							context.getCounter(DelayCounters.scheduled_arrival).increment(1);
						}else if(arrDelayTime<0) {
							context.getCounter(DelayCounters.early_arrival).increment(1);
						}
					}else {
						context.getCounter(DelayCounters.not_available_arrival).increment(1);
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
		}
	}
}
```



driver

```java
package lab.hadoop.sort;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import lab.hadoop.delaycount.DelayCount;

public class DelayCountwithDateKey extends Configured implements Tool{
	public int run(String[] args) throws Exception{
		
		String[] otherArgs=new GenericOptionsParser(getConf(),args).getRemainingArgs();
		//입추력 데이터 경로 확
		if(args.length !=2) {
			System.err.println("Usage: DelayCountwithDateKey <in> <out>");
			System.exit(2);
		}
		//job이름 설정 
		Job job=new Job(getConf(), "DelayCountWithDateKey");
		
		FileSystem hdfs=FileSystem.get(getConf());
		//route check 
				//경로 체크
				Path path= new Path(args[1]);
				if(hdfs.exists(path)) {
					hdfs.delete(path,true);
				}
		//입출력 데이터 경로 설
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		//job클래스 설
		job.setJarByClass(DelayCountwithDateKey.class);
		job.setPartitionerClass(GroupKeyPartitioner.class);
		job.setGroupingComparatorClass(GroupKeyComparator.class);
		job.setSortComparatorClass(DateKeyComparator.class);
		
		//Mapper클래스 설정
		job.setMapperClass(DelayCountMapperWithDateKey.class);
		//Reducer클래스 설
		job.setReducerClass(DelayCountReducerWithDateKey.class);
		
		job.setMapOutputKeyClass(DateKey.class);
		job.setMapOutputValueClass(IntWritable.class);
		
		//입출력 데이터 포맷 설정
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		
	
	
		//출력키 및 출력값 유형 설정 
		job.setOutputKeyClass(DateKey.class);
		job.setOutputValueClass(IntWritable.class);
		//MultipleOupputs 설정
		MultipleOutputs.addNamedOutput(job, "departure", TextOutputFormat.class, DateKey.class, IntWritable.class);
		MultipleOutputs.addNamedOutput(job, "arrival",TextOutputFormat.class,DateKey.class , IntWritable.class);
		
		
		job.waitForCompletion(true);
		return 0;
	}
	public static void main(String[] args)throws Exception{
		//Tool 인터페이스 실행
		int res=ToolRunner.run(new Configuration(),new DelayCountwithDateKey(),args);
		System.out.println("##RESULT:"+res);
	}

}
```



---



#### 복습

- 분산 컴퓨팅 필요 조건

  - **장애 허용** - 분산 클러스터  노드 중 하나에서 문제가 생겨도 메인 컴퓨팅 프로세스에 부정적인 영향을 주지 않아야 한다(프로세스 실패가 발생하지 않아야한다).

  - **복구 능력** - 분산 클러스터 노드에서 수행 중인 작업이 실패하더라도 작업으로부터 어떤 데이터도 손실 되어서는 안 된다.

  - **선형적 확장성** - 컴퓨팅 능력, 스토리지 공간 확장등, 성능도 선형적으로 증가해야 합니다.

    

- 하둡 아키텍쳐

  ```HDFS```, ```Yarn```, ```MapReduce```, etc. APIs

  

- 하둡 클러스터 

  하둡 분산 파일 시스템(***HDFS***)과 클러스터 리소스 매니저(***Yarn***)를 기반으로 하는 하둡 소프트웨어를 사용하는 컴퓨터들의 집합



- 마스터 노드

  - Hadoop 2.0부터 마스터 노드 2개 이상 구성하여 고가용성을 지원합니다(High Availability).

  - ```Active``` + ```Standby``` (***Zoo Keeper*** 같이 구성해 줘야 함)
  - 하둡 클러스터의 작업을 중재 - 하둡 클라이언트는 파일을 저장, 읽고, 처리하려면 master 노드에 접속해야합니다.
  - ***namenode*** 구성되고, 파일을 저장 쓰고, 파일시스템의 메타 정보 관리
  - ***mapreduce*** 작업의 중재하는 프로세스 JobTracker가 구성



- 워커노드(슬레이브 노드) 

  마스터 노드의 지시를 받아서 명령을 수행. 실제 데이터를 저장하고, 데이터 처리 프로세싱하는 노드.



- HDFS는 HDFS의 스토리지를 관리
  - *NameNode* - HDFS 파일 시스템 디렉토리 트리와 파일의 위치 등 HDFS 스토리지 관련 메타 정보를 관리
    - 블럭 데이터를 데이터 노드에 매핑
    - 파일, 디렉토리, 생성, 열기, 쓰기 오퍼레이션 수행
    - 어떤 데이터 노드에 복제/삭제 할지 결정
    - 데이터 노드에서 보내온 하트비트와 블록 리포드를 처리 (블록 위치 유지, 데이터 노드의 상태 관리)
  - *SecondaryNameNode* - HDFS 스토리지 메타 정보 업데이트(기본 1시간 간격, fsimage파일과 editlog 파일을 merge)
  - *DataNode* - 마스터 노드에 접속 유지, 3초 간격으로 heartbeat, block, report를 주기적으로 전송, 마스터 노드의 요청을 처리(block 저장, block 삭제)
    - 로컬 파일 시스템에 블록을 저장
    - 데이터에 대한 읽기, 쓰기 수행
    - 데이터 블록 생성 및 삭제 수행
    - 클러스터에 데이터 블럭 복제
    - 주기적으로 네임노드에 heartbeat와 block report를 전송



- **Yarn** 서비스
  - *resource manager* - 마스터 노드에서 실행. 클러스터의 리소스를 나눠주는 역할, TaskTracker들의 Task를 스케줄링
  - *node manager* - 워커 노드에서 실행, Task들을 실행시키고 관리, resource manager와 관계 유지, 태스크/노드 상태 관리
  - *application manager* - 클러스터에서의 메인이 되는 마스터 프로세스로서 어플리케이션별로 하나씩 실행됨. 클러스터에서 실행되는 어플리케이션의 실행 조율, 리소스 매니저와 통신(관계 유지)하면서 리소스 조절



- 기타 특징
  - ***sharding***, ***replication*** -  하둡 클러스터에서 장애 허용과 복구 능력을 위해 sharding, replication을 수행합니다.
  - 배치 처리, 파일 기반 처리 
    - map의 처리 결과도 map처리된 datanode에 파일로 저장. -
    - reducer의 출력결과도 hdfs에 저장
    - disk/stream 기반
    - sequential 하게 처리





### hive 설치

- 설치 

```bash
http://www.apache.org/dyn/closer.cgi/hive/

[root@master local]# tar -xzvf /home/hadoop/Downloads/apache-hive-1.2.2-bin.tar.gz 
[root@master local]# chown -R hadoop:hadoop apache-hive-1.2.2-bin/

[root@master local]# ln -s apache-hive-1.2.2-bin/  hive
[root@master local]# ls -l

[root@master local]# chown -R hadoop:hadoop hive
[root@master local]# ls -l

#마스터에서 hadoop 환경설정 파일 변경
[root@master local]# su - hadoop
[hadoop@master ~]$ vi .bash_profile

export HIVE_HOME=/usr/local/hive
export PATH=$PATH:$JAVA_HOME/bin:$HADOOP_HOME/bin:$HIVE_HOME/bin:



#마스터 노드에 hive 메타스토어 mysql 구성 (로컬모드)
[root@master ~]# rpm -ivh /home/hadoop/Downloads/mysql-community-release-el6-5.noarch.rpm
[root@master ~]#  ls -la /etc/yum.repos.d/
[root@master ~]# yum install mysql-server

[root@master ~]# ls /usr/bin/mysql
[root@master ~]# ls /usr/sbin/mysqld
[root@master ~]#  service mysqld start

[root@master ~]# mysql --version
[root@master ~]# netstat -anp | grep mysql

[root@master ~]# mysql
```



- mysql  설정

```mysql
mysql> grant all privileges on *.* to hive@localhost identified by 'hive' with grant option;
Query OK, 0 rows affected (0.05 sec)
>flush privileges;
 
mysql> show databases;
 +--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
+--------------------+


mysql> use mysql;
mysql> show tables;
+---------------------------+
| Tables_in_mysql           |
+---------------------------+
| columns_priv              |
| db                        |
| event                     |
| func                      |
| general_log               |
| help_category             |
| help_keyword              |
| help_relation             |
| help_topic                |
| innodb_index_stats        |
| innodb_table_stats        |
| ndb_binlog_index          |
| plugin                    |
| proc                      |
| procs_priv                |
| proxies_priv              |
| servers                   |
| slave_master_info         |
| slave_relay_log_info      |
| slave_worker_info         |
| slow_log                  |
| tables_priv               |
| time_zone                 |
| time_zone_leap_second     |
| time_zone_name            |
| time_zone_transition      |
| time_zone_transition_type |
| user                      |
+---------------------------+

mysql> select user from user;
+------+
| user |
+------+
| root |
| root |
|      |
| hive |
| root |
|      |
| root |
+------+
```



- hive 설정

```bash
[hadoop@master conf]$ cd /usr/local/hive/conf/
[hadoop@master conf]$ cp hive-env.sh.template hive-env.sh
[hadoop@master conf]$ vi hive-env.sh
# HADOOP_HOME=/usr/local/hadoop-2.7.7 삽입
[hadoop@master conf]$ chmod 755 hive-env.sh

# /usr/local/hive/conf/hive-site.xml을 수정
[hadoop@master ~]$ vi /usr/local/hive/conf/hive-site.xml

```

hive-site.xml

```xml
<?xml version="1.0"?>
<?xml-stylesheet type="text/xsl" href="configuration.xsl"?>
<configuration>
<property>
  <name>hive.metastore.local</name>
  <value>true</value>
</property>
<property>
  <name>javax.jdo.option.ConnectionURL</name>
  <value>jdbc:mysql://localhost:3306/metastore_db?createDatabaseIfNotExist=true</value>
  <description>JDBC connect string for a JDBC metastore</description>
</property>
<property>
  <name>javax.jdo.option.ConnectionDriverName</name>
  <value>com.mysql.jdbc.Driver</value>
  <description>Driver class name for a JDBC metastore</description>
</property>
<property>
  <name>javax.jdo.option.ConnectionUserName</name>
  <value>hive</value>
  <description>username to use against metastore database</description>
</property>

<property>
  <name>javax.jdo.option.ConnectionPassword</name>
  <value>hive</value>
  <description>password to use against metastore database</description>
</property> 
  </configuration>
```



- mysql에 database와 table 생성

```mysql
[root@master ~]# mysql -u root -p


# 스크립트 실행하여 hive를 위한 db  생성
mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
+--------------------+
3 rows in set (0.02 sec)

mysql> CREATE DATABASE metastore_db;
Query OK, 1 row affected (0.00 sec)

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| metastore_db       |
| mysql              |
| performance_schema |
+--------------------+
4 rows in set (0.00 sec)

mysql> USE metastore_db;
Database changed

mysql> show tables;
Empty set (0.01 sec)

mysql> SOURCE /usr/local/hive/scripts/metastore/upgrade/mysql/hive-schema-1.1.0.mysql.sql;
...
ERROR:
Failed to open file 'hive-txn-schema-0.13.0.mysql.sql', error: 2
...

mysql> show tables;
#45개 나옴

#실패한 스크립트 직접 실행
mysql> SOURCE /usr/local/hive/scripts/metastore/upgrade/mysql/hive-txn-schema-0.14.0.mysql.sql

mysql> show tables;
#53개 나옴

#드라이버 카피
hadoop@master ~]$ tar -xvzf mysql-connector-java-5.1.36.tar.gz
hadoop@master ~]$ cp ./Downloads/mysql-connector-java-5.1.36-bin.jar /usr/local/hive/lib/


```
