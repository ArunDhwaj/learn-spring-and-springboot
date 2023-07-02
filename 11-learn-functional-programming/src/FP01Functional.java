import java.util.List;

public class FP01Functional {
    public static void main(String[] args){
        List<Integer> numbers = List.of(1, 2, 22, 11, 23, 44, 54, 56, 70, 72, 75, 88);

//        printFunctionalWay(numbers);
        printEvenOnly(numbers);
    }

    private static void printFunctionalWay(List<Integer> numbers)
    {
        //numbers.stream().forEach(FP01Functional::print);
        numbers.stream().forEach(System.out::println);
    }

    private static void printEvenOnly(List<Integer> numbers)
    {
        //numbers.stream().forEach(FP01Functional::print);
        numbers.stream()
//                .filter(FP01Functional::isEven)
//                .filter((num)->{return num%2 == 0;} )
//                .filter(num->num%2 == 0)
                .map(num->num*num)
                .forEach( System.out::println);
    }

    private static void print(int num)
    {
        System.out.println(num);
    }

    private static boolean isEven(int num)
    {
        return num%2==0;
    }
}
