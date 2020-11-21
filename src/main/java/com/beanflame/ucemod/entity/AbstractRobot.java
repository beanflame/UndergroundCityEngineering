package com.beanflame.ucemod.entity;

import com.beanflame.ucemod.ai.RaidAIBlock;
import com.beanflame.ucemod.ai.RaidAIDropBlock;
import com.beanflame.ucemod.inventory.RobotContainer;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
//一定要记得让放置机器的时候,一定放在箱子上
public abstract class AbstractRobot extends EntityCreature {
    private int interactCooldown=0;
    protected RobotContainer container=new RobotContainer(new TextComponentTranslation("container.uce.default").getKey());
    protected DataParameter<Integer> FUEL ;

    public AbstractRobot(World worldIn) {
        super(worldIn);
    }
    //重写方法
    @Override
    protected void entityInit() {
        super.entityInit();
        setSize(1,1);
        FUEL= EntityDataManager.<Integer>createKey(AbstractRobot.class, DataSerializers.VARINT);
        //WORKING=EntityDataManager.<Boolean>createKey(AbstractRobot.class, DataSerializers.BOOLEAN);
        this.dataManager.register(FUEL,100);
        //this.dataManager.register(WORKING,false);
    }
    @Override
    protected void initEntityAI()
    {
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 2.2D));
        //TODO 完善FUEL_COOKIE


            //UCEItem.FUEL_COOKIE
        //this.tasks.addTask(3, new EntityAITempt(this, 1.0D, UCEItem.BUCKET_WHEEL, false));



        // this.tasks.addTask(4, new EntityAIAvoidEntity(this, EntityPlayer.class, 8.0F, 2.2D, 2.2D));
        this.tasks.addTask(5, new RaidAIBlock(this,0.7,32));
        this.tasks.addTask(2, new RaidAIDropBlock(this));
        this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 0.6D));
        this.tasks.addTask(11, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
    }
    @Override
    public void onEntityUpdate() {
        super.onEntityUpdate();
    }

    @Override
    protected boolean processInteract(EntityPlayer player, EnumHand hand) {
        if(hand!=EnumHand.MAIN_HAND)
            return false;
        if(!handleInteractCooldown())
            return false;
        ItemStack hold=player.getHeldItem(hand);

        /*
        //addFuel
        if (hold == UCEItem.BUCKET_WHEEL)
        {
            hold.shrink(1);
            this.addFuel(1000);
            return true;
        }
        */


        if(canRide())
        if (this.canPassengerSteer()&&this.canBeRidden(player))
        {
            this.startRiding(player);
            return true;
        }
        AbstractRobot robot = null;
        if(hasInv())
            if(player.isSneaking()){
                getInventory().openInventory(player);
            }
        return false;
    }
    public void dropItems(){
        for(int i=0;i<getInventory().getSizeInventory();i++){
            ItemStack stack=getInventory().getStackInSlot(i);
            if (stack==null)
                continue;
           this.dropItem(stack.getItem(),stack.getCount());
        }
        getInventory().clear();
    }
    //yuseful
    abstract boolean canRide();
    abstract boolean hasInv();
    //私有方法
    private boolean handleInteractCooldown(){
        if(this.interactCooldown<0) {
            interactCooldown = 60;
            return true;
        }
          interactCooldown--;
          return false;
    }
    //get&setter
    public RobotContainer getInventory(){
        return this.container;
    }
    public boolean isFull(){
        return getInventory().getStackInSlot(47)== ItemStack.EMPTY;
    }
    public int getFuel(){
        return this.dataManager.get(FUEL);
    }
    public int setFuel(int fuel){
        this.dataManager.set(FUEL,fuel);
        return fuel;
    }

    public boolean hasFuel() {
        return getFuel()>0;
    }
    public int addFuel(int fuel){
       return setFuel(getFuel()+fuel);

    }
    /*
    public boolean isWorking(){
        return  this.dataManager.get(WORKING);
    }
    public boolean setWorking(boolean working){
        this.dataManager.set(WORKING,working);
        return working;
    }
    public boolean toggleWorking(){
        return setWorking(!isWorking());
    }
    */
    //属性
    @Override
    public boolean canBeSteered()
    {
        return true;
    }

}
