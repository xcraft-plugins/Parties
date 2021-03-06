package com.alessiodp.parties.common.commands.utils;

import com.alessiodp.core.common.commands.utils.ADPPermission;

public enum PartiesPermission implements ADPPermission {
	
	// User
	ACCEPT		("parties.user.accept"),
	CHAT		("parties.user.chat"),
	CHAT_COLOR	("parties.user.chat.color"),
	COLOR		("parties.user.color"),
	CREATE		("parties.user.create"),
	DENY		("parties.user.deny"),
	DESC		("parties.user.desc"),
	FOLLOW		("parties.user.follow"),
	HELP		("parties.user.help"),
	IGNORE		("parties.user.ignore"),
	INFO		("parties.user.info"),
	INFO_OTHERS	("parties.user.info.others"),
	INVITE		("parties.user.invite"),
	JOIN		("parties.user.join"),
	JOINDEFAULT	("parties.user.joindefault"),
	KICK		("parties.user.kick"),
	LEAVE		("parties.user.leave"),
	LIST		("parties.user.list"),
	MOTD		("parties.user.motd"),
	MUTE		("parties.user.mute"),
	PASSWORD	("parties.user.password"),
	PLAYER		("parties.user.player"),
	RANK		("parties.user.rank"),
	RENAME		("parties.user.rename"),
	SENDMESSAGE	("parties.user.sendmessage"),
	// Bukkit
	CLAIM		("parties.user.claim"),
	HOME		("parties.user.home"),
	PROTECTION	("parties.user.protection"),
	SETHOME		("parties.user.sethome"),
	TELEPORT	("parties.user.teleport"),
	
	// Admin
	ADMIN_ALERTS				("parties.admin.alerts"),
	ADMIN_CREATE_FIXED			("parties.admin.create.fixed"),
	ADMIN_DELETE				("parties.admin.delete"),
	ADMIN_DELETE_SILENT			("parties.admin.delete.silent"),
	ADMIN_JOIN_BYPASS			("parties.admin.join.bypass"),
	ADMIN_JOINDEFAULT_BYPASS	("parties.admin.joindefault.bypass"),
	ADMIN_KICK_OTHERS			("parties.admin.kick.others"),
	ADMIN_RANK_BYPASS			("parties.admin.rank.bypass"),
	ADMIN_RANK_OTHERS			("parties.admin.rank.others"),
	ADMIN_RELOAD				("parties.admin.reload"),
	ADMIN_RENAME_OTHERS			("parties.admin.rename.others"),
	ADMIN_SPY					("parties.admin.spy"),
	ADMIN_VERSION				("parties.admin.version"),
	
	// Bukkit
	ADMIN_HOME_OTHERS			("parties.admin.home.others"),
	ADMIN_PROTECTION_BYPASS		("parties.admin.protection.bypass"),
	ADMIN_VAULTBYPASS			("parties.admin.vaultbypass"),
	
	
	PRIVATE_CLAIM("party.claim"),
	PRIVATE_HOME("party.home"),
	PRIVATE_INVITE("party.invite"),
	PRIVATE_KICK("party.kick"),
	PRIVATE_SENDMESSAGE("party.sendmessage"),
	PRIVATE_SENDMESSAGE_COLOR("party.sendmessage.color"),
	
	PRIVATE_EDIT_HOME("party.edit.home"),
	PRIVATE_EDIT_DESC("party.edit.desc"),
	PRIVATE_EDIT_FOLLOW("party.edit.follow"),
	PRIVATE_EDIT_MOTD("party.edit.motd"),
	PRIVATE_EDIT_COLOR("party.edit.color"),
	PRIVATE_EDIT_PASSWORD("party.edit.password"),
	PRIVATE_EDIT_PROTECTION("party.edit.protection"),
	
	PRIVATE_ADMIN_RANK("party.admin.rank"),
	PRIVATE_ADMIN_RENAME("party.admin.rename"),
	PRIVATE_ADMIN_TELEPORT("party.admin.teleport"),
	
	PRIVATE_WARNONDAMAGE("party.warnondamage"),
	PRIVATE_AUTOCOMMAND("party.autocommand"),
	PRIVATE_BYPASSCOOLDOWN("party.bypasscooldown");
	
	private final String perm;
	PartiesPermission(String t) {
		perm = t;
	}
	
	@Override
	public String toString() {
		return perm;
	}
}
