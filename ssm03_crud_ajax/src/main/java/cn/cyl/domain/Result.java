package cn.cyl.domain;

public class Result {
    private int code;//编码 404 200
    private String msg;//提示信息
    private Object data; //数据

    public static Result init(int code, String msg, Object data) {
        Result result = new Result(code, msg, data);
        return result;
    }

    private Result() {
    }

    private Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}