/**
 * Created by Ritchie on 2018/8/4.
 */
public class Student {
    private String name;
    private int score;
    public Student(String studentname , int studentscore){
        name = studentname;
        score = studentscore;
    }
    @Override
    public String toString(){
         return String.format("Student: (name = %s , score = %d)",name , score);
    }
    public static void main(String[] args){
        ArrayOfGeneric<Student> arr =new ArrayOfGeneric<>();
        arr.addLast(new Student("Alice",99));
        arr.addLast(new Student("Bob",98));
        arr.addLast(new Student("Mike",95));
        System.out.println(arr); //这里打印是arr是ArrayOfGeneric类的对象，所以先调用ArrayOfGeneric的toString函数，记作函数1，函数1中又需要打印Student对象，故调用了Student类的toString函数
    }
}
