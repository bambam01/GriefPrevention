package me.ryanhamshire.GriefPrevention;

import java.util.List;

/**
 * Created by SirWill on 16.10.15.
 */
public class TrustableFakePlayers {

    public static boolean isTrustableFakePlayer(String player) {
        List<String> ignoredAccounts = GriefPrevention.instance.config_mods_ignoreTrustAccounts;

        if(ignoredAccounts.contains(player.toLowerCase())) {
            return true;
        }

        for(String ignored : ignoredAccounts) {
            if(ignored.toLowerCase().equals(player.toLowerCase()))
                return true;

            if(ignored.contains("*")) {
                String pattern = ignored.replace("*", ".*").toLowerCase();
                if(pattern.matches(player))
                    return true;
            }
        }
        return false;
    }
}
