package imageloader.my.imageloader.bean;

/**
 * Created by huangResplendent on 16/8/30.
 * 结果实体
 */
public class ResultEntity<T> {
    //状态 -1失败 1成功
    private int code;
    //数据实体
    private T date;

    public ResultEntity(int code, T date) {
        this.code = code;
        this.date = date;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }
}
