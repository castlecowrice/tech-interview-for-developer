# CPU Scheduling

<br>

### 선점 / 비선점 스케줄링

- 선점 (preemptive) : OS가 CPU의 사용권을 선점할 수 있다.
- 비선점 (nonpreemptive) : 프로세스 종료 or I/O 등의 이벤트가 있을 때까지 실행을 보장한다.

### 프로세스 상태

![download (5)](https://user-images.githubusercontent.com/13609011/91695344-f2dfae80-eba8-11ea-9a9b-702192316170.jpeg)
- 선점 스케줄링 : `Interrupt`, `I/O or Event Completion`, `I/O or Event Wait`, `Exit`
- 비선점 스케줄링 : `I/O or Event Wait`, `Exit`

---

**프로세스의 상태 전이**

✓ **승인 (Admitted)** : 프로세스 생성이 가능하여 승인됨.

✓ **스케줄러 디스패치 (Scheduler Dispatch)** : 준비 상태에 있는 프로세스 중 하나를 선택하여 실행시키는 것.

✓ **인터럽트 (Interrupt)** : timer, i/o complete, priority... 등이 발생하여 현재 실행 중인 프로세스를 준비 상태로 바꾸고, interrupt handler가 실행.

✓ **입출력 또는 이벤트 대기 (I/O or Event wait)** : 실행 중인 프로세스가 r/w syscall, page fault, acquire lock...를 처리해야 하는 경우, 끝날 때까지 대기 상태로 만드는 것.

✓ **입출력 또는 이벤트 완료 (I/O or Event Completion)** : 입출력 등이 끝난 프로세스를 준비 상태로 바꿔 스케줄러에 의해 선택될 수 있도록 만드는 것.

ex.

1. [user mode] t1 running -> read system call -> [kernel mode] save t1 state, t1 waiting, restore t2
2. [user mode] t2 running -> I/O completion (interrupt) -> [kernel mode] save t2 state, t1 ready, restore t2
3. [user mode] t2 running -> timer interrupt -> [kernel mode] save t2 state, t2 ready, restore t1
4. [user mode] t1 running -> ...

### CPU 스케줄링의 종류

- 비선점 스케줄링
    1. FCFS (First Come First Served)
        - 큐에 도착한 순서대로 실행
        - 실행 시간이 짧은 게 뒤로 가면 평균 대기 시간이 길어짐
    2. SJF (Shortest Job First)
        - 실행시간(CPU burst time)이 가장 짧은 프로세스를 먼저 실행
        - FCFS 보다 평균 대기 시간 감소 / starvation 가능성

- 선점 스케줄링
    1. SRTF (Shortest Remaining Time First)
        - 현재 실행중인 프로세스의 남은 burst time 보다 더 짧은 새로운 프로세스가 도착하면 preempt.
        - starvation 가능성
    2. Priority Scheduling
        - 정적/동적으로 우선순위를 부여하여 우선순위가 높은 순서대로 실행
        - starvation 가능성 -> Aging 
    3. Round Robin
        - 기본 FCFS에 더해, 각 프로세스에 동일한 `Time Quantum(Slice)` 할당. Time Slice가 끝나면 preempt, 큐의 맨 뒤로 보냄
        - Time Quantum이 크면 FCFS와 같게 되고, 작으면 잦은 Context Switch로 오버헤드 증가
    4. Multilevel-Queue (다단계 큐)
    
        ![Untitled1](https://user-images.githubusercontent.com/13609011/91695428-16a2f480-eba9-11ea-8d91-17d22bab01e5.png)
        - 작업들을 우선순위에 따라 나누어 여러 개의 큐를 이용하는 기법
        - starvation 가능성 -> queue마다 일정 %만큼 실행 시간 할당.
  
    5. Multilevel-Feedback-Queue (다단계 피드백 큐)

        ![Untitled2](https://user-images.githubusercontent.com/13609011/91695489-2cb0b500-eba9-11ea-8578-6602fee742ed.png)

        - 다단계 큐에서 자신의 `Time Quantum`을 다 채운 프로세스 (CPU-intensive)는 밑으로 내려가고, (I/O로 인해) 자신의 `Time Quantum`을 다 채우지 못한 프로세스는 원래 큐 그대로
        - 짧은 작업, 입출력 위주, Interactive Task에 우선권을 줌
        - 처리 시간이 짧은 프로세스를 먼저 처리하기 때문에 Turnaround 평균 시간을 줄여줌

        ![Untitled](https://user-images.githubusercontent.com/13609011/91695480-2a4e5b00-eba9-11ea-8dbf-390bf0a73c10.png)

        - 우선순위가 낮은 큐들이 실행 못하는 걸 방지하고자 각 큐마다 다른 `Time Quantum`을 설정 해주는 방식 사용
        - 우선순위가 높은 큐는 작은 `Time Quantum` 할당. 우선순위가 낮은 큐는 큰 `Time Quantum` 할당.

### CPU 스케줄링 척도

1. Response Time
    - 작업이 처음 실행되기까지 걸린 시간 (first execution time - arrival time)
2. Turnaround Time
    - 실행 시간과 큐에서 대기한 시간(= waiting time)을 모두 합한 시간으로 작업이 완료될 때 까지 걸린 시간 (completion time - arrival time)

---

### 출처

- 스케줄링 목표 : [링크](https://jhnyang.tistory.com/29?category=815411)
- 프로세스 전이도 그림 출처 : [링크](https://rebas.kr/852)
- CPU 스케줄링 종류 및 정의 참고 : [링크](https://m.blog.naver.com/PostView.nhn?blogId=so_fragrant&logNo=80056608452&proxyReferer=https:%2F%2Fwww.google.com%2F)
- 다단계큐 참고 : [링크](https://jhnyang.tistory.com/28)
- 다단계 피드백 큐 참고 : [링크](https://jhnyang.tistory.com/156)
