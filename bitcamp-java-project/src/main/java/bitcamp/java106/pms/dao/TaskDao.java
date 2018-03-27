package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Task;

public class TaskDao {
    Task[] tasks = new Task[1000];
    int taskIndex = 0;
    
    public void insert(Task task) {
        // 팀 정보가 담겨있는 객체의 주소를 배열에 보관한다.
        task.setNo(taskIndex);
        this.tasks[this.taskIndex++] = task;
    }
    
    public Task getTask(String teamName, int no) {
        for (int i = 0; i < this.taskIndex; i++) {
            if (tasks[i] == null) continue;
            if (tasks[i].getTeam().getName().toLowerCase().equals(teamName) 
                    && (tasks[i].getNo() == no)) {
                return tasks[i];
            }
        }
        return null;
    }
    
    public int count(String teamName) {
        int count = 0;
        for (int i = 0; i < this.taskIndex; i++) {
            if (tasks[i] == null) continue;
            if (tasks[i].getTeam().getName().toLowerCase().equals(teamName)) {
                count++;
            }
        }
        return count;
    }
    
    public Task[] list(String teamName) {
        Task[] arr = new Task[count(teamName)];
        for (int i = 0, x = 0; i < this.taskIndex; i++) {
            if (tasks[i] == null) continue;
            if (tasks[i].getTeam().getName().toLowerCase().equals(teamName)) {
                arr[x++] = this.tasks[i];
            }
        }
        return arr;
    }
    
//    public Task get(String name) {
//        int i = this.getTaskIndex(name);
//        if (i == -1)
//            return null;
//        return tasks[i];
//    }
//    
    public void update(Task task) {
        tasks[task.getNo()] = task;
    }
//    
    public void delete(Task task) {
        tasks[task.getNo()] = null;
    }
//    
//    private int getTaskIndex(String name) {
//        for (int i = 0; i < this.taskIndex; i++) {
//            if (this.tasks[i] == null) continue;
//            if (name.equals(this.tasks[i].getName().toLowerCase())) {
//                return i;
//            }
//        }
//        return -1;
//    }

}