import lombok.*;

import java.util.List;

@Data
public class Person {
    private String name;
    private int age;
    private boolean married;
    private List<String> hobbies;
    private List<String> children;
    private Car car;
    private Job job;
}
