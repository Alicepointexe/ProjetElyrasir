package elyrasir.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import elyrasir.world.inventory.RegisterCMenu;

import elyrasir.procedures.ScreenPlayerProcedure;
import elyrasir.procedures.GetServerIDProcedure;

import elyrasir.network.RegisterCButtonMessage;

import elyrasir.ElyrasirMod;

import com.mojang.blaze3d.systems.RenderSystem;

public class RegisterCScreen extends AbstractContainerScreen<RegisterCMenu> {
	private final static HashMap<String, Object> guistate = RegisterCMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox E42_Prenom;
	EditBox E42_Nom;
	EditBox E42_age;
	EditBox E42_Origine;
	Button button_valider;

	public RegisterCScreen(RegisterCMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 231;
		this.imageHeight = 229;
	}

	private static final ResourceLocation texture = new ResourceLocation("elyrasir:textures/screens/register_c.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		E42_Prenom.render(guiGraphics, mouseX, mouseY, partialTicks);
		E42_Nom.render(guiGraphics, mouseX, mouseY, partialTicks);
		E42_age.render(guiGraphics, mouseX, mouseY, partialTicks);
		E42_Origine.render(guiGraphics, mouseX, mouseY, partialTicks);
		if (ScreenPlayerProcedure.execute(entity) instanceof LivingEntity livingEntity) {
			InventoryScreen.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + 29, this.topPos + 91, 30, 0f, 0, livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (E42_Prenom.isFocused())
			return E42_Prenom.keyPressed(key, b, c);
		if (E42_Nom.isFocused())
			return E42_Nom.keyPressed(key, b, c);
		if (E42_age.isFocused())
			return E42_age.keyPressed(key, b, c);
		if (E42_Origine.isFocused())
			return E42_Origine.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		E42_Prenom.tick();
		E42_Nom.tick();
		E42_age.tick();
		E42_Origine.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.register_c.label_formulaire_denregistrement_e42"), 45, 6, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.register_c.label_nom"), 74, 27, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.register_c.label_prenom"), 59, 51, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.register_c.label_origines"), 46, 100, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.register_c.label_age"), 72, 75, -16777216, false);
		guiGraphics.drawString(this.font,

				GetServerIDProcedure.execute(entity), 19, 129, -16777216, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		E42_Prenom = new EditBox(this.font, this.leftPos + 100, this.topPos + 52, 118, 18, Component.translatable("gui.elyrasir.register_c.E42_Prenom"));
		E42_Prenom.setMaxLength(32767);
		guistate.put("text:E42_Prenom", E42_Prenom);
		this.addWidget(this.E42_Prenom);
		E42_Nom = new EditBox(this.font, this.leftPos + 100, this.topPos + 27, 118, 18, Component.translatable("gui.elyrasir.register_c.E42_Nom"));
		E42_Nom.setMaxLength(32767);
		guistate.put("text:E42_Nom", E42_Nom);
		this.addWidget(this.E42_Nom);
		E42_age = new EditBox(this.font, this.leftPos + 99, this.topPos + 76, 118, 18, Component.translatable("gui.elyrasir.register_c.E42_age"));
		E42_age.setMaxLength(32767);
		guistate.put("text:E42_age", E42_age);
		this.addWidget(this.E42_age);
		E42_Origine = new EditBox(this.font, this.leftPos + 100, this.topPos + 99, 118, 18, Component.translatable("gui.elyrasir.register_c.E42_Origine"));
		E42_Origine.setMaxLength(32767);
		guistate.put("text:E42_Origine", E42_Origine);
		this.addWidget(this.E42_Origine);
		button_valider = Button.builder(Component.translatable("gui.elyrasir.register_c.button_valider"), e -> {
			if (true) {
				ElyrasirMod.PACKET_HANDLER.sendToServer(new RegisterCButtonMessage(0, x, y, z));
				RegisterCButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 85, this.topPos + 197, 61, 20).build();
		guistate.put("button:button_valider", button_valider);
		this.addRenderableWidget(button_valider);
	}
}
