package stevekung.mods.moreplanets.init;

import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import stevekung.mods.moreplanets.entity.EntityBlackHole;
import stevekung.mods.moreplanets.entity.EntityBlackHoleStorage;
import stevekung.mods.moreplanets.entity.EntitySpaceCapsule;
import stevekung.mods.moreplanets.entity.EntitySpaceMinecartChest;
import stevekung.mods.moreplanets.entity.projectile.EntityLaserBullet;
import stevekung.mods.moreplanets.entity.projectile.EntitySpaceFishHook;
import stevekung.mods.moreplanets.module.planets.chalos.entity.*;
import stevekung.mods.moreplanets.module.planets.chalos.entity.projectile.EntityCheeseSpore;
import stevekung.mods.moreplanets.module.planets.chalos.entity.projectile.EntitySmallCheeseSpore;
import stevekung.mods.moreplanets.module.planets.diona.entity.*;
import stevekung.mods.moreplanets.module.planets.diona.entity.projectile.EntityInfectedCrystallizeArrow;
import stevekung.mods.moreplanets.module.planets.fronos.entity.EntityBearry;
import stevekung.mods.moreplanets.module.planets.fronos.entity.EntityGiantBlueberry;
import stevekung.mods.moreplanets.module.planets.fronos.entity.EntityMarshmallow;
import stevekung.mods.moreplanets.module.planets.nibiru.entity.*;
import stevekung.mods.moreplanets.module.planets.nibiru.entity.projectile.*;
import stevekung.mods.moreplanets.module.planets.nibiru.entity.weather.EntityNibiruLightningBolt;
import stevekung.mods.moreplanets.util.entity.EnumEntityTrackerType;
import stevekung.mods.moreplanets.util.helper.ColorHelper;
import stevekung.mods.moreplanets.util.helper.CommonRegisterHelper;

public class MPEntities
{
    public static void init()
    {
        CommonRegisterHelper.registerEntity(EntityAlbetiusWorm.class, "albetius_worm", ColorHelper.rgbToDecimal(137, 115, 196), ColorHelper.rgbToDecimal(52, 38, 89));
        CommonRegisterHelper.registerEntity(EntityInfectedCrystallizeSpider.class, "infected_crystallize_spider", ColorHelper.rgbToDecimal(51, 26, 63), ColorHelper.rgbToDecimal(188, 159, 242));
        CommonRegisterHelper.registerEntity(EntityInfectedCrystallizeWorm.class, "infected_crystallize_worm", ColorHelper.rgbToDecimal(102, 80, 146), ColorHelper.rgbToDecimal(147, 111, 213));
        CommonRegisterHelper.registerEntity(EntityInfectedCrystallizeSlimeBoss.class, "infected_crystallize_slime_boss", ColorHelper.rgbToDecimal(59, 50, 71), ColorHelper.rgbToDecimal(91, 19, 110));
        CommonRegisterHelper.registerEntity(EntityZeliusZombie.class, "zelius_zombie", ColorHelper.rgbToDecimal(23, 130, 130), ColorHelper.rgbToDecimal(108, 94, 118));
        CommonRegisterHelper.registerEntity(EntityZeliusCreeper.class, "zelius_creeper", ColorHelper.rgbToDecimal(87, 72, 124), ColorHelper.rgbToDecimal(44, 22, 69));
        CommonRegisterHelper.registerEntity(EntityCheeseCubeEyeBoss.class, "cheese_cube_eye_boss", ColorHelper.rgbToDecimal(255, 218, 131), ColorHelper.rgbToDecimal(194, 39, 36));
        CommonRegisterHelper.registerEntity(EntityCheeseFloater.class, "cheese_floater", ColorHelper.rgbToDecimal(255, 218, 131), ColorHelper.rgbToDecimal(19, 38, 201));
        CommonRegisterHelper.registerEntity(EntityCheeseSlime.class, "cheese_slime", ColorHelper.rgbToDecimal(255, 218, 131), ColorHelper.rgbToDecimal(255, 228, 162));
        CommonRegisterHelper.registerEntity(EntityCheeseCow.class, "cheese_cow", ColorHelper.rgbToDecimal(108, 84, 28), ColorHelper.rgbToDecimal(255, 227, 160));
        CommonRegisterHelper.registerEntity(EntityGiantWorm.class, "giant_worm", -2060769, -1413099);
        CommonRegisterHelper.registerEntity(EntityInfectedZombie.class, "infected_zombie", ColorHelper.rgbToDecimal(74, 55, 50), ColorHelper.rgbToDecimal(66, 25, 15));
        CommonRegisterHelper.registerEntity(EntityAlienMiner.class, "alien_miner", ColorHelper.rgbToDecimal(75, 75, 75), ColorHelper.rgbToDecimal(176, 193, 227));
        CommonRegisterHelper.registerEntity(EntityInfectedCrystallizeSlimeMinion.class, "infected_crystallize_slime_minion", ColorHelper.rgbToDecimal(59, 50, 71), ColorHelper.rgbToDecimal(91, 19, 110));
        CommonRegisterHelper.registerEntity(EntityInfectedWorm.class, "infected_worm", ColorHelper.rgbToDecimal(150, 52, 32), ColorHelper.rgbToDecimal(160, 70, 52));
        CommonRegisterHelper.registerEntity(EntityInfectedSnowman.class, "infected_snowman", ColorHelper.rgbToDecimal(164, 101, 84), ColorHelper.rgbToDecimal(145, 145, 145));
        CommonRegisterHelper.registerEntity(EntityZeliusSkeleton.class, "zelius_skeleton", ColorHelper.rgbToDecimal(100, 85, 106), ColorHelper.rgbToDecimal(120, 86, 188));
        CommonRegisterHelper.registerEntity(EntityInfectedGuardian.class, "infected_guardian", ColorHelper.rgbToDecimal(133, 79, 64), ColorHelper.rgbToDecimal(112, 97, 197));
        CommonRegisterHelper.registerEntity(EntityInfectedElderGuardian.class, "infected_elder_guardian", ColorHelper.rgbToDecimal(114, 118, 151), ColorHelper.rgbToDecimal(41, 42, 46));
        CommonRegisterHelper.registerEntity(EntityInfectedSquid.class, "infected_squid", ColorHelper.rgbToDecimal(70, 29, 20), ColorHelper.rgbToDecimal(143, 77, 54), 64, 3);
        CommonRegisterHelper.registerEntity(EntityInfectedChicken.class, "infected_chicken", ColorHelper.rgbToDecimal(148, 119, 108), ColorHelper.rgbToDecimal(88, 35, 19));
        CommonRegisterHelper.registerEntity(EntityInfectedCow.class, "infected_cow", ColorHelper.rgbToDecimal(95, 59, 36), ColorHelper.rgbToDecimal(66, 66, 66));
        CommonRegisterHelper.registerEntity(EntityInfectedCaveSpider.class, "infected_cave_spider", ColorHelper.rgbToDecimal(120, 54, 7), ColorHelper.rgbToDecimal(0, 204, 0));
        CommonRegisterHelper.registerEntity(EntityZergius.class, "zergius", ColorHelper.rgbToDecimal(176, 176, 124), ColorHelper.rgbToDecimal(121, 239, 51));
        CommonRegisterHelper.registerEntity(EntityShlime.class, "shlime", 15198183, ColorHelper.rgbToDecimal(151, 69, 46));
        CommonRegisterHelper.registerEntity(EntityNibiruVillager.class, "nibiru_villager", ColorHelper.rgbToDecimal(106, 79, 72), ColorHelper.rgbToDecimal(169, 90, 67));
        CommonRegisterHelper.registerEntity(EntityInfectedCreeper.class, "infected_creeper", ColorHelper.rgbToDecimal(159, 74, 40), ColorHelper.rgbToDecimal(66, 26, 16));
        CommonRegisterHelper.registerEntity(EntityInfectedSkeleton.class, "infected_skeleton", ColorHelper.rgbToDecimal(129, 54, 15), ColorHelper.rgbToDecimal(57, 30, 19));
        CommonRegisterHelper.registerEntity(EntityVeinFloater.class, "vein_floater", ColorHelper.rgbToDecimal(132, 68, 28), ColorHelper.rgbToDecimal(79, 49, 28));
        CommonRegisterHelper.registerEntity(EntityVeinFloaterMinion.class, "vein_floater_minion", ColorHelper.rgbToDecimal(132, 68, 28), ColorHelper.rgbToDecimal(79, 49, 28));
        CommonRegisterHelper.registerEntity(EntityMiniVeinFloater.class, "mini_vein_floater", ColorHelper.rgbToDecimal(132, 68, 28), ColorHelper.rgbToDecimal(79, 49, 28));
        CommonRegisterHelper.registerEntity(EntityGiantBlueberry.class, "giant_blueberry", ColorHelper.rgbToDecimal(69, 88, 156), ColorHelper.rgbToDecimal(79, 100, 177));
        CommonRegisterHelper.registerEntity(EntityMarshmallow.class, "marshmallow", ColorHelper.rgbToDecimal(225, 215, 206), ColorHelper.rgbToDecimal(128, 128, 128));
        CommonRegisterHelper.registerEntity(EntityBearry.class, "bearry", ColorHelper.rgbToDecimal(179, 47, 47), ColorHelper.rgbToDecimal(0, 143, 0));

        CommonRegisterHelper.registerNonMobEntity(EntitySpaceMinecartChest.class, "space_minecart_chest");
        CommonRegisterHelper.registerNonMobEntity(EntityTier4Rocket.class, "tier_4_rocket", EnumEntityTrackerType.TIERED_ROCKET);
        CommonRegisterHelper.registerNonMobEntity(EntityInfectedCrystallizeTentacle.class, "infected_crystallize_tentacle");
        CommonRegisterHelper.registerNonMobEntity(EntityTier5Rocket.class, "tier_5_rocket", EnumEntityTrackerType.TIERED_ROCKET);
        CommonRegisterHelper.registerNonMobEntity(EntityCheeseSpore.class, "cheese_spore", EnumEntityTrackerType.THROWABLE);
        CommonRegisterHelper.registerNonMobEntity(EntitySmallCheeseSpore.class, "small_cheese_spore", EnumEntityTrackerType.THROWABLE);
        CommonRegisterHelper.registerNonMobEntity(EntityInfectedCrystallizeBomb.class, "infected_crystallize_bomb", EnumEntityTrackerType.THROWABLE);
        CommonRegisterHelper.registerNonMobEntity(EntityNibiruLightningBolt.class, "nibiru_lightning_bolt");
        CommonRegisterHelper.registerNonMobEntity(EntityDarkLightningBolt.class, "dark_lightning_bolt");
        CommonRegisterHelper.registerNonMobEntity(EntityInfectedSnowball.class, "infected_snowball", EnumEntityTrackerType.THROWABLE);
        CommonRegisterHelper.registerNonMobEntity(EntityBlackHole.class, "black_hole");
        CommonRegisterHelper.registerNonMobEntity(EntityInfectedEgg.class, "infected_egg", EnumEntityTrackerType.THROWABLE);
        CommonRegisterHelper.registerNonMobEntity(EntityInfectedCrystallizeArrow.class, "infected_crystallize_arrow", EnumEntityTrackerType.ARROW);
        CommonRegisterHelper.registerNonMobEntity(EntityInfectedArrow.class, "infected_arrow", EnumEntityTrackerType.ARROW);
        CommonRegisterHelper.registerNonMobEntity(EntitySpaceFishHook.class, "space_fish_hook", EnumEntityTrackerType.FISHING_HOOK);
        CommonRegisterHelper.registerNonMobEntity(EntityAlienBeam.class, "alien_beam");
        CommonRegisterHelper.registerNonMobEntity(EntityVeinEye.class, "vein_eye", 64, 4);
        CommonRegisterHelper.registerNonMobEntity(EntityLaserBullet.class, "laser_bullet", EnumEntityTrackerType.ARROW);
        CommonRegisterHelper.registerNonMobEntity(EntitySpaceCapsule.class, "space_capsule");
        CommonRegisterHelper.registerNonMobEntity(EntityVeinBall.class, "vein_ball", EnumEntityTrackerType.THROWABLE);
        CommonRegisterHelper.registerNonMobEntity(EntityTier6Rocket.class, "tier_6_rocket", EnumEntityTrackerType.TIERED_ROCKET);
        CommonRegisterHelper.registerNonMobEntity(EntityBlackHoleStorage.class, "black_hole_storage");

        CommonRegisterHelper.registerEntityPlacement(EntityAlienMiner.class, SpawnPlacementType.ON_GROUND);
        CommonRegisterHelper.registerEntityPlacement(EntityZeliusZombie.class, SpawnPlacementType.ON_GROUND);
        CommonRegisterHelper.registerEntityPlacement(EntityZeliusCreeper.class, SpawnPlacementType.ON_GROUND);
        CommonRegisterHelper.registerEntityPlacement(EntityCheeseFloater.class, SpawnPlacementType.ON_GROUND);
        CommonRegisterHelper.registerEntityPlacement(EntityCheeseSlime.class, SpawnPlacementType.ON_GROUND);
        CommonRegisterHelper.registerEntityPlacement(EntityCheeseCow.class, SpawnPlacementType.ON_GROUND);
        CommonRegisterHelper.registerEntityPlacement(EntityGiantWorm.class, SpawnPlacementType.ON_GROUND);
        CommonRegisterHelper.registerEntityPlacement(EntityInfectedZombie.class, SpawnPlacementType.ON_GROUND);
        CommonRegisterHelper.registerEntityPlacement(EntityInfectedSnowman.class, SpawnPlacementType.ON_GROUND);
        CommonRegisterHelper.registerEntityPlacement(EntityZeliusSkeleton.class, SpawnPlacementType.ON_GROUND);
        CommonRegisterHelper.registerEntityPlacement(EntityInfectedGuardian.class, SpawnPlacementType.IN_WATER);
        CommonRegisterHelper.registerEntityPlacement(EntityInfectedSquid.class, SpawnPlacementType.IN_WATER);
        CommonRegisterHelper.registerEntityPlacement(EntityInfectedChicken.class, SpawnPlacementType.ON_GROUND);
        CommonRegisterHelper.registerEntityPlacement(EntityInfectedCow.class, SpawnPlacementType.ON_GROUND);
        CommonRegisterHelper.registerEntityPlacement(EntityZergius.class, SpawnPlacementType.IN_AIR);
        CommonRegisterHelper.registerEntityPlacement(EntityShlime.class, SpawnPlacementType.ON_GROUND);
        CommonRegisterHelper.registerEntityPlacement(EntityInfectedCreeper.class, SpawnPlacementType.ON_GROUND);
        CommonRegisterHelper.registerEntityPlacement(EntityInfectedSkeleton.class, SpawnPlacementType.ON_GROUND);
        CommonRegisterHelper.registerEntityPlacement(EntityGiantBlueberry.class, SpawnPlacementType.ON_GROUND);
        CommonRegisterHelper.registerEntityPlacement(EntityMarshmallow.class, SpawnPlacementType.ON_GROUND);
        CommonRegisterHelper.registerEntityPlacement(EntityBearry.class, SpawnPlacementType.ON_GROUND);
    }
}