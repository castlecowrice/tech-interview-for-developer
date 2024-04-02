## [TCP] 3 way handshake & 4 way handshake

> 연결을 성립하고 해제하는 과정을 말한다. (establish/finish connection)

<br>

### handshake 하는 이유 / why not 2 way handshake?

TCP에서 reliable data transfer를 위해 패킷마다 번호를 붙인다 (sequence number). 이를 통해 어떤 packet이 lost되었는지, 또는 duplicate되었는지 알 수 있다.

최초의 sequence number (ISN, Initial Sequence Number)는 랜덤으로 정하기 때문에, 상대방에게 이를 알려 줘야 함. 랜덤으로 정하는 이유는.. 보안상 그렇다고 한다.

3 way handshake = 2 way를 양쪽 모두 한 번씩 하는 것. (TCP는 양방향 통신이므로 양쪽이 송수신을 하려면 둘 다 해야 한다.)

- SYN X = 내 ISN을 상대방과 Synchronize.
- ACK X+1 = SYN을 받았으며, 다음 byte인 X+1을 받을 준비가 되었다.

https://networkengineering.stackexchange.com/questions/24068/why-do-we-need-a-3-way-handshake-why-not-just-2-way

Q. 그러면 한쪽만 송신을 하는 경우에는 2-way handshake로도 충분한가?

문제 시나리오

1. SYN X, 도착
2. ACK X+1
3. ACK이 도착하기 전 SYN X 재전송, ACK 도착
4. 클라이언트 종료
5. SYN X 도착
6. ACK X+1 (도착 못 함)

-> 서버만 연결을 수립하는 결과.

<br>

### 3 way handshake - 연결 성립

TCP는 연결 지향형 프로토콜이다. 따라서 통신하기에 앞서 논리적인 연결을 성립하기 위해 3 way handshake 과정을 진행한다.

<img src="https://media.geeksforgeeks.org/wp-content/uploads/TCP-connection-1.png">

1) 클라이언트가 서버에게 SYN(x)를 보낸다.

2) 서버가 SYN(x)를 받고, 클라이언트에게 받았다는 신호인 ACK(x+1)와 SYN(y)를 보낸다.

3) 클라이언트는 서버의 ACK(x+1)와 SYN(y) 를 받고, ACK(y+1)을 서버로 보낸다.

<br>

이렇게 3번의 통신이 완료되면 연결이 성립된다.

<br>

### 4 way handshake - 연결 해제

연결 성립 후, 모든 통신이 끝났다면 연결을 해제해야 한다.

<img src="https://media.geeksforgeeks.org/wp-content/uploads/CN.png">

1) 클라이언트는 서버에게 연결을 종료한다는 FIN을 보낸다.

2) 서버는 FIN을 받고, 확인했다는 ACK을 클라이언트에게 보낸다. (이때 모든 데이터를 보내기 위해 CLOSE_WAIT 상태가 된다.)

3) 데이터를 모두 보냈다면, 연결이 종료되었다는 FIN을 클라이언트에게 보낸다.

4) 클라이언트는 FIN을 받고, 확인했다는 ACK을 서버에게 보낸다. (아직 서버로부터 받지 못한 데이터가 있을 수 있으므로 TIME_WAIT을 통해 기다린다.)

- 서버는 ACK를 받은 이후 소켓을 닫는다. (Closed)

- TIME_WAIT 시간이 끝나면 클라이언트도 닫는다. (Closed)

<br>

이렇게 4번의 통신이 완료되면 연결이 해제된다.

<br>

<br>

##### [참고 자료]

[링크](<https://www.geeksforgeeks.org/tcp-connection-termination/>)
