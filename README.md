# Graph-algorithm

### Matrix Construction

Given integers R1, ..., Rn and C1, ..., Cn,
implement an algorithm that determines
if there exists an n × n 0/1 matrix A such that:
(a) For all i, Sum(j=1 to n in A[i, j]) = Ri
(b) For all j, Sum(i=1 to n in A[i, j]) = Cj .


* **INPUT**: The first line of the input file gives the value of n (assume n ≤ 1000). The next line gives the
value of R1, R2, ..., Rn separated by commas. The final line gives the value of C1, C2, ..., Cn separated
by commas. Below is an example of an input file.

```
3
1,1,1
1,1,1
```

* **OUTPUT**: The first line of the output should indicate whether such a graph A exists. This is a 0/1
value. In case, this line contains 0, then the subsequent lines should be empty (since your algorithm
thinks that no such matrix can exist). In case the first line is 1, then the subsequent lines should give
the matrix. The second line should give the first row of the matrix (entries separated by commas), the
third line should give the second row of the matrix and so on. For example, consider the output file
corresponding to the input file above:

```
1
1,0,0
0,1,0
0,0,1
```
