package net.mavity.mod_name_goes_here.configregister;

import com.google.common.collect.Lists;

import eu.midnightdust.lib.config.MidnightConfig;

import java.util.List;

public class ModNameGoesHereConfigMidnightLib extends MidnightConfig {
    @Comment(category = "settings", centered = true) public static Comment comment_1; // Comments are rendered like an option without a button and are excluded from the config file
    @Entry(category = "settings") public static boolean showInfo = true; // Example for a boolean option
    @Entry(category = "settings") public static String name = "WiiU";
    @Entry(category = "settings") public static Style style = Style.Fancy;
    public enum Style {
        Ew, Fancy, Fabulous, Posh
    }
    @Entry(category = "examples") public static int fabric = 16777215; // Example for an int option
    @Entry(category = "examples") public static double world = 1.4D; // Example for a double option
    @Entry(category = "examples", min=69, max=420) public static int hello = 420; // - The entered number has to be larger than 69 and smaller than 420
    @Entry(category = "examples", width = 7, min = 7, isColor = true, name = "I am a color!") public static String titleColor = "#ffffff"; // The isColor property adds a preview box for a hexadecimal color
    @Entry(category = "examples", name = "I am an array list!") public static List<String> arrayList = Lists.newArrayList("String1", "String2"); // Array String Lists are also supported
    @Entry(category = "examples", name = "I am an int slider.", isSlider = true, min = 0, max = 100) public static int intSlider = 35; // Int fields can also be displayed as a Slider
    @Entry(category = "examples", name = "I am a float slider!", isSlider = true, min = 0f, max = 1f, precision = 1000) public static float floatSlider = 0.24f; // And so can floats! Precision defines the amount of decimal places
    // The name field can be used to specify a custom translation string or plain text
}
