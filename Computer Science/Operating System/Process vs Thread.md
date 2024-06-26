# 프로세스 & 스레드

<br>

> **프로세스** : 메모리 상에서 실행중인 프로그램의 한 instance.
>
> **스레드** : 프로세스 안에서 실행되는 여러 실행 흐름의 단위

<br>

기본적으로 프로세스마다 최소 1개의 스레드 소유 (메인 스레드 포함)

<br>

![img](https://camo.githubusercontent.com/3dc4ad61f03160c310a855a4bd68a9f2a2c9a4c7/68747470733a2f2f74312e6461756d63646e2e6e65742f6366696c652f746973746f72792f393938383931343635433637433330363036)

프로세스는 각각 독립적인 메모리 공간 할당

- Code : 프로그램의 instruction을 담고 있는 영역

- Data : 전역변수, static 변수 등
  - 초기화 된 데이터는 data 영역에 저장
  - 초기화 되지 않은 데이터는 bss 영역에 저장
- Heap : 동적 할당 시 사용 (new(), malloc() 등)

- Stack : local variable, parameter, return address (임시 데이터 저장)

<br>

스레드는 Stack + Register만 따로 할당 받고 나머지 영역 (메모리, open file descriptor 등)은 서로 공유

- Stack + Register만 따로 할당 받는 이유
  - 쓰레드는 독립적인 실행 흐름
  - 즉 독립적으로 함수를 call하고 return 할 수 있어야 한다
  - 때문에 함수의 매개변수, 지역변수등을 저장하는 스택 메모리 영역은 독립적으로 할당 받아야 한다

<br>

**프로세스는 자신만의 고유 공간과 자원을 할당받아 사용**하는데 반해, **스레드는 다른 스레드와 공간, 자원을 공유하면서 사용**하는 차이가 존재함

<br>

<br>

##### 멀티프로세스

> 하나의 프로그램을 여러개의 프로세스로 구성하여 각 프로세스가 병렬적으로 작업을 수행하는 것

**장점** : 안전성

**단점** : 각각 독립된 메모리 공간을 갖고 있어 오버헤드 발생. Context Switch로 인한 성능 저하

<br>

***Context Switch***

> 프로세스의 상태 정보를 저장하고 복원하는 일련의 과정
>
> 즉, 동작 중인 프로세스가 대기하면서 해당 프로세스의 상태를 보관하고, 대기하고 있던 다음 순번의 프로세스가 동작하면서 이전에 보관했던 프로세스 상태를 복구하는 과정을 말함
>
> → 프로세스는 각 독립된 메모리 영역을 할당받아 사용되므로, cache miss 발생 증가.

<br>

<br>

##### 멀티 스레드

> 하나의 응용 프로그램에서 여러 스레드를 구성해 각 스레드가 하나의 작업을 처리하는 것

<br>

**장점** : 독립적인 프로세스에 비해 가볍다.

**단점** : 안전성 문제. 공유 자원에 대한 동기화 필요. 

하나의 스레드가 비정상적으로 동작하면 다른 스레드도 종료될 수 있습니다. 

-> 한 스레드가 공유된 자원을 비정상적으로 수정하거나 손상시키는 경우, 다른 스레드도 이에 영향을 받아 비정상적인 동작을 할 수 있습니다.

<br>

멀티스레드의 안전성에 대한 단점은 Critical Section 기법을 통해 대비함

-> Mutual Exclusion, Progress, Bounded Waiting...
