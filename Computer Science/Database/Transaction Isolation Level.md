## 트랜잭션 격리 수준(Transaction Isolation Level)

ACID의 I

transaction의 중간 결과가 다른 transaction에 visible하지 않아야 한다.

<br>

#### Lock

Shared Lock(S) : Read Lock

Exclusive Lock(X) : Write Lock

Q. Transaction vs Lock?

A.

Lock은 동시에 여러 사용자가 데이터에 접근할 때 동시성 제어 역할을 한다.

<br>

#### Isolation level의 필요성

----

트랜잭션은 독립적으로 수행되어야 한다. (Isolation)

이것을 완전히 보장하려면 lock을 통해 한 트랜잭션이 DB에 접근하는 동안 다른 트랜잭션이 접근하지 못하도록 막고, 트랜잭션들을 순서대로 처리해야 한다.

하지만 이러면 데이터베이스의 성능은 떨어지게 될 것이다.

반대로 성능을 위해 lock의 범위를 줄인다면, 잘못된 값이 처리되는 문제가 발생할 수 있다.

-> 상황에 따른 절충이 필요하다.

<br>

#### Isolation level 종류

----

1. ##### Read Uncommitted (레벨 0)

   아직 commit되지 않은 데이터를 다른 트랜잭션이 읽는 것을 허용한다. (dirty read)

   -> 트랜잭션이 롤백되는 경우 데이터가 보였다가 사라진다.

   <br>

2. ##### Read Committed (레벨 1)

   대부분의 SQL 서버가 Default로 사용하는 Isolation Level

   다른 트랜잭션이 commit한 데이터만 읽을 수 있다. commit되지 않은 데이터를 읽을 때는 Undo log에 백업된 레코드 (rollback 용)에서 읽어온다.

   -> 한 트랜잭션이 동일한 데이터를 두 번 읽을 때, commit 전후에 읽는 값이 달라진다. (Non-repeatable read, consistency 위배) 

   <br>

3. ##### Repeatable Read (레벨 2)
  
    MySQL에서 Default로 사용하는 Isolation Level
    
    자기보다 transaction id가 작은 (자기보다 먼저 시작한) 트랜잭션의 변경 사항만 읽을 수 있다.
    
    -> Phantom read가 발생할 수 있다. (lock을 걸 때는 Undo log가 아닌 테이블의 레코드를 읽는다.)
    
    Why? Undo log에는 lock을 걸 수 없다고 한다. 이유는 복잡..
  
   <br>

4. ##### Serializable (레벨 3)

   트랜잭션을 순차적으로 처리한다.

   완벽한 읽기 일관성을 제공한다.

   <br>

<br>

***선택 시 고려사항***

Isolation Level에 대한 조정은, 동시성과 데이터 무결성에 연관되어 있다.

동시성을 증가시키면 데이터 무결성에 문제가 발생하고, 데이터 무결성을 유지하면 동시성이 떨어지게 된다.

<br>

#### 링크

https://mangkyu.tistory.com/299

