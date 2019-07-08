public class Main {
//gittest123412313
    public static void main(String[] args) {
//测试git
	// write your code here
//        int arr[] = new int[20];
//        int scores[] = new int[]{99,98,97,59,100};
//        for(int i=0;i<arr.length;i++){
//            arr[i]=i;
//        }
//        for (int arrys:arr) {
//            System.out.println(arrys);
//        }
//        scores[1] = 100;
//        for (int score:scores) {
//            System.out.println(score);
//        }
        ArrayOfGeneric<Integer> arr = new ArrayOfGeneric<>(20);//Integer是int类型的包装类，Java语法中不支持ArrayOfGeneric<int> arr 的语法，需要采用对应包装类。
        for(int i = 0; i <=10; i++){
            arr.addLast(i);
        }
        System.out.println(arr);
        arr.add(1,100);
        System.out.println(arr);
        int b = arr.getValue(5);
        System.out.println(b);
        arr.find(100);
        arr.remove(2);
        System.out.println(arr);

    }
}
