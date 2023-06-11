import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Recordクラスに対して学習内容と学習時間を入れて、同じ学習内容ごとに合計時間を算出して出力する（課題提出時の記述）
//public class Main {
//    public static void main(String[] args) {
//        List<Record> rec = List.of(
//                new Record("Java",0.5),
//                new Record("Java",0.75),
//                new Record("Research",0.5),
//                new Record("Git",1.0));
//
//        Map<String, Double> result = rec.stream().collect(Collectors.groupingBy(Record::getContents,Collectors.summingDouble(Record::getTime)));
//        System.out.println("本日の学習内容と学習時間："+result);
//    }
//
//
//}

//提案いただいた別の記述方法。メソッドとしてMain外に記述し、よりわかりやすくしていただいている。
public class Main {
    public static void main(String[] args) {
        List<Record> records = initializeRecords();

        Map<String, Double> totalTimePerContent = calculateTotalTimePerContent(records);

        System.out.println("本日の学習内容と学習時間：" + totalTimePerContent);
    }

    /**
     * @return the list of records
     */
    private static List<Record> initializeRecords() {
        return List.of(
                new Record("Java", 0.5),
                new Record("Java", 0.75),
                new Record("Research", 0.5),
                new Record("Git", 1.0));
    }

    /**
     * @param records the list of records
     * @return a map with content as key and total time as value
     */
    private static Map<String, Double> calculateTotalTimePerContent(List<Record> records) {
        return records.stream()
                .collect(Collectors.groupingBy(
                        Record::getContents,
                        Collectors.summingDouble(Record::getTime)));
    }
}
