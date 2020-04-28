package com.alessiodp.parties.common.commands.sub;

import com.alessiodp.core.common.ADPPlugin;
import com.alessiodp.core.common.commands.utils.ADPMainCommand;
import com.alessiodp.core.common.commands.utils.CommandData;
import com.alessiodp.core.common.user.User;
import com.alessiodp.parties.common.PartiesPlugin;
import com.alessiodp.parties.common.commands.utils.PartiesCommandData;
import com.alessiodp.parties.common.commands.utils.PartiesPermission;
import com.alessiodp.parties.common.commands.utils.PartiesSubCommand;
import com.alessiodp.parties.common.configuration.PartiesConstants;
import com.alessiodp.parties.common.configuration.data.Messages;
import com.alessiodp.parties.common.parties.objects.PartyImpl;
import com.alessiodp.parties.common.players.objects.PartyPlayerImpl;
import lombok.Getter;

public class CommandPlayer extends PartiesSubCommand {
    @Getter
    private final boolean executableByConsole = true;

    public CommandPlayer(ADPPlugin plugin, ADPMainCommand mainCommand) {
        super(plugin, mainCommand);
    }

    @Override
    public boolean preRequisites(CommandData commandData) {
        User sender = commandData.getSender();
        if (sender.isPlayer()) {
            PartyPlayerImpl partyPlayer = ((PartiesPlugin) plugin).getPlayerManager().getPlayer(sender.getUUID());

            // Checks for command prerequisites
            if (!sender.hasPermission(PartiesPermission.PLAYER.toString())) {
                sendNoPermissionMessage(partyPlayer, PartiesPermission.PLAYER);
                return false;
            }

            PartyImpl party = null;
            if (commandData.getArgs().length == 1) {
                party = ((PartiesPlugin) plugin).getPartyManager().getPartyOfPlayer(partyPlayer);
                if (party == null) {
                    sendMessage(sender, partyPlayer, Messages.PARTIES_COMMON_NOTINPARTY);
                    return false;
                }
            }

            ((PartiesCommandData) commandData).setPartyPlayer(partyPlayer);
            ((PartiesCommandData) commandData).setParty(party);
        } else {
            if (commandData.getArgs().length == 1) {
                sendMessage(sender, null, Messages.PARTIES_COMMON_PARTYNOTFOUND);
                return false;
            }
        }

        commandData.addPermission(PartiesPermission.PLAYER);
        return true;
    }

    @Override
    public void onCommand(CommandData commandData) {
        User sender = commandData.getSender();
        PartyPlayerImpl partyPlayer = ((PartiesCommandData) commandData).getPartyPlayer();

        // Command handling
        if (partyPlayer == null && commandData.getArgs().length > 1) {
            if (!commandData.havePermission(PartiesPermission.PLAYER)) {
                sendNoPermissionMessage(partyPlayer, PartiesPermission.PLAYER);
                return;
            }
        }

        if (partyPlayer == null) {
            sendMessage(sender, partyPlayer, Messages.PARTIES_COMMON_PARTYNOTFOUND
                                                 .replace("%party%", commandData.getArgs()[1]));
            return;
        }

        // Command starts
        sendMessage(sender, partyPlayer, partyPlayer.getPartyName());
    }

}
