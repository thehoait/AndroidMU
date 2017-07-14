package com.example.hoaht.androidmu.api.response;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import lombok.Getter;

/**
 * DataResponse.
 *
 * @author HoaHT
 */
@Getter
@Root(name = "li", strict = false)
public class DataResponse {
//    @Element
//    private Channel channel;
    @Attribute(name = "data-id", required = false)
    private String className;

    public class Channel {
        @Element(name = "language", required = false)
        private String title;
    }
}
