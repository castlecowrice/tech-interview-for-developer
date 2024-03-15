## 세마포어(Semaphore) & 뮤텍스(Mutex)

<br>

공유된 자원에 여러 프로세스가 동시에 접근하면서 문제가 발생할 수 있다. 이때 공유된 자원의 데이터는 한 번에 하나의 프로세스만 접근할 수 있도록 제한을 둬야 한다.

이를 위해 나온 것이 바로 **'세마포어'**

**세마포어** : 정수 값.

<br>

##### 임계 구역(Critical Section)

> 여러 프로세스가 데이터를 공유하며 수행될 때, **각 프로세스에서 공유 데이터를 접근하는 프로그램 코드 부분**

공유 데이터를 여러 프로세스가 동시에 접근할 때 잘못된 결과를 만들 수 있기 때문에, 한 프로세스가 임계 구역을 수행할 때는 다른 프로세스가 접근하지 못하도록 해야 한다.

Why?

ex.

메모리 -> 레지스터
increment
레지스터 -> 메모리

<br>

#### 세마포어 P, V 연산

P : 임계 구역 들어가기 전에 수행 ( 프로세스 진입 여부를 자원의 개수(S)를 통해 결정)

V : 임계 구역에서 나올 때 수행 ( 자원 반납 알림, 대기 중인 프로세스를 깨우는 신호 )

<br>

##### 구현 방법

```sql
P(S);

// --- 임계 구역 ---

V(S);
```

<br>

```sql
procedure P(S)   --> 최초 S값은 1임
    while S=0 do wait  --> S가 0면 1이 될때까지 기다려야 함
    S := S-1   --> S를 0로 만들어 다른 프로세스가 들어 오지 못하도록 함
end P

--- 임계 구역 ---

procedure V(S) --> 현재상태는 S가 0임
    S := S+1   --> S를 1로 원위치시켜 해제하는 과정
end V
```

이를 통해, 한 프로세스가 P 혹은 V를 수행하고 있는 동안 프로세스가 인터럽트 당하지 않게 된다(?). P와 V를 사용하여 임계 구역에 대한 상호배제 구현이 가능하게 되었다.

<br>

**뮤텍스** : 임계 구역을 가진 스레드들의 실행시간이 서로 겹치지 않고 각각 단독으로 실행되게 하는 기술

> 상호 배제(**Mut**ual **Ex**clusion)의 약자

해당 접근을 조율하기 위해 lock과 unlock을 사용한다.

- acquire lock : 현재 임계 구역에 들어갈 권한을 얻어옴. ( 만약 다른 프로세스/스레드가 임계 구역 수행 중이면 종료할 때까지 대기 )
- release lock : 현재 임계 구역을 모두 사용했음을 알림. ( 대기 중인 다른 프로세스/스레드가 임계 구역에 진입할 수 있음 )

<br>

뮤텍스는 상태가 0, 1로 **이진 세마포어**로 부르기도 함

but

binary semaphore -> mutex (o)

mutex -> binary semaphore (x)

Q. mutex vs semaphore

- mutex : 소유권 개념이 있음. lock을 acquire한 thread만이 그 lock을 release할 수 있음.
- semaphore : 소유권 개념 없음. 한 thread가 down(P)한 semaphore를 다른 thread가 up(V)할 수 있음.

Q. semaphore 사용 예

1. producer-consumer problem

buffer에 producer는 data insert, consumer는 data pop.

empty = buffer에서 비어 있는 칸의 수.

full = buffer에서 채워져 있는 칸의 수.

Producer
```
P(empty);
P(mutex);
...
V(mutex);
V(full);
```

Consumer
```
P(full);
P(mutex);
...
V(mutex);
V(empty);
```

2. reader-writer problem



3. dining philosopher problem

철학자 다섯 명이 원탁에 앉아 있다. 
철학자는 자신의 왼쪽과 오른쪽에 있는 젓가락을 들고 밥을 먹고, 다 먹고 나면 젓가락을 내려놓고 생각을 한다.

```
semaphore chopstick[5];

P(chopstick[i]);
P(chopstick[(i+1)%5]);
eat();
V(chopstick[i]);
V(chopstick[(i+1)%5]);
think();
```

-> deadlock 발생 가능.




<br>

#### **뮤텍스 알고리즘**

mutual exclusion 구현

i. lock, semaphore

atomic operation, hardware support (compare-and-swap, test-and-set)

2개 이상 프로세스, 스레드

ii. Peterson's solution

software-based solution

2개 프로세스, 스레드

1. ##### 데커(Dekker) 알고리즘

   flag와 turn 변수를 통해 임계 구역에 들어갈 프로세스/스레드를 결정하는 방식

   - flag : 프로세스 중 누가 임계영역에 진입할 것인지 나타내는 변수
   - turn : 누가 임계구역에 들어갈 차례인지 나타내는 변수

   ```java
   while(true) {
       flag[i] = true; // 프로세스 i가 임계 구역 진입 시도
       while(flag[j]) { // 프로세스 j가 현재 임계 구역에 있는지 확인
           if(turn == j) { // j가 임계 구역 사용 중이면
               flag[i] = false; // 프로세스 i 진입 취소
               while(turn == j); // turn이 j에서 변경될 때까지 대기
               flag[i] = true; // j turn이 끝나면 다시 진입 시도
           }
       }
   }
   
   // ------- 임계 구역 ---------
   
   turn = j; // 임계 구역 사용 끝나면 turn을 넘김
   flag[i] = false; // flag 값을 false로 바꿔 임계 구역 사용 완료를 알림
   ```

   <br>

2. ##### 피터슨(Peterson) 알고리즘

   데커와 유사하지만, 상대방 프로세스/스레드에게 진입 기회를 양보하는 것에 차이가 있음

   ```java
   while(true) {
       flag[i] = true; // 프로세스 i가 임계 구역 진입 시도
       turn = j; // 다른 프로세스에게 진입 기회 양보
       while(flag[j] && turn == j) { // 다른 프로세스가 진입 시도하면 대기
       }
   }
   
   // ------- 임계 구역 ---------
   
   flag[i] = false; // flag 값을 false로 바꿔 임계 구역 사용 완료를 알림
   ```

   <br>

mutual exclusion : 한 번에 하나의 프로세스만 Critical section에 들어갈 수 있다.

progress : Critical section에서 실행되고 있는 프로세스가 없는 상황에서, 어떤 프로세스가 그 Critical section에 들어가고 싶어 한다면, 들어갈 수 있어야 한다.

bounded wait (no starvation) : Critical Section으로 들어가고자 하는 프로세스는 언젠가는 (eventually) 해당 Critical section에 들어갈 수 있어야 한다. 그 전까지 다른 프로세스들이 Critical Section 에 진입하는 횟수는 제한이 있어야 한다.



   
