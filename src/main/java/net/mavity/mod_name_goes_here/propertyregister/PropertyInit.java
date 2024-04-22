package net.mavity.mod_name_goes_here.propertyregister;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import net.mavity.mod_name_goes_here.ModNameGoesHere;

public class PropertyInit {
    public static final FabricItemSettings RUPEE_TYPE = new FabricItemSettings().maxCount(64).fireproof();
    public static final FabricItemSettings GENERIC_TYPE = new FabricItemSettings().maxCount(64).fireproof();
    public static final FabricItemSettings GENERIC_TYPE_ONESTACK = new FabricItemSettings().fireproof().maxDamage(0);
    public static void registerMNGHProperties() {
        ModNameGoesHere.LOGGER.info(ModNameGoesHere.MOD_ID + " has registered its' properties.");
    }
}
