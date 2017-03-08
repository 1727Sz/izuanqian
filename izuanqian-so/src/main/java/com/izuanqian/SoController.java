package com.izuanqian;

import com.izuanqian.response.ApiResponse;
import com.izuanqian.response.Ok;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by root on 17-3-8.
 */
@RestController
@Api(tags = "so", description = "convert url to the short one.")
public class SoController {

    public ApiResponse convert(@ModelAttribute UrlConvertPO convert){
        return new Ok();
    }
}
