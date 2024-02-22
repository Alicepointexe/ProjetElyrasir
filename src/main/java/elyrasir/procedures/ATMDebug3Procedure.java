package elyrasir.procedures;

import net.minecraft.world.level.LevelAccessor;

import elyrasir.network.ElyrasirModVariables;

public class ATMDebug3Procedure {
	public static String execute(LevelAccessor world) {
		return "factM: "
				+ (ElyrasirModVariables.MapVariables.get(world).Banque_facteur_Mo + "" + ("fact: " + (ElyrasirModVariables.MapVariables.get(world).Banque_facteur + "" + ("factMe: " + ElyrasirModVariables.MapVariables.get(world).Banque_facteur_Me))));
	}
}
