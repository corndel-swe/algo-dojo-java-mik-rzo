package com.corndel.trees.done_counter;

import com.corndel.trees.dto.Task;
import java.util.Stack;

public class DoneCounter {

    public static int countIterative(Task task) {
        int count = 0;
        Stack<Task> stack = new Stack<>();
        stack.push(task);

        while (!stack.isEmpty()) {
            Task current = stack.pop();
            if (current.isDone()) {
                count++;
            }
            for (Task child : current.getChildren()) {
                stack.push(child);
            }
        }

        return count;
    }

    public static int countRecursive(Task task) {
        int currentCount = task.isDone() ? 1 : 0;

        for (Task child : task.getChildren()) {
            currentCount += countRecursive(child);
        }

        return currentCount;
    }

}
