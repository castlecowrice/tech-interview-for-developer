#### GET
GET 방식은 request를 보낼 때 데이터를 url ? 뒤의 query string에 담아서 전송한다. 

전송할 수 있는 데이터의 크기가 제한적이다. (브라우저에 따라 수십 kb 정도)
비밀번호와 같은 데이터의 경우, 값이 그대로 url에 노출되므로 적절하지 않다.

CRUD의 R

#### POST
POST 방식의 request는 HTTP Body에 데이터를 담아서 전송한다. 

전송할 수 있는 데이터 크기가 GET 방식보다 크고 보안적으로 낫다.
(하지만 암호화를 하지 않는 이상 큰 차이는 없다.)

CRUD의 C (서버에 데이터를 생성)

#### GET vs POST

GET 은 서버에서 데이터를 가져오는 용도이고 서버의 값이나 상태 등을 변경하지 않는다. 

POST 는 서버의 값이나 상태를 변경하기 위해서 또는 추가하기 위해서 사용된다.

GET 방식의 요청은 브라우저에서 Caching 할 수 있다. 

#### PUT

CRUD의 U (서버의 데이터를 수정)

#### DELETE

CRUD의 D (서버의 데이터를 삭제)

#### Caching

Response Header의 cache-control에 max-age(캐시가 유효한 시간)를 설정하고 전송 -> 응답 결과를 브라우저 캐시에 저장

