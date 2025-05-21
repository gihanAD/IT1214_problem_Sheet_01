import java.util.Scanner;

class Student {
    private String name;
    private int studentId;
    private int daysattended;

    Student(String name, int studentId, int daysattended) {
        this.name = name;
        this.studentId = studentId;
        this.daysattended = daysattended;
    }
    public String getName() {
        return name;
    }
    public int getStudentId() {
        return studentId;
    }
    public int getDaysattended() {
        return daysattended;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public void setDaysattended(int daysattended) {
        this.daysattended = daysattended;
    }
    

}
class Classroom{
    Student[] students=new Student[10]; 
    int studentCount=0;
    public void addStudent(Student student){
        if(studentCount<students.length){
            students[studentCount]=student;
            studentCount++;
        }else{
            System.out.println("Classroom is full");
        }
    }
	
    public void updateDaysattended(int studentId, int daysattended){
		int count=0;
		boolean stcheck=false;
        for(int i=0;i<studentCount;i++){
            if(students[i].getStudentId()==studentId){
                stcheck=true;
				count=i;
				break;
			}
        }
		if(stcheck==true){
			students[count].setDaysattended(daysattended);
            System.out.println("Days attended updated for student ID: " + studentId);
        }else{
			System.out.println("Student not found");
		}
    }
    public void displayStudents(){
        for(int i=0;i<studentCount;i++){
            System.out.println("Name: " + students[i].getName() + ", Student ID: " + students[i].getStudentId() + ", Days Attended: " + students[i].getDaysattended());
        }
    }
}
class StudentMain{
    public static void main(String[] args){
        Classroom classroom=new Classroom();
        Student student1=new Student("Alice smith", 101, 12);
        Student student2=new Student("Bob Jones", 102, 15); 
        Student student3=new Student("Carol Lee", 103, 10);
        classroom.addStudent(student1);
        classroom.addStudent(student2);
        classroom.addStudent(student3);
        classroom.updateDaysattended(102, 16);
        classroom.updateDaysattended(104, 16);
        classroom.displayStudents();
    }
}
        