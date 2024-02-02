
package elyrasir.command;

@Mod.EventBusSubscriber
public class CkeckVariableCommand {

	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("ckeckvariable").requires(s -> s.hasPermission(4))

		);
	}

}
