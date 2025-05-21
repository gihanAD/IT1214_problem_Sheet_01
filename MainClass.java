import java.util.Scanner;
class Student{
	private String name;
	private int exam1;
	private int exam2;
	private int exam3;
	
	Student(String name,int exam1,int exam2,int exam3){
		this.name=name;
		if (validateMarks(exam1)&&validateMarks(exam2)&&validateMarks(exam3)) {
			this.exam1 = exam1;
			this.exam2 = exam2;
			this.exam3 = exam3;
		}else{
			throw new IllegalArgumentException("Marks must be between 0 and 100");
		}
	}
		
		
		
	
	boolean validateMarks(int marks){
		if (marks<=100 && marks>=0){
			return true;
		}else{
			return false;
		}
	}
	public int getExam1(){
		return exam1;
	}
	public int getExam2(){
		return exam2;
	}
	public int getExam3(){
		return exam3;
	}
	
	public double calculateAverage(){
		double ave=(exam1+exam2+exam3)/3;
		return ave;
	}
	
}
class MainClass{
	public static void main(String []args){
		Scanner sc =new Scanner(System.in);
		System.out.print("Enter the Name :");
		String name=sc.nextLine();
		System.out.print("Enter marks for Exam1 :");
		int exam1=sc.nextInt();
		System.out.print("Enter marks for Exam2 :");
		int exam2=sc.nextInt();
		System.out.print("Enter marks for Exam3 :");
		int exam3=sc.nextInt();
		try{
			Student st=new Student(name,exam1,exam2,exam3);
			System.out.println(name+",s Average mark is "+st.calculateAverage());
		}catch(IllegalArgumentException e){
			System.out.println("Error :"+ e.getMessage());
		}
		
}
}