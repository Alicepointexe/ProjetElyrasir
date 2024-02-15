package elyrasir.procedures;

import net.minecraft.world.level.LevelAccessor;

import elyrasir.network.ElyrasirModVariables;

public class ATMBuyRateReturnProcedure {
	public static String execute(LevelAccessor world) {
		return "Total d'achats sur la p\u00E9riode: " + new java.text.DecimalFormat("##").format(ElyrasirModVariables.MapVariables.get(world).Banque_periode_buy);
	}
}
