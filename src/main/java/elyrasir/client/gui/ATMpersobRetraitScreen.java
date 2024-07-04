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

import elyrasir.world.inventory.ATMpersobRetraitMenu;

import elyrasir.procedures.ReturnPlayerAcountValueProcedure;

import elyrasir.network.ATMpersobRetraitButtonMessage;

import elyrasir.ElyrasirMod;

import com.mojang.blaze3d.systems.RenderSystem;

public class ATMpersobRetraitScreen extends AbstractContainerScreen<ATMpersobRetraitMenu> {
	private final static HashMap<String, Object> guistate = ATMpersobRetraitMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_round_button_vanilla;
	ImageButton imagebutton_round_button_vanilla1;
	ImageButton imagebutton_round_button_vanilla2;
	ImageButton imagebutton_round_button_vanilla3;
	ImageButton imagebutton_round_button_vanilla4;
	ImageButton imagebutton_billet50pc;
	ImageButton imagebutton_billet500pc;
	ImageButton imagebutton_billet20pc;
	ImageButton imagebutton_billet200pc;
	ImageButton imagebutton_billet10pc;
	ImageButton imagebutton_billet100pc;
	ImageButton imagebutton_piece1pc;
	ImageButton imagebutton_piece5pc;

	public ATMpersobRetraitScreen(ATMpersobRetraitMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 245;
		this.imageHeight = 220;
	}

	private static final ResourceLocation texture = new ResourceLocation("elyrasir:textures/screens/at_mpersob_retrait.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.at_mpersob_retrait.label_bienvenue_a_la_banque"), 94, 14, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.at_mpersob_retrait.label_quitter"), 116, 108, -52429, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.at_mpersob_retrait.label_11"), 217, 17, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.at_mpersob_retrait.label_5"), 183, 108, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.at_mpersob_retrait.label_21"), 217, 40, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.at_mpersob_retrait.label_31"), 217, 63, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.at_mpersob_retrait.label_41"), 217, 86, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.at_mpersob_retrait.label_51"), 218, 109, -16777216, false);
		guiGraphics.drawString(this.font,

				ReturnPlayerAcountValueProcedure.execute(entity), 92, 28, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.at_mpersob_retrait.label_account_value"), 19, 28, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		imagebutton_round_button_vanilla = new ImageButton(this.leftPos + 210, this.topPos + 12, 20, 20, 0, 0, 20, new ResourceLocation("elyrasir:textures/screens/atlas/imagebutton_round_button_vanilla.png"), 20, 40, e -> {
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
				ElyrasirMod.PACKET_HANDLER.sendToServer(new ATMpersobRetraitButtonMessage(4, x, y, z));
				ATMpersobRetraitButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_round_button_vanilla4", imagebutton_round_button_vanilla4);
		this.addRenderableWidget(imagebutton_round_button_vanilla4);
		imagebutton_billet50pc = new ImageButton(this.leftPos + 37, this.topPos + 73, 32, 32, 0, 0, 32, new ResourceLocation("elyrasir:textures/screens/atlas/imagebutton_billet50pc.png"), 32, 64, e -> {
			if (true) {
				ElyrasirMod.PACKET_HANDLER.sendToServer(new ATMpersobRetraitButtonMessage(5, x, y, z));
				ATMpersobRetraitButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_billet50pc", imagebutton_billet50pc);
		this.addRenderableWidget(imagebutton_billet50pc);
		imagebutton_billet500pc = new ImageButton(this.leftPos + 26, this.topPos + 38, 32, 32, 0, 0, 32, new ResourceLocation("elyrasir:textures/screens/atlas/imagebutton_billet500pc.png"), 32, 64, e -> {
			if (true) {
				ElyrasirMod.PACKET_HANDLER.sendToServer(new ATMpersobRetraitButtonMessage(6, x, y, z));
				ATMpersobRetraitButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:imagebutton_billet500pc", imagebutton_billet500pc);
		this.addRenderableWidget(imagebutton_billet500pc);
		imagebutton_billet20pc = new ImageButton(this.leftPos + 102, this.topPos + 73, 32, 32, 0, 0, 32, new ResourceLocation("elyrasir:textures/screens/atlas/imagebutton_billet20pc.png"), 32, 64, e -> {
			if (true) {
				ElyrasirMod.PACKET_HANDLER.sendToServer(new ATMpersobRetraitButtonMessage(7, x, y, z));
				ATMpersobRetraitButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		guistate.put("button:imagebutton_billet20pc", imagebutton_billet20pc);
		this.addRenderableWidget(imagebutton_billet20pc);
		imagebutton_billet200pc = new ImageButton(this.leftPos + 91, this.topPos + 39, 32, 32, 0, 0, 32, new ResourceLocation("elyrasir:textures/screens/atlas/imagebutton_billet200pc.png"), 32, 64, e -> {
			if (true) {
				ElyrasirMod.PACKET_HANDLER.sendToServer(new ATMpersobRetraitButtonMessage(8, x, y, z));
				ATMpersobRetraitButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		});
		guistate.put("button:imagebutton_billet200pc", imagebutton_billet200pc);
		this.addRenderableWidget(imagebutton_billet200pc);
		imagebutton_billet10pc = new ImageButton(this.leftPos + 166, this.topPos + 72, 32, 32, 0, 0, 32, new ResourceLocation("elyrasir:textures/screens/atlas/imagebutton_billet10pc.png"), 32, 64, e -> {
			if (true) {
				ElyrasirMod.PACKET_HANDLER.sendToServer(new ATMpersobRetraitButtonMessage(9, x, y, z));
				ATMpersobRetraitButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		});
		guistate.put("button:imagebutton_billet10pc", imagebutton_billet10pc);
		this.addRenderableWidget(imagebutton_billet10pc);
		imagebutton_billet100pc = new ImageButton(this.leftPos + 154, this.topPos + 38, 32, 32, 0, 0, 32, new ResourceLocation("elyrasir:textures/screens/atlas/imagebutton_billet100pc.png"), 32, 64, e -> {
			if (true) {
				ElyrasirMod.PACKET_HANDLER.sendToServer(new ATMpersobRetraitButtonMessage(10, x, y, z));
				ATMpersobRetraitButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		});
		guistate.put("button:imagebutton_billet100pc", imagebutton_billet100pc);
		this.addRenderableWidget(imagebutton_billet100pc);
		imagebutton_piece1pc = new ImageButton(this.leftPos + 126, this.topPos + 54, 32, 32, 0, 0, 32, new ResourceLocation("elyrasir:textures/screens/atlas/imagebutton_piece1pc.png"), 32, 64, e -> {
			if (true) {
				ElyrasirMod.PACKET_HANDLER.sendToServer(new ATMpersobRetraitButtonMessage(11, x, y, z));
				ATMpersobRetraitButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		});
		guistate.put("button:imagebutton_piece1pc", imagebutton_piece1pc);
		this.addRenderableWidget(imagebutton_piece1pc);
		imagebutton_piece5pc = new ImageButton(this.leftPos + 60, this.topPos + 53, 32, 32, 0, 0, 32, new ResourceLocation("elyrasir:textures/screens/atlas/imagebutton_piece5pc.png"), 32, 64, e -> {
			if (true) {
				ElyrasirMod.PACKET_HANDLER.sendToServer(new ATMpersobRetraitButtonMessage(12, x, y, z));
				ATMpersobRetraitButtonMessage.handleButtonAction(entity, 12, x, y, z);
			}
		});
		guistate.put("button:imagebutton_piece5pc", imagebutton_piece5pc);
		this.addRenderableWidget(imagebutton_piece5pc);
	}
}
