package net.mavity.mod_name_goes_here.soundregister;

import net.mavity.mod_name_goes_here.ModNameGoesHere;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class SoundInit {

    public static final SoundEvent MAVITYS_RANDOM_ONE = register("mavitys_random_one");

    static SoundEvent register(String id) {
        SoundEvent sound = SoundEvent.of(new Identifier(ModNameGoesHere.MOD_ID, id));
        return Registry.register(Registries.SOUND_EVENT, new Identifier(ModNameGoesHere.MOD_ID, id), sound);
    }

    public static void registerMNGHSounds() {
        ModNameGoesHere.LOGGER.info(ModNameGoesHere.NAME + " has registered its' sounds.");
    }

}
