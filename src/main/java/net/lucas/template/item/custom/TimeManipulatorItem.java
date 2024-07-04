package net.lucas.template.item.custom;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class TimeManipulatorItem extends Item {
    public TimeManipulatorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();

        if (!world.isClient && player != null) {
            if (player.isSneaking()) {
                // Fast-forward time by 400 ticks (20 seconds)
                ServerCommandSource ServerCommandSource = player.getCommandSource();
                executeSprint(ServerCommandSource, 400);
            } else {
                // Fast-forward time by 1000 ticks (50 seconds)
                ServerCommandSource ServerCommandSource = player.getCommandSource();
                executeSprint(ServerCommandSource, 1000);
            }
            PlayerEntity PlayerEntity = player;
            ItemHit(PlayerEntity, context);
            player.getItemCooldownManager().set(this, 200); // Cooldown of 10 seconds
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }
    private static int executeSprint(ServerCommandSource source, int ticks) {
        boolean bl = source.getServer().getTickManager().startSprint(ticks);
        if (bl) {
            source.sendFeedback(() -> Text.translatable("commands.tick.sprint.stop.success"), true);
        }

        source.sendFeedback(() -> Text.translatable("commands.tick.status.sprinting"), true);
        return 1;
    }

    public static void ItemHit(PlayerEntity player, ItemUsageContext context) {
        context.getStack().damage(1, player, PlayerEntity.getSlotForHand(Hand.MAIN_HAND));
    }
}