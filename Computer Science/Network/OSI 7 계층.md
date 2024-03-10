## OSI 7 계층

<br>

<img src="https://s7280.pcdn.co/wp-content/uploads/2018/06/osi-model-7-layers-1.png">

<br>

#### 7계층은 왜 나눌까?

통신이 일어나는 과정을 단계별로 알 수 있고, 특정한 곳에 이상이 생기면 그 단계만 수정할 수 있기 때문이다.

<br>

##### 1) 물리(Physical)

> 리피터, 케이블, 허브 등

전기 신호를 통해 데이터를 전송.

<br>

##### 2) 데이터 링크(Data Link)

> 브릿지, 스위치, MAC 주소

물리 계층으로부터 송수신되는 정보를 frame 단위로 처리하고 frame에 MAC 주소를 부여.

<br>

##### 3) 네트워크(Network)

> 라우터, IP

패킷(Packet) 단위의 데이터 전송, 라우팅, 그리고 IP 주소 지정을 수행합니다.
IP 주소와 라우터를 이용하여 최적의 경로를 선택하는 역할을 합니다.

<br>

##### 4) 전송(Transport)

> TCP, UDP

TCP와 UDP가 동작하는 layer. 프로세스 간 논리적 연결 담당.

논리적 연결(logical communication)? 물리적 연결의 반대. 하위 계층에서 일어나는 일을 추상화해서 제공.

<br>

##### 5) 세션(Session)?

> API, Socket

데이터가 통신하기 위한 논리적 연결을 담당한다. TCP/IP 세션을 만들고 없애는 책임을 지니고 있다.

<br>

##### 6) 표현(Presentation)?

> JPEG, MPEG 등

데이터 표현에 대한 독립성을 제공하고 암호화하는 역할을 담당한다.

파일 인코딩, 명령어를 포장, 압축, 암호화한다.

<br>

##### 7) 응용(Application)

> HTTP, FTP, DNS 등

최종 사용자와 직접 상호작용하는 인터페이스를 제공합니다.
