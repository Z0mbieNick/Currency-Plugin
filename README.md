The Code is found in the master branch

the right version to download is: minecraft-currency-plugin-1.0.0.jar
it is found in the target folder


Minecraft Currency Plugin
A Minecraft plugin designed for managing an in-game currency system and creating villager-based shops. Players can trade items for money, transfer money to each other, and create shops with limited stock, making trading more realistic.

Features
Currency System:

Each player has an in-game balance.
Players can send money to each other using simple commands.
Admins can set starting balances for all players.
Villager Shops:

Players can create shops where a villager acts as the trader.
Shop owners can stock items and set prices.
Items are removed from stock when sold.
Shops can only be removed when their inventory is empty.
Admin Controls:

Admins can set the starting balance for players.
Fully configurable via commands or config files.
Commands
Command	Description	Permission
/createshop <shopName>	Creates a villager shop with a unique name.	All players
/removeshop <shopName>	Removes the player's shop (only if inventory is empty).	All players
/pay <player> <amount>	Transfers money to another player.	All players
/balance	Displays the player's current balance.	All players
/setstartingcapital <amount>	Sets the starting balance for all players.	minecraftcurrencyplugin.setstartingcapital
Permissions
Permission	Description
minecraftcurrencyplugin.setstartingcapital	Allows the use of /setstartingcapital. Default: OP
Setup and Installation
Download the Plugin:

Build the plugin using Maven or download the precompiled JAR file.
Add the Plugin to Your Server:

Copy the JAR file to your server's plugins folder.
Restart your server.
Verify Installation:

Run /plugins in-game or in the server console.
You should see MinecraftCurrencyPlugin in the list of active plugins.
Start Using the Plugin:

Use the commands to create shops, trade items, and manage money.
How It Works
1. Villager Shops
Create a Shop:

Use /createshop <shopName> to spawn a villager and create a shop.
Stock the shop by right-clicking the villager and adding items to the inventory.
Buy Items:

Players interact with the villager to buy items.
Items are removed from the shop's inventory after purchase.
Money is deducted from the buyer and transferred to the shop owner.
Remove a Shop:

Use /removeshop <shopName> to delete the shop.
A shop can only be removed if its inventory is empty.
2. Currency System
Send Money:

Use /pay <player> <amount> to transfer money to another player.
The sender’s balance decreases, and the recipient’s balance increases.
Check Balance:

Use /balance to view your current balance.
Set Starting Capital (Admin):

Admins can use /setstartingcapital <amount> to set the starting balance for all players.
