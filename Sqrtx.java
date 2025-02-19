package Алгоритмы;

class Sqrtx {
    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        if (x == 0){
            return 0;
        }
        while (left<=right){
            long mid = (left + right)/2;
            long result = mid*mid;
            if (result == x){
                return (int)mid;
            }
            else if (result < x){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return (int)left - 1;
    }

}

