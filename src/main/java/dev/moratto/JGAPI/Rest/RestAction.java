package dev.moratto.JGAPI.Rest;

import java.util.concurrent.TimeUnit;

public class RestAction<T> {
    private int sequenceNumber;
    private Request request;
    private String result = null;
    public RestAction(int sequenceNumber, Request request) {
        this.request = request;
        this.sequenceNumber = sequenceNumber;
    }

    public int getSequenceNumber() {
        return this.sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public Request getRequest() {
        return this.request;
    }

    private class RestActionResponse<T> {}

    public RestAction<T> queue() {}

    public RestAction<T> submit() {}

    public RestActionResponse<T> complete() {}

    public RestActionResponse<T> completeAfter(TimeUnit unit, int delay) {}
}
