## Exception

##### 정의

프로그램을 실행하는 도중에 특정 event가 발생하여 실행 흐름이 kernel로 넘어가는 상황

<br>

##### Asynchronous(Hardware) Exception = Interrupt

  - Timer Interrupt
  - I/O Interrupt (data from network, disk, ...)

  <br>

##### Synchronous Exception

Caused by events that occur as a result of executing an instruction.

  - Trap (system call, ...)
  - Fault (page fault, ...)
  - Abort (illegal instruction, ...)

<br>

#### 인터럽트 발생 처리 과정

<img src=" https://mblogthumb-phinf.pstatic.net/20160310_124/scw0531_14575366291105WjS7_PNG/ERTRTETRE.png?type=w2 ">

만약 **인터럽트 기능이 없었다면**, CPU는 Interrupt가 발생했는지 알기 위해 주기적으로 확인을 해야 한다. (이를 폴링(Polling)이라고 한다)

-> CPU 시간이 낭비된다.

<br>

즉, 컨트롤러가 입력을 받아들이는 방법(우선순위 판별방법)에는 두가지가 있다.

- ##### 폴링 방식

  사용자가 명령어를 사용해 입력 핀의 값을 계속 읽어 변화를 알아내는 방식

  인터럽트 요청 플래그를 차례로 비교하여 우선순위가 가장 높은 인터럽트 자원을 찾아 이에 맞는 인터럽트 서비스 루틴을 수행한다. (하드웨어에 비해 속도 느림)

- ##### 인터럽트 방식

  MCU 자체가 하드웨어적으로 변화를 체크하여 변화 시에만 일정한 동작을 하는 방식

  - Daisy Chain
  - 병렬 우선순위 부여 

<br>

인터럽트 방식은 하드웨어로 지원을 받아야 하는 제약이 있지만, 폴링에 비해 신속하게 대응하는 것이 가능하다. 따라서 **'실시간 대응'**이 필요할 때는 필수적인 기능이다.

<br>

즉, 인터럽트는 **발생시기를 예측하기 힘든 경우에 컨트롤러가 가장 빠르게 대응할 수 있는 방법**이다.

