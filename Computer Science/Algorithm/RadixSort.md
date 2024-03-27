#### Radix sort

----

데이터를 구성하는 기본 요소 (Radix) 를 이용하여 정렬을 진행하는 방식

* 시간 복잡도 : O(d * (n + b))  

  -> d는 정렬할 숫자의 자릿수, b는 10

* 장점 : 문자열, 정수 정렬 가능.

* 단점 : 자릿수가 없는 것은 정렬할 수 없음. (부동 소숫점)

  중간 결과를 저장할 bucket 공간이 필요함. (queue)

#### 소스 코드 (LSD)

```cpp
queue<int> bucket[10];

void radix_sort() {
	for (int i = 1; i <= MAX; i = i * 10) {
		for (int j = 0; j < N; j++) {
			int k = (A[j] / i) % 10;
			bucket[k].push(A[j]);
		}
		int j = 0;
		for (int k = 0; k < 10; k++) {
			while (!bucket[k].empty()) {
				A[j] = bucket[k].front();
				bucket[k].pop();
				j++;
			}
		}
	}
}

```

#### 질문

---

Q. MSD (Most-Significant-Digit) vs LSD (Least-Significant-Digit)

MSD는 가장 높은 자리수부터 sort 하는 것을 의미하고, LSD는 가장 낮은 자리수부터 sort 하는 것을 의미함.

* MSD 는 정렬 중간에 정렬이 될 수 있다. -> 정렬하는데 걸리는 시간을 줄일 수 있다. 하지만 정렬이 완료되는지 확인하는 과정이 필요하다.

* LSD radix sorts typically use the following sorting order: short keys come before longer keys, and then keys of the same length are sorted lexicographically. This coincides with the normal order of integer representations, like the sequence [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].

* MSD radix sorts are most suitable for sorting strings or fixed-length integer representations. A sequence like [b, c, e, d, f, g, ba] would be sorted as [b, ba, c, d, e, f, g].
