package com.corndel.trees.effort_totaller;

import com.corndel.trees.dto.Task;
import java.util.Stack;

public class EffortTotaller {

    public static int totalIterative(Task task) {
        int total = 0;
        if (task == null) {
            return 0;
        }
        Stack<Task> stack = new Stack<>();
        stack.push(task);

        while (!stack.isEmpty()) {
            Task current = stack.pop();
            total += current.getEffort();
            for (Task child : current.getChildren()) {
                stack.push(child);
            }
        }

        return total;
    }


    public static int totalRecursive(Task task) {
        if (task == null) {
            return 0;
        }
        int total = task.getEffort();

        for (Task child : task.getChildren()) {
            total += totalRecursive(child);
        }

        return total;
    }

}
