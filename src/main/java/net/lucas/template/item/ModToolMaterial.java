package net.lucas.template.item;

import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {
    RUBY(ModTags.Blocks.INCORRECT_FOR_RUBY_TOOL, 5, 650, 100f, 50f, 100, () -> Ingredient.ofItems(ModItems.RUBY) );

    private final TagKey<Block> inverseTag;
    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> RepareIngredient ;

    ModToolMaterial(final TagKey inverseTag, int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repareIngredient) {
        this.inverseTag = inverseTag;
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        RepareIngredient = repareIngredient;
    }


    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.RepareIngredient.get();
    }
}