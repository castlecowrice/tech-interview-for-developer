#### [DB] Anomaly

---

> 정규화를 해야하는 이유는 [잘못된 테이블 설계로 인해 Anomaly (이상 현상)]가 나타나기 때문이다.
>
> 하나의 relation에 너무 많은 attribute를 집어 넣으려고 하면 발생 -> decomposition 필요.

삽입 이상 : tuple을 추가할 때, 필요 없는 속성에 대한 데이터도 함께 추가해야 한다.

갱신 이상 : 갱신할 때 관련된 모든 tuple이 아닌 일부 tuple만 갱신되어 일관성이 깨진다.

삭제 이상 : tuple의 일부 데이터만 삭제하고 싶지만, tuple 전체를 삭제해야 하면서 정보 손실이 일어난다.

예) student(ID, name, dept_name) + department(dept_name, building) -> student_department
