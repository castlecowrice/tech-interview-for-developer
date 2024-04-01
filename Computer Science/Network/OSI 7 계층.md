## OSI 7 계층

<br>

<img src="https://s7280.pcdn.co/wp-content/uploads/2018/06/osi-model-7-layers-1.png">

<br>

#### 7계층은 왜 나눌까?

통신이 일어나는 과정을 단계별로 알 수 있고, 특정한 곳에 이상이 생기면 그 단계만 수정할 수 있기 때문이다.

<br>

##### 1) 물리(Physical)

> 리피터, 허브, 케이블

전기 신호를 통해 데이터를 전송한다.

<br>

##### 2) 데이터 링크(Data Link)

> 스위치

hop-to-hop 전송을 책임진다.

MAC 주소를 이용한다.

<br>

##### 3) 네트워크(Network)

> 라우터

end-to-end (host-to-host) 전송을 책임진다.

IP 주소와 라우터를 이용하여 최적의 경로로 전달하는 역할을 한다.

Q. 스위치 vs 라우터?

스위치 : 한 네트워크 안에서 host 간 연결

라우터 : 네트워크 간 연결

<br>

##### 4) 전송(Transport)

TCP, UDP

프로세스 간 전송을 책임진다.

<br>

##### 5) 세션(Session)

API, Socket

TCP/IP 세션의 생성, 유지, 종료를 책임진다.

Q. 세션?

A.

<br>

##### 6) 표현(Presentation)

JPEG, MPEG 등

응용 계층의 다양한 데이터 표현 방식을 통일된 형식으로 변환한다. 예) 정수형 값은 시스템에 따라 16비트, 32비트 등으로 표현된다.

데이터를 압축, 암호화한다.

<br>

##### 7) 응용(Application)

HTTP, FTP, DNS 등

최종 사용자와 직접 상호작용하는 인터페이스를 제공한다.
