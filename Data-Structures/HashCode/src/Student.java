public class Student {
    int grade;
    int cls;
    String firstName;
    String lastName;

    public Student(int grade, int cls, String firstName, String lastName) {
        this.grade = grade;
        this.cls = cls;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Override
    public int hashCode(){
        int B = 31;
        int hash = 0;
        hash = hash * B + ((Integer)grade).hashCode();
        hash = hash * B + ((Integer)cls).hashCode();
        hash = hash * B + firstName.toLowerCase().hashCode();//toLowerCase 统一将字母处理为小写字母
        hash = hash * B + lastName.toLowerCase().hashCode();
        return hash;
    }
    //因为可能会产生冲突，所以只覆盖一个HashCode函数是不够的，还要覆盖equals函数
    @Override
    public boolean equals(Object o){
        if(this == o)//是否同一个引用
            return true;

        if(o == null)//是否为空
            return false;

        if(getClass() != o.getClass())//是否是同一个类
            return false;
        //上述检测之后，依次比较成员变量
        Student another = (Student)o;
        return this.grade == another.grade &&
                this.cls == another.cls &&
                this.firstName.toLowerCase().equals(another.firstName.toLowerCase()) &&
                this.lastName.toLowerCase().equals(another.lastName.toLowerCase());
    }

}
