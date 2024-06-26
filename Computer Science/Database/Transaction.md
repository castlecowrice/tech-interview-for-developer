# DB 트랜잭션(Transaction)

<br>

#### 트랜잭션이란?

> 데이터베이스의 "작업 단위"

<br>

```
- SELECT
- INSERT
- DELETE
- UPDATE
```
의 집합으로 생각할 수 있다.

<br>

작업 단위 = **많은 SQL 명령문들을 사람이 정하는 기준에 따라 묶은 것**

```
예) A가 B에게 만원을 송금한다.

* 작업 단위
- 1. A의 계좌에서 만원을 출금하는 UPDATE 문
- 2. B의 계좌에 만원을 입금하는 UPDATE 문

이를 통틀어 하나의 트랜잭션이라고 한다.
```

<br>

#### 트랜잭션 특징

- 원자성(Atomicity)

  > 트랜잭션이 DB에 모두 반영되거나, 혹은 전혀 반영되지 않아야 된다.

- 일관성(Consistency)

  > 트랜잭션의 작업 처리 전후 데이터베이스의 일관성이 있어야 한다.
  >
  > 일관성? -> 데이터베이스의 제약이나 규칙을 만족해야 한다.

- 독립성(Isolation)

  > 동시에 실행되는 트랜잭션은 서로 영향없이 독립적으로 수행되어야 한다.

- 지속성(Durability)

  > 트랜잭션이 성공적으로 완료되었으면, 결과는 영구적으로 반영되어야 한다.

<br>

##### Commit

트랜잭션이 정상적으로 종료되었을 때, 트랜잭션의 실행 결과를 확정짓는 연산이다.

<br>

##### Rollback

트랜잭션이 비정상적으로 종료되었을 때, 트랜잭션이 시작하기 전의 상태로 되돌리는 연산이다. 

<br>

---

<br>

### 트랜잭션의 상태

#### Active

트랜잭션이 실행중인 상태이다.

#### Failed

트랜잭션에 오류가 발생하여 중단된 상태이다.

#### Aborted

트랜잭션이 취소되고 rollback된 상태이다.

#### Partially Committed

마지막 쿼리까지 실행 후 commit하기 직전의 상태를 말한다.

#### Committed

트랜잭션이 정상적으로 완료된 상태를 말한다.

---
