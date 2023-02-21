import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class Student implements Comparable<Student> {
    int grade;

    public Student (int grade) {
        this.grade = grade;
    }

    public int compareTo(Student stu) {
        return grade - stu.grade;
    }

    @Override
    public String toString () {
        return "" + grade;    
    }

}
public class App {
    public static int[] createRandomArray(int arrayLength) {
        Random random = new Random();
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++){
            array[i] = random.nextInt();
        }
        return array;
    }

    public static <E> ArrayList<E> createRandomArray2(int arrayLength) {
        ArrayList<E> a = new ArrayList<>();


        return a;
    }

    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++){
            if (array[i] > array[i + 1]){
                return false;
            }
        }
        return true;
    }

    public static void bubbleSort(int[] a) {
        for (int i = a.length; i > 1; i--){
            for (int j = 0; j < i - 1; j++){
                if (a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    public static <E extends Comparable<E>> void bubbleSort(ArrayList<E> a) {
        for (int i = a.size(); i > 1; i --) {
            for (int j = 0; j < i - 1; j ++) {
                if (a.get(j).compareTo(a.get(j+1)) > 0) { 
                    E temp = a.get(j);
                    a.set(j, a.get(j+1));
                    a.set(j+1, temp);
                }
            }
        }
    }

    public static int[] mergeArray(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                c[k] = a[i];
                k ++;
                i ++;
            } else {
                c[k] = b[j];
                k ++;
                j ++;
            }
        }
           
        while (i < a.length) {
            c[k] = a[i];
            k ++;
            i ++;
        }

        while (j < b.length) {
            c[k] = b[j];
            k ++;
            j ++;
        }
        
        return c;
    }
        
    


    public static void mergeArray(int[] a, int start, int middle, int end) {
        int i = start;
        int j = middle;
        int k = 0;
        int[] tempArray = new int[end - start];
        
        while (i < middle && j < end){
            if (a[i] <= a[j]) {
                tempArray[k] = a[i];
                k ++;
                i ++;
            } else {
                tempArray[k] = a[j];
                k ++;
                j ++;
            }
        }

        while (i < middle) {
            tempArray[k] = a[i];
            k ++;
            i ++;
        }

        while (j < end) {
            tempArray[k] = a[j];
            k ++;
            j ++;
        }

        for (i = start; i < end; i ++){
            a[i] = tempArray[i - start];
        }

    }

    public static <E extends Comparable<E>> void mergeArray(ArrayList<E> a, int start, int middle, int end) {
        ArrayList<E> c = new ArrayList<>();
        int i = start;
        int j = middle;
 
        
        while (i < middle && j < end){
            if (a.get(i).compareTo(a.get(j)) <= 0) {
                c.add(a.get(i));
                i ++;
            } else {
                c.add(a.get(j));
                j ++;
            }
        }

        while (i < middle) {
            c.add(a.get(i));
            i ++;
        }

        while (j < end) {
            c.add(a.get(j));
            j ++;
        }

        for (i = start; i < end; i ++){
            a.set(i, c.get(i - start));
        }

    }

    public static <E extends Comparable<E>> void mergeSort(ArrayList<E> a, int start, int end){
        if (end - start <= 1) {
            return;
        }

        int middle = (start + end) / 2;
        mergeSort(a, start, middle);
        mergeSort(a, middle, end);
        mergeArray(a, start, middle, end);
    }

    public static void mergeSort(int[] a, int start, int end){
        
        if (end - start <= 1) {
            return;
        }

        int middle = (start + end) / 2;
        mergeSort(a, start, middle);
        mergeSort(a, middle, end);
        mergeArray(a, start, middle, end);
    }

    public static <E extends Comparable<E>> void mergeSort(ArrayList<E> a) {
        mergeSort(a, 0, a.size());
    }

    public static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length);
    }
    
    public static void main(String[] args) throws Exception {
        ArrayList<Student> arrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i ++) {
           arrayList.add(new Student(random.nextInt(100)));
        }
        System.out.println(arrayList.toString());
        mergeSort(arrayList);
        System.out.println(arrayList.toString());
        
        // int arrayLength = 100000;
        // int[] array = createRandomArray(arrayLength);
        // // System.out.println(Arrays.toString(array));
        // long start_time;
        // float time_spent;
        // // start_time = System.currentTimeMillis() / 1000;
        // // System.out.println("Before sorting, isSorted(array): " + isSorted(array));
        // // bubbleSort(array);
        // // time_spent = System.currentTimeMillis() / 1000 - start_time;
        // // System.out.println("Bubble sort time: " + time_spent + " s");
        // start_time = System.currentTimeMillis();
        // mergeSort(array);
        // time_spent = System.currentTimeMillis() - start_time;
        // System.out.println("Merge sort time " + time_spent + " s");
        // // System.out.println(Arrays.toString(array));
        // System.out.println("After sorting, isSorted(array): " + isSorted(array));
        // System.out.println(System.currentTimeMillis());
    }
}
