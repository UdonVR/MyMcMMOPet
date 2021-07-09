package io.github.takato65.mymcmmopet.listeners;


import org.bukkit.event.Listener;

public class PetReleseListener implements Listener {

/*    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
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
    }*/
}
