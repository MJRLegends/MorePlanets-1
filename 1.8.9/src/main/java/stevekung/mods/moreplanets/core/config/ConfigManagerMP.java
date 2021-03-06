package stevekung.mods.moreplanets.core.config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.util.StatCollector;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.config.IConfigElement;
import stevekung.mods.moreplanets.util.MPLog;

public class ConfigManagerMP
{
    private static Configuration config;
    public static String GENERAL = "configgeneralguimp";
    public static String DIMENSIONS = "configdimensionguimp";
    public static String BIOMES = "configbiomeguimp";
    public static String OTHERS = "configotherguimp";

    // General
    public static String startedPlanet;
    public static boolean enableDebug;
    public static boolean enableVersionChecker;
    public static boolean enableChangeLogInGame;
    public static boolean enableNightVisionEffect;
    public static boolean enableBlackHoleExplosion;
    public static boolean enableStartedPlanet;
    public static boolean use3DTorchItemModel;
    public static int idNetworkHandler;

    // Dimensions
    public static int idDimensionDiona;
    public static int idDimensionChalos;
    public static int idDimensionNibiru;
    public static int idDimensionFronos;

    // Biomes
    public static int idBiomeDiona;
    public static int idBiomeChalosPlains;
    public static int idBiomeChalosHills;
    public static int idBiomeSlimelyWasteland;
    public static int idBiomeInfectedPlains;
    public static int idBiomeInfectedForest;
    public static int idBiomeInfectedDesert;
    public static int idBiomeInfectedRiver;
    public static int idBiomeInfectedOcean;
    public static int idBiomeInfectedDeepOcean;
    public static int idBiomeInfectedDeadTaiga;
    public static int idBiomeInfectedSwampland;
    public static int idBiomeInfectedExtremeHills;
    public static int idBiomeInfectedDeadRoofedForest;
    public static int idBiomeInfectedJungle;
    public static int idBiomeInfectedDeadSavanna;
    public static int idBiomeInfectedIcePlains;
    public static int idBiomeGreenVein;

    // Others
    public static int idBaseRocketSchematic;
    public static int idBaseSchematic;
    public static int idBaseRocketSchematicGui;
    public static int idBaseSchematicGui;

    public static void init(File file)
    {
        ConfigManagerMP.config = new Configuration(file);
        ConfigManagerMP.syncConfig(true);
    }

    public static void syncConfig(boolean load)
    {
        try
        {
            if (!ConfigManagerMP.config.isChild)
            {
                if (load)
                {
                    ConfigManagerMP.config.load();
                }
            }

            ConfigManagerMP.config.setCategoryPropertyOrder(ConfigManagerMP.GENERAL, ConfigManagerMP.addGeneralConfig());
            ConfigManagerMP.config.setCategoryPropertyOrder(ConfigManagerMP.DIMENSIONS, ConfigManagerMP.addDimensionIDConfig());
            ConfigManagerMP.config.setCategoryPropertyOrder(ConfigManagerMP.BIOMES, ConfigManagerMP.addBiomeIDConfig());
            ConfigManagerMP.config.setCategoryPropertyOrder(ConfigManagerMP.OTHERS, ConfigManagerMP.addOtherConfig());

            if (ConfigManagerMP.config.hasChanged())
            {
                ConfigManagerMP.config.save();
            }
        }
        catch (Exception e)
        {
            MPLog.error("More Planets has a problem loading it's configuration");
        }
    }

    private static ArrayList<String> addGeneralConfig()
    {
        ArrayList<String> propOrder = Lists.newArrayList();
        Property prop;
        prop = ConfigManagerMP.config.get(ConfigManagerMP.GENERAL, "Planet to Start", "planet.");
        prop.comment = "Put planet name that you would like to spawn (Also you need to enable started planet in the config). For example \"planet.nibiru\", \"moon.moon\", \"satellite.spacestation.overworld\" ";
        ConfigManagerMP.startedPlanet = prop.getString();
        propOrder.add(prop.getName());

        prop = ConfigManagerMP.config.get(ConfigManagerMP.GENERAL, "Enable Started Planet", false);
        ConfigManagerMP.enableStartedPlanet = prop.getBoolean();
        propOrder.add(prop.getName());

        prop = ConfigManagerMP.config.get(ConfigManagerMP.GENERAL, "Enable Night Vision Effect while boss fight", false);
        ConfigManagerMP.enableNightVisionEffect = prop.getBoolean();
        propOrder.add(prop.getName());

        prop = ConfigManagerMP.config.get(ConfigManagerMP.GENERAL, "Enable Black Hole Explosion", true);
        ConfigManagerMP.enableBlackHoleExplosion = prop.getBoolean();
        propOrder.add(prop.getName());

        prop = ConfigManagerMP.config.get(ConfigManagerMP.GENERAL, "Use 3D Item Model for Torch", true);
        prop.setRequiresMcRestart(true);
        ConfigManagerMP.use3DTorchItemModel = prop.getBoolean();
        propOrder.add(prop.getName());

        prop = ConfigManagerMP.config.get(ConfigManagerMP.GENERAL, "Enable Debug Logging", false);
        ConfigManagerMP.enableDebug = prop.getBoolean();
        propOrder.add(prop.getName());

        prop = ConfigManagerMP.config.get(ConfigManagerMP.GENERAL, "Enable Version Checker", true);
        prop.setRequiresMcRestart(true);
        ConfigManagerMP.enableVersionChecker = prop.getBoolean();
        propOrder.add(prop.getName());

        prop = ConfigManagerMP.config.get(ConfigManagerMP.GENERAL, "Enable Change Log in Game", true);
        ConfigManagerMP.enableChangeLogInGame = prop.getBoolean();
        propOrder.add(prop.getName());

        prop = ConfigManagerMP.config.get(ConfigManagerMP.GENERAL, "Network Handler ID", 2542);
        prop.setRequiresMcRestart(true);
        ConfigManagerMP.idNetworkHandler = prop.getInt();
        propOrder.add(prop.getName());
        return propOrder;
    }

    private static ArrayList<String> addDimensionIDConfig()
    {
        ArrayList<String> propOrder = Lists.newArrayList();
        Property prop;
        prop = ConfigManagerMP.config.get(ConfigManagerMP.DIMENSIONS, "Diona Dimension ID", -2542);
        prop.setRequiresMcRestart(true);
        ConfigManagerMP.idDimensionDiona = prop.getInt();
        propOrder.add(prop.getName());

        prop = ConfigManagerMP.config.get(ConfigManagerMP.DIMENSIONS, "Chalos Dimension ID", -2543);
        prop.setRequiresMcRestart(true);
        ConfigManagerMP.idDimensionChalos = prop.getInt();
        propOrder.add(prop.getName());

        prop = ConfigManagerMP.config.get(ConfigManagerMP.DIMENSIONS, "Nibiru Dimension ID", -2544);
        prop.setRequiresMcRestart(true);
        ConfigManagerMP.idDimensionNibiru = prop.getInt();
        propOrder.add(prop.getName());

        prop = ConfigManagerMP.config.get(ConfigManagerMP.DIMENSIONS, "Fronos Dimension ID", -2545);
        prop.setRequiresMcRestart(true);
        ConfigManagerMP.idDimensionFronos = prop.getInt();
        propOrder.add(prop.getName());
        return propOrder;
    }

    private static ArrayList<String> addBiomeIDConfig()
    {
        ArrayList<String> propOrder = Lists.newArrayList();
        Property prop;
        prop = ConfigManagerMP.config.get(ConfigManagerMP.BIOMES, "Diona Biome ID", 180);
        prop.setRequiresMcRestart(true);
        ConfigManagerMP.idBiomeDiona = prop.getInt();
        propOrder.add(prop.getName());

        prop = ConfigManagerMP.config.get(ConfigManagerMP.BIOMES, "Chalos Plains Biome ID", 181);
        prop.setRequiresMcRestart(true);
        ConfigManagerMP.idBiomeChalosPlains = prop.getInt();
        propOrder.add(prop.getName());

        prop = ConfigManagerMP.config.get(ConfigManagerMP.BIOMES, "Chalos Hills Biome ID", 182);
        prop.setRequiresMcRestart(true);
        ConfigManagerMP.idBiomeChalosHills = prop.getInt();
        propOrder.add(prop.getName());

        prop = ConfigManagerMP.config.get(ConfigManagerMP.BIOMES, "Slimely Wasteland Biome ID", 183);
        prop.setRequiresMcRestart(true);
        ConfigManagerMP.idBiomeSlimelyWasteland = prop.getInt();
        propOrder.add(prop.getName());

        prop = ConfigManagerMP.config.get(ConfigManagerMP.BIOMES, "Infected Plains Biome ID", 184);
        prop.setRequiresMcRestart(true);
        ConfigManagerMP.idBiomeInfectedPlains = prop.getInt();
        propOrder.add(prop.getName());

        prop = ConfigManagerMP.config.get(ConfigManagerMP.BIOMES, "Infected Forest Biome ID", 185);
        prop.setRequiresMcRestart(true);
        ConfigManagerMP.idBiomeInfectedForest = prop.getInt();
        propOrder.add(prop.getName());

        prop = ConfigManagerMP.config.get(ConfigManagerMP.BIOMES, "Infected Desert Biome ID", 186);
        prop.setRequiresMcRestart(true);
        ConfigManagerMP.idBiomeInfectedDesert = prop.getInt();
        propOrder.add(prop.getName());

        prop = ConfigManagerMP.config.get(ConfigManagerMP.BIOMES, "Infected River Biome ID", 187);
        prop.setRequiresMcRestart(true);
        ConfigManagerMP.idBiomeInfectedRiver = prop.getInt();
        propOrder.add(prop.getName());

        prop = ConfigManagerMP.config.get(ConfigManagerMP.BIOMES, "Infected Ocean Biome ID", 188);
        prop.setRequiresMcRestart(true);
        ConfigManagerMP.idBiomeInfectedOcean = prop.getInt();
        propOrder.add(prop.getName());

        prop = ConfigManagerMP.config.get(ConfigManagerMP.BIOMES, "Infected Deep Ocean Biome ID", 189);
        prop.setRequiresMcRestart(true);
        ConfigManagerMP.idBiomeInfectedDeepOcean = prop.getInt();
        propOrder.add(prop.getName());

        prop = ConfigManagerMP.config.get(ConfigManagerMP.BIOMES, "Infected Dead Taiga Biome ID", 190);
        prop.setRequiresMcRestart(true);
        ConfigManagerMP.idBiomeInfectedDeadTaiga = prop.getInt();
        propOrder.add(prop.getName());

        prop = ConfigManagerMP.config.get(ConfigManagerMP.BIOMES, "Infected Swampland Biome ID", 191);
        prop.setRequiresMcRestart(true);
        ConfigManagerMP.idBiomeInfectedSwampland = prop.getInt();
        propOrder.add(prop.getName());

        prop = ConfigManagerMP.config.get(ConfigManagerMP.BIOMES, "Infected Extreme Hills Biome ID", 192);
        prop.setRequiresMcRestart(true);
        ConfigManagerMP.idBiomeInfectedExtremeHills = prop.getInt();
        propOrder.add(prop.getName());

        prop = ConfigManagerMP.config.get(ConfigManagerMP.BIOMES, "Infected Dead Roofed Forest Biome ID", 193);
        prop.setRequiresMcRestart(true);
        ConfigManagerMP.idBiomeInfectedDeadRoofedForest = prop.getInt();
        propOrder.add(prop.getName());

        prop = ConfigManagerMP.config.get(ConfigManagerMP.BIOMES, "Infected Jungle Biome ID", 194);
        prop.setRequiresMcRestart(true);
        ConfigManagerMP.idBiomeInfectedJungle = prop.getInt();
        propOrder.add(prop.getName());

        prop = ConfigManagerMP.config.get(ConfigManagerMP.BIOMES, "Infected Dead Savanna Biome ID", 195);
        prop.setRequiresMcRestart(true);
        ConfigManagerMP.idBiomeInfectedDeadSavanna = prop.getInt();
        propOrder.add(prop.getName());

        prop = ConfigManagerMP.config.get(ConfigManagerMP.BIOMES, "Infected Ice Plains Biome ID", 196);
        prop.setRequiresMcRestart(true);
        ConfigManagerMP.idBiomeInfectedIcePlains = prop.getInt();
        propOrder.add(prop.getName());

        prop = ConfigManagerMP.config.get(ConfigManagerMP.BIOMES, "Green Vein Biome ID", 197);
        prop.setRequiresMcRestart(true);
        ConfigManagerMP.idBiomeGreenVein = prop.getInt();
        propOrder.add(prop.getName());
        return propOrder;
    }

    private static ArrayList<String> addOtherConfig()
    {
        ArrayList<String> propOrder = Lists.newArrayList();
        Property prop;
        prop = ConfigManagerMP.config.get(ConfigManagerMP.OTHERS, "Tier 4 Rocket Schematic ID", 800);
        ConfigManagerMP.idBaseRocketSchematic = prop.getInt();
        propOrder.add(prop.getName());

        prop = ConfigManagerMP.config.get(ConfigManagerMP.OTHERS, "Base Schematic ID", 850);
        ConfigManagerMP.idBaseSchematic = prop.getInt();
        propOrder.add(prop.getName());

        prop = ConfigManagerMP.config.get(ConfigManagerMP.OTHERS, "Tier 4 Rocket Schematic GUI ID", 500);
        ConfigManagerMP.idBaseRocketSchematicGui = prop.getInt();
        propOrder.add(prop.getName());

        prop = ConfigManagerMP.config.get(ConfigManagerMP.OTHERS, "Base Schematic GUI ID", 550);
        ConfigManagerMP.idBaseSchematicGui = prop.getInt();
        propOrder.add(prop.getName());
        return propOrder;
    }

    public static List<IConfigElement> getConfigElements()
    {
        List<IConfigElement> list = Lists.newArrayList();
        ConfigCategory configGeneral = ConfigManagerMP.config.getCategory(ConfigManagerMP.GENERAL);
        configGeneral.setComment(StatCollector.translateToLocal("gui.config.mp.general"));
        list.add(new ConfigElement(configGeneral));

        ConfigCategory configDimension = ConfigManagerMP.config.getCategory(ConfigManagerMP.DIMENSIONS);
        configDimension.setComment(StatCollector.translateToLocal("gui.config.mp.dimension"));
        list.add(new ConfigElement(configDimension));

        ConfigCategory configBiome = ConfigManagerMP.config.getCategory(ConfigManagerMP.BIOMES);
        configBiome.setComment(StatCollector.translateToLocal("gui.config.mp.biome"));
        list.add(new ConfigElement(configBiome));

        ConfigCategory configSchematic = ConfigManagerMP.config.getCategory(ConfigManagerMP.OTHERS);
        configSchematic.setComment(StatCollector.translateToLocal("gui.config.mp.schematic"));
        list.add(new ConfigElement(configSchematic));

        ConfigCategory configGUIs = ConfigManagerMP.config.getCategory(ConfigManagerMP.OTHERS);
        configGUIs.setComment(StatCollector.translateToLocal("gui.config.mp.other"));
        list.add(new ConfigElement(configGUIs));
        return list;
    }
}