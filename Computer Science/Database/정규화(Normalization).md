# 정규화(Normalization)

<br>

```
데이터의 중복과 이상 현상(anomaly)를 줄이기 위해 relation을 분해(decompose)하는 과정

decomposition

1. lossless join

2. preserve functional dependency
```

<br>

정규화에는 여러가지 단계가 있지만, 대체적으로 1~3단계 정규화까지의 과정을 거친다.

<br>

### Functional Dependency

a -> b

a uniquely determines b (a가 b를 유일하게 결정한다. b는 a에 종속된다.)

a = determinant, b = dependent

### 제 1정규화(1NF, first normal form)

테이블 컬럼이 원자값(하나의 값, atomic value)을 갖도록 테이블을 분리시키는 것을 말한다.

<br>

<img src="http://dl.dropbox.com/s/9s8vowdzs3t66uw/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202018-12-02%2017.50.02.png">

<br>

현재 테이블은 전화번호를 여러개 가지고 있어 원자값이 아니다. 따라서 1NF에 맞추기 위해서는 아래와 같이 분리할 수 있다.

<br>

<img src="http://dl.dropbox.com/s/1rr8ofxuy46i61b/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202018-12-02%2018.00.52.png">

<br>

<br>

### 제 2정규화(2NF, second normal form)

1NF를 만족하면서, 기본키에 속하지 않은 attribute가 기본키에 대해 완전 함수적 종속을 만족해야 한다.

= 테이블에서 기본키의 부분집합만으로 다른 컬럼을 결정지을 수 있으면 안된다.

<br>

<img src="http://dl.dropbox.com/s/c2xfxdanbuiaw1l/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202018-12-03%2006.58.17.png">

<br>

`Manufacture`과 `Model`이 키가 되어 `Model Full Name`을 알 수 있다.

`Manufacturer Country`는 `Manufacturer`로 인해 결정된다. (부분 함수 종속)

따라서, `Model`과 `Manufacturer Country`는 아무런 연관관계가 없는 상황이다.

<br>

결국 완전 함수적 종속을 충족시키지 못하고 있는 테이블이다. 부분 함수 종속을 해결하기 위해 테이블을 아래와 같이 나눠서 2NF를 만족할 수 있다.

<br>

<img src="http://dl.dropbox.com/s/x8481598dhnpzeg/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202018-12-03%2010.58.15.png">

<br>

<br>

### 제 3정규화(3NF, third normal form)

2NF를 만족하면서, 기본키가 아닌 속성들이 기본키에 이행적 종속되지 않아야 한다.

= 기본키가 아닌 속성들은 기본키에 종속되며, 기본키가 아닌 속성에 종속되지 않는다.

<br>

<img src="http://dl.dropbox.com/s/xtfoetv8hg6jn3f/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202018-12-03%2012.59.46.png">

<br>

현재 테이블에서는 `Tournament`와 `Year`이 기본키다.

`Winner`는 이 두 복합키를 통해 결정된다.

하지만 `Winner Date of Birth`는 기본키가 아닌 `Winner`에 의해 결정되고 있다. 

따라서 이는 3NF를 위반하고 있으므로 아래와 같이 분리해야 한다.

<br>

<img src="http://dl.dropbox.com/s/ks03nkc26nsffin/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202018-12-04%2014.51.39.png">

<br>

### BCNF

3NF를 만족하면서, 모든 결정자가 후보키 집합에 속해야 한다.

#### [참고 사항]

- [링크](https://wkdtjsgur100.github.io/database-normalization/)
