#### Comparison-Based Sort

------

> 스무고개 게임을 한다고 생각해 보자. 한 명이 배열의 두 원소를 비교하는 질문을 하면, 다른 한 명이 답을 해 준다.
>
> 답을 하는 사람은 (A[i] > A[j]?) 라는 질문이 들어올 때마다, 답이 YES인 순열의 집합과 답이 NO인 순열의 집합 중 항상 더 큰 집합의 답을 준다.
>
> 그러면 질문 한 번에 최대 절반까지 순열의 집합의 크기를 줄일 수 있으므로, 최소 log(n!) = O(nlogn) 번의 질문 (비교 연산)을 해야 한다.

https://www.cs.cmu.edu/~avrim/451f11/lectures/lect0913.pdf

#### Counting Sort 과정

----

시간 복잡도 : O(n + k) -> k는 배열에서 등장하는 최댓값

공간 복잡도 : O(k)

Counting : 각 숫자가 몇 번 등장하는지 센다.

```c
int A[N];
int B[N];
int count[MAX+1];

for (int i = 0; i < N; i++) {
    count[arr[i]]++;
}

int k = 0;
for (int i = 0; i <= MAX; i++) {
    for(int j = 0; j < count[i]; j++) {
        B[k++] = i;
    }
}

```

* 사용 : 정렬하는 숫자가 특정한 범위 내에 있을 때 사용한다.

* 장점 : 선형 시간복잡도

* 단점 : 배열의 최댓값이 크면 시간/공간복잡도가 커진다.
