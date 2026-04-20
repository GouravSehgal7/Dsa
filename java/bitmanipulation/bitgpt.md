🧠 BIT MANIPULATION — COMPLETE PATTERN ROADMAP

I’ll give you:

✅ Core patterns (must memorize)
✅ Questions (ordered: easy → hard)
✅ How to recognize each pattern in interview
🔑 1. BASIC BIT OPERATIONS (Foundation)
Patterns:
Get ith bit → (n >> i) & 1
Set ith bit → n | (1 << i)
Clear ith bit → n & ~(1 << i)
Toggle ith bit → n ^ (1 << i)
Practice:
Single Number
Number of 1 Bits
Counting Bits

👉 Goal: Comfort with binary

⚡ 2. XOR PATTERN (VERY IMPORTANT)
Properties:
a ^ a = 0
a ^ 0 = a
XOR is commutative
Patterns:
Find unique element
Cancel duplicates
Practice:
Single Number (1 unique)
Single Number II (3 repeats)
Missing Number
Find XOR from L to R
Recognition:

👉 “All numbers repeat except one”

🔄 3. EVEN / ODD & POWER CHECK
Patterns:
Even/odd → n & 1
Power of 2 → (n & (n-1)) == 0
Practice:
Power of Two
Power of Four
Number Complement
Recognition:

👉 “Check structure of number”

🔥 4. REMOVE LOWEST SET BIT
Trick:
n = n & (n - 1)
Uses:
Count bits
Detect powers
Practice:
Number of 1 Bits (optimized)
Brian Kernighan Algorithm
Recognition:

👉 “reduce bits one by one”

🧩 5. BIT MASKING (SUBSETS)
Patterns:
Represent set using bits
Iterate subsets
Practice:
Subsets
Subsets II
Count subsets with given XOR
Recognition:

👉 “generate all combinations”

🔁 6. SHIFTING (MULTIPLY / DIVIDE)
Patterns:
n << 1 = n * 2
n >> 1 = n / 2
Practice:
Divide Two Integers
Reverse Bits
Recognition:

👉 “optimize math operations”

🧠 7. BIT COUNT / PARITY
Patterns:
Integer.bitCount(n)
Even/odd number of 1s
Practice:
Counting Bits
K-th Grammar (parity trick 🔥)
Recognition:

👉 “flip based on number of operations”

🧬 8. GRAY CODE / PATTERN FLIPS
Patterns:
i ^ (i >> 1)
Practice:
Gray Code
Circular Permutation
Recognition:

👉 “only 1 bit changes each step”

🪞 9. MIRROR + INVERT (ADVANCED 🔥)

👉 Your current problem falls here

Patterns:
Mirror index → n - k + 1
Inversion → 1 - x
Practice:
K-th Grammar
Find Kth Bit in Nth Binary String (1545)
Reverse + invert recursion problems
Recognition:

👉 “reverse + invert + recursive structure”

🧱 10. BUILD ANSWER BIT BY BIT
Patterns:
Construct result using bits
Practice:
Sum of Two Integers (without +)
Add Binary
Maximum XOR of Two Numbers
Recognition:

👉 “simulate addition or greedy bit choice”

🚀 COMPLETE LEARNING PATH (IMPORTANT)

Follow this exact order 👇

🟢 LEVEL 1 (Basics)
Number of 1 Bits
Counting Bits
Power of Two
Single Number
🟡 LEVEL 2 (XOR + Tricks)
Missing Number
Single Number II
Find XOR of range
Reverse Bits
🟠 LEVEL 3 (Bitmasking)
Subsets
Subsets II
Maximum XOR
🔴 LEVEL 4 (Advanced Thinking)
K-th Grammar
Find Kth Bit in Nth Binary String
Gray Code