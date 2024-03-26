void bubbleSort(int[] arr) {
	int n = arr.length;
	for(int i = 1; i < n; i++) {
		for(int j = 0; j < n-i; j++) {
			if(arr[j] > arr[j+1]) {
				int temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
			}
		}
	}
	System.out.println(Arrays.toString(arr));
}

/*

시간복잡도 : O(n^2)
공간복잡도 : O(1)

*/
