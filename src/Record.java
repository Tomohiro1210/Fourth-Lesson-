
//学習記録を格納するためのクラス。contents:学習内容、time：学習時間(単位：時間。0.5だと0.5時間を表す）
public class Record {
    private String contents;
    private Double time;

    public Record(String contents,Double time){
        this.contents = contents;
        this.time = time;
    }


    public String getContents(){
        return contents;
    }

    public Double getTime(){
        return time;
    }

}
