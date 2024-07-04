package net.lucas.template.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent Tomato = new FoodComponent.Builder().nutrition(5).saturationModifier(0.25f).statusEffect(new StatusEffectInstance(StatusEffects.INFESTED, 200, 255), 0.5f).alwaysEdible().build();

}
