## 트랜잭션 격리 수준(Transaction Isolation Level)

ACID의 I

transaction의 중간 결과가 다른 transaction에 visible하지 않아야 한다.

<br>

#### Lock

Shared Lock(S) : Read Lock
Exclusive Lock(X) : Write Lock

<br>

#### Isolation level의 필요성

----

데이터베이스는 ACID 특징과 같이 트랜잭션이 독립적인 수행을 하도록 한다.

따라서 Locking을 통해, 트랜잭션이 DB를 다루는 동안 다른 트랜잭션이 관여하지 못하도록 막는 것이 필요하다.

하지만 무조건 Locking으로 동시에 수행되는 수많은 트랜잭션들을 순서대로 처리하는 방식으로 구현하게 되면 데이터베이스의 성능은 떨어지게 될 것이다.

그렇다고 해서, 성능을 높이기 위해 Locking의 범위를 줄인다면, 잘못된 값이 처리될 문제가 발생하게 된다.

- 따라서 최대한 효율적인 Locking 방법이 필요함!

<br>

#### Isolation level 종류

----

1. ##### Read Uncommitted (레벨 0)

  아직 Commit되지 않은 데이터를 다른 트랜잭션이 읽는 것을 허용함 (dirty read)

   ```
   Transaction 1이 A라는 데이터를 B로 변경하는 동안 Transaction 2는 아직 완료되지 않은(Uncommitted) 트랜잭션이지만 데이터 B를 읽을 수 있다
   ```

-> 트랜잭션이 롤백되는 경우 데이터가 보였다가 사라진다.

   <br>

2. ##### Read Committed (레벨 1)

   Commit된 데이터만 조회 가능

   트랜잭션 2가 commit되지 않은 데이터를 읽을 때는 Undo log에 백업된 레코드에서 읽어온다.

   -> 트랜잭션 2가 트랜잭션 1의 commit 전, 후에 읽는 값이 달라진다. (consistency 위배) 


   대부분의 SQL 서버가 Default로 사용하는 Isolation Level임

   <br>

4. ##### Repeatable Read (레벨 2)
  
   MySQL에서 Default로 사용하는 Isolation Level


- MVCC

변경 전 레코드를 Undo 공간에 백업 (Undo log) -> 트랜잭션 Rollback 시 데이터 복원 가능

트랜잭션에 transaction id를 부여하고, 백업 레코드에 transaction id를 함께 저장한다.

SELECT할 때, 자기보다 transaction id가 작은 (자기보다 먼저 시작한) 트랜잭션의 변경 사항만 보게 된다.

Phantom Read 발생 조건 : SELECT FOR UPDATE (lock을 걸 때는 Undo log가 아닌 테이블의 레코드를 읽는다.)

Why? Undo log에는 lock을 걸 수 없다고 한다. 이유는 복잡..
  

   <br>

6. ##### Serializable (레벨 3)

   트랜잭션을 순차적으로 처리

   완벽한 읽기 일관성 모드를 제공함

   <br>

<br>

***선택 시 고려사항***

Isolation Level에 대한 조정은, 동시성과 데이터 무결성에 연관되어 있음

동시성을 증가시키면 데이터 무결성에 문제가 발생하고, 데이터 무결성을 유지하면 동시성이 떨어지게 됨

레벨을 높게 조정할 수록 발생하는 비용이 증가함

<br>

##### 낮은 단계 Isolation Level을 활용할 때 발생하는 현상들

- Dirty Read

  > 커밋되지 않은 수정중인 데이터를 다른 트랜잭션에서 읽을 수 있도록 허용할 때 발생하는 현상
  >
  > 어떤 트랜잭션에서 아직 실행이 끝나지 않은 다른 트랜잭션에 의한 변경사항을 보게되는 경우  
  - 발생 Level: Read Uncommitted

- Non-Repeatable Read

  > 한 트랜잭션에서 같은 쿼리를 두 번 수행할 때 그 사이에 다른 트랜잭션 값을 수정 또는 삭제하면서 두 쿼리의 결과가 상이하게 나타나는 일관성이 깨진 현상
  - 발생 Level: Read Committed, Read Uncommitted

- Phantom Read

  > 한 트랜잭션 안에서 일정 범위의 레코드를 두 번 이상 읽었을 때, 첫번째 쿼리에서 없던 레코드가 두번째 쿼리에서 나타나는 현상
  >
  > 트랜잭션 도중 새로운 레코드 삽입을 허용하기 때문에 나타나는 현상임
  - 발생 Level: Repeatable Read, Read Committed, Read Uncommitted


#### 링크

https://mangkyu.tistory.com/299

