package com.izuanqian;

import com.izuanqian.response.ApiResponse;
import com.izuanqian.response.Ok;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * Created by root on 17-3-8.
 */
@RestController
@Api(tags = "url", description = "convert url to the short one.")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @ApiOperation(value = "get the short url",
            notes = "",
            response = UrlConvertVO.class)
    @GetMapping
    public ApiResponse convert(
            @ModelAttribute UrlConvertPO convert) throws UnsupportedEncodingException {
        UrlConvert urlConvert = urlService.get(convert.getUrl());

        return new Ok(
                UrlConvertVO
                        .builder()
                        .url(urlConvert.getUrl())
                        .originalUrl(urlConvert.getOriginalUrl())
                        .build());
    }
}
