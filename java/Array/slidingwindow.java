public class slidingwindow {

    // Fundamental concepts < its not what you think >

    // concept of monotonicity :
    // monotonicity means that a value or state moves in only one direction 
    // (always increases, or always decreases) as you add more elements. It never reverses course.
    // If the property is Monotonic:
    // The value ONLY goes UP (e.g., Sum of positives, Bitwise OR, max , cnt , frequency cnt)
    // OR
    // The value ONLY goes DOWN (e.g., GCD, min, bitwise and)

    // For an array slice (A[L...R]) and a window evaluation function (f(A[L...R])
    // if R2 > R1 and f(A[L...R1])<=f(A[L...R2]) (monotonicity increasing)
    // if R2 > R1 and f(A[L...R1])>=f(A[L...R2]) (monotonicity decreasing)
    // If your function f satisfies either of these conditions for all 
    // possible subsegments, a dynamic sliding window is mathematically 
    // guaranteed to find the correct answer in O(N) time.
    // XOR is not monotonic
    // Sum with Negative Numbers not monotonic


    // concept of invertable function
    // Invertible Operations: if x is input , and y is function of x such that y = f(x)
    // if there exist any function g which is a function of y such that g(y) = x then g is inverse of f
    // function  -- inverse
    // add,sum,cnt sum , frequency sum -- subtraction  (NewSum = OldSum + Incoming - Outgoing)
    // multiply -- divide    (NewProd = OldProd * Incoming / Outgoing) 
    // xor -- xor  (NewXOR = OldXOR ^ Incoming ^ Outgoing)
    // we need to track extra data structure  for below function
    // for operation like : min / max (Monotonic Deque) , bitwise and/or (O(1) or (O(log K)) Two-Stack Queue / Segment Tree),  gcd (O(1) or (O(log K)) Two-Stack Queue / Segment Tree) we need to track extra data structure 


    // static window
    // The usual stuff : < Window size same , k is defined as value or can be computed, hare k define the index window should cover >

    // No Monotonicity Required: It does not matter if the array has """negative numbers""", zeros, or 
    // unpredictable values. Because the window movement is strictly forced (add one on the right, 
    // drop one on the left), it cannot get "confused."

    // we can do any operation imaginable inside a static (fixed-size) sliding window.
    // While you can do any operation in a static window, the efficiency of updating the window as it slides depends on whether the operation is invertible or non-invertible.



    // dynamic
    // window grows and shrinks dynamically
    // k is defined as target value , sum , count with any number of length of window

    // An operation is only allowed if it preserves Monotonicity.
    // Sum of Non-Negative Numbers, Frequency / Unique Count, Bitwise OR (|), Greatest Common Divisor (GCD) & Bitwise AND (&)

    // f(K)) means "At Most (K)"
    // A standard dynamic sliding window is designed only to handle inequalities 
    // (<=K) or (>= K). When you run a standard dynamic window with a constraint 
    // (K), your window counts every subarray that contains (0, 1, 2,...,) up to (K) 
    // items. It cannot easily isolate only the ones with exactly (K).
    // (f(K) - f(K-1)) gives exactly k
    

    // for at least k
    // When a problem asks for subarrays with at least K items, the moment your 
    // sliding window becomes valid (reaches K items), every single expansion to the 
    // right is also automatically valid.

    // If the window from index left to right is valid, then any subarray starting 
    // at left and ending at right, right + 1, right + 2, up to the very end of the 
    // array (N - 1) is also valid.

    // or 
    // at least k = total subarray value - atmost k-1 subarrays



    // monotonic deque concept
    
    
}
