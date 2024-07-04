package net.lucas.template.entity.custom;

import net.lucas.template.block.ModBlocks;
import net.lucas.template.block.custom.DiceBlock;
import net.lucas.template.entity.ModEntities;
import net.lucas.template.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntityAttributesS2CPacket;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.server.network.EntityTrackerEntry;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

public class DisePrjektileEntity extends ThrownItemEntity {
    public DisePrjektileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }
    public DisePrjektileEntity(LivingEntity entity, World world) {
        super(ModEntities.DISE_PRJEKTILE_ENTITY, entity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.DICE;
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket(EntityTrackerEntry entityTrackerEntry) {
        return new EntitySpawnS2CPacket(this, entityTrackerEntry);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        if(!this.getWorld().isClient()) {
            this.getWorld().sendEntityStatus(this, (byte)3);
            this.getWorld().setBlockState(getBlockPos(), ((DiceBlock) ModBlocks.DICE_BLOCK).getRandomBlockState(), 3);

        }
        this.discard();
        super.onBlockHit(blockHitResult);
    }
}
