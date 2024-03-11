#### [DB] Anomaly

---

> 정규화를 해야하는 이유는 [잘못된 테이블 설계로 인해 Anomaly (이상 현상)]가 나타나기 때문이다.
>
> 하나의 relation에 너무 많은 attribute를 집어 넣으려고 하면 발생 -> decomposition 필요.


예) student(ID, name, dept_name), department(dept_name, building)

-> std_dept(ID, name, dept_name, building)

복수전공 가능. primary key = {ID, dept_name}


1. 삽입 이상 (Insertion Anomaly)

   새 department를 추가하지 못함. (ID null)

   Q. 그럼에도 추가해야 한다면?

   A. ID = 0


2. 갱신 이상 (Update Anomaly)

   update std_dept
   set building = 'A'
   where name 'B';

   name이 B인 학생의 building만 변경, 다른 학생의 building은 변경 x

   

3. 삭제 이상 (Deletion Anomaly)

   어떤 department에 속한 학생이 1명. 그 학생을 삭제하면, department에 대한 정보 (building) 도 삭제됨.


Q. student(ID, name, dept_name)은 anomaly가 없는가?

A. partial FD (ID -> name)이 존재한다. 2NF가 아님.
