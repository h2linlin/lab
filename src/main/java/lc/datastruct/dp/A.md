动态规划篇

### 概述

关于动态规划：

- 动态规划的算法名字，和它具体的算法没有关系。这个名字是创始人用来忽悠美国军方的，让别人不知道他到底在干啥。

- 动态规划是一种思想：充分利用已有的结果，推算之后的结果。从而避免暴力搜索，大幅降低时间复杂度。类似KMP。

- 动态规划解决的问题：一般的问题场景是，总的问题可以拆分为很多个子问题，然后可以根据子问题的局部最优，最终推导出总问题的最优解。同时前一个子问题会影响当前子问题的结果。当前子问题的最优抉择，是根据前一子问题的抉择来决定的。

- 动态规划的思路：类似高中的数列。

  - 数列是要求得到递推公式，然后根据递推公式用归纳法等方式推出通项公式。
  
  - 而动态规划的状态转移公式，就相当于数组的递推公式。不同的是，动态规划无需求出通项公式（也不一定能求出来），而是直接从初值开始，根据状态转移公式，暴力推导出来。
  
  - 所以动态规划算法的关键就是，**确定dp[]数组的含义**。有了这个含义，就很容易得到状态转移公式，以及赋初值、遍历。

**动态规划五部曲**：

1. dp数组：确定dp数组及下标：dp数组及下标含义

2. 公式：确定递推公式：确定递推公式

3. 初始化：dp数组如何初始化。要先确定公式才初始化方式，因为某些情况下公式决定了数组如何初始化

4. 遍历：确定遍历顺序：从前往后、从后往前等

5. 举例：举例推导dp数组

复杂一点的递推公式，dp[i]可能是需要自己处理来推出来的。而且，递推公式是通过观察得到的。。例如：
```java
// N0096 不同的二叉搜索树，递推公式
for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // 递推公式
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
```

### 背包问题：


