package me.megabot.pvpcustomdmg.config;

public class DamageConfig {
    private static int dmgPercentageMulti = 0;
    private static double baseDmg = 1.0;
    private static boolean isBaseEnabled = false;
    private static boolean isDemoEnabled = false;

    public static double modifyDamageValue(double damage) {
        if (isBaseEnabled) return (damage == 0) ? damage : baseDmg;
        return damage + (damage * (dmgPercentageMulti / 100));
    }

    public static void setDmgPercentageMulti(int multi) {
        dmgPercentageMulti = multi;
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

    public static void setIsDemoEnabled(boolean enabled) {
        isDemoEnabled = enabled;
    }

    public static boolean isDemoEnabled() {
        return isDemoEnabled;
    }
}
