import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int a = 42;
        System.out.println(((Integer)a).hashCode());

        int b = -42;
        System.out.println(((Integer)b).hashCode());
        double c = 3.1415926;
        System.out.println(((Double)c).hashCode());
        String d = "imooc";
        System.out.println(d.hashCode());//因为String本身就是一个类，不需要做类型转换
        Student student = new Student(3 , 2 , "yuqi" , "Fan");
        System.out.println(student.hashCode());
        //自定义类中覆盖HashCode()方法，Java中的hashMap和hashSet会使用覆盖的方法，负责会使用Java默认的HashCode方法，默认方法根据物理地址生成哈希值
        HashSet<Student> set = new HashSet<>();
        set.add(student);
        HashMap<Student , Integer> scores = new HashMap<>();
        scores.put(student,100);

    }
}
