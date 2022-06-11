package dev.JGAPI.JG_API.Entities.ListItems;

import java.time.Instant;

public class ListItemSummary {
    private String id;
    private String serverId;
    private String channelId;
    private String message;
    private Instant createdAt;
    private String createdBy;
    private String createdByWebhookId;
    private Instant updatedAt;
    private String updatedBy;
    private String parentListItemId;
    private Instant completedAt;
    private String completedby;
    private ListItemNote note;
}
