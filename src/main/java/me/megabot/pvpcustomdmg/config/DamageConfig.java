package me.megabot.pvpcustomdmg.config;

public class DamageConfig {
    private static int dmgPercentageMulti = -100;
    private static double baseDmg = 1.0;
    private static boolean isBaseEnabled = false;

    public static double modifyDamageValue(double damage) {
        if (isBaseEnabled) return baseDmg;
        return damage + (damage * dmgPercentageMulti);
    }

    public static void setDmgPercentageMulti(int mult) {
        dmgPercentageMulti = mult;
    }

    public static int getDmgPercentageMulti() {
        return dmgPercentageMulti;
    }

    public static void setIsBaseEnabled(boolean enabled) {
        isBaseEnabled = enabled;
    }

    public static boolean isBaseEnabled() {
        return isBaseEnabled;
    }

    public static void setBaseDmg(double damage) {
        baseDmg = damage;
    }

    public static double getBaseDmg() {
        return baseDmg;
    }
}
