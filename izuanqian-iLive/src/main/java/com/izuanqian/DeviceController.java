package com.izuanqian;

import com.izuanqian.apidoc.version.V440;
import com.izuanqian.response.ApiResponse;
import com.izuanqian.response.Fail;
import com.izuanqian.response.Ok;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * Created by root on 17-3-5.
 */


@RestController
@RequestMapping("/device")
@Api(tags = "device", description = "log device information.")
public class DeviceController {

    @V440
    @ApiOperation(
            value = "update device info",
            notes = "update device info, eg, code of device, or push code",
            response = Ok.class)
    @PostMapping
    public ApiResponse updateDeviceCode(
            @RequestBody DeviceUpdatePo device) {
        return new Ok(device);
    }

    @V440
    @ApiOperation(
            value = "locate",
            notes = "notes of locate function.",
            response = User.class)
    @PostMapping("/locate")
    public ApiResponse locate(
            @ApiParam("lng") @RequestHeader("Location-lng") String lng,
            @ApiParam("lat") @RequestHeader("Location-lat") String lat) {
        System.out.println(lng + " / " + lat);
        if ("1".equals(lng)) {
            return new Fail(201703051, "hah, this is a demo of fail response.");
        }
        return new Ok(Arrays.asList(new User() {{
            setAge(0);
            getFriends().add(new User() {{
                setName("sanlion.do");
            }});
            setLocate(new Address(){{
                this.setAddress("suzhou, ");
            }});
        }}));
    }
}
