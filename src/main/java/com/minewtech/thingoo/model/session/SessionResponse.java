package com.minewtech.thingoo.model.session;


import com.minewtech.thingoo.model.response.OperationResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class SessionResponse extends OperationResponse {
  @ApiModelProperty(required = true, value = "")
  private SessionItem data;

    public void setData(SessionItem sessionItem) {
    }

    public void setMessage(String dummy_login_success) {
    }

  public void setStatus(int i) {
  }
}
