package education;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Simulator {
    public static final Logger logger = Logger.getLogger(Simulator.class.getName());
    public static void main(String[] args) {
        var tasks = new ArrayList<Task>();
        for (int i = 0; i < 3; i++){
            var task = Task.generateRandomTask();
            tasks.add(task);
        }
        var students = new ArrayList<Student>();
        for (int i = 0; i < 3; i++){
            var st = Student.createRandomStudent();
            for (var task:tasks){
                st.getTasksToDo().add(task.copy());
            }
            students.add(st);
        }
        var professor = new Professor();
        professor.students = students;
        for (;;){
            try {
                Thread.sleep(1000);
                logger.info("new day\n");
                for (var student:students) {
                    Thread.sleep(1000);
                    student.work();
                }
                professor.evaluateRandom();
            }
            catch (Exception e){
                logger.warning("something went wrong" + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}
