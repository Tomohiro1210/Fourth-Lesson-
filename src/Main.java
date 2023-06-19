import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Recordクラスに対して学習内容と学習時間を入れて、同じ学習内容ごとに合計時間を算出して出力する
public class Main {
    public static void main(String[] args) {
        List<Note> records = initializeRecords();
        Map<String, Double> totalTimePerContent = calculateTotalTimePerContent(records);
        Map<String, Long> totalRecordsPerContent = dataCount(records);
        System.out.println("本日の学習内容と学習時間：" + totalTimePerContent);
        System.out.println("学習内容別の登録件数：" + totalRecordsPerContent);
    }

    //メソッドでリストの初期化と学習内容毎の学習時間を集計する。

    private static List<Note> initializeRecords() {
        return List.of(
                new Note("Java", 0.5),
                new Note("Java", 0.75),
                new Note("Research", 0.5),
                new Note("Git", 1.0));
    }

    private static Map<String, Double> calculateTotalTimePerContent(List<Note> records) {
        return records.stream().collect(Collectors.groupingBy(Note::getContents, Collectors.summingDouble(Note::getTime)));
    }

    //メソッドで学習内容のなかにある記録の件数が何件か出力する。
    private static Map<String, Long> dataCount(List<Note> records) {
        return records.stream().collect(Collectors.groupingBy(Note::getContents, Collectors.counting()));
    }
}
