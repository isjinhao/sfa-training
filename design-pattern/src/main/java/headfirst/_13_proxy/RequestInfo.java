package headfirst._13_proxy;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/12
 */
public class RequestInfo {

    private String action;

    private Long responseTime;
    private Long startTimestamp;
    private Long endTimeStamp;

    public RequestInfo(String action, Long responseTime, Long startTimestamp, Long endTimeStamp) {
        this.action = action;
        this.responseTime = responseTime;
        this.startTimestamp = startTimestamp;
        this.endTimeStamp = endTimeStamp;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Long responseTime) {
        this.responseTime = responseTime;
    }

    public Long getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(Long startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public Long getEndTimeStamp() {
        return endTimeStamp;
    }

    public void setEndTimeStamp(Long endTimeStamp) {
        this.endTimeStamp = endTimeStamp;
    }

    @Override
    public String toString() {
        return "RequestInfo{" +
            "action='" + action + '\'' +
            ", responseTime=" + responseTime +
            ", startTimestamp=" + startTimestamp +
            ", endTimeStamp=" + endTimeStamp +
            '}';
    }
}
