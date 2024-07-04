package net.lucas.template.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.lucas.template.entity.custom.DisePrjektileEntity;
import net.lucas.template.entity.custom.PorcupineEntity;
import net.lucas.template.mod.TemplateMod;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<PorcupineEntity> PORCUPINE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(TemplateMod.MOD_ID, "porcupine"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PorcupineEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 1f)).build());


    public static final EntityType<DisePrjektileEntity> DISE_PRJEKTILE_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(TemplateMod.MOD_ID, "dice_projectile"),
            FabricEntityTypeBuilder.<DisePrjektileEntity>create(SpawnGroup.MISC, DisePrjektileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

}
