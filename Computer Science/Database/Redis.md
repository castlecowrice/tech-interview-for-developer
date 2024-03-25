## Redis

> 메모리 기반 key-value store

보통 데이터베이스는 하드 디스크나 SSD에 저장한다. 하지만 Redis는 메모리(RAM)에 저장 해 매우 빠른 장점이 존재한다.

세션을 관리하거나, 캐싱을 할 때 자주 사용된다.

***RAM은 휘발성 아닌가요? 껐다키면 다 날아가는데..***

이를 막기위한 백업 과정이 존재한다.

- snapshot : 특정 지점을 설정하고 디스크에 백업한다.
- AOF(Append Only File) : 쿼리들을 저장해두고, 서버가 셧다운되면 재실행해서 복원한다.

##### value 5가지

1. String (text, binary data)
2. set
3. zset
4. hash
5. list
