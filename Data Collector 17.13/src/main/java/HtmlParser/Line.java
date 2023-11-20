package HtmlParser;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Line {

    public static List<Line> lineList = new ArrayList<>();
    public String name;
    public String number;

}
