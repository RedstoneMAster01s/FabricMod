package net.lucas.template.item.custom;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

import net.lucas.template.item.ModItems;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class ModArmorMaterel {
    public static final RegistryEntry<ArmorMaterial> RUBY = register(
            "ruby",
            Util.make(new EnumMap(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 100);
                map.put(ArmorItem.Type.LEGGINGS, 100);
                map.put(ArmorItem.Type.CHESTPLATE, 100);
                map.put(ArmorItem.Type.HELMET, 100);
                map.put(ArmorItem.Type.BODY, 100);
            }),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,
            1.0F,
            1.0F,
            () -> Ingredient.ofItems(ModItems.RUBY),
            List.of(new ArmorMaterial.Layer(Identifier.ofVanilla("ruby"), "", false), new ArmorMaterial.Layer(Identifier.ofVanilla("ruby"), "_overlay", false))
    );
    private static RegistryEntry<ArmorMaterial> register(
            String id,
            EnumMap<ArmorItem.Type, Integer> defense,
            int enchantability,
            RegistryEntry<SoundEvent> equipSound,
            float toughness,
            float knockbackResistance,
            Supplier<Ingredient> repairIngredient
    ) {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(Identifier.ofVanilla(id)));
        return register(id, defense, enchantability, equipSound, toughness, knockbackResistance, repairIngredient, list);
    }

    private static RegistryEntry<ArmorMaterial> register(
            String id,
            EnumMap<ArmorItem.Type, Integer> defense,
            int enchantability,
            RegistryEntry<SoundEvent> equipSound,
            float toughness,
            float knockbackResistance,
            Supplier<Ingredient> repairIngredient,
            List<ArmorMaterial.Layer> layers
    ) {
        EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap(ArmorItem.Type.class);

        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            enumMap.put(type, (Integer)defense.get(type));
        }

        return Registry.registerReference(
                Registries.ARMOR_MATERIAL,
                Identifier.ofVanilla(id),
                new ArmorMaterial(enumMap, enchantability, equipSound, repairIngredient, layers, toughness, knockbackResistance)
        );
    }
}
