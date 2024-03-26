void insertionSort(int[] arr)
{
   for(int i = 1 ; i < arr.length ; i++) {
      int temp = arr[i];
      int j = i - 1;
      while( j >= 0 && arr[j] > temp ) {
         arr[j+1] = arr[j];
         j--;
      }
      arr[j+1] = temp;
   }
   System.out.println(Arrays.toString(arr));
}

/* 

시간복잡도 : O(n) ~ O(n^2)
공간복잡도 : O(1)

*/
