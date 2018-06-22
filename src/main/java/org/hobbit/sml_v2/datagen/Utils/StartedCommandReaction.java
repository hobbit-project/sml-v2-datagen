package org.hobbit.sml_v2.datagen.Utils;

import com.rabbitmq.client.MessageProperties;
import org.hobbit.core.Commands;
import org.hobbit.sdk.utils.CommandSender;
import org.hobbit.sdk.utils.commandreactions.CommandReaction;
import org.junit.Assert;

public class StartedCommandReaction implements CommandReaction {
    @Override
    public void handleCmd(Byte command, byte[] bytes, String replyTo) throws Exception {

        if(command == Commands.TASK_GENERATOR_READY_SIGNAL) {

            synchronized (this) {
                try {
                    (new CommandSender(Commands.TASK_GENERATOR_START_SIGNAL)).send();
                } catch (Exception var15) {
                    Assert.fail(var15.getMessage());
                }

            }
        }
    }
}
