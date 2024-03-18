# DB 트랜잭션(Transaction)

<br>

#### 트렌잭션이란?

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

작업 단위 → **많은 SQL 명령문들을 사람이 정하는 기준에 따라 묶은 것**

```
예시) 사용자 A가 사용자 B에게 만원을 송금한다.

* 이때 DB 작업
- 1. 사용자 A의 계좌에서 만원을 차감한다 : UPDATE 문을 사용해 사용자 A의 잔고를 변경
- 2. 사용자 B의 계좌에 만원을 추가한다 : UPDATE 문을 사용해 사용자 B의 잔고를 변경

현재 작업 단위 : 출금 UPDATE문 + 입금 UPDATE문
→ 이를 통틀어 하나의 트랜잭션이라고 한다.
- 위 두 쿼리문 모두 성공적으로 완료되어야만 "하나의 작업(트랜잭션)"이 완료되는 것이다. `Commit`
- 작업 단위에 속하는 쿼리 중 하나라도 실패하면 모든 쿼리문을 취소하고 이전 상태로 돌려놓아야한다. `Rollback`

```

<br>

#### 트랜잭션 특징

- 원자성(Atomicity)

  > 트랜잭션이 DB에 모두 반영되거나, 혹은 전혀 반영되지 않아야 된다.

- 일관성(Consistency)

  > 트랜잭션의 작업 처리 전후 데이터베이스의 일관성이 있어야 한다.

- 독립성(Isolation)

  > 동시에 실행되는 트랜잭션은 서로 영향없이 독립적으로 수행되어야 한다.

- 지속성(Durability)

  > 트랜잭션이 성공적으로 완료되었으면, 결과는 영구적으로 반영되어야 한다.

<br>

##### Commit

하나의 트랜잭션이 성공적으로 끝났고,  DB가 일관성있는 상태일 때 이를 알려주기 위해 사용하는 연산

<br>

##### Rollback

하나의 트랜잭션 처리가 비정상적으로 종료되어 트랜잭션 원자성이 깨진 경우

transaction이 정상적으로 종료되지 않았을 때, last consistent state (ex. Transaction의 시작 상태) 로 roll back 할 수 있음. 

<br>

---

<br>

### 트랜잭션의 상태

![transaction-status](https://github.com/castlecowrice/tech-interview-for-developer/assets/48044251/3431a22e-a608-4b80-a2d4-098c96305af9)


#### Active

트랜잭션의 활동 상태. 트랜잭션이 실행중인 상태를 말한다.

#### Failed

트랜잭션 실패 상태. 트랜잭션에 오류가 발생하여 중단된 상태를 말한다.

#### Aborted

트랜잭션 취소 상태. 트랜잭션이 취소되고 rollback된 상태를 말한다.

#### Partially Committed

마지막 연산까지 실행 후 commit하기 직전의 상태를 말한다.

#### Committed

트랜잭션이 정상적으로 완료된 상태를 말한다.

---
