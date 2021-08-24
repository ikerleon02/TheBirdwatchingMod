package com.ikerleon.birdwmod.client.gui;

import com.ikerleon.birdwmod.Main;
import com.ikerleon.birdwmod.entity.BirdEntity;
import com.ikerleon.birdwmod.entity.BirdSettings;
import com.ikerleon.birdwmod.entity.InitEntities;
import com.ikerleon.birdwmod.items.InitItems;
import com.mojang.blaze3d.systems.RenderSystem;
import edu.umd.cs.findbugs.annotations.Nullable;
import net.fabricmc.fabric.impl.object.builder.FabricEntityType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ScreenTexts;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.PageTurnWidget;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.NarratorManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.*;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import org.lwjgl.opengl.GL11;

public class GUIBirdGuide extends Screen {

    private final int bookImageHeight = 180;
    private final int bookImageWidth = 292;

    private int currPage = 0;
    private static final int bookTotalPages = 17;

    private ButtonWidget buttonDone;
    private ButtonWidget buttonNextPage;
    private ButtonWidget buttonPreviousPage;
    private static Identifier cover=new Identifier("birdwmod" + ":textures/gui/birdguide/cover.png");
    private static Identifier page=new Identifier("birdwmod" + ":textures/gui/birdguide/page.png");

    private static String Waterfowl = Formatting.GRAY + "Waterfowl";
    private static String Galliformes = Formatting.GRAY + "Galliformes";
    private static String Waders = Formatting.GRAY + "Waders";
    private static String GullsBoobies = Formatting.GRAY + "Gulls & Boobies";
    private static String Auks = Formatting.GRAY + "Auks";
    private static String Owls = Formatting.GRAY + "Owls";
    private static String Nightjars = Formatting.GRAY + "Nightjars";
    private static String Passerines = Formatting.GRAY + "Passerines";
    private static String Herons = Formatting.GRAY + "Herons";
    private static String Coraciiformes = Formatting.GRAY + "Coraciiformes";
    private static String Opisthocomiformes = Formatting.GRAY + "Opisthocomiformes";

    private static String CharacteristicsTitle = Formatting.BOLD + "Characteristics";
    private static String BiomesTitle = Formatting.BOLD + "Vanilla Biomes";

    private static String page9Title = Formatting.BOLD + "Red-necked nightjar";
    private static String page9Subtitle = Formatting.ITALIC + "(Caprimulgus ruficollis)";
    private static String page9Text = "It's the largest of the nightjars occurring in Europe. It breeds in Iberia and north Africa, and winters in tropical west Africa. Open sandy heaths with trees or bushes are the haunts of this crepuscular bird. In flight it presents a characteristic silhouette with silent flight and low altitude.";

    private static String page10Title = Formatting.BOLD + "Northern Mockingbird";
    private static String page10Subtitle = Formatting.ITALIC + "(Mimus polyglottos)";
    private static String page10Text = "It's are best known for the habit of mimicking the songs of other birds and the sounds of insects and amphibians. This bird is mainly a permanent resident, but northern birds may move south during harsh weather. Northern mockingbirds are omnivore. It's often found in open areas and forest edges.";

    private static String page11Title = Formatting.BOLD + "Eastern bluebird";
    private static String page11Subtitle = Formatting.ITALIC + "(Sialia sialis)";
    private static String page11Text = "It's a small thrush found in open woodlands, farmlands, and orchards of North America. The Eastern bluebird is the state bird of New York. About two-thirds of the diet of an adult consists of insects and other invertebrates. Eastern bluebirds tend to live in open country around trees.";

    private static String page12Title = Formatting.BOLD + "Red-flanked bluetail";
    private static String page12Subtitle = Formatting.ITALIC + "(Tarsiger cyanurus)";
    private static String page12Text = "It's a small passerine bird that lives in the coniferous forests of Eurasia. It breeds in upper-middle and marginally in upper continental latitudes, exclusively boreal and mountain. Its diet is based on insects, also fruits and seeds outside breeding season.";

    private static String page14Title1 = Formatting.BOLD + "King-of-Saxony";
    private static String page14Title2 = Formatting.BOLD + "bird of paradise";
    private static String page14Subtitle = Formatting.ITALIC + "(Pteridophora alberti)";
    private static String page14Text = "It's a bird of paradise endemic to montane forest in New Guinea. The most iconic characteristic of this bird are the two remarkably long (up to 50 cm) brow-plumes, which are so bizarre that when the first specimen was brought to Europe, it was thought to be a fake.";

    private static String page15Title1 = Formatting.BOLD + "Turquoise-browed";
    private static String page15Title2 = Formatting.BOLD + "motmot";
    private static String page15Subtitle = Formatting.ITALIC + "(Eumomota superciliosa)";
    private static String page15Text = "It's a colorful bird that lives all across Central America, from south-east Mexico (mostly the Yucatán Peninsula), to Costa Rica. It lives in habitats such as forest edge or gallery forest. it often perches from wires or posts where it scans for prey, such as insects and small reptiles.";

    private static String page16Title = Formatting.BOLD + "Hoatzin";
    private static String page16Subtitle = Formatting.ITALIC + "(Opisthocomus hoazin)";
    private static String page16Text = "It's a tropical, dinosaur-type bird that can be found in swamps, riparian forests, and mangroves of the Amazon and the Orinoco basins in South America. It is notable for having chicks that have claws on two of their wing digits. The hoatzin is a folivore, in other words it eats the leaves";


    public GUIBirdGuide() {
        super(NarratorManager.EMPTY);
    }

    @Override
    protected void init() {
        int offLeft = (int)((this.width - 292) / 2.0F);
        int offTop = (int)((this.height - 225) / 2.0F);

        this.client.keyboard.setRepeatEvents(true);

        buttonDone = new ButtonWidget(offLeft+(bookImageWidth/2)-50, offTop+bookImageHeight+15, 100, 20, ScreenTexts.DONE, (buttonWidget) -> {
            this.client.setScreen(null);
        });

        this.addDrawableChild(buttonDone);
        this.addDrawableChild(buttonNextPage = new ButtonWidget(offLeft+bookImageWidth+15, offTop, 50, 20, new LiteralText("->"), (buttonWidget) -> {
            if (currPage < bookTotalPages - 1)
            {
                ++currPage;
                buttonNextPage.visible = (currPage < bookTotalPages - 1);
                buttonPreviousPage.visible = currPage > 0;
            }
        }));
        this.addDrawableChild(buttonPreviousPage = new ButtonWidget( offLeft-65, offTop, 50, 20, new LiteralText("<-"), (buttonWidget) -> {
            if (currPage > 0)
            {
                --currPage;
                buttonPreviousPage.visible = currPage > 0;
                buttonNextPage.visible = (currPage < bookTotalPages - 1);
            }
        }));
        buttonPreviousPage.visible = false;
    }

    public static MutableText getTranslatedText(@Nullable Formatting format, BirdEntity bird, String section){
        MutableText text = new TranslatableText("gui."+Main.ModID+"."+bird.getPath()+"_" + section);
        if(format!=null){return text.formatted(format);}
        return text;
    }

    public static MutableText getTranslatedText(BirdEntity bird, String section){
        return getTranslatedText(null, bird, section);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        int offLeft = (int)((this.width - 292) / 2.0F);
        int offTop = (int)((this.height - 225) / 2.0F);
        int mousePosX = mouseX;
        int mousePosY = mouseY;

        if(currPage==0) {
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.setShaderTexture(0, cover);
            drawTexture(matrices, offLeft, offTop, 0, 0, bookImageWidth, bookImageHeight, bookImageWidth, bookImageHeight);
            super.render(matrices, mouseX, mouseY, delta);
            return;
        }
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, page);
        drawTexture(matrices, offLeft, offTop, 0, 0, bookImageWidth ,bookImageHeight ,bookImageWidth ,bookImageHeight);

        BirdEntity.Settings birdSettings = BirdSettings.bookBirds.get(currPage - 1);
        BirdEntity entity = new BirdEntity(InitEntities.GUI_BIRD_ENTITY, MinecraftClient.getInstance().world, birdSettings);
        this.textRenderer.draw( matrices, getTranslatedText(Formatting.BOLD, entity, "title"), offLeft + 30, 15 + offTop, 0);
        this.textRenderer.draw( matrices, getTranslatedText(Formatting.ITALIC, entity, "subtitle"), offLeft + 25, 25 + offTop, 0);
        this.textRenderer.drawTrimmed(StringVisitable.plain(getTranslatedText(entity, "text").getString()), offLeft + 13, 40 + offTop, 126, 0);
        this.textRenderer.draw( matrices, CharacteristicsTitle, offLeft + 170, 15 + offTop, 0);
        this.textRenderer.draw( matrices,Waterfowl, offLeft + 195, 25 + offTop, 0);
        this.textRenderer.draw( matrices,Formatting.ITALIC + "Male", offLeft + 175, 80 + offTop, 0);
        this.textRenderer.draw( matrices,Formatting.ITALIC + "Female", offLeft + 232, 80 + offTop, 0);
        this.textRenderer.draw( matrices, BiomesTitle, offLeft + 175, 125 + offTop, 0);
        this.textRenderer.draw( matrices, BiomesTitle, offLeft + 175, 125 + offTop, 0);
        this.textRenderer.drawTrimmed(StringVisitable.plain(birdSettings.spawnBiomesAsString()), offLeft + 160, 140 + offTop,110,  0);

        BirdEntity female_entity = new BirdEntity(InitEntities.GUI_BIRD_ENTITY, MinecraftClient.getInstance().world, birdSettings);
        entity.setGender(0);
        entity.setVariant(0);
        entity.setOnGround(true);
        female_entity.setGender(1);
        female_entity.setVariant(0);
        female_entity.setOnGround(true);
        this.itemRenderer.renderGuiItemIcon(new ItemStack(entity.getFeatherItem(), 1), offLeft + 175, 95 + offTop);
        this.itemRenderer.renderInGui(new ItemStack(female_entity.getFeatherItem(), 1), offLeft + 240, 95 + offTop);
        int i = (this.width - this.bookImageWidth) / 2;
        int j = (this.height - this.bookImageHeight) / 2;
        InventoryScreen.drawEntity(offLeft + 185, 75 + offTop, 60, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity);
        InventoryScreen.drawEntity(offLeft + 250, 75 + offTop, 60, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, female_entity);

        super.render(matrices, mouseX, mouseY, delta);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
