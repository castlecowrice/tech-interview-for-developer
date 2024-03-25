#### Blocking I/O & Non-Blocking I/O

---

> I/O 작업은 Kernel level에서만 수행할 수 있다. 따라서, Process, Thread는 커널에게 I/O를 요청해야 한다.

<br>

1. #### Blocking I/O

   I/O Blocking 형태의 작업은 

   (1) Process(Thread)가 Kernel에게 I/O를 요청하는 함수를 호출한다.

   (2) Kernel이 작업을 완료하면 작업 결과를 반환받는다.

   

   * 특징
     * I/O 작업이 진행되는 동안 user Process(Thread) 는 자신의 작업을 중단한 채 대기한다.
     * Resource 낭비가 심하다. <br>(I/O 작업이 CPU 자원을 거의 쓰지 않으므로)

   <br>

2. #### Synchronous Non-Blocking I/O

   I/O 작업이 진행되는 동안 User Process의 작업을 중단하지 않는다.

   * 진행 순서

     1. User Process가 recvfrom 함수를 호출한다. (커널에게 해당 Socket으로부터 data를 받고 싶다고 요청한다.)

     2. Kernel은 이 요청에 대해서, 곧바로 recvBuffer를 채워서 보내지 못하므로, "EWOULDBLOCK"을 return한다.

     3. Blocking 방식과 달리, User Process는 다른 작업을 진행할 수 있다.

     4. recvBuffer에 user가 받을 수 있는 데이터가 있는 경우, Buffer로부터 데이터를 복사하여 받아온다.

        > 이때, recvBuffer는 Kernel이 가지고 있는 메모리에 적재되어 있으므로, Memory간 복사로 인해, I/O보다 훨씬 빠른 속도로 data를 받아올 수 있다.

     5. recvfrom 함수는 빠른 속도로 data를 복사한 후, 복사한 data의 길이와 함께 반환한다.

3. #### Asynchronous Non-Blocking I/O

  




