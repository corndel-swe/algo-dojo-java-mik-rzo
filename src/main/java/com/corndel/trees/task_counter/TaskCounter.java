package com.corndel.trees.task_counter;

import com.corndel.trees.dto.Task;
import java.util.Stack;

public class TaskCounter {

    public static int countIterative(Task task) {
        int count = 0;
        Stack<Task> stack = new Stack<>();
        stack.push(task);

        while (!stack.isEmpty()) {
            Task current = stack.pop();
            count++;
            for (Task child : current.getChildren()) {
                stack.push(child);
            }
        }

        return count;
    }


    public static int countRecursive(Task task) {
        int count = 1;

        for (Task child: task.getChildren()) {
            count += countRecursive(child);
        }

        return count;
    }
}
