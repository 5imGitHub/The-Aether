package com.aetherteam.aether.client;

import com.aetherteam.aether.Aether;
import com.aetherteam.aether.block.AetherWoodTypes;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = Aether.MODID, value = Dist.CLIENT, bus = Bus.MOD)
public class AetherAtlases {
	public static Material TREASURE_CHEST_MATERIAL;
	public static Material TREASURE_CHEST_LEFT_MATERIAL;
	public static Material TREASURE_CHEST_RIGHT_MATERIAL;

	public static void registerTreasureChestAtlases() {
		TREASURE_CHEST_MATERIAL = getChestMaterial("treasure_chest");
		TREASURE_CHEST_LEFT_MATERIAL = getChestMaterial("treasure_chest_left");
		TREASURE_CHEST_RIGHT_MATERIAL = getChestMaterial("treasure_chest_right");
	}

	public static void registerWoodTypeAtlases() {
		Sheets.addWoodType(AetherWoodTypes.SKYROOT);
	}

	public static Material getChestMaterial(String chestName) {
		return new Material(Sheets.CHEST_SHEET, new ResourceLocation(Aether.MODID, "entity/tiles/chest/" + chestName));
	}
}
