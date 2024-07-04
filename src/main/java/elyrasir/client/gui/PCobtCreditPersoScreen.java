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

import elyrasir.world.inventory.PCobtCreditPersoMenu;

import elyrasir.network.PCobtCreditPersoButtonMessage;

import elyrasir.ElyrasirMod;

import com.mojang.blaze3d.systems.RenderSystem;

public class PCobtCreditPersoScreen extends AbstractContainerScreen<PCobtCreditPersoMenu> {
	private final static HashMap<String, Object> guistate = PCobtCreditPersoMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_round_button_vanilla;
	ImageButton imagebutton_round_button_vanilla1;
	ImageButton imagebutton_round_button_vanilla2;
	ImageButton imagebutton_round_button_vanilla3;
	ImageButton imagebutton_round_button_vanilla4;

	public PCobtCreditPersoScreen(PCobtCreditPersoMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 236;
		this.imageHeight = 220;
	}

	private static final ResourceLocation texture = new ResourceLocation("elyrasir:textures/screens/p_cobt_credit_perso.png");

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

		guiGraphics.blit(new ResourceLocation("elyrasir:textures/screens/banque_panel.png"), this.leftPos + 12, this.topPos + 12, 0, 0, 187, 112, 187, 112);

		guiGraphics.blit(new ResourceLocation("elyrasir:textures/screens/corner_bottom_left.png"), this.leftPos + 11, this.topPos + 115, 0, 0, 10, 10, 10, 10);

		guiGraphics.blit(new ResourceLocation("elyrasir:textures/screens/corner_top_left.png"), this.leftPos + 11, this.topPos + 11, 0, 0, 10, 10, 10, 10);

		guiGraphics.blit(new ResourceLocation("elyrasir:textures/screens/corner_top_right.png"), this.leftPos + 190, this.topPos + 11, 0, 0, 10, 10, 10, 10);

		guiGraphics.blit(new ResourceLocation("elyrasir:textures/screens/corner_bottom_right.png"), this.leftPos + 190, this.topPos + 115, 0, 0, 10, 10, 10, 10);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.p_cobt_credit_perso.label_bienvenue_a_la_banque"), 56, 15, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.p_cobt_credit_perso.label_veuillez_choisir_une_service"), 37, 24, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.p_cobt_credit_perso.label_acheter_du_pommecoin"), 15, 40, -3355444, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.p_cobt_credit_perso.label_info_banque"), 70, 71, -3355444, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.p_cobt_credit_perso.label_quitter"), 111, 108, -52429, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.p_cobt_credit_perso.label_1"), 178, 41, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.p_cobt_credit_perso.label_11"), 212, 17, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.p_cobt_credit_perso.label_2"), 178, 56, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.p_cobt_credit_perso.label_3"), 178, 72, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.p_cobt_credit_perso.label_5"), 178, 108, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.p_cobt_credit_perso.label_21"), 212, 40, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.p_cobt_credit_perso.label_31"), 212, 63, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.p_cobt_credit_perso.label_41"), 212, 86, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.p_cobt_credit_perso.label_51"), 213, 109, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.p_cobt_credit_perso.label_reserver_une_chambre"), 7, 55, -1, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		imagebutton_round_button_vanilla = new ImageButton(this.leftPos + 205, this.topPos + 12, 20, 20, 0, 0, 20, new ResourceLocation("elyrasir:textures/screens/atlas/imagebutton_round_button_vanilla.png"), 20, 40, e -> {
			if (true) {
				ElyrasirMod.PACKET_HANDLER.sendToServer(new PCobtCreditPersoButtonMessage(0, x, y, z));
				PCobtCreditPersoButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_round_button_vanilla", imagebutton_round_button_vanilla);
		this.addRenderableWidget(imagebutton_round_button_vanilla);
		imagebutton_round_button_vanilla1 = new ImageButton(this.leftPos + 205, this.topPos + 35, 20, 20, 0, 0, 20, new ResourceLocation("elyrasir:textures/screens/atlas/imagebutton_round_button_vanilla1.png"), 20, 40, e -> {
			if (true) {
				ElyrasirMod.PACKET_HANDLER.sendToServer(new PCobtCreditPersoButtonMessage(1, x, y, z));
				PCobtCreditPersoButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_round_button_vanilla1", imagebutton_round_button_vanilla1);
		this.addRenderableWidget(imagebutton_round_button_vanilla1);
		imagebutton_round_button_vanilla2 = new ImageButton(this.leftPos + 205, this.topPos + 58, 20, 20, 0, 0, 20, new ResourceLocation("elyrasir:textures/screens/atlas/imagebutton_round_button_vanilla2.png"), 20, 40, e -> {
		});
		guistate.put("button:imagebutton_round_button_vanilla2", imagebutton_round_button_vanilla2);
		this.addRenderableWidget(imagebutton_round_button_vanilla2);
		imagebutton_round_button_vanilla3 = new ImageButton(this.leftPos + 205, this.topPos + 81, 20, 20, 0, 0, 20, new ResourceLocation("elyrasir:textures/screens/atlas/imagebutton_round_button_vanilla3.png"), 20, 40, e -> {
		});
		guistate.put("button:imagebutton_round_button_vanilla3", imagebutton_round_button_vanilla3);
		this.addRenderableWidget(imagebutton_round_button_vanilla3);
		imagebutton_round_button_vanilla4 = new ImageButton(this.leftPos + 205, this.topPos + 104, 20, 20, 0, 0, 20, new ResourceLocation("elyrasir:textures/screens/atlas/imagebutton_round_button_vanilla4.png"), 20, 40, e -> {
			if (true) {
				ElyrasirMod.PACKET_HANDLER.sendToServer(new PCobtCreditPersoButtonMessage(4, x, y, z));
				PCobtCreditPersoButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_round_button_vanilla4", imagebutton_round_button_vanilla4);
		this.addRenderableWidget(imagebutton_round_button_vanilla4);
	}
}
