## SQL Injection

> 해커에 의해 조작된 SQL 쿼리문이 데이터베이스에 그대로 전달되어 비정상적 명령을 실행시키는 공격 기법

<br>

#### 공격 방법

##### 1) 인증 우회

```
"select * from instructor where name = ' " + name + "'"
```

SQL Injection으로 공격할 때

```
X' or 'Y' = 'Y
```

```
X'; drop table instructor; --
```

<br>

#### 방어 방법

##### 1) input 값을 받을 때, 특수문자 여부 검사하기

> 로그인 전, 검증 로직을 추가하여 미리 설정한 특수문자들이 들어왔을 때 요청을 막아낸다.

##### 3) preparestatement 사용하기

> preparestatement를 사용하면, 특수문자를 자동으로 escaping 해준다. (statement와는 다르게 쿼리문에서 전달인자 값을 `?`로 받는 것) 이를 활용해 서버 측에서 필터링 과정을 통해서 공격을 방어한다.

