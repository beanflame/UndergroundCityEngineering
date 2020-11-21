package com.beanflame.ucemod.render;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class EntityRenderFactory implements IRenderFactory {
    private final Class<? extends Render> renderClass;
    public EntityRenderFactory( Class<? extends Render> renderClass){
        this.renderClass = renderClass;
    }
    @Override
    public Render createRenderFor(RenderManager manager)
    {
        try
        {
            return renderClass.getConstructor(RenderManager.class).newInstance(manager);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
