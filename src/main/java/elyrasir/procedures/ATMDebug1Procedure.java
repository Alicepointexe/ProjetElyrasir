package elyrasir.procedures;

import net.minecraft.world.level.LevelAccessor;

import elyrasir.network.ElyrasirModVariables;

public class ATMDebug1Procedure {
	public static String execute(LevelAccessor world) {
		return "BUY_M: " + new java.text.DecimalFormat("##").format(ElyrasirModVariables.MapVariables.get(world).Banque_periode_buy_M);
	}
}
