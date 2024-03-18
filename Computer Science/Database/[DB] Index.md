# Index(인덱스)

<br>

#### 목적

책의 Index와 같다고 생각하면 편하다.

테이블의 검색 속도를 향상시키기 위한 자료구조.

테이블을 풀스캔하는 대신, B+ Tree를 이용하여 특정 컬럼에 특정 값을 가진 튜플을 빠르게 찾을 수 있게 해 주는 data structure.

<br>

#### 파일 구성

MySQL에서 테이블 생성 시, 3가지 파일이 생성된다.

- FRM : 테이블 구조(schema) 저장 파일
- MYD : 실제 데이터 파일
- MYI : Index 정보 파일

<br>

사용자가 쿼리를 통해 Index를 사용하는 칼럼을 검색하게 되면, 이때 MYI 파일의 내용을 활용한다.

<BR>

#### 단점

- 저장공간 필요.
- 인덱스 된 Field에서 **Record를 추가, 삭제, 수정 시 성능이 떨어진다.**

<br>

#### 상황 분석

- ##### 사용하면 좋은 경우

  (1) Where 절에서 자주 사용되는 Column

  (2) foreign key가 사용되는 Column

  (3) Join에 자주 사용되는 Column

1 -> b+tree를 사용하여 range query 처리하기 좋음.

2, 3 -> join할 때 join attribute의 값이 일치하는 튜플을 찾아야 하기 때문.

  <br>

- ##### Index 사용을 피해야 하는 경우

  (1) DML이 자주 일어나는 Column

  (2) 중복도가 높은 (cardinality가 낮은) Column (성별 등)

2 -> 인덱스로 값을 많이 거를 수 없어서?

<br>

#### DML이 일어났을 때의 상황

- INSERT: 새로운 데이터에 대한 인덱스를 추가함 (정렬된 상태를 유지하는 overhead 발생)
- DELETE: 삭제하는 데이터의 인덱스를 사용하지 않는다는 작업을 진행함 (실제 데이터 수 < 인덱스 데이터 수)
- UPDATE: 기존의 인덱스를 사용하지 않음 처리하고, 갱신된 데이터에 대해 인덱스를 추가함 (INSERT, DELETE 단점 공유)

<br>

<br>

#### 인덱스 관리 방식

- ##### B-Tree 자료구조

  BST 확장. 노드 하나에 2개 이상(N개) 데이터. Balanced Tree. → 탐색 연산에 있어 O(log N)의 시간복잡도를 갖는다.

  모든 노드들에 대해 값을 저장하고 있으며 포인터 역할을 동반한다.

- ##### B+Tree 자료구조

  B-Tree를 개선한 형태의 자료구조

  값을 리프노드에만 저장하며 리프노드는 링크드 리스트로 연결되어 있다 → 때문에 부등호문 연산에 대해 효과적이다.

  리프 노드를 제외한 노드들은 포인터의 역할만을 수행한다.

- ##### HashTable 자료구조

  해시 함수를 이용해서 값을 인덱스로 변경 하여 관리하는 자료구조

  일반적인 경우 탐색, 삽입, 삭제 연산에 대해 O(1)의 시간 복잡도를 갖는다. (worst case O(N))

  값 자체를 변경하기 때문에 부등호문 연산에 사용할 수 없다.

#### Clustered Index vs Non-clustered Index

Clustered Index (= Primary Key by default)

전화번호부는 (물리적으로) 이름 순으로 정렬. -> 이름 = Clustered Index.

disk에 데이터가 저장될 때 clustered index의 순서와 동일하게 저장됨.

tree의 leaf는 실제 physical data가 저장되어 있음.

Non-clustered Index

책의 색인. 단어 순으로 정렬되어 있지만, 실제 책은 단어가 순서대로 나타나지 않음. -> 단어 = Non-clustered Index.

tree의 leaf에는 실제 physical row로 향하는 pointer가 저장되어 있음.

#### Composite Index

(a, b, c) -> 사전순 정렬 생각.

SELECT WHERE (a), (a, b) -> ok.
SELECT WHERE (b), (b, c) -> no.

##### [참고사항]

- [링크](https://lalwr.blogspot.com/2016/02/db-index.html)
