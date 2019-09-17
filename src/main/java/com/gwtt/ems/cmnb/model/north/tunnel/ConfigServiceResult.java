package com.gwtt.ems.cmnb.model.north.tunnel;

import com.gwtt.ems.cmnb.model.common.CommandResult;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by chenjj on 2019/9/17
 */
@XmlRootElement(name = "ouput")
public class ConfigServiceResult {
    private CommandResult commandResult;

    public CommandResult getCommandResult() {
        return commandResult;
    }

    @XmlElement(name = "command-result")
    public void setCommandResult(CommandResult commandResult) {
        this.commandResult = commandResult;
    }
}
