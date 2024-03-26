#### 머지 소트(Merge Sort)

---

합병 정렬이라고도 부르며, 분할 정복을 통해 구현

요소를 쪼갠 후, 다시 합병시키면서 정렬해나가는 방식으로, 쪼개는 방식은 퀵정렬과 유사

**시간복잡도**

|   평균   |   최선   |   최악   |
| :------: | :------: | :------: |
| Θ(nlogn) | Ω(nlogn) | O(nlogn) |

**공간복잡도**
O(n)

<br>

- mergeSort

```java
public void mergeSort(int[] array, int left, int right) {
    
    if(left < right) {
        int mid = (left + right) / 2;
        
        mergeSort(array, left, mid);
        mergeSort(array, mid+1, right);
        merge(array, left, mid, right);
    }
    
}
```

정렬 로직에 있어서 merge() 메소드가 핵심



*퀵소트와의 차이점*

> 퀵정렬 : 우선 피벗을 통해 정렬(partition) → 영역을 쪼갬(quickSort)
>
> 합병정렬 : 영역을 쪼갤 수 있을 만큼 쪼갬(mergeSort) →  정렬(merge)

<br>

- merge()

```java
public static void merge(int[] array, int left, int mid, int right) {
    int[] L = Arrays.copyOfRange(array, left, mid + 1);
    int[] R = Arrays.copyOfRange(array, mid + 1, right + 1);
    
    int i = 0, j = 0, k = left;
    int l = L.length, r = R.length;
    
    while(i < l && j < r) {
        if(L[i] <= R[j]) {
            array[k++] = L[i++];
        }
        else {
            array[k++] = R[j++];
        }
    }
    
    // remain
    while(i < l) {
        array[k++] = L[i++];
    }
    while(j < r) {
        array[k++] = R[j++];
    }
}
```

이미 **합병의 대상이 되는 두 영역이 각 영역에 대해서 정렬이 되어있기 때문**에 단순히 두 배열을 **순차적으로 비교하면서 정렬할 수가 있다.**


**★★★합병정렬은 순차적**인 비교로 정렬을 진행하므로, **LinkedList의 정렬이 필요할 때 사용하면 효율적**이다.★★★


*LinkedList를 퀵정렬을 사용해 정렬하면?*

> 성능이 좋지 않음
>
> 퀵정렬은, 순차 접근이 아닌 **임의 접근이기 때문**

