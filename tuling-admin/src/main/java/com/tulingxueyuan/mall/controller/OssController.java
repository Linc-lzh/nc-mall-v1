package com.tulingxueyuan.mall.controller;

import com.tulingxueyuan.mall.common.api.CommonResult;
import com.tulingxueyuan.mall.dto.OssPolicyResult;
import com.tulingxueyuan.mall.service.impl.OssServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Oss相关操作接口
 * @author Linc
 * @since 2024-12-30
 */
@Controller
@Api(tags = "OssController", description = "Oss管理")
@RequestMapping("/aliyun/oss")
public class OssController {
    @Autowired
    private OssServiceImpl ossService;

    @ApiOperation(value = "oss上传签名生成")
    @RequestMapping(value = "/policy", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<OssPolicyResult> policy() {
        OssPolicyResult result = ossService.policy();
        return CommonResult.success(result);
    }

//    @Value("${upload.product.images}")
//    private String uploadBasePath;
//
//    /**
//     *
//     * @param multiFile
//     * @param req
//     * @return
//     * @throws IOException
//     */
//    @RequestMapping(value = "/upload",method = RequestMethod.POST)
//    @CrossOrigin
//    @ResponseBody
//    public CommonResult<String> importData(@RequestParam("image-file") MultipartFile multiFile, HttpServletRequest req) throws IOException {
//        SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
//        String format = sdf.format(new Date());
//        /*
//         * 按日期分类
//         */
//        String realPath = uploadBasePath + format;
//        File folder = new File(realPath);
//        if (!folder.exists()) {
//            folder.mkdirs();
//        }
//
//        String oldName = multiFile.getOriginalFilename();
//        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
//
//        multiFile.transferTo(new File(folder,newName));
//        //String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/upload" + format + newName;
//        String httpBasePath = "/upload/product/images" + format + newName;
//
//        return CommonResult.success(httpBasePath);
//    }


}
