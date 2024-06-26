package elyrasir.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;
import java.util.List;
import java.util.ArrayList;

import java.io.File;

import elyrasir.ElyrasirMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ElyrasirModVariables {
	public static List<Object> testlist = new ArrayList<>();
	public static File testlist2 = new File("");

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		ElyrasirMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		ElyrasirMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.Banque_card_name = original.Banque_card_name;
			clone.Global_nom = original.Global_nom;
			clone.Global_prenom = original.Global_prenom;
			clone.Global_age = original.Global_age;
			clone.Global_origine = original.Global_origine;
			clone.Global_PID = original.Global_PID;
			if (!event.isWasDeath()) {
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					ElyrasirMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					ElyrasirMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					ElyrasirMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "elyrasir_worldvars";

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				ElyrasirMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "elyrasir_mapvars";
		public double Boulanger_CoffreFort = 0;
		public boolean Boulanger_IsBoulanger = false;
		public boolean Boulanger_IsWork = false;
		public boolean Boulanger_Rank1 = false;
		public double Boulanger_Rank1_Vendeur = 0;
		public boolean Boulanger_Rank2 = false;
		public double Boulanger_Rank2_Logisticien = 0;
		public boolean Boulanger_Rank3 = false;
		public double Boulanger_Rank3_Boulanger = 0;
		public boolean Boulanger_Rank4 = false;
		public double Boulanger_Rank4_ViceDirecteur = 0;
		public boolean Boulanger_Rank5 = false;
		public double Boulanger_Rank5_Directeur = 0;
		public double Bucheron_CoffreFort = 0;
		public boolean Bucheron_IsBucheron = false;
		public boolean Bucheron_IsWork = false;
		public boolean Bucheron_Rank1 = false;
		public double Bucheron_Rank1_Vendeur = 0;
		public boolean Bucheron_Rank2 = false;
		public double Bucheron_Rank2_Logisticien = 0;
		public boolean Bucheron_Rank3 = false;
		public double Bucheron_Rank3_Bucheron = 0;
		public boolean Bucheron_Rank4 = false;
		public double Bucheron_Rank4_ViceDirecteur = 0;
		public boolean Bucheron_Rank5 = false;
		public double Bucheron_Rank5_Directeur = 0;
		public double Eleveur_CoffreFort = 0;
		public boolean Eleveur_IsEleveur = false;
		public boolean Eleveur_IsWork = false;
		public boolean Eleveur_Rank1 = false;
		public double Eleveur_Rank1_Vendeur = 0;
		public boolean Eleveur_Rank2 = false;
		public boolean Eleveur_Rank3 = false;
		public double Eleveur_Rank3_Eleveur = 0;
		public boolean Eleveur_Rank4 = false;
		public double Eleveur_Rank4_ViceDirecteur = 0;
		public boolean Eleveur_Rank5 = false;
		public double Eleveur_Rank5_Directeur = 0;
		public double Farmer_CoffreFort = 0;
		public boolean Farmer_IsFarmer = false;
		public boolean Farmer_IsWork = false;
		public boolean Farmer_Rank1 = false;
		public double Farmer_Rank1_Vendeur = 0;
		public boolean Farmer_Rank2 = false;
		public double Farmer_Rank2_Logisticien = 0;
		public boolean Farmer_Rank3 = false;
		public double Farmer_Rank3_Farmer = 0;
		public boolean Farmer_Rank4 = false;
		public double Farmer_Rank4_ViceDirecteur = 0;
		public boolean Farmer_Rank5 = false;
		public double Farmer_Rank5_Directeur = 0;
		public double Medic_CoffreFort = 0;
		public double Medic_IsHealthLevel = 0;
		public boolean Medic_IsMedic = false;
		public boolean Medic_IsMedicOnline = false;
		public boolean Medic_IsWork = false;
		public boolean Medic_Rank1 = false;
		public double Medic_Rank1_Secouriste = 0;
		public boolean Medic_Rank2 = false;
		public double Medic_Rank2_Infirmier = 0;
		public boolean Medic_Rank3 = false;
		public double Medic_Rank3_Medecin = 0;
		public boolean Medic_Rank4 = false;
		public double Medic_Rank4_Chirurgien = 0;
		public boolean Medic_Rank5 = false;
		public double Medic_Rank5_ViceDirecteur = 0;
		public boolean Medic_Rank6 = false;
		public double Medic_Rank6_Directeur = 0;
		public boolean Mineur_IsMineur = false;
		public boolean Mineur_IsWork = false;
		public boolean Mineur_Rank1 = false;
		public double Mineur_Rank1_Vendeur = 0;
		public boolean Mineur_Rank2 = false;
		public double Mineur_Rank2_Logisticien = 0;
		public boolean Mineur_Rank3 = false;
		public double Mineur_Rank3_Mineur = 0;
		public boolean Mineur_Rank4 = false;
		public boolean Mineur_Rank5 = false;
		public double Mineur_Rank5_Directeur = 0;
		public boolean Police_CoffreFort = false;
		public boolean Police_IsCuffed = false;
		public boolean Police_IsPolice = false;
		public boolean Police_IsWork = false;
		public double Police_Rank1 = 0;
		public boolean Police_Rank1_Recrue = false;
		public double Police_Rank2 = 0;
		public boolean Police_Rank2_Officier = false;
		public double Police_Rank3 = 0;
		public boolean Police_Rank3_Lieutenant = false;
		public double Police_Rank4 = 0;
		public boolean Police_Rank4_Enqueteur = false;
		public boolean Police_Rank5_Capitaine = false;
		public double Police_Rank6 = 0;
		public boolean Police_Rank6_Commandant = false;
		public double Prison_CoffreFort = 0;
		public boolean Prison_IsPrison = false;
		public boolean Prison_IsWork = false;
		public boolean Prison_Rank1 = false;
		public boolean Prison_Rank2 = false;
		public boolean Prison_Rank3 = false;
		public boolean Prison_Rank4 = false;
		public double Train_CoffreFort = 0;
		public boolean Train_IsTrain = false;
		public boolean Train_IsWork = false;
		public boolean Train_Rank2 = false;
		public double Train_Rank2_Controleur = 0;
		public boolean Train_Rank3 = false;
		public double Train_Rank3_Ingenieur = 0;
		public boolean Train_Rank4 = false;
		public double Train_Rank4_ViceDirecteur = 0;
		public boolean Train_Rank5 = false;
		public double Train_Rank5_Directeur = 0;
		public double Vigneron_CoffreFort = 0;
		public boolean Vigneron_IsVigneron = false;
		public boolean Vigneron_IsWork = false;
		public boolean Vigneron_Rank1 = false;
		public double Vigneron_Rank1_Vendeur = 0;
		public boolean Vigneron_Rank2 = false;
		public double Vigneron_Rank2_Logisticien = 0;
		public boolean Vigneron_Rank3 = false;
		public double Vigneron_Rank3_Vigneron = 0;
		public boolean Vigneron_Rank4 = false;
		public double Vigneron_Rank4_ViceDirecteur = 0;
		public boolean Vigneron_Rank5 = false;
		public double Prison_Rank1_Gardien = 0;
		public double Prison_Rank2_Superviseur = 0;
		public double Prison_Rank3_ViceDirecteur = 0;
		public double Prison_Rank5_Directeur = 0;
		public double Vigneron_Rank5_Directeur = 0.0;
		public double Eleveur_Rank2_Logisticien = 0.0;
		public double Train_Rank1_Conducteur = 0.0;
		public double Police_Rank5 = 0.0;
		public boolean Train_Rank1 = false;
		public double Mineur_Rank4_ViceDirecteur = 0.0;
		public double Banque_rate_D_PC = 3200.0;
		public double Banque_rate_D_PC_temp = 0;
		public double Banque_rate_buy_pc = 0;
		public double Banque_stock_1pc = 1545600.0;
		public double Banque_stock_5pc = 230401.0;
		public double Banque_stock_10pc = 131658.0;
		public double Banque_stock_20pc = 75233.0;
		public double Banque_stock_50pc = 34.392;
		public double Banque_stock_100pc = 19652.0;
		public double Banque_stock_200pc = 11229.0;
		public double Banque_stock_500pc = 5133.0;
		public double Banque_total_supply = 2.208E7;
		public double Banque_reserve = 6518455.0;
		public double Banque_Diamand_stock = 0;
		public double Banque_total_buy = 0;
		public double Banque_total_buy_M = 0;
		public double Banque_total_buy_rate = 0;
		public double Banque_total_periodes = 0;
		public double Banque_time_periode = 0.0;
		public double Banque_periode_buy = 0.0;
		public double Banque_periode_buy_M = 1.0;
		public String testt = "q";
		public double Banque_time_timer = 0;
		public boolean Banque_time_active = false;
		public double Banque_time_sec = 0;
		public double Banque_time_min = 0;
		public double Banque_time_heu = 0;
		public double Banque_time_jou = 0;
		public double Banque_time_sem = 0;
		public double ghgffjtfjgjgf = 0;
		public double Banque_facteur = 0;
		public double Banque_facteur_Me = 0;
		public double Banque_facteur_Mo = 0;
		public double Banque_periode_buy_Me = 1.0;
		public Direction AtmTemp = Direction.NORTH;
		public double Global_PlayerUnique = 1.0;

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			Boulanger_CoffreFort = nbt.getDouble("Boulanger_CoffreFort");
			Boulanger_IsBoulanger = nbt.getBoolean("Boulanger_IsBoulanger");
			Boulanger_IsWork = nbt.getBoolean("Boulanger_IsWork");
			Boulanger_Rank1 = nbt.getBoolean("Boulanger_Rank1");
			Boulanger_Rank1_Vendeur = nbt.getDouble("Boulanger_Rank1_Vendeur");
			Boulanger_Rank2 = nbt.getBoolean("Boulanger_Rank2");
			Boulanger_Rank2_Logisticien = nbt.getDouble("Boulanger_Rank2_Logisticien");
			Boulanger_Rank3 = nbt.getBoolean("Boulanger_Rank3");
			Boulanger_Rank3_Boulanger = nbt.getDouble("Boulanger_Rank3_Boulanger");
			Boulanger_Rank4 = nbt.getBoolean("Boulanger_Rank4");
			Boulanger_Rank4_ViceDirecteur = nbt.getDouble("Boulanger_Rank4_ViceDirecteur");
			Boulanger_Rank5 = nbt.getBoolean("Boulanger_Rank5");
			Boulanger_Rank5_Directeur = nbt.getDouble("Boulanger_Rank5_Directeur");
			Bucheron_CoffreFort = nbt.getDouble("Bucheron_CoffreFort");
			Bucheron_IsBucheron = nbt.getBoolean("Bucheron_IsBucheron");
			Bucheron_IsWork = nbt.getBoolean("Bucheron_IsWork");
			Bucheron_Rank1 = nbt.getBoolean("Bucheron_Rank1");
			Bucheron_Rank1_Vendeur = nbt.getDouble("Bucheron_Rank1_Vendeur");
			Bucheron_Rank2 = nbt.getBoolean("Bucheron_Rank2");
			Bucheron_Rank2_Logisticien = nbt.getDouble("Bucheron_Rank2_Logisticien");
			Bucheron_Rank3 = nbt.getBoolean("Bucheron_Rank3");
			Bucheron_Rank3_Bucheron = nbt.getDouble("Bucheron_Rank3_Bucheron");
			Bucheron_Rank4 = nbt.getBoolean("Bucheron_Rank4");
			Bucheron_Rank4_ViceDirecteur = nbt.getDouble("Bucheron_Rank4_ViceDirecteur");
			Bucheron_Rank5 = nbt.getBoolean("Bucheron_Rank5");
			Bucheron_Rank5_Directeur = nbt.getDouble("Bucheron_Rank5_Directeur");
			Eleveur_CoffreFort = nbt.getDouble("Eleveur_CoffreFort");
			Eleveur_IsEleveur = nbt.getBoolean("Eleveur_IsEleveur");
			Eleveur_IsWork = nbt.getBoolean("Eleveur_IsWork");
			Eleveur_Rank1 = nbt.getBoolean("Eleveur_Rank1");
			Eleveur_Rank1_Vendeur = nbt.getDouble("Eleveur_Rank1_Vendeur");
			Eleveur_Rank2 = nbt.getBoolean("Eleveur_Rank2");
			Eleveur_Rank3 = nbt.getBoolean("Eleveur_Rank3");
			Eleveur_Rank3_Eleveur = nbt.getDouble("Eleveur_Rank3_Eleveur");
			Eleveur_Rank4 = nbt.getBoolean("Eleveur_Rank4");
			Eleveur_Rank4_ViceDirecteur = nbt.getDouble("Eleveur_Rank4_ViceDirecteur");
			Eleveur_Rank5 = nbt.getBoolean("Eleveur_Rank5");
			Eleveur_Rank5_Directeur = nbt.getDouble("Eleveur_Rank5_Directeur");
			Farmer_CoffreFort = nbt.getDouble("Farmer_CoffreFort");
			Farmer_IsFarmer = nbt.getBoolean("Farmer_IsFarmer");
			Farmer_IsWork = nbt.getBoolean("Farmer_IsWork");
			Farmer_Rank1 = nbt.getBoolean("Farmer_Rank1");
			Farmer_Rank1_Vendeur = nbt.getDouble("Farmer_Rank1_Vendeur");
			Farmer_Rank2 = nbt.getBoolean("Farmer_Rank2");
			Farmer_Rank2_Logisticien = nbt.getDouble("Farmer_Rank2_Logisticien");
			Farmer_Rank3 = nbt.getBoolean("Farmer_Rank3");
			Farmer_Rank3_Farmer = nbt.getDouble("Farmer_Rank3_Farmer");
			Farmer_Rank4 = nbt.getBoolean("Farmer_Rank4");
			Farmer_Rank4_ViceDirecteur = nbt.getDouble("Farmer_Rank4_ViceDirecteur");
			Farmer_Rank5 = nbt.getBoolean("Farmer_Rank5");
			Farmer_Rank5_Directeur = nbt.getDouble("Farmer_Rank5_Directeur");
			Medic_CoffreFort = nbt.getDouble("Medic_CoffreFort");
			Medic_IsHealthLevel = nbt.getDouble("Medic_IsHealthLevel");
			Medic_IsMedic = nbt.getBoolean("Medic_IsMedic");
			Medic_IsMedicOnline = nbt.getBoolean("Medic_IsMedicOnline");
			Medic_IsWork = nbt.getBoolean("Medic_IsWork");
			Medic_Rank1 = nbt.getBoolean("Medic_Rank1");
			Medic_Rank1_Secouriste = nbt.getDouble("Medic_Rank1_Secouriste");
			Medic_Rank2 = nbt.getBoolean("Medic_Rank2");
			Medic_Rank2_Infirmier = nbt.getDouble("Medic_Rank2_Infirmier");
			Medic_Rank3 = nbt.getBoolean("Medic_Rank3");
			Medic_Rank3_Medecin = nbt.getDouble("Medic_Rank3_Medecin");
			Medic_Rank4 = nbt.getBoolean("Medic_Rank4");
			Medic_Rank4_Chirurgien = nbt.getDouble("Medic_Rank4_Chirurgien");
			Medic_Rank5 = nbt.getBoolean("Medic_Rank5");
			Medic_Rank5_ViceDirecteur = nbt.getDouble("Medic_Rank5_ViceDirecteur");
			Medic_Rank6 = nbt.getBoolean("Medic_Rank6");
			Medic_Rank6_Directeur = nbt.getDouble("Medic_Rank6_Directeur");
			Mineur_IsMineur = nbt.getBoolean("Mineur_IsMineur");
			Mineur_IsWork = nbt.getBoolean("Mineur_IsWork");
			Mineur_Rank1 = nbt.getBoolean("Mineur_Rank1");
			Mineur_Rank1_Vendeur = nbt.getDouble("Mineur_Rank1_Vendeur");
			Mineur_Rank2 = nbt.getBoolean("Mineur_Rank2");
			Mineur_Rank2_Logisticien = nbt.getDouble("Mineur_Rank2_Logisticien");
			Mineur_Rank3 = nbt.getBoolean("Mineur_Rank3");
			Mineur_Rank3_Mineur = nbt.getDouble("Mineur_Rank3_Mineur");
			Mineur_Rank4 = nbt.getBoolean("Mineur_Rank4");
			Mineur_Rank5 = nbt.getBoolean("Mineur_Rank5");
			Mineur_Rank5_Directeur = nbt.getDouble("Mineur_Rank5_Directeur");
			Police_CoffreFort = nbt.getBoolean("Police_CoffreFort");
			Police_IsCuffed = nbt.getBoolean("Police_IsCuffed");
			Police_IsPolice = nbt.getBoolean("Police_IsPolice");
			Police_IsWork = nbt.getBoolean("Police_IsWork");
			Police_Rank1 = nbt.getDouble("Police_Rank1");
			Police_Rank1_Recrue = nbt.getBoolean("Police_Rank1_Recrue");
			Police_Rank2 = nbt.getDouble("Police_Rank2");
			Police_Rank2_Officier = nbt.getBoolean("Police_Rank2_Officier");
			Police_Rank3 = nbt.getDouble("Police_Rank3");
			Police_Rank3_Lieutenant = nbt.getBoolean("Police_Rank3_Lieutenant");
			Police_Rank4 = nbt.getDouble("Police_Rank4");
			Police_Rank4_Enqueteur = nbt.getBoolean("Police_Rank4_Enqueteur");
			Police_Rank5_Capitaine = nbt.getBoolean("Police_Rank5_Capitaine");
			Police_Rank6 = nbt.getDouble("Police_Rank6");
			Police_Rank6_Commandant = nbt.getBoolean("Police_Rank6_Commandant");
			Prison_CoffreFort = nbt.getDouble("Prison_CoffreFort");
			Prison_IsPrison = nbt.getBoolean("Prison_IsPrison");
			Prison_IsWork = nbt.getBoolean("Prison_IsWork");
			Prison_Rank1 = nbt.getBoolean("Prison_Rank1");
			Prison_Rank2 = nbt.getBoolean("Prison_Rank2");
			Prison_Rank3 = nbt.getBoolean("Prison_Rank3");
			Prison_Rank4 = nbt.getBoolean("Prison_Rank4");
			Train_CoffreFort = nbt.getDouble("Train_CoffreFort");
			Train_IsTrain = nbt.getBoolean("Train_IsTrain");
			Train_IsWork = nbt.getBoolean("Train_IsWork");
			Train_Rank2 = nbt.getBoolean("Train_Rank2");
			Train_Rank2_Controleur = nbt.getDouble("Train_Rank2_Controleur");
			Train_Rank3 = nbt.getBoolean("Train_Rank3");
			Train_Rank3_Ingenieur = nbt.getDouble("Train_Rank3_Ingenieur");
			Train_Rank4 = nbt.getBoolean("Train_Rank4");
			Train_Rank4_ViceDirecteur = nbt.getDouble("Train_Rank4_ViceDirecteur");
			Train_Rank5 = nbt.getBoolean("Train_Rank5");
			Train_Rank5_Directeur = nbt.getDouble("Train_Rank5_Directeur");
			Vigneron_CoffreFort = nbt.getDouble("Vigneron_CoffreFort");
			Vigneron_IsVigneron = nbt.getBoolean("Vigneron_IsVigneron");
			Vigneron_IsWork = nbt.getBoolean("Vigneron_IsWork");
			Vigneron_Rank1 = nbt.getBoolean("Vigneron_Rank1");
			Vigneron_Rank1_Vendeur = nbt.getDouble("Vigneron_Rank1_Vendeur");
			Vigneron_Rank2 = nbt.getBoolean("Vigneron_Rank2");
			Vigneron_Rank2_Logisticien = nbt.getDouble("Vigneron_Rank2_Logisticien");
			Vigneron_Rank3 = nbt.getBoolean("Vigneron_Rank3");
			Vigneron_Rank3_Vigneron = nbt.getDouble("Vigneron_Rank3_Vigneron");
			Vigneron_Rank4 = nbt.getBoolean("Vigneron_Rank4");
			Vigneron_Rank4_ViceDirecteur = nbt.getDouble("Vigneron_Rank4_ViceDirecteur");
			Vigneron_Rank5 = nbt.getBoolean("Vigneron_Rank5");
			Prison_Rank1_Gardien = nbt.getDouble("Prison_Rank1_Gardien");
			Prison_Rank2_Superviseur = nbt.getDouble("Prison_Rank2_Superviseur");
			Prison_Rank3_ViceDirecteur = nbt.getDouble("Prison_Rank3_ViceDirecteur");
			Prison_Rank5_Directeur = nbt.getDouble("Prison_Rank5_Directeur");
			Vigneron_Rank5_Directeur = nbt.getDouble("Vigneron_Rank5_Directeur");
			Eleveur_Rank2_Logisticien = nbt.getDouble("Eleveur_Rank2_Logisticien");
			Train_Rank1_Conducteur = nbt.getDouble("Train_Rank1_Conducteur");
			Police_Rank5 = nbt.getDouble("Police_Rank5");
			Train_Rank1 = nbt.getBoolean("Train_Rank1");
			Mineur_Rank4_ViceDirecteur = nbt.getDouble("Mineur_Rank4_ViceDirecteur");
			Banque_rate_D_PC = nbt.getDouble("Banque_rate_D_PC");
			Banque_rate_D_PC_temp = nbt.getDouble("Banque_rate_D_PC_temp");
			Banque_rate_buy_pc = nbt.getDouble("Banque_rate_buy_pc");
			Banque_stock_1pc = nbt.getDouble("Banque_stock_1pc");
			Banque_stock_5pc = nbt.getDouble("Banque_stock_5pc");
			Banque_stock_10pc = nbt.getDouble("Banque_stock_10pc");
			Banque_stock_20pc = nbt.getDouble("Banque_stock_20pc");
			Banque_stock_50pc = nbt.getDouble("Banque_stock_50pc");
			Banque_stock_100pc = nbt.getDouble("Banque_stock_100pc");
			Banque_stock_200pc = nbt.getDouble("Banque_stock_200pc");
			Banque_stock_500pc = nbt.getDouble("Banque_stock_500pc");
			Banque_total_supply = nbt.getDouble("Banque_total_supply");
			Banque_reserve = nbt.getDouble("Banque_reserve");
			Banque_Diamand_stock = nbt.getDouble("Banque_Diamand_stock");
			Banque_total_buy = nbt.getDouble("Banque_total_buy");
			Banque_total_buy_M = nbt.getDouble("Banque_total_buy_M");
			Banque_total_buy_rate = nbt.getDouble("Banque_total_buy_rate");
			Banque_total_periodes = nbt.getDouble("Banque_total_periodes");
			Banque_time_periode = nbt.getDouble("Banque_time_periode");
			Banque_periode_buy = nbt.getDouble("Banque_periode_buy");
			Banque_periode_buy_M = nbt.getDouble("Banque_periode_buy_M");
			testt = nbt.getString("testt");
			Banque_time_timer = nbt.getDouble("Banque_time_timer");
			Banque_time_active = nbt.getBoolean("Banque_time_active");
			Banque_time_sec = nbt.getDouble("Banque_time_sec");
			Banque_time_min = nbt.getDouble("Banque_time_min");
			Banque_time_heu = nbt.getDouble("Banque_time_heu");
			Banque_time_jou = nbt.getDouble("Banque_time_jou");
			Banque_time_sem = nbt.getDouble("Banque_time_sem");
			ghgffjtfjgjgf = nbt.getDouble("ghgffjtfjgjgf");
			Banque_facteur = nbt.getDouble("Banque_facteur");
			Banque_facteur_Me = nbt.getDouble("Banque_facteur_Me");
			Banque_facteur_Mo = nbt.getDouble("Banque_facteur_Mo");
			Banque_periode_buy_Me = nbt.getDouble("Banque_periode_buy_Me");
			AtmTemp = Direction.from3DDataValue(nbt.getInt("AtmTemp"));
			Global_PlayerUnique = nbt.getDouble("Global_PlayerUnique");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putDouble("Boulanger_CoffreFort", Boulanger_CoffreFort);
			nbt.putBoolean("Boulanger_IsBoulanger", Boulanger_IsBoulanger);
			nbt.putBoolean("Boulanger_IsWork", Boulanger_IsWork);
			nbt.putBoolean("Boulanger_Rank1", Boulanger_Rank1);
			nbt.putDouble("Boulanger_Rank1_Vendeur", Boulanger_Rank1_Vendeur);
			nbt.putBoolean("Boulanger_Rank2", Boulanger_Rank2);
			nbt.putDouble("Boulanger_Rank2_Logisticien", Boulanger_Rank2_Logisticien);
			nbt.putBoolean("Boulanger_Rank3", Boulanger_Rank3);
			nbt.putDouble("Boulanger_Rank3_Boulanger", Boulanger_Rank3_Boulanger);
			nbt.putBoolean("Boulanger_Rank4", Boulanger_Rank4);
			nbt.putDouble("Boulanger_Rank4_ViceDirecteur", Boulanger_Rank4_ViceDirecteur);
			nbt.putBoolean("Boulanger_Rank5", Boulanger_Rank5);
			nbt.putDouble("Boulanger_Rank5_Directeur", Boulanger_Rank5_Directeur);
			nbt.putDouble("Bucheron_CoffreFort", Bucheron_CoffreFort);
			nbt.putBoolean("Bucheron_IsBucheron", Bucheron_IsBucheron);
			nbt.putBoolean("Bucheron_IsWork", Bucheron_IsWork);
			nbt.putBoolean("Bucheron_Rank1", Bucheron_Rank1);
			nbt.putDouble("Bucheron_Rank1_Vendeur", Bucheron_Rank1_Vendeur);
			nbt.putBoolean("Bucheron_Rank2", Bucheron_Rank2);
			nbt.putDouble("Bucheron_Rank2_Logisticien", Bucheron_Rank2_Logisticien);
			nbt.putBoolean("Bucheron_Rank3", Bucheron_Rank3);
			nbt.putDouble("Bucheron_Rank3_Bucheron", Bucheron_Rank3_Bucheron);
			nbt.putBoolean("Bucheron_Rank4", Bucheron_Rank4);
			nbt.putDouble("Bucheron_Rank4_ViceDirecteur", Bucheron_Rank4_ViceDirecteur);
			nbt.putBoolean("Bucheron_Rank5", Bucheron_Rank5);
			nbt.putDouble("Bucheron_Rank5_Directeur", Bucheron_Rank5_Directeur);
			nbt.putDouble("Eleveur_CoffreFort", Eleveur_CoffreFort);
			nbt.putBoolean("Eleveur_IsEleveur", Eleveur_IsEleveur);
			nbt.putBoolean("Eleveur_IsWork", Eleveur_IsWork);
			nbt.putBoolean("Eleveur_Rank1", Eleveur_Rank1);
			nbt.putDouble("Eleveur_Rank1_Vendeur", Eleveur_Rank1_Vendeur);
			nbt.putBoolean("Eleveur_Rank2", Eleveur_Rank2);
			nbt.putBoolean("Eleveur_Rank3", Eleveur_Rank3);
			nbt.putDouble("Eleveur_Rank3_Eleveur", Eleveur_Rank3_Eleveur);
			nbt.putBoolean("Eleveur_Rank4", Eleveur_Rank4);
			nbt.putDouble("Eleveur_Rank4_ViceDirecteur", Eleveur_Rank4_ViceDirecteur);
			nbt.putBoolean("Eleveur_Rank5", Eleveur_Rank5);
			nbt.putDouble("Eleveur_Rank5_Directeur", Eleveur_Rank5_Directeur);
			nbt.putDouble("Farmer_CoffreFort", Farmer_CoffreFort);
			nbt.putBoolean("Farmer_IsFarmer", Farmer_IsFarmer);
			nbt.putBoolean("Farmer_IsWork", Farmer_IsWork);
			nbt.putBoolean("Farmer_Rank1", Farmer_Rank1);
			nbt.putDouble("Farmer_Rank1_Vendeur", Farmer_Rank1_Vendeur);
			nbt.putBoolean("Farmer_Rank2", Farmer_Rank2);
			nbt.putDouble("Farmer_Rank2_Logisticien", Farmer_Rank2_Logisticien);
			nbt.putBoolean("Farmer_Rank3", Farmer_Rank3);
			nbt.putDouble("Farmer_Rank3_Farmer", Farmer_Rank3_Farmer);
			nbt.putBoolean("Farmer_Rank4", Farmer_Rank4);
			nbt.putDouble("Farmer_Rank4_ViceDirecteur", Farmer_Rank4_ViceDirecteur);
			nbt.putBoolean("Farmer_Rank5", Farmer_Rank5);
			nbt.putDouble("Farmer_Rank5_Directeur", Farmer_Rank5_Directeur);
			nbt.putDouble("Medic_CoffreFort", Medic_CoffreFort);
			nbt.putDouble("Medic_IsHealthLevel", Medic_IsHealthLevel);
			nbt.putBoolean("Medic_IsMedic", Medic_IsMedic);
			nbt.putBoolean("Medic_IsMedicOnline", Medic_IsMedicOnline);
			nbt.putBoolean("Medic_IsWork", Medic_IsWork);
			nbt.putBoolean("Medic_Rank1", Medic_Rank1);
			nbt.putDouble("Medic_Rank1_Secouriste", Medic_Rank1_Secouriste);
			nbt.putBoolean("Medic_Rank2", Medic_Rank2);
			nbt.putDouble("Medic_Rank2_Infirmier", Medic_Rank2_Infirmier);
			nbt.putBoolean("Medic_Rank3", Medic_Rank3);
			nbt.putDouble("Medic_Rank3_Medecin", Medic_Rank3_Medecin);
			nbt.putBoolean("Medic_Rank4", Medic_Rank4);
			nbt.putDouble("Medic_Rank4_Chirurgien", Medic_Rank4_Chirurgien);
			nbt.putBoolean("Medic_Rank5", Medic_Rank5);
			nbt.putDouble("Medic_Rank5_ViceDirecteur", Medic_Rank5_ViceDirecteur);
			nbt.putBoolean("Medic_Rank6", Medic_Rank6);
			nbt.putDouble("Medic_Rank6_Directeur", Medic_Rank6_Directeur);
			nbt.putBoolean("Mineur_IsMineur", Mineur_IsMineur);
			nbt.putBoolean("Mineur_IsWork", Mineur_IsWork);
			nbt.putBoolean("Mineur_Rank1", Mineur_Rank1);
			nbt.putDouble("Mineur_Rank1_Vendeur", Mineur_Rank1_Vendeur);
			nbt.putBoolean("Mineur_Rank2", Mineur_Rank2);
			nbt.putDouble("Mineur_Rank2_Logisticien", Mineur_Rank2_Logisticien);
			nbt.putBoolean("Mineur_Rank3", Mineur_Rank3);
			nbt.putDouble("Mineur_Rank3_Mineur", Mineur_Rank3_Mineur);
			nbt.putBoolean("Mineur_Rank4", Mineur_Rank4);
			nbt.putBoolean("Mineur_Rank5", Mineur_Rank5);
			nbt.putDouble("Mineur_Rank5_Directeur", Mineur_Rank5_Directeur);
			nbt.putBoolean("Police_CoffreFort", Police_CoffreFort);
			nbt.putBoolean("Police_IsCuffed", Police_IsCuffed);
			nbt.putBoolean("Police_IsPolice", Police_IsPolice);
			nbt.putBoolean("Police_IsWork", Police_IsWork);
			nbt.putDouble("Police_Rank1", Police_Rank1);
			nbt.putBoolean("Police_Rank1_Recrue", Police_Rank1_Recrue);
			nbt.putDouble("Police_Rank2", Police_Rank2);
			nbt.putBoolean("Police_Rank2_Officier", Police_Rank2_Officier);
			nbt.putDouble("Police_Rank3", Police_Rank3);
			nbt.putBoolean("Police_Rank3_Lieutenant", Police_Rank3_Lieutenant);
			nbt.putDouble("Police_Rank4", Police_Rank4);
			nbt.putBoolean("Police_Rank4_Enqueteur", Police_Rank4_Enqueteur);
			nbt.putBoolean("Police_Rank5_Capitaine", Police_Rank5_Capitaine);
			nbt.putDouble("Police_Rank6", Police_Rank6);
			nbt.putBoolean("Police_Rank6_Commandant", Police_Rank6_Commandant);
			nbt.putDouble("Prison_CoffreFort", Prison_CoffreFort);
			nbt.putBoolean("Prison_IsPrison", Prison_IsPrison);
			nbt.putBoolean("Prison_IsWork", Prison_IsWork);
			nbt.putBoolean("Prison_Rank1", Prison_Rank1);
			nbt.putBoolean("Prison_Rank2", Prison_Rank2);
			nbt.putBoolean("Prison_Rank3", Prison_Rank3);
			nbt.putBoolean("Prison_Rank4", Prison_Rank4);
			nbt.putDouble("Train_CoffreFort", Train_CoffreFort);
			nbt.putBoolean("Train_IsTrain", Train_IsTrain);
			nbt.putBoolean("Train_IsWork", Train_IsWork);
			nbt.putBoolean("Train_Rank2", Train_Rank2);
			nbt.putDouble("Train_Rank2_Controleur", Train_Rank2_Controleur);
			nbt.putBoolean("Train_Rank3", Train_Rank3);
			nbt.putDouble("Train_Rank3_Ingenieur", Train_Rank3_Ingenieur);
			nbt.putBoolean("Train_Rank4", Train_Rank4);
			nbt.putDouble("Train_Rank4_ViceDirecteur", Train_Rank4_ViceDirecteur);
			nbt.putBoolean("Train_Rank5", Train_Rank5);
			nbt.putDouble("Train_Rank5_Directeur", Train_Rank5_Directeur);
			nbt.putDouble("Vigneron_CoffreFort", Vigneron_CoffreFort);
			nbt.putBoolean("Vigneron_IsVigneron", Vigneron_IsVigneron);
			nbt.putBoolean("Vigneron_IsWork", Vigneron_IsWork);
			nbt.putBoolean("Vigneron_Rank1", Vigneron_Rank1);
			nbt.putDouble("Vigneron_Rank1_Vendeur", Vigneron_Rank1_Vendeur);
			nbt.putBoolean("Vigneron_Rank2", Vigneron_Rank2);
			nbt.putDouble("Vigneron_Rank2_Logisticien", Vigneron_Rank2_Logisticien);
			nbt.putBoolean("Vigneron_Rank3", Vigneron_Rank3);
			nbt.putDouble("Vigneron_Rank3_Vigneron", Vigneron_Rank3_Vigneron);
			nbt.putBoolean("Vigneron_Rank4", Vigneron_Rank4);
			nbt.putDouble("Vigneron_Rank4_ViceDirecteur", Vigneron_Rank4_ViceDirecteur);
			nbt.putBoolean("Vigneron_Rank5", Vigneron_Rank5);
			nbt.putDouble("Prison_Rank1_Gardien", Prison_Rank1_Gardien);
			nbt.putDouble("Prison_Rank2_Superviseur", Prison_Rank2_Superviseur);
			nbt.putDouble("Prison_Rank3_ViceDirecteur", Prison_Rank3_ViceDirecteur);
			nbt.putDouble("Prison_Rank5_Directeur", Prison_Rank5_Directeur);
			nbt.putDouble("Vigneron_Rank5_Directeur", Vigneron_Rank5_Directeur);
			nbt.putDouble("Eleveur_Rank2_Logisticien", Eleveur_Rank2_Logisticien);
			nbt.putDouble("Train_Rank1_Conducteur", Train_Rank1_Conducteur);
			nbt.putDouble("Police_Rank5", Police_Rank5);
			nbt.putBoolean("Train_Rank1", Train_Rank1);
			nbt.putDouble("Mineur_Rank4_ViceDirecteur", Mineur_Rank4_ViceDirecteur);
			nbt.putDouble("Banque_rate_D_PC", Banque_rate_D_PC);
			nbt.putDouble("Banque_rate_D_PC_temp", Banque_rate_D_PC_temp);
			nbt.putDouble("Banque_rate_buy_pc", Banque_rate_buy_pc);
			nbt.putDouble("Banque_stock_1pc", Banque_stock_1pc);
			nbt.putDouble("Banque_stock_5pc", Banque_stock_5pc);
			nbt.putDouble("Banque_stock_10pc", Banque_stock_10pc);
			nbt.putDouble("Banque_stock_20pc", Banque_stock_20pc);
			nbt.putDouble("Banque_stock_50pc", Banque_stock_50pc);
			nbt.putDouble("Banque_stock_100pc", Banque_stock_100pc);
			nbt.putDouble("Banque_stock_200pc", Banque_stock_200pc);
			nbt.putDouble("Banque_stock_500pc", Banque_stock_500pc);
			nbt.putDouble("Banque_total_supply", Banque_total_supply);
			nbt.putDouble("Banque_reserve", Banque_reserve);
			nbt.putDouble("Banque_Diamand_stock", Banque_Diamand_stock);
			nbt.putDouble("Banque_total_buy", Banque_total_buy);
			nbt.putDouble("Banque_total_buy_M", Banque_total_buy_M);
			nbt.putDouble("Banque_total_buy_rate", Banque_total_buy_rate);
			nbt.putDouble("Banque_total_periodes", Banque_total_periodes);
			nbt.putDouble("Banque_time_periode", Banque_time_periode);
			nbt.putDouble("Banque_periode_buy", Banque_periode_buy);
			nbt.putDouble("Banque_periode_buy_M", Banque_periode_buy_M);
			nbt.putString("testt", testt);
			nbt.putDouble("Banque_time_timer", Banque_time_timer);
			nbt.putBoolean("Banque_time_active", Banque_time_active);
			nbt.putDouble("Banque_time_sec", Banque_time_sec);
			nbt.putDouble("Banque_time_min", Banque_time_min);
			nbt.putDouble("Banque_time_heu", Banque_time_heu);
			nbt.putDouble("Banque_time_jou", Banque_time_jou);
			nbt.putDouble("Banque_time_sem", Banque_time_sem);
			nbt.putDouble("ghgffjtfjgjgf", ghgffjtfjgjgf);
			nbt.putDouble("Banque_facteur", Banque_facteur);
			nbt.putDouble("Banque_facteur_Me", Banque_facteur_Me);
			nbt.putDouble("Banque_facteur_Mo", Banque_facteur_Mo);
			nbt.putDouble("Banque_periode_buy_Me", Banque_periode_buy_Me);
			nbt.putInt("AtmTemp", AtmTemp.get3DDataValue());
			nbt.putDouble("Global_PlayerUnique", Global_PlayerUnique);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				ElyrasirMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		private final int type;
		private SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			if (nbt != null) {
				this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
				if (this.data instanceof MapVariables mapVariables)
					mapVariables.read(nbt);
				else if (this.data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt);
			}
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("elyrasir", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public String Banque_card_name = "\"\"";
		public String Global_nom = "\"\"";
		public String Global_prenom = "\"\"";
		public String Global_age = "\"\"";
		public String Global_origine = "\"\"";
		public double Global_PID = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				ElyrasirMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putString("Banque_card_name", Banque_card_name);
			nbt.putString("Global_nom", Global_nom);
			nbt.putString("Global_prenom", Global_prenom);
			nbt.putString("Global_age", Global_age);
			nbt.putString("Global_origine", Global_origine);
			nbt.putDouble("Global_PID", Global_PID);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			Banque_card_name = nbt.getString("Banque_card_name");
			Global_nom = nbt.getString("Global_nom");
			Global_prenom = nbt.getString("Global_prenom");
			Global_age = nbt.getString("Global_age");
			Global_origine = nbt.getString("Global_origine");
			Global_PID = nbt.getDouble("Global_PID");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.Banque_card_name = message.data.Banque_card_name;
					variables.Global_nom = message.data.Global_nom;
					variables.Global_prenom = message.data.Global_prenom;
					variables.Global_age = message.data.Global_age;
					variables.Global_origine = message.data.Global_origine;
					variables.Global_PID = message.data.Global_PID;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
