package net.mavity.mod_name_goes_here.configregister;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import net.mavity.mod_name_goes_here.ModNameGoesHere;

@Config(name = ModNameGoesHere.MOD_ID)
public class ConfigInit implements ConfigData {
    public boolean isAoTS4P2Good = true;
}
