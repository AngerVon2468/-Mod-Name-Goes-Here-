package net.mavity.mod_name_goes_here;

import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;

import net.fabricmc.api.ClientModInitializer;

import net.mavity.mod_name_goes_here.itemregister.ItemInit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModNameGoesHereClient implements ClientModInitializer {
    public static final String NAME = "<Mod Name Goes Here Client>";
    public static final Logger LOGGER = LoggerFactory.getLogger(ModNameGoesHereClient.NAME);
    @Override
    public void onInitializeClient() {

        // Logger
        ModNameGoesHereClient.LOGGER.info(ModNameGoesHereClient.NAME + " has registered its' client class");

        // Trinket Renderer
        TrinketRendererRegistry.registerRenderer(ItemInit.MAJORAS_MASK, (TrinketRenderer) ItemInit.MAJORAS_MASK);
    }
}
