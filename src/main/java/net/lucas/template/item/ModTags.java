package net.lucas.template.item;
import net.minecraft.block.Block;
import net.lucas.template.mod.TemplateMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> INCORRECT_FOR_RUBY_TOOL = createTag("incorrect_for_ruby_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(Registries.BLOCK.getKey(), Identifier.of(TemplateMod.MOD_ID, name));
            }
    }
}
