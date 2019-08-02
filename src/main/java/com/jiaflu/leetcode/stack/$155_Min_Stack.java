package com.jiaflu.leetcode.stack;

import java.util.Stack;

/**
 * 题目：最小栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 *
 * 示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 解答：
 * - 辅助 stack 法
 * - 借用一个辅助栈`min_stack`，用于存储`stack`中最小值：
 *   - `push`：每当 push 新值进来时，如果 “小于等于” `min_stack` 栈顶值，则一起 push 到`min_stack`，即更新了最小值；
 *   - `pop`：判断 pop 出去的元素是否是 `min_stack` 栈顶元素（即最小值），如果是则将 `min_stack` 栈顶元素一起 pop，这样可以保证`min_stack`栈顶元素始终是`stack`中的最小值。
 *   - `getMin`：返回`min_stack`栈顶即可。
 */

public class $155_Min_Stack {
    class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> min_stack;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            min_stack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if(min_stack.isEmpty() || x <= min_stack.peek())
                min_stack.push(x);
        }

        public void pop() {
            if(stack.pop().equals(min_stack.peek()))
                min_stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min_stack.peek();
        }
    }
}
