package net.lucas.template.entity.client;

import net.lucas.template.mod.TemplateMod;
import net.lucas.template.mod.TemplateMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer PORCUPINE =
            new EntityModelLayer(Identifier.of(TemplateMod.MOD_ID, "porcupine"), "main");
}
