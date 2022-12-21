import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@SaveTo(path = "C:\\Users\\Ivanka\\Desktop\\javaGithub\\AnnotationExample\\src\\task2.txt")
public class Container {
    String tex = "Hello";
    @Saver
    public void save(String fileName)  throws IOException{
        whenWriteStringUsingBufferedWritter_thenCorrect(fileName);
    }

    public void whenWriteStringUsingBufferedWritter_thenCorrect(String fileName)
            throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(tex);

        writer.close();
    }
}
