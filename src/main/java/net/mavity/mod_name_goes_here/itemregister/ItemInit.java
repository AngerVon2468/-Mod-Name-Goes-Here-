package net.mavity.mod_name_goes_here.itemregister;

import net.mavity.mod_name_goes_here.ModNameGoesHere;
import net.mavity.mod_name_goes_here.itemregister.itemtypes.trinkets.MMTrinket;
import net.mavity.mod_name_goes_here.propertyregister.PropertyInit;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemInit {
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(ModNameGoesHere.MOD_ID, name), item);
    }

    // Majora's Mask
    public static final Item MAJORAS_MASK = registerItem("majoras_mask", new MMTrinket(PropertyInit.GENERIC_TYPE_ONESTACK));

    public static void registerMNGHItems() {
        ModNameGoesHere.LOGGER.info(ModNameGoesHere.NAME + " has registered its' items.");
    }

}
