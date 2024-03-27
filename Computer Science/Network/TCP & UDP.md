#### Connectionless vs Connection-orineted

Connectionless ~ 편지

Connection-oriented ~ 전화

<br>

#### TCP & UDP

Transport layer에서 사용하는 프로토콜

- TCP (Transmission Control Protocol)
  
  - 신뢰성 있는 (중복x 손실x 순서o), 연결 지향형 프로토콜.
  - 흐름제어, 혼잡제어 지원.
  - HTTP/HTTPS, 이메일, 파일
    
  - 전이중(full-duplex) : 동시에 양방향 전송 가능.
  - 점대점(point to point) : 연결은 2개의 종단점(소켓)을 가지고 있다.

- UDP (User Datagram Protocol)

  - 신뢰성 없는, 비연결형 프로토콜.
  - DNS, 실시간 방송, 온라인 게임

- TCP vs UDP

  - UDP는 TCP 보다 overhead가 적고 속도가 빠르다.
    - connectionless (handshaking x)
    - Header가 작다.

- TCP와 UDP는 왜 나오게 됐는가?

  1. IP의 역할은 Host to Host (장치 to 장치)만을 지원한다. 하나의 Host 안에서 여러 process들이 통신을 할 경우에는 IP만으로는 한계가 있다.

  2. IP에서 오류가 발생하면 ICMP에서 알려준다. 하지만 ICMP는 오류 대처를 못 하기 때문에 IP보다 위에서 처리를 해줘야 한다.

  - ICMP : 인터넷 제어 메시지 프로토콜로 오류 메시지를 전송하는데 주로 쓰인다..

  - 1번을 해결하기 위하여 포트 번호가 나왔고, 2번을 해결하기 위해 상위 프로토콜인 TCP와 UDP가 나왔다.

- DNS(Domain Name System)에서 UDP를 사용하는 이유

  - DNS Request는 크기가 작다. -> UDP Segment에 담길 수 있다.
  - Application Layer에서 timeout시 resend를 통해 신뢰성을 더할 수 있다.

  - 참고: 데이터가 512 bytes를 넘는 경우 TCP를 사용한다.

<br>

#### UDP Header

<img src='https://t1.daumcdn.net/cfile/tistory/272A5A385759267B36'>

  - Source port : 시작 포트
  - Destination port : 도착지 포트
  - Length : 길이
  - _Checksum_ : 무결성 검사
    - Datagram을 16비트 단위로 나누고 다 더한다. -> 1의 보수

<br>

[ref]<br>

- <https://www.geeksforgeeks.org/why-does-dns-use-udp-and-not-tcp/>
- <https://support.microsoft.com/en-us/help/556000>
- <https://www.scaler.com/topics/domain-name-system/>
