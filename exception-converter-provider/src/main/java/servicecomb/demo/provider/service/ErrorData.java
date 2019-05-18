package servicecomb.demo.provider.service;

import java.util.Date;

public class ErrorData {
  private String msg;

  private Date timestamp;

  public ErrorData() {
  }

  public ErrorData(String msg, Date timestamp) {
    this.msg = msg;
    this.timestamp = timestamp;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("ErrorData{");
    sb.append("msg='").append(msg).append('\'');
    sb.append(", timestamp=").append(timestamp);
    sb.append('}');
    return sb.toString();
  }
}
