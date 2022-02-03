package com.mhi.zgl010.models;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("PMD.UnusedPrivateField")
public class CountResponse
{
    @JsonProperty("result")
    private final String count;

    public CountResponse( final int count ) {
        this.count = Integer.toString(count);
    }
}
