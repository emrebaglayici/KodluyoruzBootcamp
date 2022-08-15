package Week3.StreamApı;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        Stream<String> lines=getLinesFromAFile("test.txt");
        Random random =new Random();
        Stream<String> valueStream=Stream.of("value1","value2","value3");
        Integer[] integers={1,2,3,4,5};
        Stream<Integer> integerStream= Arrays.stream(integers);
        Stream<Integer> integerStream1=Arrays.stream(integers,0,3);
        integerStream1.forEach(System.out::println);
        Stream<String> stringStream=Stream.<String>builder().add("Value1").add("Value2").build();
        stringStream.forEach(System.out::println);
        Stream<Integer> limitedStream=Stream.generate(()->random.nextInt(1,10)).limit(10);
        limitedStream.forEach(System.out::println);

        Stream<Integer> integerStream2=Stream.iterate(20,(n)->n*2).limit(5);
        integerStream2.forEach(System.out::println);

        IntStream intStream=IntStream.range(0,5);
        LongStream longStream=LongStream.rangeClosed(0,5);
        DoubleStream doubleStream=random.doubles(5);
        doubleStream.forEach(System.out::println);

        Stream<String> stream= Pattern.compile("\\|").splitAsStream("name|surname|email");
        stream.forEach(System.out::println);

        IntStream integerStream3=random.ints(10);
        int sum=integerStream3.filter(a->a<10).sorted().sum();
        System.out.println(sum);

        String[] values={"1","2","3"};
        Arrays.stream(values).map(Integer::parseInt).forEach(System.out::println);

        User[] users={new User("emre","emre@gmail.com"),new User("elif","elif@gmail.com")};

//        Arrays.stream(users).flatMap(a->Stream.of(a.email)).forEach(System.out::println);

//        Stream<String> emails=Arrays.stream(users).flatMap(a->Stream.of(a.email));
//        boolean isValid=emails.anyMatch(element->element.contains("e"));
//        boolean isValidTwo=emails.allMatch(element->element.contains("@gmail.com"));
//        boolean isValidThree=emails.noneMatch(element->element.contains("e"));
//        boolean threeValid=emails.anyMatch(email->email==null || email.isEmpty());
        int[] a={1,2,3};
        int reduced=Arrays.stream(a).reduce(1,(x,y)->x*y);
        System.out.println("Reduced "+reduced);

        List<String> items=new ArrayList<>();
        items.add("one");
        items.add("two");
        items.add("three");
        String reducedList=items.stream().filter(item->!item.startsWith("o"))
                .reduce("",(acc,item)->acc+" "+item);
        System.out.println(reducedList);
    }

    private static Stream<String> getLinesFromAFile(String s) {
        Stream<String> lines = null;
        try{
            Path path= Paths.get(Main.class.getClassLoader().getResource("text.txt").toURI());
        }catch (URISyntaxException ex){
            lines=Stream.empty();
        }
        return lines;
    }
}
class User{
    String name;
    String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
