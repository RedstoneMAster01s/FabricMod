package net.lucas.template.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lucas.template.entity.ModEntities;
import net.lucas.template.item.custom.DiceItem;
import net.lucas.template.item.custom.MetelDetectorItem;
import net.lucas.template.item.custom.ModArmorMaterel;
import net.lucas.template.item.custom.TimeManipulatorItem;
import net.lucas.template.mod.TemplateMod;
import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;


public class ModItems {

    public static final Item RUBY_CHESTPLATE = registerItem(
            "ruby_chestplate",
            new ArmorItem(ModArmorMaterel.RUBY, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(1500)))
    );
    public static final Item RUBY_BOOTS = registerItem(
            "ruby_boots",
            new ArmorItem(ModArmorMaterel.RUBY, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(1500)))
    );
    public static final Item RUBY_HELMET = registerItem(
            "ruby_helmet",
            new ArmorItem(ModArmorMaterel.RUBY, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(1500)))
    );
    public static final Item RUBY_LEGGINGS = registerItem(
            "ruby_leggings",
            new ArmorItem(ModArmorMaterel.RUBY, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(1500)))
    );
    public static final Item RUBY = registerItem("ruby",
            new Item(new Item.Settings()));

    public static final Item RAW_RUBY = registerItem("raw_ruby",
            new Item(new Item.Settings()));

    public static final Item METEL_DETECTOR = registerItem("metel_detector",
            new MetelDetectorItem(new Item.Settings().maxDamage(64).maxCount(1)));

    public static final Item TimeManipulatorItem = registerItem("TimeManipulator",
            new TimeManipulatorItem(new Item.Settings().maxDamage(64).maxCount(1)));

    public static final Item DICE = registerItem("dice",
            new DiceItem(new Item.Settings()));

    public static final Item TOMATO = registerItem("tomato",
            new Item(new Item.Settings().food(ModFoodComponents.Tomato)));

    public static final Item PORCUPINE_SPAWN_EGG = registerItem("porcupine_spawn_egg",
            new SpawnEggItem(ModEntities.PORCUPINE, 0xa86518, 0x3b260f, new Item.Settings()));


    public static final Item BAD_FUEL = registerItem("bad_fuel",
            new Item(new Item.Settings()));

    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe",
            new PickaxeItem(ModToolMaterial.RUBY, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterial.RUBY, 4, -2.25F))));

    public static final Item RUBY_AXE = registerItem("ruby_axe",
            new AxeItem(ModToolMaterial.RUBY, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterial.RUBY, 4, -2.25F))));

    public static final Item RUBY_SHOVEL = registerItem("ruby_shovel",
            new ShovelItem(ModToolMaterial.RUBY, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterial.RUBY, 4, -2.25F))));
    public static final Item RUBY_SWORD = registerItem("ruby_sword",
            new SwordItem(ModToolMaterial.RUBY, (new Item.Settings())
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterial.RUBY, 4, -2.25F))));

    public static final Item RUBY_HOE = registerItem("ruby_hoe",
            new HoeItem(ModToolMaterial.RUBY, (new Item.Settings())
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterial.RUBY, 4, -2.25F))));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(RUBY);
        entries.add(RAW_RUBY);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TemplateMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TemplateMod.LOGGER.info("Registering Mod Items for " + TemplateMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}