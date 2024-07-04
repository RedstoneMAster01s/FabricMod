package net.lucas.template.block;

import net.lucas.template.block.custom.DiceBlock;
import net.lucas.template.block.custom.SoundBlock;
import net.lucas.template.mod.TemplateMod;
import net.lucas.template.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            new Block(Block.Settings.copy(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block DICE_BLOCK = Registry.register(Registries.BLOCK, Identifier.of(TemplateMod.MOD_ID, "dice_block"),
            new DiceBlock(Block.Settings.copy(Blocks.STONE)));
    public static final Block SOUND_BLOCK = registerBlock("sound_block",
            new SoundBlock(Block.Settings.copy(Blocks.IRON_BLOCK).sounds(ModSounds.SOUND_BLOCK_SOUNDS)));

    public static final Block RAW_RUBY_BLOCK = registerBlock("raw_ruby_block",
            new Block(Block.Settings.copy(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RUBY_ORE = registerBlock("ruby_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), Block.Settings.copy(Blocks.STONE).strength(2f)));

    public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), Block.Settings.copy(Blocks.DEEPSLATE).strength(4f)));

    public static final Block NETHER_RUBY_ORE = registerBlock("nether_ruby_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), Block.Settings.copy(Blocks.NETHERRACK).strength(1.5f)));

    public static final Block END_STONE_RUBY_ORE = registerBlock("end_stone_ruby_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4, 7), Block.Settings.copy(Blocks.END_STONE).strength(4f)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TemplateMod.MOD_ID, name),block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(TemplateMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void RegisterModBlocks() {
        TemplateMod.LOGGER.info("Registering ModBlocks For "+TemplateMod.MOD_ID);
    }
}
