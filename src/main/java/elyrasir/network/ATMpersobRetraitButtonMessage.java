
package elyrasir.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.HashMap;

import elyrasir.world.inventory.ATMpersobRetraitMenu;

import elyrasir.procedures.ReturnPersoAtmProcedure;
import elyrasir.procedures.AtmPersoRetrait5Procedure;
import elyrasir.procedures.AtmPersoRetrait50Procedure;
import elyrasir.procedures.AtmPersoRetrait500Procedure;
import elyrasir.procedures.AtmPersoRetrait20Procedure;
import elyrasir.procedures.AtmPersoRetrait200Procedure;
import elyrasir.procedures.AtmPersoRetrait1Procedure;
import elyrasir.procedures.AtmPersoRetrait10Procedure;
import elyrasir.procedures.AtmPersoRetrait100Procedure;

import elyrasir.ElyrasirMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ATMpersobRetraitButtonMessage {
	private final int buttonID, x, y, z;

	public ATMpersobRetraitButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public ATMpersobRetraitButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(ATMpersobRetraitButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(ATMpersobRetraitButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = ATMpersobRetraitMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 4) {

			ReturnPersoAtmProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			AtmPersoRetrait50Procedure.execute(entity);
		}
		if (buttonID == 6) {

			AtmPersoRetrait500Procedure.execute(entity);
		}
		if (buttonID == 7) {

			AtmPersoRetrait20Procedure.execute(entity);
		}
		if (buttonID == 8) {

			AtmPersoRetrait200Procedure.execute(entity);
		}
		if (buttonID == 9) {

			AtmPersoRetrait10Procedure.execute(entity);
		}
		if (buttonID == 10) {

			AtmPersoRetrait100Procedure.execute(entity);
		}
		if (buttonID == 11) {

			AtmPersoRetrait1Procedure.execute(entity);
		}
		if (buttonID == 12) {

			AtmPersoRetrait5Procedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ElyrasirMod.addNetworkMessage(ATMpersobRetraitButtonMessage.class, ATMpersobRetraitButtonMessage::buffer, ATMpersobRetraitButtonMessage::new, ATMpersobRetraitButtonMessage::handler);
	}
}
