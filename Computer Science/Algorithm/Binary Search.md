## 이분 탐색(Binary Search)

#### 중복 x

```java
public static int solution(int[] arr, int M) { // arr 배열에서 M을 찾자
	
    Arrays.sort(arr); // 정렬
	
    int start = 0;
    int end = arr.length - 1;
    int mid = 0;

    while (start <= end) {
        mid = (start + end) / 2;
        if (M == arr[mid]) {
            return mid;
        }else if (arr[mid] < M) {
            start = mid + 1;
        }else if (M < arr[mid]) {
            end = mid - 1;
        }
    }
    throw new NoSuchElementException("타겟 존재하지 않음");
}
```

#### 중복 o (lower bound)

```cpp
#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    int n; cin >> n;
    vector<int> A(n);
    for(int i = 0; i < n; i++) {
        cin >> A[i];
    }
    sort(A.begin(), A.end());

    int m; cin >> m;
    while(m--) {
        int x; cin >> x;
        int lo = -1, hi = n-1;
        while(hi-lo > 1) {
            int k = (lo+hi)/2;
            if(A[k] < x) {
                lo = k;
            }
            else {
                hi = k;
            }
        }
        cout << (A[hi] == x) << '\n';
    }
}
```
