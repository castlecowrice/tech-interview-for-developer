#### 퀵소트

---

퀵소트는 최악의 경우 O(n^2), 평균적으로 Θ(nlogn)



```cpp
int A[1000];

int _partition(int left, int right) {
    int mid = (left+right)/2;
    swap(A[left], A[mid]);
    int pivot = A[left];
    int i = left;
    for(int j = left+1; j <= right; j++) {
        if(A[j] < pivot) {
            swap(A[++i], A[j]);
        }
    }
    swap(A[left], A[i]);
    
    return i;
}

void quickSort(int left, int right) {
    
    if(left >= right) return;
    
    int pivot = _partition(left, right);
    
    quickSort(left, pivot-1);
    quickSort(pivot+1, right);
    
}
```

---

- **피벗 값이 최소나 최대값으로 지정되어 파티션이 나누어지지 않았을 때** O(n^2)

- 다른 O(nlogn) 시간복잡도를 가진 소트들보다 빠르다고 알려져있음

    -> 캐시 (?)
