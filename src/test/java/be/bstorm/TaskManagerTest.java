package be.bstorm;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {

    private TaskManager manager;

    @BeforeEach
    void setUp() {
        manager = new TaskManager();
    }

    @AfterEach
    void tearDown() {
        manager = null;
    }

    @Test
    void testAddTask(){
        Task task = new Task("Task 1");
        boolean result = manager.addTask(task);

        assertTrue(result);
        List<Task> pendingTask = manager.getPendingTasks();
        assertEquals(1,pendingTask.size());
        assertEquals("Task 1",pendingTask.get(0).getDescription());
        assertFalse(pendingTask.get(0).isCompleted());
    }

    @Test
    void testRemoveTask(){
        Task task = new Task("Task 1");
        manager.addTask(task);
        boolean result = manager.removeTask("Task 1");
        assertTrue(result);
        List<Task> pendingTasks = manager.getPendingTasks();
        assertEquals(0,pendingTasks.size());
    }

    @Test
    void testRemoveTaskFailed(){
        Task task = new Task("Task 1");
        manager.addTask(task);
        boolean result = manager.removeTask("Error");
        assertFalse(result);
        List<Task> pendingTask = manager.getPendingTasks();
        assertEquals(1,pendingTask.size());
    }

    @Test
    void testMarkAsCompleted(){
        Task task = new Task("Task 1");
        manager.addTask(task);
        boolean result = manager.markTaskAsCompleted("Task 1");
        assertTrue(result);
        List<Task> pendingTasks = manager.getPendingTasks();
        List<Task> completedTasks = manager.getCompletedTasks();
        assertEquals(0,pendingTasks.size());
        assertEquals(1,completedTasks.size());
        assertTrue(completedTasks.get(0).isCompleted());
    }

    @Test
    void testMarkAsCompletedFailed(){
        Task task = new Task("Task 1");
        manager.addTask(task);
        boolean result = manager.markTaskAsCompleted("Error");
        List<Task> pendingTasks = manager.getPendingTasks();
        List<Task> completedTasks = manager.getCompletedTasks();
        assertEquals(1,pendingTasks.size());
        assertEquals(0,completedTasks.size());
        assertFalse(pendingTasks.get(0).isCompleted());
    }
}