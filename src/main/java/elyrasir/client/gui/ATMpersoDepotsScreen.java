package elyrasir.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import elyrasir.world.inventory.ATMpersoDepotsMenu;

import elyrasir.procedures.ReturnPlayerAcountValueProcedure;

import elyrasir.network.ATMpersoDepotsButtonMessage;

import elyrasir.ElyrasirMod;

import com.mojang.blaze3d.systems.RenderSystem;

public class ATMpersoDepotsScreen extends AbstractContainerScreen<ATMpersoDepotsMenu> {
	private final static HashMap<String, Object> guistate = ATMpersoDepotsMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_round_button_vanilla;
	ImageButton imagebutton_round_button_vanilla1;
	ImageButton imagebutton_round_button_vanilla2;
	ImageButton imagebutton_round_button_vanilla3;
	ImageButton imagebutton_round_button_vanilla4;

	public ATMpersoDepotsScreen(ATMpersoDepotsMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 245;
		this.imageHeight = 220;
	}

	private static final ResourceLocation texture = new ResourceLocation("elyrasir:textures/screens/at_mperso_depots.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("elyrasir:textures/screens/banque_panel.png"), this.leftPos + 17, this.topPos + 12, 0, 0, 187, 112, 187, 112);

		guiGraphics.blit(new ResourceLocation("elyrasir:textures/screens/corner_bottom_left.png"), this.leftPos + 16, this.topPos + 115, 0, 0, 10, 10, 10, 10);

		guiGraphics.blit(new ResourceLocation("elyrasir:textures/screens/corner_top_left.png"), this.leftPos + 16, this.topPos + 11, 0, 0, 10, 10, 10, 10);

		guiGraphics.blit(new ResourceLocation("elyrasir:textures/screens/corner_top_right.png"), this.leftPos + 195, this.topPos + 11, 0, 0, 10, 10, 10, 10);

		guiGraphics.blit(new ResourceLocation("elyrasir:textures/screens/corner_bottom_right.png"), this.leftPos + 195, this.topPos + 115, 0, 0, 10, 10, 10, 10);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.at_mperso_depots.label_bienvenue_a_la_banque"), 63, 12, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.at_mperso_depots.label_veuillez_choisir_une_service"), 31, 31, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.at_mperso_depots.label_acheter_du_pommecoin"), 48, 96, -3355444, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.at_mperso_depots.label_quitter"), 116, 108, -52429, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.at_mperso_depots.label_1"), 183, 96, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.at_mperso_depots.label_11"), 217, 17, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.at_mperso_depots.label_5"), 183, 108, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.at_mperso_depots.label_21"), 217, 40, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.at_mperso_depots.label_31"), 217, 63, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.at_mperso_depots.label_41"), 217, 86, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.at_mperso_depots.label_51"), 218, 109, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.at_mperso_depots.label_puis_effectuez_lechange"), 51, 42, -16777216, false);
		guiGraphics.drawString(this.font,

				ReturnPlayerAcountValueProcedure.execute(entity), 51, 58, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		imagebutton_round_button_vanilla = new ImageButton(this.leftPos + 210, this.topPos + 12, 20, 20, 0, 0, 20, new ResourceLocation("elyrasir:textures/screens/atlas/imagebutton_round_button_vanilla.png"), 20, 40, e -> {
			if (true) {
				ElyrasirMod.PACKET_HANDLER.sendToServer(new ATMpersoDepotsButtonMessage(0, x, y, z));
				ATMpersoDepotsButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_round_button_vanilla", imagebutton_round_button_vanilla);
		this.addRenderableWidget(imagebutton_round_button_vanilla);
		imagebutton_round_button_vanilla1 = new ImageButton(this.leftPos + 210, this.topPos + 35, 20, 20, 0, 0, 20, new ResourceLocation("elyrasir:textures/screens/atlas/imagebutton_round_button_vanilla1.png"), 20, 40, e -> {
		});
		guistate.put("button:imagebutton_round_button_vanilla1", imagebutton_round_button_vanilla1);
		this.addRenderableWidget(imagebutton_round_button_vanilla1);
		imagebutton_round_button_vanilla2 = new ImageButton(this.leftPos + 210, this.topPos + 58, 20, 20, 0, 0, 20, new ResourceLocation("elyrasir:textures/screens/atlas/imagebutton_round_button_vanilla2.png"), 20, 40, e -> {
		});
		guistate.put("button:imagebutton_round_button_vanilla2", imagebutton_round_button_vanilla2);
		this.addRenderableWidget(imagebutton_round_button_vanilla2);
		imagebutton_round_button_vanilla3 = new ImageButton(this.leftPos + 210, this.topPos + 81, 20, 20, 0, 0, 20, new ResourceLocation("elyrasir:textures/screens/atlas/imagebutton_round_button_vanilla3.png"), 20, 40, e -> {
		});
		guistate.put("button:imagebutton_round_button_vanilla3", imagebutton_round_button_vanilla3);
		this.addRenderableWidget(imagebutton_round_button_vanilla3);
		imagebutton_round_button_vanilla4 = new ImageButton(this.leftPos + 210, this.topPos + 104, 20, 20, 0, 0, 20, new ResourceLocation("elyrasir:textures/screens/atlas/imagebutton_round_button_vanilla4.png"), 20, 40, e -> {
			if (true) {
				ElyrasirMod.PACKET_HANDLER.sendToServer(new ATMpersoDepotsButtonMessage(4, x, y, z));
				ATMpersoDepotsButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_round_button_vanilla4", imagebutton_round_button_vanilla4);
		this.addRenderableWidget(imagebutton_round_button_vanilla4);
	}
}
