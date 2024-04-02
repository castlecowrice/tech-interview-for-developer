#### 메인 메모리(main memory)

> 메인 메모리는 CPU가 직접 접근할 수 있는 주기억 장치
>
> 프로세스가 실행되려면 프로그램이 메모리에 올라와야 함

<br>

#### MMU (Memory Management Unit, 메모리 관리 장치)

- 논리 주소를 물리 주소로 변환해 준다.

- 메모리 보호나 캐시 관리 등 CPU가 메모리에 접근하는 것을 총 관리해 주는 하드웨어임

<br>

메모리의 공간이 한정적이기 때문에, 사용자에게 더 많은 메모리를 제공하기 위해 '가상 주소'라는 개념이 등장 (가상 주소는 프로그램 상에서 사용자가 보는 주소 공간이라고 보면 됨)

이 가상 주소에서 실제 데이터가 담겨 있는 곳에 접근하기 위해선 빠른 주소 변환이 필요한데, 이를 MMU가 도와주는 것

<br>

또한 메인 메모리의 직접 접근은 비효율적이므로, CPU와 메인 메모리 속도를 맞추기 위해 캐시가 존재함

<br>

#### Virtual Memory

memory의 abstraction

-> 각 process가 단독으로 메모리를 사용하는 것처럼 보이게 한다. process마다 독자적인 메모리 공간을 제공한다.

-> 프로세스 전체가 메모리 내에 올라오지 않더라도 실행이 가능하다. 메모리보다 큰 프로그램을 실행할 수 있다.

-> 라이브러리가 여러 프로세스들 사이에 공유될 수 있도록 한다. 프로세스들은 공유 메모리를 통해 통신할 수 있다.


#### Demand Paging

프로그램 실행 시작 시에 프로그램 전체를 디스크에서 물리 메모리에 적재하는 대신, 초기에 필요한 것들만 적재하는 전략.

실행과정에서 필요해질 때 페이지들이 물리 메모리에 적재된다.

#####  페이지 교체

> page fault가 발생했을 때, frame 하나를 swap out해서 빈 프레임을 확보하는 것

<br>

1. 프로세스 실행 도중 page fault 발생

2. page fault를 발생시킨 페이지 위치를 디스크에서 찾음

3. 메모리에 빈 프레임이 있는지 확인

   > 빈 프레임이 있으면 해당 프레임을 사용
   >
   > 빈 프레임이 없으면, victim 프레임을 선정해 디스크에 기록하고(swap-out) 페이지 테이블을 업데이트함

4. 빈 프레임에 페이지 폴트가 발생한 페이지를 올리고(swap-in), 페이지 테이블 업데이트

<br>

#### 오버헤드를 감소시키는 해결법

##### 방법1

변경비트를 모든 페이지마다 둬서, victim 페이지가 정해지면 해당 페이지의 비트를 확인

해당 비트가 set 상태면? → 해당 페이지 내용이 디스크 상의 페이지 내용과 달라졌다는 뜻
(즉, 페이지가 메모리 올라온 이후 한 번이라도 수정이 일어났던 것. 따라서 이건 디스크에 기록해야 함)

bit가 clear 상태라면? → 디스크 상의 페이지 내용과 메모리 상의 페이지가 정확히 일치하는 상황
(즉, 디스크와 내용이 같아서 기록할 필요가 없음)

비트를 활용해  디스크에 기록하는 횟수를 줄이면서 오버헤드에 대한 수를 최대 절반으로 감소시키는 방법임

<br>

##### 방법2

페이지 교체 알고리즘을 상황에 따라 잘 선택해야 함

현재 상황에서 페이지 폴트를 발생할 확률을 최대한 줄여줄 수 있는 교체 알고리즘을 사용

FIFO

OPT

LRU

<br>

#### 캐시 메모리 (SRAM)

> main memory (DRAM)보다 크기는 작지만 속도가 빠른 메모리.
>
> CPU가 최근에 접근한 main memory의 데이터를 저장. -> 다시 접근할 때 main memory가 아닌 cache를 참조.

CPU에는 이러한 캐시 메모리가 2~3개 정도 사용된다. (L1, L2, L3 캐시 메모리라고 부른다)

속도와 크기에 따라 분류한 것으로, 일반적으로 L1 캐시부터 먼저 사용된다. (CPU에서 가장 빠르게 접근하고, 여기서 데이터를 찾지 못하면 L2로 감)

<br>

#### CPU와 Memory의 상호작용

CPU

- fetch

   - CPU -> MMU -> Cache <-> Main Memory <-> Disk 
   
   - MMU
   
      TLB <-> Translation (Page Table in Physical Memory) (VPN -> PPN)

   Q. TLB on context switch?

   i. flush
  
   ii. pid를 같이 저장.

- decode

  opcode, register

- execute

#### 지역성 (locality)

**시간 지역성 (temporal locality)** : 최근에 참조된 주소의 내용은 곧 다음에도 참조되는 특성

**공간 지역성 (spatial locality)** : 실제 프로그램이 참조된 주소와 인접한 주소의 내용이 다시 참조되는 특성

<br>

<br>

#### Caching Line

cache memory - main memory mapping하는 여러 가지 방법.

- ##### Direct Mapped Cache

  가장 기본적인 구조로, DRAM의 여러 주소가 캐시 메모리의 한 주소에 대응되는 다대일 방식

  ex) 메모리 공간이 32개(00000-11111)이고, 캐시 메모리 공간은 8개(000-111)인 상황

  00000, 01000, 10000, 11000인 메모리 주소는 000 캐시 메모리 주소에 맵핑

  이때 000이 '인덱스 필드', 인덱스 제외한 앞의 나머지(00, 01, 10, 11)를 '태그 필드'라고 한다.

  이처럼 캐시메모리는 `tag 필드 + index 필드 + 데이터 필드`로 구성된다.

  간단하고 빠른 장점이 있지만, **Conflict Miss가 발생하는 것이 단점**이다. 같은 Index의 데이터를 동시에 사용해야 할 때 발생한다.

  <br>

- ##### Fully Associative Cache 

  비어있는 캐시 메모리가 있으면, 마음대로 주소를 저장하는 방식

  저장할 때는 매우 간단하지만, 찾을 때가 문제

  조건이나 규칙이 없어서 특정 캐시 Set 안에 있는 모든 블럭을 한번에 찾아 원하는 데이터가 있는지 검색해야 한다.

  <br>

- ##### Set Associative Cache

  Direct + Fully 방식이다. Index로 set #을 결정하고, 그 set안의 비어있는 way에 저장하는 방식이다. Direct에 비해 검색 속도는 느리지만, 저장이 빠르고 Fully에 비해 저장이 느린 대신 검색이 빠른 중간형이다.

  > 실제로 위 두가지보다 나중에 나온 방식

<br>

Q. Why not a virtually-addressed cache?

Two programs which are sharing data will have two different virtual addresses for the same physical address so have two copies of the shared data in the cache which would lead to coherence issues

<br>
