package Week3.Anotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@interface MyAnnotation {
    String name();
    int value();
    char word() default 'C';
}

class MyAnnotatedClass{

    @MyAnnotation(name = "Emre",value = 1)
    public void annotatedMethod(){
        System.out.println("This method is annotated");
    }
}

class MyAnnotationDemo{
    public static void main(String[] args) {
        MyAnnotatedClass ob=new MyAnnotatedClass();

        Class<? extends MyAnnotatedClass> obClass=ob.getClass();
        Method[] methods= obClass.getMethods();
        for (Method m:methods){
            for (Annotation a:m.getAnnotations()){
                System.out.println(a);
            }
        }
    }
}
