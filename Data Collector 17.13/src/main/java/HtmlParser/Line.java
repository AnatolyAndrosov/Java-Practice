package HtmlParser;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@JsonPropertyOrder({"number", "mame"})
public class Line {

    public static List<Line> lineList = new ArrayList<>();
    public String name;
    public String number;

}
