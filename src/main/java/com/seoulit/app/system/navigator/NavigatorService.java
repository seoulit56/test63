package com.seoulit.app.system.navigator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * MenuService
 */
@RestController
public class NavigatorService {


    @Resource
    private NavigatorRepositiry navigatorRepositiry;

    @Resource
    private NavigatorDao navigatorDao;

    public List<Map<String, Object>> mainNavList() {


        List<Map<String, Object>> mainNavList = navigatorDao.mainNavList();

        return makeTreeData(mainNavList, "");
    }

    public List<Map<String, Object>> makeTreeData(List<Map<String, Object>> dataList, String rootVal) {
    
        List<Map<String, Object>> result = new ArrayList<>();

        for (Map<String, Object> data : dataList) {

            String parent = null;
            if (data.get("PARENT") == null) parent = "";
            else parent = data.get("PARENT").toString();   
            
            String navigatorId = data.get("NAVIGATOR_ID").toString();
            String navigatorName = data.get("NAVIGATOR_NAME").toString();
            String url = data.get("URL").toString();
            String icon = data.get("CLASS_TYPE").toString();

            if (parent.equals(rootVal)) {

                Map<String, Object> tempData = new HashMap<>();

                tempData.put("navigatorId", navigatorId);
                tempData.put("name", navigatorName);
                tempData.put("url", url);
                tempData.put("icon", icon);

                List<Map<String, Object>> children = makeTreeData(dataList, navigatorId);

                if (children.size() > 0) {
                    tempData.put("children", children);
                }

                result.add(tempData);

            }

        }

        return result;
    }

    
}