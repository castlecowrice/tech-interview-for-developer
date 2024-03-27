### DNS (Domain Name System)

모든 통신은 IP를 기반으로 연결된다. 하지만 사용자가 직접 IP 주소를 기억하고 입력하는 것은 쉽지 않다.

따라서 DNS 가 등장했으며 DNS 는 도메인 주소와 IP 주소를 매핑하는 역할을 수행한다.

### 도메인 주소가 IP로 변환되는 과정

1. 디바이스는 hosts 파일을 열어봅니다
   - hosts 파일에는 로컬에서 설정한 도메인 주소와 IP 주소의 매핑이 저장되어 있습니다
2. DNS는 캐시를 확인합니다
   - 기존에 접속했던 사이트의 경우 캐시에 남아 있을 수 있습니다
   - DNS는 브라우저 캐시, 로컬 캐시(OS 캐시), 라우터 캐시, ISP캐시 순으로 확인합니다
3. DNS (ISP의 DNS 서버)는 Root DNS에 요청을 보냅니다
   - Root DNS의 주소는 잘 알려져 있다.
   - Root DNS는 도메인 주소의 최상위 계층을 확인하여 TLD(Top Level domain, .com) Name Server의 주소를 반환합니다
4. DNS는 TLD NS에 요청을 보냅니다
   - TLD NS는 Authoritative(권한 있는, google.com) NS의 주소를 반환합니다
5. DNS는 Authoritative NS에 요청을 보냅니다
   - 도메인 이름에 대한 IP 주소를 반환합니다

### www.google.com 에 접속할 때 일어나는 일

www.google.com 을 브라우저 주소창에 친다.

브라우저는 DNS Lookup을 통해 www.google.com 의 IP주소를 알아낸다.

브라우저는 HTTP (GET) Request Message를 만들고 OS에 해당 IP로 전송 요청을 한다.

서버와 TCP 연결을 수립한다. (3 way handshaking)

TCP 연결이 완료되면 요청이 전송된다.



> 프로토콜 스택(운영체제에 내장된 네트워크 제어용 소프트웨어)이 브라우저로부터 메시지를 받아 패킷에 저장한다.
>
> L3 Header : IP 주소 (end-to-end)
>
> L2 Header : MAC 주소 (next-hop)
>
> 프레임을 네트워크 어댑터 (NIC, Network Interface Card) 에 넘긴다.
>
> 어댑터는 프레임을 전기신호로 변환시키고, LAN 케이블에 송출한다.
>
> host -> switch -> router -> ISP -> Internet -> ...
>
> (https://youtu.be/rYodcvhh7b8)

서버가 요청을 처리하고 response를 생성한다.

> 패킷이 웹 서버에 도착하면 웹 서버의 프로토콜 스택은 패킷을 추출하여 메시지를 복원하고 웹 서버 애플리케이션에 넘긴다.
>
> 메시지를 받은 웹 서버 애플리케이션은 요청 메시지에 따라 응답을 생성하고 클라이언트로 전송한다.

브라우저가 HTML content를 보여준다.
