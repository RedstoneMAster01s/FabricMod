package net.lucas.template.mod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.lucas.template.block.ModBlocks;
import net.lucas.template.entity.ModEntities;
import net.lucas.template.entity.custom.PorcupineEntity;
import net.lucas.template.item.ModItems;
import net.lucas.template.item.ModItemGroups;
import net.lucas.template.sound.ModSounds;
import net.lucas.template.util.ModCustomTrades;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TemplateMod implements ModInitializer {
	public static final String MOD_ID = "templatemod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.RegisterModBlocks();
		ModItemGroups.registerItemGroups();
		ModCustomTrades.registerTrades();
		ModSounds.registerSounds();
		ModItems.registerModItems();
		FabricDefaultAttributeRegistry.register(ModEntities.PORCUPINE, PorcupineEntity.createPorcupineAttributes());


		
		FuelRegistry.INSTANCE.add(ModItems.BAD_FUEL, 3);
	}
}
