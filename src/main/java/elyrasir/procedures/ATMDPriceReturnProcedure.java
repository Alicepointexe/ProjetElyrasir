package elyrasir.procedures;

import net.minecraft.world.level.LevelAccessor;

import elyrasir.network.ElyrasirModVariables;

public class ATMDPriceReturnProcedure {
	public static String execute(LevelAccessor world) {
		return "1 Diamand = " + (new java.text.DecimalFormat("##").format(ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC) + "PC");
	}
}
