## 一些算法小细节

### 异或判断符号是否相异
```java
boolean negative;
negative = (a ^ b) < 0; // 用异或来计算是否符号相异
```

### int 类型值溢出之后边界问题
当需要考虑到 int 类型值溢出之后边界问题时，可以直接将 int 转换为 long。


### 位操作
- `0 ^ x = x`
- `x ^ x = 0`
- `x & ~x = 0`
- `x & ~0 =x`

| 操作符 | 描述                                                                     | 例子                           |
| :----- | :-----------------------------------------------------------            | :----------------------------- |
| ＆     | 如果相对应位都是1，则结果为1，否则为0                                        | （A＆B），得到12，即0000 1100  |
| \|     | 如果相对应位都是0，则结果为0，否则为1                                        | （A \| B）得到61，即 0011 1101 |
| ^      | 如果相对应位值相同，则结果为0，否则为1                                       | （A ^ B）得到49，即 0011 0001  |
| 〜     | 按位取反运算符翻转操作数的每一位，即0变成1，1变成0。                           | （〜A）得到-61，即1100 0011    |
| <<     | 按位左移运算符。左操作数按位左移右操作数指定的位数。                           | A << 2得到240，即 1111 0000    |
| >>     | 按位右移运算符。左操作数按位右移右操作数指定的位数。                           | A >> 2得到15即 1111            |
| >>>    | 按位右移补零操作符。左操作数的值按右操作数指定的位数右移，移动得到的空位以零填充。 | A>>>2得到15即0000 1111         |