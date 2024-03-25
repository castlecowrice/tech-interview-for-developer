#### 확장 개념

데이터베이스 서버의 확장성은 '수직적' 확장과 '수평적' 확장으로 나누어진다.

- 수직적 확장 : 데이터베이스 서버의 성능을 향상시키는 것 (CPU 업그레이드 등)
- 수평적 확장 : 데이터베이스 서버의 수를 늘리는 것

<br>

수평적 확장

RDBMS의 경우 수평적 확장이 어렵다.
  
join의 대상이 되는 테이블이 서로 다른 서버에 저장된 경우 overhead가 크다.

<br>

#### SQL (관계형 DB, RDBMS)

---

- 정해진 데이터 스키마에 따라 데이터를 저장한다. -> ...
- 데이터는 (테이블 간의) 관계를 통해 여러 테이블에 나누어 저장된다. -> 데이터의 중복을 피할 수 있다. / 쿼리할 때 join이 필요하다.

<br>

스키마 = set of attributes.

각 attribute는 이름과 type으로 정의된다.

<br>

<img src="https://t1.daumcdn.net/cfile/tistory/994D09355C937ECD2D">

<br>

#### NoSQL (비관계형 DB)

---

관계형 DB의 반대이다. 일반적으로 정해진 스키마가 없다. -> 유연하다. 필요에 따라 자유롭게 필드를 추가할 수 있다.

테이블 간의 관계를 정의하지 않아 테이블 간 join이 없다. 데이터를 여러 테이블에 나누어 저장하지 않고, 그 자체로 완전한 문서를 작성하여 하나의 '컬렉션'에 저장한다. (Denormalization) 

-> 반정규화로 인한 데이터 중복이 발생한다. 수정 시 중복된 데이터를 모두 업데이트해야 한다.

<br>

(따라서 위 사진에 SQL에서 진행한 Orders, Users, Products 테이블로 나눈 것을 NoSQL에서는 Orders에 한꺼번에 포함해서 저장하게 된다.)

<br>

#### NoSQL Types

1. Key-Value Model

   key-value pair를 저장한다. 값으로 모든 타입의 데이터가 가능하다.
    
   ex. Redis

2. Document Model

   key-value model의 확장으로, 값으로 document를 저장한다. key는 문서의 id.
    
   문서 = JSON과 같은 형식을 가지는 데이터.
    
   한 컬렉션에 있는 문서별로 다른 field를 가질 수 있다. (유연한 스키마)
  
   ex. MongoDB

3. Column Model
  
   ...

<br>

#### Partitioning, Sharding

cluster = shards (partitions)

shard = nodes

node = primary / read replica

<br>

#### CAP

- 일관성(Consistency)

모든 노드가 같은 시간에 같은 데이터를 보여줘야 한다.

Eventual Consistency : Consistency를 완전히 보장하지는 않지만, 데이터의 변경사항을 모든 노드에 전파하여 결과적으로 Consistency가 보장된다.

- 가용성(Availability)

읽기/쓰기 요청에 대하여 항상 응답이 가능해야 한다.

일부 NoSQL은 replication을 통해 클러스터 내에서 몇 개의 노드가 망가지더라도 정상적인 서비스가 가능하다.

- 네트워크 분할 허용성(Partition tolerance)

분산 시스템에서 네트워크가 단절되어도 각 시스템은 정상적으로 동작해야 한다.

<br>
