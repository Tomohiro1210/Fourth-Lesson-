import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Recordクラスに対して学習内容と学習時間を入れて、同じ学習内容ごとに合計時間を算出して出力する
public class Main {
    public static void main(String[] args) {
        List<Record> rec = List.of(
                new Record("Java",0.5),
                new Record("Java",0.75),
                new Record("Research",0.5),
                new Record("Git",1.0));

        Map<String, Double> result = rec.stream().collect(Collectors.groupingBy(Record::getContents,Collectors.summingDouble(Record::getTime)));
        System.out.println("本日の学習内容と学習時間："+result);
    }


}