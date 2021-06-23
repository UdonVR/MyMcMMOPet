package io.github.takato65.mymcmmopet.listeners;


import com.gmail.nossr50.datatypes.player.McMMOPlayer;
import com.gmail.nossr50.datatypes.skills.PrimarySkillType;
import com.gmail.nossr50.util.skills.CombatUtils;
import de.Keyle.MyPet.api.entity.MyPet;
import de.Keyle.MyPet.api.entity.MyPetBukkitEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import static org.bukkit.Bukkit.getLogger;

public class EntityListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof MyPetBukkitEntity) {
            //getLogger().info("[MyMCMMOPet] attacked");
            if (event.getEntity() instanceof LivingEntity){
                LivingEntity target = (LivingEntity) event.getEntity();
                MyPetBukkitEntity craftMyPet = (MyPetBukkitEntity) event.getDamager();
                MyPet myPet = craftMyPet.getMyPet();

                double damage = event.getFinalDamage();
                //getLogger().info("[MyMCMMOPet] "+ myPet.getPetName()+ " did " +damage+ " to "+ event.getEntity().toString());
                //com.gmail.nossr50.api.ExperienceAPI.addCombatXP
                McMMOPlayer mcMMOPlayer = com.gmail.nossr50.util.player.UserManager.getPlayer(myPet.getOwner().getPlayer());
                CombatUtils.processCombatXP(mcMMOPlayer, target, PrimarySkillType.TAMING, 3);
            }
        }
    }
}
