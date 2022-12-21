import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Main {
    public static void testAnnotationIsPresent(Method method) {
        Task taskObject = new Task();
        if (method.isAnnotationPresent(Test.class)) {
            try {
                // iterates all the annotations available in the method
                for (Annotation anno : method.getDeclaredAnnotations()) {
                    System.out.println("Annotation in Method '" + method.getName() + "' : " + anno);
                }
                Test methodAnno = method.getAnnotation(Test.class);

                method.invoke(taskObject, methodAnno.a(), methodAnno.b());

            } catch (Throwable ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void task1Solution() {
        try {
            for (Method method : Main.class.getClassLoader().loadClass(("Task")).getMethods()) {
                // checks if Test annotation is present for the method
                testAnnotationIsPresent(method);
            }
        } catch (SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void task2Solution() {

        Container container = new Container();
        Annotation a[] = container.getClass().getAnnotations();
        SaveTo s = (SaveTo) a[0];
//        System.out.println(s.path());
        try {
            for (Method method : Main.class.getClassLoader().loadClass(("Container")).getMethods()) {
                // checks if Test annotation is present for the method
                containerAnnotationIsPresent(method, s.path());
            }
        } catch (SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void containerAnnotationIsPresent(Method method, String path) {
        Container container = new Container();
        if (method.isAnnotationPresent(Saver.class)) {
            try {
                // iterates all the annotations available in the method
                for (Annotation anno : method.getDeclaredAnnotations()) {
                    System.out.println("Annotation in Method '" + method.getName() + "' : " + anno);
                }
                method.invoke(container, path);

            } catch (Throwable ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        task1Solution();
        task2Solution();
    }
}