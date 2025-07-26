package com.corndel.trees.max_effort_finder;

import com.corndel.trees.dto.Task;
import java.util.Stack;

public class MaxEffortFinder {

    public static int findIterative(Task task) {
        int maxEffort = task.getEffort();
        Stack<Task> stack = new Stack<>();
        stack.push(task);

        while (!stack.isEmpty()) {
            Task current = stack.pop();
            if (current.getEffort() > maxEffort) {
                maxEffort = current.getEffort();
            }
            for (Task child : current.getChildren()) {
                stack.push(child);
            }
        }

        return maxEffort;
    }

    public static int findRecursive(Task task) {
        int maxEffort = task.getEffort();

        for (Task child : task.getChildren()) {
            int childEffort = findRecursive(child);
            if (childEffort > maxEffort) {
                maxEffort = childEffort;
            }
        }

        return maxEffort;
    }
}
