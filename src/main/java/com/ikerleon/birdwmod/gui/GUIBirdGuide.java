package com.ikerleon.birdwmod.gui;

import com.ikerleon.birdwmod.entity.InitEntities;
import com.ikerleon.birdwmod.entity.europe.EurasianBullfinchEntity;
import com.ikerleon.birdwmod.entity.europe.RedFlankedBluetailEntity;
import com.ikerleon.birdwmod.entity.europe.RedNeckedNightjarEntity;
import com.ikerleon.birdwmod.entity.europe.StellersEiderEntity;
import com.ikerleon.birdwmod.entity.jungle.HoatzinEntity;
import com.ikerleon.birdwmod.entity.jungle.KingOfSaxonyEntity;
import com.ikerleon.birdwmod.entity.jungle.TurquoiseBrowedMotmotEntity;
import com.ikerleon.birdwmod.entity.northamerica.EasternBluebirdEntity;
import com.ikerleon.birdwmod.entity.northamerica.GreenHeronEntity;
import com.ikerleon.birdwmod.entity.northamerica.KilldeerEntity;
import com.ikerleon.birdwmod.entity.northamerica.NorthernMockingbirdEntity;
import com.ikerleon.birdwmod.entity.release160.BrownBoobyEntity;
import com.ikerleon.birdwmod.entity.release160.GreatGreyOwlEntity;
import com.ikerleon.birdwmod.entity.release170.HimalayanMonalEntity;
import com.ikerleon.birdwmod.entity.release170.RazorbillEntity;
import com.ikerleon.birdwmod.entity.release170.SabinesGullEntity;
import com.ikerleon.birdwmod.items.InitItems;
import net.fabricmc.fabric.impl.object.builder.FabricEntityType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ScreenTexts;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.NarratorManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.StringRenderable;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biomes;
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

    private static String page1Title = Formatting.BOLD + "Steller's eider";
    private static String page1Subtitle = Formatting.ITALIC + "(Polysticta stelleri)";
    private static String page1Text = "It's a smallish sea duck that breeds along the Arctic coasts of eastern Siberia and Alaska. It winters somewhat farther south in the Bering Sea, northern Scandinavia and the Baltic Sea. It can form large flocks of up to 200,000 birds on suitable coastal waters. It is scarce south of its wintering range.";

    private static String page2Title = Formatting.BOLD + "Himalayan Monal";
    private static String page2Subtitle = Formatting.ITALIC + "(Lophophorus impejanus)";
    private static String page2Text = "It's a high altitude bird, native to the Himalayan regions of China, India, Nepal, which have it as its national bird. It feeds mainly on seeds, fruits and different insects. Its most interesting fact is their wide range of calls, which allows them to differentiate between contentment, aggression or alarm";

    private static String page3Title = Formatting.BOLD + "Green heron";
    private static String page3Subtitle = Formatting.ITALIC + "(Butorides virescens)";
    private static String page3Text = "It's a small heron of North and Central America. Green herons are one of the few species of bird known to use tools, they commonly use bread crusts, insects, or other items as bait. The habitat of the green heron is small wetlands in low-lying areas. The species is most conspicuous during dusk and dawn.";

    private static String page4Title = Formatting.BOLD + "Killdeer";
    private static String page4Subtitle = Formatting.ITALIC + "(Charadrius vociferus)";
    private static String page4Text = "It's a large plover found in the Americas. The killdeer's common name comes from its often-heard call. It primarily feeds on insects, although other invertebrates and seeds are eaten. The non-breeding habitat of the killdeer includes coastal wetlands, beach habitats, and coastal fields.";

    private static String page5Title = Formatting.BOLD + "Sabine's Gull";
    private static String page5Subtitle = Formatting.ITALIC + "(Xema sabini)";
    private static String page5Text = "It's a small gull that breeds in the Arctic, through northernmost North America and Eurasia. It migrates south in late summer. Most of the population winters at sea in the Pacific off western South America and in Atlantic central Africa. It has an extremely pelagic lifestyle out of its breeding grounds.";

    private static String page6Title = Formatting.BOLD + "Brown booby";
    private static String page6Subtitle = Formatting.ITALIC + "(Sula leucogaster)";
    private static String page6Text = "It's a large seabird of the Sulidae family, this species breeds on islands and coasts in the pantropical areas of the Atlantic and Pacific oceans. This booby commutes and forages at low height over inshore waters, where they plunge-dive to take small fish, especially when these are driven near the surface.";

    private static String page7Title = Formatting.BOLD + "Razorbill";
    private static String page7Subtitle = Formatting.ITALIC + "(Alca torda)";
    private static String page7Text = "It is a seabird, member of the Alcidae family. It is the closest living relative of the extinct great auk. Razorbills are distributed across the North Atlantic, where they feed on mid water fish such as cod, sprats and herring. Both genders are identical in plumage; however, males are larger than females.";

    private static String page8Title = Formatting.BOLD + "Great grey owl";
    private static String page8Subtitle = Formatting.ITALIC + "(Strix nebulosa)";
    private static String page8Text = "It's the documented as the world's largest species of Strix genus. It breeds across the Northern Hemisphere, being the only species of Strix genus found in both Eastern and Western Hemispheres. Their habitat is often the dense coniferous forests of the taiga, near open areas, such as meadows or bogs.";

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

    private static String page13Title = Formatting.BOLD + "Eurasian bullfinch";
    private static String page13Subtitle = Formatting.ITALIC + "(Pyrrhula pyrrhula)";
    private static String page13Text = "It's a finch that breeds across Europe and temperate Asia. It is mainly resident, but many northern birds migrate further south in the winter. Mixed woodland with some conifers is favoured for breeding, including parkland and gardens. The food they eat is mainly seeds and buds of fruit trees.";

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

        this.client.keyboard.enableRepeatEvents(true);

        buttonDone = new ButtonWidget(offLeft+(bookImageWidth/2)-50, offTop+bookImageHeight+15, 100, 20, ScreenTexts.DONE, (buttonWidget) -> {
            this.client.openScreen((Screen)null);
        });

        this.addButton(buttonDone);
        this.addButton(buttonNextPage = new ButtonWidget(offLeft+bookImageWidth+15, offTop, 50, 20, new LiteralText("->"), (buttonWidget) -> {
            if (currPage < bookTotalPages - 1)
            {
                ++currPage;
                buttonNextPage.visible = (currPage < bookTotalPages - 1);
                buttonPreviousPage.visible = currPage > 0;
            }
        }));
        this.addButton(buttonPreviousPage = new ButtonWidget( offLeft-65, offTop, 50, 20, new LiteralText("<-"), (buttonWidget) -> {
            if (currPage > 0)
            {
                --currPage;
                buttonPreviousPage.visible = currPage > 0;
                buttonNextPage.visible = (currPage < bookTotalPages - 1);
            }
        }));
        buttonPreviousPage.visible = false;
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        int offLeft = (int)((this.width - 292) / 2.0F);
        int offTop = (int)((this.height - 225) / 2.0F);
        int mousePosX = mouseX;
        int mousePosY = mouseY;

        if(currPage==0) {
            MinecraftClient.getInstance().getTextureManager().bindTexture(cover);
        }
        else {
            MinecraftClient.getInstance().getTextureManager().bindTexture(page);
        }
        drawTexture(matrices, offLeft, offTop, 0, 0, bookImageWidth ,bookImageHeight ,bookImageWidth ,bookImageHeight);

        if(currPage==1){
            this.textRenderer.draw( matrices, page1Title, offLeft + 30, 15 + offTop, 0);
            this.textRenderer.draw( matrices, page1Subtitle, offLeft + 25, 25 + offTop, 0);
            this.textRenderer.drawTrimmed(StringRenderable.plain(page1Text), offLeft + 13, 40 + offTop, 126, 0);
            this.textRenderer.draw( matrices, CharacteristicsTitle, offLeft + 170, 15 + offTop, 0);
            this.textRenderer.draw( matrices,Waterfowl, offLeft + 195, 25 + offTop, 0);
            this.textRenderer.draw( matrices,Formatting.ITALIC + "Male", offLeft + 175, 80 + offTop, 0);
            this.textRenderer.draw( matrices,Formatting.ITALIC + "Female", offLeft + 232, 80 + offTop, 0);
            this.textRenderer.draw( matrices, BiomesTitle, offLeft + 175, 125 + offTop, 0);
            this.textRenderer.drawTrimmed(StringRenderable.plain("- Snowy Beach, Frozen Ocean"), offLeft + 160, 140 + offTop,110,  0);

            this.itemRenderer.renderGuiItemIcon(new ItemStack(InitItems.STELLERSEIDERFEATHER_MALE, 1), offLeft + 175, 95 + offTop);
            this.itemRenderer.renderInGui(new ItemStack(InitItems.STELLERSEIDERFEATHER_FEMALE, 1), offLeft + 240, 95 + offTop);

            int i = (this.width - this.bookImageWidth) / 2;
            int j = (this.height - this.bookImageHeight) / 2;
            StellersEiderEntity entity = new StellersEiderEntity(InitEntities.STELLERS_EIDER_ENTITY, MinecraftClient.getInstance().world);
            entity.setGender(0);
            entity.setOnGround(true);
            StellersEiderEntity entity2 = new StellersEiderEntity(InitEntities.STELLERS_EIDER_ENTITY, MinecraftClient.getInstance().world);
            entity2.setGender(1);
            entity2.setOnGround(true);
            InventoryScreen.drawEntity(offLeft + 185, 75 + offTop, 60, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity);
            InventoryScreen.drawEntity(offLeft + 250, 75 + offTop, 60, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity2);
        }
        if(currPage==2){
            this.textRenderer.draw( matrices, page2Title, offLeft + 30, 15 + offTop, 0);
            this.textRenderer.draw( matrices, page2Subtitle, offLeft + 11, 25 + offTop, 0);
            this.textRenderer.drawTrimmed(StringRenderable.plain(page2Text), offLeft + 13, 40 + offTop, 126, 0);
            this.textRenderer.draw( matrices, CharacteristicsTitle, offLeft + 170, 15 + offTop, 0);
            this.textRenderer.draw( matrices, Galliformes, offLeft + 190, 25 + offTop, 0);
            this.textRenderer.draw( matrices,Formatting.ITALIC + "Male", offLeft + 175, 80 + offTop, 0);
            this.textRenderer.draw( matrices,Formatting.ITALIC + "Female", offLeft + 232, 80 + offTop, 0);
            this.textRenderer.draw( matrices, BiomesTitle, offLeft + 175, 125 + offTop, 0);
            this.textRenderer.drawTrimmed(StringRenderable.plain("- Wooded Mountains"), offLeft + 160, 140 + offTop,110,  0);

            this.itemRenderer.renderGuiItemIcon(new ItemStack(InitItems.HIMALAYANMONALMALEFEATHER, 1), offLeft + 175, 95 + offTop);
            this.itemRenderer.renderInGui(new ItemStack(InitItems.HIMALAYANMONALFEMALEFEATHER, 1), offLeft + 240, 95 + offTop);

            int i = (this.width - this.bookImageWidth) / 2;
            int j = (this.height - this.bookImageHeight) / 2;
            HimalayanMonalEntity entity = new HimalayanMonalEntity(InitEntities.HIMALAYAN_MONAL_ENTITY, MinecraftClient.getInstance().world);
            entity.setGender(0);
            entity.setOnGround(true);
            HimalayanMonalEntity entity2 = new HimalayanMonalEntity(InitEntities.HIMALAYAN_MONAL_ENTITY, MinecraftClient.getInstance().world);
            entity2.setGender(1);
            entity2.setOnGround(true);
            InventoryScreen.drawEntity(offLeft + 185, 75 + offTop, 50, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity);
            InventoryScreen.drawEntity(offLeft + 250, 75 + offTop, 50, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity2);
        }

        else if(currPage==3){
            this.textRenderer.draw( matrices, page3Title, offLeft + 35, 15 + offTop, 0);
            this.textRenderer.draw(matrices, page3Subtitle, offLeft + 20, 25 + offTop, 0);
            this.textRenderer.drawTrimmed(StringRenderable.plain(page3Text), offLeft + 13, 40 + offTop, 126, 0);
            this.textRenderer.draw(matrices, CharacteristicsTitle, offLeft + 170, 15 + offTop, 0);
            this.textRenderer.draw(matrices, Herons, offLeft + 200, 25 + offTop, 0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "var. 1", offLeft + 160, 75 + offTop,0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "var. 2", offLeft + 200, 85 + offTop,0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "var. 3", offLeft + 240, 75 + offTop,0);
            this.textRenderer.draw(matrices, BiomesTitle, offLeft + 175, 125 + offTop, 0);
            this.textRenderer.draw(matrices, "- River", offLeft + 160, 140 + offTop, 0);

            this.itemRenderer.renderInGui(new ItemStack(InitItems.GREENHERONFEATHER, 1), offLeft + 205, 95 + offTop);

            int i = (this.width - this.bookImageWidth) / 2;
            int j = (this.height - this.bookImageHeight) / 2;
            GreenHeronEntity entity = new GreenHeronEntity(InitEntities.GREEN_HERON_ENTITY, MinecraftClient.getInstance().world);
            entity.setVariant(1);
            entity.setOnGround(true);
            GreenHeronEntity entity2 = new GreenHeronEntity(InitEntities.GREEN_HERON_ENTITY, MinecraftClient.getInstance().world);
            entity2.setVariant(2);
            entity2.setOnGround(true);
            GreenHeronEntity entity3 = new GreenHeronEntity(InitEntities.GREEN_HERON_ENTITY, MinecraftClient.getInstance().world);
            entity3.setVariant(3);
            entity3.setOnGround(true);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            InventoryScreen.drawEntity(offLeft + 175, 70 + offTop, 60, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity3);
            InventoryScreen.drawEntity(offLeft + 215, 80 + offTop, 60, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity2);
            InventoryScreen.drawEntity(offLeft + 255, 70 + offTop, 60, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity);
        }

        else if(currPage==4) {
            this.textRenderer.draw(matrices, page4Title, offLeft + 50, 15 + offTop, 0);
            this.textRenderer.draw(matrices, page4Subtitle, offLeft + 15, 25 + offTop, 0);
            this.textRenderer.drawTrimmed(StringRenderable.plain(page4Text), offLeft + 13, 40 + offTop, 126, 0);
            this.textRenderer.draw(matrices, CharacteristicsTitle, offLeft + 170, 15 + offTop, 0);
            this.textRenderer.draw(matrices, Waders, offLeft + 200, 25 + offTop, 0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "var. 1", offLeft + 160, 65 + offTop,0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "var. 2", offLeft + 200, 85 + offTop,0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "var. 3", offLeft + 240, 65 + offTop,0);
            this.textRenderer.draw(matrices, BiomesTitle, offLeft + 175, 125 + offTop, 0);
            this.textRenderer.draw(matrices, "- Plains", offLeft + 160, 140 + offTop, 0);

            this.itemRenderer.renderInGui(new ItemStack(InitItems.KILLDEERFEATHER, 1), offLeft + 205, 95 + offTop);

            int i = (this.width - this.bookImageWidth) / 2;
            int j = (this.height - this.bookImageHeight) / 2;
            KilldeerEntity entity = new KilldeerEntity(InitEntities.KILLDEER_ENTITY, MinecraftClient.getInstance().world);
            entity.setVariant(1);
            entity.setOnGround(true);
            KilldeerEntity entity2 = new KilldeerEntity(InitEntities.KILLDEER_ENTITY, MinecraftClient.getInstance().world);
            entity2.setVariant(2);
            entity2.setOnGround(true);
            KilldeerEntity entity3 = new KilldeerEntity(InitEntities.KILLDEER_ENTITY, MinecraftClient.getInstance().world);
            entity3.setVariant(3);
            entity3.setOnGround(true);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            InventoryScreen.drawEntity(offLeft + 175, 60 + offTop, 80, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity);
            InventoryScreen.drawEntity(offLeft + 215, 80 + offTop, 80, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity2);
            InventoryScreen.drawEntity(offLeft + 255, 60 + offTop, 80, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity3);
        }
        else if(currPage==5){
            this.textRenderer.draw(matrices, page5Title, offLeft + 40, 15 + offTop, 0);
            this.textRenderer.draw(matrices, page5Subtitle, offLeft + 40, 25 + offTop, 0);
            this.textRenderer.drawTrimmed(StringRenderable.plain(page5Text), offLeft + 13, 40 + offTop, 126, 0);
            this.textRenderer.draw(matrices, CharacteristicsTitle, offLeft + 170, 15 + offTop, 0);
            this.textRenderer.draw(matrices, GullsBoobies, offLeft + 180, 25 + offTop, 0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "var. 1", offLeft + 160, 65 + offTop,0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "var. 2", offLeft + 200, 85 + offTop,0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "var. 3", offLeft + 240, 65 + offTop,0);
            this.textRenderer.draw(matrices, BiomesTitle, offLeft + 175, 125 + offTop, 0);
            this.textRenderer.draw(matrices, "- Beach and Ocean", offLeft + 160, 140 + offTop, 0);

            this.itemRenderer.renderInGui(new ItemStack(InitItems.SABINESGULLFEATHER, 1), offLeft + 205, 95 + offTop);

            int i = (this.width - this.bookImageWidth) / 2;
            int j = (this.height - this.bookImageHeight) / 2;
            SabinesGullEntity entity = new SabinesGullEntity(InitEntities.SABINES_GULL_ENTITY, MinecraftClient.getInstance().world);
            entity.setVariant(1);
            entity.setOnGround(true);
            SabinesGullEntity entity2 = new SabinesGullEntity(InitEntities.SABINES_GULL_ENTITY, MinecraftClient.getInstance().world);
            entity2.setVariant(2);
            entity2.setOnGround(true);
            SabinesGullEntity entity3 = new SabinesGullEntity(InitEntities.SABINES_GULL_ENTITY, MinecraftClient.getInstance().world);
            entity3.setVariant(3);
            entity3.setOnGround(true);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            InventoryScreen.drawEntity(offLeft + 175, 65 + offTop, 60, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity);
            InventoryScreen.drawEntity(offLeft + 215, 85 + offTop, 60, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity2);
            InventoryScreen.drawEntity(offLeft + 255, 65 + offTop, 60, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity3);
        }
        else if(currPage==6){
            this.textRenderer.draw(matrices, page6Title, offLeft + 35, 15 + offTop, 0);
            this.textRenderer.draw(matrices, page6Subtitle, offLeft + 25, 25 + offTop, 0);
            this.textRenderer.drawTrimmed(StringRenderable.plain(page6Text), offLeft + 13, 40 + offTop, 126, 0);
            this.textRenderer.draw(matrices, CharacteristicsTitle, offLeft + 170, 15 + offTop, 0);
            this.textRenderer.draw(matrices, GullsBoobies, offLeft + 180, 25 + offTop, 0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "var. 1", offLeft + 200, 60 + offTop,0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "var. 2", offLeft + 160, 85 + offTop,0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "var. 3", offLeft + 200, 95 + offTop,0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "var. 4", offLeft + 240, 85 + offTop,0);
            this.textRenderer.draw(matrices, BiomesTitle, offLeft + 175, 125 + offTop, 0);
            this.textRenderer.draw(matrices, "- Beach and Ocean", offLeft + 160, 140 + offTop, 0);

            this.itemRenderer.renderInGui(new ItemStack(InitItems.BROWNBOOBYFEATHER, 1), offLeft + 205, 102 + offTop);

            int i = (this.width - this.bookImageWidth) / 2;
            int j = (this.height - this.bookImageHeight) / 2;
            BrownBoobyEntity entity = new BrownBoobyEntity(InitEntities.BROWN_BOOBY_ENTITY, MinecraftClient.getInstance().world);
            entity.setVariant(1);
            entity.setOnGround(true);
            BrownBoobyEntity entity2 = new BrownBoobyEntity(InitEntities.BROWN_BOOBY_ENTITY, MinecraftClient.getInstance().world);
            entity2.setVariant(2);
            entity2.setOnGround(true);
            BrownBoobyEntity entity3 = new BrownBoobyEntity(InitEntities.BROWN_BOOBY_ENTITY, MinecraftClient.getInstance().world);
            entity3.setVariant(3);
            entity3.setOnGround(true);
            BrownBoobyEntity entity4 = new BrownBoobyEntity(InitEntities.BROWN_BOOBY_ENTITY, MinecraftClient.getInstance().world);
            entity4.setVariant(4);
            entity4.setOnGround(true);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            InventoryScreen.drawEntity(offLeft + 175, 85 + offTop, 35, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity3);
            InventoryScreen.drawEntity(offLeft + 215, 95 + offTop, 35, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity2);
            InventoryScreen.drawEntity(offLeft + 255, 85 + offTop, 35, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity);
            InventoryScreen.drawEntity(offLeft + 215, 60 + offTop, 35, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity4);
        }
        else if(currPage==7){
            this.textRenderer.draw(matrices, page7Title, offLeft + 45, 15 + offTop, 0);
            this.textRenderer.draw(matrices, page7Subtitle, offLeft + 40, 25 + offTop, 0);
            this.textRenderer.drawTrimmed(StringRenderable.plain(page7Text), offLeft + 13, 40 + offTop, 126, 0);
            this.textRenderer.draw(matrices, CharacteristicsTitle, offLeft + 170, 15 + offTop, 0);
            this.textRenderer.draw(matrices, Auks, offLeft + 208, 25 + offTop, 0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "Summer", offLeft + 170, 80 + offTop, 0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "Winter", offLeft + 232, 80 + offTop, 0);
            this.textRenderer.draw(matrices, BiomesTitle, offLeft + 175, 125 + offTop, 0);
            this.textRenderer.draw(matrices, "- Beach and Ocean", offLeft + 160, 140 + offTop, 0);

            this.itemRenderer.renderInGui(new ItemStack(InitItems.RAZORBILLFEATHER, 1), offLeft + 207, 95 + offTop);

            int i = (this.width - this.bookImageWidth) / 2;
            int j = (this.height - this.bookImageHeight) / 2;
            RazorbillEntity entity = new RazorbillEntity(InitEntities.RAZORBILL_ENTITY, MinecraftClient.getInstance().world);
            entity.setGender(0);
            entity.setOnGround(true);
            RazorbillEntity entity2 = new RazorbillEntity(InitEntities.RAZORBILL_ENTITY, MinecraftClient.getInstance().world);
            entity2.setGender(1);
            entity2.biome = Biomes.SNOWY_BEACH;
            entity2.setOnGround(true);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            InventoryScreen.drawEntity(offLeft + 190, 75 + offTop, 60, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity);
            InventoryScreen.drawEntity(offLeft + 250, 75 + offTop, 60, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity2);
        }
        else if(currPage==8){
            this.textRenderer.draw(matrices, page8Title, offLeft + 30, 15 + offTop, 0);
            this.textRenderer.draw(matrices, page8Subtitle, offLeft + 34, 25 + offTop, 0);
            this.textRenderer.drawTrimmed(StringRenderable.plain(page8Text), offLeft + 13, 40 + offTop, 126, 0);
            this.textRenderer.draw(matrices, CharacteristicsTitle, offLeft + 170, 15 + offTop, 0);
            this.textRenderer.draw(matrices, Owls, offLeft + 208, 25 + offTop, 0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "var. 1", offLeft + 160, 75 + offTop,0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "var. 2", offLeft + 200, 85 + offTop,0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "var. 3", offLeft + 240, 75 + offTop,0);
            this.textRenderer.draw(matrices, BiomesTitle, offLeft + 175, 125 + offTop, 0);
            this.textRenderer.draw(matrices, "- Taiga", offLeft + 160, 140 + offTop, 0);

            this.itemRenderer.renderInGui(new ItemStack(InitItems.GREATGREYOWLFEATHER, 1), offLeft + 207, 95 + offTop);

            int i = (this.width - this.bookImageWidth) / 2;
            int j = (this.height - this.bookImageHeight) / 2;
            GreatGreyOwlEntity entity = new GreatGreyOwlEntity(InitEntities.GREAT_GREY_OWL_ENTITY, MinecraftClient.getInstance().world);
            entity.setVariant(1);
            entity.setOnGround(true);
            GreatGreyOwlEntity entity2 = new GreatGreyOwlEntity(InitEntities.GREAT_GREY_OWL_ENTITY, MinecraftClient.getInstance().world);
            entity2.setVariant(2);
            entity2.setOnGround(true);
            GreatGreyOwlEntity entity3 = new GreatGreyOwlEntity(InitEntities.GREAT_GREY_OWL_ENTITY, MinecraftClient.getInstance().world);
            entity3.setVariant(3);
            entity3.setOnGround(true);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            InventoryScreen.drawEntity(offLeft + 175, 70 + offTop, 55, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity3);
            InventoryScreen.drawEntity(offLeft + 215, 80 + offTop, 55, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity2);
            InventoryScreen.drawEntity(offLeft + 255, 70 + offTop, 55, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity);
        }
        else if(currPage==9){
            this.textRenderer.draw(matrices, page9Title, offLeft + 15, 15 + offTop, 0);
            this.textRenderer.draw(matrices, page9Subtitle, offLeft + 15, 25 + offTop, 0);
            this.textRenderer.drawTrimmed(StringRenderable.plain(page9Text), offLeft + 13, 40 + offTop, 126, 0);
            this.textRenderer.draw(matrices, CharacteristicsTitle, offLeft + 170, 15 + offTop, 0);
            this.textRenderer.draw(matrices, Nightjars, offLeft + 194, 25 + offTop, 0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "var. 1", offLeft + 160, 65 + offTop,0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "var. 2", offLeft + 200, 85 + offTop,0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "var. 3", offLeft + 240, 65 + offTop,0);
            this.textRenderer.draw(matrices, BiomesTitle, offLeft + 175, 125 + offTop, 0);
            this.textRenderer.draw(matrices, "- Savanna, Mesa", offLeft + 160, 140 + offTop, 0);

            this.itemRenderer.renderInGui(new ItemStack(InitItems.REDNECKEDNIGHTJARFEATHER, 1), offLeft + 205, 95 + offTop);

            int i = (this.width - this.bookImageWidth)/2;
            int j = (this.height - this.bookImageHeight)/2;
            RedNeckedNightjarEntity entity = new RedNeckedNightjarEntity(InitEntities.RED_NECKED_NIGHTJAR_ENTITY, MinecraftClient.getInstance().world);
            entity.setVariant(1);
            entity.setOnGround(true);
            RedNeckedNightjarEntity entity2 = new RedNeckedNightjarEntity(InitEntities.RED_NECKED_NIGHTJAR_ENTITY, MinecraftClient.getInstance().world);
            entity2.setVariant(2);
            entity2.setOnGround(true);
            RedNeckedNightjarEntity entity3 = new RedNeckedNightjarEntity(InitEntities.RED_NECKED_NIGHTJAR_ENTITY, MinecraftClient.getInstance().world);
            entity3.setVariant(3);
            entity3.setOnGround(true);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            InventoryScreen.drawEntity(offLeft + 175, 60 + offTop, 70, (float)(i + 51) - (mousePosX * 2), (float)(j + 75 - 50) - mousePosY, entity);
            InventoryScreen.drawEntity(offLeft + 215, 80 + offTop, 70, (float)(i + 51) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity2);
            InventoryScreen.drawEntity(offLeft + 255, 60 + offTop, 70, (float)(i + 51) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity3);
        }
        else if(currPage==10){
            this.textRenderer.draw(matrices, page10Title, offLeft + 13, 15 + offTop, 0);
            this.textRenderer.draw(matrices, page10Subtitle, offLeft + 30, 25 + offTop, 0);
            this.textRenderer.drawTrimmed( StringRenderable.plain(page10Text), offLeft + 13, 40 + offTop, 126, 0);
            this.textRenderer.draw(matrices, CharacteristicsTitle, offLeft + 170, 15 + offTop, 0);
            this.textRenderer.draw(matrices, Passerines, offLeft + 192, 25 + offTop, 0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "var. 1", offLeft + 160, 65 + offTop,0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "var. 2", offLeft + 200, 85 + offTop,0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "var. 3", offLeft + 240, 65 + offTop,0);
            this.textRenderer.draw(matrices, BiomesTitle, offLeft + 175, 125 + offTop, 0);
            this.textRenderer.draw(matrices, "- Plains, Forest", offLeft + 160, 140 + offTop, 0);

            this.itemRenderer.renderInGui(new ItemStack(InitItems.NORTHERNMOCKINGBIRDFEATHER, 1), offLeft + 205, 95 + offTop);

            int i = (this.width - this.bookImageWidth) / 2;
            int j = (this.height - this.bookImageHeight) / 2;
            NorthernMockingbirdEntity entity = new NorthernMockingbirdEntity(InitEntities.NORTHERN_MOCKINGBIRD_ENTITY, MinecraftClient.getInstance().world);
            entity.setVariant(1);
            entity.setOnGround(true);
            NorthernMockingbirdEntity entity2 = new NorthernMockingbirdEntity(InitEntities.NORTHERN_MOCKINGBIRD_ENTITY, MinecraftClient.getInstance().world);
            entity2.setVariant(2);
            entity2.setOnGround(true);
            NorthernMockingbirdEntity entity3 = new NorthernMockingbirdEntity(InitEntities.NORTHERN_MOCKINGBIRD_ENTITY, MinecraftClient.getInstance().world);
            entity3.setVariant(3);
            entity3.setOnGround(true);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            InventoryScreen.drawEntity(offLeft + 175, 60 + offTop, 90, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity);
            InventoryScreen.drawEntity(offLeft + 215, 80 + offTop, 90, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity2);
            InventoryScreen.drawEntity(offLeft + 255, 60 + offTop, 90, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity3);
        }
        else if(currPage==11){
            this.textRenderer.draw(matrices, page11Title, offLeft + 25, 15 + offTop, 0);
            this.textRenderer.draw(matrices, page11Subtitle, offLeft + 40, 25 + offTop, 0);
            this.textRenderer.drawTrimmed(StringRenderable.plain(page11Text), offLeft + 13, 40 + offTop, 126, 0);
            this.textRenderer.draw(matrices, CharacteristicsTitle, offLeft + 170, 15 + offTop, 0);
            this.textRenderer.draw(matrices, Passerines, offLeft + 192, 25 + offTop, 0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "Male", offLeft + 175, 80 + offTop, 0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "Female", offLeft + 232, 80 + offTop, 0);
            this.textRenderer.draw(matrices, BiomesTitle, offLeft + 175, 125 + offTop, 0);
            this.textRenderer.draw(matrices, "- Plains, oak forest", offLeft + 160, 140 + offTop, 0);

            this.itemRenderer.renderInGui(new ItemStack(InitItems.EASTERNBLUEBIRDFEATHER_MALE, 1), offLeft + 175, 95 + offTop);
            this.itemRenderer.renderInGui(new ItemStack(InitItems.EASTERNBLUEBIRDFEATHER_FEMALE, 1), offLeft + 240, 95 + offTop);

            int i = (this.width - this.bookImageWidth) / 2;
            int j = (this.height - this.bookImageHeight) / 2;
            EasternBluebirdEntity entity = new EasternBluebirdEntity(InitEntities.EASTERN_BLUEBIRD_ENTITY, MinecraftClient.getInstance().world);
            entity.setGender(0);
            entity.setOnGround(true);
            EasternBluebirdEntity entity2 = new EasternBluebirdEntity(InitEntities.EASTERN_BLUEBIRD_ENTITY, MinecraftClient.getInstance().world);
            entity2.setGender(1);
            entity2.setOnGround(true);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            InventoryScreen.drawEntity(offLeft + 185, 75 + offTop, 100, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity);
            InventoryScreen.drawEntity(offLeft + 250, 75 + offTop, 100, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity2);
        }
        else if(currPage==12){
            this.textRenderer.draw(matrices, page12Title, offLeft + 15, 15 + offTop, 0);
            this.textRenderer.draw(matrices, page12Subtitle, offLeft + 25, 25 + offTop, 0);
            this.textRenderer.drawTrimmed(StringRenderable.plain(page12Text), offLeft + 13, 40 + offTop, 126, 0);
            this.textRenderer.draw(matrices, CharacteristicsTitle, offLeft + 170, 15 + offTop, 0);
            this.textRenderer.draw(matrices, Passerines, offLeft + 192, 25 + offTop, 0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "Male", offLeft + 175, 80 + offTop, 0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "Female", offLeft + 232, 80 + offTop, 0);
            this.textRenderer.draw(matrices, BiomesTitle, offLeft + 175, 125 + offTop, 0);
            this.textRenderer.draw(matrices, "- Taiga", offLeft + 160, 140 + offTop, 0);

            this.itemRenderer.renderInGui(new ItemStack(InitItems.REDFLANCKEDBLUETAILFEATHER_MALE, 1), offLeft + 175, 95 + offTop);
            this.itemRenderer.renderInGui(new ItemStack(InitItems.REDFLANCKEDBLUETAILFEATHER_FEMALE, 1), offLeft + 240, 95 + offTop);

            int i = (this.width - this.bookImageWidth) / 2;
            int j = (this.height - this.bookImageHeight) / 2;
            RedFlankedBluetailEntity entity = new RedFlankedBluetailEntity(InitEntities.RED_FLANKED_BLUETAIL_ENTITY, MinecraftClient.getInstance().world);
            entity.setOnGround(true);
            entity.setGender(0);
            RedFlankedBluetailEntity entity2 = new RedFlankedBluetailEntity(InitEntities.RED_FLANKED_BLUETAIL_ENTITY, MinecraftClient.getInstance().world);
            entity2.setOnGround(true);
            entity2.setGender(1);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            InventoryScreen.drawEntity(offLeft + 185, 75 + offTop, 100, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity);
            InventoryScreen.drawEntity(offLeft + 250, 75 + offTop, 100, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity2);
        }
        else if(currPage==13){
            this.textRenderer.draw(matrices, page13Title, offLeft + 18, 15 + offTop, 0);
            this.textRenderer.draw(matrices, page13Subtitle, offLeft + 20, 25 + offTop, 0);
            this.textRenderer.drawTrimmed(StringRenderable.plain(page13Text), offLeft + 13, 40 + offTop, 126, 0);
            this.textRenderer.draw(matrices, CharacteristicsTitle, offLeft + 170, 15 + offTop, 0);
            this.textRenderer.draw(matrices, Passerines, offLeft + 192, 25 + offTop, 0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "Male", offLeft + 175, 80 + offTop, 0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "Female", offLeft + 232, 80 + offTop, 0);
            this.textRenderer.draw(matrices, BiomesTitle, offLeft + 175, 125 + offTop, 0);
            this.textRenderer.draw(matrices, "- Taiga, all forests", offLeft + 160, 140 + offTop, 0);

            this.itemRenderer.renderInGui(new ItemStack(InitItems.EURASIANBULLFINCHDFEATHER_MALE, 1), offLeft + 175, 95 + offTop);
            this.itemRenderer.renderInGui(new ItemStack(InitItems.EURASIANBULLFINCHDFEATHER_FEMALE, 1), offLeft + 240, 95 + offTop);

            int i = (this.width - this.bookImageWidth) / 2;
            int j = (this.height - this.bookImageHeight) / 2;
            EurasianBullfinchEntity entity = new EurasianBullfinchEntity(InitEntities.EURASIAN_BULLFINCH_ENTITY, MinecraftClient.getInstance().world);
            entity.setOnGround(true);
            entity.setGender(0);
            EurasianBullfinchEntity entity2 = new EurasianBullfinchEntity(InitEntities.EURASIAN_BULLFINCH_ENTITY, MinecraftClient.getInstance().world);
            entity2.setOnGround(true);
            entity2.setGender(1);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            InventoryScreen.drawEntity(offLeft + 185, 75 + offTop, 100, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity);
            InventoryScreen.drawEntity(offLeft + 250, 75 + offTop, 100, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity2);
        }
        else if(currPage==14){
            this.textRenderer.draw(matrices, page14Title1, offLeft + 28, 15 + offTop, 0);
            this.textRenderer.draw(matrices, page14Title2, offLeft + 25, 25 + offTop, 0);
            this.textRenderer.draw(matrices, page14Subtitle, offLeft + 18, 35 + offTop, 0);
            this.textRenderer.drawTrimmed(StringRenderable.plain(page14Text), offLeft + 13, 50 + offTop, 126, 0);
            this.textRenderer.draw(matrices, CharacteristicsTitle, offLeft + 170, 15 + offTop, 0);
            this.textRenderer.draw(matrices, Passerines, offLeft + 192, 25 + offTop, 0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "Male", offLeft + 175, 80 + offTop, 0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "Female", offLeft + 232, 80 + offTop, 0);
            this.textRenderer.draw(matrices, BiomesTitle, offLeft + 175, 125 + offTop, 0);
            this.textRenderer.draw(matrices, "- Jungle", offLeft + 160, 140 + offTop, 0);

            this.itemRenderer.renderInGui(new ItemStack(InitItems.KINGOFSAXONYFEATHER_MALE, 1), offLeft + 175, 95 + offTop);
            this.itemRenderer.renderInGui(new ItemStack(InitItems.KINGOFSAXONYFEATHER_FEMALE, 1), offLeft + 240, 95 + offTop);

            int i = (this.width - this.bookImageWidth) / 2;
            int j = (this.height - this.bookImageHeight) / 2;
            KingOfSaxonyEntity entity = new KingOfSaxonyEntity(InitEntities.KING_OF_SAXONY_ENTITY, MinecraftClient.getInstance().world);
            entity.setGender(0);
            entity.setOnGround(true);
            KingOfSaxonyEntity entity2 = new KingOfSaxonyEntity(InitEntities.KING_OF_SAXONY_ENTITY, MinecraftClient.getInstance().world);
            entity2.setGender(1);
            entity2.setOnGround(true);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            InventoryScreen.drawEntity(offLeft + 185, 75 + offTop, 80, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity);
            InventoryScreen.drawEntity(offLeft + 250, 75 + offTop, 80, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity2);
        }
        else if(currPage==15){
            this.textRenderer.draw(matrices, page15Title1, offLeft + 19, 10 + offTop, 0);
            this.textRenderer.draw(matrices, page15Title2, offLeft + 55, 20 + offTop, 0);
            this.textRenderer.draw(matrices, page15Subtitle, offLeft + 15, 30 + offTop, 0);
            this.textRenderer.drawTrimmed(StringRenderable.plain(page15Text), offLeft + 13, 45 + offTop, 126, 0);
            this.textRenderer.draw(matrices, CharacteristicsTitle, offLeft + 170, 15 + offTop, 0);
            this.textRenderer.draw(matrices, Coraciiformes, offLeft + 182, 25 + offTop, 0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "var. 1", offLeft + 160, 65 + offTop,0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "var. 2", offLeft + 200, 85 + offTop,0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "var. 3", offLeft + 240, 65 + offTop,0);
            this.textRenderer.draw(matrices, BiomesTitle, offLeft + 175, 125 + offTop, 0);
            this.textRenderer.draw(matrices, "- Jungle", offLeft + 160, 140 + offTop, 0);

            this.itemRenderer.renderInGui(new ItemStack(InitItems.MOTMOTFEATHER, 1), offLeft + 205, 95 + offTop);

            int i = (this.width - this.bookImageWidth) / 2;
            int j = (this.height - this.bookImageHeight) / 2;
            TurquoiseBrowedMotmotEntity entity = new TurquoiseBrowedMotmotEntity(InitEntities.TURQUOISE_BROWED_MOTMOT_ENTITY, MinecraftClient.getInstance().world);
            entity.setVariant(1);
            entity.setOnGround(true);
            TurquoiseBrowedMotmotEntity entity2 = new TurquoiseBrowedMotmotEntity(InitEntities.TURQUOISE_BROWED_MOTMOT_ENTITY, MinecraftClient.getInstance().world);
            entity2.setVariant(2);
            entity2.setOnGround(true);
            TurquoiseBrowedMotmotEntity entity3 = new TurquoiseBrowedMotmotEntity(InitEntities.TURQUOISE_BROWED_MOTMOT_ENTITY, MinecraftClient.getInstance().world);
            entity3.setVariant(3);
            entity3.setOnGround(true);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            InventoryScreen.drawEntity(offLeft + 175, 60 + offTop, 85, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity);
            InventoryScreen.drawEntity(offLeft + 215, 80 + offTop, 85, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity2);
            InventoryScreen.drawEntity(offLeft + 255, 60 + offTop, 85, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity3);
        }
        else if(currPage==15){
            this.textRenderer.draw(matrices, page16Title, 51 + offLeft, 15 + offTop, 0);
            this.textRenderer.draw(matrices, page16Subtitle, offLeft + 18, 25 + offTop, 0);
            this.textRenderer.drawTrimmed(StringRenderable.plain(page16Text), offLeft + 13, 40 + offTop, 126, 0);
            this.textRenderer.draw(matrices, CharacteristicsTitle, offLeft + 170, 15 + offTop, 0);
            this.textRenderer.draw(matrices, Opisthocomiformes, offLeft + 171, 25 + offTop, 0);
            this.textRenderer.draw(matrices, Formatting.ITALIC + "Single variant", offLeft + 181, 80 + offTop, 0);
            this.textRenderer.draw(matrices, BiomesTitle, offLeft + 175, 125 + offTop, 0);
            this.textRenderer.draw(matrices, "- Jungle, Swamp", offLeft + 160, 140 + offTop, 0);

            this.itemRenderer.renderInGui(new ItemStack(InitItems.HOATZINFEATHER, 1), offLeft + 207, 95 + offTop);

            int i = (this.width - this.bookImageWidth) / 2;
            int j = (this.height - this.bookImageHeight) / 2;
            HoatzinEntity entity = new HoatzinEntity(InitEntities.HOATZIN_ENTITY, MinecraftClient.getInstance().world);
            entity.setOnGround(true);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            InventoryScreen.drawEntity(offLeft + 217, 75 + offTop, 55, (float)(i) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity);
        }

        super.render(matrices, mouseX, mouseY, delta);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
