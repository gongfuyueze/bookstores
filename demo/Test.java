package java8.demo;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Singleton{
    public Singleton() {
    }
    private static Singleton singleton ;

    public static Singleton getInstance() {
        if (singleton==null){
            singleton = new Singleton();
        }
        return singleton;
    }
}

class Test{
    public static void main(String[] args) throws IOException {

        
        List<Student> students = new ArrayList<Student>() {
            {
                add(new Student(20160001, "孔明", 20, 1, "土木工程", "武汉大学"));
                add(new Student(20160002, "伯约", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20160003, "玄德", 22, 3, "经济管理", "武汉大学"));
                add(new Student(20160004, "云长", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20161001, "翼德", 21, 2, "机械与自动化", "华中科技大学"));
                add(new Student(20161002, "元直", 23, 4, "土木工程", "华中科技大学"));
                add(new Student(20161003, "奉孝", 23, 4, "计算机科学", "华中科技大学"));
                add(new Student(20162001, "仲谋", 22, 3, "土木工程", "浙江大学"));
                add(new Student(20162002, "鲁肃", 23, 4, "计算机科学", "浙江大学"));
                add(new Student(20163001, "丁奉", 24, 5, "土木工程", "南京大学"));
            }
        };
        Map<String, Map<String, List<Student>>> groups2 = students.stream().collect(
                Collectors.groupingBy(Student::getSchool,  
                        Collectors.groupingBy(Student::getMajor)));  
        System.out.println(groups2);

        Map<String, List<Student>> groups = students.stream().collect(Collectors.groupingBy(Student::getSchool));
        System.out.println(groups);

        Map<String, Long> groupsCount = students.stream().collect(Collectors.groupingBy(Student::getSchool, Collectors.counting()));
        System.out.println(groupsCount);


    }
}
