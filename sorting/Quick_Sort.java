import java.util.Arrays;

public class sorted_array {
	public static void main(String[] args) {
		int[] arr = { 1, 3, 78, 5, 77, 22 };
		quick_sort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));

	}

	public static void quick_sort(int[] arr, int start , int end) {
		if(start>= end) {
			return;
		}
		int left = start;
		int right = end;
		int mid = (left + right) / 2;
		while (left <= right) {
			while (arr[left] < arr[mid]) {
				left++;
			}
			while (arr[right] > arr[mid]) {
				right--;
			}
			if(left<= right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
			}
		}
		quick_sort(arr, start, right);
		quick_sort(arr, left, end);
	}

}

// Output

// [1, 3, 5, 22, 77, 78]
