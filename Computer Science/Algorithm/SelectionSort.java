void selectionSort(int[] arr) {
    int minIndex, temp;
    int n = arr.length;
    for (int i = 0; i < n-1; i++) {
        minIndex = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        // swap
        temp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = temp;
  }
  System.out.println(Arrays.toString(arr));
}

/*

시간복잡도: O(n^2)
공간복잡도: O(1)

*/
