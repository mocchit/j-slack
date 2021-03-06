package io.mocchit.jslack.api.method;

import io.mocchit.jslack.api.ApiUtil;
import io.mocchit.jslack.api.BaseAPI;
import io.mocchit.jslack.api.Result;

import java.util.Map;

public interface Channels extends BaseAPI {
	/**
	 * Archives a channel.
	 * 
	 * @param channel
	 *            Channel to archive
	 * @return
	 */
	default Result archiveChannel(String channel) {
		return send("channels.archive", getTokenParam() + "&channel=" + channel);
	}

	/**
	 * Creates a channel.
	 * 
	 * @param name
	 *            Name of channel to create
	 * @return
	 */
	default Result createChannel(String name) {
		return send("channels.create", getTokenParam() + "&name=" + name);
	}

	/**
	 * Fetches history of messages and events from a channel.
	 * 
	 * @param channel
	 *            Channel to fetch history for.
	 * @param optionals
	 *            https://api.slack.com/methods/channels.history
	 * @return
	 */
	default Result fetchChannelHistory(String channel, Map<String, String> optionals) {
		StringBuilder builder = new StringBuilder(getTokenParam());
		builder.append("&channel=");
		builder.append(channel);
		builder.append(ApiUtil.toParam(optionals));
		return send("channels.history", builder.toString());
	}

	/**
	 * Fetches history of messages and events from a channel.
	 * 
	 * @param channel
	 *            Channel to fetch history for.
	 * @return
	 */
	default Result fetchChannelHistory(String channel) {
		return fetchChannelHistory(channel, null);
	}

	/**
	 * Gets information about a channel.
	 * 
	 * @param channel
	 *            Channel to get info on
	 * @return
	 */
	default Result fetchChannelInfo(String channel) {
		return send("channels.info", getTokenParam() + "&channel=" + channel);
	}

	/**
	 * Invites a user to a channel.
	 * 
	 * @param channel
	 *            Channel to invite user to.
	 * @param user
	 *            User to invite to channel.
	 * @return
	 */
	default Result inviteToChannel(String channel, String user) {
		return send("channels.invite", getTokenParam() + "&channel=" + channel
				+ "&user=" + user);
	}

	/**
	 * Joins a channel, creating it if needed.
	 * 
	 * @param name
	 *            Name of channel to join
	 * @return
	 */
	default Result joinChannel(String name) {
		return send("channels.join", getTokenParam() + "&name=" + name);
	}

	/**
	 * Removes a user from a channel.
	 * 
	 * @param channel
	 *            Channel to remove user from.
	 * @param name
	 *            User to remove from channel.
	 * @return
	 */
	default Result kickChannelUser(String channel, String name) {
		return send("channels.kick", getTokenParam() + "&channel=" + channel
				+ "&name=" + name);
	}

	/**
	 * Leaves a channel.
	 * 
	 * @param channel
	 *            Channel to leave
	 * @return
	 */
	default Result leaveChannel(String channel) {
		return send("channels.leave", getTokenParam() + "&channel=" + channel);
	}

	/**
	 * Lists all channels in a Slack team.
	 * 
	 * @param channel
	 * @param optionals
	 * @return
	 */
	default Result fetchChannelList(Map<String, String> optionals) {
		StringBuilder builder = new StringBuilder(getTokenParam());
		builder.append(ApiUtil.toParam(optionals));
		return send("channels.list", builder.toString());
	}

	/**
	 * Lists all channels in a Slack team.
	 * 
	 * @return
	 */
	default Result fetchChannelList() {
		return fetchChannelList(null);
	}

	/**
	 * Sets the read cursor in a channel.
	 * 
	 * @param channel
	 *            Channel to set reading cursor in.
	 * @param ts
	 *            Timestamp of the most recently seen message.
	 * @return
	 */
	default Result markChannel(String channel, String ts) {
		return send("channels.mark", getTokenParam() + "&channel=" + channel
				+ "&ts=" + ts);
	}

	/**
	 * Renames a channel.
	 * 
	 * @param channel
	 *            Channel to rename
	 * @param name
	 *            New name for channel.
	 * @return
	 */
	default Result renameChannel(String channel, String name) {
		return send("channels.rename", getTokenParam() + "&channel=" + channel
				+ "&name=" + name);
	}

	/**
	 * Sets the purpose for a channel.
	 * 
	 * @param channel
	 *            Channel to set the purpose of
	 * @param purpose
	 *            The new purpose
	 * @return
	 */
	default Result setChannelPurpose(String channel, String purpose) {
		return send("channels.setPurpose", getTokenParam() + "&channel="
				+ channel + "&purpose=" + purpose);
	}

	/**
	 * Sets the topic for a channel.
	 * 
	 * @param channel
	 *            Channel to set the topic of
	 * @param topic
	 *            The new topic
	 * @return
	 */
	default Result setChannelTopic(String channel, String topic) {
		return send("channels.setTopic", getTokenParam() + "&channel="
				+ channel + "&topic=" + topic);
	}

	/**
	 * Unarchives a channel.
	 * 
	 * @param channel
	 *            Channel to unarchive
	 * @return
	 */
	default Result unarchiveChannel(String channel) {
		return send("channels.unarchive", getTokenParam() + "&channel="
				+ channel);
	}
}
