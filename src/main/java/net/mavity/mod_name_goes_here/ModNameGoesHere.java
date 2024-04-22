package net.mavity.mod_name_goes_here;

import eu.midnightdust.lib.config.MidnightConfig;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;

import net.fabricmc.api.ModInitializer;

import net.mavity.mod_name_goes_here.configregister.ConfigInit;
import net.mavity.mod_name_goes_here.configregister.ModNameGoesHereConfigMidnightLib;
import net.mavity.mod_name_goes_here.itemregister.ItemInit;
import net.mavity.mod_name_goes_here.propertyregister.PropertyInit;
import net.mavity.mod_name_goes_here.soundregister.SoundInit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModNameGoesHere implements ModInitializer {
	public static final String MOD_ID = "mod_name_goes_here";
	public static final String NAME = "<Mod Name Goes Here>";
    public static final Logger LOGGER = LoggerFactory.getLogger(ModNameGoesHere.NAME);

	//CONFIG
	public static final ConfigHolder<ConfigInit> CONFIG = AutoConfig.register(
			ConfigInit.class, Toml4jConfigSerializer::new);

	@Override
	public void onInitialize() {

		// Logger & initializing class
		ModNameGoesHere.LOGGER.info(ModNameGoesHere.NAME + " has registered its' main class.");
		ItemInit.registerMNGHItems();
		SoundInit.registerMNGHSounds();
		PropertyInit.registerMNGHProperties();

		// Config
		AutoConfig.getConfigHolder(ConfigInit.class).getConfig();
		CONFIG.load();

		// MidnightLib Config (based)
		MidnightConfig.init(ModNameGoesHere.MOD_ID, ModNameGoesHereConfigMidnightLib.class);
	}
}