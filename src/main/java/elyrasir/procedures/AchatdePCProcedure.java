package elyrasir.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

import elyrasir.network.ElyrasirModVariables;

import elyrasir.init.ElyrasirModItems;

public class AchatdePCProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
					if (stack != null)
						return stack.getCount();
				}
				return 0;
			}
		}.getAmount(0) >= 1) {
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(Items.DIAMOND);
				_setstack.setCount((int) (new Object() {
					public int getAmount(int sltid) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
							if (stack != null)
								return stack.getCount();
						}
						return 0;
					}
				}.getAmount(0) - 1));
				((Slot) _slots.get(0)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp = ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC;
			ElyrasirModVariables.MapVariables.get(world).syncData(world);
			if (ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp - 500 >= 500) {
				while (ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp >= 500) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ElyrasirModItems.CINQCENTPC.get());
						_setstack.setCount((int) (new Object() {
							public int getAmount(int sltid) {
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
									if (stack != null)
										return stack.getCount();
								}
								return 0;
							}
						}.getAmount(1) + 1));
						((Slot) _slots.get(1)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp = ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp - 500;
					ElyrasirModVariables.MapVariables.get(world).syncData(world);
				}
			} else {
				if (ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp - 200 >= 200) {
					while (ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp >= 200) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(ElyrasirModItems.DEUXCENTPC.get());
							_setstack.setCount((int) (new Object() {
								public int getAmount(int sltid) {
									if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
										if (stack != null)
											return stack.getCount();
									}
									return 0;
								}
							}.getAmount(2) + 1));
							((Slot) _slots.get(2)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
						ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp = ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp - 200;
						ElyrasirModVariables.MapVariables.get(world).syncData(world);
					}
				} else {
					if (ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp - 100 >= 100) {
						while (ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp >= 100) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(ElyrasirModItems.CENTPC.get());
								_setstack.setCount((int) (new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(3) + 1));
								((Slot) _slots.get(3)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
							ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp = ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp - 100;
							ElyrasirModVariables.MapVariables.get(world).syncData(world);
						}
					} else {
						if (ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp - 50 >= 50) {
							while (ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp >= 50) {
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									ItemStack _setstack = new ItemStack(ElyrasirModItems.CINQUANTEPC.get());
									_setstack.setCount((int) (new Object() {
										public int getAmount(int sltid) {
											if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
												ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
												if (stack != null)
													return stack.getCount();
											}
											return 0;
										}
									}.getAmount(4) + 1));
									((Slot) _slots.get(4)).set(_setstack);
									_player.containerMenu.broadcastChanges();
								}
								ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp = ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp - 50;
								ElyrasirModVariables.MapVariables.get(world).syncData(world);
							}
						} else {
							if (ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp - 20 >= 20) {
								while (ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp >= 20) {
									if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										ItemStack _setstack = new ItemStack(ElyrasirModItems.VINGTPC.get());
										_setstack.setCount((int) (new Object() {
											public int getAmount(int sltid) {
												if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
													ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
													if (stack != null)
														return stack.getCount();
												}
												return 0;
											}
										}.getAmount(5) + 1));
										((Slot) _slots.get(5)).set(_setstack);
										_player.containerMenu.broadcastChanges();
									}
									ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp = ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp - 20;
									ElyrasirModVariables.MapVariables.get(world).syncData(world);
								}
							} else {
								if (ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp - 10 >= 10) {
									while (ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp >= 10) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack _setstack = new ItemStack(ElyrasirModItems.DIXPC.get());
											_setstack.setCount((int) (new Object() {
												public int getAmount(int sltid) {
													if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
														ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
														if (stack != null)
															return stack.getCount();
													}
													return 0;
												}
											}.getAmount(6) + 1));
											((Slot) _slots.get(6)).set(_setstack);
											_player.containerMenu.broadcastChanges();
										}
										ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp = ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp - 10;
										ElyrasirModVariables.MapVariables.get(world).syncData(world);
									}
								} else {
									if (ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp - 5 >= 5) {
										while (ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp >= 5) {
											if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
												ItemStack _setstack = new ItemStack(ElyrasirModItems.CINQPC.get());
												_setstack.setCount((int) (new Object() {
													public int getAmount(int sltid) {
														if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
															ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
															if (stack != null)
																return stack.getCount();
														}
														return 0;
													}
												}.getAmount(7) + 1));
												((Slot) _slots.get(7)).set(_setstack);
												_player.containerMenu.broadcastChanges();
											}
											ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp = ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp - 5;
											ElyrasirModVariables.MapVariables.get(world).syncData(world);
										}
									} else {
										if (ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp - 1 >= 1) {
											while (ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp >= 1) {
												if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
													ItemStack _setstack = new ItemStack(ElyrasirModItems.UNPC.get());
													_setstack.setCount((int) (new Object() {
														public int getAmount(int sltid) {
															if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
																ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
																if (stack != null)
																	return stack.getCount();
															}
															return 0;
														}
													}.getAmount(8) + 1));
													((Slot) _slots.get(8)).set(_setstack);
													_player.containerMenu.broadcastChanges();
												}
												ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp = ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC_temp - 1;
												ElyrasirModVariables.MapVariables.get(world).syncData(world);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
