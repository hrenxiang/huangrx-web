package JDBCTest_06_DataSource;

/**
 * @author Charon
 * @date 2020/6/23
 **/
public class xskc {

    private String 学号;
    private String 课程号;
    private int 成绩;
    private int 学分;

    public xskc() {
    }

    public xskc(String 学号, String 课程号, int 成绩, int 学分) {
        this.学号 = 学号;
        this.课程号 = 课程号;
        this.成绩 = 成绩;
        this.学分 = 学分;
    }

    public String get学号() {
        return 学号;
    }

    public void set学号(String 学号) {
        this.学号 = 学号;
    }

    public String get课程号() {
        return 课程号;
    }

    public void set课程号(String 课程号) {
        this.课程号 = 课程号;
    }

    public int get成绩() {
        return 成绩;
    }

    public void set成绩(int 成绩) {
        this.成绩 = 成绩;
    }

    public int get学分() {
        return 学分;
    }

    public void set学分(int 学分) {
        this.学分 = 学分;
    }

    @Override
    public String toString() {
        return "xskc{" +
                "学号='" + 学号 + '\'' +
                ", 课程号='" + 课程号 + '\'' +
                ", 成绩=" + 成绩 +
                ", 学分=" + 学分 +
                '}';
    }
}
