/**
 * Created by jianiyang on 16/7/14.
 */
public class SearchInRotatedArray {
    public int search(int[] A, int target){
        if(A == null || A.length == 0){
            return -1;
        }

        int l = 0;
        int r = A.length - 1;

        while(l <= r){ //有可能长度为奇数,所以l可以等于r;
            int m = (l + r)/2; //每次都取中点,所以必须放在while里面;
            if(target == A[m]){
                return m;
            }
            if(A[m] < A[r]){
                if(target > A[m] && target <= A[r]){
                    l = m + 1;
                }else
                    r = m-1;
            }else{
                if(target >= A[l] && target < A[m]){
                    r = m - 1;
                }else{
                    l = m + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] A = {4,5,6,1,2,3};
        int target = 5;
        SearchInRotatedArray res = new SearchInRotatedArray();
        int output = res.search(A, target);
        System.out.println(output);
    }
}
