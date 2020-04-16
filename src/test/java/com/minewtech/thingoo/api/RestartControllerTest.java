package com.minewtech.thingoo.api;

import com.minewtech.thingoo.model.instructions.Instructions;
import com.minewtech.thingoo.repository.OperationRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RestartControllerTest {

    private String gatewayMac;

    @Test
    public void restart() {
        Instructions instructions =new Instructions();

        instructions.setAction("reboot");
        instructions.setRequestId(gatewayMac);
        String topic="/gw/"+gatewayMac+"/action";
        System.out.println(topic);

    }
}