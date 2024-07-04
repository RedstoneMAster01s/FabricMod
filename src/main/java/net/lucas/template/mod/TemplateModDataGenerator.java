package net.lucas.template.mod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.lucas.template.datagen.*;

public class TemplateModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProviter::new);
		pack.addProvider(ModItemTagProviter::new);
		pack.addProvider(ModLootTableProviter::new);
		pack.addProvider(ModModelProviter::new);
		pack.addProvider(ModRecipeProviter::new);

	}
}
