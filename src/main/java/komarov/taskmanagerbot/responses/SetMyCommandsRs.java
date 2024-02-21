package komarov.taskmanagerbot.responses;


import lombok.Data;

import java.io.Serializable;

@Data
public class SetMyCommandsRs implements Serializable {
    private boolean ok;
    private boolean result;
}
