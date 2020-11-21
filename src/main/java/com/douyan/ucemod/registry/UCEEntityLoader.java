package com.douyan.ucemod.registry;

import com.douyan.ucemod.UCEmod;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
@Mod.EventBusSubscriber
public class UCEEntityLoader
{
	
    public static final EntityEntry VEHICLE_EXPLORER = createEntityEntry(MachineExplorer.class, "vehicle_explorer", 0xFFFFFF, 0xAAAAAA);

    private static int ID=1;
    private RegistryEvent.Register<EntityEntry> event;


	@SubscribeEvent
    public void registerEntity(RegistryEvent.Register<EntityEntry> event) {
       this.event=event;
       reg(VEHICLE_EXPLORER);
    }
    private void reg(EntityEntry... ee){
        for(EntityEntry et:ee){
            event.getRegistry().register(et);
        }
    }
    private static EntityEntry createEntityEntry(Class entityClass, String name, int eggCcolor1, int eggColor2) {

        return EntityEntryBuilder.create().entity(entityClass).id(new ResourceLocation(UCEmod.MODID, name), ID++).name(name).egg(eggCcolor1, eggColor2).tracker(32, 10, true).build();
    }
}
