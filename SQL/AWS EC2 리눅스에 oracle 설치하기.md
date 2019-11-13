# AWS EC2 리눅스(text mode)에 oracle 11g 설치하기

## 개요

여러 방법들을 시도 해 본 결과 oracle 홈페이지에서 rpm 버전을 다운로드 받아서 설치하는 방법이 가장(매우x10) 간편하고 확실한 방법이라고 결론 내리고 진행하였다.

> 다른 방법들은 아예 gui 환경이 있어야 설치가 진행되거나 혹은 text mode로 설치하더라도 사전에 oracle 계정 전용 group  등을 필수로 생성해줘야하고, 또 환경설정등의 매우 귀찮은 절차가 필요하다. 특별한 이유가 없는한 개인적으로는 매우 비추한다.

## Oracle 11.2.0 RPM 패키지 다운 받기

[이곳](https://www.oracle.com/database/technologies/xe-prior-releases.html)에서 `Oracle Database 11gR2 Express Edition for Linux x64`를 다운 받도록 한다. 다운 받을 경로는 편한 곳으로 지정한다. 

> 나 같은 경우는 `ec2-user` 계정의 홈 디렉토리 적당한 곳에 저장하고 추후에 `root` 계정으로 설치하였다.

## 의존성 패키지 설치

설치에 필요한 의존성 패키지들이 꽤 있는데 이미 ec2 amazon-ami linux에는 많은 부분들이 기설치되어 있어 큰 문제가 없었다. 대표적으로는 아래와 같은 의존성 패키지 들이 깔려 있어야 한다.

- libaio
- bc
- 기타 dev tools

설치 중에 error 가 발생하면 메시지를 잘 확인하여 해당 패키지를 깔면 된다. 나 같은 경우는 이미 다 깔려있어서 문제가 되지 않았다. 설치해야 할 패키지가 있따면 `yum install [패키지명]`으로 하면 된다.

## swap 공간 확보

oracle을 설치하기 위해서는 약 2G 정도의 스왑 공간이 필요하다. 스왑 공간이 모자라면 설치중에 에러가 발생한다. 

자신의 linux swap 공간을 확인해보거나 혹은 설치중 swap 용량 문제로 에러가 발생하면 아래와 같이 진행하여 swap 공간을 확보하도록 한다.

### swqp 공간 확인

이미 swap이 설정되어 있어서 2047MB의 공간을 갖고 있다.

```bash
$ free -m
             total       used       free     shared    buffers     cached
Mem:           985        829        156        234         31        614
-/+ buffers/cache:        184        801
Swap:         2047          1       2046

```

### swap 공간 만들기

만약 swap 공간의 최대 크기가 2GB를 만족시키지 못한다면 아래와 같이 설정한다(크기는 2GB 이상으로 취향에 맞게 설정).

```bash
$ mkdir /swap
$ dd if=/dev/zero of=/swap/swapfile bs=1024 count=2097152
2097152+0 records in
2097152+0 records out
2147483648 bytes (2.1 GB) copied, 127.844 s, 16.8 MB/s
$ cd /swap
$ mkswap swapfile
mkswap: swapfile: warning: don't erase bootbits sectors
        on whole disk. Use -f to force.
Setting up swapspace version 1, size = 2097148 KiB
no label, UUID=2c6a1277-a5c3-4f48-b64c-7010dd161c72
$ chmod 644 swapfile
$ swapon swapfile
```

### 리부팅시 swap을 자동으로 장착하도록 하기

리눅스를 리부팅 시키면 장착시켜둔 swap 공간이 해제되므로, 부팅시 자동으로 다시 장착되도록 아래와 같이 `rc.local`을 

```bash
$ vi /etc/rc.d/rc.local

# 파일에 추가해야할 내용
swapon /swap/swapfile
```

## 오라클 11g 설치

이제 모든 준비가 끝났으므로  아래와 같이 RPM 패키지를 설치한다.

### 설치

```bash
$ rpm -ivh oracle-xe-11.2.0-1.0.x86_64.rpm
```

별 문제가 ㅇ벗다는 성공 메시지와 함께 종료된다.

### 설정

`Oracle Application Express Port`나 `database listener Port`, 그리고 재부팅시 자동실행 등의 설정을 해준다. 아래와 같은 커맨드로 그 과정을 진행할 수 있다. 

```bash
$ /etc/init.d/oracle-xe configure
```

## 오라클 실행하기

모든 설치가 정상적으로 끝나면 아래경로로 들어가 환경변수 설정등을 확인하여 실행하도록 한다. 자신의 `ec2-user` 계정의 `.bash_profile` 에도 설정 해 두면 좋다.

```bash
$ cd /u01/app/oracle/product/11.2.0/xe/bin
$ ./oracle_env.sh
```

모든과정이 끝났으므로 `sqlplus`를 실행한다!

```bash
$ sqlplus / as sysdba
```

### sysdba 접속이 안 될 때

```bash
$ sudo su oracle
$ export ORACLE_HOME=/u01/app/oracle/product/11.2.0/xe
$ export ORACLE_SID=XE
$ PATH=$PATH:$HOME/.local/bin:$HOME/bin:$ORACLE_HOME/bin
$ export PATH
$ sqlplus / as sysdba

SQL*Plus: Release 11.2.0.2.0 Production on Wed Nov 13 02:37:10 2019

Copyright (c) 1982, 2011, Oracle.  All rights reserved.


Connected to:
Oracle Database 11g Express Edition Release 11.2.0.2.0 - 64bit Production

SQL>
```







**-끝-**

