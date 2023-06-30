import java.util.List;

public class FP01FunctionalExercise {
    public static void main(String[] args){
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "GCP", "Azure", "Docker", "Kubernetes");
//        printIfWordPresent(courses);
        printILengthOfCourse(courses);
    }

    private static void printIfWordPresent(List<String> courses)
    {
        //numbers.stream().forEach(FP01Functional::print);
        courses.stream()
//               .filter(str -> str.contains("Spring"))
//               .filter(str -> str.length()>=4)
                .filter(course -> course.length()<=4)
                .forEach( System.out::println);
    }

    private static void printILengthOfCourse(List<String> courses)
    {
        //numbers.stream().forEach(FP01Functional::print);
        courses.stream()
//                .filter(str -> str.contains("Spring"))
//                .filter(str -> str.length()>=4)
                .map(course -> course + ": " + course.length())
                .forEach( System.out::println);
    }

}
