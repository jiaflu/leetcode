##二分搜索

### 二分搜索场景的应用场景
- 在有序序列中查找一个数，时间复杂度为 O(logN)
- 并不一定非要在有序序列中才能得到应用

### 二分搜索常见的考察点
- 对于边界条件的考察以及代码实现的能力

### 二分搜索常见题目的变化
- 给定处理活查找的对象不同
- 判断条件不同
- 要求返回的内容不同

### 二分搜索的重要提醒
- 可能溢出的写法：`mid = (left + right) / 2` 

- 更安全的写法：`mid = left + (right - left) / 2`