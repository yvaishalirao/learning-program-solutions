public class MVCMain {

    static class Student {
        private String name;
        private String id;
        private String grade;

        public Student(String name, String id, String grade) {
            this.name = name;
            this.id = id;
            this.grade = grade;
        }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public String getGrade() { return grade; }
        public void setGrade(String grade) { this.grade = grade; }
    }

    static class StudentView {
        public void displayStudentDetails(Student student) {
            System.out.println("Student Info: " + student.getName() + " | ID: " + student.getId() + " | Grade: " + student.getGrade());
        }
    }

    static class StudentController {
        private Student student;
        private StudentView view;

        public StudentController(Student student, StudentView view) {
            this.student = student;
            this.view = view;
        }

        public void setStudentName(String name) { student.setName(name); }
        public void setStudentGrade(String grade) { student.setGrade(grade); }
        public void updateView() { view.displayStudentDetails(student); }
    }

    public static void main(String[] args) {
        Student student = new Student("Vaishali", "S101", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        controller.updateView();

        controller.setStudentGrade("A+");
        controller.setStudentName("Y. Vaishali Rao");
        controller.updateView();
    }
}
