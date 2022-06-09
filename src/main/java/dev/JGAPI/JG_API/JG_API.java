package dev.JGAPI.JG_API;

import dev.JGAPI.JG_API.Exceptions.ClientBuildException;
import dev.JGAPI.JG_API.Websocket.WebSocketManager;
import dev.JGAPI.JG_API.Rest.RestClient;
import dev.JGAPI.JG_API.Entities.Members.User;

public class JG_API extends Thread {
    private String parentServerId;
    private String clientToken;
    private String clientId;
    private User clientUser;

    private WebSocketManager webSocketManager;
    private RestClient restClient;
    private boolean running = true;

    private JG_API(ClientBuilder clientBuilder) {
        this.parentServerId = clientBuilder.parentServerId;
        this.clientToken = clientBuilder.clientToken;
        this.clientId = clientBuilder.clientId;
    }

    public void login() {
        webSocketManager = new WebSocketManager(this.clientToken, this);
        webSocketManager.connect();
    }

    @Override
    public void run() {
        // We want to send a heartbeat every so often
        while (this.running) {
            // keep alive
            // TODO Need to send a heartbeat every so often
        }
    }

    public static class ClientBuilder {
        private String parentServerId;
        private String clientToken;
        @Deprecated
        private String clientId;

        /**
         * Build the Client
         */
        public ClientBuilder() {}

        /**
         * Set the Client's Token.
         *
         * @param clientToken The client's token.
         * @return Returns the current instance of the Client Builder.
         */
        public ClientBuilder setToken(String clientToken) {
            this.clientToken = clientToken;

            return this;
        }

        /**
         * Set the Client's ID.
         *
         * @param clientId The client's ID.
         * @return Returns the current instance of the Client Builder.
         * @implNote This will be deprecated once Guilded API payloads the ID of the Client that is logged in.
         */
        @Deprecated
        public ClientBuilder setClientId(String clientId) {
            this.clientId = clientId;

            return this;
        }

        public ClientBuilder setParentServerId(String serverId) {
            this.parentServerId = serverId;

            return this;
        }

        /**
         * Validates the Client Object.
         * TODO: Remove requirement for ClientID.
         * REVIEW: Is ServerID needed?
         *
         * @param client @{link Client} object.
         * @throws ClientBuildException If there was a missing property from the required props.
         */
        private void validateClientObject(ClientBuilder client) throws ClientBuildException {
            if (client.clientToken == null || client.clientToken.isBlank())
                throw new ClientBuildException("A Client Token was not provided to the Client Builder.");
            if (client.parentServerId == null || client.parentServerId.isBlank())
                throw new ClientBuildException("A Server ID was not provided to the Client Builder.");
        }

        /**
         * Builds the Client.
         *
         * @return {link Client} object.
         * @throws ClientBuildException If there was a missing property from the required props.
         */
        public JG_API build() throws ClientBuildException {
            validateClientObject(this);

            return new JG_API(this);
        }


    }
}