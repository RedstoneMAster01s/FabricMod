package net.lucas.template.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.lucas.template.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

public class ModCustomTrades {
    public static void registerTrades() {
        TradeOfferHelper.registerVillagerOffers(
                VillagerProfession.WEAPONSMITH,
                1, factories -> {
                    factories.add((entity, random) -> (
                        new TradeOffer(new TradedItem(Items.EMERALD, 2),
                                new ItemStack(ModItems.RUBY, 1),
                                15, 5, 0.50f)
                    ));
                });
        TradeOfferHelper.registerVillagerOffers(
                VillagerProfession.FARMER,
                1, factories -> {
                    factories.add((entity, random) -> (
                            new TradeOffer(new TradedItem(Items.EMERALD, 20),
                                    new ItemStack(ModItems.RUBY, 100),
                                    100, 50, 1f)
                    ));
                });
        TradeOfferHelper.registerWanderingTraderOffers(
                1, factories -> {
                    factories.add((entity, random) -> (
                            new TradeOffer(new TradedItem(Items.EMERALD, 20),
                                    new ItemStack(ModItems.METEL_DETECTOR, 1),
                                    5, 50, 3f)
                    ));
                });
        TradeOfferHelper.registerWanderingTraderOffers(
                2, factories -> {
                    factories.add((entity, random) -> (
                            new TradeOffer(new TradedItem(Items.EMERALD, 1),
                                    new ItemStack(ModItems.METEL_DETECTOR, 1),
                                    5, 100, 10f)
                    ));
                });
    }
}
